import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : numbers){
            al.add(num);
        }
        Collections.sort(al,(a,b)->compare2(a,b));
        StringBuilder sb = new StringBuilder();
        if(al.get(0)==0) return "0";
        for(int num : al){
            sb.append(num);
        }
        answer = sb.toString();
        return answer;
    }
    int compare(int a, int b){
        int headA = head(a);
        int headB = head(b);
        while(a<1000&&a>0) a = a*10+headA;
        while(b<1000&&b>0) b = b*10+headB;
        return b-a;
    }
    int compare2(int a, int b){
        String ab = String.valueOf(a)+String.valueOf(b);
        String ba = String.valueOf(b)+String.valueOf(a);
        return ba.compareTo(ab);
    }
    int head(int a){
        while(a>=10) a=a/10;
        return a;
    }
}