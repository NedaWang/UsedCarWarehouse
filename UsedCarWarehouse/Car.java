
/**
 * The car class is a model of actural cars.
 * 
 * @author (Miao Wang) 
 * @version (2.1)
 */
public class Car
{
    private String carReg;
    private int yearMade;
    private String carMake;
    private String carModel;
    private int price;
    private String colour1;
    private String colour2;
    private String colour3;

    /**
     * 0 parameter constructor for objects of class Car.
     */
    public Car()
    {
        this.carReg = "";
        this.yearMade = 2017;
        this.carMake = "";
        this.carModel = "";
        this.price = 0;
        this.colour1 = "";
        this.colour2 = "";
        this.colour3 = "";
    }

    /**
     * 1 parameter (registration number) constructor for objects of class Car.
     */
    public Car(String carReg)
    {
        if (carReg.matches("[a-zA-Z0-9]{1,6}"))
            this.carReg = carReg;
        this.yearMade = 2017;
        this.carMake = "";
        this.carModel = "";
        this.price = 0;
        this.colour1 = "";
        this.colour2 = "";
        this.colour3 = "";
    }

    /**
     * 8 parameters (all details) constructor for objects of class Car.
     */
    public Car(String carReg, int yearMade, 
    String colour1, String colour2, 
    String colour3, String carMake, 
    String carModel, int price)
    {        
        if (carReg.matches("[a-zA-Z0-9]{1,6}"))
            this.carReg = carReg;
        else
            this.carReg = "";
        if (String.valueOf(yearMade).matches("[12][0-9]{3}"))
            this.yearMade = yearMade;
        else
            this.yearMade = 0;
        if (colour1.matches("[a-zA-Z]+[a-zA-Z\\s]+"))
            this.colour1 = colour1;
        else
            this.colour1 = "";
        if (colour2.matches("[a-zA-Z\\s]*"))
            this.colour2 = colour2;
        else
            this.colour2 = "";
        if (colour3.matches("[a-zA-Z\\s]*"))
            this.colour3 = colour3;
        else
            this.colour3 = "";
        if (carMake.matches("[a-zA-Z0-9]+"))
            this.carMake = carMake;
        else
            this.carMake = "";
        if (carModel.matches("[a-zA-Z0-9]+"))
            this.carModel = carModel;
        else
            this.carModel = "";
        if (String.valueOf(price).matches("[1-9][0-9]{2,9}"))
            this.price = price;
        else
            this.price = 0;
    }

    /**
     * Judge if the two variables refer to the same object.
     * 
     * @param obj   the compared object
     * @return  the comparison result
     */
    @Override
    public boolean equals(Object obj)
    {
        final Car other = (Car)obj;
        return carReg.equals(other.getCarReg());
    }

    /**
     * Get car make.
     * 
     * @return carMake  car make
     */
    public String getCarMake()
    {
        return carMake;
    }

    /**
     * Get car model.
     * 
     * @return carModel  car model
     */
    public String getCarModel()
    {
        return carModel;
    }

    /**
     * Get car registration number.
     * 
     * @return carReg  car registration number
     */
    public String getCarReg()
    {
        return carReg;
    }

    /**
     * Get car colour1.
     * 
     * @return the first colour
     */
    public String getColour1()
    {
        return colour1;
    }

    /**
     * Get car colour2.
     * 
     * @return the second colour
     */
    public String getColour2()
    {
        return colour2;
    }

    /**
     * Get car colour3.
     * 
     * @return the third colour
     */
    public String getColour3()
    {
        return colour3;
    }

    /**
     * Get car price.
     * 
     * @return the price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Get car made year number.
     * 
     * @return the year made
     */
    public int getYearMade()
    {
        return yearMade;
    }

    /**
     * Change the defualt hashcode calculate method.
     * Judge if two variables are same only by the car registration number.
     * If the registration numbers are same, hence, the two variables refer to the same object.
     * Then, get hashcode of the car object.
     * 
     * @return the hashcode of the car object
     */
    @Override
    public int hashCode()
    {
        final int prime =31;
        int result = 1;
        result = prime * result + carReg.hashCode();
        return result;
    }

    /**
     * Save car make.
     * 
     * @param car make
     */
    public void setCarMake(String carMake)
    {
        if (carMake.matches("[a-zA-Z0-9]+"))
            this.carMake = carMake;
    }

    /**
     * Save car model.
     * 
     * @param car model
     */
    public void setCarModel(String carModel)
    {
        if (carModel.matches("[a-zA-Z0-9]+"))
            this.carModel = carModel;
    }

    /**
     * Save car registration number.
     * 
     * @param car registration number
     */
    public void setCarReg(String carReg)
    {
        if (carReg.matches("[a-zA-Z0-9]{1,6}"))
            this.carReg = carReg;
    }

    /**
     * Save the first colour.
     * 
     * @param the first colour
     */
    public void setColour1(String colour1)
    {
        if (colour1.matches("[a-zA-Z]+[a-zA-Z\\s]+"))
            this.colour1 = colour1;
    }

    /**
     * Save the second colour.
     * 
     * @param the second colour
     */
    public void setColour2(String colour2)
    {
        if (colour2.matches("[a-zA-Z\\s]*"))
            this.colour2 = colour2;
    }

    /**
     * Save the third colour.
     * 
     * @param the third colour
     */
    public void setColour3(String colour3)
    {
        if (colour3.matches("[a-zA-Z\\s]*"))
            this.colour3 = colour3;
    }

    /**
     * Save the price.
     * 
     * @param the price
     */
    public void setPrice(int price)
    {
        if (String.valueOf(price).matches("[1-9][0-9]{2,9}"))
            this.price = price;
    }

    /**
     * Save the made year number.
     * 
     * @param the year made
     */
    public void setYearMade(int yearMade)
    {
        if (String.valueOf(yearMade).matches("[12][0-9]{3}"))
            this.yearMade = yearMade;
    }

    /**
     * Returns a string representation of the car object detail inforation.
     * 
     * @return the detail inforation
     */
    @Override
    public String toString()
    {
        return carReg + "," + yearMade + "," 
        + colour1 + "," + colour2 + "," 
        + colour3 + "," + carMake + "," 
        + carModel + "," + price;
    }

}