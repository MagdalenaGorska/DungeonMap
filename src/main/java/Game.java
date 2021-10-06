import model.Dungeon;
import model.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static List<Room> roomList;
    private Scanner scanner;
    private Character direction = ' ';
    private String currentRoom;
    private Dungeon dungeon;

    public void start() {

        roomList = Game.loadDungeonFromFile("MapOfDungeon.txt");

        scanner = new Scanner(System.in);
        dungeon = new Dungeon(roomList);

        System.out.print("\nWhich room do you want to start in? Your options:\n");
        for (Room room : roomList) {
            System.out.print(room.getSource() + ' ');
        }
        currentRoom = scanner.nextLine();
        System.out.println("You have been started in room \033[0;92m" + currentRoom + "\033[0m");

        while (!direction.equals('q')) {
            System.out.print("Which direction do you want to move? " + dungeon.getDirectionsForRoom(currentRoom) + " ? Enter 'q' to finish ");
            direction = scanner.nextLine().charAt(0);
            if (direction.equals('n') || direction.equals('s') || direction.equals('w') || direction.equals('e')) {
                currentRoom = dungeon.move(currentRoom, direction);
                System.out.println("You are currently in the room \033[0;96m" + currentRoom + "\033[0m");
            }

        }
    }

    private static List<Room> loadDungeonFromFile(String nameOfFile) {
        String line;
        String[] valuesOfLine;
        roomList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfFile))) {
            while (null != (line = bufferedReader.readLine())) {
                System.out.println(line);
                valuesOfLine = line.split(" ");
                Room room = new Room(valuesOfLine[0]);
                for (int i = 1; i < valuesOfLine.length; i++) {
                    String[] directionAndDestination = valuesOfLine[i].split(":");
                    room.addPath(directionAndDestination[0].charAt(0), directionAndDestination[1]);
                }
                roomList.add(room);
                //System.out.println("Adding room");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomList;
    }
}
