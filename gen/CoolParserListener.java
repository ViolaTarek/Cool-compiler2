// Generated from E:/COOL-Compiler-master/src\CoolParser.g4 by ANTLR 4.7.2

	import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CoolParser}.
 */
public interface CoolParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CoolParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CoolParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classes}
	 * labeled alternative in {@link CoolParser#programBlocks}.
	 * @param ctx the parse tree
	 */
	void enterClasses(CoolParser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classes}
	 * labeled alternative in {@link CoolParser#programBlocks}.
	 * @param ctx the parse tree
	 */
	void exitClasses(CoolParser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#classDefine}.
	 * @param ctx the parse tree
	 */
	void enterClassDefine(CoolParser.ClassDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#classDefine}.
	 * @param ctx the parse tree
	 */
	void exitClassDefine(CoolParser.ClassDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#featureList}.
	 * @param ctx the parse tree
	 */
	void enterFeatureList(CoolParser.FeatureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#featureList}.
	 * @param ctx the parse tree
	 */
	void exitFeatureList(CoolParser.FeatureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(CoolParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(CoolParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(CoolParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(CoolParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(CoolParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(CoolParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#formalList}.
	 * @param ctx the parse tree
	 */
	void enterFormalList(CoolParser.FormalListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#formalList}.
	 * @param ctx the parse tree
	 */
	void exitFormalList(CoolParser.FormalListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(CoolParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(CoolParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(CoolParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(CoolParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(CoolParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(CoolParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letIn}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLetIn(CoolParser.LetInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letIn}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLetIn(CoolParser.LetInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNew(CoolParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNew(CoolParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(CoolParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(CoolParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(CoolParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(CoolParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueOrFlase}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFlase(CoolParser.TrueOrFlaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueOrFlase}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFlase(CoolParser.TrueOrFlaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(CoolParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(CoolParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isvoid}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsvoid(CoolParser.IsvoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isvoid}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsvoid(CoolParser.IsvoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CoolParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CoolParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concat}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConcat(CoolParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConcat(CoolParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWhile(CoolParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWhile(CoolParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInt(CoolParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInt(CoolParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code division}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivision(CoolParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code division}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivision(CoolParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqual(CoolParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqual(CoolParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negative}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegative(CoolParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegative(CoolParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolNot}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolNot(CoolParser.BoolNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolNot}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolNot(CoolParser.BoolNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(CoolParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(CoolParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CoolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CoolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(CoolParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(CoolParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessEqual(CoolParser.LessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessEqual(CoolParser.LessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(CoolParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(CoolParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIf(CoolParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIf(CoolParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(CoolParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(CoolParser.MethodCallContext ctx);
}