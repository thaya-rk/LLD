public class PrintSubscriber implements Subscriber{
    private final String name;

    public PrintSubscriber(String name){
        this.name=name;
    }
    @Override
    public void onMessage(Message message) {
        System.out.println(name + " received: " + message.getContent());
    }

}
