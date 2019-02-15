package paintcalculator;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator {

    private List<Paintable> paintableList = new ArrayList<Paintable>();
    private Scanner keyboard;

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        new PaintCalculator();
    }

    public PaintCalculator() throws IOException, FileNotFoundException, ClassNotFoundException {
        keyboard = new Scanner(System.in);

        int option = 0;

        while (option != 5) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        createFence();
                        break;
                    case 3:
                        writeFile();
                        break;
                    case 4:
                        readFile();
                        break;
                    case 5:
                        printRooms();
                        break;                
                    case 6:
                        System.out.println("Goodbye");
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        }

    }
    private void createFence()
    {
        Fence f = new Fence();
        paintableList.add(f);
    }

    private void writeFile() throws IOException
    {
        RoomWriter writer = new RoomWriter();
        writer.writePaintable("rooms.dat", paintableList);
    }
    private void readFile() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        paintableList = RoomReader.readPaintable("rooms.dat");
    }
    private void printRooms() {
        if (paintableList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Paintable item : paintableList) {
            System.out.println(item.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Add fence");
        System.out.println("3. Write rooms to file");
        System.out.println("4. Read rooms from file");
        System.out.println("5. View rooms");
        System.out.println("6. Exit");
        System.out.println();
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            paintableList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }

    }
}
