import java.io.*;
import java.util.*;
class Main {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			String[] str = new String[m];
			for(int j=0; j<m; j++){
				str[j] = br.readLine();
			}
			Arrays.sort(str);
			boolean res = false;
			
			for(int j=1; j<m; j++){
				int len = Math.min(str[j].length(), str[j-1].length());
				if(str[j].substring(0, len).equals(str[j-1].substring(0,len))){
					res = true;
				}
			}
			if(res)
			System.out.println("NO");
			else 
			System.out.println("YES");
		}
		
	
	}
}