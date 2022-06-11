import java.io.*;
import java.util.*;

class Main {
	public static int solution(String str1, String str2) {
        int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> inter = new ArrayList<>();

		for(int i=0; i<str1.length(); i++){
			if(i+2 <= str1.length()){
				if(str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z' 
				&&str1.charAt(i+1) >= 'a' && str1.charAt(i+1) <= 'z')			
					arr1.add(str1.substring(i,i+2));
			}
		}
		for(int i=0; i<str2.length(); i++){
			if(i+2 <= str2.length()){
				if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' 
				&&str2.charAt(i+1) >= 'a' && str2.charAt(i+1) <= 'z')
					arr2.add(str2.substring(i,i+2));
			}
		}

		for(int i=0; i<arr1.size(); i++){
			//union 을 만들기 위해서 union 에 들어가는 값을 없애기
			if(arr2.contains(arr1.get(i))){
				arr2.remove(arr1.get(i));
				inter.add(arr1.get(i));
			}

			union.add(arr1.get(i));
		}
		for(int i=0; i<arr2.size(); i++){
			union.add(arr2.get(i));
		}
		double ans = (double)inter.size() /union.size();
        answer = (int)(ans * 65536);
		return answer;
    }
	public static void main(String[] args) throws Exception {
		int n= 4;
		String s = "handshake";
		String s1 = "shake hands";
		int ans = solution(s, s1);
		System.out.println(ans);
	}
}

