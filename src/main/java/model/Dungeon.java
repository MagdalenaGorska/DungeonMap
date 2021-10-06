package model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Dungeon {
    private List<Room> listOfPath;

    public Dungeon(List<Room> listOfPath) {

        this.listOfPath = listOfPath;
    }

    public String move(String currentPosition, char direction) {
        for (Room path : listOfPath) {
            if (path.getSource().equals(currentPosition) && path.getDirectionAndDestination().keySet().contains(direction))
                return path.getDirectionAndDestination().get(direction);
        }
        System.out.println("Wrong direction. You have to stay in the same room.");
        return currentPosition;
    }

    public List<Set<Character>> getDirectionsForRoom(String room) {
        List<Set<Character>> availableDirections = listOfPath.stream().filter(r -> r.getSource().equals(room)).map(r -> r.getDirectionAndDestination().keySet()).collect(Collectors.toList());
        return availableDirections;
    }
}
