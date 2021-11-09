public class 완전탐색_모음사전 {
    public static char[] dir = {'A', 'E', 'I', 'O', 'U'};
	public static ArrayList<String> q = new ArrayList<String>(); 
	public static void func(String a, int len){
		if(a.length() == len){
			q.add(a);
			return;
		}
		for(int i=0; i<5; i++){
			func(a + (char)dir[i] , len);
		}
	}
	public static int solution(String word) {
        int answer = 0;
		
		for(int i=1; i<=5; i++){
			func("", i);
		}
		Collections.sort(q);
		int cnt=1;
		while(!q.isEmpty()){
			if(q.get(cnt).equals(word)){
				answer = cnt;
				break;
			}
			cnt++;
		}
        return answer+1;
    }
    
	public static void main(String[] args) throws Exception {
		int answer = solution("I");
		System.out.println(answer);
	}
}
