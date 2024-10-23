package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static utils.Constants.STATUS;

public class GetQuestion implements Question<Boolean> {

    private int statusOK;

    public GetQuestion(int statusOK) {
        this.statusOK = statusOK;
    }

    @Override
    @Subject("{0} valida el codigo de estado exitoso #statusOK ")
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(STATUS, response -> response.statusCode(statusOK)));
        return true;
    }

    public static GetQuestion successful(int statusOK) {
        return new GetQuestion(statusOK);
    }

}