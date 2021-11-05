public class 백트래킹,bfs_연구소 {
    public static int[][] arr1 ;
    public static int n;
    public static int m;

    public static class line{
        int x;
        int y;
        public line(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int result=0;
    public static void bfs(){
        Queue<line> q = new LinkedList<line>();
        
        // 벽을 세운것 복사
        int[][] arr =new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = arr1[i][j];
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 2){
                    q.add(new line(i,j));
                }
            }
        }

        int[][] dir = {{-1, 0} , {1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            line now = q.poll();
          
            for(int c=0; c<4; c++){
            int i = now.x +dir[c][0];
            int j = now.y +dir[c][1];
            if(i>=0 && i<n && j>=0 && j<m){
                if(arr[i][j] == 0){
                arr[i][j] = 2;
                q.add(new line(i, j));
                }
            }
         }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        result = Math.max(result , cnt);
        //System.out.println(result);
    }
    public static void Possibility(int cnt){
        if(cnt == 3){
            bfs();
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr1[i][j] == 0){
                    arr1[i][j] = 1;
                    Possibility(cnt+1);
                    arr1[i][j] = 0;
                }
            }
        }
        
    
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        arr1 = new int[n][m];
        for(int i=0; i<n; i++){
            strs = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr1[i][j] = Integer.parseInt(strs[j]);
            }
        }
        Possibility(0);
        System.out.println(result);
    } 

}
