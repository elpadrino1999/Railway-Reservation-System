package rrs;

import java.util.*;

public class BookTickets {

    int availableLowerberth = 3;
    int availableMiddleberth = 3;
    int availableUpperberth = 3;
    int availableRAC = 3;
    int availableWaitinglist = 3;
    static int i = 0;

    Queue<Integer> waitinglist = new LinkedList<Integer>();
    Queue<Integer> raclist = new LinkedList<Integer>();
    Map<Integer, Passenger> passengerdata = new HashMap<Integer, Passenger>();

    public void bookTicket(Passenger p) {
        TicketDetails td = new TicketDetails();
        if (availableWaitinglist == 0) {
            System.out.println("\n>>>>>>>>>>>>Sorry No Tickets Available<<<<<<<<<<<<<<<<<<<<<\n");
        } else if (p.getAge() <= 5) {
            System.out.println("\n>>>>>>>>>>>>>>There are no seperate berths allocation for passenger age under 5\n");

        } else if (p.getAge() >= 60 && availableLowerberth > 0) {
            System.out.println("\n>>>>Passengers equals or above age 60 we allocate lower berth for you<<<<<<<<\n");
            td.print_BookedTicket(p, "L");
            availableLowerberth--;
        } else if (p.getChildname() != ("Nil") && p.getChild_age() <= 5 && availableLowerberth > 0) {
            System.out.println("\n>>>>>>>Passengers with child lower berth should be arranged<<<<<<<<<<<\n");
           td. print_BookedTicket(p, "L");
            availableLowerberth--;
        } else if ((p.getBerth_pref().equalsIgnoreCase("L") && availableLowerberth > 0) || (p.getBerth_pref().equalsIgnoreCase("M") && availableMiddleberth > 0) || (p.getBerth_pref().equalsIgnoreCase("U") && availableUpperberth > 0)) {
            if (p.getBerth_pref().equalsIgnoreCase("L")) {
                System.out.println("\nLower Berth Given\n");
                td.print_BookedTicket(p, "L");
                availableLowerberth--;
            } else if (p.getBerth_pref().equalsIgnoreCase("M")) {
                System.out.println("\nMiddle Berth Given\n");
                td.print_BookedTicket(p, "M");
                availableMiddleberth--;
            } else if (p.getBerth_pref().equalsIgnoreCase("U")) {
                System.out.println("\nUpper Berth Given\n");
                td.print_BookedTicket(p, "U");
                availableUpperberth--;
            }
        } else if (availableLowerberth > 0) {
            System.out.println("\nLower Berth Given\n");
            td.print_BookedTicket(p, "L");
            availableLowerberth--;
        } else if (availableMiddleberth > 0) {
            System.out.println("\nMiddle Berth Given\n");
            td.print_BookedTicket(p, "M");
            availableMiddleberth--;
        } else if (availableUpperberth > 0) {
            System.out.println("\nUpper Berth Given\n");
            td.print_BookedTicket(p, "U");
            availableUpperberth--;
        } else if (availableRAC > 0) {
            System.out.println("\nRAC Berth Given\n");
            if (i % 2 == 0) {
                td.print_RacTicket(p, "Berth" + "RAC");
            } else {
                td.print_RacTicket(p, "RAC");
            }
            while (i < 21) {
                i++;
                break;
            }
            availableRAC--;
        } else if (availableWaitinglist > 0) {
            System.out.println("\nWaiting List Given\n");
            td.print_WlTicket(p, "WL");
            availableWaitinglist--;
        }
    }

    public void cancelTicket(int p_id) {
        if (!passengerdata.containsKey(p_id)) {
            System.out.println("\nPassenger ID is Not Found\n");
        } else if (raclist.contains(p_id) || waitinglist.contains(p_id)) {
            Passenger p = passengerdata.get(p_id);
            String p_alloted = p.alloted;
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>Ticked has been cancelled successfully<<<<<<<<<<<<<<<<<<<<<<<<     \n");
            if (p_alloted.equalsIgnoreCase("RAC") || p_alloted.equalsIgnoreCase("Berth" + "RAC")) {
                Passenger passengerInRAC1 = passengerdata.get(p_id);
                raclist.remove(passengerInRAC1.passengerId);
                passengerdata.remove(p_id);
                availableRAC++;
                i--;

                if (waitinglist.size() > 0) {
                    Passenger passengerInwl = passengerdata.get(waitinglist.poll());
                    waitinglist.remove(passengerInwl.passengerId);
                    if (p_alloted.equalsIgnoreCase("RAC")) {
                        passengerInwl.alloted = "RAC";
                    } else {
                        passengerInwl.alloted = "Berth" + "RAC";
                    }
                    raclist.add(passengerInwl.passengerId);
                    availableWaitinglist++;
                    availableRAC--;
                }
            } else if (p_alloted.equalsIgnoreCase("WL")) {
                waitinglist.remove(p_id);
                passengerdata.remove(p_id);
                availableWaitinglist++;
            }
        } else {
            Passenger p = passengerdata.get(p_id);
            String p_alloted = p.alloted;
            passengerdata.remove(p_id);
            System.out.println("\n>>>>>>>>>>>>>>>>>>>Ticket cancelled successfully<<<<<<<<<<<<<<<<<<<<<<\n");
            if (p_alloted.equalsIgnoreCase("L")) {
                availableLowerberth++;
            } else if (p_alloted.equalsIgnoreCase("M")) {
                availableMiddleberth++;
            } else if (p_alloted.equalsIgnoreCase("U")) {
                availableUpperberth++;
            }

            if (raclist.size() > 0) {
                Passenger passengerInRAC = passengerdata.get(raclist.poll());
                raclist.remove(passengerInRAC.passengerId);
                availableRAC++;

                if (waitinglist.size() > 0) {
                    Passenger passengerInwl = passengerdata.get(waitinglist.poll());
                    waitinglist.remove(passengerInwl.passengerId);

                    passengerInwl.alloted = "RAC";
                    raclist.add(passengerInwl.passengerId);
                    availableWaitinglist++;
                    availableRAC--;
                }
                bookTicket(passengerInRAC);
            }
        }
    }

}
