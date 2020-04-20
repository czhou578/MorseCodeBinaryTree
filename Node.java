public class Node {

   private char letter;
   private int number;
   private Node left;
   private Node right;
   public static final char EMPTY = ' ';

   public Node() {
      letter = EMPTY;
      left = null;
      right = null;
   }
   
   public void setLetter(char letter) {
	 this.letter = letter;
   }

/* 
   gets letter value in node
*/
   public char getLetter() {
      return letter;
   }

   public void setNumber(int number) {
      this.number = number;
   }
   
   public int getNumber() {
	  return number;
   }

/*
*  gets left node
*/
   public Node getLeft() {
      return left;
   }

/*
*  sets left node
*/
   public void setLeft(Node left) {
      this.left = left;
   }

/*
*  gets the right node
*/
   public Node getRight() {
      return right;
   }

/*
*  sets right node
*/
   public void setRight(Node right) {
      this.right = right;
   }
}