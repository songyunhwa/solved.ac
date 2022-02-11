
import java.io.*;
import java.util.*;

import javax.tools.JavaFileManager.Location;
class Main {

		public static int solution(int m, int n, int[][] puddles) {
			int answer = 0;
			int[][] dir = new int[m+1][n+1];

			for (int[] puddle : puddles)
				dir[puddle[0] - 1][puddle[1] - 1] = -1;

			for(int i=1; i<m; i++){
				for(int j=1; j<n; j++){
					if(dir[i][j] != -1){
						dir[i][j] = Math.min(dir[i-1][j] , dir[i][j-1]) +1;
						dir[i][j]  %=1000000007;
					}
				}
			
			}
			return dir[m-1][n-1] %1000000007;
		}
	
   	public static void main(String[] args) throws Exception {
		int[][] pad = new int[2][2];
		int result = solution(4, 3, pad);
		System.out.println(result);
	}
}