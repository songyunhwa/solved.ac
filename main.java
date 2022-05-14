import java.io.*;
import java.util.*;

class Main {
	public static int[] findParent;
	public static int n;
	public static ArrayList<ArrayList<Integer>>  arr;
	public static void dfs(int now){
		for(int next : arr.get(now)){
			if(findParent[next] == 0){
				findParent[next] = now;
				dfs(next);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i=0; i<=n ;i++){
			arr.add(new ArrayList<>());
		}
		findParent = new int[n+1];
		String[] str;


		for(int i=1; i<n; i++){
			str = br.readLine().split(" ");
			int a  = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		dfs(1);
		for(int i=2; i<= n; i++){
			System.out.println(findParent[i]);
		}
	}
}
