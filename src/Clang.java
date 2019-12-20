import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public	class Clang
{
	public static void main(String[] args) throws Exception
	{
		String inputFile = null;

		// Create the input stream.
		if (args.length > 0) inputFile = args[0];
		
		if (!inputFile.endsWith(".c")) {
			System.out.println("Input file must be end with an extension '.c'");
			return;
		}
		InputStream is = (inputFile != null)
				? new FileInputStream(inputFile)
				: System.in;

		// Create the character stream from the input stream.
		CharStream cs = CharStreams.fromStream(is);

		// Create a lexer which scans the character stream
		// to create a token stream.
		ClangLexer lexer = new ClangLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Create a parser which parses the token stream
		// to create a parse tree.
		ClangParser parser = new ClangParser(tokens);
		ParseTree tree = parser.program();

		// Visit the parse tree
		String fileNameWithoutExtension = inputFile.substring(0, inputFile.length()-2);
		Pass1Visitor pass1 = new Pass1Visitor(fileNameWithoutExtension);
		pass1.visit(tree);
	}
}