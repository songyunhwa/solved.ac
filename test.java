1.


    public static void main(String[] args) throws IOException{
        int leave= 4;
        String day="FRI"	;
        int[] holidays  ={6, 21, 23, 27, 28};
        int result = solution(leave, day, holidays);
        System.out.println(result);
    }
    
    class days implements Comparable<days>{
        int dp; // 연차수
        int start; // 
        int end; // 
        public days(int d, int s, int e){
            this.dp =d;
            this.start= s;
            this.end = e;
        }
        @Override
        public int compareTo(days o){
            if(this.dp > o.dp){
                return -1;
            }else return 1;
        }
    }
    public static int solution(int leave, String day, int[] holidays) {
        int answer = 0;
        String[] days = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        String[] news = new String[7];
        int dd= 0; // 현재 요일
        for(int i=0; i<days.length; i++){
            if(day.equals(days[i])){
                dd = i;
                break;
            }
        }
        int[] dp = new int[31];
            for(int i=1;i <=30; i++){
                if(dd == 5 || dd == 6){
                    dp[i] = -1;
                }
                dd++;
                if(dd==7) dd=0;
                
                if(dp[i] != -1) dp[i] =1;
            }
            for(int i=0; i<holidays.length; i++){
                dp[holidays[i]] = -1;
            }
      
            Queue<days> pq = new LinkedList<>();
            for(int i=2; i<=30; i++){
                if(dp[i] > 0){ // 휴일이 아닐때
                    dp[i] = dp[i] + dp[i-1];
                }else { // 휴일일 때
                    
                    if(dp[i-1]>0) 
                    pq.add(new days(dp[i-1], i-dp[i-1]-1,i));
                }
            }
            ArrayList<Integer> arr = new ArrayList<>();
            while(!pq.isEmpty()){
                days now = pq.poll();
                if(leave-now.dp >=0){
                    leave-=now.dp;
                    answer+= now.dp;
                    if(!arr.contains(now.start)){
                        answer+=1;
                    }
                }
            }
        
        return answer;
    }


2.

    public String change(String input){
                String s ="";
            String n ="";
        for(int i=0; i<input.length(); i++){
            int a = input.charAt(i);
            if(a>=48 && a<=59){
                s+= input.substring(i,i+1);
              
            }else if(a>=65 && a<=122){
                n+= input.substring(i,i+1);
            } 
        }
        int s1 = 0;
if(s.length() >0){
s1 = Integer.parseInt(s);
s1 +=1;
}else {
    s1 = 1;
}
return n + Integer.toString(s1);
   
        
    }
    public String check(String[] registered_list, String new_id){
     
        boolean equal = false;
        
        for(int i=0; i< registered_list.length; i++){
            if(new_id.equals(registered_list[i])){
                equal = true;
                break;
            }
        }
        
if(equal) {
    String result = change(new_id);
    result = check(registered_list, result);
    return result;
}else {
    return new_id;
}
        
    }
    public String solution(String[] registered_list, String new_id) {
        String answer = "";
     String result = "";
    
    result = check(registered_list, new_id);       
        return result;
    }
}

3.

SELECT a.ID, a.NAME FROM 
(SELECT s.ID, s.NAME, l.LINE_COLOR FROM SUBWAY_STATIONS as s LEFT JOIN
 LINE_ROUTES  as l
on s.ID = l.STATION_ID
ORDER BY s.ID) as a
WHERE a.LINE_COLOR != "Red" and a.LINE_COLOR != "Green"