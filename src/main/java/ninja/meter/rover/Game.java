package ninja.meter.rover;

import java.util.List;

public class Game implements IGame {
    private final List<List<String>> world;
    private final long roverX;
    private final long roverY;
    private final String roverDirection;

    Game(List<List<String>> world, long roverX, long roverY, String roverDirection) {
        this.world = world;
        this.roverX = roverX;
        this.roverY = roverY;
        this.roverDirection = roverDirection;
    }

    @Override
    public IGame execute(String input) {
        return null;
    }

    @Override
    public long getRoverX() {
        return this.roverX;
    }

    @Override
    public long getRoverY() {
        return this.roverY;
    }

    @Override
    public String getRoverDirection() {
        return this.roverDirection;
    }

    @Override
    public List<List<String>> getWorld() {
        return this.world;
    }
}
