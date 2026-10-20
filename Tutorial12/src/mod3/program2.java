package mod3;


import java.util.Scanner;

class InvalidReservationException extends Exception {
    public InvalidReservationException(String message) {
        super(message);
    }
}

class HotelRoom {

    private int availableSlots = 20;

    public void reserveRooms(int slots)
            throws InvalidReservationException {

        if (slots <= 0) {
            throw new InvalidReservationException(
                "Number of reservation slots must be positive."
            );
        }

        if (slots > availableSlots) {
            System.out.println("Not enough rooms available.");
            return;
        }

        availableSlots = availableSlots - slots;

        System.out.println("Reservation successful!");
        System.out.println("Rooms reserved: " + slots);
        System.out.println("Available rooms: " + availableSlots);
    }
}

public class program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelRoom hotel = new HotelRoom();

        try {
            System.out.print("Enter number of rooms to reserve: ");
            int slots = sc.nextInt();

            hotel.reserveRooms(slots);

        } catch (InvalidReservationException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
