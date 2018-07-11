package br.com.oryaj;

import java.util.regex.*;

public class C0 {

	public C0() {
	}
	
	public static boolean get(String txt){
	String r = "";

	//String txt=" (2016_01_15 14_30_27 UTC)";

    String re1="\\s+";	// White Space 1
    String re2="\\(";	// Any Single Character 1
    String re3="\\d";	// Any Single Digit 1
    String re4="\\d";	// Any Single Digit 2
    String re5="\\d";	// Any Single Digit 3
    String re6="\\d";	// Any Single Digit 4
    String re7="_";	// Any Single Character 2
    String re8="\\d";	// Any Single Digit 5
    String re9="\\d";	// Any Single Digit 6
    String re10="_";	// Any Single Character 3
    String re11="\\d";	// Any Single Digit 7
    String re12="\\d";	// Any Single Digit 8
    String re13="\\s+";	// Any Single Character 4
    String re14="\\d";	// Any Single Digit 9
    String re15="\\d";	// Any Single Digit 10
    String re16="_";	// Any Single Character 5
    String re17="\\d";	// Any Single Digit 11
    String re18="\\d";	// Any Single Digit 12
    String re19="_";	// Any Single Character 6
    String re20="\\d";	// Any Single Digit 13
    String re21="\\d";	// Any Single Digit 14
    String re22="\\s+";	// Any Single Character 7
    String re23="U";	// Any Single Character 8
    String re24="T";	// Any Single Character 9
    String re25="C";	// Any Single Character 10
    String re26="\\)";	// Any Single Character 11

    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13+re14+re15+re16+re17+re18+re19+re20+re21+re22+re23+re24+re25+re26,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    Matcher m = p.matcher(txt);
    /*if (m.find())
    {
        String ws1=m.group(1);
        String c1=m.group(2);
        String d1=m.group(3);
        String d2=m.group(4);
        String d3=m.group(5);
        String d4=m.group(6);
        String c2=m.group(7);
        String d5=m.group(8);
        String d6=m.group(9);
        String c3=m.group(10);
        String d7=m.group(11);
        String d8=m.group(12);
        String c4=m.group(13);
        String d9=m.group(14);
        String d10=m.group(15);
        String c5=m.group(16);
        String d11=m.group(17);
        String d12=m.group(18);
        String c6=m.group(19);
        String d13=m.group(20);
        String d14=m.group(21);
        String c7=m.group(22);
        String c8=m.group(23);
        String c9=m.group(24);
        String c10=m.group(25);
        String c11=m.group(26);
        
        //System.out.print("("+ws1.toString()+")"+"("+c1.toString()+")"+"("+d1.toString()+")"+"("+d2.toString()+")"+"("+d3.toString()+")"+"("+d4.toString()+")"+"("+c2.toString()+")"+"("+d5.toString()+")"+"("+d6.toString()+")"+"("+c3.toString()+")"+"("+d7.toString()+")"+"("+d8.toString()+")"+"("+c4.toString()+")"+"("+d9.toString()+")"+"("+d10.toString()+")"+"("+c5.toString()+")"+"("+d11.toString()+")"+"("+d12.toString()+")"+"("+c6.toString()+")"+"("+d13.toString()+")"+"("+d14.toString()+")"+"("+c7.toString()+")"+"("+c8.toString()+")"+"("+c9.toString()+")"+"("+c10.toString()+")"+"("+c11.toString()+")"+"\n");
        
        r="("+ws1.toString()+")"+"("+c1.toString()+")"+"("+d1.toString()+")"+"("+d2.toString()+")"+"("+d3.toString()+")"+"("+d4.toString()+")"+"("+c2.toString()+")"+"("+d5.toString()+")"+"("+d6.toString()+")"+"("+c3.toString()+")"+"("+d7.toString()+")"+"("+d8.toString()+")"+"("+c4.toString()+")"+"("+d9.toString()+")"+"("+d10.toString()+")"+"("+c5.toString()+")"+"("+d11.toString()+")"+"("+d12.toString()+")"+"("+c6.toString()+")"+"("+d13.toString()+")"+"("+d14.toString()+")"+"("+c7.toString()+")"+"("+c8.toString()+")"+"("+c9.toString()+")"+"("+c10.toString()+")"+"("+c11.toString()+")";
        
			
    }*/
    
    return m.find();
  }
}