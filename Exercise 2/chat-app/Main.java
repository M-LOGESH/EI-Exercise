import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Chat Room ID
        System.out.print("Enter Chat Room ID: ");
        String roomId = scanner.nextLine();

        // Create Chat Room
        ChatRoomManager manager = ChatRoomManager.getInstance();
        ChatRoom chatRoom = manager.createChatRoom(roomId);

        // Input for Active Users
        System.out.print("Enter Active Users (comma-separated): ");
        String userInput = scanner.nextLine();
        String[] users = userInput.split("\\s*,\\s*"); // Handle comma and optional spaces
        List<User> userList = new ArrayList<>();
        for (String username : users) {
            User user = new User(username.trim());
            chatRoom.addObserver(user);
            chatRoom.addUser(username.trim());
            userList.add(user);
        }

        // Input for Messages
        System.out.println("Enter Messages (type 'done' to finish): ");
        while (true) {
            String messageContent = scanner.nextLine();
            if (messageContent.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter username for the message: ");
            String username = scanner.nextLine().trim();
            chatRoom.sendMessage(new Message(username, messageContent));
        }

        // Output Active Users and Messages
        System.out.println("Active Users: " + chatRoom.getActiveUsers().stream().collect(Collectors.toList()));
        System.out.println("Chat Messages:");
        for (Message message : chatRoom.getMessages()) {
            System.out.println(message);
        }

        scanner.close();
    }
}
