import java.io.*;
import java.util.*;

class Main {
	public static ArrayList<ArrayList<Integer>> arr;

	public static boolean error= false;
	public static int[] color;
	public static void dfs(int ff){
		Stack<Integer> st = new Stack<>();
		st.push(ff);
		color[ff] = 1;
		while(!st.isEmpty() ) {
			int f= st.pop();

			for(int j=0; j<arr.get(f).size(); j++){
				int next = arr.get(f).get(j);
				if(color[next] == 0){
					if(color[f] == 1){
						color[next] = 2;
					}
					if(color[f] == 2){
						color[next] = 1;
					}
					st.push(next);
				}
				if(color[next] == 1 && color[f] == 1){
					error = true;
					break;
				}
				if(color[next] == 2 && color[f] == 2){
					error= true;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str ;
		for(int i=0; i<n; i++){
			str  = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			color = new int[a+1];

			arr =new ArrayList<>();
			for(int j=0; j<=a; j++){
				arr.add(new ArrayList<Integer>());
			}
			for(int j=0; j<b; j++){
				str = br.readLine().split(" ");
				// 그래프는 서로 연결해주는 것 잊지 말것.
				arr.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
				arr.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
			}

			error= false;
		
			for(int j=1; j<=a; j++){
				if(color[j] == 0) {
					dfs(j);
				} 
			}

			
		if(error){
			System.out.println("NO");
		}else System.out.println("YES");
	}
}
}
