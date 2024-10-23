package interaction;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;

@Slf4j
public class ActualizarUsuarioPUT implements Interaction {

    private final EnvironmentVariables environmentVariables;
    private static final String MESSAGE_GENERAL = "El servicio PUT se consumió de forma exitosa";
    private final String request;
    private final String bodyRequest;
    private final String typeContent;

    public ActualizarUsuarioPUT(EnvironmentVariables environmentVariables, String request, String bodyRequest, String typeContent) {
        this.environmentVariables = environmentVariables; // Asignar la variable de entorno
        this.request = request;
        this.bodyRequest = bodyRequest;
        this.typeContent = typeContent;
    }

    @Override
    @Subject("{0} Actualiza la información del usuario con el servicio PUT: #request")
    public <T extends Actor> void performAs(T actor) {
        // Obtener la base URL del archivo de propiedades
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.default.baseurl"); // Asegúrate de que esta propiedad exista

        // Crear el endpoint completo
        String fullEndpoint = baseUrl + request;


        // Asignar al actor la habilidad de hacer llamadas a la API
        actor.whoCan(CallAnApi.at(baseUrl));

        // Realizar la petición PUT
        actor.attemptsTo(
                Put.to(request)
                        .with(requestSpecification -> requestSpecification
                                .contentType(typeContent)
                                .body(bodyRequest)
                                .relaxedHTTPSValidation())
        );

        // Imprimir la respuesta en consola y en los logs
        log.info(MESSAGE_GENERAL);


  int statusCode = SerenityRest.lastResponse().getStatusCode();

     log.info("El código de estado es: "+statusCode);


        SerenityRest.lastResponse().body().prettyPrint();


    }

    public static ActualizarUsuarioPUT params(EnvironmentVariables environmentVariables, String request, String bodyRequest, String typeContent) {
        return Tasks.instrumented(ActualizarUsuarioPUT.class, environmentVariables, request, bodyRequest, typeContent);
    }
}
