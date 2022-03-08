package extra1;

public class Car {
    //Ami biztosan nem változik legyen final
    private String carType;
    private int numberOfKilometers;
    private final int yearOfManufacture;
    private String carBrand;
    private final int maxPassangers;
    private int speed;
    private Color color;
    private FuelType fuelType;

    public void moveCar(int kilometers){
        if (kilometers > 0 ) {
            numberOfKilometers += kilometers;
        }
    }

    public void changeSpeed(int speedIndicator){
        if(speedIndicator > 0) speed += speedIndicator;
        else{
            speed -= speedIndicator;
            if (speed < 0) speed = 0;
        }
    }

    public void resetMileage(){
        if(numberOfKilometers >= 200) numberOfKilometers = 0;
    }

    //getters
    public int getNumberOfKilometers(){
        return numberOfKilometers;
    }
    public String getCarType(){
        return carType;
    }
    public int getSpeed(){
        return speed;
    }
    public FuelType getFuelType(){
        return fuelType;
    }
    public Color getColor(){
        return color;
    }
    public int getMaxPassangers(){
        return maxPassangers;
    }
    public String getCarBrand(){
        return getCarBrand();
    } //Vigyázat ez végtelen ciklus
    public int getYearOfManufacture(){
        return yearOfManufacture;
    }

    //setter
    public void setColor(Color color){
        this.color = color;
    }

    //constructors
    Car(String carType, String carBrand, Color color, FuelType fuelType, int numberOfKilometers, int maxPassangers, int yearOfManufacture){
        this.carType = carType;
        this.carBrand = carBrand;
        this.color = color;
        this.fuelType = fuelType;
        this.numberOfKilometers = numberOfKilometers;
        this.maxPassangers = maxPassangers;
        this.yearOfManufacture = yearOfManufacture;
    }

    Car(String carBrand, String carType, int fuelValue, boolean familyCar, int yearOfManufacture){
        this.carType = carType;
        this.carBrand = carBrand;
        this.speed = 0;
        this.numberOfKilometers = 0;
        this.yearOfManufacture = yearOfManufacture;


        if(familyCar)
            this.maxPassangers = 5;
        else
            this.maxPassangers = 2;


        switch (fuelValue) {
            case 0 -> this.fuelType = FuelType.DIESEL;
            case 1 -> this.fuelType = FuelType.PETROL;
            case 2 -> this.fuelType = FuelType.GAS;
            case 3 -> this.fuelType = FuelType.ELECTRIC;
            default -> this.fuelType = FuelType.HYBRID;
        }

        if(carBrand.charAt(0) == 'R')
            this.color = Color.RED;
        else if (carBrand.charAt(0) == 'G')
            this.color = Color.GREEN;
        else if (carBrand.charAt(0) == 'B')
            this.color = Color.BLUE;
        else if (carBrand.charAt(0) == 'W')
            this.color = Color.WHITE;
        else
            this.color = Color.BLACK;
    }

    @Override
    public String toString(){
        String ret_value = carBrand + " " + carType + " ";
        if (maxPassangers == 5)
            ret_value += "family car, ";
        else
            ret_value += "two-seater car, ";
        ret_value += "manifactured in " + yearOfManufacture + ".\n";
        ret_value += "Properties:\nCOLOR: " + color + "\nFUEL: " + fuelType + "\nKMs traveled: " + numberOfKilometers;
        return ret_value;

    }
}
