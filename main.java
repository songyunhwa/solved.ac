import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str1 = br.readLine();

		Stack st = new Stack<>();
		for(int i=0;i <str.length(); i++){
			st.add(str.substring(i, i+1));
			if(st.size()>= str1.length()) {
				boolean eq = true;
				for(int j=0; j<str1.length(); j++){
					if(!st.get(st.size() - str1.length() + j).equals(str1.substring(j, j+1))){
						eq = false;
						break;
					}
				}
				if(eq){
					for(int j=0; j<str1.length(); j++) st.pop();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()){
		  sb.insert(0, st.pop());
		}

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}
}
