package fitness.tracker.core;

import java.util.List;
import java.util.Scanner;

public class FitnessTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Running fitness tests...");
        testValidWorkoutLogging();
        testInvalidIntensityHandling();
        testGoalAchievement();
        testCommunityChallenge();
        testTotalCaloriesBurned();
        
        scanner.close();
    }

    private static void testValidWorkoutLogging() {
        System.out.println("\n[Test 1] Valid Workout Logging");
        Workout workout = new RunningWorkout("Running", 30, 0.8, 5.0);
        System.out.println("Workout successfully logged: " + workout.getName());
    }

    private static void testInvalidIntensityHandling() {
        System.out.println("\n[Test 2] Invalid Intensity Handling");
        double intensity = 1.5; // Invalid intensity
        try {
            Workout workout = new RunningWorkout("Running", 30, intensity, 5.0);
            System.out.println("Error: Intensity validation failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught invalid intensity: " + e.getMessage());
        }
    }

    private static void testGoalAchievement() {
        System.out.println("\n[Test 3] Goal Achievement Check");
        double goal = 300;
        Workout workout = new RunningWorkout("Running", 45, 0.9, 7.0);
        double caloriesBurned = workout.calculateCaloriesBurned();
        System.out.println("Calories burned: " + caloriesBurned);
        System.out.println(caloriesBurned >= goal ? "Goal achieved!" : "Keep pushing to reach your goal.");
    }

    private static void testCommunityChallenge() {
        System.out.println("\n[Test 4] Community Challenge Bonus");
        int communityMinutes = 1200;
        int challengeGoal = 1000;
        System.out.println(communityMinutes >= challengeGoal ? "Community challenge completed! Bonus unlocked." : "Keep working together to complete the challenge.");
    }

    private static void testTotalCaloriesBurned() {
        System.out.println("\n[Test 5] Total Calories Burned");
        new RunningWorkout("Running", 30, 0.8, 5.0);
        new SwimmingWorkout("Swimming", 40, 0.7, 10, "Freestyle");
        new WeightsWorkout("Weights", 50, 0.9, 4);
        
        List<Workout> workouts = Workout.getWorkoutLogs();
        double totalCalories = 0;
        for (Workout workout : workouts) {
            totalCalories += workout.calculateCaloriesBurned();
        }
        System.out.println("Total Calories Burned: " + totalCalories);
    }
}
