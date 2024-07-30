import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private final String roomId;
    private final List<Observer> observers = new ArrayList<>();
    private final List<Message> messages = new ArrayList<>();
    private final List<String> activeUsers = new ArrayList<>();

    public ChatRoom(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void sendMessage(Message message) {
        messages.add(message);
        notifyObservers(message);
    }

    private void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addUser(String username) {
        if (!activeUsers.contains(username)) {
            activeUsers.add(username);
        }
    }

    public void removeUser(String username) {
        activeUsers.remove(username);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<String> getActiveUsers() {
        return new ArrayList<>(activeUsers);
    }
}
