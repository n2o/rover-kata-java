package ninja.meter.rover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverControlTest {

    @Test
    public void emptyInputSequence_NoMovement() {
        IGame game = new Game(null, 0, 0, "north");

        IGame executedGame = RoverControl.execute(game, "");

        assertEquals(game.getRoverX(), executedGame.getRoverX());
        assertEquals(game.getRoverY(), executedGame.getRoverY());
        assertEquals(game.getRoverDirection(), executedGame.getRoverDirection());
    }
}