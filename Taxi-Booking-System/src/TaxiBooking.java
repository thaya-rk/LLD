import java.util.ArrayList;

public class TaxiBooking {
    private static final int taxiLimit=4;
    private static int idGenerator=1;
    //Contains the list of Taxi objects
    private static ArrayList<Taxi> taxiList= new ArrayList<>();
    //List to Display the booked history of each taxi using Cloning
    private static ArrayList<Taxi> BookedHistory=new ArrayList<>();

    public static String book(char pickupLocation,char dropLocation,int pickupTime)throws CloneNotSupportedException {
        if(taxiList.size()<taxiLimit){
            //creating a taxi object
            taxiList.add(new Taxi());
        }

        int min=Integer.MAX_VALUE;
        Taxi taxiReady=null;

        //Iterating each taxi in list to find available taxi
        for(Taxi t:taxiList){
            if(t.getDropTime()<=pickupTime && Math.abs(pickupLocation - t.getDropLocation())<min){
                taxiReady=t;
                //To find the nearest taxi available amon taxis
                min=Math.abs(pickupLocation-t.getDropLocation());
            }
        }

        if(taxiReady!=null){
            //now update the current Taxi Ready Details
            taxiReady.setCustomerId(idGenerator++);
            taxiReady.setPickupTime(pickupTime);
            taxiReady.setPickupLocation(pickupLocation);
            taxiReady.setDropLocation(dropLocation);
            taxiReady.setCurrentLocation(dropLocation);
            //Here example point C - A =3-1 =>2 so pickupTime+2
            taxiReady.setDropTime(pickupTime+Math.abs(pickupLocation-dropLocation));
            taxiReady.setTaxiId(taxiList.indexOf(taxiReady)+1);
            //here example,A->C, 100+(((3-1)*15)-5)*10 -> 100+(25)*10 -> 100+250 -> 350
            taxiReady.setEarnings((taxiReady.getEarnings())+100+(Math.abs(((dropLocation-pickupLocation)*15)-5)*10));

            //now Add the Booked taxi in Booked History List
            BookedHistory.add((Taxi) taxiReady.clone());
        }
        return taxiReady!=null?"---> Taxi no."+taxiReady.getTaxiId()+" booked Successfully <---":"Taxi not Available <---\n";


    }
    //Display Details
    public static void display(){
        System.out.println("-------------------------------");
        for(Taxi t:BookedHistory){
            System.out.println(t.toString());
            System.out.println("-----------------------------------");
        }
    }

}
