package lw06.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst=new BinarySearchTree();
        String line=read.nextLine();
        Scanner in=new Scanner(line);
        while (in.hasNext()) {
            int data=in.nextInt();
            bst.insert(data);
        }
        in.close();
        int target=read.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : "); 
        bst.postOrder();

        System.out.println("Search "+target+" : "+bst.search(target));

        System.out.println("Minimum : "+bst.findMin());
        System.out.println("Maximum : "+bst.findMax());

        read.close();
    }
}
