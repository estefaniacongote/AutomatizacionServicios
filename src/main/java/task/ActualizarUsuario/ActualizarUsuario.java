package task.ActualizarUsuario;

import interaction.ActualizarUsuarioPUT;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.util.EnvironmentVariables;

public class ActualizarUsuario {

    private final EnvironmentVariables environmentVariables;

    public ActualizarUsuario(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    // Método para realizar la petición PUT utilizando EnvironmentVariables
    public Performable apiPut(String bodyRequest, String request, String typeContent) {
        return Task.where("{0} Llamada PUT al servicio",
                ActualizarUsuarioPUT.params(environmentVariables, request, bodyRequest, typeContent) // Interacción PUT
        );
    }
}
