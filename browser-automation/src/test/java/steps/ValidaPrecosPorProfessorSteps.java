package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageactions.ValidaPrecoPageActions;

public class ValidaPrecosPorProfessorSteps
{
    ValidaPrecoPageActions pageActions;

    public ValidaPrecosPorProfessorSteps()
    {
        this.pageActions = new ValidaPrecoPageActions(Hooks.driver, new WebDriverWait(Hooks.driver, 20));
    }

    @Dado ("que nego o popup de notificações")
    public void queNegoOPopupDeNotificacoes() throws Exception
    {
        pageActions.denyNotificationPopup();
    }

    @E("que abro o menu Por Professor")
    public void queAbroOMenuPorProfessor()
    {
        pageActions.openPorProfessor();
    }

    @E("que eu filtro por {string}")
    public void queAbroOMenuPorProfessor(String professor) throws Exception
    {
        pageActions.filterBy(professor);
    }

    @Então("valido os preços dos cursos")
    public void validoOsPrecosDosCursos() throws Exception
    {
        pageActions.validateCoursePrice();
    }

}
