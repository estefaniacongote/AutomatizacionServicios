package questions;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static utils.Constants.RESPONSE_REQUEST;

public class PutQuestion implements Question<Boolean> {

    private int statusOK;

    public PutQuestion(int statusOK) {
        this.statusOK = statusOK;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(
                        RESPONSE_REQUEST,
                        response -> response.statusCode(statusOK)
                                .body("email", equalTo("estefania2@gmail.com"))
                                .body("first_name", equalTo("Estefania Congote"))
                )
        );

        return true;
    }

    public static PutQuestion updateSuccess(int statusOK) {
        return new PutQuestion(statusOK);
    }
}