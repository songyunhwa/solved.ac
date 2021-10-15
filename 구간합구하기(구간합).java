//https://chanhuiseok.github.io/posts/baek-19/ 설명 잘돼있음.
public class 구간합구하기(구간합) {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<n; i++) {
            strs = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i+1][j+1] = Integer.parseInt(strs[j]);
            }
        }
   
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }
        for(int i=0; i<m; i++){
            strs = br.readLine().split(" ");
            int x1= Integer.parseInt(strs[0]);
            int y1= Integer.parseInt(strs[1]);
            int x2= Integer.parseInt(strs[2]);
            int y2= Integer.parseInt(strs[3]);
            System.out.println(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1 - 1][y1 - 1] );

        }

    }
}
