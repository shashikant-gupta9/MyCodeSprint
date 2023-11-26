import java.util.Random;

public class RandomJokeGenerator {
    public static void main(String[] args) {
        String[] jokes = {
            "Why don't scientists trust atoms? Because they make up everything!",
            "Did you hear about the mathematician who’s afraid of negative numbers? He’ll stop at nothing to avoid them!",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "How does a programmer open a jar? By using the jar's `jar` library!",
            "Why don't we tell secrets on a farm? Because the potatoes have eyes and the corn has ears!"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(jokes.length);

        String randomJoke = jokes[randomIndex];
        System.out.println("Random Joke: " + randomJoke);
    }
}
