import java.util.*;

public class DesktopMessageData {
    private int desktopId;
    private LinkedList<String> recentMessages = new LinkedList<>();
    private LinkedList<String> historyMessages = new LinkedList<>();

    public DesktopMessageData(int desktopId) {
        this.desktopId = desktopId;
    }

    public int getDesktopId() {
        return desktopId;
    }

    public void storeMessage(String message) {
        if (recentMessages.size() >= 10) {
            String oldest = recentMessages.removeFirst();
            if (historyMessages.size() >= 1000) {
                historyMessages.removeFirst(); // Drop oldest history
            }
            historyMessages.add(oldest);
        }
        recentMessages.add(message);
    }

    public List<String> getRecentMessages() {
        return new ArrayList<>(recentMessages);
    }

    public List<String> getHistoryMessages() {
        return new ArrayList<>(historyMessages);
    }
}
