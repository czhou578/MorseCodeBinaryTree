// This program tests the IntSearchTree class by constructing a
// binary search tree of integers and printing its contents as
// well as its structure.

import java.util.*;

public class IntSearchTreeClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        IntSearchTree numbers = new IntSearchTree();
        int[] values = {50, 20, 75, 98, 80, 37, 150, 39, 23, 11, 77};        

        // add values[] entries in their current array order
        for (int i = 0; i < 11; i++) {
            numbers.add(values[i]);
        }

/*
        // Randomly add values[] entries to the tree until all have
        // been added; duplicates won't be added, so we keep at it
        // until we get them all
        // The idea here is to demonstrate that values being added in
        // different orders create different-looking binary search trees
        Random r = new Random();
        while (numbers.countNodes() < values.length) {
            int index = r.nextInt(11);
            numbers.add(values[index]);
        }
*/        
/*        
        // accept entries from a user, interactively
        System.out.print("Next int (0 to quit)? ");
        int number = console.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = console.nextInt();
        }
        System.out.println();
*/        

        System.out.println("Tree Structure:");
        numbers.printSideways();
        System.out.println("\nSorted list:");
        numbers.print(); //inorder traversal print

        int target = 75;
        System.out.println((numbers.contains(target) ? "Did" : "Didn't") + " find " + target);
        System.out.println("Removing " + target);
        numbers.remove(target);
        numbers.print();
        System.out.println((numbers.contains(target) ? "Did" : "Didn't") + " find " + target);
    }
}
