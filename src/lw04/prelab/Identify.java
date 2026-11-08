package lw04.prelab;

public class Identify {
    public static void main(String[] args) {
        int [] data = {3, 7, 1, 9, 5, 8, 2};
        int [] data2 = {2, 5, 8, 1, 10, 6, 3};

        bubbleSort(3, data);
        //selectionSort(3, data);
        insertionSort(3, data2);
    }
    
    public static void bubbleSort(int pass, int[] data) {
        for (int a=0; a<pass; a++) {
            for (int b=0; b<data.length-1-a; b++) {
                if (data[b] < data[b+1]) {
                    int temp = data[b+1];
                    data[b+1] = data[b];
                    data[b] = temp;
                }
            }
        }
        System.out.println("bubble sort: ");
        for (int d:data) {
            System.out.print(d+ " ");
        }
    }

    public static void selectionSort(int pass, int[] data) {
        for (int a=0; a<pass; a++) {
            int max = data[a];
            int maxIndex = a;
            for (int b=a+1; b<data.length; b++) {
                if (max < data[b]) {
                    max = data[b];
                    maxIndex = b;
                }
            }
            int temp = data[a];
            data[a] = max;
            data[maxIndex] = temp;
        }
        System.out.println("selection sort: ");
        for (int d:data) {
            System.out.print(d+ " ");
        }
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
        System.out.println("insertion sort: ");
        for (int d:data) {
            System.out.print(d+ " ");
        }
    }
}

