
import java.io.*;
import java.util.*;
import java.util.*;

import javax.tools.JavaFileManager.Location;
class Main {
	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 1;
        int end = distance;
        
        Arrays.sort(rocks);
        while(start <= end){
            int mid = (start + end )/ 2; // 돌맹이 가운데의 거리 최솟값 중 최대
            int rock =0; // 빼야하는 돌맹이 수
            int prev = 0;
            
            for(int i=0; i<rocks.length; i++){
                if(rocks[i] - prev < mid){
                    rock++;  // 거리가 작으면 그대로 돌맹이를 빼기
                   
                }else  prev = rocks[i]; // 아니면 돌맹이를 빼지 않기.
            }
            if(distance - prev < mid) rock++;
            System.out.println(rock + "  :  " + mid + "  " + start + "  "  + end);
		
            if(rock >= n){ // 돌을 너무 많이 뽑았다면 최솟값을 줄여야 함
				answer = end;
                end = mid-1;
				
            }else {
                start = mid+1;
		
            }
            
        }
        
        return answer;
    }
	
   	public static void main(String[] args) throws Exception {
		int[] arr = {6,7,8,9};

		int result = solution(10, arr, 3);

		System.out.println(result);
	}
}