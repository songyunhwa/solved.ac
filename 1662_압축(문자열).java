public class 1662_압축(문자열) {
    //반례
// 15(22)13(92(1111)42(222))
//60

//15(22)13(92(1111)42(222))123(1)45
//67

///못해결
//stck + 재귀로 해결하신 분 https://escapefromcoding.tistory.com/158
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String strs = br.readLine();
    

    Stack<Integer> st = new Stack();
    String sub = "";
   
    for(int i=0; i<strs.length(); i++){            
        if(strs.charAt(i) == '('){
            st.push(Integer.parseInt(sub));
            sub= "";
        }
        else if(strs.charAt(i) == ')'){
            if(sub.length() > 0)
            st.push(Integer.parseInt(sub));
            sub= "";
        }else{
            sub+=strs.charAt(i);
        }
    }

    int end = 0;
    int cnt =0;
    while(!st.empty()){
        if(cnt == 0){ // 처음일 때
        end = Integer.toString(st.pop()).length();
        cnt++;
        }
        else{
            int now = st.pop();
            String nowString = Integer.toString(now);
            String endString = nowString.substring(nowString.length()-1);
            int result =  end *  Integer.parseInt(endString);
            end = (nowString.length()-1 + result);
        }
    }
    if(sub.length() > 0) {
        end += Integer.parseInt(sub);
    }
    System.out.println(end);
}
}
