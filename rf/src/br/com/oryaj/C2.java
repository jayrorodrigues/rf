package br.com.oryaj;

//URL that generated this code:
//http://txt2re.com/index-java.php3?s=(2016_01_28%2021_08_36%20UTC)&-38&-46&-40&-43&-50&-57&-41&-44&-58&-47&-52&-36&-48&-45&-59&-42&-53&-60&-49&-51&-37&-56&-55&-54&-39 

import java.util.regex.*;

class C2 {
	public static String get() {
		String r = "";
		String txt = " (2016_01_28 21_08_36 UTC)";

		String re1 = "(\\s+)"; // White Space 1
		String re2 = "(\\()"; // Any Single Character 1
		String re3 = "(2)"; // Any Single Character 2
		String re4 = "(0)"; // Any Single Character 3
		String re5 = "(1)"; // Any Single Character 4
		String re6 = "(6)"; // Any Single Character 5
		String re7 = "(_)"; // Any Single Character 6
		String re8 = "(0)"; // Any Single Character 7
		String re9 = "(1)"; // Any Single Character 8
		String re10 = "(_)"; // Any Single Character 9
		String re11 = "(2)"; // Any Single Character 10
		String re12 = "(8)"; // Any Single Character 11
		String re13 = "(\\s+)"; // White Space 2
		String re14 = "(2)"; // Any Single Digit 1
		String re15 = "(1)"; // Any Single Digit 2
		String re16 = ".*?"; // Non-greedy match on filler
		String re17 = "(0)"; // Any Single Digit 3
		String re18 = "(8)"; // Any Single Digit 4
		String re19 = ".*?"; // Non-greedy match on filler
		String re20 = "(3)"; // Any Single Digit 5
		String re21 = "(6)"; // Any Single Digit 6
		String re22 = "( )"; // White Space 3
		String re23 = "(U)"; // Any Single Word Character (Not Whitespace) 1
		String re24 = "(T)"; // Any Single Word Character (Not Whitespace) 2
		String re25 = "(C)"; // Any Single Word Character (Not Whitespace) 3
		String re26 = "(\\))"; // Any Single Character 12

		Pattern p = Pattern.compile(
				re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16
						+ re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26,
				Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = p.matcher(txt);
		if (m.find()) {
			String ws1 = m.group(1);
			String c1 = m.group(2);
			String c2 = m.group(3);
			String c3 = m.group(4);
			String c4 = m.group(5);
			String c5 = m.group(6);
			String c6 = m.group(7);
			String c7 = m.group(8);
			String c8 = m.group(9);
			String c9 = m.group(10);
			String c10 = m.group(11);
			String c11 = m.group(12);
			String ws2 = m.group(13);
			String d1 = m.group(14);
			String d2 = m.group(15);
			String d3 = m.group(16);
			String d4 = m.group(17);
			String d5 = m.group(18);
			String d6 = m.group(19);
			String ws3 = m.group(20);
			String w1 = m.group(21);
			String w2 = m.group(22);
			String w3 = m.group(23);
			String c12 = m.group(24);

			// System.out.print("("+ws1.toString()+")"+"("+c1.toString()+")"+"("+c2.toString()+")"+"("+c3.toString()+")"+"("+c4.toString()+")"+"("+c5.toString()+")"+"("+c6.toString()+")"+"("+c7.toString()+")"+"("+c8.toString()+")"+"("+c9.toString()+")"+"("+c10.toString()+")"+"("+c11.toString()+")"+"("+ws2.toString()+")"+"("+d1.toString()+")"+"("+d2.toString()+")"+"("+d3.toString()+")"+"("+d4.toString()+")"+"("+d5.toString()+")"+"("+d6.toString()+")"+"("+ws3.toString()+")"+"("+w1.toString()+")"+"("+w2.toString()+")"+"("+w3.toString()+")"+"("+c12.toString()+")"+"\n");

			r = ws1.toString() + c1.toString() + c2.toString() + c3.toString() + c4.toString() + c5.toString()
					+ c6.toString() + c7.toString() + c8.toString() + c9.toString() + c10.toString() + c11.toString()
					+ ws2.toString() + d1.toString() + d2.toString() + d3.toString() + d4.toString() + d5.toString()
					+ d6.toString() + ws3.toString() + w1.toString()
					+ w2.toString() + w3.toString() + c12.toString() + "\n";
		}

		return r;
	}
}

// -----
// This code is for use with Sun's Java VM - see http://java.sun.com/ for
// downloads.
//
// Paste the code into a new java application or a file called 'Main.java'
//
// Compile and run in Unix using:
// # javac Main.java
// # java Main
//
