parser grammar CoolParser;

options {
	tokenVocab = CoolLexer;
}
@header{
	import java.util.List;
}
program returns [AST.program value]
    : pb = programBlocks EOF
    {
		$value = new AST.program($pb.value, $pb.value.get(0).lineNo);
	}
    ;

programBlocks returns [ArrayList<AST.class_> value]
    @init
    {
    	$value = new ArrayList<AST.class_>();
    }
     /*classes*/
    : (c = classDefine SEMICOLON {$value.add($c.value);})+ # classes
   ;

classDefine returns [AST.class_ value]
    /*class without inherit*/
    : c=CLASS n=TYPEID LBRACE fl=featureList RBRACE
    {
        $value = new AST.class_($n.getText(), "no_inherirts", $fl.value, $c.getLine());
    }
    /*class with inherit*/
    | c=CLASS n=TYPEID INHERITS p=TYPEID LBRACE fl=featureList RBRACE
    {
        $value = new AST.class_($n.getText(), $p.getText(), $fl.value, $c.getLine());
    }
    ;

featureList returns [ArrayList<AST.feature> value]
    @init
    {
    	$value = new ArrayList<AST.feature>();
    }
    : (f=feature SEMICOLON {$value.add($f.value);})*

    ;

feature returns [AST.feature value]
    : m=method
    {
        $value = $m.value;
    }
    | d=attribute
    {
        $value = $d.value;
    }
   ;

method returns [AST.method value]
    /*x(): Int {..}*/
    : n=OBJECTID LPAREN RPAREN COLON rt=TYPEID LBRACE e=expression RBRACE
    {
        $value = new AST.method($n.getText(), $rt.getText(), new ArrayList<AST.formal>(), $e.value, $n.getLine());
    }

    /*x(a, b ..): Int {..}*/
    |n=OBJECTID LPAREN fl=formalList RPAREN COLON rt=TYPEID LBRACE e=expression RBRACE
    {
        $value = new AST.method($n.getText(), $rt.getText(), $fl.value, $e.value, $n.getLine());
    }
    ;

attribute returns [AST.attribute value]
    //x: Int
    //x: Int <- expr
    :{Boolean flag = false;}
    n=OBJECTID COLON t=TYPEID (ASSIGN e=expression{flag = true;})?
    {
        if(flag)    $value = new AST.attribute($n.getText(), $t.getText(), $n.getLine(), $e.value);
        else    $value = new AST.attribute($n.getText(), $t.getText(), $n.getLine());
    }
    ;

formalList returns [ArrayList<AST.formal> value]
    @init
    {
    	$value = new ArrayList<AST.formal>();
    }
    : f=formal {$value.add($f.value);} (COMMA fi=formal {$value.add($fi.value);})*

    ;

formal returns [AST.formal value]
    /*x: Int*/
    : n=OBJECTID COLON t=TYPEID
    {
        $value = new AST.formal($n.getText(), $t.getText());
    }
    ;

/* [expr [[, expr]]* ] */
expression_list returns [ArrayList<AST.Expression> value]
	@init
	{
		$value = new ArrayList<AST.Expression>();
	}
	:
		( expr = expression {$value.add($expr.value);} (COMMA expr = expression {$value.add($expr.value);})* )?
	;

/* method argument */
expression returns [AST.Expression value]

   :
   IF e1=expression THEN e2=expression ELSE e3=expression FI
    {
        $value = new AST.If($e1.value, $e2.value, $e3.value);
    }
    # if

    | WHILE e1=expression LOOP e2=expression POOL
    {
        $value = new AST.While($e1.value, $e2.value);
    }
    # while

    | LBRACE
    {ArrayList<AST.Expression> a = new ArrayList<AST.Expression>();}
    (e=expression SEMICOLON {a.add($e.value);}) + RBRACE
    {
        $value = new AST.BlockOfExpr(a);
    }
    # block

    |
    {
        ArrayList<AST.Expression> exprs = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<Boolean> flags = new ArrayList<>();
        Boolean flag;
        AST.Expression expr;
    }
    LET i1=OBJECTID {flag = false; expr = new AST.Expression(); ids.add($i1.getText());} COLON TYPEID
    (ASSIGN e1=expression {flag = true; expr = $e1.value;})? {flags.add(flag); exprs.add(expr);}
    (COMMA i=OBJECTID {flag = false; expr = new AST.Expression(); ids.add($i.getText());} COLON TYPEID
    (ASSIGN e=expression {flag = true; expr = $e.value;})? {flags.add(flag); exprs.add(expr);})* IN e2=expression
    {
        $value = new AST.Let(flags, ids, exprs, $e2.value);
    }
    # letIn

    /*| CASE expression OF (OBJECTID COLON TYPEID CASE_ARROW expression SEMICOLON) + ESAC # case*/
    | NEW i=TYPEID
    {
        $value = new AST.NewType($i.getText());
    }
    # new
    | op=MINUS e=expression
    {
        $value = new AST.LogOp($e.value, $op.getText());
    }
    # negative

    | ISVOID e=expression
    {
        $value = new AST.IsVo($e.value);
    }
    # isvoid

    | e1=expression op=STAR e2=expression
    {
        $value = new AST.ArithmeticOp($e1.value, $e2.value, $op.getText());
    }
    # multiply

    | e1=expression op=SLASH e2=expression
    {
        $value = new AST.ArithmeticOp($e1.value, $e2.value, $op.getText());
    }
    # division

    | e1=expression op=PLUS e2=expression
    {
        $value = new AST.ArithmeticOp($e1.value, $e2.value, $op.getText());
    }
    # add

    | e1=expression op=MINUS e2=expression
    {
        $value = new AST.ArithmeticOp($e1.value, $e2.value, $op.getText());
    }
    # minus

    | e1=expression op=LT e2=expression
    {
        $value = new AST.RelOp($e1.value, $e2.value, $op.getText());
    }
    # lessThan

    | e1=expression op=LE e2=expression
    {
        $value = new AST.RelOp($e1.value, $e2.value, $op.getText());
    }
    # lessEqual

    | e1=expression op=EQUALS e2=expression
    {
        $value = new AST.RelOp($e1.value, $e2.value, $op.getText());
    }
    # equal

    | op=NOT e=expression
    {
        $value = new AST.LogOp($e.value, $op.getText());
    }
    # boolNot

    | LPAREN e=expression RPAREN
    {
        $value = new AST.Parentheses($e.value);
    }
    # parentheses

    | i=OBJECTID
    {
        $value = new AST.ObId($i.getText());
    }
    # id

    | i=INT_CONST
    {
        $value = new AST.IntConst(Integer.parseInt($i.getText()));
    }

    # int

    | st=STRING
    {
        $value = new AST.Str($st.getText());
    }
    # string

    | bo=BOOL_CONST
    {
        $value = new AST.Bool($bo.getText().toUpperCase());
    }
    # TrueOrFlase

    | i=OBJECTID ASSIGN e=expression
    {
        $value = new AST.Assign($i.getText(), $e.value);
    }
    # assignment
    |
    expr=expression DOT id=OBJECTID LPAREN expr_list = expression_list RPAREN
     	{
     		$value = new AST.dispatch($expr.value, $id.getText(), $expr_list.value, $expr.value.lineNo);
     	}
     	#concat
     /*ID ( [expr [[, expr]]* ]) */
     | id=OBJECTID LPAREN expr_list = expression_list RPAREN
        	{
        		$value = new AST.dispatch(new AST.ObId("self"), $id.getText() , $expr_list.value , $id.getLine());
        	}
       # methodCall
    ;