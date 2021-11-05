public class 창고다각형 {
    // arr 에다가 높이 집어넣고
    // 양쪽 끝에서 최고 값을 구해주며 더해가기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int max_y =0;
        int mx=0;
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            arr[x] = y;
            if(max_y< y){
                max_y = y;
                mx= x;
            }
        }

        int result = 0;
        int front = 0;
        for(int i=0; i<mx; i++){
            front = Math.max(front, arr[i]);
            result += front;
        }
        int end =0;
        for(int j=1000; j>=mx; j--){
            end = Math.max(end, arr[j]);
            result += end;
        }
        System.out.println(result);
    }

}
