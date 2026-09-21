package lw01.unguided;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        ArrayList<Rental> rentals=new ArrayList<>();
        
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

            if (type.equals("LAPTOP")) {
                rentals.add(new LaptopRental(id, days));
            } else {
                rentals.add(new ProjectorRental(id,days));
            }

            sc.close();

            for (Rental rental:rentals) {
                System.out.println(rental.getId() + " | " + rental.label() + " | " + rental.calculateCharge(units));
            }
        }

    }
}
