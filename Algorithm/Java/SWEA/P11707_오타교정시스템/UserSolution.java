package P11707_오타교정시스템;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class UserSolution {

	// The below commented methods are for your reference. If you want 
	// to use it, uncomment these methods.
	//
		int mstrcmp(char[] a, char[] b) {
			int i;
			for (i = 0; a[i] != '\0'; i++) {
				if (a[i] != b[i])
					return a[i] - b[i];
			}
			return a[i] - b[i];
		}
	//
//		int mstrncmp(char[] a, char[] b, int len) {
//			for (int i = 0; i < len; i++) {
//				if (a[i] != b[i])
//					return a[i] - b[i];
//			}
//			return 0;
//		}
	//
		int mstrlen(char[] a) {
			int len = 0;
	
			while (a[len] != '\0')
				len++;
	
			return len;
		}
	//
//		void mstrcpy(char[] dest, char[] src) {
//			int i = 0;
//			while (src[i] != '\0') {
//				dest[i] = src[i];
//				i++;
//			}
//			dest[i] = src[i];
//		}
	//
//		void mstrncpy(char[] dest, char[] src, int len) {
//			for (int i = 0; i < len; i++) {
//				dest[i] = src[i];
//			}
//			dest[len] = '\0';
//		}
		
		void init(int n) {
			usersLastTime = new int[n+1]; // mId 사용자의 마지막 검색시간
			usersLastWord = new char[n+1][11]; // mId 사용자의가 마지막 검색 단어 
			DB = new HashMap<>();
			Sub = new HashMap<>();
		}
		
		HashMap<char[], HashSet<char[]>> DB;
		HashMap<char[], HashMap<char[],HashSet<Integer>>> Sub; //후보들
		
		int[] usersLastTime;
		char[][] usersLastWord;
		//최장공통부분문자열
		boolean check(char[] searchWord, char[] lastWord) {
			int lengthSearch = mstrlen(searchWord);
			int lengthLastWord = mstrlen(lastWord);
			
			if(lengthSearch == lengthLastWord) {
				int diff = 0;
				//두 단어가 같은지 체크
				for(int i = 0; i<lengthSearch; i++) {
					if(searchWord[i] != lastWord[i]) diff++;
				}
				if(diff == 1) return true;
				else return false;				
			}
			
			int[][] lcs = new int[lengthSearch+1][lengthLastWord+1];
			
			for(int i = 1; i<=lengthSearch; i++) {
				char nowS = searchWord[i-1];
				for(int j=1; j<=lengthLastWord ; j++) {
					char nowL = lastWord[j-1];
					if(nowS==nowL) lcs[i][j] = lcs[i-1][j-1]+1;
					else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
			int maxLen = lcs[lengthSearch][lengthLastWord];
			if(lengthLastWord-lengthSearch==1) {
				if(lengthSearch==maxLen) return true;
			}
			else if(lengthLastWord-lengthSearch==-1) {
				if(lengthLastWord==maxLen) return true;
			}
		
			return false;
		}
		
//		HashMap<char[], HashSet<char[]>> DB;
//		HashMap<char[], HashMap<char[],HashSet<Integer>>> Sub; //후보들
		int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
			int lastTime = usersLastTime[mId];
			char[] lastWord = usersLastWord[mId];
			
			if(!DB.containsKey(lastWord)) DB.put(lastWord, new HashSet<>());
			if(!Sub.containsKey(lastWord)) Sub.put(lastWord, new HashMap<>());
			//10초내에 검색한 이력이 있으면 비교 시작
			if(lastTime != 0 && searchTimestamp-lastTime<=10) {
				if(check(searchWord,lastWord)) {
					//기존 DB에 있는지 확인
					if(!DB.get(lastWord).contains(searchWord)) {
						//DB에 없으면 후보에 올려
						if(!Sub.get(lastWord).containsKey(searchWord)) Sub.get(lastWord).put(searchWord, new HashSet<>());
						Sub.get(lastWord).get(searchWord).add(mId);
						if(Sub.get(lastWord).get(searchWord).size()==3) {
							DB.get(lastWord).add(searchWord);
							Sub.get(lastWord).remove(searchWord);
						}
					}
				}
			}
			int cnt = 0;

			usersLastTime[mId] = searchTimestamp;
			usersLastWord[mId] = searchWord;
			
			if(!DB.containsKey(searchWord)) return 0;
			for(char[] word : DB.get(searchWord)) {
				correctWord[cnt] = word;
				cnt++;
			}
			
			
			return cnt;
		}
	}

