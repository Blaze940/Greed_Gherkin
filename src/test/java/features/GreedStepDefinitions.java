package features;

import com.esgi.greedgherkin.domain.Greed;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

public class GreedStepDefinitions {
    private Greed greed;
    private int score;
    private int[] dice;

    @Given("^I throw the following dice: (.*)$")
    public void throwDice(String diceValues) {
        greed = new Greed();
        String[] diceString = diceValues.split(", ");
        dice = new int[diceString.length];
        for (int i = 0; i < diceString.length; i++) {
            dice[i] = Integer.parseInt(diceString[i].trim());
        }
    }

    @When("I calculate my score")
    public void calculateScore() {
        try {
            score = greed.score(dice);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Then("I should have a score of {int}")
    public void checkScore(int expectedScore) {
        assertThat(score).isEqualTo(expectedScore);
    }

    @Then("I should have a score of {int}*{int} = {int}")
    public void checkScore(int tripleScore, int multiplier, int expectedTotalScore) {
        assertThat(score).isEqualTo(tripleScore * multiplier);
        assertThat(score).isEqualTo(expectedTotalScore);
    }

    @Then("I should have an error message saying {string}")
    public void checkErrorMessage(String expectedErrorMessage) {
        assertThatThrownBy(() -> greed.score(dice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }
}
