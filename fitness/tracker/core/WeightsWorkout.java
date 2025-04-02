package fitness.tracker.core;

public class WeightsWorkout extends Workout {
    private final int sets;

    public WeightsWorkout(String name, int duration, double intensity, int sets) {
        super(name, duration, intensity);
        this.sets = sets;
    }

    @Override
    public double calculateCaloriesBurned() {
        double calories = sets * 15 * getIntensity();
        System.out.println("Workout: Weights");
        System.out.println("Duration: " + getDuration() + " minutes");
        System.out.println("Intensity: " + getIntensity());
        System.out.println("Sets: " + sets);
        System.out.println("Calories Burned: " + calories);
        return calories;
    }
}