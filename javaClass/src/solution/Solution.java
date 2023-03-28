package solution;

class Solution {
	public static int solution(String[] babblings) {
		// "aya", "ye", "woo", "ma" 4가지 발음만 가능
		int answer = 0;
		for (int i = 0; i < babblings.length; i++) {
			if (babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo")
					|| babblings[i].contains("mama")) {
				continue;
			}
			babblings[i] = babblings[i].replace("aya", " ");
			babblings[i] = babblings[i].replace("ye", " ");
			babblings[i] = babblings[i].replace("woo", " ");
			babblings[i] = babblings[i].replace("ma", " ");
			babblings[i] = babblings[i].replace(" ", "");

			if (babblings[i].length() == 0)
				answer++;

		}
		return answer;
	}

	// 확인
	public static void main(String[] args) {
		String[] exam1 = { "aya", "yee", "u", "maa" };
		String[] exam2 = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
		System.out.println(solution(exam1));
		System.out.println("----------------");
		System.out.println(solution(exam2));
	}
}