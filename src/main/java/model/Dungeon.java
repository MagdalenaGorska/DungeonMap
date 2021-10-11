package model;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Dungeon {
    private List<Room> listOfPath;

    public Dungeon(List<Room> listOfPath) {

        this.listOfPath = listOfPath;
    }

    public Optional<Room> move(Optional<Room> currentPosition, char direction) {
        for (Room path : listOfPath) {
            if (path.getSource().equals(currentPosition.get().getSource()) && path.getDirectionAndDestination().keySet().contains(direction)) {
                String sourceNextRoom = path.getDirectionAndDestination().get(direction);
                return findRoomObj(sourceNextRoom);
            }
        }
        System.out.println("Wrong direction. You have to stay in the same room.");
        return currentPosition;
    }

    public Optional<Room> findRoomObj(String name) {
        if (listOfPath == null) {
            return Optional.empty();
        }
        for (Room room : listOfPath) {
            if (room.getSource().equals(name)) {
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }


    public List<Set<Character>> getDirectionsForRoom(String room) {
        List<Set<Character>> availableDirections = listOfPath.stream().filter(r -> r.getSource().equals(room)).map(r -> r.getDirectionAndDestination().keySet()).collect(Collectors.toList());
        return availableDirections;
    }

    public void printRoomsStruct() {
        System.out.println();
        for (Room oneRoom : listOfPath) {
            String txActive = oneRoom.isActive() ? "(*)" : "";
            System.out.print(String.format("%s%s", oneRoom.getSource(), txActive));


            var entry = oneRoom.getDirectionAndDestination().entrySet();
            //entry.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

            for (var o : entry) {
                Character nextDirection = o.getKey();
                String nextSourceName = o.getValue();

                System.out.print(" " + nextDirection + "->" + nextSourceName + " ");

                switch (nextDirection) {
                    case 'n':
                        //System.out.println(entry.getKey() + ":" + entry.getValue());
                        break;
                    case 's':
                        break;
                    case 'w':
                        break;
                    case 'e':
                        break;
                }

                //System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println();

        }
    }
}