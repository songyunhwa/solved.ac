// 함수 호출로 값을 넣어서 visit 개수를 셋는데 잘 안됨.
// queue 밖에서 관리하는 게 좋다는 걸 깨달음.
import java.util.*;
import java.io.*;
class 그림 {

    public static int result =0;
    public static int result1 =0;

    public static class location {
        int x;
        int y;
        public location(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[][] arr =new int[n][m];
        int[][] visit = new int[n][m];

        for(int i=0; i<n; i++){
            strs = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 && visit[i][j] == 0){
                    visit[i][j] = 1;
                    result++;
                    Queue<location> q = new LinkedList<>();
                    q.add(new location(i, j));
                    int cnt =1;
                    while(!q.isEmpty()) {
                    
                    location front = q.poll();
                    for(int a=0; a<4; a++){
                        int x= front.x + dir[a][0];
                        int y= front.y + dir[a][1];
                        if(x >=0 && x<arr.length && y>=0 && y<arr[0].length){
                            if(visit[x][y] == 0 && arr[x][y] == 1){
                                visit[x][y] = 1;
                                q.add(new location(x,y));
                                cnt++;
                            }
                        }
            
                    }
                    }
                    result1 = Math.max(result1, cnt);
                }
            }
        }
       
        System.out.println(result);
        System.out.println(result1);
        return;
    }


}
