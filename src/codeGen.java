import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class codeGen {

    public static BufferedWriter writer ;

    public static void main(String[] args) {
        try {
            String TestCaseFile = "test cases/"+args[0];
            String OutputFile = "output/" + args[0] + "-TAC";

            File file = new File(OutputFile);
            file.delete();
            writer = new BufferedWriter(new FileWriter(OutputFile, true));

            FileInputStream inputStream = new FileInputStream(new File(TestCaseFile));
            ANTLRInputStream input = new ANTLRInputStream(inputStream);
            CoolLexer lexer = new CoolLexer(input);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            tokenStream.fill();

            CoolParser parser = new CoolParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(new throwingError());


            CoolParser.ProgramContext prog = parser.program();

            //System.out.println(prog.value.getString(""));
            prog.value.gen();

            for (String s : AST.threeAddressCode) {
               // System.out.println(s);
                writer.append(s+ "\n");
            }
            System.out.println("TAC file has generated");
            writer.close();


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    }
