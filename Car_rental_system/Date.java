/**
 * Date class ,this class represents a Date object
 * @author Tamir Shaoni
 * @version 23/11/2022
 */

public class Date
{
    private int _day;
    private int _month;
    private int _year;
    private final int DEAFULT_DAY = 1;
    private final int DEAFULT_MONTH = 1;
    private final int DEAFULT_YEAR = 2000;
    private final int MIN_YEAR = 999;
    private final int MAX_YEAR = 10000;
    private final int MIN_MONTH = 0;
    private final int MAX_MONTH = 13;
    private final int MIN_DAY = 0;
    private int maxDay = 32;

    /**
     * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     */

    public Date(int day, int month, int year)
    {
        if(validDate(day,month,year))
        {
            _day = day;
            _month = month;
            _year = year;
        }
        else
        {
            _day = DEAFULT_DAY;
            _month = DEAFULT_MONTH;
            _year = DEAFULT_YEAR;  
        }
    }

    /**
     * Copy constructor 
     * @param other the date to be copied
     */
    public Date(Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    /**
     * Check if the date is possible
     */
    private boolean validDate(int d, int m, int y)
    {
        if(y > MIN_YEAR && y < MAX_YEAR)
        {
            if(m > MIN_MONTH && m < MAX_MONTH) 
            {
                if(d > MIN_DAY && d < maxDay)
                {
                    switch(m) 
                    {
                            //  Long months
                        case 1: 
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12: return true;
                            //  Short months
                        case 4:
                        case 6:
                        case 9:
                        case 11:                     
                            maxDay = 31;
                            if(d < maxDay)
                                return true;
                            return false;
                            // February
                        case 2: 
                            if((y % 4 == 0 && y % 100 != 0 ) || (y % 400 == 0)) // Checking leap year
                            {
                                maxDay = 30;
                                if(d < maxDay)
                                    return true;
                            }
                            else
                                maxDay = 29;
                            if(d < maxDay)
                                return true;
                            return false;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * Gets the day
     * @return the day
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * Gets the month
     * @return the month
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * Gets the year
     * @return the year
     */
    public int getYear()
    {
        return _year;
    }

    /**
     * Set the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet)
    {
        if(validDate(dayToSet, _month, _year))
            _day = dayToSet;
    }

    /**
     * Set the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet)
    {
        if(validDate(_day,monthToSet,_year))
            _month = monthToSet;
    }

    /**
     * Set the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet)
    {
        if(validDate(_day,_month,yearToSet))
            _year = yearToSet;
    }

    /**
     * Check if 2 dates are the same
     * @param other the date to compare this date to
     * @return true if the date are the same, otherwise false
     */
    public boolean equals(Date other)
    {
        if(other._day == _day && other._month == _month && other._year == _year)
            return true;
        return false;
    }

    /**
     * Check if this date is before other date
     * @param other date to compare this date to
     * @return true if this date is before other date, otherwise false
     */
    public boolean before(Date other)
    {
        if(_year < other._year)
            return true;
        else if(_year == other._year)
        {
            if(_month < other._month)
                return true;
            else if(_month == other._month)
            {
                if(_day < other._day)
                    return true;
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * Check if this date is after other date
     * @param other date to compare this date to
     * @return true if this date is after other date, otherwise false
     */
    public boolean after(Date other)
    {
        if(_year > other._year)
            return true;
        else if(_year == other._year)
        {
            if(_month > other._month)
                return true;
            else if(_month == other._month)
            {
                if(_day > other._day)
                    return true;                                
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * Calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference(Date other)
    {
        int a = calculateDate(other._day, other._month, other._year);
        int b = calculateDate(_day, _month, _year);
        int diff = a-b;
        if(diff < 0)
            diff*=(-1);
        return diff;
    }

    /**
     * Returns a String that represents this date
     * @return String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
     */
    public String toString()
    {
        if(_day > 9)
        {
            if(_month > 9)
                return _day + "/" + _month + "/" + _year;
            else
                return _day + "/" + "0" + _month + "/" + _year;
        }
        else if(_month > 9)
            return "0" + _day + "/" + _month + "/" + _year;
        else 
            return "0" + _day + "/" + "0" + _month + "/" + _year;
    }

    /**
     * Calculate the date of tomorrow
     * @return the date of tomorrow
     */
    public Date tomorrow()
    {
        Date other;
        if(validDate(_day+1 , _month , _year))
            other = new Date(_day+1 , _month , _year);
        else if(_month != 12)
            other = new Date(DEAFULT_DAY , _month+1 , _year);
        else
            other = new Date(DEAFULT_DAY , DEAFULT_MONTH , _year+1); 
        return other;
    }

    /**
     * Computes the day number since the beginning of the Christian counting of years
     */
    private int calculateDate( int day, int month, int year)
    {
        if (month < 3)
        {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    } 
}