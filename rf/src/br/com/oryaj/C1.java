package br.com.oryaj;

import java.util.regex.*;

public class C1 {

	public C1() {
	}
	// URL that generated this code:
	// http://txt2re.com/index-java.php3?s=%20(2016_01_15%2014_30_27%20UTC)&17&-40&30&23&26&35&-59&24&27&-60&28&34&-38&29&33&-61&32&25&-62&31&36&-19&-22&-21&-20&-41

	public static String get() {
		String txt = " (2016_01_15 14_30_27 UTC)";

		String r = "";

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
		String re11 = "(1)"; // Any Single Character 10
		String re12 = "(5)"; // Any Single Character 11
		String re13 = "(\\s+)"; // Any Single Character 12
		String re14 = "(1)"; // Any Single Character 13
		String re15 = "(4)"; // Any Single Character 14
		String re16 = "(_)"; // Any Single Character 15
		String re17 = "(3)"; // Any Single Character 16
		String re18 = "(0)"; // Any Single Character 17
		String re19 = "(_)"; // Any Single Character 18
		String re20 = "(2)"; // Any Single Character 19
		String re21 = "(7)"; // Any Single Character 20
		String re22 = "( )"; // Any Single Character 21
		String re23 = "(U)"; // Any Single Character 22
		String re24 = "(T)"; // Any Single Character 23
		String re25 = "(C)"; // Any Single Character 24
		String re26 = "(\\))"; // Any Single Character 25

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
			String c12 = m.group(13);
			String c13 = m.group(14);
			String c14 = m.group(15);
			String c15 = m.group(16);
			String c16 = m.group(17);
			String c17 = m.group(18);
			String c18 = m.group(19);
			String c19 = m.group(20);
			String c20 = m.group(21);
			String c21 = m.group(22);
			String c22 = m.group(23);
			String c23 = m.group(24);
			String c24 = m.group(25);
			String c25 = m.group(26);
			
			/*System.out.print(ws1.toString() + c1.toString() + c2.toString()
					+ c3.toString() + c4.toString() + c5.toString() + c6.toString()
					+ c7.toString() + c8.toString() + c9.toString() 
					+ c10.toString() + c11.toString() + c12.toString()
					+ c13.toString() + c14.toString() + c15.toString()
					+ c16.toString() + c17.toString() + c18.toString()
					+ c19.toString() + c20.toString() + c21.toString()
					+ c22.toString() + c23.toString() + c24.toString()
					+ c25.toString() + "\n");*/
			
			r = ws1.toString() + c1.toString() + c2.toString()
			+ c3.toString() + c4.toString() + c5.toString() + c6.toString()
			+ c7.toString() + c8.toString() + c9.toString() 
			+ c10.toString() + c11.toString() + c12.toString()
			+ c13.toString() + c14.toString() + c15.toString()
			+ c16.toString() + c17.toString() + c18.toString()
			+ c19.toString() + c20.toString() + c21.toString()
			+ c22.toString() + c23.toString() + c24.toString()
			+ c25.toString() + "\n";
		}
		
		return r;
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
}