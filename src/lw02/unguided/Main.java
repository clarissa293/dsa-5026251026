package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> requests=new LinkedList<>();
        LinkedList<String[]> bookStock=new LinkedList<>();
        LinkedList<String[]> members=new LinkedList<>();
        Queue<String[]> queue=new LinkedList<>();
        Stack<String[]> failed=new Stack<>();
        Scanner sc=new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        //input
        while (sc.hasNextLine()) {
            String[] data=sc.nextLine().split(" ");

            String name=data[0];
            String book_title=data[1];

            requests.add(new String[]{name, book_title});

            //adding members
            for (String[] m:members) {
            if (members.isEmpty()) {
                members.add(new String[]{name, "0"});
            } else if (m[0].equals(name)) {
                break;
            } else {
                members.add(new String[]{name, "0"});
            } }
        }

        sc.close();

        bookStock.add(new String[]{"Kalkulus", "2", "Fisika", "1", "Statistika", "2"});
        // bookStock.add(new String[]{"Fisika", "1"});
        // bookStock.add(new String[]{"Statistika", "2"});

        //pindah ke queue
        while(!requests.isEmpty()) {
            queue.offer(requests.removeFirst());
        }

        //processing
        while(!queue.isEmpty()) {
            String[] request=queue.poll();

            String name=request[0];
            String book_title=request[1];

            for (String[] bs:bookStock) {
                int stockKalkulus=Integer.parseInt(bs[1]);
                int stockFisika=Integer.parseInt(bs[3]);
                int stockStatistika=Integer.parseInt(bs[5]);

                for (String[] r:requests) {
                    if (r[0].equals(name)) {
                        int max_borrow=Integer.parseInt(r[1]);

                        if (book_title.equals("Kalkulus")) {
                            if(stockKalkulus>0 && max_borrow<2) {
                                stockKalkulus--;
                                max_borrow++;
                                r[1]=String.valueOf(max_borrow);
                                bs[1]=String.valueOf(stockKalkulus);
                            } else {
                                failed.push(request);
                            }
                        } else if (book_title.equals("Fisika")) {
                            if (stockFisika>0 && max_borrow<2) {
                                stockFisika--;
                                max_borrow++;
                                r[1]=String.valueOf(max_borrow);
                                bs[3]=String.valueOf(stockFisika);
                            } else {
                                failed.push(request);
                            }
                        } else {
                            if(stockStatistika>0 && max_borrow<2) {
                                stockStatistika--;
                                max_borrow++;
                                r[1]=String.valueOf(max_borrow);
                                bs[5]=String.valueOf(stockStatistika);
                            } else {
                                failed.push(request);
                            }
                        }

                    }
                }
            }
        }
        //output
        System.out.println("=== Successfully Processed Requests ===");
        for (String[] r:requests) {
            System.out.println(r[0] + " " + r[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Book Stock ===");
        for (String[] bs:bookStock) {
            System.out.println(bs[0] + " " + bs[1]);
            System.out.println(bs[2] + " " + bs[3]);
            System.out.println(bs[4] + " " + bs[5]);
        }

        System.out.println();
        System.out.println("=== Failed Requests ===");
        while(!failed.isEmpty()) {
            String[] request=failed.pop();
            System.out.println(request[0] + " " + request[1]);
        }
    }
    
}
