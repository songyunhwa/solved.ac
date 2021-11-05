public class 수건돌리기(조세퍼스순열) {
    // 브루트 포스 - 부분 성공
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        int[] visit = new int[n+1];
        visit[1] = 1;
        int now =1;
        int cnt = 1;
        int zero =0;
        while(true){
    
            for(int i=1; i<=n; i++){
                if(visit[i] == 0) zero++;
                if(zero == 2) {
                    visit[i] = 1;
                    cnt++;
                    zero = 0;
                }
                if(cnt==k){
                    System.out.println(i);
                    return;
                }
            }
            
        }

       
    }
    
    
}
