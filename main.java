
import java.io.*;
import java.util.*;
class Main {
	public static class line implements Comparable<line>{
		int x;
		int y;
		int n;		
		int time;
		public line(int x , int y, int time){
			this.x =x;
			this.y =y;
			this.time= time;
		}
		@Override
		public int compareTo(line o){
			if(this.y < o.y){ // y 랑 x 가 클수록 앞에
				return -1;
			}else if(this.y == o.y){
				if(this.x < this.y){
					return -1;
				}else if(this.x == this.y ){
					return 0;
				}
				return 1;
			}else return 1;
		}
		}
	public static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	public static int time =0;
	public static int nn =0;
	public static int fishSize = 2;
	public static int sumSize = 0;
	public static void go(int[][] arr, Queue<line> q){
		
		ArrayList<line> fishs = new ArrayList<line>();
		boolean find = false;
		while(true){
	
		int[][] visit = new int[nn][nn];
		while(!q.isEmpty()){
			line n = q.poll();
			visit[n.x][n.y ] = 1;
			if(find) break;

			for(int i=0; i<4; i++){
				int x= n.x + dir[i][0];
				int y= n.y + dir[i][1];
				if( x>=0 && x <nn && y>=0 && y<nn){
					if(fishSize >= arr[x][y] && visit[x][y] == 0){
						visit[x][y] = 1;
						if(arr[x][y] > 0){
							find = true;
							visit[x][y] =0;
							fishs.add(new line(x,y,n.time+1));	
						}
						q.add(new line(x,y,n.time+1));

					}
				}

			}
		}
		if(fishs.size() > 0){
				Collections.sort(fishs);
				line first = fishs.get(0);
				//System.out.println(first.time);
				fishs.remove(first);
				time += first.time;

				sumSize += arr[first.x][first.y];
				arr[first.x][first.y] = 0;
				if(sumSize == fishSize){
					sumSize =0;
					fishSize+=1;
				} 
				find = false;
				q.clear();
				// 영으로 초기화해서 상어가 다음으로 갈길을 정함.
				q.add(new line(first.x, first.y, 0));
				fishs.clear();
		}else break;
		
	}

}	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nn = Integer.parseInt(br.readLine());
		int[][] arr =new int[nn][nn];
		Queue<line> q = new LinkedList<>();
		for(int i=0; i<nn; i++){
			String[] str = br.readLine().split(" ");
			for(int j=0; j<nn; j++){
				arr[i][j]  = Integer.parseInt(str[j]);
				if(arr[i][j] == 9) q.add(new line(i, j, 1));
			}
		}

		go(arr, q);
		
		System.out.println(time);
	}
}