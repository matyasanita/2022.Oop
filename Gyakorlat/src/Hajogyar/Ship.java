package Hajogyar;

import java.util.Objects;

public class Ship implements Comparable<Ship> {
    private final String shipId;
    private String manufacturer;
    private String type;
    private int yearOfProfuction;
    private int price;
    private double weight;

    public Ship(String shipId, String manufacturer, String type, int yearOfProfuction, int price, double weight) {
        this.shipId = shipId;
        this.manufacturer = manufacturer;
        this.type = type;
        this.yearOfProfuction = yearOfProfuction;
        this.price = price;
        this.weight = weight;
    }

    public String getShipId() {
        return shipId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public int getYearOfProfuction() {
        return yearOfProfuction;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipId='" + shipId + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", yearOfProfuction=" + yearOfProfuction +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return this.shipId.equals(((Ship) o).shipId);
    }


    @Override
    public int compareTo(Ship o) {
        return this.yearOfProfuction - o.yearOfProfuction;
    }
}
