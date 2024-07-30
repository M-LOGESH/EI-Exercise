import java.util.HashMap;
import java.util.Map;

public class ChatRoomManager {
    private static ChatRoomManager instance;
    private final Map<String, ChatRoom> chatRooms = new HashMap<>();

    private ChatRoomManager() {
    }

    public static synchronized ChatRoomManager getInstance() {
        if (instance == null) {
            instance = new ChatRoomManager();
        }
        return instance;
    }

    public ChatRoom createChatRoom(String roomId) {
        ChatRoom chatRoom = new ChatRoom(roomId);
        chatRooms.put(roomId, chatRoom);
        return chatRoom;
    }

    public ChatRoom getChatRoom(String roomId) {
        return chatRooms.get(roomId);
    }
}
