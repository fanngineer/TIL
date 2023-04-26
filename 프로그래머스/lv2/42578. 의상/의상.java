import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            String key = cloth[1];
            if(map.containsKey(key)){
                int cnt = map.get(key);
                cnt++;
                map.put(key,cnt);
                // map.get(cloth[1]);
            }else{
                map.put(key,1);
            }
        }
        for(String key : map.keySet()){
            answer *= map.get(key)+1;
        }
        answer--;
        return answer;
    }
}