package Sehyunict.Tk.util;

public class PriceConverter {
	
	public int toInt(String price_str) {
		int result = 0;
		try {
			result = Integer.parseInt(price_str.replace(",", ""));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("price_str parsing failed");
		}
		
		return result;
	}
	
	public String toChar(int price) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(1000000000);
		
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
