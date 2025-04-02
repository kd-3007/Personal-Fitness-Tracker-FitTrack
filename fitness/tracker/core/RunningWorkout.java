package fitness.tracker.core;

public class RunningWorkout extends Workout {
    private final double distance; // in kilometers

    public RunningWorkout(String name, int duration, double intensity, double distance) {
        super(name, duration, intensity);
        this.distance = distance;
    }

    @Override
    public double calculateCaloriesBurned() {
        double calories = distance * 60 * getIntensity();
        System.out.println("Workout: Running");
        System.out.println("Duration: " + getDuration() + " minutes");
        System.out.println("Intensity: " + getIntensity());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Calories Burned: " + calories);
        return calories;
    }
}