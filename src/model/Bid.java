package model;

public class Bid {
    private String bidderName;
    private double amount;
    private Car car;

    public Bid(String bidderName, double amount, Car car) {
        this.bidderName = bidderName;
        this.amount = amount;
        this.car = car;
    }

    public String getBidderName() {
        return bidderName;
    }
    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Car getCar() {
        return car;
    }
}
