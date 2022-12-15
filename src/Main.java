import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static final String EXIT = "exit";
    public static final String START = "start";
    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public static final String EAST = "east";
    public static final String WEST = "west";
    public static final String LOOK = "look";

    public static final List<String> VALID_COMMAND = Arrays.asList(EXIT, START, NORTH, SOUTH, EAST, WEST, LOOK);
    
    static String f = "zork.txt";

    public static void main(String[] args) {
        
        System.out.println("WELCOME TO ZORK!!!");
        Scanner sc = new Scanner(System.in);
        String line;
        boolean stop = false;

        while(!stop) {
            line = sc.nextLine();
            line = line.trim();
            System.out.println("You entered: " + line);

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("END GAME...GOOD BYE!!!");
                stop = true;   
            }

            if (!ValidateInput(line)) {
               System.out.println("Invalid input! Please try again...");
            }
            else {
                System.out.println("Processing: " + line);
                ProcessingInput(line);
            }
        }
        sc.close();
    }
    

    public static boolean ValidateInput(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].trim();
        return VALID_COMMAND.contains(command);
    }

    public static void ProcessingInput(String input) {
        Scanner sc = new Scanner(System.in);
        String command = sc.next().trim();

        switch (command) {
            case START:
            ReadFileStart();
            break;

            case NORTH:
            //ReadFileNorth();
            break;

            case SOUTH:
            break;

            case EAST:
            break;

            case WEST:
            ReadFileWest();
            break;

            case LOOK:
            break;

            default:
            break;

        }
        sc.close();
    }

    public static void ReadFileStart() {

          try {
          BufferedReader bf = new BufferedReader(new FileReader("zork.txt"));
          List<String> line = bf.lines()
          .skip(23)
          .limit(1)
          .collect(Collectors.toList());

          line.stream().forEach(System.out::println);
          bf.close();
        
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    
    }

    public static void ReadFileWest() {

        try {
        BufferedReader bf = new BufferedReader(new FileReader("zork.txt"));
        List<String> line = bf.lines()
        .skip(1)
        .limit(4)
        .collect(Collectors.toList());

        line.stream().forEach(System.out::println);
        bf.close();
      
      } catch (FileNotFoundException e) {
      e.printStackTrace();
      } catch (IOException e) {
      e.printStackTrace();
      }

  }

  public static void ReadFileSouth() {

    try {
    BufferedReader bf = new BufferedReader(new FileReader("zork.txt"));
    List<String> line = bf.lines()
    .skip(7)
    .limit(5)
    .collect(Collectors.toList());

    line.stream().forEach(System.out::println);
    bf.close();
  
  } catch (FileNotFoundException e) {
  e.printStackTrace();
  } catch (IOException e) {
  e.printStackTrace();
  }

}

}
