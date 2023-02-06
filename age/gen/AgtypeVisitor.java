// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AgtypeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AgtypeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#agType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgType(AgtypeParser.AgTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#agValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgValue(AgtypeParser.AgValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(AgtypeParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerValue(AgtypeParser.IntegerValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(AgtypeParser.FloatValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueBoolean}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueBoolean(AgtypeParser.TrueBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseBoolean}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseBoolean(AgtypeParser.FalseBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(AgtypeParser.NullValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectValue(AgtypeParser.ObjectValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AgtypeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(AgtypeParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(AgtypeParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(AgtypeParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(AgtypeParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#typeAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAnnotation(AgtypeParser.TypeAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgtypeParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(AgtypeParser.FloatLiteralContext ctx);
}