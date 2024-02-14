import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    Map<String, Double> incomeTax = new HashMap<>();

    // Define Global Variables
    Map<Integer, List<Integer>> employee = new HashMap<>();
    int employeeID;
    int input_hours;

  
    // Function to initiate the income tax map
    public void loadHashMap () {
      incomeTax.put("AL", 2.0);
      incomeTax.put("AK", 0.0);
      incomeTax.put("AZ", 2.59);
      incomeTax.put("AR", 2.0);
      incomeTax.put("CA", 1.0);
      incomeTax.put("CO", 4.55);
      incomeTax.put("CT", 3.0);
      incomeTax.put("DC", 4.0);
      incomeTax.put("DE", 0.0);
      incomeTax.put("FL", 0.0);
      incomeTax.put("GA", 1.0);
      incomeTax.put("HI", 1.4);
      incomeTax.put("ID", 1.125);
      incomeTax.put("IL", 4.95);
      incomeTax.put("IN", 3.23);
      incomeTax.put("IA", 0.33);
      incomeTax.put("KS", 3.1);
      incomeTax.put("KY", 5.0);
      incomeTax.put("LA", 1.85);
      incomeTax.put("ME", 5.8);
      incomeTax.put("MD", 2.0);
      incomeTax.put("MA", 5.0);
      incomeTax.put("MI", 4.25);
      incomeTax.put("MN", 5.35);
      incomeTax.put("MS", 0.0);
      incomeTax.put("MO", 1.5);
      incomeTax.put("MT", 1.0);
      incomeTax.put("NE", 2.46);
      incomeTax.put("NV", 0.0);
      incomeTax.put("NH", 5.0);
      incomeTax.put("NJ", 1.4);
      incomeTax.put("NM", 1.7);
      incomeTax.put("NY", 4.0);
      incomeTax.put("NC", 4.99);
      incomeTax.put("ND", 1.1);
      incomeTax.put("OH", 0.0);
      incomeTax.put("OK", 0.25);
      incomeTax.put("OR", 4.75);
      incomeTax.put("PA", 3.07);
      incomeTax.put("RI", 3.75);
      incomeTax.put("SC", 0.0);
      incomeTax.put("SD", 0.0);
      incomeTax.put("TN", 0.0);
      incomeTax.put("TX", 0.0);
      incomeTax.put("UT", 4.95);
      incomeTax.put("VT", 3.35);
      incomeTax.put("VA", 2.0);
      incomeTax.put("WA", 0.0);
      incomeTax.put("WV", 3.0);
      incomeTax.put("WI", 3.54);
      incomeTax.put("WY", 0.0); 
    }

    // Function to clear the console
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Fuction to display the menu
    public static void menu() {
        System.out.println("1.  Input Hours \n");
        System.out.println("2.  Show Hours Worked \n");
        System.out.println("3.  Calculatw Wage \n");
        System.out.println("4.  Delete Hours Worked \n");
        System.out.println("#.  Any Number Other Than The Stated To Exit The Program \n");
    }

    // Function to process the input selection and route to the appropriate functions
    public int options(int selection) {
      
        switch (selection) {
            case 1:
                System.out.println("\n - You selected Option 1 (Input Hours Worked) - \n");
                option_1();
                break;
            case 2:
                System.out.println("\n - You selected Option 2 (Show Hours Worked) - \n");
                option_2();
                break;
            case 3:
                System.out.println("\n - You selected Option 3 (Calculate Wage) - \n");
                option_3();
                break;
            case 4:
              System.out.println("\n - You selected Option 3 (Delete Hours Worked) - \n");
              option_4();
              break;
            default:
                System.out.println("\n - You Exited The Program - \n");
                break;
        }
        return selection;
    }

    // Function to process the input selection of 1 
    public void option_1() {

        // Prints prompt to ask for emplyoee ID and get user input
        System.out.println("Please enter your employee ID (Numbers Only): ");
        Scanner scanner = new Scanner(System.in);
        employeeID = scanner.nextInt();

        // Prints prompt to ask for hours worked and get user input
        System.out.println("Please enter your Hours Worked (Numbers Only): ");
        input_hours = scanner.nextInt();
  
        // Create a new list for each input
        List<Integer> newHoursList = new ArrayList<>();
        newHoursList.add(input_hours);

        // Take all user inputs and pass the values to the addValue function
        addValue(employeeID, newHoursList);
  
    }

    // Function to process the input from option_1
    private void addValue(int key, List<Integer> hours) {

        // Checks to see if the key exists in the map
        if (employee.containsKey(key)) {
            List<Integer> existingHours = employee.get(key);
            existingHours.addAll(hours);
        } else {
            // Adds the new key and value to the list
            List<Integer> newHoursList = new ArrayList<>(hours);
            // Add the list to the employee map
            employee.put(key, newHoursList);
        }
    }

    // Function to process the input selection of 2
    private void option_2() {

      // Defines new scanner object for input
      Scanner scanner = new Scanner(System.in);

      // Prints prompt to ask for employee ID and get user input
      System.out.println("Please enter your employee ID (Numbers Only): ");

      // Loops to check for correct input from user. If input is not a number, it will loop until correct input is given
      while (!scanner.hasNextInt()) {
          System.out.println("Invalid input. Please enter numbers only.");

          scanner.next();
      }

      // Save the input as an integer
      int selected_employeeID = scanner.nextInt();

      // Prints the employee ID and hours worked for the selected employee
      System.out.println("\n Employee ID: " + selected_employeeID);
      System.out.println("\n Hours Worked: " + "\n");

      // Instantiate a new list to store the hours worked for the selected employee
      List<Integer> employeeHours = employee.get(selected_employeeID);

      // Checks if the list employeeHours is empty
      if (employeeHours != null) {
        
        // Prints the elements of the ArrayList using a for loop
        for (int i = 0; i < employeeHours.size(); i++) {
            System.out.println("ID: " + i + ", Hours: " + employeeHours.get(i) + "\n");
        }

      }
    }

    // Function to process the input selection of 3
    private void option_3() {

      // Defines new scanner object for input
      Scanner scanner = new Scanner(System.in);

      // Define local variables
      double taxRate = 0.0;
      String selected_state = "";

      // Prints prompt to ask for employee ID and get user input
      System.out.println("Please enter your State (Two Letters Only i.e. MN): ");
      selected_state = scanner.next();

      // Checks to see if the key exists in the mapm, if not it will loop until a correct input is given
      while(!incomeTax.containsKey(selected_state)) {
        System.out.println("Invalid state or input. Please try again.");
        System.out.println("Please enter your State (Two Letters Only i.e. MN): ");
        selected_state = scanner.next();
      }

      // Uses the key to get the value from the map
      taxRate = incomeTax.get(selected_state);

      // Prints prompt asking user input for employee ID
      System.out.println("Please enter your employee ID (Numbers Only): ");

      // Loops to check for correct input from user. If input is not a number, it will loop until correct input is given
      while (!scanner.hasNextInt()) {
          System.out.println("Invalid input. Please enter numbers only.");
         
          scanner.next();
      }

      // Save the input as an integer
      int selected_employeeID = scanner.nextInt();

      // Prints the prompt to ask user for wage rate
      System.out.println("Please enter your wage rate (Numbers Only): ");

      // Loops to check for correct input from user. If input is not a number, it will loop until correct input
      while (!scanner.hasNextDouble()) {
          System.out.println("Invalid input. Please enter numbers only.");

          scanner.next();
      }

      // Save the input as a double
      double wageRate = scanner.nextDouble();

      // Clears the console
      clearConsole();

      // Prints the employee ID, hours worked, and wage rate
      System.out.println("Employee ID: " + selected_employeeID);
      System.out.println("Hours Worked: ");

      // Instantiate a new list to store the hours worked for the selected employee
      List<Integer> employeeHours = employee.get(selected_employeeID);
      int totalHours = 0;

      // Checks if the list employeeHours is empty
      if (employeeHours != null) {
          // Print the elements of the ArrayList
          for (Integer value : employeeHours) {
              System.out.println(value + "\n");

              // Calculates the total hours worked
              totalHours = totalHours + value; 
          }

          // Calculates the gross total
          double grossTotal = (wageRate * totalHours);
          // Calculates the net total
          double netTotal = grossTotal - (grossTotal * (taxRate/100));;

          // Prints the output for the total hours worked, gross total, net total, and tax rate
          System.out.println("_____________________________________________________________________ \n");
            System.out.println("Total Hours: " + totalHours + "\n");
            System.out.println("Wage Rate: " + "$" + String.format("%.2f", wageRate) + "\n");
            System.out.println("Tax Rate: " +  taxRate + "%" +  "\n");
            System.out.println("Gross Total Wage: " + "$" + String.format("%.2f", grossTotal) + "\n");
            System.out.println("Net Total Wage: " + "$" + String.format("%.2f", netTotal) + "\n");
          System.out.println("_____________________________________________________________________ \n");
      } else {
          System.out.println("N/A No Hours Worked. \n");
      }
    }

    // Function to process the input selection of 4
    public void option_4() {

      // Clears the console
      clearConsole();

      // Creates new scanner object
      Scanner scanner = new Scanner(System.in);

      // Prints prompt to ask for employee ID and get user input
      System.out.println("Please enter your employee ID (Numbers Only): ");

      // Loops to check for correct input from user. If input is not a number, it will loop until correct input is given
      while (!scanner.hasNextInt()) {
          System.out.println("Invalid input. Please enter numbers only.");

          scanner.next();
      }

      // Save the input as an integer
      int selected_employeeID = scanner.nextInt();

      // Prints the prompt to show employee ID and hours worked
      System.out.println("Employee ID: " + selected_employeeID);
      System.out.println("Hours Worked: ");

      // Instantiate a new list to store the hours worked for the selected employee
      List<Integer> employeeHours = employee.get(selected_employeeID);

      // Checks if the list employeeHours is empty
      if (employeeHours != null) {
        
          // Print the elements of the ArrayList
          for (int i = 0; i < employeeHours.size(); i++) {
              System.out.println("ID: " + i + ", Hours: " + employeeHours.get(i) + "\n");
          }

          // Prints the prompt to ask for the ID of the hours to be deleted
          System.out.println("Which ID would you like to delete? (Numbers Only): ");
          while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter numbers only.");
  
            scanner.next();
          }

          // Save the input as an integer
          selected_employeeID = scanner.nextInt();
          // Removes the emoployee hours using employee ID from the list
          employeeHours.remove(selected_employeeID);
          
        }
    }

    // Main function 
    public static void main(String[] args) {

        // Creates a new object of the Main class
        Main mainInstance = new Main();

        // Calls the loadHashMap function to insantiate the map
        mainInstance.loadHashMap();

        // Creates new scanner object
        Scanner scanner = new Scanner(System.in);
        
        // Instantiate the selectin to 1 
        int selection = 1;

        // Loops until the user correctly puts in the proper input
        while (selection >= 1 && selection <= 4) {

            // Calls the menu function to display the menu
            menu();

            // Prints prompt to ask for selection and get user input
            System.out.println("Enter your choice: ");

            // Loops to check for correct input from user. If input is not a number, it will loop until correct input is given
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter numbers only.");

                scanner.next();
            }
            // Save the input as an integer
            selection = scanner.nextInt();

            // Calls the options function to process the user input
            mainInstance.options(selection);
        }

        // Closes the scanner object
        scanner.close();
    }
}