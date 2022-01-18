
import java.io.*;
import java.util.*;
class Main {
	public static int n;
	public static int result ;
	public static void check(String[][] arr ) {
		for(int i=0; i<n; i++){
			int cnt = 1;
			for(int j=1; j<n; j++){
				// 행마다
				result = Math.max(result ,cnt);
				if(arr[i][j-1].equals(arr[i][j])){
					cnt++;
				}else cnt=0;
			}
			
			cnt = 1;
			for(int j=1; j<n; j++){
				result = Math.max(result ,cnt);
				if(arr[j-1][i].equals(arr[j][i])){
						cnt++;
				}else cnt=0;
			}
		
		}
	}
   	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][n];
		for(int i=0; i<n; i++){
			String str = br.readLine();
			for(int j=0; j<n; j++){
				arr[i][j] = str.substring(j,j+1);
			}
		}
		 result =0;
		
		 /// 위아래로 바꿔주고 
		///check 함수 불러주면됨..
		// 어렵게 생각안하고 정말 구현만 해주면 됬음.
		System.out.println(result);
	}
}