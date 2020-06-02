import java.util.*;

/**
 * Display menu on screen and get the response from user.
 * 
 * @author (Miao Wang) 
 * @version (2.8)
 */
public class Entrance
{
    private Scanner scanner;

    /**
     * Constructor of the entrance class.
     */
    public Entrance()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Ask for the car age from user and receive the result.
     * 
     * @return the age
     */
    public String askAge()
    {
        System.out.print("Please input maximum age: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the car make from user and receive the result.
     * 
     * @return the car make
     */
    public String askCarMake()
    {
        System.out.print("Please input the car make: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the car model from user and receive the result.
     * 
     * @return the model
     */
    public String askCarModel()
    {
        System.out.print("Please input the car model: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the car registration number from user and receive the result.
     * 
     * @return the registration number
     */
    public String askCarReg()
    {
        System.out.print("Please input the car registration number: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the colour from user and receive the result.
     * 
     * @param number    the serial number of colours
     * @return the colour
     */
    public String askColour(String number)
    {
        System.out.print("Please input the colour" + number + ": ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the edit option number from user and receive the result.
     * 
     * @return a String represents the edit option number
     */
    public String askEditOption()
    {
        System.out.println("Which attribute do you want to edit?");
        System.out.println("1. colours");
        System.out.println("2. price");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the maximum price from user and receive the result.
     * 
     * @return a String represents the maximum price
     */
    public String askMaxPrice()
    {
        System.out.print("Please input the maximum price: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the minimum price from user and receive the result.
     * 
     * @return a String represents the minimum price
     */
    public String askMinPrice()
    {
        System.out.print("Please input the minimum price: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for a price from user and receive the result.
     * 
     * @return a String represents the price
     */
    public String askPrice()
    {
        System.out.print("Please input the price: ");
        return scanner.nextLine().trim();
    }

    /**
     * Ask for the made year number from user and receive the result.
     * 
     * @return a String represents the year made
     */
    public String askYearMade()
    {
        System.out.print("Please input the made year: ");
        return scanner.nextLine().trim();
    }

    /**
     * Display car make string standard when user enter invalid string.
     */
    public void carMakePrompt()
    {
        System.out.println("Valid input. Car make is consisted of only ");
        System.out.println("English alphabet and digit and cannot be blank.");
    }
    
    /**
     * Display car model string standard when user enter invalid string.
     */
    public void carModelPrompt()
    {
        System.out.println("Valid input. Car model is consisted of only ");
        System.out.println("English alphabet and digit and cannot be blank.");
    }

    /**
     * Display car registration number string standard when user enter invalid string.
     */
    public void carRegPrompt()
    {
        System.out.println("Valid input. Car registion number should contain maximum 6 ");
        System.out.println("characters combination of English alphabet or digit.");
        System.out.println("In addition, it can not be blank");
    }

    /**
     * Display colour string standard when user enter invalid string.
     */
    public void colourPrompt()
    {
        System.out.println("Valid input. The colour should only consisted of English  alphabets");
        System.out.println("(more than 2 characters) and white spaces in the middle.");
        System.out.println("In addition, it can not be blank");
    }

    /**
     * Display the main menu to user.
     */
    public void displayMenu()
    {
        System.out.println("Enter an option number please:");
        System.out.println("(1) Search Cars");
        System.out.println("(2) Add Car");
        System.out.println("(3) Edit Car");
        System.out.println("(4) Delete Car");
        System.out.println("(5) Exit System");
    }

    /**
     * Display the searching menu to user.
     */
    public void displaySearchCarMenu()
    {
        System.out.println("Car Searching Options:");
        System.out.println("(1) By Registration Number");
        System.out.println("(2) By Car Make and Car Model");
        System.out.println("(3) By Age");
        System.out.println("(4) By Price (range)");
        System.out.println("(5) By Colour");
        System.out.println("(6) Back to Main Menu");
    }

    /**
     * Get the scanner.
     * 
     * @return a scanner which can scan from the screen.
     */
    public Scanner getScanner()
    {
        return scanner;
    }

    /**
     * Ask for main menu option number.
     */
    public void menuOptionValidate()
    {
        System.out.println("Invalid input, please type number 1 to 5");
        System.out.println();
    }
    
    /**
     * Display price string standard when user enter invalid string.
     */
    public void pricePrompt()
    {
        System.out.println("Invalid input. Price should between $100 and $999,999,999.");
    }
    
    /**
     * Display prices standard 
     * when user enter maximum price less than or equal with minimum price.
     */
    public void pricesPrompt()
    {
        System.out.println("The maximum price must greater than minimum price.");
    }
    
    /**
     * Ask for search menu option number.
     */
    public void searchOptionValidate()
    {
        System.out.println("invalid input, please type number 1 to 6");
        System.out.println();
    }
}
