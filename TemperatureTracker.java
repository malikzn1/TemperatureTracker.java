import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        while (true) {
            System.out.println("Enter a day of the week (Monday through Sunday) or type 'week' to see all temperatures and the weekly average:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("week")) {
                if (days.isEmpty()) {
                    System.out.println("No data available.");
                } else {
                    double totalTemperature = 0.0;
                    System.out.println("Day\tTemperature");
                    for (int i = 0; i < days.size(); i++) {
                        System.out.println(days.get(i) + "\t" + temperatures.get(i));
                        totalTemperature += temperatures.get(i);
                    }
                    double weeklyAverage = totalTemperature / days.size();
                    System.out.println("Weekly average temperature: " + weeklyAverage);
                }
                break;
            } else if (isValidDay(input)) {
                System.out.println("Enter the average temperature for " + input + ":");
                double temperature = Double.parseDouble(scanner.nextLine());
                days.add(input);
                temperatures.add(temperature);
            } else {
                System.out.println("Invalid day. Please enter a valid day of the week or 'week'.");
            }
        }
        scanner.close();
    }

    private static boolean isValidDay(String day) {
        String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String validDay : validDays) {
            if (day.equalsIgnoreCase(validDay)) {
                return true;
            }
        }
        return false;
    }
}
