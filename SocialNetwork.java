import java.util.*;

class User {
    private String username;
    private Set<User> friends;

    public User(String username) {
        this.username = username;
        this.friends = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void addFriend(User friend) {
        friends.add(friend);
        friend.friends.add(this); // Mutual friendship
    }

    public void displayFriends() {
        System.out.println("Friends of " + username + ":");
        for (User friend : friends) {
            System.out.println("- " + friend.getUsername());
        }
    }
}

public class SocialNetwork {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        user1.addFriend(user2);
        user1.addFriend(user3);
        user2.addFriend(user3);

        System.out.println(user1.getUsername() + "'s friends:");
        user1.displayFriends();

        System.out.println(user2.getUsername() + "'s friends:");
        user2.displayFriends();

        System.out.println(user3.getUsername() + "'s friends:");
        user3.displayFriends();
    }
}
