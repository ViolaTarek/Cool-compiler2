import org.antlr.v4.runtime.ParserRuleContext;

public class errorListener extends CoolParserBaseListener {

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println(ctx.getText());      //code that executes per rule
    }
}

