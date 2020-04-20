
public class MorseClient {
     public static void main(String[]args) {
    	 MorseSearchTree tree = new MorseSearchTree();
    	 tree.inOrderPrint();
    	 
    	 System.out.println();
    	 System.out.println("Decode Test 1");
         String str = "... --- ..."; 
         System.out.println("str = " + str);
         System.out.println("str should decode to: sos");
         System.out.println("decode(str) = " + tree.deCode(str));
         //testResults("sos", tree.deCode(str));
         
    	 System.out.println("Encode Test 1");
         String str2 = "z"; 
         System.out.println("str = " + str2);
         System.out.println("str should decode to: --..");
        System.out.println("decode(str) = " + tree.encode(str2));
         
    	 
     }
}
