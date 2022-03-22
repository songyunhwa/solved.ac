
import java.io.*;
import java.util.*;

class Main {
	public static class line {
		int i;
		int j;
		int x_cnt;
		public line(int i, int j, int x_cnt){
			this.i=i;
			this.j=j;
			this.x_cnt = x_cnt;
		}
		
	}
	public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static int result = Integer.MAX_VALUE;
	public static void bfs(String[][] arr , int i, int j, int i1, int j1){
		Queue<line> q = new LinkedList<>();
		q.add(new line(i, j,  0));
		int [][] visit= new int[arr.length][arr[0].length];
		while(!q.isEmpty()){
			line f= q.poll();
			visit[f.i][f.j]=  1;
			

			for(int t=0; t<4; t++){
				int x = f.i + dir[t][0];
				int y = f.j + dir[t][1];
		
				if(x>=0 && x<arr.length && y>=0 && y<arr[0].length){
					if( arr[x][y].equals("L")  && visit[x][y] ==0){
						result = Math.min(result, f.x_cnt/2 + f.x_cnt%2);
						continue;
					}	

					if(visit[x][y] == 0){
					if(arr[x][y].equals("X"))
					q.add(new line(x,y, f.x_cnt+1));
					else
					q.add(new line(x,y, f.x_cnt));
					}

				}	

			}
		}
	}
   	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k =Integer.parseInt(str[1]);

		int x=-1;
		int y=-1;
		int x1=0;
		int y1=0;
		String[][] arr = new String[n][k];
		for(int i=0; i<n; i++){
			String str1 =br.readLine();
			for(int j=0; j<k; j++){
				arr[i][j] = str1.substring(j, j+1);

				if(arr[i][j].equals("L")){
					if(x==-1 && y==-1){
						x=i;
						y=j;
					}else {
						x1=i;
						y1=j;
					}
				}
			}
		}

		bfs(arr, x, y ,x1, y1);
		System.out.println(result);
	}
}