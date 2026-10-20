package mod3;


import java.util.Scanner;

abstract class Vehicle {
    int vehicleId;
    String vehicleName;
    double rentalPricePerDay;

    Vehicle(int vehicleId, String vehicleName,
            double rentalPricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    abstract double calculateRentalAmount(int days);

    void displayVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Price per day: " + rentalPricePerDay);
    }
}

interface Displayable {
    void showDetails(int days);
}

class Car extends Vehicle implements Displayable {

    Car(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateRentalAmount(int days) {
        double amount = rentalPricePerDay * days;

        if (days > 5) {
            amount = amount - (amount * 0.10);
        }

        return amount;
    }

   
    public void showDetails(int days) {
        displayVehicleDetails();
        System.out.println("Days rented: " + days);
        System.out.println("Total rental amount: "
                + calculateRentalAmount(days));
    }
}

class Bike extends Vehicle implements Displayable {

    Bike(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateRentalAmount(int days) {
        double amount = rentalPricePerDay * days;

        if (days > 3) {
            amount = amount - (amount * 0.05);
        }

        return amount;
    }

  
    public void showDetails(int days) {
        displayVehicleDetails();
        System.out.println("Days rented: " + days);
        System.out.println("Total rental amount: "
                + calculateRentalAmount(days));
    }
}

public class program2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car car = new Car(101, "Car", 2000);
        Bike bike = new Bike(102, "Bike", 500);

        System.out.print("Enter number of days for car: ");
        int carDays = sc.nextInt();

        System.out.print("Enter number of days for bike: ");
        int bikeDays = sc.nextInt();

        System.out.println("\n--- Car Details ---");
        car.showDetails(carDays);

        System.out.println("\n--- Bike Details ---");
        bike.showDetails(bikeDays);

        sc.close();
    }
}

