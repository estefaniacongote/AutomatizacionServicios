package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ActualizarUsuario.feature",
        glue = "stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Successful"
)


public class ActualizarUsuarioRunner {
}
