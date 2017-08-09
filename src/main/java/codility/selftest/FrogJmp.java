package codility.selftest;

public class FrogJmp {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE > 1000000000);

	}

	public int solution(int X, int Y, int D) {

		return (Y - X) / D + (((Y - X) % D == 0) ? 0 : 1);
	}
}
