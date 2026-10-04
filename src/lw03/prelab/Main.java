package lw03.prelab;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        //problem 1
        Scanner sc=new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist=new ArrayList<>();

        while (sc.hasNextLine()) {
            String line=sc.nextLine();
            String[] parts=line.split(" ",2);
            String type=parts[0];

            if (type.equals("ADD")) {
                String song=parts[1];
                playlist.add(song);
            } else if (type.equals("INSERT")) {
                String[] insert=parts[1].split(" ", 2);

                int index=Integer.parseInt(insert[0]);
                String song=insert[1];
                playlist.add(index, song);
            } else if (type.equals("REMOVE")) {
                String song=parts[1];
                playlist.remove(song);
            }
        }
        sc.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs:" + playlist.size());
        for (int i=0; i<playlist.size(); i++) {
            System.out.println((i+1) + ": " + playlist.get(i));
        }

        //problem 2
        Scanner scn=new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set<String> participants=new LinkedHashSet<>();;
        int countDupe=0;

        while (scn.hasNextLine()) {
            String name=scn.nextLine();

            if (!participants.add(name)) {
                countDupe++;
            } 
        }
        scn.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants:" + participants.size());
        
        int i=1;
        for (String p:participants) {
            System.out.println(i + ". " + p);
            i++;
        }
        System.out.println("Duplicate registrations:" + countDupe);

        //problem 3
        Scanner scnn=new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        
        Map< String, Integer> inventory=new LinkedHashMap<>();
        int countFails=0;

        while (scnn.hasNextLine()) {
            String line=scnn.nextLine();
            String[] parts=line.split(" ");

            String type=parts[0];
            String product=parts[1];
            int quantity=Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                int stock=inventory.getOrDefault(product, 0);

                inventory.put(product, (stock + quantity));
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    int stock=inventory.get(product);
                    inventory.put(product, (stock-quantity));
                } else {
                    countFails++;
                }
            }
        }
        scnn.close();

        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry:inventory.entrySet()) {
            System.out.println(entry.getKey()  + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + countFails);
    }
    
}
