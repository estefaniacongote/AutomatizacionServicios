package interaction;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;



@Slf4j
public class ConsultarUsuarioGet implements Interaction {

    private final EnvironmentVariables environmentVariables;
    private static final String MESSAGE_GENERAL = "El servicio se consumió de forma exitosa";
    private final String request;
    private final String typeContent;

    public ConsultarUsuarioGet(EnvironmentVariables environmentVariables, String request, String typeContent) {
        this.environmentVariables = environmentVariables; // Asignar la variable de entorno
        this.request = request;
        this.typeContent = typeContent;
    }

    @Override
    @Subject("{0} El usuario obtiene la información desde el servicio GET: #request")
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.default.baseurl"); // Asegúrate de que esta propiedad exista

        // Crear el endpoint completo
        String fullEndpoint = baseUrl + request;

        // Log del endpoint completo
        log.info("Consultando la URL completa: {}", fullEndpoint);

        actor.whoCan(CallAnApi.at(baseUrl));
        actor.attemptsTo(
                Get.resource(request)
                        .with(requestSpecification -> requestSpecification
                                .accept(typeContent)
                                .relaxedHTTPSValidation())
        );
        log.info(MESSAGE_GENERAL);

        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().body().prettyPrint();
    }

    public static ConsultarUsuarioGet params(EnvironmentVariables environmentVariables, String request, String typeContent) {
        return Tasks.instrumented(ConsultarUsuarioGet.class, environmentVariables, request, typeContent);
    }
}

