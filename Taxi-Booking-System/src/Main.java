import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        boolean loop=true;

        while (loop){
            System.out.println("Choose a option \n1.Book Taxi \n2.Display Details \n3.Exit");
            Scanner sc=new Scanner(System.in);
            int n= sc.nextInt();

            switch (n){
                case 1:
                {
                    System.out.println("Enter pickup Location:");
                    char pickupLocation= sc.next().charAt(0);
                    System.out.println("Enter Drop Location:");
                    char dropLocation=sc.next().charAt(0);
                    System.out.println("Enter Pickup Time:");
                    int pickupTime= sc.nextInt();
                    System.out.println(TaxiBooking.book(pickupLocation,dropLocation,pickupTime));
                    break;
                }
                case 2:
                {
                    TaxiBooking.display();
                    break;
                }
                case 3:
                {
                    loop=false;
                    System.out.println("Thank you for visiting!!!");
                    sc.close();
                    break;
                }
            }
        }

    }
}
