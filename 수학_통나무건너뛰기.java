public class 수학_통나무건너뛰기 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]); // 줄
        ArrayList<Integer> arr =new ArrayList<>();
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            strs = br.readLine().split(" ");
            arr.clear();
            
            for(int j=0; j<k; j++){
                arr.add(Integer.parseInt(strs[j]));
            }
            Collections.sort(arr, Collections.reverseOrder());
            int cnt =0;
            
            int max=0;
            for(int j=0; j<k-2; j+=2){
                max = Math.max(max, arr.get(j) - arr.get(j+2));
            }
       
    
            System.out.println(max);
        }
        
    }
}
