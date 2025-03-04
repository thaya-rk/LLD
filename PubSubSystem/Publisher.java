public class Publisher {
    public final String name;

    public Publisher(String name){
        this.name=name;
    }
    public void publish(Topic topic,String content){
        Message message= new Message(content);
        topic.publish(message);
    }
}
