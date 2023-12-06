/**
 * Rent class, this class represents a Rent object
 * @author Tamir Shaoni
 * @version 23/11/2022
 */

public class Rent
{
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
    private final int WEEK = 7;
    private final int PRICE_A = 100;
    private final int PRICE_B = 150;
    private final int PRICE_C = 180;
    private final int PRICE_D = 240;
    private final double DISCOUNT = 0.9;
    private double price; 
    
    /**
     * Creates a new Rent object
     * <br>
     * The return date must be at least one day after the pickup date, otherwise set it to one day after the pick up date.
     * @param name the client's name
     * @param car the rented car
     * @param pick the pickup date
     * @param ret the return date
     */ 
    public Rent(String name, Car car, Date pick, Date ret)
    {
        _name = new String(name);
        _car = new Car(car);
        _pickDate = new Date(pick);
        if(ret.after(pick))
            _returnDate = new Date(ret);
        else
            _returnDate = new Date(pick.tomorrow());
    }

    /**
     * Copy constructor
     * @param other the rent to be copied
     */
    public Rent(Rent other)
    {
        _name = new String(other._name);
        _car = new Car(other._car);     
        _pickDate = new Date(other._pickDate);
        _returnDate = new Date(other._returnDate);
    }

    /**
     * Check if 2 rents are the same
     * @param other the rent to compare this rent to
     * @return true if the rents are the same 
     */
    public boolean equals(Rent other)
    {
        if(other._name.equals(_name) && other._pickDate.equals(_pickDate) && other._returnDate.equals(_returnDate) && other._car.equals(_car))
            return true;
        return false;
    }

    /**
     * Gets the car
     * @return the car
     */
    public Car getCar()
    {
        return new Car(_car);
    }

    /**
     * Gets the name
     * @return the name
     */
    public String getName()
    {
        return new String(_name);
    }

    /**
     * Gets the pick up date
     * @return the pick up date
     */
    public Date getPickDate()
    {
        return new Date(_pickDate);
    }

    /**
     * Gets the return date
     * @return the return date
     */
    public Date getReturnDate()
    {
        return new Date(_returnDate);
    }

    /**
     * Returns the rent total price
     * @return the rent total price
     */
    public int getPrice()
    {  

        if(_car.getType() == 'A')
        {
            price = (howManyDays() / WEEK) * WEEK * PRICE_A * DISCOUNT;
            price += (howManyDays() % WEEK) * PRICE_A;
        }
        if(_car.getType() == 'B')
        {
            price = (howManyDays() / WEEK) * WEEK * PRICE_B * DISCOUNT;
            price += (howManyDays() % WEEK) * PRICE_B;
        }
        if(_car.getType() == 'C')
        {
            price = (howManyDays() / WEEK) * WEEK * PRICE_C * DISCOUNT;
            price += (howManyDays() % WEEK) * PRICE_C;
        }
        if(_car.getType() == 'D')
        {
            price = (howManyDays() / WEEK) * WEEK * PRICE_D * DISCOUNT;
            price += (howManyDays() % WEEK) * PRICE_D;
        }
        return (int)price;
    }

    /**
     * Sets the client name
     * @param name the client name (You can assume that the name is a valid name)
     */
    public void setName(String name)
    {
        _name = new String(name);
    }

    /**
     * Sets the rented car
     * @param car the rented car (You can assume that car is not null)
     */
    public void setCar(Car car)
    {
        _car = new Car(car);
    }

    /**
     * Sets the pick up date
     * <br>
     * The pick up date must be at least one day before the return date, otherwise - don't change the pick up date
     * @param pickDate the pick up date (You can assume that pick up date is not null) 
     */
    public void setPickDate(Date pickDate)
    {
        if(pickDate.before(_returnDate))
            _pickDate = new Date(pickDate);
    }

    /**
     * Sets the return date
     * <br>
     * The return date must be at least one day after the pick up date, otherwise - don't change the return date
     * @param returnDate the return date (You can assume that return date is not null)
     */
    public void setReturnDate(Date returnDate)
    {
        if(returnDate.after(_pickDate))
            _returnDate = new Date(returnDate);
    }

    /**
     * Returns the number of rent days
     * @return the number of rent days
     */
    public int howManyDays()
    {
        return _returnDate.difference(_pickDate);
    }

    /**
     * Try to upgrade the car to a better car
     * <br>
     * If the given car is better than the current car of the rent, upgrade it and return the upgrade additional cost, otherwise - don't upgrade
     * @param car the car to upgrade to
     * @return the upgrade cost
     */
    public int upgrade(Car newCar)
    {
        if(newCar.better(_car))
        {
            int oldPrice = getPrice();
            _car = new Car(newCar);
            return getPrice() - oldPrice;
        }
        return 0;
    }

    /**
     * Check if there is a double listing of a rent for the same person and car with an overlap in the rental days
     * <br>
     * If there is - return a new rent object with the unified dates, otherwise - return null.
     * @param other the other rent
     * @return the unified rent or null
     */
    public Rent overlap(Rent other)
    {
        if(other._name.equals(_name) || other._car.equals(_car))
        {

            if(other._pickDate.after(_returnDate))
                return null;
            other.setPickDate(_pickDate);
            if(_returnDate.after(other._returnDate))
                other.setReturnDate(_returnDate);
            return other;
        }
        return null;
    }

    /**
     * Returns a String that represents this rent
     * @return String that represents this rent in the following format:
     * <br>
     * Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
     */
    public String toString()
    {
        return "Name:"+ _name + " From:" + _pickDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice();
    }
}