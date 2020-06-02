import java.util.*;
import java.io.*;

/**
 * The warehouse class manages car collection.
 * 
 * @author (Miao Wang) 
 * @version (2.5)
 */
public class Warehouse
{
    private HashSet<Car> usedCars;

    /**
     * Constructor for objects of class Warehouse
     * 
     * @param Scanner   a scanner which can read the aimed text file
     */
    public Warehouse(Scanner scanner) throws IOException
    {
        usedCars = new HashSet<>();
        loadCars(scanner);
    }

    /**
     * Add one car in the car collection.
     * 
     * @param Car   a car with detail information
     */
    public void add(Car car)
    {
        usedCars.add(car);
    }

    /**
     * Delete one sepcific car from the car collection.
     * 
     * @param Car   a car which in the current car collection
     */
    public void delete(Car car)
    {
        usedCars.remove(car);
    }
    
    /**
     * Return the current car collection.
     * 
     * @return current car collection
     */
    public HashSet<Car> getUsedCars()
    {
        return usedCars;
    }

    /**
     * Load car collection from the aimed text file.
     * 
     * @param Scanner   a scanner which can read from the aimed file
     */
    public void loadCars(Scanner scanner)
    {
        while (scanner.hasNext())
        {
            String[] inf = scanner.nextLine().split(",");
            Car newCar = new Car(inf[0], Integer.parseInt(inf[1]), 
                                 inf[2], inf[3], inf[4], inf[5],
                                 inf[6], Integer.parseInt(inf[7]));
            add(newCar);
        }
    }

    /**
     * Display detail information of a car collection.
     * 
     * @param HashSet   a collection of cars
     */
    public void printResult(HashSet<Car> cars)
    {
        for (Car car : cars)
        {
            System.out.println(car.toString());
        }
    }

    /**
     * Save the current car collection to the aimed file.
     * 
     * @param Printwriter   a writer which can write to the aimed file.
     */
    public void saveCars(PrintWriter writer)
    {
        for (Car car : usedCars)
        {
            writer.println(car.toString());
        }
    }

    /**
     * Search car by car registration number from the current car collection.
     * 
     * @param String   the car registration number
     * @return the car which meet the requirement
     */
    public Car searchByCarReg(String carReg)
    {
        Car existentCar = null;
        for (Car car : usedCars)
        {
            if (car.getCarReg().equalsIgnoreCase(carReg))
                existentCar = car;
        }
        return existentCar;
    }
    
    /**
     * Search cars by an age range from the current car collection.
     * 
     * @param int   the maximum age
     * @return the cars which meet the requirement
     */
    public HashSet<Car> searchCars(int age)
    {
        HashSet<Car> existentCars = new HashSet<Car>();
        for (Car car : usedCars)
        {
            if (car.getYearMade() >= (Calendar.getInstance().get(Calendar.YEAR) - age))
                existentCars.add(car);
        }
        return existentCars;
    }

    /**
     * Search cars by car make and car model from the current car collection.
     * 
     * @param String   the car make
     * @param String   the car model
     * @return the cars which meet the requirement
     */
    public HashSet<Car> searchCars(String make, String model)
    {
        HashSet<Car> existentCars = new HashSet<Car>();
        for (Car car : usedCars)
        {
            if (car.getCarMake().equalsIgnoreCase(make))
            {
                if (model.equalsIgnoreCase("ANY"))
                    existentCars.add(car);
                else
                {
                    if (car.getCarModel().equalsIgnoreCase(model))
                        existentCars.add(car);
                }                    
            }    
        }
        return existentCars;
    }

    /**
     * Search cars by a price range from the current car collection.
     * 
     * @param int   the minimum price
     * @param int   the maximum price
     * @return the cars which meet the requirement
     */
    public HashSet<Car> searchCars(int minPrice, int maxPrice)
    {
        HashSet<Car> existentCars = new HashSet<Car>();
        for (Car car : usedCars)
        {
            if (car.getPrice() >= minPrice &&
                car.getPrice() <= maxPrice)
                existentCars.add(car);
        }
        return existentCars;
    }

    /**
     * Search cars by colour from the current car collection.
     * 
     * @param String   colour name
     * @return the cars which meet the requirement
     */
    public HashSet<Car> searchCarsByColour(String colour)
    {
        HashSet<Car> existentCars = new HashSet<Car>();
        for (Car car : usedCars)
        {
            if (car.getColour1().equalsIgnoreCase(colour)||
                car.getColour2().equalsIgnoreCase(colour)||
                car.getColour3().equalsIgnoreCase(colour))
                existentCars.add(car);
        }
        return existentCars;
    }

}
