package solution;

public class Solution {
	
	public static int solution(int[] ingredient) {
		int answer = 0;		
        
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < ingredient.length; i++) {
			sb.append(ingredient[i]);		
			if (sb.length() > 3 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
				sb.delete(sb.length() - 4, sb.length());
				answer++;
			}
		}
		return answer;
	}
}