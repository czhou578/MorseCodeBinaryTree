import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseSearchTree<E> implements MorseCodeInterface{
	private SearchTreeNode<E> overallRoot;
	private String result;
	private char letter;
	private SearchTreeNode root;
	private String chara;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public MorseSearchTree() {
        root = new SearchTreeNode();
        readToTree();
        //printSideways();
    }
    
    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    /*private SearchTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new SearchTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }*/
        //looks correct
    public void readToTree() { //reads file into tree
    	try {
    		Scanner scanner = new Scanner(new File("C:\\Users\\mycol\\Documents\\morseCode.txt"));
    		while(scanner.hasNext()) {
    			//String line = scanner.nextLine();
    			//line.replaceAll("\\s", ""); //removes white space
    			//System.out.println(line);
    			//String symbol = line.substring(0, 1); //adds character
    			//System.out.println(symbol);
    			//System.out.println(line.substring(1));   			
    	        while (scanner.hasNextLine()) {
    	            String data = scanner.nextLine().trim();
    	            //System.out.println(data);
    	            if (data.length() > 0) {
    	            	chara += data.charAt(0);
    	                add(data.substring(1).trim(), chara);
    	            }
    	        }
    			//add(symbol, line.substring(1)); //adds morse code
    		}
      		
    	} catch (FileNotFoundException exception) {
    		System.out.println("File not found!");
    	}
    	//System.out.println(overallRoot.data);
    }
    
	@Override
	public void add(String mcode, String ltr) {
	        SearchTreeNode current = root;
	        String signal = " ";
	 
	        for (int i = 0; i < mcode.length(); i++) {
	            signal = mcode.substring(i, i + 1);
	            if (signal.equals(".")) {
	                if (current.left != null) {
	                	System.out.println(current.left.getChar());
	                    current = current.left;
	                    //System.out.println(current.data); returns null
	                } else {
	                    current.left = new SearchTreeNode();
	                	//System.out.println(current.left.getChar());
	                    current = current.left;
	                    //System.out.println(current.data); returns null
	                }
	            } else {
	                if (current.right != null) {
	                	//System.out.println(current.right.getChar());
	                    current = current.right;
	                } else {
	                    current.right = new SearchTreeNode();
	                    current = current.right;
	                }
	            }
	        }
	        current.setLetter(ltr);
	        //System.out.println(current.getChar());
	    }	 
	
	public void inOrderPrint() {        
		//SearchTreeNode current = overallRoot; 
		SearchTreeNode current = root; 
		//System.out.println(current.data);
		printInorder(current);
	}
	
	/**
	 * called by inOrderPrint to print tree contents (helper method)
	 * @param current the node to print
	 */
	private void printInorder(SearchTreeNode current) {      
		if (current != null) {
			//System.out.println("hello");
			printInorder(current.left);
			System.out.print(current.getChar());  
			printInorder(current.right);
		}
	}



	@Override //correct
	public String deCode(String str) { //takes in morse code and returns word equivalent
		SearchTreeNode root = overallRoot;
		result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1) == ".") {
				root = root.right;
			} else if (str.substring(i, i + 1) == "-") {
				root = root.left;
			}
			result += root.data;
		}
		return result;
	}

	@Override //correct
	public String encode(String str) { //takes in word and returns morse code
		SearchTreeNode current = root;
		for (int i = 0; i < str.length(); i++) {
			String pos = "";
			pos += str.charAt(i);
			result = search(current, str, pos);
		}
		return result;
	}
	
	//correct
	public String search(SearchTreeNode root, String string, String letter) {
		if (root.getChar() == letter) {
			return string;
		} else { 
			if (root.left != null) {
				string += "-";
				return search(root.left, string, letter);
			} else if (root.right != null) {
				string += ".";
				return search(root.right, string, letter);
			}
			return string;
		}
	}	
	


	@Override
	public void orderPrint(SearchTreeNode node) {
		
	}
	
	/*public void printSideways() {
		SearchTreeNode current = root;
		printSideways(root, 0);
	}*/

	/*private void printSideways(SearchTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
	}*/

	/*private void printSideways(SearchTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
	}*/
	
    /*private String toString(SearchTreeNode root) { //prints tree as String
    	if (root == null) { //empty tree
    		return "empty";
    	}
    	
    	if (root.right == null && root.left == null) { //root only case
    		return "" + root.data;
    	} 
    	
    	return "(" + root.data + ", " + toString(root.left) + ", " + toString(root.right) + ")";
    	
    }*/
    
   /*public String toString() { //runs private method
       //SearchTreeNode current = root;    	
    	return toString(overallRoot);
    }*/

	

}

     

