package fitness.tracker.core;

public class SwimmingWorkout extends Workout {
    private final int laps;
    private final String strokeType;

    public SwimmingWorkout(String name, int duration, double intensity, int laps, String strokeType) {
        super(name, duration, intensity);
        this.laps = laps;
        this.strokeType = strokeType;
    }

    @Override
    public double calculateCaloriesBurned() {
        double calories = laps * 10 * getIntensity();
        System.out.println("Workout: Swimming");
        System.out.println("Duration: " + getDuration() + " minutes");
        System.out.println("Intensity: " + getIntensity());
        System.out.println("Laps: " + laps);
        System.out.println("Stroke Type: " + strokeType);
        System.out.println("Calories Burned: " + calories);
        return calories;
    }
}