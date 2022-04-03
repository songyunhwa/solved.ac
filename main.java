import java.io.*;
import java.util.*;

class Main {

	// 함수로 불러도 안에 있는 게 이어짐.
	
	public static int[][]map;
	public static int m;
	public static int bb;
	public static int[] visit;
	public static class line{
		int x;
		int y;
		public line(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
		public static class line1{
		int x;
		String path;
		int size;
		public line1(int x, String path, int size){
			this.x=x;
			this.path= path;
			this.size =size;
		}
	}
	public static void dfs(int a, int k){
		Queue<line1> q= new LinkedList<>();
		q.add(new line1(a, Integer.toString(a)+ " ", 0));
	
		while(!q.isEmpty()){
			line1 f= q.poll();

			if(f.x==bb && f.size <=k){
				System.out.println(f.path);
				String[] str = f.path.split(" ");
				for(int i=0; i< str.length; i++){
					visit[Integer.parseInt(str[i])]= 1;
				}
			}else {
				if(f.size < k)
				for(int i=1; i<=m ;i++){
				if(map[f.x][i] == 1){
					q.add(new line1(i, f.path + Integer.toString(i)  +  " ", f.size+1));
				}
           		}
            }
		}		
	}
	public static int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = -1;
		m = n;
		bb = b;
		visit = new int[n+1];

		map= new int[n+1][n+1];
		ArrayList<line> ans =new ArrayList<line>();
		for(int i=0; i<edges.length; i++){
			map[edges[i][0]][edges[i][1]] = 1;
			map[edges[i][1]][edges[i][0]] = 1;
			ans.add(new line(edges[i][0], edges[i][1]));
		}
		dfs(a, k);

		for(int i=0; i<=n ;i++){
			System.out.print(visit[i] + " ");
			if(visit[i] ==0){
				for(int j=0; j<ans.size(); j++){
					if(ans.get(j).x == i || ans.get(j).y == i){
						ans.remove(j);
					}
				}
			}
		}
		System.out.println();
		System.out.println(ans.size());
		return ans.size();

    }
	public static void main(String[] args) throws Exception {
		int[][] edges ={{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
		int answer = solution(8,edges,4,0,3);

	}
	
}