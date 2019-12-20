// Generated from Clang.g4 by ANTLR 4.7.2

    import wci.intermediate.TypeSpec;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NEWLINE", 
			"BLANK", "TAB", "MAIN", "ASSIGN", "EQ", "NOT_EQ", "LE", "LE_EQ", "GT", 
			"GT_EQ", "ADD", "SUB", "MUL", "DIV", "MOD", "INC_DEC", "OR", "AND", "NOT", 
			"VOID", "INT", "DOUBLE", "STRING", "IF", "ELSE", "WHILE", "FOR", "RETURN", 
			"BREAK", "ID", "INT_NUM", "DOUBLE_NUM", "STR_VALUE", "BRAKETS"
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


	public ClangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Clang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0100\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\5\nk\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u009e\n\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\7(\u00e0\n(\f(\16(\u00e3\13(\3)\6)\u00e6\n)\r)\16)\u00e7\3*\6*"+
		"\u00eb\n*\r*\16*\u00ec\3*\3*\6*\u00f1\n*\r*\16*\u00f2\3+\3+\7+\u00f7\n"+
		"+\f+\16+\u00fa\13+\3+\3+\3,\3,\3,\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2"+
		"\6\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\3\2$$\2\u0106\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3"+
		"Y\3\2\2\2\5[\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e"+
		"\3\2\2\2\21g\3\2\2\2\23j\3\2\2\2\25p\3\2\2\2\27t\3\2\2\2\31x\3\2\2\2\33"+
		"}\3\2\2\2\35\177\3\2\2\2\37\u0082\3\2\2\2!\u0085\3\2\2\2#\u0087\3\2\2"+
		"\2%\u008a\3\2\2\2\'\u008c\3\2\2\2)\u008f\3\2\2\2+\u0091\3\2\2\2-\u0093"+
		"\3\2\2\2/\u0095\3\2\2\2\61\u0097\3\2\2\2\63\u009d\3\2\2\2\65\u009f\3\2"+
		"\2\2\67\u00a2\3\2\2\29\u00a5\3\2\2\2;\u00a7\3\2\2\2=\u00ac\3\2\2\2?\u00b0"+
		"\3\2\2\2A\u00b7\3\2\2\2C\u00be\3\2\2\2E\u00c1\3\2\2\2G\u00c6\3\2\2\2I"+
		"\u00cc\3\2\2\2K\u00d0\3\2\2\2M\u00d7\3\2\2\2O\u00dd\3\2\2\2Q\u00e5\3\2"+
		"\2\2S\u00ea\3\2\2\2U\u00f4\3\2\2\2W\u00fd\3\2\2\2YZ\7]\2\2Z\4\3\2\2\2"+
		"[\\\7_\2\2\\\6\3\2\2\2]^\7=\2\2^\b\3\2\2\2_`\7.\2\2`\n\3\2\2\2ab\7}\2"+
		"\2b\f\3\2\2\2cd\7\177\2\2d\16\3\2\2\2ef\7*\2\2f\20\3\2\2\2gh\7+\2\2h\22"+
		"\3\2\2\2ik\7\17\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\f\2\2mn\3\2\2\2"+
		"no\b\n\2\2o\24\3\2\2\2pq\7\"\2\2qr\3\2\2\2rs\b\13\2\2s\26\3\2\2\2tu\7"+
		"\13\2\2uv\3\2\2\2vw\b\f\2\2w\30\3\2\2\2xy\7o\2\2yz\7c\2\2z{\7k\2\2{|\7"+
		"p\2\2|\32\3\2\2\2}~\7?\2\2~\34\3\2\2\2\177\u0080\7?\2\2\u0080\u0081\7"+
		"?\2\2\u0081\36\3\2\2\2\u0082\u0083\7#\2\2\u0083\u0084\7?\2\2\u0084 \3"+
		"\2\2\2\u0085\u0086\7>\2\2\u0086\"\3\2\2\2\u0087\u0088\7>\2\2\u0088\u0089"+
		"\7?\2\2\u0089$\3\2\2\2\u008a\u008b\7@\2\2\u008b&\3\2\2\2\u008c\u008d\7"+
		"@\2\2\u008d\u008e\7?\2\2\u008e(\3\2\2\2\u008f\u0090\7-\2\2\u0090*\3\2"+
		"\2\2\u0091\u0092\7/\2\2\u0092,\3\2\2\2\u0093\u0094\7,\2\2\u0094.\3\2\2"+
		"\2\u0095\u0096\7\61\2\2\u0096\60\3\2\2\2\u0097\u0098\7\'\2\2\u0098\62"+
		"\3\2\2\2\u0099\u009a\7-\2\2\u009a\u009e\7-\2\2\u009b\u009c\7/\2\2\u009c"+
		"\u009e\7/\2\2\u009d\u0099\3\2\2\2\u009d\u009b\3\2\2\2\u009e\64\3\2\2\2"+
		"\u009f\u00a0\7~\2\2\u00a0\u00a1\7~\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7"+
		"(\2\2\u00a3\u00a4\7(\2\2\u00a48\3\2\2\2\u00a5\u00a6\7#\2\2\u00a6:\3\2"+
		"\2\2\u00a7\u00a8\7x\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab"+
		"\7f\2\2\u00ab<\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af"+
		"\7v\2\2\u00af>\3\2\2\2\u00b0\u00b1\7f\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3"+
		"\7w\2\2\u00b3\u00b4\7d\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7g\2\2\u00b6"+
		"@\3\2\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7t\2\2\u00ba"+
		"\u00bb\7k\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7i\2\2\u00bdB\3\2\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7h\2\2\u00c0D\3\2\2\2\u00c1\u00c2\7g\2\2\u00c2"+
		"\u00c3\7n\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7g\2\2\u00c5F\3\2\2\2\u00c6"+
		"\u00c7\7y\2\2\u00c7\u00c8\7j\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7n\2\2"+
		"\u00ca\u00cb\7g\2\2\u00cbH\3\2\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7q\2"+
		"\2\u00ce\u00cf\7t\2\2\u00cfJ\3\2\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7"+
		"g\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7w\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6"+
		"\7p\2\2\u00d6L\3\2\2\2\u00d7\u00d8\7d\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da"+
		"\7g\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7m\2\2\u00dcN\3\2\2\2\u00dd\u00e1"+
		"\t\2\2\2\u00de\u00e0\t\3\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2P\3\2\2\2\u00e3\u00e1\3\2\2\2"+
		"\u00e4\u00e6\t\4\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8R\3\2\2\2\u00e9\u00eb\t\4\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\7\60\2\2\u00ef\u00f1\t\4\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3T\3\2\2\2\u00f4\u00f8\7$\2\2\u00f5\u00f7\n\5\2\2\u00f6\u00f5"+
		"\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7$\2\2\u00fcV\3\2\2\2\u00fd"+
		"\u00fe\7]\2\2\u00fe\u00ff\7_\2\2\u00ffX\3\2\2\2\n\2j\u009d\u00e1\u00e7"+
		"\u00ec\u00f2\u00f8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}