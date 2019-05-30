import java.util.ArrayList;
import java.util.List;

public class AST {
	public static class ASTNode {
		int lineNo;

		void gen(){

		}
	}

	public static ArrayList<String> threeAddressCode = new ArrayList<>();
	public static int tCounter = 1;
	public static int lCounter = 1;
	public static String sp = "  ";

	public static class program extends ASTNode {
		public ArrayList<AST.class_> classes_;
		public program(ArrayList<AST.class_> cl, int l){
			classes_ = cl;
			lineNo = l;
		}
		String getString(String space){
			String str;
			str = space+"#"+lineNo+"\n"+space+"_program";
			for ( class_ c : classes_ ) {
				str += "\n"+c.getString(space+sp);
			}
			return str;
		}
		void gen(){
			for ( AST.class_ c : classes_ ) {
				c.gen();
			}
		}
	}
	public static class class_ extends ASTNode {
		public String name;
		public String parent;
		public List<feature> features;
		public class_(String n, String p, List<feature> fl, int l){
			name = n;
			parent = p;
			features = fl;
			lineNo = l;
		}
		String getString(String space){
			String str;
			str = space+"#"+lineNo + " class:" + name;
			for ( feature f : features ) {
				str += "\n" + f.getString(space+sp);
			}
			return str;

		}
		void gen(){
			for ( feature f : features ) {
				f.gen();
			}
		}
	}
	public static class feature extends ASTNode {
		public feature(){

		}
		String getString(String space){

			return space+"feature";
		}
		void gen(){

		}
	}
	public static class method extends feature {
		String name;
		String returnType;
		public List<formal> formals;
		Expression exp;
		String v;
		public method(String n, String rt, List<formal> fl, Expression expression, int l){
			name = n;
			returnType = rt;
			formals = fl;
			exp = expression;
			lineNo = l;
		}
		String getString(String space){
			String str;

			str = space+"#"+lineNo+" method:" + name + " return type:" + returnType + "\n";
			if(formals.size() > 0)
				str += space + sp + "formals: " + formals.size() + "\n";
			else
				str+= space + sp + "no formals" + "\n";
			for ( formal f : formals ) {
				str += f.getString(space+sp) + "\n";
			}
			str +=  exp.getString(space+sp) + "\n";
			return str;
		}
		void gen() {
			threeAddressCode.add(name +": " +"\n" + " BeginFunc");
		}


	}
	public static class attribute extends feature {
		String name;
		String type;
		Boolean flag = false;
		Expression e;

		public attribute(String n, String t, int l){
			name = n;
			type = t;
			lineNo = l;
		}

		public attribute(String n, String t, int l, Expression e){
			name = n;
			type = t;
			lineNo = l;
			this.e = e;
			flag = true;
		}

		String getString(String space){

			return space+ "#" + lineNo + " attribute:" + name + " type:" + type + "\n";
		}

		void gen(){
			if(flag){
				e.gen();
				threeAddressCode.add(name + " = " + e.getV());

			}
		}

		String getV(){
			return name;
		}
	}
	public static class formal extends ASTNode {
		String name;
		String type;
		public formal(String n, String t){
			name = n;
			type = t;

		}
		String getString(String space){

			return space + "formal:" + name + " type:" + type + "\n";
		}
		void gen(){

		}
	}
	public static class Expression extends ASTNode {
		String type;
		public String v = "uninitialized";
		public Expression(){
			type = "no_type";
		}
		String getString(String space){

			return space + "Expression: type:" + type + "\n";
		}

		int eval(){
			return -999999;
		}
		String getV(){
			return v;
		}
	}
	public static class BlockOfExpr extends Expression {
		ArrayList<AST.Expression> exprs;
		String v;

		public BlockOfExpr(ArrayList<Expression> exprs){
			type = "BlockOfExpr";
			this.exprs = exprs;
			v = "t" + tCounter++;
		}

		String getString(String space){

			String str = space + "Expression: type:" + type + "\n";

			for(Expression e: exprs){
				str += e.getString(space+sp);
			}

			return str;
		}

		void gen(){
			Expression last = new Expression();

			for(Expression e: exprs){
				e.gen();
				last = e;
			}

			threeAddressCode.add(v + " = " + last.getV()+" entered block of expressions");
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class ArithmeticOp extends Expression {
		Expression e1;
		Expression e2;
		String op;
		int res;
		public String v;

		public ArithmeticOp(Expression exp1, Expression exp2, String operation) {

			e1 = exp1;
			e2 = exp2;
			op = operation;
			res = this.eval();
			v = "t" + tCounter++;
			//System.out.println(">>> " +v);

			switch (op) {
				case "+":
					type = "Add";
					break;
				case "-":
					type = "Sub";
					break;
				case "*":
					type = "Mul";
					break;
				case "/":
					type = "Div";
					break;
				default:
					type = "un identified";
					break;

			}
		}

		String getString(String space) {

			return space + "Expression: type:" + type + "\n"
					+ space + e1.getString(space + sp) + "\n"
					+ space + e2.getString(space + sp) + "\n"
					+ space + "result = " + res + "\n";
		}

		int eval() {
			switch (op) {
				case "+":
					return e1.eval() + e2.eval();
				case "-":
					return e1.eval() - e2.eval();
				case "*":
					return e1.eval() * e2.eval();
				case "/":
					return e1.eval() / e2.eval();
				default:
					return -999999;
			}
		}

		void gen(){
			e1.gen();
			e2.gen();
			String command = v + " = " + e1.getV() + " " + op + " " + e2.getV();

			threeAddressCode.add(command);


		}
		@Override
		String getV(){
			return v;
		}
	}
	public static class IntConst extends Expression {
		int value;
		public String v;
		public IntConst(int vv){
			type = "IntConst";
			value = vv;
			this.v = Integer.toString(value);
		}
		String getString(String space){

			return space + "Expression: type:" + type + " value = " + value + "\n";
		}
		int eval(){
			return value;
		}

		void gen(){
			//threeAddressCode.add( Integer.toString(value)+" entered int const");
		}
		@Override
		String getV(){
			return v;
		}
	}
	public static class RelOp extends Expression {
		Expression e1;
		Expression e2;
		String op;
		public String v;

		public RelOp(Expression ee1, Expression ee2, String opp) {
			e1 = ee1;
			e2 = ee2;
			op = opp;
			v = "t" + tCounter++;

			switch (op) {
				case "<":
					type = "Less";
					break;
				case "=":
					type = "Equal";
					break;
				case "<=":
					type = "LEqual";
					break;
				default:
					type = "un identified";
					break;
			}
		}

		String getString(String space) {

			return space + "Expression: type:" + type + "\n"
					+ space + e1.getString(space + sp) + "\n"
					+ space + e2.getString(space + sp)+ "\n";
		}

		void gen(){
			e1.gen();
			e2.gen();
			String command = v + " = " + e1.getV() + " " + op + (op.equals("=") ? op : "") + " " + e2.getV();
			threeAddressCode.add(command);
		}
		@Override
		String getV(){
			return v;
		}
	}
	public static class LogOp extends Expression {
		Expression e;
		String op;
		public String v;

		public LogOp(Expression ee, String opp) {
			e = ee;
			op = opp;
			if(op.equals("NOT"))    op = "!";
			v = "t" + tCounter++;
		}

		String getString(String space) {

			return space + "Expression: type: "+ op + "\n"
					+ space + e.getString(space + sp) + "\n";
		}

		void gen(){
			e.gen();
			String command = v + " = " + op + " " + e.getV();
			threeAddressCode.add(command);
		}
		@Override
		String getV(){
			return v;
		}
	}
	public static class Parentheses extends Expression {
		Expression e;
		public String v;

		public Parentheses(Expression ee) {
			e = ee;
			v = e.getV();
		}

		String getString(String space) {

			return space + "Expression: type: Parentheses" + "\n"
					+ space + e.getString(space + sp) + "\n";
		}

		void gen(){
			e.gen();

		}
		@Override
		String getV(){
			return v;
		}
	}
	public static class If extends Expression {
		Expression exp1;
		Expression ifbody;
		Expression elsebody;
		String before_else, after_else;

		public String v;
		public If(Expression e1, Expression e2, Expression e3){
			this.exp1 = e1;
			this.ifbody = e2;
			this.elsebody = e3;
			type = "If";
			before_else = "A" + lCounter;
			after_else = "L" + lCounter++;
		}

		String getString(String space){

			return space + "Expression: type:" + type + "\n";
		}

		void gen(){
			exp1.gen();
			threeAddressCode.add("ifFalse ( " + exp1.getV() + " ) goto " + before_else );
			ifbody.gen();
			threeAddressCode.add("goto " + after_else );
			threeAddressCode.add(before_else + ": " );
			elsebody.gen();
			threeAddressCode.add(after_else + ": " );
			//threeAddressCode.add( Integer.toString(value));
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class While extends Expression {
		Expression e1;
		Expression e2;
		String before, after;

		public String v;
		public While(Expression e1, Expression e2){
			this.e1 = e1;
			this.e2 = e2;
			type = "While";
			before = "A" + lCounter;
			after = "L" + lCounter++;
		}

		String getString(String space){
			return space + "Expression: type:" + type + "\n";
		}

		void gen(){
			threeAddressCode.add(before + ": " );
			e1.gen();
			threeAddressCode.add("ifFalse " + e1.getV() + " goto " + after );
			e2.gen();
			threeAddressCode.add("goto " + before );
			threeAddressCode.add(after + ": ");
		}

	}
	public static class ObId extends Expression {
		public String v;
		public ObId(String v){
			type = "ObId";
			this.v = v;

		}
		String getString(String space){

			return space + "Expression: type:" + type + " value = " + v + "\n";
		}


		void gen(){

		}
		@Override
		String getV(){
			return v;
		}
	}
	public static class Assign extends Expression {
		public String v;
		Expression e;

		public Assign(String v, Expression e){
			type = "Ob_Assign";
			this.v = v;
			this.e = e;
		}

		String getString(String space){

			return space + "Expression: type:" + type + " value = " + v + "\n";
		}

		void gen(){
			e.gen();
			threeAddressCode.add(v + " = " + e.getV());
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class Str extends Expression {
		public String v;

		public Str(String st){
			type = "String";
			v = st;
		}

		String getString(String space){
			return space + "Expression: type:" + type + " value = " + v + "\n";
		}

		void gen(){
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class Bool extends Expression {
		public String v;

		public Bool(String bo){
			type = "BOOL_CONST";
			v = bo;
		}

		String getString(String space){
			return space + "Expression: type:" + type + " value = " + v + "\n";
		}

		void gen(){
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class NewType extends Expression {
		String type;
		public NewType(String type){
			this.type = type;
		}

		String getString(String space){
			return space + "Expression: type: NEW " + type + "\n";
		}

		void gen(){
		}

		@Override
		String getV(){
			return "NULL";
		}
	}
	public static class IsVo extends Expression {
		Expression e;
		public String v;

		public IsVo(Expression ee){
			e = ee;
			type = "IsVoid";
			v = "t" + tCounter++;
		}

		String getString(String space){
			return space + "Expression: type:" + type + "\n";
		}

		void gen(){
			e.gen();
			String command = v + " = " + e.getV() + " == NULL";
			threeAddressCode.add(command);
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class Let extends Expression {
		Expression e;
		ArrayList<Expression> exprs;
		ArrayList<String> ids;
		ArrayList<Boolean> flags;
		String type;
		public String v;

		public Let(ArrayList<Boolean> flags, ArrayList<String> ids, ArrayList<Expression> exprs, Expression e){
			this.exprs = exprs;
			this.flags = flags;
			this.ids = ids;
			this.e = e;
			type = "LET";
			v = "t" + tCounter++;
		}

		String getString(String space){
			return space + "Expression: type:" + type + "\n";
		}

		void gen(){
			int po = 0;
			for (AST.Expression it : exprs){
				if(flags.get(po)){
					it.gen();
					threeAddressCode.add(ids.get(po) + " = " + it.getV());
				}
				po++;
			}

			e.gen();
			//threeAddressCode.add(v + " = " + e.getV()+ " entered let after gen");
		}

		@Override
		String getV(){
			return v;
		}
	}
	public static class dispatch extends Expression{
		public Expression caller;
		public String name;
		public ArrayList<Expression> actuals;
		public String v;

		public dispatch(Expression v1, String n, ArrayList<Expression> a, int l){
			caller = v1;
			name = n;
			actuals = a;
			lineNo = l;
		}
		String getString(String space){
			String str;
			str = space+"#"+lineNo+"\n"+space+"_dispatch\n"+caller.getString(space+sp)+"\n"+space+sp+name+"\n"+space+sp+"(\n";
			for ( AST.Expression e1 : actuals ) {
				str += e1.getString(space+sp)+"\n";
			}
			str+=space+sp+")\n"+space+": "+type;
			threeAddressCode.add("entered dispatch");

			return str;
		}
		void gen(){
			caller.gen();
			//threeAddressCode.add("entered dispatch");
		}

		@Override
		String getV() {
			return v;
		}
	}

}
