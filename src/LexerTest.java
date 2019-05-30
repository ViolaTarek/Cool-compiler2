import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;

public class LexerTest {
	public static String array[] = new String[100];
	public static int i = 1;
	public static boolean isError = false;
	public static BufferedWriter writer ;

	public static void main(String[] args) throws Exception {

		String TestCaseFile = args[0];
		String output = "output/" + args[0] + "-lex";

		File file = new File(output);
		file.delete();

		writer = new BufferedWriter(new FileWriter(output, true));

		FileInputStream inputStream = new FileInputStream(new File(TestCaseFile));
		ANTLRInputStream input = new ANTLRInputStream(inputStream);
		CoolLexer lexer = new CoolLexer(input);
		//read tokens file
		FileReader tokens = new FileReader("gen/CoolLexer.tokens");
		BufferedReader reader = new BufferedReader(tokens);

		//read code line by line
		String code = reader.readLine();
		while(code != null && code.charAt(0) != '\''){
			array[i]=code.substring(0, code.indexOf('='));
			i++;
			code = reader.readLine();
		}

		reader.close();

		Token token = lexer.nextToken();
		while (!isError && token.getType() != CoolLexer.EOF) {
			getTokenType(token);
			token = lexer.nextToken();
		}

		writer.close();

		//if there is error delete previous generated file of the same name
		if(isError){
			file = new File(output);
			file.delete();
		}
		else{
			System.out.println("cool Lexer Done!");
		}
	}

	private static void getTokenType(Token token)throws Exception {
		String str;

		if(token.getType() == i-1){
			isError = true;
			str = ("LEXER ERROR at line " + token.getLine() + ": invalid character: " + token.getText());
			System.out.println(str);
		}else{
			str = (token.getLine() + "\n" + array[token.getType()] + "\n" + token.getText() + "\n");
			writer.append(str);
		}
	}
}