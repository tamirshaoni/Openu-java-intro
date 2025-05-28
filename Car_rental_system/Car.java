/**
 * Car class, this class represents a Car object
 * @author Tamir Shaoni
 * @version 23/11/2022
 */

public class Car
{
    private int _id;    
    private char _type;
    private String _brand;
    private boolean _isManual;
    private String gear;
    private final int MIN_ID = 999999;
    private final int MAX_ID = 10000000;
    private final int DEAFULT_ID = 9999999;

    /**
     * Creates a new Car object
     * <br>
     * id should be a 7 digits number, otherwise set it to 9999999
     * <br>
     * type should be 'A','B','C' or 'D', otherwise set it to 'A'
     */
    public Car(int id, char type, String brand, boolean isManual)
    {
        if(id > MIN_ID && id < MAX_ID)
            _id = id;
        else
            _id = DEAFULT_ID;   
        if(type >= 'A' && type <= 'D')
            _type = type;
        else
            _type = 'A';
        _brand = brand;
        _isManual = isManual;
    }

    /**
     * Copy constructor
     */
    public Car(Car other)
    {
        _id = other._id;
        _type = other._type;
        _brand = other._brand;
        _isManual = other._isManual;
    }

    /**
     * Gets the id
     * @return the id
     */
    public int getId()  
    {
        return _id;
    }

    /**
     * Gets the type
     * @return the type
     */
    public char getType() 
    {
        return _type;
    }

    /**
     * Gets the brand
     * @return the brand
     */
    public String getBrand() 
    {
        return _brand;
    }

    /**
     * Gets the isManual flag
     * @return the isManual flag
     */
    public boolean isManual()
    {
        return _isManual;
    }

    /**
     * Sets the id (only if the given id is valid)
     * @param id the id value to be set
     */
    public void setId(int id)
    {       
        if(id > MIN_ID && id < MAX_ID)
            _id = id;
        else
            _id = DEAFULT_ID;
    }

    /**
     * Sets the type (only if the given type is valid)
     * @param type the type value to be set
     */
    public void setType(char type)
    {
        if(type >= 'A' && type <= 'D')
            _type = type;
        else
            _type = 'A';
    }

    /**
     * Sets the brand of the car
     * @param brand the brand value to be set
     */
    public void setBrand(String brand)
    {
        _brand = brand;
    }

    /**
     * Sets the isManual flag of the car
     * @param isManual the isManual flag to be set
     */
    public void setIsManual(boolean isManual)
    {
        _isManual = isManual;
    }

    /**
     * Returns a String object that represents this car
     * @return String that represents this car in the following format:
     * <br>
     * id:1234567 type:B brand:Toyota gear:manual (or auto)
     */
    public String toString()
    {
        if(_isManual)
            gear = "manual";
        else
            gear = "auto";
        return "id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + gear; 
    }

    /**
     * Check if two cars are the same
     * <br>
     * Cars are considered the same if they have the same type, brand and gear
     * @param other the car to compare this car to
     * @return true if the cars are the same, otherwise false
     */
    public boolean equals(Car other)
    {
        if(_type == other._type && _brand.equals(other._brand) && _isManual == other._isManual)
            return true;
        return false;
    }

    /**
     * Check if this car is better than the other car
     * <br>
     * A car is considered better than another car if its type is higher.
     * <br>
     * If both cars have the same type, an automated car is better than a manual car.
     * @param other the car to compare this car to
     * @return true if this car is better than the other car, otherwise false
     */
    public boolean better(Car other)
    {
        if(_type > other._type)
            return true;
        else if(_type == other._type)
        {
            if(_isManual == false && other._isManual == true)
                return true;
        }
        return false;
    }

    /**
     * Check if this car is worse than the other car
     * @param other car to compare this car to
     * @return true if this car is worse than the other car, otherwise false
     */
    public boolean worse(Car other)
    {
        if(better(other))
            return false;
        return true;
    }
}