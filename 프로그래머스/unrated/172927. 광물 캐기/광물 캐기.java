import java.util.Arrays;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        //한번 선택하면 5개 캐야한다.
        int dia = picks[0]; // 1 1 1
        int iron = picks[1]; // 5 1 1
        int stone = picks[2]; // 25 5 1
        int idx = 0;
        int max = (dia+stone+iron) * 5; //최대 광물의 수
        int len;
        if(minerals.length%5==0) len = minerals.length/5;
        else len = minerals.length/5+1;
        if(len*5>max) len = dia+stone+iron;
        int[][] cnt = new int[len][3];
        int i = 0;
        
        int num = 0;
        for(String mineral : minerals){
            if(mineral.equals("diamond")) cnt[i][0]++;
            else if (mineral.equals("iron")) cnt[i][1]++;
            else cnt[i][2]++;
            idx++;
            if(idx==5){
                idx = 0;
                i++;
            }
            num++;
            if(num == max) break;
        }
        Arrays.sort(cnt,(a,b) -> (a[0] != b[0] ? b[0]-a[0] : b[1]-a[1]));
        for(int[] c : cnt){
            if(dia>0){
                dia--;
                answer += c[0]+c[1]+c[2];
            }else if(iron>0){
                iron--;
                answer += 5*c[0]+c[1]+c[2];
            }else if(stone>0){
                stone--;
                answer += 25*c[0]+5*c[1]+c[2];
            }else{
                break;
            }
        }
        return answer;
    }
}