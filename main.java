import java.io.*;
import java.util.*;
class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
	 	 arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;
		int a =0;
		int b =n-1;
		int r1 =0;
		int r2 = 0;
		while(a<b){
			int sum = arr[a] + arr[b];
	
			if(Math.abs(result) > Math.abs(sum)){
				result = sum;
				r1 = arr[a];
				r2 = arr[b];
				
				if(sum ==0 )break;
			}
			if(sum < 0){
				a++; // 음수면 최하를 올려줌.
			}else {
				b--;
			}
		}	

		System.out.println(r2 + " " + r1);

	}
}