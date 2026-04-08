import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String number = "", type = "";
        int hours = 0;
        double fee = 0;

        int choice;

        do {
            System.out.println("\n===== Parking System =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            // ADD VEHICLE
            if (choice == 1) {

                System.out.print("Enter Vehicle Number: ");
                number = sc.next();

                System.out.print("Enter Type (bike/car/bus): ");
                type = sc.next();

                System.out.print("Enter Hours: ");
                hours = sc.nextInt();

                if (type.equalsIgnoreCase("bike")) {
                    fee = 10 * hours;
                } else if (type.equalsIgnoreCase("car")) {
                    fee = 20 * hours;
                } else if (type.equalsIgnoreCase("bus")) {
                    fee = 30 * hours;
                } else {
                    fee = 15 * hours;
                }

                System.out.println("Vehicle Added!");
            }

            // VIEW REPORT
            else if (choice == 2) {

                if (number.equals("")) {
                    System.out.println("No data available!");
                } else {
                    System.out.println("\n--- Report ---");
                    System.out.println("Vehicle Number: " + number);
                    System.out.println("Type: " + type);
                    System.out.println("Hours: " + hours);
                    System.out.println("Fee: ₹" + fee);
                }
            }

        } while (choice != 3);

        System.out.println("Thank you!");
        sc.close();
    }
}
