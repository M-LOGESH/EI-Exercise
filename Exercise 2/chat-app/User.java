public class User implements Observer {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(Message message) {
        // Message is printed by the Main class
    }

    public String getUsername() {
        return username;
    }
}
