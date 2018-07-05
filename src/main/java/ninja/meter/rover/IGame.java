package ninja.meter.rover;

import java.util.List;

public interface IGame {
    IGame execute(String input);
    long getRoverX();
    long getRoverY();
    String getRoverDirection();
    List<List<String>> getWorld();
}
