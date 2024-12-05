import java.util.List;

public class NotificationService {
    private List<Notifier> notifiers;

    public NotificationService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void sendNotification(String recipient, String message) {
        for (Notifier notifier : notifiers) {
            notifier.notify(recipient, message);
        }
    }
}

