package codility;

public class Compare {
	public static void main(String[] args) {
		Compare solution = new Compare();
		System.out.println(solution.solution("A2Le", "2pL1"));
		// Provider nProvider = new Provider("14A");
		// char cu;
		// for (int i = 0; i < 15; i++)
		// System.out.println(nProvider.next());
	}

	public boolean solution(String S, String T) {

		boolean answer = true;
		Provider leftProvider = new Provider(S), rightProvider = new Provider(T);
		while (true) {
			char left = leftProvider.next(), right = rightProvider.next();
			if (left == 0 && right == 0)
				break;
			else if (left == 0 || right == 0) {
				answer = false;
				break;
			} else {
				if (!(left == right || left == '?' || right == '?')) {
					answer = false;
					break;
				}
			}
		}
		return answer;

	}

	public static boolean compareChar(char a, char b) {
		// a, b not ?
		if (a == '?' || b == '?')
			return true;
		else {
			return a == b;
		}

	}

	static class Provider {

		String string;
		int indexOfString;
		int numForDuplicate;
		int numAlreadyDuplicate;
		boolean question;

		public Provider(String string) {
			this.string = string;
		}

		// return 0 if end
		public char next() {
			// already processing question
			if (question) {
				// TODO
				numAlreadyDuplicate++;
				if (numAlreadyDuplicate == numForDuplicate) {
					question = false;
				}
				return '?';
			}
			// if not digit
			char current;
			try {
				current = string.charAt(indexOfString);
			} catch (IndexOutOfBoundsException e) {
				return 0;
			}

			if (!Character.isDigit(current)) {
				indexOfString++;
				return current;
			} else {
				int lastDigitIndex = indexOfString;
				while (true) {
					boolean digit;
					try {
						digit = Character.isDigit(string.charAt(lastDigitIndex));
						if (digit)
							lastDigitIndex++;
						else
							break;

					} catch (Exception e) {
						break;
					}
				}
				lastDigitIndex--;
				numForDuplicate = Integer.parseInt(string.substring(indexOfString, lastDigitIndex + 1));
				if (numForDuplicate != 1)
					question = true;
				numAlreadyDuplicate = 1;
				indexOfString = lastDigitIndex + 1;
				return '?';
			}
		}

	}
}
