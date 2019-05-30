
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;


    public class throwingError extends BaseErrorListener {
        public static final throwingError INSTANCE = new throwingError();
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
                throws ParseCancellationException {
            throw new ParseCancellationException("line " + line + " : error :" + msg);
        }
    }