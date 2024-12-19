package notifier;

public class EmailNotifierAdapter implements Notifier {
    private EmailNotifier emailNotifier;

    public EmailNotifierAdapter() {
        this.emailNotifier = new EmailNotifier();
    }

    @Override
    public void notify(String recipient, String message) {
        emailNotifier.sendEmail(recipient, "Notification", message);
    }
}

