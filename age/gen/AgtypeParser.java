// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AgtypeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, IDENT=14, STRING=15, INTEGER=16, 
		RegularFloat=17, ExponentFloat=18, WS=19;
	public static final int
		RULE_agType = 0, RULE_agValue = 1, RULE_value = 2, RULE_obj = 3, RULE_pair = 4, 
		RULE_array = 5, RULE_typeAnnotation = 6, RULE_floatLiteral = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"agType", "agValue", "value", "obj", "pair", "array", "typeAnnotation", 
			"floatLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'null'", "'{'", "','", "'}'", "':'", "'['", 
			"']'", "'::'", "'-'", "'Infinity'", "'NaN'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "IDENT", "STRING", "INTEGER", "RegularFloat", "ExponentFloat", 
			"WS"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AgtypeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AgTypeContext extends ParserRuleContext {
		public AgValueContext agValue() {
			return getRuleContext(AgValueContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AgtypeParser.EOF, 0); }
		public AgTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterAgType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitAgType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitAgType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgTypeContext agType() throws RecognitionException {
		AgTypeContext _localctx = new AgTypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_agType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			agValue();
			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AgValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public AgValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterAgValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitAgValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitAgValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgValueContext agValue() throws RecognitionException {
		AgValueContext _localctx = new AgValueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_agValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			value();
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(20);
				typeAnnotation();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullValueContext extends ValueContext {
		public NullValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterNullValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitNullValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitNullValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectValueContext extends ValueContext {
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ObjectValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterObjectValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitObjectValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitObjectValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerValueContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(AgtypeParser.INTEGER, 0); }
		public IntegerValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitIntegerValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitIntegerValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueBooleanContext extends ValueContext {
		public TrueBooleanContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterTrueBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitTrueBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitTrueBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseBooleanContext extends ValueContext {
		public FalseBooleanContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterFalseBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitFalseBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitFalseBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatValueContext extends ValueContext {
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public FloatValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterFloatValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitFloatValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitFloatValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValueContext extends ValueContext {
		public TerminalNode STRING() { return getToken(AgtypeParser.STRING, 0); }
		public StringValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValueContext extends ValueContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(STRING);
				}
				break;
			case INTEGER:
				_localctx = new IntegerValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(INTEGER);
				}
				break;
			case T__10:
			case T__11:
			case T__12:
			case RegularFloat:
			case ExponentFloat:
				_localctx = new FloatValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				floatLiteral();
				}
				break;
			case T__0:
				_localctx = new TrueBooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(T__0);
				}
				break;
			case T__1:
				_localctx = new FalseBooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(27);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(28);
				match(T__2);
				}
				break;
			case T__3:
				_localctx = new ObjectValueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(29);
				obj();
				}
				break;
			case T__7:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(30);
				array();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjContext extends ParserRuleContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_obj);
		int _la;
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(T__3);
				setState(34);
				pair();
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(35);
					match(T__4);
					setState(36);
					pair();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(T__3);
				setState(45);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AgtypeParser.STRING, 0); }
		public AgValueContext agValue() {
			return getRuleContext(AgValueContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(STRING);
			setState(49);
			match(T__6);
			setState(50);
			agValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public List<AgValueContext> agValue() {
			return getRuleContexts(AgValueContext.class);
		}
		public AgValueContext agValue(int i) {
			return getRuleContext(AgValueContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_array);
		int _la;
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__7);
				setState(53);
				agValue();
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(54);
					match(T__4);
					setState(55);
					agValue();
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__7);
				setState(64);
				match(T__8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeAnnotationContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(AgtypeParser.IDENT, 0); }
		public TypeAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterTypeAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitTypeAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitTypeAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeAnnotationContext typeAnnotation() throws RecognitionException {
		TypeAnnotationContext _localctx = new TypeAnnotationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__9);
			setState(68);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FloatLiteralContext extends ParserRuleContext {
		public TerminalNode RegularFloat() { return getToken(AgtypeParser.RegularFloat, 0); }
		public TerminalNode ExponentFloat() { return getToken(AgtypeParser.ExponentFloat, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AgtypeListener ) ((AgtypeListener)listener).exitFloatLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AgtypeVisitor ) return ((AgtypeVisitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatLiteralContext floatLiteral() throws RecognitionException {
		FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_floatLiteral);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RegularFloat:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(RegularFloat);
				}
				break;
			case ExponentFloat:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(ExponentFloat);
				}
				break;
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(72);
					match(T__10);
					}
				}

				setState(75);
				match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013P\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u0016"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003&\b\u0003\n\u0003\f\u0003)\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003/\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u00059\b\u0005\n\u0005\f\u0005<\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005B\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007J\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007N\b\u0007"+
		"\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000"+
		"W\u0000\u0010\u0001\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000"+
		"\u0004\u001f\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000\u0000\b"+
		"0\u0001\u0000\u0000\u0000\nA\u0001\u0000\u0000\u0000\fC\u0001\u0000\u0000"+
		"\u0000\u000eM\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000"+
		"\u0011\u0012\u0005\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000"+
		"\u0013\u0015\u0003\u0004\u0002\u0000\u0014\u0016\u0003\f\u0006\u0000\u0015"+
		"\u0014\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016"+
		"\u0003\u0001\u0000\u0000\u0000\u0017 \u0005\u000f\u0000\u0000\u0018 \u0005"+
		"\u0010\u0000\u0000\u0019 \u0003\u000e\u0007\u0000\u001a \u0005\u0001\u0000"+
		"\u0000\u001b \u0005\u0002\u0000\u0000\u001c \u0005\u0003\u0000\u0000\u001d"+
		" \u0003\u0006\u0003\u0000\u001e \u0003\n\u0005\u0000\u001f\u0017\u0001"+
		"\u0000\u0000\u0000\u001f\u0018\u0001\u0000\u0000\u0000\u001f\u0019\u0001"+
		"\u0000\u0000\u0000\u001f\u001a\u0001\u0000\u0000\u0000\u001f\u001b\u0001"+
		"\u0000\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 \u0005\u0001\u0000"+
		"\u0000\u0000!\"\u0005\u0004\u0000\u0000\"\'\u0003\b\u0004\u0000#$\u0005"+
		"\u0005\u0000\u0000$&\u0003\b\u0004\u0000%#\u0001\u0000\u0000\u0000&)\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(*\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005\u0006\u0000"+
		"\u0000+/\u0001\u0000\u0000\u0000,-\u0005\u0004\u0000\u0000-/\u0005\u0006"+
		"\u0000\u0000.!\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/\u0007"+
		"\u0001\u0000\u0000\u000001\u0005\u000f\u0000\u000012\u0005\u0007\u0000"+
		"\u000023\u0003\u0002\u0001\u00003\t\u0001\u0000\u0000\u000045\u0005\b"+
		"\u0000\u00005:\u0003\u0002\u0001\u000067\u0005\u0005\u0000\u000079\u0003"+
		"\u0002\u0001\u000086\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000=>\u0005\t\u0000\u0000>B\u0001\u0000\u0000"+
		"\u0000?@\u0005\b\u0000\u0000@B\u0005\t\u0000\u0000A4\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000B\u000b\u0001\u0000\u0000\u0000CD\u0005"+
		"\n\u0000\u0000DE\u0005\u000e\u0000\u0000E\r\u0001\u0000\u0000\u0000FN"+
		"\u0005\u0011\u0000\u0000GN\u0005\u0012\u0000\u0000HJ\u0005\u000b\u0000"+
		"\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KN\u0005\f\u0000\u0000LN\u0005\r\u0000\u0000MF\u0001\u0000"+
		"\u0000\u0000MG\u0001\u0000\u0000\u0000MI\u0001\u0000\u0000\u0000ML\u0001"+
		"\u0000\u0000\u0000N\u000f\u0001\u0000\u0000\u0000\b\u0015\u001f\'.:AI"+
		"M";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}