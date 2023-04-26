import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book){
            set.add(phone);
        }
        StringBuilder sb;
        for(String phone : phone_book){
            sb = new StringBuilder();
            for(int i = 0; i<phone.length()-1; i++){
                sb.append(phone.charAt(i));
                if(set.contains(sb.toString())) return false;
           
            }
        }
        return answer;
    }
}