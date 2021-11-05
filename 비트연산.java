import java.io.*;
class 비트연산 {
	public static int transfer(String s){
		int v =0;
		for(int i=0; i<s.length(); i++){
			v = v * 2 + Integer.parseInt(s.substring(i, i+1));
		}
		return v;
	}
	public static String left(int n,String s){
		String result = s;
		for(int i=0; i<n; i++){
				result+= "0";
		}
		return result;
	}
	public static String right(int n ,String s){
		String result = s;
		for(int i=0; i<n; i++){
				result= "0" + result;
				if(result.length() > s.length()) result = result.substring(0, s.length());
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String a = Integer.toBinaryString(Integer.parseInt(input[0]));
		int n = Integer.parseInt(input[1]);
		
		System.out.println(transfer(right(n, a)));
		System.out.println(transfer(left(n, a)));

	}
}
