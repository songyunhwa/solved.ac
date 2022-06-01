import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str;
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			str = br.readLine().split(" ");
			int[] arr =new int[a+1];
			for(int j=0; j<a; j++){
				arr[j+1] = Integer.parseInt(str[j]);
			}
			ArrayList<ArrayList<>> arr1 = new ArrayList<>();
			for(int j=0; j<b; j++){
				str = br.readLine().split(" ");
				for(int k=0; k<2; k++){
					
				}
			}
		}
	}
}
