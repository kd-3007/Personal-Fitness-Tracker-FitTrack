package fitness.tracker.core;

public class User {
    private String name;
    private double totalCalories;

    public User(String name, double totalCalories) {
        this.name = name;
        this.totalCalories = totalCalories;
    }

    public String getName() {
        return name;
    }

    public double getTotalCalories() {
        return totalCalories;
    }
}
