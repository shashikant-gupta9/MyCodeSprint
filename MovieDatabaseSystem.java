import java.util.*;

class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;

    public Movie(String title, String genre, int releaseYear, double rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

class MovieDatabase {
    private List<Movie> movies;

    public MovieDatabase() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String genre, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, genre, releaseYear, rating);
        movies.add(newMovie);
        System.out.println("Movie added to the database!");
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available in the database.");
        } else {
            System.out.println("Movie Database:");
            for (Movie movie : movies) {
                System.out.println("Title: " + movie.getTitle() + " | Genre: " + movie.getGenre()
                        + " | Release Year: " + movie.getReleaseYear() + " | Rating: " + movie.getRating());
            }
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Movie found:");
                System.out.println("Title: " + movie.getTitle() + " | Genre: " + movie.getGenre()
                        + " | Release Year: " + movie.getReleaseYear() + " | Rating: " + movie.getRating());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie not found!");
        }
    }

    public void searchByGenre(String genre) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("Title: " + movie.getTitle() + " | Genre: " + movie.getGenre()
                        + " | Release Year: " + movie.getReleaseYear() + " | Rating: " + movie.getRating());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found in this genre!");
        }
    }

    public void updateRating(String title, double newRating) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movie.setRating(newRating);
                System.out.println("Rating updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie not found! Rating not updated.");
        }
    }
}

public class MovieDatabaseSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDatabase movieDatabase = new MovieDatabase();

        boolean running = true;

        while (running) {
            System.out.println("\nMovie Database System");
            System.out.println("1. Add Movie");
            System.out.println("2. Display Movies");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Genre");
            System.out.println("5. Update Rating");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int releaseYear = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating = scanner.nextDouble();
                    movieDatabase.addMovie(title, genre, releaseYear, rating);
                    break;
                case 2:
                    movieDatabase.displayMovies();
                    break;
                case 3:
                    System.out.print("Enter movie title to search: ");
                    String searchTitle = scanner.nextLine();
                    movieDatabase.searchByTitle(searchTitle);
                    break;
                case 4:
                    System.out.print("Enter movie genre to search: ");
                    String searchGenre = scanner.nextLine();
                    movieDatabase.searchByGenre(searchGenre);
                    break;
                case 5:
                    System.out.print("Enter movie title to update rating: ");
                    String movieTitle = scanner.nextLine();
                    System.out.print("Enter new rating: ");
                    double newRating = scanner.nextDouble();
                    movieDatabase.updateRating(movieTitle, newRating);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Movie Database System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}
