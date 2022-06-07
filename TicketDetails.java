package rrs;

public class TicketDetails {

    BookTickets tb = new BookTickets();
    public void print_BookedTicket(Passenger p, String allotedBerth) {
        p.alloted = allotedBerth;
        tb.passengerdata.put(p.passengerId, p);
        System.out.println("Passenger Id : "+p.passengerId);
        System.out.println("Passenger Name : "+p.getName());
        System.out.println("Passenger Age : "+p.getAge());
        System.out.println("Passenger Gender : "+p.getGender());
        System.out.println("Alloted Berth : "+allotedBerth);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>Ticked has been Booked Successfully<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
    public void print_RacTicket(Passenger p, String RACBerth) {
        p.alloted = RACBerth;
        tb.passengerdata.put(p.passengerId, p);
        tb.raclist.add(p.passengerId);
        System.out.println("Passenger Id : "+p.passengerId);
        System.out.println("Passenger Name : "+p.getName());
        System.out.println("Passenger Age : "+p.getAge());
        System.out.println("Passenger Gender : "+p.getGender());
        System.out.println("Alloted Berth : "+RACBerth);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>Ticked has been Booked Successfully<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
    public void print_WlTicket(Passenger p, String WLBerth) {
        p.alloted = WLBerth;
        tb.passengerdata.put(p.passengerId, p);
        tb.waitinglist.add(p.passengerId);
        System.out.println("Passenger Id : "+p.passengerId);
        System.out.println("Passenger Name : "+p.getName());
        System.out.println("Passenger Age : "+p.getAge());
        System.out.println("Passenger Gender : "+p.getGender());
        System.out.println("Alloted Berth : "+WLBerth);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>Ticked has been Booked Successfully<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }

    public void availableTickets() {
        System.out.println("\nNumber of available Lower Berth Tickets is : "+tb.availableLowerberth);
        System.out.println("Number of available Middle Berth Tickets is  : "+tb.availableMiddleberth);
        System.out.println("Number of available Upper Berth Tickets is   : "+tb.availableUpperberth);
        System.out.println("Number of available RAC Berth Tickets is     : "+tb.availableRAC);
        System.out.println("Number of available Waiting LIst Tickets is  : "+tb.availableWaitinglist);
        System.out.println("");
    }

    public void getPassengersDetails() {
        if(tb.passengerdata.size() == 0) {
            System.out.println("\nNo Passenger Details Found\n");
        }
        else{
            for(Passenger p : tb.passengerdata.values()) {
                System.out.println("");
                System.out.println("Passenger Id           : "+p.passengerId);
                System.out.println("Passenger Name         : "+p.getName());
                System.out.println("Passenger Age          : "+p.getAge());
                System.out.println("Passenger Gender       : "+p.getGender());
                System.out.println("Passenger Child Name   : "+p.getChildname());
                System.out.println("Passenger Child Age    : "+p.getChild_age());
                System.out.println("Passenger Child Gender : "+p.getChild_gender());
                System.out.println("Alloted Berth          : "+p.alloted);
                System.out.println("");
            }


        }
    }
}
