// Generated from c:\Users\Bitnine\Documents\dev\notebook\apache-age-python\antlr\age.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		KW_VERTEX=10, KW_EDGE=11, KW_PATH=12, STRING=13, NUMBER=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"KW_VERTEX", "KW_EDGE", "KW_PATH", "STRING", "ESC", "UNICODE", "HEX", 
			"SAFECODEPOINT", "NUMBER", "INT", "EXP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "','", "']'", "'true'", "'false'", "'null'", "'{'", "'}'", 
			"':'", "'::vertex'", "'::edge'", "'::path'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "KW_VERTEX", 
			"KW_EDGE", "KW_PATH", "STRING", "NUMBER", "WS"
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


	public ageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "age.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16"+
		"d\n\16\f\16\16\16g\13\16\3\16\3\16\3\17\3\17\3\17\5\17n\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\5\23{\n\23\3\23\3\23\3\23"+
		"\6\23\u0080\n\23\r\23\16\23\u0081\5\23\u0084\n\23\3\23\5\23\u0087\n\23"+
		"\3\24\3\24\3\24\7\24\u008c\n\24\f\24\16\24\u008f\13\24\5\24\u0091\n\24"+
		"\3\25\3\25\5\25\u0095\n\25\3\25\3\25\3\26\6\26\u009a\n\26\r\26\16\26\u009b"+
		"\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\2\37\2!\2#\2%\20\'\2)\2+\21\3\2\n\n\2$$\61\61^^ddhhppttv"+
		"v\5\2\62;CHch\5\2\2!$$^^\3\2\62;\3\2\63;\4\2GGgg\4\2--//\5\2\13\f\17\17"+
		"\"\"\2\u00a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2%\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2"+
		"\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\138\3\2\2\2\r>\3\2\2\2\17C\3\2\2"+
		"\2\21E\3\2\2\2\23G\3\2\2\2\25I\3\2\2\2\27R\3\2\2\2\31Y\3\2\2\2\33`\3\2"+
		"\2\2\35j\3\2\2\2\37o\3\2\2\2!u\3\2\2\2#w\3\2\2\2%z\3\2\2\2\'\u0090\3\2"+
		"\2\2)\u0092\3\2\2\2+\u0099\3\2\2\2-.\7]\2\2.\4\3\2\2\2/\60\7.\2\2\60\6"+
		"\3\2\2\2\61\62\7_\2\2\62\b\3\2\2\2\63\64\7v\2\2\64\65\7t\2\2\65\66\7w"+
		"\2\2\66\67\7g\2\2\67\n\3\2\2\289\7h\2\29:\7c\2\2:;\7n\2\2;<\7u\2\2<=\7"+
		"g\2\2=\f\3\2\2\2>?\7p\2\2?@\7w\2\2@A\7n\2\2AB\7n\2\2B\16\3\2\2\2CD\7}"+
		"\2\2D\20\3\2\2\2EF\7\177\2\2F\22\3\2\2\2GH\7<\2\2H\24\3\2\2\2IJ\7<\2\2"+
		"JK\7<\2\2KL\7x\2\2LM\7g\2\2MN\7t\2\2NO\7v\2\2OP\7g\2\2PQ\7z\2\2Q\26\3"+
		"\2\2\2RS\7<\2\2ST\7<\2\2TU\7g\2\2UV\7f\2\2VW\7i\2\2WX\7g\2\2X\30\3\2\2"+
		"\2YZ\7<\2\2Z[\7<\2\2[\\\7r\2\2\\]\7c\2\2]^\7v\2\2^_\7j\2\2_\32\3\2\2\2"+
		"`e\7$\2\2ad\5\35\17\2bd\5#\22\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2"+
		"\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7$\2\2i\34\3\2\2\2jm\7^\2\2kn\t\2\2"+
		"\2ln\5\37\20\2mk\3\2\2\2ml\3\2\2\2n\36\3\2\2\2op\7w\2\2pq\5!\21\2qr\5"+
		"!\21\2rs\5!\21\2st\5!\21\2t \3\2\2\2uv\t\3\2\2v\"\3\2\2\2wx\n\4\2\2x$"+
		"\3\2\2\2y{\7/\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u0083\5\'\24\2}\177\7"+
		"\60\2\2~\u0080\t\5\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083}\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0087\5)\25\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087&\3\2\2\2\u0088\u0091\7\62\2\2\u0089\u008d\t\6\2\2"+
		"\u008a\u008c\t\5\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0088\3\2\2\2\u0090\u0089\3\2\2\2\u0091(\3\2\2\2\u0092\u0094\t\7\2\2"+
		"\u0093\u0095\t\b\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0097\5\'\24\2\u0097*\3\2\2\2\u0098\u009a\t\t\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\26\2\2\u009e,\3\2\2\2\16\2cemz"+
		"\u0081\u0083\u0086\u008d\u0090\u0094\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}