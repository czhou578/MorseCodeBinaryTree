
public class DemoClient {

	public static void main(String[] args) {
       MorseCoder mc = new MorseCoder();
       System.out.println("Tree printed out using inorder traversal.");
       mc.inOrderPrint();
       
  	   System.out.println();
  	   
  	   System.out.println("Decode Test 1");
       String str = "... --- ..."; 
       System.out.println(str + "should decode to: sos");
       System.out.println("Decodes to: " + mc.decode(str));
       System.out.println();
       
  	   System.out.println("Decode Test 2");
       String str2 = "... .--- "; 
       System.out.println(str2 + "should decode to: s1");
       System.out.println("Decodes to: " + mc.decode(str2));
       System.out.println();

       
  	   /*System.out.println("Encode Test 1");
       String str2 = "z"; 
       System.out.println("str = " + str2);
       System.out.println("str should encode to: --..");
       System.out.println("encode(str) = " + mc.encode(str2));*/

	}

}
