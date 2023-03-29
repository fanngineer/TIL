package P11707_오타교정시스템;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
	
	private static int n, m;
	
	private final static UserSolution usersolution = new UserSolution();
	
	private static char[][] words = new char[4000][11];
	
	private static int mstrcmp(char[] a, char[] b)
	{
		int i;
		for (i = 0; a[i] != '\0'; i++)
		{
			if (a[i] != b[i])
				return a[i] - b[i];
		}
		return a[i] - b[i];
	}

	private static void String2Char(String s, char[] b) {
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			b[i] = s.charAt(i);
		}
		b[n] = '\0';
	}
	
	private static void inputWords(int wordCnt, Scanner sc) {
		
		for (int i = 0; i < wordCnt; ++i) {
			String2Char(sc.next(), words[i]);	
		}
	}
	
	private static boolean run(int m, Scanner sc) {
		
		boolean accepted = true;
		char[][] correctWord = new char[5][11];
		char[][] answerWord = new char[5][11];
		while(m-- > 0) {
			
			int id, timestamp, correctWordN, answerWordN;
			int wordIdx;
			
			id = sc.nextInt();
			timestamp = sc.nextInt();
			wordIdx = sc.nextInt();
			
			correctWordN = usersolution.search(id, timestamp, words[wordIdx], correctWord);
			
			answerWordN = sc.nextInt();
			
			for (int i = 0; i < answerWordN; ++i) {
				String2Char(sc.next(), answerWord[i]);
			}
			
			if (correctWordN != answerWordN) {				
				accepted = false;
			} else {
				for (int i = 0; i < answerWordN; ++i) {
					boolean isExist = false;
					
					for (int j = 0; j < correctWordN ; ++j) {
						if (mstrcmp(answerWord[i], correctWord[j]) == 0) {
							isExist = true;
						}
					}
					
					if (!isExist) {
						accepted = false;
					}
				}
			}
		}
		
		return accepted;
	}
	
	public static void main(String[] args) throws Exception {
		
		int test, T;
		int wordCnt;
		
		// System.setIn(new java.io.FileInputStream("sample_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (test = 1 ; test <= T ; ++test) {
			
			wordCnt = sc.nextInt();
			
			inputWords(wordCnt, sc);
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			usersolution.init(n);
			
			if (run(m, sc)) {
				System.out.println("#" + test + " 100");
			} else {
				System.out.println("#" + test + " 0");
			}
		}
	}
}
