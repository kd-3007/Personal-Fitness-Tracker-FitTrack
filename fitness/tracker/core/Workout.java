package fitness.tracker.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Workout {
    private final String name;
    private final int duration;
    private final double intensity;
    private static final List<Workout> workoutLogs = new ArrayList<>();

    public Workout(String name, int duration, double intensity) {
        this.name = name;
        this.duration = duration;
        this.intensity = intensity;
        workoutLogs.add(this);
    }

    public abstract double calculateCaloriesBurned();

    public String getName() { return name; }
    public int getDuration() { return duration; }
    public double getIntensity() { return intensity; }

    public static List<Workout> getWorkoutLogs() {
        return workoutLogs;
    }
}
