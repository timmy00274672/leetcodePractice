package codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Name {

	public static void main(String[] args) {
		String inputString = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		Name solution = new Name();
		System.out.println(solution.solution(inputString, "Example"));
	}

	public String solution(String S, String C) {
		// split the S into list of names
		String[] namesArray = S.split(";");
		List<String> answerList = new ArrayList<>();
		Map<String, Integer> count = new HashMap<>();

		for (int i = 0; i < namesArray.length; i++) {
			String name = namesArray[i];
			// with or without middle name
			// hypen in last name
			// duplicate
			String[] split = name.trim().split(" ");
			boolean withMiddle = split.length == 3;
			String lastName, middleName = null, firstName;
			if (withMiddle) {
				middleName = split[1].substring(0, 1);
				lastName = split[2];
			} else {
				lastName = split[1];
			}
			firstName = split[0];

			// hypen
			if (lastName.contains("-")) {
				int index = lastName.indexOf("-");
				lastName = lastName.substring(0, index) + lastName.substring(index + 1, lastName.length());
			}
			String mailUserName;
			// combine
			// TODO duplicate
			if (withMiddle) {
				mailUserName = String.format("%s_%s_%s", lastName, firstName, middleName).toLowerCase();
			} else {
				mailUserName = String.format("%s_%s", lastName, firstName).toLowerCase();
			}

			// update map
			int num = count.getOrDefault(mailUserName, 0) + 1;
			count.put(mailUserName, num);
			if (num == 1) {
				answerList.add(String.format("%s@%s.com", mailUserName, C).toLowerCase());
			} else {
				answerList.add(String.format("%s%d@%s.com", mailUserName, num, C).toLowerCase());
			}

		}

		// TODO : last one
		return String.join("; ", answerList);
	}
}
