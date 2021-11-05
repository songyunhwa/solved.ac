public class 조합_도영이가만든맛있는음식 {
    public static int result=Integer.MAX_VALUE;
    public static void go(int[][] arr, int i ,int v, int v1){
        
        if(i!=0 && v!=1 && v1!=0)
            result = Math.min(result, Math.abs(v1-v));
        if(arr.length == i){
                return;
        }
        go(arr, i+1, v*arr[i][0], v1+arr[i][1]);
        go(arr, i+1, v, v1);
    }
  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int a = 1;
        int b=0;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strs[0]);
            arr[i][1] = Integer.parseInt(strs[1]);
        }
       
        go(arr, 0,1, 0);
        System.out.println(result);
        

    }

}
