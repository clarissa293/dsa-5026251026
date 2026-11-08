package lw04.prelab;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n=s.nextInt();
        int [] data=new int[n];
        for (int i=0; i<n; i++) {
            data[i]=s.nextInt();
        }
        insertionSort(3, data);
        int target=s.nextInt();
        for (int i=0; i<target; i++) {
            int k=s.nextInt();
            int index=linearSearch(k, data);
            System.out.print(k+": ");
            if (index == -1) {
                System.out.println("NOT FOUND");
            } else {
                System.out.println("FOUND at index "+index);
            }
        } s.close();
    }

    public static void insertionSort(int pass, int[] data) {
        for (int a=1; a<=pass; a++) {
            int temp = data[a];
            int index = a;
            for (int b=a-1; b>=0; b--) {
                if (data[b] < temp) {
                    data[b+1] = data[b];
                    index = b;
                }
                data[index] = temp;
            }
        }
        for (int d:data) {
            System.out.print(d+ " ");
        }
        System.out.println();
    }

    public static int linearSearch(int k, int[] data) {
        for (int i=0 ; i<data.length ; i++) {
            if (data[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
