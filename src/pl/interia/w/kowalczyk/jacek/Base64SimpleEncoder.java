/**
 * 
 */
package pl.interia.w.kowalczyk.jacek;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author kowalczykj
 *
 */
public class Base64SimpleEncoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Base64SimpleEncoder b64 = new Base64SimpleEncoder();
        String output= null;
        
		if (args.length>0){
			for (int i=0; i <args.length; i++){
					
	            System.out.println(args[i]+" --Base64--> "+b64.encodeBase64(args[i]));
				System.out.println("\n");

			}
		}

	}
	
	public String encodeBase64(String in){
		String output= null;
		byte [] input = in.getBytes();
        output = Base64.encode(input);
        output = output.substring(0, output.length()-1);
		return output;
	}

}
