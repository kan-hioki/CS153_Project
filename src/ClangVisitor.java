// Generated from Clang.g4 by ANTLR 4.7.2

    import wci.intermediate.TypeSpec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ClangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ClangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ClangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ClangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ClangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#global_var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_var_decl(ClangParser.Global_var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#global_var_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_var_list(ClangParser.Global_var_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#local_var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_var_decl(ClangParser.Local_var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#local_var_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_var_list(ClangParser.Local_var_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(ClangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(ClangParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#nonassign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonassign_stmt(ClangParser.Nonassign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ClangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(ClangParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(ClangParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_init(ClangParser.For_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#for_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_end(ClangParser.For_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(ClangParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#rtn_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtn_stmt(ClangParser.Rtn_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(ClangParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#inc_dec_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInc_dec_stmt(ClangParser.Inc_dec_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntNum}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(ClangParser.IntNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(ClangParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ClangParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrValue}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrValue(ClangParser.StrValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ClangParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relativity}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativity(ClangParser.RelativityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleNum}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleNum(ClangParser.DoubleNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(ClangParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ClangParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedExpr}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedExpr(ClangParser.SignedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(ClangParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(ClangParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ClangParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link ClangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(ClangParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#actual_arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActual_arg_list(ClangParser.Actual_arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(ClangParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(ClangParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#formal_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_args(ClangParser.Formal_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#formal_args_proto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_args_proto(ClangParser.Formal_args_protoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(ClangParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClangParser#main_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_func(ClangParser.Main_funcContext ctx);
}