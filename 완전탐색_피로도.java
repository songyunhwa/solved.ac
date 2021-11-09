public class 완전탐색_피로도 {
    // 최소 필요 피로도
    // 소모피로도
    // 한가지만 두고 보면 안되서 완전 탐색
    public static class line {
		int v;
		ArrayList<Integer> arr;
		public line(int v, ArrayList<Integer> arr){
			this.v = v;
			this.arr = arr;
		}
	}
	public static int solution(int k, int[][] dungeons) {
		int answer = -1;
		Queue<line> q = new LinkedList<line>();
		q.add(new line(k, new ArrayList<Integer>()));
		
		while(!q.isEmpty()){
			line l = q.poll();
			answer = Math.max(answer , l.arr.size());
			for(int i=0; i<dungeons.length; i++){
				if(!l.arr.contains(i)){
					if(l.v - dungeons[i][1] >=0 && l.v >= dungeons[i][0]){
						ArrayList<Integer> arr1 = new ArrayList<>();
						for(int j=0; j<l.arr.size(); j++){
							arr1.add(l.arr.get(j));
						}
						arr1.add(i);
						q.add(new line(l.v-dungeons[i][1]  , arr1));
					}
				}
			}
		}
		
        return answer;
	}
    
	public static void main(String[] args) throws Exception {
		int k = 80;
		int[][] dungeons= {{80,20},{50,40},{30,10}};

		int answer = solution(k, dungeons);
		System.out.println(answer);
	}
}
