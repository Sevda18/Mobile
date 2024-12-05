public class SmsNotifierAdapter implements Notifier {
    private SmsNotifier smsNotifier;

    public SmsNotifierAdapter() {
        this.smsNotifier = new SmsNotifier();
    }

    @Override
    public void notify(String recipient, String message) {
        smsNotifier.sendSms(recipient, message);
    }
}

