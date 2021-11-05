public class 격자상의경로(dfs+dp) {
    public static int[][] arr;
    public static int result =0;
    public static int kx;
    public static int ky;
    public static int[][] visit;
    public static int[][] dp;
    public static int dfs(int i, int j){
        if(i == kx && j == ky){
            return dp[i][j];
        }

        int[][] dir={{0, 1}, {1, 0}};

        visit[i][j] = 1;

        for(int a=0; a<2; a++){
            int x= i + dir[a][0];
            int y = j + dir[a][1];

            if(x>=0 && x<arr.length && y>=0 && y<arr[0].length){
                if(visit[x][y] == 0) {
                    // 방문 안했을 떄 
                    dp[i][j] += dfs(x,y);
                }else {
                    // 방문 했을 떄
                    dp[i][j] += dp[x][y];                }
            }
        }
        return dp[i][j];
    }

    public static int sum(int start , int end) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                visit[i][j] =0;
                dp[i][j] = 0;
            }
        }
        dp[kx][ky] = 1;
         dfs(start, end);
         return dp[start][end];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);

        arr =new int[n][m];
        visit = new int[n][m];
        dp = new int[n][m];
        int cnt = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = cnt++;
                if(arr[i][j] == k){
                    kx= i;
                    ky = j;
                }
            }
        }

        //기점을 가운데에 놓고 구하기.
        System.out.println(sum(0,0) + sum(n-1, m-1));

        return;
    }
}
