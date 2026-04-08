import java.util.ArrayList;
import java.util.Scanner;

// Class to store vehicle details
class Vehicle {
    String vehicleNumber;
    String vehicleType;
    int hours;
    double fee;

    Vehicle(String vehicleNumber, String vehicleType, int hours, double fee) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.hours = hours;
        this.fee = fee;
    }
}

public class ParkingSystem {

    static ArrayList<Vehicle> records = new ArrayList<>();

    // Method to calculate fee
    public static double calculateFee(String type, int hours) {
        double rate = 0;

        if (type.equalsIgnoreCase("bike")) {
            rate = 10;
        } else if (type.equalsIgnoreCase("car")) {
            rate = 20;
        } else if (type.equalsIgnoreCase("bus")) {
            rate = 30;
        } else {
            System.out.println("Unknown vehicle type. Default rate applied.");
            rate = 15;
        }

        return rate * hours;
    }

    // Add vehicle entry
    public static void addVehicle(Scanner sc) {
        System.out.print("Enter Vehicle Number: ");
        String number = sc.next();

        System.out.print("Enter Vehicle Type (bike/car/bus): ");
        String type = sc.next();

        System.out.print("Enter Parking Hours: ");
        int hours = sc.nextInt();

        double fee = calculateFee(type, hours);

        records.add(new Vehicle(number, type, hours, fee));

        System.out.println("✅ Vehicle Added Successfully! Fee: ₹" + fee);
    }

    // Generate report
    public static void generateReport() {
        if (records.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        double totalRevenue = 0;

        System.out.println("\n--- Parking Report ---");
        System.out.printf("%-15s %-10s %-10s %-10s\n",
                "Vehicle No", "Type", "Hours", "Fee");

        for (Vehicle v : records) {
            System.out.printf("%-15s %-10s %-10d %-10.2f\n",
                    v.vehicleNumber, v.vehicleType, v.hours, v.fee);
            totalRevenue += v.fee;
        }

        System.out.println("------------------------------");
        System.out.println("Total Vehicles: " + records.size());
        System.out.println("Total Revenue: ₹" + totalRevenue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Parking System =====");
            System.out.println("1. Add Vehicle Entry");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addVehicle(sc);
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
