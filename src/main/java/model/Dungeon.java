package model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Dungeon {
    private List<Room> listOfPath;

    public Dungeon(List<Room> listOfPath) {

        this.listOfPath = listOfPath;
    }

    /*
        public String move(String currentPosition, char direction) {
            for (Room path : listOfPath) {
                if (path.getSource().equals(currentPosition) && path.getDirectionAndDestination().keySet().contains(direction))
                    return path.getDirectionAndDestination().get(direction);
            }
            System.out.println("Wrong direction. You have to stay in the same room.");
            return currentPosition;
        }
    */

    public Room move(String currentPosition, char direction) {
        for (Room path : listOfPath) {
            if (path.getSource().equals(currentPosition) && path.getDirectionAndDestination().keySet().contains(direction)) {
                String sourceNextRoom = path.getDirectionAndDestination().get(direction);
                return findRoomObj(sourceNextRoom);
            }
        }
        System.out.println("Wrong direction. You have to stay in the same room.");
        return null;
    }

    public Room findRoomObj(String name) {
        if (listOfPath == null) {
            return null;
        }
        for (var object : listOfPath) {
            if (object.getSource().equals(name)) {
                return object;
            }
        }
        return null;
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
