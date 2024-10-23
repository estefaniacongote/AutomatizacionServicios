package task.Consultar;

import interaction.ConsultarUsuarioGet;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.util.EnvironmentVariables;

public class ConsultarUsuario {

    private final EnvironmentVariables environmentVariables;

    public ConsultarUsuario(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public Performable apiget(String request, String typeContent) {
        return Task.where("{0} Llamada de un servicio a ejecutar GET",
                // Pasar las variables de entorno a la interacción
                actor -> actor.attemptsTo(
                        ConsultarUsuarioGet.params(environmentVariables, request, typeContent)
                )
        );
    }
}
