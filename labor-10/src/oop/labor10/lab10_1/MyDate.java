package oop.labor10.lab10_1;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    @Override
    public String toString(){
        return "Date: " + year + "/" + month + "/" + day;
    }

    @Override
    public int compareTo(MyDate that) {
        if (this.year == that.year){
            if (this.month == that.month){
                if (this.day == that.year)
                    return 0;
                return this.day - that.day;
            }
            return this.month - that.month;
        }
        return this.year - that.year;
    }


}
