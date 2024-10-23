package stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.gl.Dado;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static utils.Constants.*;

@Slf4j
public class BaseUrlUserStepdefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("{string} obtiene la baseurl de la api")
    public void getTheBaseurlFromTheApi(String actor) {
        log.info(String.format(
                FORMAT_THREE,
                actor,
                CALL_SERVICE,
                BASE_URL.replace(TYPE_ENVIRONMENT, ENV1))
        );
    }
}