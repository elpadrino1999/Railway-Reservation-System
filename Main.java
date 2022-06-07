package rrs;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean value = true;
        BookTickets booking = new BookTickets();
        TicketDetails t=new TicketDetails();

        while (value) {
            System.out.println("1.Book  \n2.Cancel  \n3.Available Tickets  \n4.Booked Tickets  \n5.Exit  \n");
            System.out.println("Enter Your choice :");
            int num = sc.nextInt();

            switch (num) {

                case 1: {
                    if (booking.availableLowerberth != 0 || booking.availableMiddleberth != 0 || booking.availableUpperberth != 0 || booking.availableRAC != 0 || booking.availableWaitinglist != 0) {
                        System.out.println("Enter the Passenger Name ");
                        String name = sc.next();
                        System.out.println("Enter the Passenger Age ");
                        int age = sc.nextInt();
                        System.out.println("Enter the Passenger Gender (Male-M,Female-F) ");
                        String gender = sc.next();
                        if (gender.equalsIgnoreCase("F")) {
                            System.out.println("\nPress 1 if you have a child \nPress 0 if you don't have a child ");
                            int child = sc.nextInt();
                            if (child == 1) {
                                System.out.println("Enter the Child Name ");
                                String child_name = sc.next();
                                System.out.println("Enter the Child Age ");
                                int child_age = sc.nextInt();
                                System.out.println("Enter the Child Gender (Male-M,Female-F) ");
                                String child_gender = sc.next();
                                System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                String berth_pref = sc.next();

                                if (booking.availableLowerberth == 0 && berth_pref.contains("L")) {
                                    System.out.println(berth_pref + " is full choose another");
                                    System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                    berth_pref = sc.next();
                                } else if (booking.availableMiddleberth == 0 && berth_pref.contains("M")) {
                                    System.out.println(berth_pref + " is full choose another");
                                    System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                    berth_pref = sc.next();
                                } else if (booking.availableUpperberth == 0 && berth_pref.contains("U")) {
                                    System.out.println(berth_pref + " is full choose another");
                                    System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                    berth_pref = sc.next();
                                }

                                Passenger p = new Passenger();
                                p.setName(name);
                                p.setAge(age);
                                p.setGender(gender);
                                p.setChildname(child_name);
                                p.setChild_age(child_age);
                                p.setChild_gender(child_gender);
                                p.setBerth_pref(berth_pref);
                                booking.bookTicket(p);
                            } else if (child == 0) {
                                String child_name = "Nil";
                                int child_age = 0;
                                String child_gender = "Nil";
                                System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                String berth_pref = sc.next();
                                Passenger p = new Passenger();
                                p.setName(name);
                                p.setAge(age);
                                p.setGender(gender);
                                p.setChildname(child_name);
                                p.setChild_age(child_age);
                                p.setChild_gender(child_gender);
                                p.setBerth_pref(berth_pref);
                                booking.bookTicket(p);
                            }
                        } else if (gender.equalsIgnoreCase("M")) {
                            String child_name = "Nil";
                            int child_age = 0;
                            String child_gender = "Nil";
                            System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                            String berth_pref = sc.next();

                            if (booking.availableLowerberth == 0 && berth_pref.contains("L")) {
                                System.out.println(berth_pref + " is full choose another");
                                System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                berth_pref = sc.next();
                            } else if (booking.availableMiddleberth == 0 && berth_pref.contains("M")) {
                                System.out.println(berth_pref + " is full choose another");
                                System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                berth_pref = sc.next();
                            } else if (booking.availableUpperberth == 0 && berth_pref.contains("U")) {
                                System.out.println(berth_pref + " is full choose another");
                                System.out.println("Enter the Passenger berth preference (Lower-L,Middle-M,Upper-U");
                                berth_pref = sc.next();
                            }

                            Passenger p = new Passenger();
                            p.setName(name);
                            p.setAge(age);
                            p.setGender(gender);
                            p.setChildname(child_name);
                            p.setChild_age(child_age);
                            p.setChild_gender(child_gender);
                            p.setBerth_pref(berth_pref);
                            booking.bookTicket(p);
                        }
                    } else {
                        System.out.println("\n>>>>>>>Sorry No Tickets Available<<<<<<<<<<<<\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the Passenger ID : ");
                    int id = sc.nextInt();
                    booking.cancelTicket(id);
                    break;
                }
                case 3: {
                    t.availableTickets();
                    break;
                }
                case 4: {
                    t.getPassengersDetails();
                    break;
                }
                case 5: {
                    sc.close();
                    value = false;
                    break;
                }
                default: {
                    System.out.println("\n>>>>>>>>>>>>>>>Please provide valid input<<<<<<<<<<<<<<<<<<<<<<<\n");
                }
            }
        }
    }
}
