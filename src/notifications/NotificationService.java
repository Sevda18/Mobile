package notifications;

import notifier.Notifier;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Notifier> notifiers;

    public NotificationService() {
        this.notifiers = new ArrayList<>();
    }

    public NotificationService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void addNotifier(Notifier notifier) {
        this.notifiers.add(notifier);
    }

    public void sendNotification(String recipient, String message) {
        for (Notifier notifier : notifiers) {
            notifier.notify(recipient, message);
        }
    }
}