package notifier;

public class PigeonNotifierAdapter implements Notifier {
    private PigeonNotifier pigeonNotifier;

    public PigeonNotifierAdapter() {
        this.pigeonNotifier = new PigeonNotifier();
    }

    @Override
    public void notify(String recipient, String message) {
        pigeonNotifier.sendPigeon(recipient, 1, message); // Примерно зададен номер на гълъба
    }
}

