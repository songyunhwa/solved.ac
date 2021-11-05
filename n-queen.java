public class n-queen {
    public static int[] arr;
    public static boolean Possibility(int depth){
        
	for (int i = 0; i < depth; i++) {
		if (arr[depth] == arr[i]) { // 같은 행이 존재할 경우
			return false;
		} 
		// 열의 차와 행의 차가 같은 경우
		else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
			return false;
		}
	}
    return true;
	
    }
  
    public static int cnt=0;
    public static void queen( int depth, int n) {
        if(depth == n){
            cnt++;
            return;
        }
	    for (int i = 0; i < n; i++) {
		arr[depth] = i; // 행에 i (열) 을 선택
		if (Possibility( depth)) {
			queen(depth + 1, n);
		}
	    }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        arr= new int[n];

        queen( 0, arr.length);
        
        System.out.println(cnt);
        
    } 

}
