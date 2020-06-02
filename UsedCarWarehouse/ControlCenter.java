import java.io.*;
import java.util.*;

/**
 * The controlcenter class is used to control the whole process of this system,
 * which process refer to read from and write to file,
 * manipulation of detail information of cars,
 * and when the dara should be validated.
 * 
 * @author (Miao Wang) 
 * @version (3.2)
 */
public class ControlCenter
{
    private Warehouse warehouse;
    private IOManager ioManager;
    private Entrance entrance;
    private Validation validation;
    //record the status for the system. true for running, false for finished.
    private boolean flag;   

    /**
     * Constructor for objects of class ControlCenter
     */
    public ControlCenter()
    {
        entrance = new Entrance();
        validation = new Validation();
        try
        {
            ioManager = new IOManager();
            warehouse = new Warehouse(ioManager.getScanner());
            flag = true;
            System.out.println("Welcome! The current year is " +
                Calendar.getInstance().get(Calendar.YEAR) + ".");
            run();
        }
        catch (IOException e)
        {
            System.out.println("IOException in construtor of ControlCenter");
        }
        finally
        {
            ioManager.closeInputStream();
        }
    }

    /**
     * Add a new car to the current car collection.
     * 
     * @param Car   the new car
     */
    public void addCar()
    {
        String carReg = entrance.askCarReg();
        if (validation.carRegValidate(carReg))
        {
            Car existentCar = null;
            for (Car car : warehouse.getUsedCars())
            {
                if (car.getCarReg().equalsIgnoreCase(carReg ))
                    existentCar = car;
            }
            if (existentCar == null)
            {
                existentCar = new Car(carReg);
                obtianYearMade(existentCar);
            }
            else
            {
                System.out.println("This number has been used already, " +
                    "please enter a different one.");
                addCar();
            }
        }
        else
        {
            entrance.carRegPrompt();
            addCar();
        }
    }

    /**
     * Edit a current car in the car collection.
     * 
     * @param Car   the aimed car
     */
    public void editCarDetail(Car car)
    {        
        String option = entrance.askEditOption();
        if (validation.editOptionValidate(option))
        {
            if (option.equals("1"))
                editColour(car);
            else
                editPrice(car);
        }
        else
        {
            System.out.println("Valid input. Enter 1 or 2 please.");
            editCarDetail(car);
        }
    }

    /**
     * Edit the colours of a current car.
     * 
     * @param Car   the aimed car
     */
    public void editColour(Car car)
    {
        obtainColour1(car,"edit");
        warehouse.add(car);
    }

    /**
     * Set new value of car make
     * 
     * @param Car   the aimed car
     */
    public void obtainCarMake(Car car)
    {
        String carMake = entrance.askCarMake();
        if (validation.carMakeValidate(carMake))
        {
            car.setCarMake(carMake);
            obtainCarModel(car);
        }
        else
        {
            entrance.carMakePrompt();
            obtainCarMake(car);
        }
    }

    /**
     * Set new value of car model
     * 
     * @param Car   the aimed car
     */
    public void obtainCarModel(Car car)
    {
        String carModel = entrance.askCarModel();
        if (validation.carMakeValidate(carModel))
        {
            car.setCarModel(carModel);
            obtainPrice(car);
        }
        else
        {
            entrance.carModelPrompt();
            obtainCarModel(car);
        }
    }

    /**
     * Set new value of the first colour
     * 
     * @param Car   the aimed car
     * @param Car   the process which this method in
     */
    public void obtainColour1(Car car, String method)
    {
        String colour1 = entrance.askColour("1");
        if (validation.colourValidate(colour1))
        {
            car.setColour1(colour1);
            obtainColour2(car, method);
        }
        else
        {
            entrance.colourPrompt();
            obtainColour1(car, method);
        }
    }

    /**
     * Set new value of the second colour
     * 
     * @param Car   the aimed car
     * @param Car   the process which this method in
     */
    public void obtainColour2(Car car, String method)
    {
        String colour2 = entrance.askColour("2");
        if (colour2.equals(""))
        {
            if (method.equals("add"))
                obtainCarMake(car);
            else
            {
                car.setColour2("");
                car.setColour3("");
            }
        }
        else
        {
            if (validation.otherColourValidate(colour2))
            {
                if (colour2.equalsIgnoreCase(car.getColour1()))
                {
                    System.out.println("Colour2 is same with colour1, input a different colour please.");
                    obtainColour2(car, method);
                }
                else
                {
                    car.setColour2(colour2);
                    obtainColour3(car, method);
                }
            }
            else
            {
                entrance.colourPrompt();
                obtainColour2(car, method);
            }
        }
    }

    /**
     * Set new value of the third colour
     * 
     * @param Car   the aimed car
     * @param Car   the process which this method in
     */
    public void obtainColour3(Car car, String method)
    {
        String colour3 = entrance.askColour("3");
        if (colour3.equals(""))
        {
            if (method.equals("add"))
                obtainCarMake(car);
            else
                car.setColour3("");
        }
        else
        {
            if (validation.otherColourValidate(colour3))
            {
                if (colour3.equalsIgnoreCase(car.getColour1()) || 
                colour3.equalsIgnoreCase(car.getColour2()))
                {
                    System.out.println("This colour has been saved already, " + 
                        "input a different colour please.");
                    obtainColour3(car, method);
                }
                else
                {
                    car.setColour3(colour3);
                    if (method.equals("add"))
                        obtainCarMake(car);
                }
            }
            else
            {
                entrance.colourPrompt();
                obtainColour3(car, method);
            }
        }
    }

    /**
     * Set new value of the car made year number
     * 
     * @param Car   the aimed car
     */
    public void obtianYearMade(Car car)
    {
        String yearMade = entrance.askYearMade();
        if (validation.yearMadeValidate(yearMade))
        {
            car.setYearMade(Integer.parseInt(yearMade));
            obtainColour1(car,"add");
        }
        else
        {
            System.out.println("Valid input. Car made year should be a " + 
                "valid year number from 1887 to now.");
            obtianYearMade(car);
        }
    }

    /**
     * Provide different functions to user continually, until user choose to exit.
     */
    public void run()
    {
        while (flag)
        {
            System.out.println();
            entrance.displayMenu();
            switch (entrance.getScanner().nextLine().trim())
            {
                case "1":
                searchCars();
                break;
                case "2":
                addCar();
                break;
                case "3":
                editCar();
                break;
                case "4":
                deleteCar();
                break;
                case "5":
                exit();
                break;
                default:
                entrance.menuOptionValidate();
                break;
            }
        }
    }

    /**
     * Search cars which younger than the appointed age.
     */
    public void searchByAge()
    {
        String yearMade = entrance.askAge();
        if (validation.ageValidate(yearMade))
        {
            HashSet<Car> cars = warehouse.searchCars(Integer.parseInt(yearMade));
            if (cars.size() != 0)
                warehouse.printResult(cars);                
            else
                System.out.println("No such car with this maximum age");
        }
        else
        {
            System.out.println("Valid input. The age should be a " + 
                "non-negative integer and less then 130.");
            searchByAge();
        }
    }

    /**
     * Search cars which belongs to the appointed car make.
     */
    public void searchByCarMake()
    {
        String carMake = entrance.askCarMake();
        if (validation.carMakeValidate(carMake))
        {
            searchByCarModel(carMake);
        }
        else
        {
            entrance.carMakePrompt();
            searchByCarMake();
        }
    }

    /**
     * Search cars which is the appointed car model.
     */
    public void searchByCarModel(String carMake)
    {
        String carModel = entrance.askCarModel();
        if (validation.carMakeValidate(carModel))
        {
            HashSet<Car> cars = warehouse.searchCars(carMake, carModel);
            if (cars.size() != 0)
                warehouse.printResult(cars);                
            else
                System.out.println("No such car with this Car Make and Car Model.");
        }
        else
        {
            entrance.carModelPrompt();
            searchByCarModel(carMake);
        }
    }

    /**
     * Search car by specific car registration number.
     */
    public void searchByCarReg()
    {   
        String carReg = entrance.askCarReg();
        if (validation.carRegValidate(carReg))
        {
            Car existentCar = warehouse.searchByCarReg(carReg);
            if (existentCar != null)
                System.out.println(existentCar.toString());
            else
                System.out.println("No such car with this Registration Number.");
        }
        else
        {
            entrance.carRegPrompt();
            searchByCarReg();
        }
    }    

    /**
     * Search cars which contain the specific colour.
     */
    public void searchByColour()
    {
        String colour = entrance.askColour("");
        if (validation.colourValidate(colour))
        {
            HashSet<Car> cars = warehouse.searchCarsByColour(colour);
            if (cars.size() != 0)
                warehouse.printResult(cars);                
            else
                System.out.println("No such car with this colour.");
        }
        else
        {
            entrance.colourPrompt();
            searchByColour();
        }
    }

    /**
     * Search cars which in the specific price range.
     */
    public void searchByPrice()
    {
        String nimPrice = entrance.askMinPrice();
        if (validation.priceValidate(nimPrice))
        {
            searchByPriceMax(nimPrice);
        }
        else
        {
            entrance.pricePrompt();
            searchByPrice();
        }
    }

    /**
     * Ask user for the upper limit of the price range.
     */
    public void searchByPriceMax(String minPrice)
    {
        String maxPrice = entrance.askMaxPrice();
        if (validation.priceValidate(maxPrice))
        {
            if (validation.pricesValidate(minPrice,maxPrice))
            {
                HashSet<Car> cars = warehouse.searchCars(Integer.parseInt(minPrice),
                        Integer.parseInt(maxPrice));
                if (cars.size() != 0)
                    warehouse.printResult(cars);                
                else
                    System.out.println("No such car with this price range");
            }
            else
            {
                entrance.pricesPrompt();
                searchByPriceMax(minPrice);
            }
        }
        else
        {
            entrance.pricePrompt();
            searchByPrice();
        }
    }

    /**
     * Provide search car functions.
     */
    public void searchCars()
    {
        entrance.displaySearchCarMenu();
        switch (entrance.getScanner().nextLine().trim())
        {
            case "1":
            searchByCarReg();
            break;
            case "2":
            searchByCarMake();
            break;
            case "3":
            searchByAge();
            break;
            case "4":
            searchByPrice();
            break;
            case "5":
            searchByColour();
            break;
            case "6":
            break;
            default:
            entrance.searchOptionValidate();
            searchCars();
            break;
        }
    }

    /**
     * Get the new price when user wants to change the old price of one current car.
     */
    public void obtainPrice(Car car)
    {
        String price = entrance.askPrice();
        if (validation.priceValidate(price))
        {
            car.setPrice(Integer.parseInt(price));
            warehouse.add(car);
        }
        else
        {
            entrance.pricePrompt();
            obtainPrice(car);
        }
    }

    /**
     * Edit detail information of a current car.
     */
    public void editCar()
    {
        String carReg = entrance.askCarReg();
        if (validation.carRegValidate(carReg))
        {   
            Car existentCar = null;
            for (Car car : warehouse.getUsedCars())
            {
                if (car.getCarReg().equalsIgnoreCase(carReg))
                    existentCar = car;
            }
            if (existentCar != null)
            {
                System.out.println("The current detials of the car: " + 
                    existentCar.toString());
                warehouse.delete(existentCar);
                editCarDetail(existentCar);
            }
            else
            {
                System.out.println("No car is existent with this registration number.");
                editCar();
            }
        }
        else
        {
            entrance.carRegPrompt();
            editCar();
        }
    }

    /**
     * Edit price information of a current car.
     */
    public void editPrice(Car car)
    {
        String price = entrance.askPrice();
        if (validation.priceValidate(price))
        {   
            car.setPrice(Integer.parseInt(price));
            warehouse.add(car);
        }
        else
        {
            entrance.pricePrompt();
            editPrice(car);
        }
    }

    /**
     * Delete a current car from the car collection.
     */
    public void deleteCar()
    {
        String carReg = entrance.askCarReg();
        if (validation.carRegValidate(carReg))
        {
            Car existentCar = null;
            for (Car car : warehouse.getUsedCars())
            {
                if (car.getCarReg().equalsIgnoreCase(carReg))
                {
                    existentCar = car;
                }
            }
            if (existentCar == null)
            {
                System.out.println("No existent car is eligible");
                deleteCar();
            }
            else
            {
                warehouse.delete(existentCar);
                System.out.println("Delete successfully");
            }
        }
        else
        {
            entrance.carRegPrompt();
            deleteCar();
        }
    }

    /**
     * Exit this Used Car Warehouse Database System.
     */
    public void exit()
    {   
        try
        {
            warehouse.saveCars(ioManager.getWriter());
            ioManager.closeOutputStream();
            System.out.println("See you~~");
            flag = false;
        }
        catch (IOException e)
        {
            System.out.println("IOException in exit method of ControlCenter");
            System.out.println();
        }
    }
}
