import exceptions.InvalidBidException;
import exceptions.NoCarsException;
import BidComparators.BidAmountComparator;
import CarComparators.CarBrandComparator;
import CarComparators.CarPriceComparator;
import model.Bid;
import model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        runCarAuction();
    }

    private static void runCarAuction() {
        List<Car> cars = new ArrayList<>();
        List<Bid> bids = new ArrayList<>();

        //Opret biler
        Car car1 = new Car("Toyota", "Yaris", 2015, 139000, "AT97660");
        Car car2 = new Car("Kia", "Rio", 2016, 129000, "EG96979");
        Car car3 = new Car("Toyota", "Aygo", 2011, 98990, "CE27956");
        Car car4 = new Car("Tesla", "Model S", 2017, 409990, "AY66012");
        Car car5 = new Car("Reliant Motor", "Reliant Robin", 2001, 8000, "DN24347");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        try {
            addBid(bids, cars, "Thor", 380999, "AY66012");
            addBid(bids, cars, "Isak", 390999, "AY66012");
            addBid(bids, cars, "Sebastian", 119000, "EG96979");
            addBid(bids, cars, "Oliver", 115999, "EG96979");
            addBid(bids, cars, "Osman", 7500, "DN24347");
            addBid(bids, cars, "Oskar", 0, "DN24347"); // Invalidt bud
            addBid(bids, cars, "Stig", 10000, "XN23910"); // Ugyldig nummerplade
        } catch (InvalidBidException | NoCarsException e) {
            System.out.println("Fejl ved oprettelse af bud: " + e.getMessage());
        }

        System.out.println("Biler sorteret efter årgang:");
        Collections.sort(cars);
        printSortedCars(cars);

        System.out.println("Biler sorteret efter pris");
        Collections.sort(cars, new CarPriceComparator());
        printSortedCars(cars);

        System.out.println("Biler sorteret efter mærke");
        Collections.sort(cars, new CarBrandComparator());
        printSortedCars(cars);

        for (Car car : cars) {
            printHighestBid(car, bids);
        }
    }

    private static void addBid(List<Bid> bids, List<Car> cars, String bidderName, double amount, String numberPlate) throws InvalidBidException, NoCarsException {
        if (cars.isEmpty()) {
            throw new NoCarsException("Der er ingen tilgængelige biler i systemet.");
        }

        //Find bilen udfra nummerplade
        Car targetCar = null;
        for (Car car : cars) {
            if (car.getNumberPlate().equalsIgnoreCase(numberPlate)) {
                targetCar = car;
                break;
            }
        }

        if (targetCar == null) {
            throw new InvalidBidException("Nummerpladen '" + numberPlate + "' findes ikke");
        }

        if (amount <= 0) {
            throw new InvalidBidException("Buddet skal være større end 0 kr.");
        }
        bids.add(new Bid(bidderName, amount, targetCar));
        System.out.println(bidderName + " har budt " + amount + " på " + targetCar.getYear() + " " + targetCar.getBrand() + " " + targetCar.getModel());
    }

    private static void printHighestBid(Car car, List<Bid> bids) {
        List<Bid> bidsForCar = new ArrayList<>();
        for (Bid bid : bids) {
            if (bid.getCar().equals(car)) {
                bidsForCar.add(bid);
            }
        }

        if (bidsForCar.isEmpty()) {
            System.out.println("There are currently no bids on car: " +car);
            return;
        }

        bidsForCar.sort(new BidAmountComparator());
        Bid highestBid = bidsForCar.getFirst();
        System.out.println(highestBid.getBidderName() + " currently has the highest bid at " + highestBid.getAmount() + " on car: " + car);
    }

    private static void printSortedCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getYear() + " " + car.getBrand() + " " + car.getModel() + "(" + car.getNumberPlate() + ") - " + car.getBasePrice() + " kr. ");
        }
    }
}
