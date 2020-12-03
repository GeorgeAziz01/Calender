/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

/**
 * Class of Calender, basic OOP project
 * @author George Aziz
 */
public class Calender {

   private int year;
   private int months;
   private int days;

    public Calender() {
        this.year = 2020;
        this.months = 1;
        this.days = 1;
    }

    public Calender(int year, int months, int days) {
        this.year = year;
        this.months = months;
        this.days = days;
    }
    
    /**
     * Copy constructor
     * @param calender another calender
     */    
    public Calender(Calender calender) {
        this.year = calender.year;
        this.months = calender.months;
        this.days = calender.days;
    }
    
    /**
     * Checks if is a leap year or not 
     * @return a boolean value whether this year is a leap year or not 
     */
    public boolean isLeapYear(){
        return year % 4 == 0;
    }
    
    /**
     * Checks how many days are there in the current month 
     * @return the number of days that is in the current month
     */
    public int getDaysInMonth() {
        switch (months) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                if (isLeapYear())
                    return 29;
                else
                    return 28;
        }
    }
    
    /**
     * Increases the year 
     */
    public void increaseYear() {
        int nextYear = ++year;
        setYear(nextYear);
    } 
    
    /**
     * Increases the months
     */
    public void increaseMonth() {
            months = (months + 1) % 14;
            if (months == 13)
                months -=  12;
            if (months == 1)
                increaseYear();
    }
    
    /**
     * Increase the days 
     */
    public void increaseDays() {
        days = (days + 1);
        if (days == getDaysInMonth() + 1){
            increaseMonth();
            days = 0;
            ++days;
        } 
    }
    
    /**
     * Formats calender data to a string
     * @return formatted string containing calender data
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%d/%d/%d\n", days, months, year);
        
        return str;
    }

    public boolean equals(Calender calender) {
        return this.year == calender.year && 
                this.months == calender.months &&
                this.days == calender.days;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
