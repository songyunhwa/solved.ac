import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
		String[] str = br.readLine().split(" ");

		if(Integer.parseInt(str[0]) == 0 && str.length == 1){
			break;
		}
		int[] histo = new int[str.length];
		for(int i=0; i<str.length; i++){
			histo[i] = Integer.parseInt(str[i]);
		}

		Stack<Integer> st = new Stack<>();
		int result = 0;
		
		// 지금 것보다 큰걸 빼면서 너비 * 높이 비교
		for(int i=0; i<str.length; i++){
			while(!st.isEmpty()){
				int p = st.peek();
				
				if(histo[p] >= Integer.parseInt(str[i])){
					int height = histo[st.pop()];
					int width = i-p;
					result = Math.max( result, height * width);
					
				}else break;
			}
			st.push(i);
		}

		// 남은 거에서 너비 * 높이 비교
		// 나머지 크기가 똑같은 경우가 있고
		// 조금만 남아있는 경우가 있음. 구분해서 해줘야함.
		while(!st.isEmpty()){
			int height = histo[st.pop()];
			int width = st.isEmpty()  ? histo.length : histo.length - 1 - st.peek();
			result = Math.max(result, height * width);
		
		}
		System.out.println(result);
		}
	}
}