public class PubSubDemo {
    public static void main(String[] args) {
        Topic sports=new Topic("Sports");
        Topic finance =new Topic("fianace");

        Subscriber s1=new PrintSubscriber("thaya");
        Subscriber s2=new PrintSubscriber("ravi");
        Subscriber s3=new PrintSubscriber("kumar");

        sports.AddSubscriber(s1);
        sports.AddSubscriber(s2);
        finance.AddSubscriber(s3);

        Publisher sportsPub=new Publisher("Hotstar");
        Publisher financePub=new Publisher("CNBC");

        sportsPub.publish(sports,"India vs Australia today");
        financePub.publish(finance,"Stock market Crash");

        sports.removeSubscriber(s2);
        sportsPub.publish(sports,"India won!!");


    }
}
