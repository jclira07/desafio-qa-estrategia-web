package steps;

import apiactions.APIActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import junit.framework.Assert;
import com.github.javafaker.Faker;

import java.util.Locale;

public class APIAutenticationSteps
{
    APIActions apiActions = new APIActions();
    Faker faker = new Faker(new Locale("pt-BR"));
    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    static String bearerToken;
    static String userID;
    static String projectId;
    private Response responseBody;

    @Dado("que crio o usuário")
    public void queCrioOUsuario()
    {
        responseBody = apiActions.apiCreateUser(name, email, password);
        bearerToken = responseBody.getBody().path("token");
        userID = responseBody.getBody().path("user._id");
        Assert.assertEquals(200, responseBody.statusCode());
    }

    @Então("faço o login")
    public void facoOLogin()
    {
        responseBody = apiActions.apiLoginUser(email, password);
        if (bearerToken == null && userID == null)
        {
            bearerToken = responseBody.getBody().path("token");
            userID = responseBody.getBody().path("user._id");
        }
        Assert.assertEquals(200, responseBody.statusCode());
    }



    @Dado("que consulto todos os projetos")
    public void consultoTodosOsProjetos()
    {
        if (bearerToken == null && userID == null)
        {
            bearerToken = apiActions.apiLoginUser(email, password).getBody().path("token");
            userID = apiActions.apiLoginUser(email, password).getBody().path("user._id");
        }

        responseBody = apiActions.apiGetAllProjects(bearerToken, userID);
        Assert.assertEquals(200, responseBody.statusCode());
    }

    @Então("faço um CRUD de um projeto")
    public void queCrioUmProjeto()
    {
        if (bearerToken == null && userID == null)
        {
            bearerToken = apiActions.apiLoginUser(email, password).getBody().path("token");
            userID = apiActions.apiLoginUser(email, password).getBody().path("user._id");
        }

        responseBody = apiActions.apiCreateProject(bearerToken, userID);
        Assert.assertEquals(200, responseBody.statusCode());

        projectId = responseBody.getBody().path("project._id");

        responseBody = apiActions.apiGetProjectById(bearerToken, projectId);
        Assert.assertEquals(200, responseBody.statusCode());

        responseBody = apiActions.apiUpdateProject(bearerToken, userID, projectId);
        Assert.assertEquals(200, responseBody.statusCode());

        responseBody = apiActions.apiDeleteProject(bearerToken, userID, projectId);
        Assert.assertEquals(200, responseBody.statusCode());
    }
}
