import java.io.*;
import java.util.*;

class Main {
	public static int[][] arr;
	public static int[] paper;
	public static int ans = Integer.MAX_VALUE;
	public static boolean check(int i, int j, int k){

		for(int x=i; x<i+k; x++){
			for(int y=j; y<j+k; y++){
				if(x > 9 || y> 9) return false;
				if(arr[x][y] == 0) return false;
			}
		}
		return true;
	}
	public static void attach(int i, int j, int k, int d){
		for(int x=i; x<i+k; x++){
			for(int y=j; y<j+k; y++){
				arr[x][y] = d;
			}
		}
	
	}
	public static void dfs(int i , int j, int cnt){
			if(j >= 9 && i>= 9) {
				ans = Math.min(ans , cnt);
				return;
			}
			if(j > 9) {
				dfs(i+1 , 0, cnt);
				return;
			}

			if(ans <= cnt) return;

			if(arr[i][j] == 1){
					for(int k=1; k<=5; k++)
						if(check(i , j ,k)){
							if(paper[k] > 0){
							paper[k]-=1;
							attach(i , j , k, 0);
							
							dfs(i, j+1 , cnt+1);
							
							paper[k]+=1;
							attach(i , j , k, 1);
							}
						}
			}
			else
			dfs(i, j+1 , cnt);
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		arr = new int[10][10];
		int s=0;
		paper = new int[6];
		Arrays.fill(paper, 5);
		for(int i=0; i<10 ; i++){
			str = br.readLine().split(" ");
			for(int j=0; j<10; j++){
				arr[i][j] =Integer.parseInt(str[j]);
				if(arr[i][j] == 1){
					s++;
				}
			}
		}
		if(s==0){
			System.out.println(0);
			return;
		}

		dfs(0,0,0);
		if(ans == Integer.MAX_VALUE)
		System.out.println(-1);
		else System.out.println(ans);


	}
}
