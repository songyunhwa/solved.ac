import java.io.*;
import java.util.*;
class Main {
	public static class line{
		int x;
		int w;
		public line(int x, int w){
			this.x = x;
			this.w = w;
		}
	}
	public static int n =0;
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		ArrayList<ArrayList<line>> arr = new ArrayList<>();
		for(int i=0; i<=n; i++){
			arr.add(new ArrayList<>());
		}
		int low = 0;
		int high = 0;
		for(int i=0; i<n; i++){
			str = br.readLine().split(" ");
			int a= Integer.parseInt(str[0]);
			int b= Integer.parseInt(str[1]);
			int c= Integer.parseInt(str[2]);
			arr.get(a).add(new line(b,c));
			high = Math.max(high, c);
		}
		str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);

		while(low <= high){
			int mid = (low+high)/2;

			boolean find = bfs(a, b, arr , mid);
			if(find){
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		System.out.println(high);
	
	}
	public static boolean bfs(int a, int b, ArrayList<ArrayList<line>> arr , int cnt){
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[n+1];
		q.add(a);
		while(!q.isEmpty()){
			int now = q.poll();
			visit[now] = 1;
			
			if(now == b) {
				return true;
			}
			for(int i=0; i< arr.get(now).size(); i++){
				line next = arr.get(now).get(i);
				if(visit[next.x] == 0 && next.w >= cnt){
					q.add(next.x);
				}
			}
		}
		return false;
	}
}