package main;

//Visitor especifico para calcular expresiones
public class VisitorNuestro extends ExprBaseVisitor<Integer>{

    public Integer visitAdd(ExprParser.AddContext ctx){
        return visit(ctx.e(0))+visit(ctx.e(1));
    }
    public Integer visitMult(ExprParser.MultContext ctx){
        return visit(ctx.e(0))*visit(ctx.e(1));
    }
    public Integer visitInt(ExprParser.IntContext ctx){
        return Integer.valueOf(ctx.INT().getText());
    }
}