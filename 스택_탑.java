// 처음에 이런식으로 했는데 맨처음 큰값이 들어오면 다 나가버림.
  //for(int i=n-1;i >=0; i--){
// while(!st.isEmpty()) {
//   if(arr[i] >= st.peek()){
//     st.pop();
//   }else break;
// }
result[i] = st.size();
}

  public static class line{
    int v;
    int i;
    public line(int v, int i){
      this.v = v;
      this.i = i;
    }
  }
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] arr =new int[n];
        int[] result =new int[n];

        Stack<line> st = new Stack<>();

        for(int i=0; i<n; i++){
          arr[i] =Integer.parseInt(strs[i]);
        
          while(!st.isEmpty() && i>0) {
            if(arr[i] > st.peek().v){
              st.pop();
            }else break;
          }
          if(i>0 && !st.isEmpty())
          result[i] = st.peek().i;

          st.push(new line(arr[i], i+1));
        }
        for(int i=0; i<n; i++)
          System.out.print(result[i] + " ");
    }

