package task.ActualizarUsuario;

import net.thucydides.core.util.EnvironmentVariables;

public class Call {

    private final EnvironmentVariables environmentVariables;

    // Constructor que acepta EnvironmentVariables
    public Call(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    // Método que retorna la instancia de ActualizarUsuario pasando las EnvironmentVariables
    public ActualizarUsuario service() {
        return new ActualizarUsuario(environmentVariables); // Pasa environmentVariables al constructor
    }
}
