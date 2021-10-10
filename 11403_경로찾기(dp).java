public class 11403_경로찾기(dp) {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr =new int[n][n];

        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                if(Integer.parseInt(strs[j]) == 1) {
                   arr[i][j] = 1; 
                }
            }
        }
    
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][k] ==1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }
        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
