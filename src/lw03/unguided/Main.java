package lw03.unguided;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> course=new LinkedHashMap<>();
        int rejected=0;

        System.out.println("===== Enrollment Checks =====");

        while (sc.hasNextLine()) {
            String line=sc.nextLine();
            String[] parts=line.split(" ", 2);

            String operation=parts[0];
            //String code=parts[1];
            //int count=Integer.parseInt(parts[2]);

            if (operation.equals("REGISTER")) {
                String[] data=parts[1].split(" ");
                String code=data[0];
                int count=Integer.parseInt(data[1]);
                int currentCount=course.getOrDefault(code, 0);
                if (!(count<=0)) {
                    if (!course.containsKey(code)) {
                        course.put(code, count);
                    } else {
                        course.put(code, (currentCount+count));
                    }
                } else {
                    rejected++; 
                }
            } else if (operation.equals("WITHDRAW")) {
                String[] data=parts[1].split(" ");
                String code=data[0];
                int count=Integer.parseInt(data[1]);  
                if (course.containsKey(code) && course.get(code) >= count) {
                    int currentCount=course.get(code);
                    course.put(code, (currentCount-count));
                } else {
                    rejected++;
                }
            } else {
                String code=parts[1];
                if (course.containsKey(code)) {
                    System.out.println(code + ": " + course.get(code) + " students");
                } else {
                    System.out.println(code + ": Not found");
                }
            }
        }
        sc.close();

        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (Map.Entry<String, Integer> enroll:course.entrySet()) {
            System.out.println(enroll.getKey() + ": " + enroll.getValue() + " students");
        }
        System.out.println();
        System.out.println("Rejected operations: " + rejected);
    }
}

