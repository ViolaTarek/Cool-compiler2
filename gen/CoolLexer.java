// Generated from E:/COOL-Compiler-master/src\CoolLexer.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, DARROW=2, LPAREN=3, RPAREN=4, COLON=5, ATSYM=6, COMMA=7, 
		PLUS=8, MINUS=9, STAR=10, SLASH=11, TILDE=12, LT=13, EQUALS=14, LBRACE=15, 
		RBRACE=16, DOT=17, LE=18, ASSIGN=19, SELF=20, SELF_TYPE=21, CLASS=22, 
		ELSE=23, FI=24, IF=25, IN=26, INHERITS=27, LET=28, LOOP=29, POOL=30, THEN=31, 
		WHILE=32, CASE=33, ESAC=34, OF=35, NEW=36, ISVOID=37, NOT=38, BOOL_CONST=39, 
		INT_CONST=40, TYPEID=41, OBJECTID=42, STRING=43, WS=44, ERROR=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SEMICOLON", "DARROW", "LPAREN", "RPAREN", "COLON", "ATSYM", "COMMA", 
			"PLUS", "MINUS", "STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", 
			"RBRACE", "DOT", "LE", "ASSIGN", "SELF", "SELF_TYPE", "CLASS", "ELSE", 
			"FI", "IF", "IN", "INHERITS", "LET", "LOOP", "POOL", "THEN", "WHILE", 
			"CASE", "ESAC", "OF", "NEW", "ISVOID", "NOT", "BOOL_CONST", "INT_CONST", 
			"TYPEID", "OBJECTID", "STRING", "ESC", "WS", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'=>'", "'('", "')'", "':'", "'@'", "','", "'+'", "'-'", 
			"'*'", "'/'", "'~'", "'<'", "'='", "'{'", "'}'", "'.'", "'<='", "'<-'", 
			"'self'", "'SELF_TYPE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEMICOLON", "DARROW", "LPAREN", "RPAREN", "COLON", "ATSYM", "COMMA", 
			"PLUS", "MINUS", "STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", 
			"RBRACE", "DOT", "LE", "ASSIGN", "SELF", "SELF_TYPE", "CLASS", "ELSE", 
			"FI", "IF", "IN", "INHERITS", "LET", "LOOP", "POOL", "THEN", "WHILE", 
			"CASE", "ESAC", "OF", "NEW", "ISVOID", "NOT", "BOOL_CONST", "INT_CONST", 
			"TYPEID", "OBJECTID", "STRING", "WS", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}



		public void reportError(String errorString) {
			setText(errorString);
			setType(ERROR);
		}

		public void notFound() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			reportError(text);
		}
		public void processString() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();

			StringBuilder buf = new StringBuilder(0);

			//write your code to test strings here
			for(int i = 0; i < text.length(); ++i) {
				if(text.charAt(i) == '\\') {
					if(text.charAt(i+1) == 'n')
						buf.append('\n');
					else if(text.charAt(i+1) == 'f')
						buf.append('\f');
					else if(text.charAt(i+1) == 't')
						buf.append('\t');
					else if(text.charAt(i+1) == 'b')
						buf.append('\t');
					else if(text.charAt(i+1) == '\"')
						buf.append('\"');
					else if(text.charAt(i+1) == '\\')
						buf.append('\\');
					else
						buf.append(text.charAt(i+1));
					i++;
				}
				else {
					buf.append(text.charAt(i));
				}
			}
			String ntext = buf.toString();
			if(ntext.length() > 1024) {
				reportError("String constant too long");
				return;
			}
			setText(ntext);
			return;
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 42:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 processString() ;
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0124\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\5(\u00f3\n(\3)\6)\u00f6\n)\r)\16)\u00f7\3*\3*\7*\u00fc"+
		"\n*\f*\16*\u00ff\13*\3*\5*\u0102\n*\3+\3+\7+\u0106\n+\f+\16+\u0109\13"+
		"+\3,\3,\3,\7,\u010e\n,\f,\16,\u0111\13,\3,\3,\3,\3-\3-\3-\3-\5-\u011a"+
		"\n-\3.\6.\u011d\n.\r.\16.\u011e\3.\3.\3/\3/\3\u010f\2\60\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y\2[.]/\3\2\31\4\2EEee\4\2NNnn\4\2CCcc\4\2UUuu\4\2G"+
		"Ggg\4\2HHhh\4\2KKkk\4\2PPpp\4\2JJjj\4\2TTtt\4\2VVvv\4\2QQqq\4\2RRrr\4"+
		"\2YYyy\4\2XXxx\4\2FFff\4\2WWww\3\2\62;\3\2C\\\6\2\62;C\\aac|\3\2c|\4\2"+
		"\62;C|\5\2\13\f\17\17\"\"\2\u012b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7d\3\2\2\2\tf\3\2\2\2\13h\3\2\2\2\rj\3\2"+
		"\2\2\17l\3\2\2\2\21n\3\2\2\2\23p\3\2\2\2\25r\3\2\2\2\27t\3\2\2\2\31v\3"+
		"\2\2\2\33x\3\2\2\2\35z\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0080\3\2\2\2%\u0082"+
		"\3\2\2\2\'\u0085\3\2\2\2)\u0088\3\2\2\2+\u008d\3\2\2\2-\u0097\3\2\2\2"+
		"/\u009d\3\2\2\2\61\u00a2\3\2\2\2\63\u00a5\3\2\2\2\65\u00a8\3\2\2\2\67"+
		"\u00ab\3\2\2\29\u00b4\3\2\2\2;\u00b8\3\2\2\2=\u00bd\3\2\2\2?\u00c2\3\2"+
		"\2\2A\u00c7\3\2\2\2C\u00cd\3\2\2\2E\u00d2\3\2\2\2G\u00d7\3\2\2\2I\u00da"+
		"\3\2\2\2K\u00de\3\2\2\2M\u00e5\3\2\2\2O\u00f2\3\2\2\2Q\u00f5\3\2\2\2S"+
		"\u0101\3\2\2\2U\u0103\3\2\2\2W\u010a\3\2\2\2Y\u0119\3\2\2\2[\u011c\3\2"+
		"\2\2]\u0122\3\2\2\2_`\7=\2\2`\4\3\2\2\2ab\7?\2\2bc\7@\2\2c\6\3\2\2\2d"+
		"e\7*\2\2e\b\3\2\2\2fg\7+\2\2g\n\3\2\2\2hi\7<\2\2i\f\3\2\2\2jk\7B\2\2k"+
		"\16\3\2\2\2lm\7.\2\2m\20\3\2\2\2no\7-\2\2o\22\3\2\2\2pq\7/\2\2q\24\3\2"+
		"\2\2rs\7,\2\2s\26\3\2\2\2tu\7\61\2\2u\30\3\2\2\2vw\7\u0080\2\2w\32\3\2"+
		"\2\2xy\7>\2\2y\34\3\2\2\2z{\7?\2\2{\36\3\2\2\2|}\7}\2\2} \3\2\2\2~\177"+
		"\7\177\2\2\177\"\3\2\2\2\u0080\u0081\7\60\2\2\u0081$\3\2\2\2\u0082\u0083"+
		"\7>\2\2\u0083\u0084\7?\2\2\u0084&\3\2\2\2\u0085\u0086\7>\2\2\u0086\u0087"+
		"\7/\2\2\u0087(\3\2\2\2\u0088\u0089\7u\2\2\u0089\u008a\7g\2\2\u008a\u008b"+
		"\7n\2\2\u008b\u008c\7h\2\2\u008c*\3\2\2\2\u008d\u008e\7U\2\2\u008e\u008f"+
		"\7G\2\2\u008f\u0090\7N\2\2\u0090\u0091\7H\2\2\u0091\u0092\7a\2\2\u0092"+
		"\u0093\7V\2\2\u0093\u0094\7[\2\2\u0094\u0095\7R\2\2\u0095\u0096\7G\2\2"+
		"\u0096,\3\2\2\2\u0097\u0098\t\2\2\2\u0098\u0099\t\3\2\2\u0099\u009a\t"+
		"\4\2\2\u009a\u009b\t\5\2\2\u009b\u009c\t\5\2\2\u009c.\3\2\2\2\u009d\u009e"+
		"\t\6\2\2\u009e\u009f\t\3\2\2\u009f\u00a0\t\5\2\2\u00a0\u00a1\t\6\2\2\u00a1"+
		"\60\3\2\2\2\u00a2\u00a3\t\7\2\2\u00a3\u00a4\t\b\2\2\u00a4\62\3\2\2\2\u00a5"+
		"\u00a6\t\b\2\2\u00a6\u00a7\t\7\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\t\b\2"+
		"\2\u00a9\u00aa\t\t\2\2\u00aa\66\3\2\2\2\u00ab\u00ac\t\b\2\2\u00ac\u00ad"+
		"\t\t\2\2\u00ad\u00ae\t\n\2\2\u00ae\u00af\t\6\2\2\u00af\u00b0\t\13\2\2"+
		"\u00b0\u00b1\t\b\2\2\u00b1\u00b2\t\f\2\2\u00b2\u00b3\t\5\2\2\u00b38\3"+
		"\2\2\2\u00b4\u00b5\t\3\2\2\u00b5\u00b6\t\6\2\2\u00b6\u00b7\t\f\2\2\u00b7"+
		":\3\2\2\2\u00b8\u00b9\t\3\2\2\u00b9\u00ba\t\r\2\2\u00ba\u00bb\t\r\2\2"+
		"\u00bb\u00bc\t\16\2\2\u00bc<\3\2\2\2\u00bd\u00be\t\16\2\2\u00be\u00bf"+
		"\t\r\2\2\u00bf\u00c0\t\r\2\2\u00c0\u00c1\t\3\2\2\u00c1>\3\2\2\2\u00c2"+
		"\u00c3\t\f\2\2\u00c3\u00c4\t\n\2\2\u00c4\u00c5\t\6\2\2\u00c5\u00c6\t\t"+
		"\2\2\u00c6@\3\2\2\2\u00c7\u00c8\t\17\2\2\u00c8\u00c9\t\n\2\2\u00c9\u00ca"+
		"\t\b\2\2\u00ca\u00cb\t\3\2\2\u00cb\u00cc\t\6\2\2\u00ccB\3\2\2\2\u00cd"+
		"\u00ce\t\2\2\2\u00ce\u00cf\t\4\2\2\u00cf\u00d0\t\5\2\2\u00d0\u00d1\t\6"+
		"\2\2\u00d1D\3\2\2\2\u00d2\u00d3\t\6\2\2\u00d3\u00d4\t\5\2\2\u00d4\u00d5"+
		"\t\4\2\2\u00d5\u00d6\t\2\2\2\u00d6F\3\2\2\2\u00d7\u00d8\t\r\2\2\u00d8"+
		"\u00d9\t\7\2\2\u00d9H\3\2\2\2\u00da\u00db\t\t\2\2\u00db\u00dc\t\6\2\2"+
		"\u00dc\u00dd\t\17\2\2\u00ddJ\3\2\2\2\u00de\u00df\t\b\2\2\u00df\u00e0\t"+
		"\5\2\2\u00e0\u00e1\t\20\2\2\u00e1\u00e2\t\r\2\2\u00e2\u00e3\t\b\2\2\u00e3"+
		"\u00e4\t\21\2\2\u00e4L\3\2\2\2\u00e5\u00e6\t\t\2\2\u00e6\u00e7\t\r\2\2"+
		"\u00e7\u00e8\t\f\2\2\u00e8N\3\2\2\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\t\13"+
		"\2\2\u00eb\u00ec\t\22\2\2\u00ec\u00f3\t\6\2\2\u00ed\u00ee\7h\2\2\u00ee"+
		"\u00ef\t\4\2\2\u00ef\u00f0\t\3\2\2\u00f0\u00f1\t\5\2\2\u00f1\u00f3\t\6"+
		"\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3P\3\2\2\2\u00f4\u00f6"+
		"\t\23\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2"+
		"\u00f7\u00f8\3\2\2\2\u00f8R\3\2\2\2\u00f9\u00fd\t\24\2\2\u00fa\u00fc\t"+
		"\25\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0102\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\3\2"+
		"\2\2\u0101\u00f9\3\2\2\2\u0101\u0100\3\2\2\2\u0102T\3\2\2\2\u0103\u0107"+
		"\t\26\2\2\u0104\u0106\t\27\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2"+
		"\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108V\3\2\2\2\u0109\u0107\3"+
		"\2\2\2\u010a\u010f\7$\2\2\u010b\u010e\5Y-\2\u010c\u010e\13\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0113\7$\2\2\u0113\u0114\b,\2\2\u0114X\3\2\2\2\u0115\u0116\7^\2\2\u0116"+
		"\u011a\7$\2\2\u0117\u0118\7^\2\2\u0118\u011a\7^\2\2\u0119\u0115\3\2\2"+
		"\2\u0119\u0117\3\2\2\2\u011aZ\3\2\2\2\u011b\u011d\t\30\2\2\u011c\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0121\b.\3\2\u0121\\\3\2\2\2\u0122\u0123\13\2\2\2"+
		"\u0123^\3\2\2\2\f\2\u00f2\u00f7\u00fd\u0101\u0107\u010d\u010f\u0119\u011e"+
		"\4\3,\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}