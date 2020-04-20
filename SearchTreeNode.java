
public class SearchTreeNode<E> {
     public E data;
     public SearchTreeNode<E> left;
     public SearchTreeNode<E> right;
     public String letter;
     public static final String EMPTY = " ";
     
     // constructs a leaf node with given data
     public SearchTreeNode() {
    	 letter = EMPTY;
    	 this.left = null;
    	 this.right = null;
     }
     
     // constructs a branch node with given data, left subtree,
     // right subtree
     public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
    	 this.left = left;
    	 this.right = right;
    	 this.letter = (String) data;
     }
     
     public String getChar() {
    	 return letter;
     }
     
     public void setLetter(String letter) {
    	 this.letter = letter;
     }
     
     
}
