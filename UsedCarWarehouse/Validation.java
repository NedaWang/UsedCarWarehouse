import java.util.regex.*;
import java.util.*;

/**
 * The validation class is take resposible for verifying input validity.
 * 
 * @author (Miao Wang) 
 * @version (2.7)
 */
public class Validation
{
    private static final Pattern CAR_REG_PATTERN = Pattern.compile("[a-zA-Z0-9]{1,6}");
    //This pattern is also appropriate for car model.
    private static final Pattern CAR_MAKE_PATTERN = Pattern.compile("[a-zA-Z0-9]+");
    private static final Pattern AGE_PATTERN = Pattern.compile("[0-9]{1,3}");
    private static final Pattern PRICE_PATTERN = Pattern.compile("[1-9][0-9]{2,9}");
    private static final Pattern YEAR_MADE_PATTERN = Pattern.compile("[12][0-9]{3}");
    private static final Pattern COLOUR_PATTERN = Pattern.compile("[a-zA-Z]+[a-zA-Z\\s]+");
    private static final Pattern OTHER_COLOUR_PATTERN = Pattern.compile("[a-zA-Z\\s]*");
    private static final Pattern EDIT_OPTION_PATTERN = Pattern.compile("[12]");
    private Matcher matcher;

    /**
     * Validation for car age.
     * The age should be a positive number and less then 130.
     * 
     * @return car age validation result
     */
    public boolean ageValidate(String age)
    {
        matcher = AGE_PATTERN.matcher(age);
        if (matcher.matches())
        {
            if (Integer.parseInt(age) >= 130)
                return false;
        }
        return matcher.matches();
    }

    /**
     * Validation for car registration number.
     * The registration number should be consisted of english characters and numbers.
     * The length of registration number should between 1 and 6.
     * 
     * @return car registration number validation result
     */
    public boolean carRegValidate(String carReg)
    {
        matcher = CAR_REG_PATTERN.matcher(carReg);
        return matcher.matches();
    }

    /**
     * Validation for car make.
     * The car make should be consisted of english characters and numbers.
     * 
     * @return car make validation result
     */
    public boolean carMakeValidate(String carMake)
    {
        matcher = CAR_MAKE_PATTERN.matcher(carMake);
        return matcher.matches();
    }

    /**
     * Validation for car colour.
     * The colour should be consisted of english characters.
     * 
     * @return car colour validation result
     */
    public boolean colourValidate(String colour)
    {
        matcher = COLOUR_PATTERN.matcher(colour);
        return matcher.matches();
    }

    /**
     * Validation for edit option number.
     * The edit option number should be 1 or 2.
     * 
     * @return car edit option number
     */
    public boolean editOptionValidate(String option)
    {
        matcher = EDIT_OPTION_PATTERN.matcher(option);
        return matcher.matches();
    }    

    /**
     * Validation for the second or third colour.
     * The requiremrnt of the second or third colour are same with the first colour.
     * In addition, the second or third colour can be blank.
     * 
     * @return car second or third colour validation result
     */
    public boolean otherColourValidate(String colour)
    {
        matcher = OTHER_COLOUR_PATTERN.matcher(colour);
        return matcher.matches();
    }

    /**
     * Validation for minimum price and maximum price.
     * The maximum price must greater than minimum price.
     * 
     * @return minimum price and maximum price validation result
     */
    public boolean pricesValidate(String minPrice, String maxPrice)
    {
        return Integer.parseInt(maxPrice) > Integer.parseInt(minPrice);
    }

    /**
     * Validation for car price.
     * The price should be a positive number, 
     * greater than $100 and less then $1,000,000,000.
     * 
     * @return car price validation result
     */
    public boolean priceValidate(String price)
    {       
        matcher = PRICE_PATTERN.matcher(price);
        if (matcher.matches())
        {
            if (price.length() > 9)
                return false;
        }
        return matcher.matches();
    }

    /**
     * Validation for car made uear number.
     * The made year is reasonable from 1887 to the current year.
     * 
     * @return a string represent the made year number
     */
    public boolean yearMadeValidate(String yearMade)
    {
        matcher = YEAR_MADE_PATTERN.matcher(yearMade);
        if (matcher.matches())
        {
            if (Integer.parseInt(yearMade) < 1887 || 
            Integer.parseInt(yearMade) > Calendar.getInstance().get(Calendar.YEAR))
                return false;
        }
        return matcher.matches();
    }

}
