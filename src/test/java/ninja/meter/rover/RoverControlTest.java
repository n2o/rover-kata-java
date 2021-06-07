package ninja.meter.rover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverControlTest {

    @Test
    public void emptyInputSequence_NoMovement() {
        IGame game = new Game(null, 0, 0, "north");

        IGame executedGame = RoverControl.control(game, "");

        assertThat(game.getRoverX()).isEqualTo(executedGame.getRoverX());
        assertThat(game.getRoverY()).isEqualTo(executedGame.getRoverY());
        assertThat(game.getRoverDirection()).isEqualTo(executedGame.getRoverDirection());
    }
}