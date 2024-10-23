package stepdefinition;

import interaction.ConsultarOrdenGet;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import questions.GetQuestion;
import task.Consultar.Call;
import utils.Uri;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.Constants.*;
import static utils.Constants.ENV1;

public class ConsultarOrdenStep {
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        // Obtén la instancia de EnvironmentVariables
        this.environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    @Cuando("configura la peticion a disparar")
    public void configuraLaPeticionADisparar() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                new Call(environmentVariables).service().apiget(
                        BASE_URL.replace(TYPE_ENVIRONMENT, ENV2),
                        Uri.LIST_USERS_2.getUri()
                )
        );
    }

    @Entonces("valida estado de la orden")
    public void validaEstadoDeLaOrden() {
        // Lógica para validar el estado de la petición
      theActorInTheSpotlight().should(seeThat(GetQuestion.successful(SC_NOT_FOUND)));
    }
}
