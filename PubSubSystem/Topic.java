import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
    private final String  name;
    private final List<Subscriber> subscribers=new CopyOnWriteArrayList<>();

    public Topic(String name){
        this.name=name;
    }

    public void AddSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
    public void publish(Message message) {
        System.out.println("Publishing message to topic: " + name);
        for (Subscriber subscriber : subscribers) {
            subscriber.onMessage(message);
        }
    }

}
