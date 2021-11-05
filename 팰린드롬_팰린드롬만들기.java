public class 팰린드롬_팰린드롬만들기 {
    public static boolean is_equal(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strs = br.readLine();
        
        if(is_equal(strs)){
            System.out.println(strs.length());
            return;
        }
        
        for(int i=0; i<strs.length(); i++){
            String sub =strs;
            for(int j=i; j>=0; j--)
                sub = sub + strs.substring(j, j+1);

            if(is_equal(sub)){
                System.out.println(sub.length());
                return;
            }
        }

    }

}
