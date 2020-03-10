package main;
import gen.*;
import visitors.*;
import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main{
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if(args.length>0) inputFile= args[0];

//Fuerza la carga del fichero de preubas
inputFile = "source.smp";

        InputStream is = System.in;
        if (inputFile != null ) is= new FileInputStream(inputFile);
        
        CharStream input = CharStreams.fromStream(is);
      ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.s();
System.out.println(tree.toStringTree(parser));

       VisitorNuestro vn = new VisitorNuestro();
      int resultado = vn.visit(tree);
       System.out.println(resultado);
    }
}

