package apiactions;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static groovy.json.JsonOutput.toJson;

public class APIActions
{
    public Response apiCreateUser(String name, String email, String pass)
    {
        String path = "auth/register";

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                    }
                };

        JSONObject bodyParams = new JSONObject();
        bodyParams.put("name", name);
        bodyParams.put("email", email);
        bodyParams.put("password", pass);

        Response response = APIMethods.postMethod(path, headerParams, bodyParams);
        return response;
    }

    public Response apiLoginUser(String email, String pass)
    {
        String path = "auth/authenticate";

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                    }
                };

        JSONObject bodyParams = new JSONObject();
        bodyParams.put("email", email);
        bodyParams.put("password", pass);

        Response response = APIMethods.postMethod(path, headerParams, bodyParams);
        return response;
    }

    public Response apiCreateProject(String token, String id)
    {
        String path = "projects";

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Authorization", "Bearer " + token);
                    }
                };

        JSONObject tasks = new JSONObject();
        tasks.put("name", "Task one");
        tasks.put("assignedTo", id);

        JSONArray tasksArray = new JSONArray();
        tasksArray.put(tasks);

        JSONObject bodyParams = new JSONObject();
        bodyParams.put("title", "Project Test Title");
        bodyParams.put("description", "Project Test Description");
        bodyParams.put("tasks",tasksArray);

        Response response = APIMethods.postMethod(path, headerParams, bodyParams);
        return response;
    }
    public Response apiGetAllProjects(String token, String id) {
        String path = "projects";

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Authorization", "Bearer " + token);
                    }
                };
        Response response = APIMethods.getMethod(path, headerParams);
        return response;
    }

    public Response apiGetProjectById(String token, String projectId) {
        String path = "projects/" + projectId;

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Authorization", "Bearer " + token);
                    }
                };
        Response response = APIMethods.getMethod(path, headerParams);
        return response;
    }

    public Response apiUpdateProject(String token, String id, String projectId) {
        String path = "projects/" + projectId;

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Authorization", "Bearer " + token);
                    }
                };

        JSONObject tasks = new JSONObject();
        tasks.put("name", "Task two");
        tasks.put("assignedTo", id);

        JSONArray tasksArray = new JSONArray();
        tasksArray.put(tasks);

        JSONObject bodyParams = new JSONObject();
        bodyParams.put("title", "Project Test Title 2");
        bodyParams.put("description", "Project Test Description 2");
        bodyParams.put("tasks",tasksArray);

        Response response = APIMethods.putMethod(path, headerParams, bodyParams);
        return response;
    }

    public Response apiDeleteProject(String token, String id, String projectId) {
        String path = "projects/" + projectId;

        Map<String, String> headerParams =
                new HashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Authorization", "Bearer " + token);
                    }
                };

        Response response = APIMethods.deleteMethod(path, headerParams);
        return response;
    }
}
