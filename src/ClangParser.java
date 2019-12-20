// Generated from Clang.g4 by ANTLR 4.7.2

    import wci.intermediate.TypeSpec;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NEWLINE=9, 
		BLANK=10, TAB=11, MAIN=12, ASSIGN=13, EQ=14, NOT_EQ=15, LE=16, LE_EQ=17, 
		GT=18, GT_EQ=19, ADD=20, SUB=21, MUL=22, DIV=23, MOD=24, INC_DEC=25, OR=26, 
		AND=27, NOT=28, VOID=29, INT=30, DOUBLE=31, STRING=32, IF=33, ELSE=34, 
		WHILE=35, FOR=36, RETURN=37, BREAK=38, ID=39, INT_NUM=40, DOUBLE_NUM=41, 
		STR_VALUE=42, BRAKETS=43;
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_identifier = 2, RULE_global_var_decl = 3, 
		RULE_global_var_list = 4, RULE_local_var_decl = 5, RULE_local_var_list = 6, 
		RULE_stmt = 7, RULE_assign_stmt = 8, RULE_nonassign_stmt = 9, RULE_block = 10, 
		RULE_if_stmt = 11, RULE_while_stmt = 12, RULE_for_init = 13, RULE_for_end = 14, 
		RULE_for_stmt = 15, RULE_rtn_stmt = 16, RULE_break_stmt = 17, RULE_inc_dec_stmt = 18, 
		RULE_expr = 19, RULE_actual_arg_list = 20, RULE_func_call = 21, RULE_argument = 22, 
		RULE_formal_args = 23, RULE_formal_args_proto = 24, RULE_func = 25, RULE_main_func = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "identifier", "global_var_decl", "global_var_list", 
			"local_var_decl", "local_var_list", "stmt", "assign_stmt", "nonassign_stmt", 
			"block", "if_stmt", "while_stmt", "for_init", "for_end", "for_stmt", 
			"rtn_stmt", "break_stmt", "inc_dec_stmt", "expr", "actual_arg_list", 
			"func_call", "argument", "formal_args", "formal_args_proto", "func", 
			"main_func"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "';'", "','", "'{'", "'}'", "'('", "')'", null, "' '", 
			"'\t'", "'main'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", null, "'||'", "'&&'", "'!'", "'void'", 
			"'int'", "'double'", "'string'", "'if'", "'else'", "'while'", "'for'", 
			"'return'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NEWLINE", "BLANK", 
			"TAB", "MAIN", "ASSIGN", "EQ", "NOT_EQ", "LE", "LE_EQ", "GT", "GT_EQ", 
			"ADD", "SUB", "MUL", "DIV", "MOD", "INC_DEC", "OR", "AND", "NOT", "VOID", 
			"INT", "DOUBLE", "STRING", "IF", "ELSE", "WHILE", "FOR", "RETURN", "BREAK", 
			"ID", "INT_NUM", "DOUBLE_NUM", "STR_VALUE", "BRAKETS"
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
	public String getGrammarFileName() { return "Clang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ClangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Main_funcContext main_func() {
			return getRuleContext(Main_funcContext.class,0);
		}
		public List<Global_var_declContext> global_var_decl() {
			return getRuleContexts(Global_var_declContext.class);
		}
		public Global_var_declContext global_var_decl(int i) {
			return getRuleContext(Global_var_declContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(56);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(54);
						global_var_decl();
						}
						break;
					case 2:
						{
						setState(55);
						func();
						}
						break;
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(61);
			main_func();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << DOUBLE) | (1L << STRING))) != 0)) {
				{
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(62);
					global_var_decl();
					}
					break;
				case 2:
					{
					setState(63);
					func();
					}
					break;
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(ClangParser.VOID, 0); }
		public TerminalNode INT() { return getToken(ClangParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ClangParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(ClangParser.STRING, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << DOUBLE) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ClangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(ID);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(72);
					match(T__0);
					setState(73);
					expr(0);
					setState(74);
					match(T__1);
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class Global_var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Global_var_listContext global_var_list() {
			return getRuleContext(Global_var_listContext.class,0);
		}
		public Global_var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitGlobal_var_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_var_declContext global_var_decl() throws RecognitionException {
		Global_var_declContext _localctx = new Global_var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_global_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			type();
			setState(82);
			global_var_list();
			setState(83);
			match(T__2);
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

	public static class Global_var_listContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(ClangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(ClangParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Global_var_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_var_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitGlobal_var_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_var_listContext global_var_list() throws RecognitionException {
		Global_var_listContext _localctx = new Global_var_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_global_var_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			identifier();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(86);
				match(ASSIGN);
				setState(87);
				expr(0);
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(90);
				match(T__3);
				setState(91);
				identifier();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(92);
					match(ASSIGN);
					setState(93);
					expr(0);
					}
				}

				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Local_var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Local_var_listContext local_var_list() {
			return getRuleContext(Local_var_listContext.class,0);
		}
		public Local_var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitLocal_var_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_var_declContext local_var_decl() throws RecognitionException {
		Local_var_declContext _localctx = new Local_var_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_local_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			type();
			setState(102);
			local_var_list();
			setState(103);
			match(T__2);
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

	public static class Local_var_listContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(ClangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(ClangParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Local_var_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_var_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitLocal_var_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_var_listContext local_var_list() throws RecognitionException {
		Local_var_listContext _localctx = new Local_var_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_local_var_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			identifier();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(106);
				match(ASSIGN);
				setState(107);
				expr(0);
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(110);
				match(T__3);
				setState(111);
				identifier();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(112);
					match(ASSIGN);
					setState(113);
					expr(0);
					}
				}

				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Nonassign_stmtContext nonassign_stmt() {
			return getRuleContext(Nonassign_stmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Rtn_stmtContext rtn_stmt() {
			return getRuleContext(Rtn_stmtContext.class,0);
		}
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Inc_dec_stmtContext inc_dec_stmt() {
			return getRuleContext(Inc_dec_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				assign_stmt();
				setState(122);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				nonassign_stmt();
				setState(125);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				if_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				while_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				for_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				rtn_stmt();
				setState(132);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				break_stmt();
				setState(135);
				match(T__2);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(137);
				inc_dec_stmt();
				setState(138);
				match(T__2);
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ClangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			identifier();
			setState(143);
			match(ASSIGN);
			setState(144);
			expr(0);
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

	public static class Nonassign_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Nonassign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonassign_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitNonassign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nonassign_stmtContext nonassign_stmt() throws RecognitionException {
		Nonassign_stmtContext _localctx = new Nonassign_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nonassign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			expr(0);
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

	public static class BlockContext extends ParserRuleContext {
		public List<Local_var_declContext> local_var_decl() {
			return getRuleContexts(Local_var_declContext.class);
		}
		public Local_var_declContext local_var_decl(int i) {
			return getRuleContext(Local_var_declContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__4);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << ADD) | (1L << SUB) | (1L << INC_DEC) | (1L << NOT) | (1L << VOID) | (1L << INT) | (1L << DOUBLE) | (1L << STRING) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << ID) | (1L << INT_NUM) | (1L << DOUBLE_NUM) | (1L << STR_VALUE))) != 0)) {
				{
				setState(151);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VOID:
				case INT:
				case DOUBLE:
				case STRING:
					{
					setState(149);
					local_var_decl();
					}
					break;
				case T__4:
				case T__6:
				case ADD:
				case SUB:
				case INC_DEC:
				case NOT:
				case IF:
				case WHILE:
				case FOR:
				case RETURN:
				case BREAK:
				case ID:
				case INT_NUM:
				case DOUBLE_NUM:
				case STR_VALUE:
					{
					setState(150);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(T__5);
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ClangParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ClangParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(IF);
			setState(159);
			match(T__6);
			setState(160);
			expr(0);
			setState(161);
			match(T__7);
			setState(162);
			block();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(163);
				match(ELSE);
				setState(164);
				block();
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

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ClangParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(WHILE);
			setState(168);
			match(T__6);
			setState(169);
			expr(0);
			setState(170);
			match(T__7);
			setState(171);
			block();
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

	public static class For_initContext extends ParserRuleContext {
		public Local_var_declContext local_var_decl() {
			return getRuleContext(Local_var_declContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFor_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_for_init);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
			case DOUBLE:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				local_var_decl();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				assign_stmt();
				setState(175);
				match(T__2);
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

	public static class For_endContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Inc_dec_stmtContext inc_dec_stmt() {
			return getRuleContext(Inc_dec_stmtContext.class,0);
		}
		public For_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_end; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFor_end(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_endContext for_end() throws RecognitionException {
		For_endContext _localctx = new For_endContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_for_end);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				assign_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				inc_dec_stmt();
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ClangParser.FOR, 0); }
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_endContext for_end() {
			return getRuleContext(For_endContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(FOR);
			setState(184);
			match(T__6);
			setState(185);
			for_init();
			setState(186);
			expr(0);
			setState(187);
			match(T__2);
			setState(188);
			for_end();
			setState(189);
			match(T__7);
			setState(190);
			block();
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

	public static class Rtn_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ClangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Rtn_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtn_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitRtn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rtn_stmtContext rtn_stmt() throws RecognitionException {
		Rtn_stmtContext _localctx = new Rtn_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rtn_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(RETURN);
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case ADD:
			case SUB:
			case NOT:
			case ID:
			case INT_NUM:
			case DOUBLE_NUM:
			case STR_VALUE:
				{
				setState(193);
				expr(0);
				}
				break;
			case T__2:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(ClangParser.BREAK, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitBreak_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(BREAK);
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

	public static class Inc_dec_stmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INC_DEC() { return getToken(ClangParser.INC_DEC, 0); }
		public Inc_dec_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_dec_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitInc_dec_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inc_dec_stmtContext inc_dec_stmt() throws RecognitionException {
		Inc_dec_stmtContext _localctx = new Inc_dec_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_inc_dec_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(199);
				identifier();
				setState(200);
				match(INC_DEC);
				}
				break;
			case INC_DEC:
				{
				setState(202);
				match(INC_DEC);
				setState(203);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExprContext extends ParserRuleContext {
		public TypeSpec typeSpec = null;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.typeSpec = ctx.typeSpec;
		}
	}
	public static class IntNumContext extends ExprContext {
		public TerminalNode INT_NUM() { return getToken(ClangParser.INT_NUM, 0); }
		public IntNumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitIntNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ClangParser.OR, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token addSubOp;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ClangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ClangParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrValueContext extends ExprContext {
		public TerminalNode STR_VALUE() { return getToken(ClangParser.STR_VALUE, 0); }
		public StrValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitStrValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelativityContext extends ExprContext {
		public Token relOp;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(ClangParser.LE, 0); }
		public TerminalNode LE_EQ() { return getToken(ClangParser.LE_EQ, 0); }
		public TerminalNode GT() { return getToken(ClangParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(ClangParser.GT_EQ, 0); }
		public RelativityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitRelativity(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleNumContext extends ExprContext {
		public TerminalNode DOUBLE_NUM() { return getToken(ClangParser.DOUBLE_NUM, 0); }
		public DoubleNumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitDoubleNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallContext extends ExprContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public FuncCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(ClangParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SignedExprContext extends ExprContext {
		public Token sign;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ADD() { return getToken(ClangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ClangParser.SUB, 0); }
		public SignedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitSignedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends ExprContext {
		public Token mulDivModOp;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ClangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ClangParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ClangParser.MOD, 0); }
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(ClangParser.AND, 0); }
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityContext extends ExprContext {
		public Token eqOp;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ClangParser.EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(ClangParser.NOT_EQ, 0); }
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(207);
				identifier();
				}
				break;
			case 2:
				{
				_localctx = new IntNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(INT_NUM);
				}
				break;
			case 3:
				{
				_localctx = new DoubleNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(DOUBLE_NUM);
				}
				break;
			case 4:
				{
				_localctx = new StrValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(STR_VALUE);
				}
				break;
			case 5:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(NOT);
				setState(212);
				expr(10);
				}
				break;
			case 6:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(T__6);
				setState(214);
				expr(0);
				setState(215);
				match(T__7);
				}
				break;
			case 7:
				{
				_localctx = new FuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				func_call();
				}
				break;
			case 8:
				{
				_localctx = new SignedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				((SignedExprContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((SignedExprContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(219);
				expr(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(223);
						((MulDivModContext)_localctx).mulDivModOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).mulDivModOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(226);
						((AddSubContext)_localctx).addSubOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).addSubOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(227);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new RelativityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(229);
						((RelativityContext)_localctx).relOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LE_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
							((RelativityContext)_localctx).relOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(230);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232);
						((EqualityContext)_localctx).eqOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NOT_EQ) ) {
							((EqualityContext)_localctx).eqOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(233);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235);
						match(AND);
						setState(236);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(238);
						match(OR);
						setState(239);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Actual_arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Actual_arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actual_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitActual_arg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Actual_arg_listContext actual_arg_list() throws RecognitionException {
		Actual_arg_listContext _localctx = new Actual_arg_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_actual_arg_list);
		int _la;
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case ADD:
			case SUB:
			case NOT:
			case ID:
			case INT_NUM:
			case DOUBLE_NUM:
			case STR_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(245);
				expr(0);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(246);
					match(T__3);
					setState(247);
					expr(0);
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Func_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ClangParser.ID, 0); }
		public Actual_arg_listContext actual_arg_list() {
			return getRuleContext(Actual_arg_listContext.class,0);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ID);
			setState(257);
			match(T__6);
			setState(258);
			actual_arg_list();
			setState(259);
			match(T__7);
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

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ClangParser.ID, 0); }
		public List<TerminalNode> BRAKETS() { return getTokens(ClangParser.BRAKETS); }
		public TerminalNode BRAKETS(int i) {
			return getToken(ClangParser.BRAKETS, i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(ID);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BRAKETS) {
				{
				{
				setState(262);
				match(BRAKETS);
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Formal_argsContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public TerminalNode VOID() { return getToken(ClangParser.VOID, 0); }
		public Formal_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFormal_args(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_argsContext formal_args() throws RecognitionException {
		Formal_argsContext _localctx = new Formal_argsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_formal_args);
		int _la;
		try {
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(268);
				type();
				setState(269);
				argument();
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(270);
					match(T__3);
					setState(271);
					type();
					setState(272);
					argument();
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class Formal_args_protoContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public TerminalNode VOID() { return getToken(ClangParser.VOID, 0); }
		public Formal_args_protoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_args_proto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFormal_args_proto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_args_protoContext formal_args_proto() throws RecognitionException {
		Formal_args_protoContext _localctx = new Formal_args_protoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_formal_args_proto);
		int _la;
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(283);
				type();
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(284);
					argument();
					}
				}

				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(287);
					match(T__3);
					setState(288);
					type();
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(289);
						argument();
						}
					}

					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class FuncContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ClangParser.ID, 0); }
		public Formal_argsContext formal_args() {
			return getRuleContext(Formal_argsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			type();
			setState(302);
			match(ID);
			setState(303);
			match(T__6);
			setState(304);
			formal_args();
			setState(305);
			match(T__7);
			setState(306);
			block();
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

	public static class Main_funcContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(ClangParser.MAIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Main_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClangVisitor ) return ((ClangVisitor<? extends T>)visitor).visitMain_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_funcContext main_func() throws RecognitionException {
		Main_funcContext _localctx = new Main_funcContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_main_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			type();
			setState(309);
			match(MAIN);
			setState(310);
			match(T__6);
			setState(311);
			match(T__7);
			setState(312);
			block();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u013d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2"+
		"\3\2\7\2C\n\2\f\2\16\2F\13\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4O\n\4\f\4"+
		"\16\4R\13\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\3\6\3\6\5\6a"+
		"\n\6\7\6c\n\6\f\6\16\6f\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bo\n\b\3\b"+
		"\3\b\3\b\3\b\5\bu\n\b\7\bw\n\b\f\b\16\bz\13\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008f\n\t\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\f\u009a\n\f\f\f\16\f\u009d\13\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\5\17\u00b4\n\17\3\20\3\20\5\20\u00b8\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u00c6"+
		"\n\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\5\24\u00cf\n\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00df\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u00f3\n\25\f\25\16\25\u00f6\13\25\3\26\3\26"+
		"\3\26\7\26\u00fb\n\26\f\26\16\26\u00fe\13\26\3\26\5\26\u0101\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u010a\n\30\f\30\16\30\u010d\13\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0115\n\31\f\31\16\31\u0118\13\31"+
		"\3\31\3\31\5\31\u011c\n\31\3\32\3\32\5\32\u0120\n\32\3\32\3\32\3\32\5"+
		"\32\u0125\n\32\7\32\u0127\n\32\f\32\16\32\u012a\13\32\3\32\3\32\5\32\u012e"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\2\3(\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\66\2\7\3\2\37\"\3\2\26\27\3\2\30\32\3\2\22\25\3\2\20\21\2\u0153\2<\3"+
		"\2\2\2\4G\3\2\2\2\6I\3\2\2\2\bS\3\2\2\2\nW\3\2\2\2\fg\3\2\2\2\16k\3\2"+
		"\2\2\20\u008e\3\2\2\2\22\u0090\3\2\2\2\24\u0094\3\2\2\2\26\u0096\3\2\2"+
		"\2\30\u00a0\3\2\2\2\32\u00a9\3\2\2\2\34\u00b3\3\2\2\2\36\u00b7\3\2\2\2"+
		" \u00b9\3\2\2\2\"\u00c2\3\2\2\2$\u00c7\3\2\2\2&\u00ce\3\2\2\2(\u00de\3"+
		"\2\2\2*\u0100\3\2\2\2,\u0102\3\2\2\2.\u0107\3\2\2\2\60\u011b\3\2\2\2\62"+
		"\u012d\3\2\2\2\64\u012f\3\2\2\2\66\u0136\3\2\2\28;\5\b\5\29;\5\64\33\2"+
		":8\3\2\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2"+
		"?D\5\66\34\2@C\5\b\5\2AC\5\64\33\2B@\3\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2E\3\3\2\2\2FD\3\2\2\2GH\t\2\2\2H\5\3\2\2\2IP\7)\2\2JK\7"+
		"\3\2\2KL\5(\25\2LM\7\4\2\2MO\3\2\2\2NJ\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3"+
		"\2\2\2Q\7\3\2\2\2RP\3\2\2\2ST\5\4\3\2TU\5\n\6\2UV\7\5\2\2V\t\3\2\2\2W"+
		"Z\5\6\4\2XY\7\17\2\2Y[\5(\25\2ZX\3\2\2\2Z[\3\2\2\2[d\3\2\2\2\\]\7\6\2"+
		"\2]`\5\6\4\2^_\7\17\2\2_a\5(\25\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b\\\3\2"+
		"\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\13\3\2\2\2fd\3\2\2\2gh\5\4\3\2hi\5"+
		"\16\b\2ij\7\5\2\2j\r\3\2\2\2kn\5\6\4\2lm\7\17\2\2mo\5(\25\2nl\3\2\2\2"+
		"no\3\2\2\2ox\3\2\2\2pq\7\6\2\2qt\5\6\4\2rs\7\17\2\2su\5(\25\2tr\3\2\2"+
		"\2tu\3\2\2\2uw\3\2\2\2vp\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\17\3\2"+
		"\2\2zx\3\2\2\2{|\5\22\n\2|}\7\5\2\2}\u008f\3\2\2\2~\177\5\24\13\2\177"+
		"\u0080\7\5\2\2\u0080\u008f\3\2\2\2\u0081\u008f\5\26\f\2\u0082\u008f\5"+
		"\30\r\2\u0083\u008f\5\32\16\2\u0084\u008f\5 \21\2\u0085\u0086\5\"\22\2"+
		"\u0086\u0087\7\5\2\2\u0087\u008f\3\2\2\2\u0088\u0089\5$\23\2\u0089\u008a"+
		"\7\5\2\2\u008a\u008f\3\2\2\2\u008b\u008c\5&\24\2\u008c\u008d\7\5\2\2\u008d"+
		"\u008f\3\2\2\2\u008e{\3\2\2\2\u008e~\3\2\2\2\u008e\u0081\3\2\2\2\u008e"+
		"\u0082\3\2\2\2\u008e\u0083\3\2\2\2\u008e\u0084\3\2\2\2\u008e\u0085\3\2"+
		"\2\2\u008e\u0088\3\2\2\2\u008e\u008b\3\2\2\2\u008f\21\3\2\2\2\u0090\u0091"+
		"\5\6\4\2\u0091\u0092\7\17\2\2\u0092\u0093\5(\25\2\u0093\23\3\2\2\2\u0094"+
		"\u0095\5(\25\2\u0095\25\3\2\2\2\u0096\u009b\7\7\2\2\u0097\u009a\5\f\7"+
		"\2\u0098\u009a\5\20\t\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\b\2\2\u009f\27\3\2\2\2\u00a0\u00a1"+
		"\7#\2\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3\5(\25\2\u00a3\u00a4\7\n\2\2\u00a4"+
		"\u00a7\5\26\f\2\u00a5\u00a6\7$\2\2\u00a6\u00a8\5\26\f\2\u00a7\u00a5\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\31\3\2\2\2\u00a9\u00aa\7%\2\2\u00aa\u00ab"+
		"\7\t\2\2\u00ab\u00ac\5(\25\2\u00ac\u00ad\7\n\2\2\u00ad\u00ae\5\26\f\2"+
		"\u00ae\33\3\2\2\2\u00af\u00b4\5\f\7\2\u00b0\u00b1\5\22\n\2\u00b1\u00b2"+
		"\7\5\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4"+
		"\35\3\2\2\2\u00b5\u00b8\5\22\n\2\u00b6\u00b8\5&\24\2\u00b7\u00b5\3\2\2"+
		"\2\u00b7\u00b6\3\2\2\2\u00b8\37\3\2\2\2\u00b9\u00ba\7&\2\2\u00ba\u00bb"+
		"\7\t\2\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\5(\25\2\u00bd\u00be\7\5\2\2"+
		"\u00be\u00bf\5\36\20\2\u00bf\u00c0\7\n\2\2\u00c0\u00c1\5\26\f\2\u00c1"+
		"!\3\2\2\2\u00c2\u00c5\7\'\2\2\u00c3\u00c6\5(\25\2\u00c4\u00c6\3\2\2\2"+
		"\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6#\3\2\2\2\u00c7\u00c8\7"+
		"(\2\2\u00c8%\3\2\2\2\u00c9\u00ca\5\6\4\2\u00ca\u00cb\7\33\2\2\u00cb\u00cf"+
		"\3\2\2\2\u00cc\u00cd\7\33\2\2\u00cd\u00cf\5\6\4\2\u00ce\u00c9\3\2\2\2"+
		"\u00ce\u00cc\3\2\2\2\u00cf\'\3\2\2\2\u00d0\u00d1\b\25\1\2\u00d1\u00df"+
		"\5\6\4\2\u00d2\u00df\7*\2\2\u00d3\u00df\7+\2\2\u00d4\u00df\7,\2\2\u00d5"+
		"\u00d6\7\36\2\2\u00d6\u00df\5(\25\f\u00d7\u00d8\7\t\2\2\u00d8\u00d9\5"+
		"(\25\2\u00d9\u00da\7\n\2\2\u00da\u00df\3\2\2\2\u00db\u00df\5,\27\2\u00dc"+
		"\u00dd\t\3\2\2\u00dd\u00df\5(\25\t\u00de\u00d0\3\2\2\2\u00de\u00d2\3\2"+
		"\2\2\u00de\u00d3\3\2\2\2\u00de\u00d4\3\2\2\2\u00de\u00d5\3\2\2\2\u00de"+
		"\u00d7\3\2\2\2\u00de\u00db\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00f4\3\2"+
		"\2\2\u00e0\u00e1\f\b\2\2\u00e1\u00e2\t\4\2\2\u00e2\u00f3\5(\25\t\u00e3"+
		"\u00e4\f\7\2\2\u00e4\u00e5\t\3\2\2\u00e5\u00f3\5(\25\b\u00e6\u00e7\f\6"+
		"\2\2\u00e7\u00e8\t\5\2\2\u00e8\u00f3\5(\25\7\u00e9\u00ea\f\5\2\2\u00ea"+
		"\u00eb\t\6\2\2\u00eb\u00f3\5(\25\6\u00ec\u00ed\f\4\2\2\u00ed\u00ee\7\35"+
		"\2\2\u00ee\u00f3\5(\25\5\u00ef\u00f0\f\3\2\2\u00f0\u00f1\7\34\2\2\u00f1"+
		"\u00f3\5(\25\4\u00f2\u00e0\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00e6\3\2"+
		"\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00ec\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5)\3\2\2\2"+
		"\u00f6\u00f4\3\2\2\2\u00f7\u00fc\5(\25\2\u00f8\u00f9\7\6\2\2\u00f9\u00fb"+
		"\5(\25\2\u00fa\u00f8\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u0101\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0101\3\2"+
		"\2\2\u0100\u00f7\3\2\2\2\u0100\u00ff\3\2\2\2\u0101+\3\2\2\2\u0102\u0103"+
		"\7)\2\2\u0103\u0104\7\t\2\2\u0104\u0105\5*\26\2\u0105\u0106\7\n\2\2\u0106"+
		"-\3\2\2\2\u0107\u010b\7)\2\2\u0108\u010a\7-\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c/\3\2\2\2"+
		"\u010d\u010b\3\2\2\2\u010e\u010f\5\4\3\2\u010f\u0116\5.\30\2\u0110\u0111"+
		"\7\6\2\2\u0111\u0112\5\4\3\2\u0112\u0113\5.\30\2\u0113\u0115\3\2\2\2\u0114"+
		"\u0110\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u011c\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011c\7\37\2\2\u011a"+
		"\u011c\3\2\2\2\u011b\u010e\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2"+
		"\2\2\u011c\61\3\2\2\2\u011d\u011f\5\4\3\2\u011e\u0120\5.\30\2\u011f\u011e"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0128\3\2\2\2\u0121\u0122\7\6\2\2\u0122"+
		"\u0124\5\4\3\2\u0123\u0125\5.\30\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0127\3\2\2\2\u0126\u0121\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012e\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012b\u012e\7\37\2\2\u012c\u012e\3\2\2\2\u012d\u011d\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\63\3\2\2\2\u012f\u0130\5\4\3"+
		"\2\u0130\u0131\7)\2\2\u0131\u0132\7\t\2\2\u0132\u0133\5\60\31\2\u0133"+
		"\u0134\7\n\2\2\u0134\u0135\5\26\f\2\u0135\65\3\2\2\2\u0136\u0137\5\4\3"+
		"\2\u0137\u0138\7\16\2\2\u0138\u0139\7\t\2\2\u0139\u013a\7\n\2\2\u013a"+
		"\u013b\5\26\f\2\u013b\67\3\2\2\2!:<BDPZ`dntx\u008e\u0099\u009b\u00a7\u00b3"+
		"\u00b7\u00c5\u00ce\u00de\u00f2\u00f4\u00fc\u0100\u010b\u0116\u011b\u011f"+
		"\u0124\u0128\u012d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}