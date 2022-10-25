package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		int length = str.length();
		if (length < 2)
			return str;
		char lastChar = str.charAt(length - 1);
		char secondLastChar = str.charAt(length - 2);

		String remainingString = str.substring(0,length - 2);

		return remainingString + lastChar + secondLastChar;
	}

	public String truncateAInFirst2Positions(String str) {
		if (str.length() < 2)
			return str.replaceAll("A","");

		String firstTwoChars = str.substring(0,2);

		String firstTwoCharsUpdated = firstTwoChars.replaceAll("A","");

		String remainingString = str.substring(2);

		return firstTwoCharsUpdated + remainingString;
	}
}
