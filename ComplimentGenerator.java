import java.util.Random;

public class ComplimentGenerator {

    private static final String[] compliments = {
            "You're amazing!",
            "You're doing great!",
            "You're a star!",
            "You make a positive impact!",
            "You're awesome!",
            "Keep up the good work!",
            "You've got this!",
            "You're a true inspiration!"
    };

    public static void main(String[] args) {
        System.out.println("Welcome to the Compliment Generator!");
        System.out.println("Here's a compliment for you:");

        String randomCompliment = getRandomCompliment();
        System.out.println(randomCompliment);
    }

    private static String getRandomCompliment() {
        Random random = new Random();
        int index = random.nextInt(compliments.length);
        return compliments[index];
    }
}
