package task.Consultar;

import net.thucydides.core.util.EnvironmentVariables;

public class Call {

    private final EnvironmentVariables environmentVariables;

    // Constructor que acepta EnvironmentVariables
    public Call(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public ConsultarUsuario service() {
        return new ConsultarUsuario(environmentVariables);
    }
}
