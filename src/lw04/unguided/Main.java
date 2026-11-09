package lw04.unguided;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n=s.nextInt();
        int[] card=new int[n];
        for (int i=0; i<n; i++) {
            card[i]=s.nextInt();
        }

        int m=s.nextInt();
        int[] req=new int[m];
        for (int i=0; i<m; i++) {
            req[i]=s.nextInt();
        }
        s.close();

        selectionSort(card, 2);
        for (int r:req) {
            int idx=linearSearch(card, r);
            if (idx == -1) {
                System.out.println(r+": NOT FOUND");
            } else {
                System.out.println(r+": FOUND at index "+idx);
            }
        }
    }

    public static void selectionSort(int[] card, int pass) {
        for (int i=0; i<pass; i++) {
            int min=card[i];
            int idx=i;
            for (int j=i+1; j<card.length; j++) {
                if (min > card[j]) {
                    min=card[j];
                    idx=j;
                }
            }
            int temp=card[i];
            card[i]=min;
            card[idx]=temp;
        }
        for (int c:card) {
            System.out.print(c+ " ");
        }
        System.out.println();
    }

    public static int linearSearch(int[] card, int k) {
        for (int i=0; i<card.length; i++) {
            if (card[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
