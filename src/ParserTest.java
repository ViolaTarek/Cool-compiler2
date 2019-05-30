
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.pattern.ParseTreeMatch;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;
import java.io.*;
import java.lang.reflect.Field;
public class ParserTest {

    public static BufferedWriter writer;


    public static void main(String[] args) {
        try {
            String TestCaseFile = args[0];
            String OutputFile = "output/" + args[0] + "-Cst";

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


            ParseTree tree = parser.program();
            writer.append(tree.toStringTree(parser));
            writer.close();

            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.open();

            errorListener listener = new errorListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}



