package sehyunict.tk.util;

public class PriceConverter {
	
	public static int toInt(String price_str) {
		int result = 0;
		try {
			result = Integer.parseInt(price_str.replace(",", ""));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("price_str parsing failed");
		}
		
		return result;
	}
	
	public static String toChar(int price) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(price);
		
		int len = sb.length();
		int offset = 3;
		
		for(int i=0; i<len/3;i++) {
			if(i==0) sb.reverse().insert(offset, ",").reverse();
			else sb.reverse().insert(offset*(i+1)+i, ",").reverse();
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	

}
