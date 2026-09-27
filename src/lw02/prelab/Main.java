package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> trans=new LinkedList<>();
        LinkedList<String[]> cust=new LinkedList<>();

        Scanner sc=new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while(sc.hasNextLine()) {
            String line=sc.nextLine();
            String[] data=line.split(" ");

            String name=data[0];
            String type=data[1];
            String amount=data[2];

            trans.add(new String[]{name, type, amount});

            boolean appear=false;

            for (String[] c:cust) {
                if (c[0].equals(name)) {
                    appear=true;
                    break;
                }
            }

                if (!appear) {
                    cust.add(new String[]{name, "0"});
                }
        }

            sc.close();

        Queue<String[]> q=new LinkedList<>();

        while (!trans.isEmpty()) {
            q.offer(trans.removeFirst());
        }

        Stack<String[]> failedTrans=new Stack<>();

        while(!q.isEmpty()) {
            String[] transac=q.poll();

            String name=transac[0];
            String type=transac[1];
            int amount=Integer.parseInt(transac[2]);

            for (String[] c:cust) {

                if (c[0].equals(name)) {
                    int balance=Integer.parseInt(c[1]);

                    if (type.equals("DEPOSIT")) {
                        balance+=amount;
                        c[1]=String.valueOf(balance);
                    } else {
                        if (amount > balance) {
                            failedTrans.push(transac);
                        } else {
                            balance-=amount;
                            c[1]=String.valueOf(balance);
                        }
                    }

                    break;
                }   
            }
        }

        System.out.println("=== Final Balances ===");

        for (String[] c:cust) {
            System.out.println(c[0] + ":" + c[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");

        while (!failedTrans.isEmpty()) {
            String[] transac=failedTrans.pop();

            System.out.println(transac[0] + " " + transac[1] + " " + transac[2]);
        }
    }
}
