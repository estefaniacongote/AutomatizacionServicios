package task.Consultar;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task; // Asegúrate de que esta es la interfaz correcta
import net.thucydides.core.util.EnvironmentVariables;

import static org.apache.http.HttpStatus.SC_OK;

public class ConsultarOrden implements Task {
    private final EnvironmentVariables environmentVariables;
    private final String endpoint;
    private final String contentType;

    public ConsultarOrden(EnvironmentVariables environmentVariables, String endpoint, String contentType) {
        this.environmentVariables = environmentVariables;
        this.endpoint = endpoint;
        this.contentType = contentType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Configura y ejecuta la petición
            RestAssured.given()
                    .header("Content-Type", contentType)
                    .when()
                    .get(environmentVariables.getProperty("base.url") + endpoint)
                    .then()
                    .statusCode(SC_OK);
        } catch (Exception e) {
            // Manejo de excepciones
            throw new RuntimeException("Error al realizar la petición GET: " + e.getMessage(), e);
        }
    }
}
