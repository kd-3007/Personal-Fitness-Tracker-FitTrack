package fitness.tracker.core;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nFitness Tracker Menu:");
            System.out.println("1. Log a Workout");
            System.out.println("2. View Logged Workouts");
            System.out.println("3. Show Total Calories Burned");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    logWorkout();
                    break;
                case 2:
                    viewLoggedWorkouts();
                    break;
                case 3:
                    showTotalCaloriesBurned();
                    break;
                case 4:
                    System.out.println("Exiting your personal Fitness Tracker");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void logWorkout() {
        System.out.print("Workout type (Running/Swimming/Weights): ");
        String name = scanner.next();
        System.out.print("Enter duration (in minutes): ");
        int duration = scanner.nextInt();
        System.out.print("Enter intensity (between 0.5 and 1.0): ");
        double intensity = scanner.nextDouble();

        switch (name.toLowerCase()) {
            case "running":
                System.out.print("Enter distance (in km): ");
                double distance = scanner.nextDouble();
                new RunningWorkout(name, duration, intensity, distance);
                break;
            case "swimming":
                System.out.print("Enter number of laps: ");
                int laps = scanner.nextInt();
                System.out.print("Enter stroke type: ");
                String strokeType = scanner.next();
                new SwimmingWorkout(name, duration, intensity, laps, strokeType);
                break;
            case "weights":
                System.out.print("Enter number of sets: ");
                int sets = scanner.nextInt();
                new WeightsWorkout(name, duration, intensity, sets);
                break;
            default:
                System.out.println("Invalid workout type. Please enter Running, Swimming, or Weights.");
        }
    }

    private void viewLoggedWorkouts() {
        List<Workout> workouts = Workout.getWorkoutLogs();
        if (workouts.isEmpty()) {
            System.out.println("No workouts logged yet.");
        } else {
            System.out.println("\nLogged Workouts:");
            for (Workout workout : workouts) {
                System.out.println("Workout: " + workout.getName() + ", Duration: " + workout.getDuration() + " min, Intensity: " + workout.getIntensity());
            }
        }
    }

    private void showTotalCaloriesBurned() {
        List<Workout> workouts = Workout.getWorkoutLogs();
        double totalCalories = 0;
        for (Workout workout : workouts) {
            totalCalories += workout.calculateCaloriesBurned();
        }
        System.out.println("Total Calories Burned: " + totalCalories);
    }
}
