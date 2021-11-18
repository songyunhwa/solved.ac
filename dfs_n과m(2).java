public class dfs_n과m(2) {
    public static ArrayList<String> result = new ArrayList<>();
	public static void dfs(int now, int n, int m, ArrayList<Integer> arr) {
		if(arr.size() == m){
			String s= "";
			for(int i=0; i<arr.size(); i++){
				s+= arr.get(i) + " ";
			}
			result.add(s);
			return;
		}
		if(now == n+1) {
			return;
		}
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		for(int i=0; i<arr.size(); i++)arr1.add(arr.get(i));
		dfs(now+1,n, m, arr1);
		arr1.add(now);
		dfs(now+1,n, m, arr1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);

		dfs(1, n, m, new ArrayList<Integer>());
		Collections.sort(result);
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i));
		}
		//System.out.println(answer);
	}
}
