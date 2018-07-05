package ninja.meter.rover;

public class RoverControl {

    public static IGame execute(IGame game, String input) {
        // Your implementation goes here
        // Valid roverDirections: "north", "south", "east", "west"
        return new Game(game.getWorld(), game.getRoverX(), game.getRoverY(), "south");
    }
}
