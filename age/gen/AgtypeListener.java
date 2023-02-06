// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AgtypeParser}.
 */
public interface AgtypeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#agType}.
	 * @param ctx the parse tree
	 */
	void enterAgType(AgtypeParser.AgTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#agType}.
	 * @param ctx the parse tree
	 */
	void exitAgType(AgtypeParser.AgTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#agValue}.
	 * @param ctx the parse tree
	 */
	void enterAgValue(AgtypeParser.AgValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#agValue}.
	 * @param ctx the parse tree
	 */
	void exitAgValue(AgtypeParser.AgValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(AgtypeParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(AgtypeParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntegerValue(AgtypeParser.IntegerValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntegerValue(AgtypeParser.IntegerValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFloatValue(AgtypeParser.FloatValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFloatValue(AgtypeParser.FloatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueBoolean}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterTrueBoolean(AgtypeParser.TrueBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueBoolean}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitTrueBoolean(AgtypeParser.TrueBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseBoolean}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFalseBoolean(AgtypeParser.FalseBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseBoolean}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFalseBoolean(AgtypeParser.FalseBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(AgtypeParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(AgtypeParser.NullValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterObjectValue(AgtypeParser.ObjectValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitObjectValue(AgtypeParser.ObjectValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(AgtypeParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(AgtypeParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(AgtypeParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(AgtypeParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(AgtypeParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(AgtypeParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(AgtypeParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(AgtypeParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#typeAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterTypeAnnotation(AgtypeParser.TypeAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#typeAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitTypeAnnotation(AgtypeParser.TypeAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgtypeParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(AgtypeParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgtypeParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(AgtypeParser.FloatLiteralContext ctx);
}