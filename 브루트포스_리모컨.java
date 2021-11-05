public class 브루트포스_리모컨 {
    public static int[] arr;
    public static boolean check(int s){
      // 쓰지 않는 것에 있는지 확인
      while(s>0){
        if(arr[s%10] == 1){
          return false;
        }
        s/=10;
      }
      return true;
    } 
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      int n = Integer.parseInt(br.readLine()); 
      int cnt = Integer.parseInt(br.readLine()); 
   
      if(cnt ==0) {
        System.out.println(Integer.toString(n).length());
        return;
      }
    
      String[] strs = br.readLine().split(" ");
      arr = new int[10];
      for(int i=0; i<cnt; i++){
        arr[Integer.parseInt(strs[i])] = 1;
      }
      
      if(n == 100) {
        System.out.println(0);
        return;
      }

      int result = Math.abs(n-100);
      for(int i=0; i<=1000000; i++){
        if(i == n) continue;
        if(check(i)){
          if(result > Math.abs(n-i)+ Integer.toString(i).length()){
            result = Math.abs(n-i)+ Integer.toString(i).length();
          }
        }
      }
      System.out.println(result);
    }

}
