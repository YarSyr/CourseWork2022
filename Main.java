import java.util.*;
import java.io.*;

enum lex_type
{
    LEX_NULL,       // 0
    //  Àﬁ◊≈¬€≈ —ÀŒ¬¿
    LEX_AND,       //1
    LEX_BEGIN,      //2
    LEX_DO,        //3
    LEX_ELSE,      //4
    LEX_END,        //5
    LEX_AS,       //6
    LEX_FOR,      //7
    LEX_TO,      //8
    LEX_IF,         //9
    LEX_FALSE,     //10
    LEX_DEC,      //11
    LEX_OCT,       //12
    LEX_BIN,        //13
    LEX_HEX,      //14
    LEX_EXP,      //15
    LEX_NOT,       //16
    LEX_OR,         //17
    LEX_PROGRAM,   //18
    LEX_READ,      //19
    LEX_THEN,       //20
    LEX_TRUE,      //21
    LEX_VAR,        //22
    LEX_WHILE,      //23
    LEX_WRITE,      //24
    LEX_INT,
    LEX_FLOAT,
    LEX_BOOL,
    // Ã¿– ≈–  ŒÕ÷¿ “≈ —“¿ œ–Œ√–¿ÃÃ€
    LEX_FIN,        //25
    // Œœ≈–¿“Œ–€ » –¿«ƒ≈À»“≈À»
    LEX_SEMICOLON,  //26
    LEX_COMMA,     //27
    LEX_COLON,     //28
    LEX_LPAREN,    //29
    LEX_RPAREN,     //30
    LEX_EQ,         //31
    LEX_LSS,         //32
    LEX_GTR,        //33
    LEX_PLUS,       //34
    LEX_MINUS,      //35
    LEX_TIMES,      //36
    LEX_SLASH,      //37
    LEX_LEQ,        //38
    LEX_NEQ,       //39
    LEX_GEQ,        //40
    LEX_NUM,        //41
    LEX_ID          //42
};



// Î‡ÒÒ "ÀÂÍÒÂÏ‡"
class Lex
{
public
 lex_type type;
 String value;
	Lex(lex_type t, String string)
	{
	    type = t;
	    value = string;
	}
	Lex()
	{
		lex_type t = lex_type.LEX_NULL; String v = "0";
	    type = t;
	    value = v;
	}
lex_type getType()
{
    return type;
}
String getValue()
{
    return value;
}
};

// Î‡ÒÒ "»‰ÂÌÚËÙËÍ‡ÚÓ"
class Id
{
public
 String name;
 boolean declared;
 boolean assigned;
 lex_type type;
 String value;

 Id(String N)
 {
	 name = N;
     declared = false;
     assigned = false;
     type = lex_type.LEX_ID;
 }
 String getName()
 {
     return name;
 }
 void setName(String Nname)
 {
     name = Nname;
 }
 lex_type getType()
 {
     return type;
 }
 void setType(lex_type Ntype)
 {
     type = Ntype;
 }
 boolean isDeclared()
 {
     return declared;
 }
 void setDeclared()
 {
     declared = true;
 }
 boolean isAssigned()
 {
     return assigned;
 }
 void setAssigned()
 {
     assigned = true;
 }
 String getValue()
 {
     return value;
 }
 void setValue(String Nvalue)
 {
     value = Nvalue;
 }
};





public class Main {
	
	public static lex_type[] keys = new lex_type[]{
			lex_type.LEX_NULL,       // 0
			    //  Àﬁ◊≈¬€≈ —ÀŒ¬¿
			 lex_type.LEX_AND,       //1
			    lex_type.LEX_BEGIN,      //2
			    lex_type.LEX_DO,        //3
			    lex_type.LEX_ELSE,      //4
			    lex_type.LEX_END,        //5
			    lex_type.LEX_AS,       //6
			    lex_type.LEX_FOR,      //7
			    lex_type.LEX_TO,      //8
			    lex_type.LEX_IF,         //9
			    lex_type.LEX_FALSE,     //10
			    lex_type.LEX_DEC,      //11
			    lex_type.LEX_OCT,       //12
			    lex_type.LEX_BIN,        //13
			    lex_type.LEX_HEX,      //14
			    lex_type.LEX_EXP,      //15
			    lex_type.LEX_NOT,       //16
			    lex_type.LEX_OR,         //17
			    lex_type.LEX_PROGRAM,   //18
			    lex_type.LEX_READ,      //19
			    lex_type.LEX_THEN,       //20
			    lex_type.LEX_TRUE,      //21
			    lex_type.LEX_VAR,        //22
			    lex_type.LEX_WHILE,      //23
			    lex_type.LEX_WRITE,      //24
			    lex_type.LEX_INT,
			    lex_type.LEX_FLOAT,
			    lex_type.LEX_BOOL,
			    // Ã¿– ≈–  ŒÕ÷¿ “≈ —“¿ œ–Œ√–¿ÃÃ€
			    lex_type.LEX_FIN,        //25
			    // Œœ≈–¿“Œ–€ » –¿«ƒ≈À»“≈À»
			    lex_type.LEX_SEMICOLON,  //26
			    lex_type.LEX_COMMA,     //27
			    lex_type.LEX_COLON,     //28
			    lex_type.LEX_LPAREN,    //29
			    lex_type.LEX_RPAREN,     //30
			    lex_type.LEX_EQ,         //31
			    lex_type.LEX_LSS,         //32
			    lex_type.LEX_GTR,        //33
			    lex_type.LEX_PLUS,       //34
			    lex_type.LEX_MINUS,      //35
			    lex_type.LEX_TIMES,      //36
			    lex_type.LEX_SLASH,      //37
			    lex_type.LEX_LEQ,        //38
			    lex_type.LEX_NEQ,       //39
			    lex_type.LEX_GEQ,        //40
			    lex_type.LEX_NUM,        //41
			    lex_type.LEX_ID          //42
		};

	
	
	public static String[] KeyWord = new String[] {"NULL", "and", "begin", "do", "else", "end", "as","for","to","if","false","dec","oct","bin","hex","exp","not","or","program","read","then","true","var","while","write","%",
			"!","$","@",";",",",":","(",")","=","<",">","+","-","*","/","<=","<>",">=","num","id"};
	static ArrayDeque<Id> IDs = new ArrayDeque<Id>();
	static ArrayDeque<Lex> Lexems = new ArrayDeque<Lex>();
	static ArrayList<Character> BUFF = new ArrayList<Character>();
	
	static int look() {
		char[] charArray = new char[BUFF.size()];
		for(int i = 0; i<BUFF.size();i++) {
			charArray[i] = BUFF.get(i);
		}
		//System.out.print(String.copyValueOf(charArray)); System.out.println("	"+KeyWord.length);
		for (int i=0; i<KeyWord.length;i++) {
			String S1 = KeyWord[i];
			String S2 = String.copyValueOf(charArray);
			//System.out.println(S1 + "	" + S2 +"	" + (S1.equals(S2)));
			if(S1.equals(S2)) {
				return i;
			}
		}
		return 0;
	}
	
	static Lex lexer(FileReader reader) {
		try
        {
                System.out.println("‘‡ÈÎ ÛÒÔÂ¯ÌÓ ÓÚÍ˚Ú!");    
		String CS = "S";
		char c = ' ';
		int j;
		do {
			System.out.println("CS ËÚÂ‡ˆËˇ " + CS);    
		switch(CS) {
			case("S"):
				
				System.out.println(CS);
				if (c == ' ' || c == '\n' || c == '\r' || c == '\t' || (c + 0) == 13) {
					c=(char) reader.read();
					System.out.println("CS1");
	            }
	            else if (Character.isLetter(c)) {
	            	System.out.println("CS2");
	                BUFF.clear();
	                BUFF.add(c);
	                c=(char) reader.read();
	                CS = "ID";
	            } 
	            else if (Character.isDigit(c)) { 
	            	System.out.println("CS7");
	                BUFF.clear();
	                System.out.println("CS8");
	                BUFF.add(c);
	                System.out.println("CS9");
	                	if(c =='1'|c =='0') {
		                	CS = "BIN";}
	                	else if(c =='2'|c =='3'|c =='4'|c =='5'|c =='6'|c =='7') {
		                	CS = "OCT";}
		                	else if(c =='8'|c =='9') {
		                	CS = "DEC";
	                }
	                System.out.println("GESDFASD");
	                c=(char) reader.read();
	                System.out.println(c);
	            }
	            else if (c == '{') {
	            	System.out.println("CS2");
	            	c=(char) reader.read();
	                CS = "COM";
	            }
	            else if (c == '.') {
	            	System.out.println("CS8");
	            	c=(char) reader.read();
	                CS = "EXP";
	            }
	            else if (c == '>') {
	            	System.out.println("CS3");
	            	c=(char) reader.read();
	                CS = "ALB";
	            }
	            else if (c == '<') {
	            	System.out.println("CS4");
	            	c=(char) reader.read();
	                CS = "ALL";
	            }
	            else if (c == '@') {
	            	System.out.println("CS5");
	   
	                Lex T1 = new Lex(lex_type.LEX_FIN, "28");
	                return T1;
	            }
	            else {
	            	System.out.println("CS6");
	                CS = "DELIM";
	                System.out.println("CS4");
	                System.out.println("œÓÎÛ˜ÂÌ ÒËÏ‚ÓÎ" + c);
	            }
	            break;
			case("ID"):
				System.out.println("CS101  "+ c);
				if (Character.isLetter(c) || Character.isDigit(c)) { System.out.println("CS103  "+ c);
					System.out.println("CS11  "+ c);
					BUFF.add(c);
					 c=(char) reader.read();
	            }
	            else { System.out.println("CS102  "+ c);
	            	j = look();
	            	 System.out.println("J ‡‚ÌÓ: " + Integer.toString(j));
	                if (j!=0) { 
	                    Lex T1 = new Lex(keys[j], Integer.toString(j));
	                    System.out.println(keys[j]);
	                    System.out.println("ID1");
	                    return T1;
	                }
	                else {
	                	System.out.println("CS104  "+ c);
	                	Id T = new Id(BUFF.toString());
	                	IDs.add(T);
	                    j = IDs.size();
	                    Lex T1 = new Lex(lex_type.LEX_ID, Integer.toString(j));

	                    return T1;
	                }
	            }
	            break;
			case("COM"):
				System.out.println("COM_begin with cchar" + c);
				if (c == '}') {
					System.out.println("COM1_with cchar" + c);
					c=(char) reader.read();
	                CS = "S";
	                System.out.println("COM11 " + c + " " + CS);
	                break;

	            }
	            else if (c == '@' || c == '{') {
	            	System.out.println("COM2_with cchar" + c);
	            	System.out.println("ÕÂ ÍÓÂÍÚÌÓÂ Ì‡ÔËÒ‡ÌËÂ ÍÓÏÏÂÌÚ‡Ëˇ");
	            	break;
	                
	            }
	            else {
	            	System.out.println("COM3_with cchar" + c);
	            	c=(char) reader.read();
	            	System.out.println("œÓÔÛÒÍ ÔÓ ÒËÏ‚ÓÎÛ " + c);
	            	break;
	            }

			case("ALB"):
				if (c == '=') {
	                Lex T1 = new Lex(lex_type.LEX_GEQ, "43");
	                return T1;
	            } else {
	            	Lex T1 = new Lex(lex_type.LEX_GTR, "36");
	                return T1;

	            }
			case("ALL"):
				if (c == '=') {
	                Lex T1 = new Lex(lex_type.LEX_LEQ, "41");
	                return T1;
	            } else if (c == '>') {
	                Lex T1 = new Lex(lex_type.LEX_NEQ, "42");
	                return T1;
	            } else {
	            	Lex T1 = new Lex(lex_type.LEX_LSS, "35");
	                return T1;

	            }
			case("BIN"):
				if (c == '0' |  c =='1') {

				} else if (c == '2' |  c =='3' |  c =='4' |  c =='5' |  c =='6' |  c =='7') {
					CS = "OCT";
				} else if (c == '8' |  c =='9' 	) {
					CS = "DEC";
				}else if (c == 'A' |  c =='a'  |  c =='C' |  c =='c' |  c =='E' |  c =='e' |  c =='F' |  c =='f') {
					CS = "HEX";
				}else if (c == 'e' |  c =='E' ) {
					CS = "EXP";
				}else if (c == 'e' |  c =='E' ) {
					CS = "EXP";
				}else if (c == 'B' |  c =='b') {
					BUFF.add(c);
					char[] charArray = new char[BUFF.size()];
					for(int i = 0; i<BUFF.size();i++) {
						charArray[i] = BUFF.get(i);
					}
					Lex T1 = new Lex(lex_type.LEX_BIN, String.copyValueOf(charArray));
	                return T1;
				} else if (c == 'O' |  c =='o') {
					BUFF.add(c);
					char[] charArray = new char[BUFF.size()];
					for(int i = 0; i<BUFF.size();i++) {
						charArray[i] = BUFF.get(i);
					}
					Lex T1 = new Lex(lex_type.LEX_OCT, String.copyValueOf(charArray));
	                return T1; } 
				else if (c == 'D' |  c =='d') {
					BUFF.add(c);
					char[] charArray = new char[BUFF.size()];
					for(int i = 0; i<BUFF.size();i++) {
						charArray[i] = BUFF.get(i);
					}
					Lex T1 = new Lex(lex_type.LEX_DEC, String.copyValueOf(charArray));
	                return T1; } else if (c == 'h' |  c =='H') {
						BUFF.add(c);
						char[] charArray = new char[BUFF.size()];
						for(int i = 0; i<BUFF.size();i++) {
							charArray[i] = BUFF.get(i);
						}
						Lex T1 = new Lex(lex_type.LEX_HEX, String.copyValueOf(charArray));
		                return T1; } else {
							BUFF.add(c);
							char[] charArray = new char[BUFF.size()];
							for(int i = 0; i<BUFF.size();i++) {
								charArray[i] = BUFF.get(i);
							}
							Lex T1 = new Lex(lex_type.LEX_DEC, String.copyValueOf(charArray));
			                return T1; }
				
				BUFF.add(c);
				c=(char) reader.read();
				break;
			case("OCT"):
				System.out.println("OCT  " + c);
				 if (c == '0' |c == '1' | c == '2' |  c =='3' |  c =='4' |  c =='5' |  c =='6' |  c =='7') {

				} else if (c == '8' |  c =='9' 	) {
					CS = "DEC";
				}else if (c == 'A' |  c =='a'  |  c =='C' |  c =='c' |  c =='E' |  c =='e' |  c =='F' |  c =='f') {
					CS = "HEX";
				}else if (c == 'e' |  c =='E' ) {
					CS = "EXP";
				} else if (c == 'O' |  c =='o') {
					BUFF.add(c);
					char[] charArray = new char[BUFF.size()];
					for(int i = 0; i<BUFF.size();i++) {
						charArray[i] = BUFF.get(i);
					}
					Lex T1 = new Lex(lex_type.LEX_OCT, String.copyValueOf(charArray));
					System.out.println(c+"   HELL  "+String.copyValueOf(charArray));
	                return T1; } else if (c == 'D' |  c =='d') { //1111111111-
						BUFF.add(c);
						char[] charArray = new char[BUFF.size()];
						for(int i = 0; i<BUFF.size();i++) {
							charArray[i] = BUFF.get(i);
						}
						Lex T1 = new Lex(lex_type.LEX_DEC, String.copyValueOf(charArray));
		                return T1; } else if (c == 'h' |  c =='H') {
							BUFF.add(c);
							char[] charArray = new char[BUFF.size()];
							for(int i = 0; i<BUFF.size();i++) {
								charArray[i] = BUFF.get(i);
							}
							Lex T1 = new Lex(lex_type.LEX_HEX, String.copyValueOf(charArray));
			                return T1; } else {
								BUFF.add(c);
								char[] charArray = new char[BUFF.size()];
								for(int i = 0; i<BUFF.size();i++) {
									charArray[i] = BUFF.get(i);
								}
								System.out.println("HELLO  "+String.copyValueOf(charArray));
								Lex T1 = new Lex(lex_type.LEX_DEC, String.copyValueOf(charArray));
				                return T1; }

				BUFF.add(c);
				c=(char) reader.read();
				break;
			case("DELIM"):
				BUFF.clear();
				BUFF.add(c);
				j = look();
           	 System.out.println("J ‡‚ÌÓ: " + Integer.toString(j));
               if (j!=0) { 
                   Lex T1 = new Lex(keys[j], Integer.toString(j));
                   System.out.println(keys[j]);
                   System.out.println("ID1");
                   return T1;
               }
               else {
               	Id T = new Id(BUFF.toString());
               	IDs.add(T);
                   j = IDs.size();
                   Lex T1 = new Lex(lex_type.LEX_ID, Integer.toString(j));
                   System.out.println(j);
                   System.out.println("ID2");
                   return T1;
               }
				

		
		
		
		
		
		
		
		}}
		
		while(true);}
		
    catch(IOException ex){
         
        System.out.println(ex.getMessage());
    }
		return null;
	}
	public static void main (String[] args) throws IOException
	{
		FileReader reader = new FileReader("C:/TXT/code2.txt");
		lex_type[] types = lex_type.values();int i = 0; for (lex_type s : types) { System.out.print(Integer.toString(i)+"  "+ s);System.out.print("		");System.out.println(KeyWord[i]); i++;}
        Lex res;
		while(true) {
			res = lexer(reader);
	        System.out.println(res.type +" F " + res.value);
	        Lexems.add(res);
	        if(Lexems.getLast().type == lex_type.LEX_FIN){
				break;};
		}
		reader.close();
		System.out.println("\n\n¬€¬Œƒ");
		for (Lex s : Lexems) {System.out.print(s.type.toString()+"	");
		System.out.println(s.value);
		};
		for (Id d : IDs) {System.out.println(d.name);
		};
		System.out.println("Á‡‚Â¯ÂÌËÂ ‡·ÓÚ˚ ÔÓ„‡ÏÏ˚");
		return;
	}
}
