package stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import questions.PutQuestion;
import task.ActualizarUsuario.ActualizarUsuario;
import utils.Uri;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.Constants.ACTOR;

public class ActualizarUsuarioStep {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        this.environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    @Cuando("configura la peticion")
    public void configuraLaPeticion() {
        // Crea una instancia de ActualizarUsuario usando environmentVariables
        ActualizarUsuario actualizarUsuario = new ActualizarUsuario(environmentVariables);

        OnStage.theActorCalled(ACTOR).attemptsTo(
                actualizarUsuario.apiPut(
                        "{\n" +  // Body de la petición
                                "    \"id\": \"2\",\n" +
                                "    \"email\": \"estefania2@gmail.com\",\n" +
                                "    \"first_name\": \"Estefania Congote\",\n" +
                                "    \"last_name\": \"Weaver\",\n" +
                                "    \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                                "}",
                        Uri.UPDATE_USER_1.getUri(),  // URI
                        "application/json"  // Tipo de contenido
                )
        );
    }

    @Entonces("valida los datos consultados fueron actualizados")
    public void validaLosDatosConsultadosFueronActualizados() {
        theActorInTheSpotlight().should(seeThat(PutQuestion.updateSuccess(SC_OK)));
    }

}
