public class 트랙킹_암호만들기 {
    public static int l;
    public static void back(String[] arr , int n, String sub){
        if(sub.length() == l){
            int a=0;
            int b=0;
            for(int i=0; i<l; i++){
                if(sub.substring(i, i+1).equals("a") ||
                sub.substring(i, i+1).equals("e") ||
                sub.substring(i, i+1).equals("i") ||
                sub.substring(i, i+1).equals("o") ||
                sub.substring(i, i+1).equals("u")){
                    a++;
                }else b++;
            }

            if(a >= 1 && b>=2) {
                System.out.println(sub);
            }
            return;
        }
        
        if(n == arr.length) return;
        
            back(arr , n+1, sub + arr[n]);
            back(arr , n+1, sub );

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        l = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        strs = br.readLine().split(" ");
        String[] arr = new String[m];
        for(int i=0; i<m ; i++){
            arr[i] = strs[i];
        }
        Arrays.sort(arr);
        back(arr, 0, "");
    } 

}
