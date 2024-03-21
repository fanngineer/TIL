
class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' ') {flag = 1; sb.append(c); continue;}
            
            if(c<='Z' &&c>='A' && flag !=1) 
            {
                c = (char) (c-'A'+'a'); //대문자이고 처음오는게 아니면 전부 소문자
            }
            if(c>='a' && c<='z' && flag==1) {
                c = (char) (c-'a'+'A');
            }
            flag = 0;
            sb.append(c);
        }
        
        return sb.toString();
    }
}