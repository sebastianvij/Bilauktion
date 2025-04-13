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
        //Opret biler
        Car car1 = new Car("Toyota", "Yaris", 2015, 139000, "AT97660");
        Car car2 = new Car("Kia", "Rio", 2016, 129000, "EG96979");
        Car car3 = new Car("Toyota", "Aygo", 2011, 98990, "CE27956");
        Car car4 = new Car("Tesla", "Model S", 2017, 409990, "AY66012");
        Car car5 = new Car("Reliant Motor", "Reliant Robin", 2001, 8000, "DN24347");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        List<Bid> bids = new ArrayList<>();
        bids.add(new Bid("Thor", 380999, car4));
        bids.add(new Bid("Isak", 390999, car4));
        bids.add(new Bid("Sebastian", 119000, car2));
        bids.add(new Bid("Oliver", 115999, car2));
        bids.add(new Bid("Osman", 7500, car5));
        bids.add(new Bid("Oskar", 6000, car5));

        System.out.println("Biler sorteret efter årgang:");
        Collections.sort(cars);
        printSortedCars(cars);

        System.out.println("Biler sorteret efter pris");
        Collections.sort(cars, new CarPriceComparator());
        printSortedCars(cars);

        System.out.println("Biler sorteret efter mærke");
        Collections.sort(cars, new CarBrandComparator());
        printSortedCars(cars);

        System.out.println();
        Collections.max(bids, new BidAmountComparator());
        

    }

    public static void printSortedCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getYear() + " " + car.getBrand() + " " + car.getModel() + "(" + car.getNumberPlate() + ") - " + car.getBasePrice() + " kr. ");
        }
    }
}