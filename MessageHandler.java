import java.util.*;

public class MessageHandler {
    private List<DesktopMessageData> desktopList = new ArrayList<>();

    private DesktopMessageData findDesktop(int id) {
        for (DesktopMessageData d : desktopList) {
            if (d.getDesktopId() == id) return d;
        }
        return null;
    }

    public void storeMessage(String message, int desktopId) {
        DesktopMessageData desktop = findDesktop(desktopId);
        if (desktop == null) {
            desktop = new DesktopMessageData(desktopId);
            desktopList.add(desktop);
        }
        desktop.storeMessage(message);
    }

    public List<String> getRecentMessages(int desktopId) {
        DesktopMessageData desktop = findDesktop(desktopId);
        return (desktop != null) ? desktop.getRecentMessages() : new ArrayList<>();
    }

    public List<String> getHistoryMessages(int desktopId) {
        DesktopMessageData desktop = findDesktop(desktopId);
        return (desktop != null) ? desktop.getHistoryMessages() : new ArrayList<>();
    }
}
