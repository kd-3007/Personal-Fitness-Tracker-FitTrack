package fitness.tracker.core;

import java.util.List;
import java.util.ArrayList;

public class CommunityChallenge {
    private static final double GROUP_BONUS = 1.15;
    private final List<User> participants = new ArrayList<>();

    public void joinChallenge(User user) {
        if (user == null) {
            System.out.println("Invalid user! Cannot join the challenge.");
            return;
        }

        if (!participants.contains(user)) {
            participants.add(user);
            System.out.println(user.getName() + " joined the community challenge! Group bonus activated.");
            System.out.println("Total participants: " + participants.size());
        } else {
            System.out.println(user.getName() + " is already in the challenge.");
        }
    }

    public double calculateGroupCalories() {
        if (participants.isEmpty()) {
            System.out.println("No participants in the challenge yet.");
            return 0.0;
        }

        double totalCalories = participants.stream()
            .mapToDouble(User::getTotalCalories)
            .sum();

        double finalCalories = totalCalories * GROUP_BONUS;
        System.out.printf("Total Group Calories (with bonus): %.2f%n", finalCalories);
        return finalCalories;
    }
}
