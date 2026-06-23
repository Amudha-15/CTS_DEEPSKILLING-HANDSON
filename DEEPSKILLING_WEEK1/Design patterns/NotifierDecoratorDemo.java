interface Notifier { void send(String message); }

class EmailNotifier implements Notifier { public void send(String message){ System.out.println("Email: " + message); } }

abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;
    protected NotifierDecorator(Notifier n){ this.wrappee = n; }
    public void send(String message){ wrappee.send(message); }
}

class SMSNotifierDecorator extends NotifierDecorator {
    SMSNotifierDecorator(Notifier n){ super(n); }
    public void send(String message){ super.send(message); System.out.println("SMS: " + message); }
}

class SlackNotifierDecorator extends NotifierDecorator {
    SlackNotifierDecorator(Notifier n){ super(n); }
    public void send(String message){ super.send(message); System.out.println("Slack: " + message); }
}

public class NotifierDecoratorDemo {
    public static void main(String[] args){
        Notifier base = new EmailNotifier();
        Notifier multi = new SMSNotifierDecorator(new SlackNotifierDecorator(base));
        multi.send("Build completed");
    }
}
