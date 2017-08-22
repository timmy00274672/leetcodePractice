package leetcode.medium;

import java.util.Arrays;

public class Medium468 {

	public static void main(String[] args) {
		// System.out.println(isIPV4("122.255.179.23"));
		// System.out.println(isIPV6("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); //
		// true
		// System.out.println(isIPV6("02001:0db8:85a3:0000:0000:8a2e:0370:7334")); //
		// false
		// System.out.println(isIPV6("2001:db8:85a3:0:0:8A2E:0370:7334")); // true
		// System.out.println(isIPV6("2001:0db8:85a3::8A2E:0370:7334")); // false
		// System.out.println(isIPV6("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(isIPV6("1081:db8:85a3:01:-0:8A2E:0370:7334"));
	}

	public String validIPAddress(String IP) {
		if (isIPV4(IP))
			return "IPv4";
		if (isIPV6(IP))
			return "IPv6";

		return "Neither";
	}

	private static boolean isIPV6(String iP) {
		try {
			if (iP.startsWith(":") || iP.endsWith(":"))
				return false;
			String[] sub = iP.split(":");
			if (sub.length != 8)
				return false;
			for (int i = 0; i < sub.length; i++) {
				String string = sub[i];
				if (string.length() > 4)
					return false;
				int sum = Integer.parseUnsignedInt(string, 16);
				if (sum < 0 || sum >= 1 << 16)
					return false;
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private static boolean isIPV4(String iP) {
		try {
			if (iP.startsWith(".") || iP.endsWith("."))
				return false;
			String[] sub = iP.split("\\.");
			if (sub.length != 4)
				return false;
			for (int i = 0; i < sub.length; i++) {
				String string = sub[i];
				if (string.charAt(0) == '0' && string.length() > 1)
					return false;
				int temp = Integer.parseUnsignedInt(string);
				if (temp < 0 || temp > 255)
					return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
