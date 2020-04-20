import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCoder implements MorseInterface {
	   private Node root;

	   public MorseCoder() {
	      root = new Node();
	      readIn();
	   }

	// reads in from file to the tree
	   private void readIn() {
	      try {
	        Scanner input = new Scanner(new File("C:\\Users\\mycol\\Documents\\morseCode.txt"));
		      while (input.hasNextLine()) {
			         String data = input.nextLine().trim();
			         if (data.length() > 0) {
			            add(data.substring(1).trim(), data.charAt(0));
			         }
			      }
	      } catch (FileNotFoundException exception) {
	         System.out.println("File not found!");
	      }
	  }

	/**
	* adds the specified letter to the tree
	*/
	   private void add(String str, char letter) {
	      Node current = root;
	      String symbol = " ";
	   
	      for (int i = 0; i < str.length(); i++) {
	         symbol = str.substring(i, i + 1);
	         if (symbol.equals(".")) {
	            if (current.getLeft() != null) {
	               current = current.getLeft();
	            } else {
	               current.setLeft(new Node());
	               current = current.getLeft();
	            }
	         } else {
	            if (current.getRight() != null) {
	               current = current.getRight();
	            } else {
	               current.setRight(new Node());
	               current = current.getRight();
	            }
	         }
	      }
	      current.setLetter((char) letter);
	   }

	// prints out tree in order
	   public void inOrderPrint() {
	      Node current = root;
	      printInorder(current);
	   }

	/*
	* method called by inOrderPrint to print the tree
	*/
	   private void printInorder(Node current) {
	      if (current != null) {
	         printInorder(current.getLeft());
	         System.out.print(current.getLetter());
	         printInorder(current.getRight());
	      }
	   }

	/**
	* converts morse code String to english
	*/
	   public String decode(String str) {
	      String symbol = "";
	      StringBuffer result = new StringBuffer("");
	      Node current = root;
	      //System.out.println(str);
	   
	      for (int i = 0; i < str.length(); i++) { //get number is always returning 0
	         symbol = str.substring(i, i + 1);
	         if (symbol.equals(".")) {
	            if (current.getLeft() != null) {
	               current = current.getLeft();
	            } else {
	               current.setLeft(new Node());
	               current = current.getLeft();
	            }
	         } else if (symbol.equals("-")) {
	            if (current.getRight() != null) {
	               current = current.getRight();
	            } else {
	               current.setRight(new Node());
	               current = current.getRight();
	            }
	            //System.out.println(current.getLetter());
	            //System.out.println(current.getNumber());
	            
	         } else {
	            result = result.append(current.getLetter());
	            //System.out.println(result);
	            current = root;
	         }
	      }
	      result = result.append(current.getLetter());
	      result = result.append(current.getNumber());
	   
	      return result.toString();
	   }

	/**
	* converts String of english to morse code
	*/
	   public String encode(String str) {
	      Node current = root;
	      String result = "";
	      String String = "";
	      char letter;
	   
	      for (int i = 0; i < str.length(); i++) {
	         letter = str.charAt(i);
	         result = searchTree(current, letter, String);
	      }
	      return result;
	   }   

	/**
	* searches the tree for the letter(s) being inputed and outputs a String of morse (helper method)
	*/
	   public String searchTree(Node current, char letter, String string) {
	      char temporary = current.getLetter(); //for debugging purposes
	   
	      if (current.getLetter() == letter) {
	         return string;
	      } else {
	         if (current.getLeft() != null) {
	            return searchTree(current.getLeft(), letter, string + ".");
	         }
	         if (current.getRight() != null) {
	            return searchTree(current.getRight(), letter, string + "-");
	         }   
	         return string;
	      }
	   }
}
