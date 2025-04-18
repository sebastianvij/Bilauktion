package model;

public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private int year;
    private double basePrice;
    private String numberPlate;

    public Car(String brand, String model, int year, double basePrice, String numberPlate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
        this.numberPlate = numberPlate;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getNumberPlate() {
        return numberPlate;
    }
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.getYear(), this.getYear());
    }

    @Override
    public String toString() {
        return year + " " + brand + " " + model + ", " + numberPlate + " | Price: " + basePrice;
    }
}
