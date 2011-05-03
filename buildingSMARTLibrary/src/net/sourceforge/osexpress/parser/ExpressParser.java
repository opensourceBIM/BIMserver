// $ANTLR : "express.g" -> "ExpressParser.java"$
 
  package net.sourceforge.osexpress.parser;

  import java.util.Hashtable;

import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.NoViableAltException;
import antlr.ParserSharedInputState;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenBuffer;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.AST;
import antlr.collections.impl.ASTArray;
import antlr.collections.impl.BitSet;

/**
 *  The Express grammar written as ANTLR productions.
 *  Peter Denno, pdenno@nist.gov
 *  Stephane Lardet, stephane.lardet@nist.gov
 *
 *   Development of this software was funded by the United States Government,
 *   and is not subject to copyright.
 *
 *   DISCLAIMER: Recipients of this software assume all responsibility
 *   associated with its operation, modification, maintenance, and subsequent
 *   re-distribution.
 */
@SuppressWarnings("all")
public class ExpressParser extends antlr.LLkParser       implements ExpressParserTokenTypes
 {

	public  Scope rootScope;
	public  Scope currentScope;
	private Scope lastCreatedScope;

	/* We keep track of scopes defined by schemas. It is useful when
	multiple schemas are parsed, to deal with external elements */
	private Hashtable schemas;

	public boolean isFirst=true; /* is the first pass running ? */

	public void newScope() {
		if (isFirst) newScope1();
		else newScope2();
	}

	public void newScope1() {
                /* creates a new Scope when entering a rule defining
                a scope in the grammar. */
                Scope ns;

                ns = new Scope(currentScope);
                currentScope=ns;
                lastCreatedScope.setNext(ns);
                lastCreatedScope=ns;
        }


	public void newScope2() {
		/* retrieve the scope created in the first pass when
		entering the same rule. 
		See comments in the lexer's IDENT rule definition */

		currentScope=lastCreatedScope.next;
		lastCreatedScope=currentScope;
	}

	public void upScope() {
		/* when exiting a scope */
		currentScope=currentScope.parent;
	}
	
	private void newSchemaScope(String id) {
		/* we record schema scopes so as to retrieve external
		elements when parsing multiple schemas */
		newScope();
		if (isFirst) schemas.put(id,currentScope);
	}

	private void newEntityScope(String id) {
                /* entity case: additional information is recorded to build
                the entity inheritance tree */
                newScope();
		if (isFirst) {
                	currentScope.setEntity();
                	currentScope.parent.addEntityScope(id,currentScope);
		}
        }

        private void addId(String id, int type) {
                /* record an id in the current scope */
                currentScope.addId(id,type);
        }

        private void addSuper(String name) {
                /* add superentity in the current entity scope */
                currentScope.addSuperEntity(name);
        }

	public void setRootScope(Scope rs) {
		rootScope=rs;
		currentScope=rootScope;
		lastCreatedScope=rootScope;
		isFirst=false;
	}

	public void addExternal(ExternalId ei) {
		/* add an element referenced or used from another schema */
		currentScope.addExternal(ei);
	}

	public void addAllReferenceExternals(String schema) {
		/* when all elements of another schema are referenced */
		currentScope.addAllReferenceExternals(schema);
	}

	public void addAllUseExternals(String schema) {
		/* when all elements of another schema are used */
		currentScope.addAllUseExternals(schema);
	}

	public void processExternals() {
	/* after the first pass, adds external ids to schema scopes */
		int i,sz;
		Object[] sa;

		sa=schemas.values().toArray();
		sz=sa.length;
		for (i=0;i<sz;i++) {
			((Scope)sa[i]).processExternals(schemas);
		}
	}

protected ExpressParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExpressParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected ExpressParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExpressParser(TokenStream lexer) {
  this(lexer,1);
}

public ExpressParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void actual_parameter_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST actual_parameter_list_AST = null;
		
		try {      // for error handling
			match(LPAREN);
			parameter();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35506:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					parameter();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35506;
				}
				
			} while (true);
			}
			match(RPAREN);
			actual_parameter_list_AST = (AST)currentAST.root;
			actual_parameter_list_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ACTUAL_PARAMETER_LIST,"ACTUAL_PARAMETER_LIST")).add(actual_parameter_list_AST));
			currentAST.root = actual_parameter_list_AST;
			currentAST.child = actual_parameter_list_AST!=null &&actual_parameter_list_AST.getFirstChild()!=null ?
				actual_parameter_list_AST.getFirstChild() : actual_parameter_list_AST;
			currentAST.advanceChildToEnd();
			actual_parameter_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = actual_parameter_list_AST;
	}
	
	public final void parameter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_AST = null;
		
		try {      // for error handling
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			parameter_AST = (AST)currentAST.root;
			parameter_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER,"PARAMETER")).add(parameter_AST));
			currentAST.root = parameter_AST;
			currentAST.child = parameter_AST!=null &&parameter_AST.getFirstChild()!=null ?
				parameter_AST.getFirstChild() : parameter_AST;
			currentAST.advanceChildToEnd();
			parameter_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = parameter_AST;
	}
	
	public final void add_like_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST add_like_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case PLUS:
			{
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(PLUS);
				add_like_op_AST = (AST)currentAST.root;
				add_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ADD_LIKE_OP,"ADD_LIKE_OP")).add(add_like_op_AST));
				currentAST.root = add_like_op_AST;
				currentAST.child = add_like_op_AST!=null &&add_like_op_AST.getFirstChild()!=null ?
					add_like_op_AST.getFirstChild() : add_like_op_AST;
				currentAST.advanceChildToEnd();
				add_like_op_AST = (AST)currentAST.root;
				break;
			}
			case MINUS:
			{
				AST tmp5_AST = null;
				tmp5_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp5_AST);
				match(MINUS);
				add_like_op_AST = (AST)currentAST.root;
				add_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ADD_LIKE_OP,"ADD_LIKE_OP")).add(add_like_op_AST));
				currentAST.root = add_like_op_AST;
				currentAST.child = add_like_op_AST!=null &&add_like_op_AST.getFirstChild()!=null ?
					add_like_op_AST.getFirstChild() : add_like_op_AST;
				currentAST.advanceChildToEnd();
				add_like_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_or:
			{
				AST tmp6_AST = null;
				tmp6_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp6_AST);
				match(LITERAL_or);
				add_like_op_AST = (AST)currentAST.root;
				add_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ADD_LIKE_OP,"ADD_LIKE_OP")).add(add_like_op_AST));
				currentAST.root = add_like_op_AST;
				currentAST.child = add_like_op_AST!=null &&add_like_op_AST.getFirstChild()!=null ?
					add_like_op_AST.getFirstChild() : add_like_op_AST;
				currentAST.advanceChildToEnd();
				add_like_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_xor:
			{
				AST tmp7_AST = null;
				tmp7_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp7_AST);
				match(LITERAL_xor);
				add_like_op_AST = (AST)currentAST.root;
				add_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ADD_LIKE_OP,"ADD_LIKE_OP")).add(add_like_op_AST));
				currentAST.root = add_like_op_AST;
				currentAST.child = add_like_op_AST!=null &&add_like_op_AST.getFirstChild()!=null ?
					add_like_op_AST.getFirstChild() : add_like_op_AST;
				currentAST.advanceChildToEnd();
				add_like_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = add_like_op_AST;
	}
	
	public final void aggregate_initializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_initializer_AST = null;
		
		try {      // for error handling
			match(LBRACK);
			{
			switch ( LA(1)) {
			case CONSTANT_IDENT:
			case ENTITY_IDENT:
			case FUNCTION_IDENT:
			case PARAMETER_IDENT:
			case TYPE_IDENT:
			case VARIABLE_IDENT:
			case ENUMERATION_IDENT:
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LPAREN:
			case PLUS:
			case MINUS:
			case LBRACK:
			case IDENT:
			case LITERAL_const_e:
			case LITERAL_pi:
			case LITERAL_self:
			case QUESTION:
			case STAR:
			case LITERAL_abs:
			case LITERAL_acos:
			case LITERAL_asin:
			case LITERAL_atan:
			case LITERAL_blength:
			case LITERAL_cos:
			case LITERAL_exists:
			case LITERAL_exp:
			case LITERAL_format:
			case LITERAL_hibound:
			case LITERAL_hiindex:
			case LITERAL_length:
			case LITERAL_lobound:
			case LITERAL_loindex:
			case LITERAL_log:
			case 256:
			case 257:
			case LITERAL_nvl:
			case LITERAL_odd:
			case LITERAL_rolesof:
			case LITERAL_sin:
			case LITERAL_sizeof:
			case LITERAL_sqrt:
			case LITERAL_tan:
			case LITERAL_typeof:
			case LITERAL_usedin:
			case LITERAL_value:
			case LITERAL_value_in:
			case LITERAL_value_unique:
			case LCURLY:
			case INT:
			case STRING:
			case LITERAL_false:
			case LITERAL_true:
			case LITERAL_unknown:
			case LITERAL_query:
			case LITERAL_not:
			{
				element();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35511:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						element();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35511;
					}
					
				} while (true);
				}
				break;
			}
			case RBRACK:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RBRACK);
			aggregate_initializer_AST = (AST)currentAST.root;
			aggregate_initializer_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATE_INITIALIZER,"AGGREGATE_INITIALIZER")).add(aggregate_initializer_AST));
			currentAST.root = aggregate_initializer_AST;
			currentAST.child = aggregate_initializer_AST!=null &&aggregate_initializer_AST.getFirstChild()!=null ?
				aggregate_initializer_AST.getFirstChild() : aggregate_initializer_AST;
			currentAST.advanceChildToEnd();
			aggregate_initializer_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = aggregate_initializer_AST;
	}
	
	public final void element() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST element_AST = null;
		
		try {      // for error handling
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				repetition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COMMA:
			case RBRACK:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			element_AST = (AST)currentAST.root;
			element_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELEMENT,"ELEMENT")).add(element_AST));
			currentAST.root = element_AST;
			currentAST.child = element_AST!=null &&element_AST.getFirstChild()!=null ?
				element_AST.getFirstChild() : element_AST;
			currentAST.advanceChildToEnd();
			element_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = element_AST;
	}
	
	public final void aggregate_source() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_source_AST = null;
		
		try {      // for error handling
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_source_AST = (AST)currentAST.root;
			aggregate_source_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATE_SOURCE,"AGGREGATE_SOURCE")).add(aggregate_source_AST));
			currentAST.root = aggregate_source_AST;
			currentAST.child = aggregate_source_AST!=null &&aggregate_source_AST.getFirstChild()!=null ?
				aggregate_source_AST.getFirstChild() : aggregate_source_AST;
			currentAST.advanceChildToEnd();
			aggregate_source_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = aggregate_source_AST;
	}
	
	public final void simple_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_expression_AST = null;
		
		try {      // for error handling
			term();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35828:
			do {
				if (((LA(1) >= PLUS && LA(1) <= LITERAL_xor))) {
					add_like_op();
					astFactory.addASTChild(currentAST, returnAST);
					term();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35828;
				}
				
			} while (true);
			}
			simple_expression_AST = (AST)currentAST.root;
			simple_expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_EXPRESSION,"SIMPLE_EXPRESSION")).add(simple_expression_AST));
			currentAST.root = simple_expression_AST;
			currentAST.child = simple_expression_AST!=null &&simple_expression_AST.getFirstChild()!=null ?
				simple_expression_AST.getFirstChild() : simple_expression_AST;
			currentAST.advanceChildToEnd();
			simple_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
		returnAST = simple_expression_AST;
	}
	
	public final void aggregate_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_aggregate);
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				type_label();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_type_AST = (AST)currentAST.root;
			aggregate_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATE_TYPE,"AGGREGATE_TYPE")).add(aggregate_type_AST));
			currentAST.root = aggregate_type_AST;
			currentAST.child = aggregate_type_AST!=null &&aggregate_type_AST.getFirstChild()!=null ?
				aggregate_type_AST.getFirstChild() : aggregate_type_AST;
			currentAST.advanceChildToEnd();
			aggregate_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = aggregate_type_AST;
	}
	
	public final void type_label() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_AST = null;
		
		try {      // for error handling
			AST tmp15_AST = null;
			tmp15_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp15_AST);
			match(IDENT);
			type_label_AST = (AST)currentAST.root;
			type_label_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_LABEL,"TYPE_LABEL")).add(type_label_AST));
			currentAST.root = type_label_AST;
			currentAST.child = type_label_AST!=null &&type_label_AST.getFirstChild()!=null ?
				type_label_AST.getFirstChild() : type_label_AST;
			currentAST.advanceChildToEnd();
			type_label_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		returnAST = type_label_AST;
	}
	
	public final void parameter_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_type_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_aggregate:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			{
				generalized_types();
				astFactory.addASTChild(currentAST, returnAST);
				parameter_type_AST = (AST)currentAST.root;
				parameter_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_TYPE,"PARAMETER_TYPE")).add(parameter_type_AST));
				currentAST.root = parameter_type_AST;
				currentAST.child = parameter_type_AST!=null &&parameter_type_AST.getFirstChild()!=null ?
					parameter_type_AST.getFirstChild() : parameter_type_AST;
				currentAST.advanceChildToEnd();
				parameter_type_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case IDENT:
			{
				named_types();
				astFactory.addASTChild(currentAST, returnAST);
				parameter_type_AST = (AST)currentAST.root;
				parameter_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_TYPE,"PARAMETER_TYPE")).add(parameter_type_AST));
				currentAST.root = parameter_type_AST;
				currentAST.child = parameter_type_AST!=null &&parameter_type_AST.getFirstChild()!=null ?
					parameter_type_AST.getFirstChild() : parameter_type_AST;
				currentAST.advanceChildToEnd();
				parameter_type_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				simple_types();
				astFactory.addASTChild(currentAST, returnAST);
				parameter_type_AST = (AST)currentAST.root;
				parameter_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_TYPE,"PARAMETER_TYPE")).add(parameter_type_AST));
				currentAST.root = parameter_type_AST;
				currentAST.child = parameter_type_AST!=null &&parameter_type_AST.getFirstChild()!=null ?
					parameter_type_AST.getFirstChild() : parameter_type_AST;
				currentAST.advanceChildToEnd();
				parameter_type_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = parameter_type_AST;
	}
	
	public final void aggregation_types() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregation_types_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_array:
			{
				array_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = (AST)currentAST.root;
				aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATION_TYPES,"AGGREGATION_TYPES")).add(aggregation_types_AST));
				currentAST.root = aggregation_types_AST;
				currentAST.child = aggregation_types_AST!=null &&aggregation_types_AST.getFirstChild()!=null ?
					aggregation_types_AST.getFirstChild() : aggregation_types_AST;
				currentAST.advanceChildToEnd();
				aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_bag:
			{
				bag_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = (AST)currentAST.root;
				aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATION_TYPES,"AGGREGATION_TYPES")).add(aggregation_types_AST));
				currentAST.root = aggregation_types_AST;
				currentAST.child = aggregation_types_AST!=null &&aggregation_types_AST.getFirstChild()!=null ?
					aggregation_types_AST.getFirstChild() : aggregation_types_AST;
				currentAST.advanceChildToEnd();
				aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_list:
			{
				list_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = (AST)currentAST.root;
				aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATION_TYPES,"AGGREGATION_TYPES")).add(aggregation_types_AST));
				currentAST.root = aggregation_types_AST;
				currentAST.child = aggregation_types_AST!=null &&aggregation_types_AST.getFirstChild()!=null ?
					aggregation_types_AST.getFirstChild() : aggregation_types_AST;
				currentAST.advanceChildToEnd();
				aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_set:
			{
				set_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = (AST)currentAST.root;
				aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATION_TYPES,"AGGREGATION_TYPES")).add(aggregation_types_AST));
				currentAST.root = aggregation_types_AST;
				currentAST.child = aggregation_types_AST!=null &&aggregation_types_AST.getFirstChild()!=null ?
					aggregation_types_AST.getFirstChild() : aggregation_types_AST;
				currentAST.advanceChildToEnd();
				aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = aggregation_types_AST;
	}
	
	public final void array_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST array_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_array);
			bound_spec();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_of);
			{
			switch ( LA(1)) {
			case LITERAL_optional:
			{
				match(LITERAL_optional);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_unique:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_unique:
			{
				match(LITERAL_unique);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			array_type_AST = (AST)currentAST.root;
			array_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY_TYPE,"ARRAY_TYPE")).add(array_type_AST));
			currentAST.root = array_type_AST;
			currentAST.child = array_type_AST!=null &&array_type_AST.getFirstChild()!=null ?
				array_type_AST.getFirstChild() : array_type_AST;
			currentAST.advanceChildToEnd();
			array_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = array_type_AST;
	}
	
	public final void bag_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bag_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_bag);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			bag_type_AST = (AST)currentAST.root;
			bag_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BAG_TYPE,"BAG_TYPE")).add(bag_type_AST));
			currentAST.root = bag_type_AST;
			currentAST.child = bag_type_AST!=null &&bag_type_AST.getFirstChild()!=null ?
				bag_type_AST.getFirstChild() : bag_type_AST;
			currentAST.advanceChildToEnd();
			bag_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = bag_type_AST;
	}
	
	public final void list_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST list_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_list);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			{
			switch ( LA(1)) {
			case LITERAL_unique:
			{
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(LITERAL_unique);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			list_type_AST = (AST)currentAST.root;
			list_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LIST_TYPE,"LIST_TYPE")).add(list_type_AST));
			currentAST.root = list_type_AST;
			currentAST.child = list_type_AST!=null &&list_type_AST.getFirstChild()!=null ?
				list_type_AST.getFirstChild() : list_type_AST;
			currentAST.advanceChildToEnd();
			list_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = list_type_AST;
	}
	
	public final void set_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST set_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_set);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			set_type_AST = (AST)currentAST.root;
			set_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SET_TYPE,"SET_TYPE")).add(set_type_AST));
			currentAST.root = set_type_AST;
			currentAST.child = set_type_AST!=null &&set_type_AST.getFirstChild()!=null ?
				set_type_AST.getFirstChild() : set_type_AST;
			currentAST.advanceChildToEnd();
			set_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = set_type_AST;
	}
	
	public final void algorithm_head() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST algorithm_head_AST = null;
		
		try {      // for error handling
			{
			_loop35518:
			do {
				if ((_tokenSet_10.member(LA(1)))) {
					declaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35518;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_constant:
			{
				constant_decl();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case PROCEDURE_IDENT:
			case PARAMETER_IDENT:
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_alias:
			case IDENT:
			case SEMI:
			case LITERAL_insert:
			case LITERAL_remove:
			case LITERAL_case:
			case LITERAL_begin:
			case LITERAL_escape:
			case LITERAL_if:
			case LITERAL_local:
			case LITERAL_end_procedure:
			case LITERAL_repeat:
			case LITERAL_return:
			case LITERAL_skip:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_local:
			{
				local_decl();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case PROCEDURE_IDENT:
			case PARAMETER_IDENT:
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_alias:
			case IDENT:
			case SEMI:
			case LITERAL_insert:
			case LITERAL_remove:
			case LITERAL_case:
			case LITERAL_begin:
			case LITERAL_escape:
			case LITERAL_if:
			case LITERAL_end_procedure:
			case LITERAL_repeat:
			case LITERAL_return:
			case LITERAL_skip:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			algorithm_head_AST = (AST)currentAST.root;
			algorithm_head_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ALGORITHM_HEAD,"ALGORITHM_HEAD")).add(algorithm_head_AST));
			currentAST.root = algorithm_head_AST;
			currentAST.child = algorithm_head_AST!=null &&algorithm_head_AST.getFirstChild()!=null ?
				algorithm_head_AST.getFirstChild() : algorithm_head_AST;
			currentAST.advanceChildToEnd();
			algorithm_head_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = algorithm_head_AST;
	}
	
	public final void declaration() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaration_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_entity:
			{
				entity_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = (AST)currentAST.root;
				declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DECLARATION,"DECLARATION")).add(declaration_AST));
				currentAST.root = declaration_AST;
				currentAST.child = declaration_AST!=null &&declaration_AST.getFirstChild()!=null ?
					declaration_AST.getFirstChild() : declaration_AST;
				currentAST.advanceChildToEnd();
				declaration_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_subtype_constraint:
			{
				subtype_constraint_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = (AST)currentAST.root;
				declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DECLARATION,"DECLARATION")).add(declaration_AST));
				currentAST.root = declaration_AST;
				currentAST.child = declaration_AST!=null &&declaration_AST.getFirstChild()!=null ?
					declaration_AST.getFirstChild() : declaration_AST;
				currentAST.advanceChildToEnd();
				declaration_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_function:
			{
				function_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = (AST)currentAST.root;
				declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DECLARATION,"DECLARATION")).add(declaration_AST));
				currentAST.root = declaration_AST;
				currentAST.child = declaration_AST!=null &&declaration_AST.getFirstChild()!=null ?
					declaration_AST.getFirstChild() : declaration_AST;
				currentAST.advanceChildToEnd();
				declaration_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_procedure:
			{
				procedure_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = (AST)currentAST.root;
				declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DECLARATION,"DECLARATION")).add(declaration_AST));
				currentAST.root = declaration_AST;
				currentAST.child = declaration_AST!=null &&declaration_AST.getFirstChild()!=null ?
					declaration_AST.getFirstChild() : declaration_AST;
				currentAST.advanceChildToEnd();
				declaration_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_type:
			{
				type_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = (AST)currentAST.root;
				declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DECLARATION,"DECLARATION")).add(declaration_AST));
				currentAST.root = declaration_AST;
				currentAST.child = declaration_AST!=null &&declaration_AST.getFirstChild()!=null ?
					declaration_AST.getFirstChild() : declaration_AST;
				currentAST.advanceChildToEnd();
				declaration_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = declaration_AST;
	}
	
	public final void constant_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_decl_AST = null;
		
		try {      // for error handling
			match(LITERAL_constant);
			constant_body();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35564:
			do {
				if ((LA(1)==CONSTANT_IDENT||LA(1)==IDENT)) {
					constant_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35564;
				}
				
			} while (true);
			}
			match(LITERAL_end_constant);
			match(SEMI);
			constant_decl_AST = (AST)currentAST.root;
			constant_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_DECL,"CONSTANT_DECL")).add(constant_decl_AST));
			currentAST.root = constant_decl_AST;
			currentAST.child = constant_decl_AST!=null &&constant_decl_AST.getFirstChild()!=null ?
				constant_decl_AST.getFirstChild() : constant_decl_AST;
			currentAST.advanceChildToEnd();
			constant_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_13);
		}
		returnAST = constant_decl_AST;
	}
	
	public final void local_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST local_decl_AST = null;
		
		try {      // for error handling
			match(LITERAL_local);
			local_variable();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35721:
			do {
				if ((_tokenSet_14.member(LA(1)))) {
					local_variable();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35721;
				}
				
			} while (true);
			}
			match(LITERAL_end_local);
			match(SEMI);
			local_decl_AST = (AST)currentAST.root;
			local_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOCAL_DECL,"LOCAL_DECL")).add(local_decl_AST));
			currentAST.root = local_decl_AST;
			currentAST.child = local_decl_AST!=null &&local_decl_AST.getFirstChild()!=null ?
				local_decl_AST.getFirstChild() : local_decl_AST;
			currentAST.advanceChildToEnd();
			local_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = local_decl_AST;
	}
	
	public final void alias_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_stmt_AST = null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_alias))&&( isFirst )) {
				newScope1();
				AST tmp33_AST = null;
				tmp33_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp33_AST);
				match(LITERAL_alias);
				variable_id();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp34_AST);
				match(LITERAL_for);
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(IDENT);
				{
				_loop35523:
				do {
					if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
						qualifier();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35523;
					}
					
				} while (true);
				}
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp36_AST);
				match(SEMI);
				stmt();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35525:
				do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35525;
					}
					
				} while (true);
				}
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp37_AST);
				match(LITERAL_end_alias);
				upScope();
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(SEMI);
				alias_stmt_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_alias)) {
				match(LITERAL_alias);
				variable_id();
				astFactory.addASTChild(currentAST, returnAST);
				match(LITERAL_for);
				general_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35527:
				do {
					if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
						qualifier();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35527;
					}
					
				} while (true);
				}
				match(SEMI);
				stmt();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35529:
				do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35529;
					}
					
				} while (true);
				}
				match(LITERAL_end_alias);
				upScope();
				match(SEMI);
				alias_stmt_AST = (AST)currentAST.root;
				alias_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ALIAS_STMT,"ALIAS_STMT")).add(alias_stmt_AST));
				currentAST.root = alias_stmt_AST;
				currentAST.child = alias_stmt_AST!=null &&alias_stmt_AST.getFirstChild()!=null ?
					alias_stmt_AST.getFirstChild() : alias_stmt_AST;
				currentAST.advanceChildToEnd();
				alias_stmt_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = alias_stmt_AST;
	}
	
	public final void variable_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case VARIABLE_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(VARIABLE_IDENT);
				variable_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); variable_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_ID,"VARIABLE_ID")).add(variable_id_AST));
				currentAST.root = variable_id_AST;
				currentAST.child = variable_id_AST!=null &&variable_id_AST.getFirstChild()!=null ?
					variable_id_AST.getFirstChild() : variable_id_AST;
				currentAST.advanceChildToEnd();
				variable_id_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_VAR_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_VAR_IDENT);
				variable_id_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); variable_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_ID,"VARIABLE_ID")).add(variable_id_AST));
				currentAST.root = variable_id_AST;
				currentAST.child = variable_id_AST!=null &&variable_id_AST.getFirstChild()!=null ?
					variable_id_AST.getFirstChild() : variable_id_AST;
				currentAST.advanceChildToEnd();
				variable_id_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_VAR_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_VAR_IDENT);
				variable_id_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); variable_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_ID,"VARIABLE_ID")).add(variable_id_AST));
				currentAST.root = variable_id_AST;
				currentAST.child = variable_id_AST!=null &&variable_id_AST.getFirstChild()!=null ?
					variable_id_AST.getFirstChild() : variable_id_AST;
				currentAST.advanceChildToEnd();
				variable_id_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(IDENT);
					addId(id.getText(),VARIABLE_IDENT);
					variable_id_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_17);
		}
		returnAST = variable_id_AST;
	}
	
	public final void qualifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifier_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case DOT:
			{
				attribute_qualifier();
				astFactory.addASTChild(currentAST, returnAST);
				qualifier_AST = (AST)currentAST.root;
				qualifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIER,"QUALIFIER")).add(qualifier_AST));
				currentAST.root = qualifier_AST;
				currentAST.child = qualifier_AST!=null &&qualifier_AST.getFirstChild()!=null ?
					qualifier_AST.getFirstChild() : qualifier_AST;
				currentAST.advanceChildToEnd();
				qualifier_AST = (AST)currentAST.root;
				break;
			}
			case BACKSLASH:
			{
				group_qualifier();
				astFactory.addASTChild(currentAST, returnAST);
				qualifier_AST = (AST)currentAST.root;
				qualifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIER,"QUALIFIER")).add(qualifier_AST));
				currentAST.root = qualifier_AST;
				currentAST.child = qualifier_AST!=null &&qualifier_AST.getFirstChild()!=null ?
					qualifier_AST.getFirstChild() : qualifier_AST;
				currentAST.advanceChildToEnd();
				qualifier_AST = (AST)currentAST.root;
				break;
			}
			case LBRACK:
			{
				index_qualifier();
				astFactory.addASTChild(currentAST, returnAST);
				qualifier_AST = (AST)currentAST.root;
				qualifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIER,"QUALIFIER")).add(qualifier_AST));
				currentAST.root = qualifier_AST;
				currentAST.child = qualifier_AST!=null &&qualifier_AST.getFirstChild()!=null ?
					qualifier_AST.getFirstChild() : qualifier_AST;
				currentAST.advanceChildToEnd();
				qualifier_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = qualifier_AST;
	}
	
	public final void stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stmt_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_alias:
			{
				alias_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case PARAMETER_IDENT:
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			{
				assignment_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_case:
			{
				case_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_begin:
			{
				compound_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_escape:
			{
				escape_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_if:
			{
				if_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case SEMI:
			{
				null_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case PROCEDURE_IDENT:
			case LITERAL_insert:
			case LITERAL_remove:
			{
				procedure_call_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_repeat:
			{
				repeat_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_return:
			{
				return_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_skip:
			{
				skip_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = (AST)currentAST.root;
				stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STMT,"STMT")).add(stmt_AST));
				currentAST.root = stmt_AST;
				currentAST.child = stmt_AST!=null &&stmt_AST.getFirstChild()!=null ?
					stmt_AST.getFirstChild() : stmt_AST;
				currentAST.advanceChildToEnd();
				stmt_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					AST tmp44_AST = null;
					tmp44_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp44_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case LBRACK:
					case COLEQ:
					case DOT:
					case BACKSLASH:
					{
						{
						_loop35851:
						do {
							if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
								qualifier();
								astFactory.addASTChild(currentAST, returnAST);
							}
							else {
								break _loop35851;
							}
							
						} while (true);
						}
						AST tmp45_AST = null;
						tmp45_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp45_AST);
						match(COLEQ);
						expression();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LPAREN:
					case SEMI:
					{
						{
						switch ( LA(1)) {
						case LPAREN:
						{
							actual_parameter_list();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case SEMI:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					AST tmp46_AST = null;
					tmp46_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp46_AST);
					match(SEMI);
					stmt_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = stmt_AST;
	}
	
	public final void general_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_ref_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case PARAMETER_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			{
				parameter_ref();
				astFactory.addASTChild(currentAST, returnAST);
				general_ref_AST = (AST)currentAST.root;
				general_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_REF,"GENERAL_REF")).add(general_ref_AST));
				currentAST.root = general_ref_AST;
				currentAST.child = general_ref_AST!=null &&general_ref_AST.getFirstChild()!=null ?
					general_ref_AST.getFirstChild() : general_ref_AST;
				currentAST.advanceChildToEnd();
				general_ref_AST = (AST)currentAST.root;
				break;
			}
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			{
				variable_ref();
				astFactory.addASTChild(currentAST, returnAST);
				general_ref_AST = (AST)currentAST.root;
				general_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_REF,"GENERAL_REF")).add(general_ref_AST));
				currentAST.root = general_ref_AST;
				currentAST.child = general_ref_AST!=null &&general_ref_AST.getFirstChild()!=null ?
					general_ref_AST.getFirstChild() : general_ref_AST;
				currentAST.advanceChildToEnd();
				general_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = general_ref_AST;
	}
	
	public final void bound_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_spec_AST = null;
		
		try {      // for error handling
			match(LBRACK);
			bound_1();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLON);
			bound_2();
			astFactory.addASTChild(currentAST, returnAST);
			match(RBRACK);
			bound_spec_AST = (AST)currentAST.root;
			bound_spec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BOUND_SPEC,"BOUND_SPEC")).add(bound_spec_AST));
			currentAST.root = bound_spec_AST;
			currentAST.child = bound_spec_AST!=null &&bound_spec_AST.getFirstChild()!=null ?
				bound_spec_AST.getFirstChild() : bound_spec_AST;
			currentAST.advanceChildToEnd();
			bound_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_19);
		}
		returnAST = bound_spec_AST;
	}
	
	public final void base_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST base_type_AST = null;
		
		try {      // for error handling
			if ((_tokenSet_20.member(LA(1)))) {
				concrete_types();
				astFactory.addASTChild(currentAST, returnAST);
				base_type_AST = (AST)currentAST.root;
				base_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BASE_TYPE,"BASE_TYPE")).add(base_type_AST));
				currentAST.root = base_type_AST;
				currentAST.child = base_type_AST!=null &&base_type_AST.getFirstChild()!=null ?
					base_type_AST.getFirstChild() : base_type_AST;
				currentAST.advanceChildToEnd();
				base_type_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_21.member(LA(1)))) {
				generalized_types();
				astFactory.addASTChild(currentAST, returnAST);
				base_type_AST = (AST)currentAST.root;
				base_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BASE_TYPE,"BASE_TYPE")).add(base_type_AST));
				currentAST.root = base_type_AST;
				currentAST.child = base_type_AST!=null &&base_type_AST.getFirstChild()!=null ?
					base_type_AST.getFirstChild() : base_type_AST;
				currentAST.advanceChildToEnd();
				base_type_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = base_type_AST;
	}
	
	public final void assignment_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignment_stmt_AST = null;
		
		try {      // for error handling
			{
			general_ref();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35536:
			do {
				if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
					qualifier();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35536;
				}
				
			} while (true);
			}
			}
			match(COLEQ);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			assignment_stmt_AST = (AST)currentAST.root;
			assignment_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ASSIGNMENT_STMT,"ASSIGNMENT_STMT")).add(assignment_stmt_AST));
			currentAST.root = assignment_stmt_AST;
			currentAST.child = assignment_stmt_AST!=null &&assignment_stmt_AST.getFirstChild()!=null ?
				assignment_stmt_AST.getFirstChild() : assignment_stmt_AST;
			currentAST.advanceChildToEnd();
			assignment_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = assignment_stmt_AST;
	}
	
	public final void expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;
		
		try {      // for error handling
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LT:
			case LE:
			case GT:
			case GE:
			case LTGT:
			case ASSIGN:
			case COLLTGT:
			case COLEQCOL:
			case LITERAL_in:
			case LITERAL_like:
			{
				rel_op_extended();
				astFactory.addASTChild(currentAST, returnAST);
				simple_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COMMA:
			case RPAREN:
			case RBRACK:
			case COLON:
			case LITERAL_of:
			case SEMI:
			case LITERAL_then:
			case LITERAL_until:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expression_AST = (AST)currentAST.root;
			expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXPRESSION,"EXPRESSION")).add(expression_AST));
			currentAST.root = expression_AST;
			currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
				expression_AST.getFirstChild() : expression_AST;
			currentAST.advanceChildToEnd();
			expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_22);
		}
		returnAST = expression_AST;
	}
	
	public final void concrete_types() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST concrete_types_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list:
			{
				aggregation_types();
				astFactory.addASTChild(currentAST, returnAST);
				concrete_types_AST = (AST)currentAST.root;
				concrete_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONCRETE_TYPES,"CONCRETE_TYPES")).add(concrete_types_AST));
				currentAST.root = concrete_types_AST;
				currentAST.child = concrete_types_AST!=null &&concrete_types_AST.getFirstChild()!=null ?
					concrete_types_AST.getFirstChild() : concrete_types_AST;
				currentAST.advanceChildToEnd();
				concrete_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				simple_types();
				astFactory.addASTChild(currentAST, returnAST);
				concrete_types_AST = (AST)currentAST.root;
				concrete_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONCRETE_TYPES,"CONCRETE_TYPES")).add(concrete_types_AST));
				currentAST.root = concrete_types_AST;
				currentAST.child = concrete_types_AST!=null &&concrete_types_AST.getFirstChild()!=null ?
					concrete_types_AST.getFirstChild() : concrete_types_AST;
				currentAST.advanceChildToEnd();
				concrete_types_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case IDENT:
			{
				named_types();
				astFactory.addASTChild(currentAST, returnAST);
				concrete_types_AST = (AST)currentAST.root;
				concrete_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONCRETE_TYPES,"CONCRETE_TYPES")).add(concrete_types_AST));
				currentAST.root = concrete_types_AST;
				currentAST.child = concrete_types_AST!=null &&concrete_types_AST.getFirstChild()!=null ?
					concrete_types_AST.getFirstChild() : concrete_types_AST;
				currentAST.advanceChildToEnd();
				concrete_types_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = concrete_types_AST;
	}
	
	public final void generalized_types() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generalized_types_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_aggregate:
			{
				aggregate_type();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = (AST)currentAST.root;
				generalized_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERALIZED_TYPES,"GENERALIZED_TYPES")).add(generalized_types_AST));
				currentAST.root = generalized_types_AST;
				currentAST.child = generalized_types_AST!=null &&generalized_types_AST.getFirstChild()!=null ?
					generalized_types_AST.getFirstChild() : generalized_types_AST;
				currentAST.advanceChildToEnd();
				generalized_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list:
			{
				general_aggregation_types();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = (AST)currentAST.root;
				generalized_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERALIZED_TYPES,"GENERALIZED_TYPES")).add(generalized_types_AST));
				currentAST.root = generalized_types_AST;
				currentAST.child = generalized_types_AST!=null &&generalized_types_AST.getFirstChild()!=null ?
					generalized_types_AST.getFirstChild() : generalized_types_AST;
				currentAST.advanceChildToEnd();
				generalized_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_generic:
			{
				generic_type();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = (AST)currentAST.root;
				generalized_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERALIZED_TYPES,"GENERALIZED_TYPES")).add(generalized_types_AST));
				currentAST.root = generalized_types_AST;
				currentAST.child = generalized_types_AST!=null &&generalized_types_AST.getFirstChild()!=null ?
					generalized_types_AST.getFirstChild() : generalized_types_AST;
				currentAST.advanceChildToEnd();
				generalized_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_generic_entity:
			{
				generic_entity_type();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = (AST)currentAST.root;
				generalized_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERALIZED_TYPES,"GENERALIZED_TYPES")).add(generalized_types_AST));
				currentAST.root = generalized_types_AST;
				currentAST.child = generalized_types_AST!=null &&generalized_types_AST.getFirstChild()!=null ?
					generalized_types_AST.getFirstChild() : generalized_types_AST;
				currentAST.advanceChildToEnd();
				generalized_types_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = generalized_types_AST;
	}
	
	public final void simple_types() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_types_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_binary:
			{
				binary_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_boolean:
			{
				boolean_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_integer:
			{
				integer_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_logical:
			{
				logical_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_number:
			{
				number_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_real:
			{
				real_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_string:
			{
				string_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = (AST)currentAST.root;
				simple_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_TYPES,"SIMPLE_TYPES")).add(simple_types_AST));
				currentAST.root = simple_types_AST;
				currentAST.child = simple_types_AST!=null &&simple_types_AST.getFirstChild()!=null ?
					simple_types_AST.getFirstChild() : simple_types_AST;
				currentAST.advanceChildToEnd();
				simple_types_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = simple_types_AST;
	}
	
	public final void named_types() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST named_types_AST = null;
		AST er_AST = null;
		AST tr_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			{
				entity_ref();
				er_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				named_types_AST = (AST)currentAST.root;
				named_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(NAMED_TYPES,"NAMED_TYPES")).add(er_AST));
				currentAST.root = named_types_AST;
				currentAST.child = named_types_AST!=null &&named_types_AST.getFirstChild()!=null ?
					named_types_AST.getFirstChild() : named_types_AST;
				currentAST.advanceChildToEnd();
				named_types_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_IDENT:
			case TYPE_ATTR_IDENT:
			case TYPE_VAR_IDENT:
			case TYPE_PARAM_IDENT:
			{
				type_ref();
				tr_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				named_types_AST = (AST)currentAST.root;
				named_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(NAMED_TYPES,"NAMED_TYPES")).add(tr_AST));
				currentAST.root = named_types_AST;
				currentAST.child = named_types_AST!=null &&named_types_AST.getFirstChild()!=null ?
					named_types_AST.getFirstChild() : named_types_AST;
				currentAST.advanceChildToEnd();
				named_types_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					AST tmp52_AST = null;
					tmp52_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp52_AST);
					match(IDENT);
					named_types_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_23);
		}
		returnAST = named_types_AST;
	}
	
	public final void binary_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST binary_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_binary);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				width_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case RPAREN:
			case SEMI:
			case COLEQ:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			binary_type_AST = (AST)currentAST.root;
			binary_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BINARY_TYPE,"BINARY_TYPE")).add(binary_type_AST));
			currentAST.root = binary_type_AST;
			currentAST.child = binary_type_AST!=null &&binary_type_AST.getFirstChild()!=null ?
				binary_type_AST.getFirstChild() : binary_type_AST;
			currentAST.advanceChildToEnd();
			binary_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = binary_type_AST;
	}
	
	public final void width_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST width_spec_AST = null;
		
		try {      // for error handling
			match(LPAREN);
			width();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_fixed:
			{
				AST tmp56_AST = null;
				tmp56_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp56_AST);
				match(LITERAL_fixed);
				break;
			}
			case RPAREN:
			case SEMI:
			case COLEQ:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			width_spec_AST = (AST)currentAST.root;
			width_spec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WIDTH_SPEC,"WIDTH_SPEC")).add(width_spec_AST));
			currentAST.root = width_spec_AST;
			currentAST.child = width_spec_AST!=null &&width_spec_AST.getFirstChild()!=null ?
				width_spec_AST.getFirstChild() : width_spec_AST;
			currentAST.advanceChildToEnd();
			width_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = width_spec_AST;
	}
	
	public final void boolean_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_boolean);
			boolean_type_AST = (AST)currentAST.root;
			boolean_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BOOLEAN_TYPE,"BOOLEAN_TYPE")).add(boolean_type_AST));
			currentAST.root = boolean_type_AST;
			currentAST.child = boolean_type_AST!=null &&boolean_type_AST.getFirstChild()!=null ?
				boolean_type_AST.getFirstChild() : boolean_type_AST;
			currentAST.advanceChildToEnd();
			boolean_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = boolean_type_AST;
	}
	
	public final void bound_1() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_1_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			bound_1_AST = (AST)currentAST.root;
			bound_1_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BOUND_1,"BOUND_1")).add(bound_1_AST));
			currentAST.root = bound_1_AST;
			currentAST.child = bound_1_AST!=null &&bound_1_AST.getFirstChild()!=null ?
				bound_1_AST.getFirstChild() : bound_1_AST;
			currentAST.advanceChildToEnd();
			bound_1_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_24);
		}
		returnAST = bound_1_AST;
	}
	
	public final void numeric_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numeric_expression_AST = null;
		
		try {      // for error handling
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			numeric_expression_AST = (AST)currentAST.root;
			numeric_expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(NUMERIC_EXPRESSION,"NUMERIC_EXPRESSION")).add(numeric_expression_AST));
			currentAST.root = numeric_expression_AST;
			currentAST.child = numeric_expression_AST!=null &&numeric_expression_AST.getFirstChild()!=null ?
				numeric_expression_AST.getFirstChild() : numeric_expression_AST;
			currentAST.advanceChildToEnd();
			numeric_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_25);
		}
		returnAST = numeric_expression_AST;
	}
	
	public final void bound_2() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_2_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			bound_2_AST = (AST)currentAST.root;
			bound_2_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BOUND_2,"BOUND_2")).add(bound_2_AST));
			currentAST.root = bound_2_AST;
			currentAST.child = bound_2_AST!=null &&bound_2_AST.getFirstChild()!=null ?
				bound_2_AST.getFirstChild() : bound_2_AST;
			currentAST.advanceChildToEnd();
			bound_2_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_26);
		}
		returnAST = bound_2_AST;
	}
	
	public final void built_in_constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_constant_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_const_e:
			{
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp58_AST);
				match(LITERAL_const_e);
				built_in_constant_AST = (AST)currentAST.root;
				built_in_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_CONSTANT,"BUILT_IN_CONSTANT")).add(built_in_constant_AST));
				currentAST.root = built_in_constant_AST;
				currentAST.child = built_in_constant_AST!=null &&built_in_constant_AST.getFirstChild()!=null ?
					built_in_constant_AST.getFirstChild() : built_in_constant_AST;
				currentAST.advanceChildToEnd();
				built_in_constant_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_pi:
			{
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(LITERAL_pi);
				built_in_constant_AST = (AST)currentAST.root;
				built_in_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_CONSTANT,"BUILT_IN_CONSTANT")).add(built_in_constant_AST));
				currentAST.root = built_in_constant_AST;
				currentAST.child = built_in_constant_AST!=null &&built_in_constant_AST.getFirstChild()!=null ?
					built_in_constant_AST.getFirstChild() : built_in_constant_AST;
				currentAST.advanceChildToEnd();
				built_in_constant_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_self:
			{
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(LITERAL_self);
				built_in_constant_AST = (AST)currentAST.root;
				built_in_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_CONSTANT,"BUILT_IN_CONSTANT")).add(built_in_constant_AST));
				currentAST.root = built_in_constant_AST;
				currentAST.child = built_in_constant_AST!=null &&built_in_constant_AST.getFirstChild()!=null ?
					built_in_constant_AST.getFirstChild() : built_in_constant_AST;
				currentAST.advanceChildToEnd();
				built_in_constant_AST = (AST)currentAST.root;
				break;
			}
			case QUESTION:
			{
				AST tmp61_AST = null;
				tmp61_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp61_AST);
				match(QUESTION);
				built_in_constant_AST = (AST)currentAST.root;
				built_in_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_CONSTANT,"BUILT_IN_CONSTANT")).add(built_in_constant_AST));
				currentAST.root = built_in_constant_AST;
				currentAST.child = built_in_constant_AST!=null &&built_in_constant_AST.getFirstChild()!=null ?
					built_in_constant_AST.getFirstChild() : built_in_constant_AST;
				currentAST.advanceChildToEnd();
				built_in_constant_AST = (AST)currentAST.root;
				break;
			}
			case STAR:
			{
				AST tmp62_AST = null;
				tmp62_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp62_AST);
				match(STAR);
				built_in_constant_AST = (AST)currentAST.root;
				built_in_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_CONSTANT,"BUILT_IN_CONSTANT")).add(built_in_constant_AST));
				currentAST.root = built_in_constant_AST;
				currentAST.child = built_in_constant_AST!=null &&built_in_constant_AST.getFirstChild()!=null ?
					built_in_constant_AST.getFirstChild() : built_in_constant_AST;
				currentAST.advanceChildToEnd();
				built_in_constant_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = built_in_constant_AST;
	}
	
	public final void built_in_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_function_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_abs:
			{
				AST tmp63_AST = null;
				tmp63_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp63_AST);
				match(LITERAL_abs);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_acos:
			{
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(LITERAL_acos);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_asin:
			{
				AST tmp65_AST = null;
				tmp65_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp65_AST);
				match(LITERAL_asin);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_atan:
			{
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(LITERAL_atan);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_blength:
			{
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(LITERAL_blength);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_cos:
			{
				AST tmp68_AST = null;
				tmp68_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp68_AST);
				match(LITERAL_cos);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_exists:
			{
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(LITERAL_exists);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_exp:
			{
				AST tmp70_AST = null;
				tmp70_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp70_AST);
				match(LITERAL_exp);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_format:
			{
				AST tmp71_AST = null;
				tmp71_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp71_AST);
				match(LITERAL_format);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_hibound:
			{
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
				match(LITERAL_hibound);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_hiindex:
			{
				AST tmp73_AST = null;
				tmp73_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp73_AST);
				match(LITERAL_hiindex);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_length:
			{
				AST tmp74_AST = null;
				tmp74_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp74_AST);
				match(LITERAL_length);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lobound:
			{
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp75_AST);
				match(LITERAL_lobound);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_loindex:
			{
				AST tmp76_AST = null;
				tmp76_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp76_AST);
				match(LITERAL_loindex);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_log:
			{
				AST tmp77_AST = null;
				tmp77_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp77_AST);
				match(LITERAL_log);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case 256:
			{
				AST tmp78_AST = null;
				tmp78_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp78_AST);
				match(256);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case 257:
			{
				AST tmp79_AST = null;
				tmp79_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp79_AST);
				match(257);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_nvl:
			{
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp80_AST);
				match(LITERAL_nvl);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_odd:
			{
				AST tmp81_AST = null;
				tmp81_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp81_AST);
				match(LITERAL_odd);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rolesof:
			{
				AST tmp82_AST = null;
				tmp82_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp82_AST);
				match(LITERAL_rolesof);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sin:
			{
				AST tmp83_AST = null;
				tmp83_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp83_AST);
				match(LITERAL_sin);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sizeof:
			{
				AST tmp84_AST = null;
				tmp84_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp84_AST);
				match(LITERAL_sizeof);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sqrt:
			{
				AST tmp85_AST = null;
				tmp85_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp85_AST);
				match(LITERAL_sqrt);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_tan:
			{
				AST tmp86_AST = null;
				tmp86_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp86_AST);
				match(LITERAL_tan);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_typeof:
			{
				AST tmp87_AST = null;
				tmp87_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp87_AST);
				match(LITERAL_typeof);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_usedin:
			{
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(LITERAL_usedin);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_value:
			{
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp89_AST);
				match(LITERAL_value);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_value_in:
			{
				AST tmp90_AST = null;
				tmp90_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp90_AST);
				match(LITERAL_value_in);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_value_unique:
			{
				AST tmp91_AST = null;
				tmp91_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp91_AST);
				match(LITERAL_value_unique);
				built_in_function_AST = (AST)currentAST.root;
				built_in_function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_FUNCTION,"BUILT_IN_FUNCTIONS")).add(built_in_function_AST));
				currentAST.root = built_in_function_AST;
				currentAST.child = built_in_function_AST!=null &&built_in_function_AST.getFirstChild()!=null ?
					built_in_function_AST.getFirstChild() : built_in_function_AST;
				currentAST.advanceChildToEnd();
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_27);
		}
		returnAST = built_in_function_AST;
	}
	
	public final void built_in_procedure() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_procedure_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_insert:
			{
				AST tmp92_AST = null;
				tmp92_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp92_AST);
				match(LITERAL_insert);
				built_in_procedure_AST = (AST)currentAST.root;
				built_in_procedure_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_PROCEDURE,"BUILT_IN_PROCEDURE")).add(built_in_procedure_AST));
				currentAST.root = built_in_procedure_AST;
				currentAST.child = built_in_procedure_AST!=null &&built_in_procedure_AST.getFirstChild()!=null ?
					built_in_procedure_AST.getFirstChild() : built_in_procedure_AST;
				currentAST.advanceChildToEnd();
				built_in_procedure_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_remove:
			{
				AST tmp93_AST = null;
				tmp93_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp93_AST);
				match(LITERAL_remove);
				built_in_procedure_AST = (AST)currentAST.root;
				built_in_procedure_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(BUILT_IN_PROCEDURE,"BUILT_IN_PROCEDURE")).add(built_in_procedure_AST));
				currentAST.root = built_in_procedure_AST;
				currentAST.child = built_in_procedure_AST!=null &&built_in_procedure_AST.getFirstChild()!=null ?
					built_in_procedure_AST.getFirstChild() : built_in_procedure_AST;
				currentAST.advanceChildToEnd();
				built_in_procedure_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_28);
		}
		returnAST = built_in_procedure_AST;
	}
	
	public final void case_action() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_action_AST = null;
		
		try {      // for error handling
			case_label();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35552:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					case_label();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35552;
				}
				
			} while (true);
			}
			match(COLON);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			case_action_AST = (AST)currentAST.root;
			case_action_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CASE_ACTION,"CASE_ACTION")).add(case_action_AST));
			currentAST.root = case_action_AST;
			currentAST.child = case_action_AST!=null &&case_action_AST.getFirstChild()!=null ?
				case_action_AST.getFirstChild() : case_action_AST;
			currentAST.advanceChildToEnd();
			case_action_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_29);
		}
		returnAST = case_action_AST;
	}
	
	public final void case_label() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_label_AST = null;
		
		try {      // for error handling
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			case_label_AST = (AST)currentAST.root;
			case_label_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CASE_LABEL,"CASE_LABEL")).add(case_label_AST));
			currentAST.root = case_label_AST;
			currentAST.child = case_label_AST!=null &&case_label_AST.getFirstChild()!=null ?
				case_label_AST.getFirstChild() : case_label_AST;
			currentAST.advanceChildToEnd();
			case_label_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_30);
		}
		returnAST = case_label_AST;
	}
	
	public final void case_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_stmt_AST = null;
		
		try {      // for error handling
			match(LITERAL_case);
			selector();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_of);
			{
			_loop35556:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					case_action();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35556;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_otherwise:
			{
				match(LITERAL_otherwise);
				match(COLON);
				stmt();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end_case:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_end_case);
			match(SEMI);
			case_stmt_AST = (AST)currentAST.root;
			case_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CASE_STMT,"CASE_STMT")).add(case_stmt_AST));
			currentAST.root = case_stmt_AST;
			currentAST.child = case_stmt_AST!=null &&case_stmt_AST.getFirstChild()!=null ?
				case_stmt_AST.getFirstChild() : case_stmt_AST;
			currentAST.advanceChildToEnd();
			case_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = case_stmt_AST;
	}
	
	public final void selector() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST selector_AST = null;
		
		try {      // for error handling
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			selector_AST = (AST)currentAST.root;
			selector_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECTOR,"SELECTOR")).add(selector_AST));
			currentAST.root = selector_AST;
			currentAST.child = selector_AST!=null &&selector_AST.getFirstChild()!=null ?
				selector_AST.getFirstChild() : selector_AST;
			currentAST.advanceChildToEnd();
			selector_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_19);
		}
		returnAST = selector_AST;
	}
	
	public final void compound_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compound_stmt_AST = null;
		
		try {      // for error handling
			match(LITERAL_begin);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35560:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35560;
				}
				
			} while (true);
			}
			match(LITERAL_end);
			match(SEMI);
			compound_stmt_AST = (AST)currentAST.root;
			compound_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPOUND_STMT,"COMPOUND_STMT")).add(compound_stmt_AST));
			currentAST.root = compound_stmt_AST;
			currentAST.child = compound_stmt_AST!=null &&compound_stmt_AST.getFirstChild()!=null ?
				compound_stmt_AST.getFirstChild() : compound_stmt_AST;
			currentAST.advanceChildToEnd();
			compound_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = compound_stmt_AST;
	}
	
	public final void constant_body() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_body_AST = null;
		
		try {      // for error handling
			constant_id();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLON);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLEQ);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			constant_body_AST = (AST)currentAST.root;
			constant_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_BODY,"CONSTANT_BODY")).add(constant_body_AST));
			currentAST.root = constant_body_AST;
			currentAST.child = constant_body_AST!=null &&constant_body_AST.getFirstChild()!=null ?
				constant_body_AST.getFirstChild() : constant_body_AST;
			currentAST.advanceChildToEnd();
			constant_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_31);
		}
		returnAST = constant_body_AST;
	}
	
	public final void constant_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				addId(id.getText(),CONSTANT_IDENT);
				constant_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==CONSTANT_IDENT)) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(CONSTANT_IDENT);
				constant_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); constant_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_ID,"CONSTANT_ID")).add(constant_id_AST));
				currentAST.root = constant_id_AST;
				currentAST.child = constant_id_AST!=null &&constant_id_AST.getFirstChild()!=null ?
					constant_id_AST.getFirstChild() : constant_id_AST;
				currentAST.advanceChildToEnd();
				constant_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_32);
		}
		returnAST = constant_id_AST;
	}
	
	public final void constant_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_factor_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_const_e:
			case LITERAL_pi:
			case LITERAL_self:
			case QUESTION:
			case STAR:
			{
				built_in_constant();
				astFactory.addASTChild(currentAST, returnAST);
				constant_factor_AST = (AST)currentAST.root;
				constant_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_FACTOR,"CONSTANT_FACTOR")).add(constant_factor_AST));
				currentAST.root = constant_factor_AST;
				currentAST.child = constant_factor_AST!=null &&constant_factor_AST.getFirstChild()!=null ?
					constant_factor_AST.getFirstChild() : constant_factor_AST;
				currentAST.advanceChildToEnd();
				constant_factor_AST = (AST)currentAST.root;
				break;
			}
			case CONSTANT_IDENT:
			{
				constant_ref();
				astFactory.addASTChild(currentAST, returnAST);
				constant_factor_AST = (AST)currentAST.root;
				constant_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_FACTOR,"CONSTANT_FACTOR")).add(constant_factor_AST));
				currentAST.root = constant_factor_AST;
				currentAST.child = constant_factor_AST!=null &&constant_factor_AST.getFirstChild()!=null ?
					constant_factor_AST.getFirstChild() : constant_factor_AST;
				currentAST.advanceChildToEnd();
				constant_factor_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = constant_factor_AST;
	}
	
	public final void constant_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(CONSTANT_IDENT);
			constant_ref_AST = (AST)currentAST.root;
			nid_AST.setType(IDENT); constant_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_REF,"CONSTANT_REF")).add(constant_ref_AST));
			currentAST.root = constant_ref_AST;
			currentAST.child = constant_ref_AST!=null &&constant_ref_AST.getFirstChild()!=null ?
				constant_ref_AST.getFirstChild() : constant_ref_AST;
			currentAST.advanceChildToEnd();
			constant_ref_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_33);
		}
		returnAST = constant_ref_AST;
	}
	
	public final void entity_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_decl_AST = null;
		
		try {      // for error handling
			entity_head();
			astFactory.addASTChild(currentAST, returnAST);
			entity_body();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_end_entity);
			upScope();
			match(SEMI);
			entity_decl_AST = (AST)currentAST.root;
			entity_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_DECL,"ENTITY_DECL")).add(entity_decl_AST));
			currentAST.root = entity_decl_AST;
			currentAST.child = entity_decl_AST!=null &&entity_decl_AST.getFirstChild()!=null ?
				entity_decl_AST.getFirstChild() : entity_decl_AST;
			currentAST.advanceChildToEnd();
			entity_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = entity_decl_AST;
	}
	
	public final void subtype_constraint_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_decl_AST = null;
		
		try {      // for error handling
			subtype_constraint_head();
			astFactory.addASTChild(currentAST, returnAST);
			subtype_constraint_body();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_end_subtype_constraint);
			match(SEMI);
			subtype_constraint_decl_AST = (AST)currentAST.root;
			subtype_constraint_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBTYPE_CONSTRAINT_DECL,"SUBTYPE_CONSTRAINT_DECL")).add(subtype_constraint_decl_AST));
			currentAST.root = subtype_constraint_decl_AST;
			currentAST.child = subtype_constraint_decl_AST!=null &&subtype_constraint_decl_AST.getFirstChild()!=null ?
				subtype_constraint_decl_AST.getFirstChild() : subtype_constraint_decl_AST;
			currentAST.advanceChildToEnd();
			subtype_constraint_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = subtype_constraint_decl_AST;
	}
	
	public final void function_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_decl_AST = null;
		
		try {      // for error handling
			function_head();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((_tokenSet_34.member(LA(1)))) {
				algorithm_head();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_15.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35668:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35668;
				}
				
			} while (true);
			}
			match(LITERAL_end_function);
			match(SEMI);
			function_decl_AST = (AST)currentAST.root;
			upScope(); function_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_DECL,"FUNCTION_DECL")).add(function_decl_AST));
			currentAST.root = function_decl_AST;
			currentAST.child = function_decl_AST!=null &&function_decl_AST.getFirstChild()!=null ?
				function_decl_AST.getFirstChild() : function_decl_AST;
			currentAST.advanceChildToEnd();
			function_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = function_decl_AST;
	}
	
	public final void procedure_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_decl_AST = null;
		
		try {      // for error handling
			procedure_head();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((_tokenSet_35.member(LA(1)))) {
				algorithm_head();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_36.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop35751:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35751;
				}
				
			} while (true);
			}
			match(LITERAL_end_procedure);
			match(SEMI);
			procedure_decl_AST = (AST)currentAST.root;
			upScope(); procedure_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_DECL,"PROCEDURE_DECL")).add(procedure_decl_AST));
			currentAST.root = procedure_decl_AST;
			currentAST.child = procedure_decl_AST!=null &&procedure_decl_AST.getFirstChild()!=null ?
				procedure_decl_AST.getFirstChild() : procedure_decl_AST;
			currentAST.advanceChildToEnd();
			procedure_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = procedure_decl_AST;
	}
	
	public final void type_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_decl_AST = null;
		
			       String id=null;
			       EnumerationType eids=null;
			
		
		try {      // for error handling
			match(LITERAL_type);
			id=type_id();
			astFactory.addASTChild(currentAST, returnAST);
			newScope();
			match(ASSIGN);
			eids=underlying_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				where_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end_type:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_end_type);
			match(SEMI);
			type_decl_AST = (AST)currentAST.root;
			upScope();
						if (eids!=null) {
						   eids.setTypeName(id);
						   currentScope.addEnumerationType(eids);
						}
						type_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_DECL,"TYPE_DECL")).add(type_decl_AST));
			currentAST.root = type_decl_AST;
			currentAST.child = type_decl_AST!=null &&type_decl_AST.getFirstChild()!=null ?
				type_decl_AST.getFirstChild() : type_decl_AST;
			currentAST.advanceChildToEnd();
			type_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = type_decl_AST;
	}
	
	public final void domain_rule() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST domain_rule_AST = null;
		
		try {      // for error handling
			if (((_tokenSet_2.member(LA(1))))&&( isFirst&&(LA(2)!=COLON) )) {
				logical_expression();
				astFactory.addASTChild(currentAST, returnAST);
				domain_rule_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_2.member(LA(1)))) {
				{
				if ((LA(1)==IDENT)) {
					label();
					astFactory.addASTChild(currentAST, returnAST);
					match(COLON);
				}
				else if ((_tokenSet_2.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				logical_expression();
				astFactory.addASTChild(currentAST, returnAST);
				domain_rule_AST = (AST)currentAST.root;
				domain_rule_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DOMAIN_RULE,"DOMAIN_RULE")).add(domain_rule_AST));
				currentAST.root = domain_rule_AST;
				currentAST.child = domain_rule_AST!=null &&domain_rule_AST.getFirstChild()!=null ?
					domain_rule_AST.getFirstChild() : domain_rule_AST;
				currentAST.advanceChildToEnd();
				domain_rule_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = domain_rule_AST;
	}
	
	public final void logical_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_expression_AST = null;
		
		try {      // for error handling
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			logical_expression_AST = (AST)currentAST.root;
			logical_expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_EXPRESSION,"LOGICAL_EXPRESSION")).add(logical_expression_AST));
			currentAST.root = logical_expression_AST;
			currentAST.child = logical_expression_AST!=null &&logical_expression_AST.getFirstChild()!=null ?
				logical_expression_AST.getFirstChild() : logical_expression_AST;
			currentAST.advanceChildToEnd();
			logical_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_38);
		}
		returnAST = logical_expression_AST;
	}
	
	public final void label() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST label_AST = null;
		
		try {      // for error handling
			AST tmp122_AST = null;
			tmp122_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp122_AST);
			match(IDENT);
			label_AST = (AST)currentAST.root;
			label_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LABEL,"LABEL")).add(label_AST));
			currentAST.root = label_AST;
			currentAST.child = label_AST!=null &&label_AST.getFirstChild()!=null ?
				label_AST.getFirstChild() : label_AST;
			currentAST.advanceChildToEnd();
			label_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_32);
		}
		returnAST = label_AST;
	}
	
	public final void repetition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repetition_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			repetition_AST = (AST)currentAST.root;
			repetition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REPETITION,"REPETITION")).add(repetition_AST));
			currentAST.root = repetition_AST;
			currentAST.child = repetition_AST!=null &&repetition_AST.getFirstChild()!=null ?
				repetition_AST.getFirstChild() : repetition_AST;
			currentAST.advanceChildToEnd();
			repetition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = repetition_AST;
	}
	
	public final void entity_head() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_head_AST = null;
		String id=null;
		
		try {      // for error handling
			match(LITERAL_entity);
			id=entity_id();
			astFactory.addASTChild(currentAST, returnAST);
			newEntityScope(id);
			{
			if (((LA(1)==LITERAL_abstract))&&( LA(2)!=LITERAL_supertype )) {
				AST tmp124_AST = null;
				tmp124_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp124_AST);
				match(LITERAL_abstract);
			}
			else if ((_tokenSet_39.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			if ((_tokenSet_39.member(LA(1)))) {
				subsuper();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_40.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case SEMI:
			{
				match(SEMI);
				break;
			}
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT:
			case LITERAL_unique:
			case LITERAL_self:
			case LITERAL_end_entity:
			case LITERAL_derive:
			case LITERAL_inverse:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			entity_head_AST = (AST)currentAST.root;
			entity_head_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_HEAD,"ENTITY_HEAD")).add(entity_head_AST));
			currentAST.root = entity_head_AST;
			currentAST.child = entity_head_AST!=null &&entity_head_AST.getFirstChild()!=null ?
				entity_head_AST.getFirstChild() : entity_head_AST;
			currentAST.advanceChildToEnd();
			entity_head_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_41);
		}
		returnAST = entity_head_AST;
	}
	
	public final String  entity_id() throws RecognitionException, TokenStreamException {
		String eid;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  id2 = null;
		AST id2_AST = null;
		eid=null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				eid=id.getText(); addId(eid,ENTITY_IDENT);
				entity_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==ENTITY_IDENT)) {
				id2 = LT(1);
				id2_AST = astFactory.create(id2);
				astFactory.addASTChild(currentAST, id2_AST);
				match(ENTITY_IDENT);
				entity_id_AST = (AST)currentAST.root;
				eid=id2.getText();
						id2_AST.setType(IDENT); 
						entity_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_ID,"ENTITY_ID")).add(entity_id_AST));
						
				currentAST.root = entity_id_AST;
				currentAST.child = entity_id_AST!=null &&entity_id_AST.getFirstChild()!=null ?
					entity_id_AST.getFirstChild() : entity_id_AST;
				currentAST.advanceChildToEnd();
				entity_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_42);
		}
		returnAST = entity_id_AST;
		return eid;
	}
	
	public final void subsuper() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subsuper_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			case LITERAL_supertype:
			{
				supertype_constraint();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT:
			case SEMI:
			case LITERAL_unique:
			case LITERAL_self:
			case LITERAL_end_entity:
			case LITERAL_subtype:
			case LITERAL_derive:
			case LITERAL_inverse:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_subtype:
			{
				subtype_declaration();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT:
			case SEMI:
			case LITERAL_unique:
			case LITERAL_self:
			case LITERAL_end_entity:
			case LITERAL_derive:
			case LITERAL_inverse:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			subsuper_AST = (AST)currentAST.root;
			subsuper_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBSUPER,"SUBSUPER")).add(subsuper_AST));
			currentAST.root = subsuper_AST;
			currentAST.child = subsuper_AST!=null &&subsuper_AST.getFirstChild()!=null ?
				subsuper_AST.getFirstChild() : subsuper_AST;
			currentAST.advanceChildToEnd();
			subsuper_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_40);
		}
		returnAST = subsuper_AST;
	}
	
	public final void entity_body() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_body_AST = null;
		
		try {      // for error handling
			{
			_loop35579:
			do {
				if ((_tokenSet_43.member(LA(1)))) {
					explicit_attr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35579;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_derive:
			{
				derive_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_unique:
			case LITERAL_end_entity:
			case LITERAL_inverse:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_inverse:
			{
				inverse_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_unique:
			case LITERAL_end_entity:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_unique:
			{
				unique_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end_entity:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				where_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end_entity:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			entity_body_AST = (AST)currentAST.root;
			entity_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_BODY,"ENTITY_BODY")).add(entity_body_AST));
			currentAST.root = entity_body_AST;
			currentAST.child = entity_body_AST!=null &&entity_body_AST.getFirstChild()!=null ?
				entity_body_AST.getFirstChild() : entity_body_AST;
			currentAST.advanceChildToEnd();
			entity_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_44);
		}
		returnAST = entity_body_AST;
	}
	
	public final void explicit_attr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST explicit_attr_AST = null;
		
		try {      // for error handling
			attribute_decl();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35612:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					attribute_decl();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35612;
				}
				
			} while (true);
			}
			match(COLON);
			{
			switch ( LA(1)) {
			case LITERAL_optional:
			{
				AST tmp128_AST = null;
				tmp128_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp128_AST);
				match(LITERAL_optional);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			explicit_attr_AST = (AST)currentAST.root;
			explicit_attr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXPLICIT_ATTR,"EXPLICIT_ATTR")).add(explicit_attr_AST));
			currentAST.root = explicit_attr_AST;
			currentAST.child = explicit_attr_AST!=null &&explicit_attr_AST.getFirstChild()!=null ?
				explicit_attr_AST.getFirstChild() : explicit_attr_AST;
			currentAST.advanceChildToEnd();
			explicit_attr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_41);
		}
		returnAST = explicit_attr_AST;
	}
	
	public final void derive_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST derive_clause_AST = null;
		
		try {      // for error handling
			match(LITERAL_derive);
			derived_attr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35621:
			do {
				if ((_tokenSet_43.member(LA(1)))) {
					derived_attr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35621;
				}
				
			} while (true);
			}
			derive_clause_AST = (AST)currentAST.root;
			derive_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DERIVE_CLAUSE,"DERIVE_CLAUSE")).add(derive_clause_AST));
			currentAST.root = derive_clause_AST;
			currentAST.child = derive_clause_AST!=null &&derive_clause_AST.getFirstChild()!=null ?
				derive_clause_AST.getFirstChild() : derive_clause_AST;
			currentAST.advanceChildToEnd();
			derive_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_45);
		}
		returnAST = derive_clause_AST;
	}
	
	public final void inverse_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inverse_clause_AST = null;
		
		try {      // for error handling
			match(LITERAL_inverse);
			inverse_attr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35625:
			do {
				if ((_tokenSet_43.member(LA(1)))) {
					inverse_attr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35625;
				}
				
			} while (true);
			}
			inverse_clause_AST = (AST)currentAST.root;
			inverse_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INVERSE_CLAUSE,"INVERSE_CLAUSE")).add(inverse_clause_AST));
			currentAST.root = inverse_clause_AST;
			currentAST.child = inverse_clause_AST!=null &&inverse_clause_AST.getFirstChild()!=null ?
				inverse_clause_AST.getFirstChild() : inverse_clause_AST;
			currentAST.advanceChildToEnd();
			inverse_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_46);
		}
		returnAST = inverse_clause_AST;
	}
	
	public final void unique_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unique_clause_AST = null;
		
		try {      // for error handling
			match(LITERAL_unique);
			unique_rule();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			{
			_loop35635:
			do {
				if ((_tokenSet_43.member(LA(1)))) {
					unique_rule();
					astFactory.addASTChild(currentAST, returnAST);
					match(SEMI);
				}
				else {
					break _loop35635;
				}
				
			} while (true);
			}
			unique_clause_AST = (AST)currentAST.root;
			unique_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNIQUE_CLAUSE,"UNIQUE_CLAUSE")).add(unique_clause_AST));
			currentAST.root = unique_clause_AST;
			currentAST.child = unique_clause_AST!=null &&unique_clause_AST.getFirstChild()!=null ?
				unique_clause_AST.getFirstChild() : unique_clause_AST;
			currentAST.advanceChildToEnd();
			unique_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_47);
		}
		returnAST = unique_clause_AST;
	}
	
	public final void where_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST where_clause_AST = null;
		
		try {      // for error handling
			match(LITERAL_where);
			domain_rule();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			{
			_loop35910:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					domain_rule();
					astFactory.addASTChild(currentAST, returnAST);
					match(SEMI);
				}
				else {
					break _loop35910;
				}
				
			} while (true);
			}
			where_clause_AST = (AST)currentAST.root;
			where_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WHERE_CLAUSE,"WHERE_CLAUSE")).add(where_clause_AST));
			currentAST.root = where_clause_AST;
			currentAST.child = where_clause_AST!=null &&where_clause_AST.getFirstChild()!=null ?
				where_clause_AST.getFirstChild() : where_clause_AST;
			currentAST.advanceChildToEnd();
			where_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_48);
		}
		returnAST = where_clause_AST;
	}
	
	public final void supertype_constraint() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_constraint_AST = null;
		
		try {      // for error handling
			if ((LA(1)==LITERAL_abstract)) {
				abstract_supertype_declaration();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_constraint_AST = (AST)currentAST.root;
				supertype_constraint_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_CONSTRAINT,"SUPERTYPE_CONSTRAINT")).add(supertype_constraint_AST));
				currentAST.root = supertype_constraint_AST;
				currentAST.child = supertype_constraint_AST!=null &&supertype_constraint_AST.getFirstChild()!=null ?
					supertype_constraint_AST.getFirstChild() : supertype_constraint_AST;
				currentAST.advanceChildToEnd();
				supertype_constraint_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_abstract||LA(1)==LITERAL_supertype)) {
				supertype_rule();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_constraint_AST = (AST)currentAST.root;
				supertype_constraint_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_CONSTRAINT,"SUPERTYPE_CONSTRAINT")).add(supertype_constraint_AST));
				currentAST.root = supertype_constraint_AST;
				currentAST.child = supertype_constraint_AST!=null &&supertype_constraint_AST.getFirstChild()!=null ?
					supertype_constraint_AST.getFirstChild() : supertype_constraint_AST;
				currentAST.advanceChildToEnd();
				supertype_constraint_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_49);
		}
		returnAST = supertype_constraint_AST;
	}
	
	public final void subtype_declaration() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_declaration_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  id2 = null;
		AST id2_AST = null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_subtype))&&( isFirst )) {
				AST tmp138_AST = null;
				tmp138_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp138_AST);
				match(LITERAL_subtype);
				AST tmp139_AST = null;
				tmp139_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp139_AST);
				match(LITERAL_of);
				AST tmp140_AST = null;
				tmp140_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp140_AST);
				match(LPAREN);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				addSuper(id.getText());
				{
				_loop35592:
				do {
					if ((LA(1)==COMMA)) {
						AST tmp141_AST = null;
						tmp141_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp141_AST);
						match(COMMA);
						id2 = LT(1);
						id2_AST = astFactory.create(id2);
						astFactory.addASTChild(currentAST, id2_AST);
						match(IDENT);
						addSuper(id2.getText());
					}
					else {
						break _loop35592;
					}
					
				} while (true);
				}
				AST tmp142_AST = null;
				tmp142_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp142_AST);
				match(RPAREN);
				{
				if ((LA(1)==SEMI)) {
					AST tmp143_AST = null;
					tmp143_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp143_AST);
					match(SEMI);
				}
				else if ((_tokenSet_40.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				subtype_declaration_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_subtype)) {
				match(LITERAL_subtype);
				match(LITERAL_of);
				match(LPAREN);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35595:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						entity_ref();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35595;
					}
					
				} while (true);
				}
				match(RPAREN);
				{
				if ((LA(1)==SEMI)) {
					match(SEMI);
				}
				else if ((_tokenSet_40.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				subtype_declaration_AST = (AST)currentAST.root;
				subtype_declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBTYPE_DECLARATION,"SUBTYPE_DECLARATION")).add(subtype_declaration_AST));
				currentAST.root = subtype_declaration_AST;
				currentAST.child = subtype_declaration_AST!=null &&subtype_declaration_AST.getFirstChild()!=null ?
					subtype_declaration_AST.getFirstChild() : subtype_declaration_AST;
				currentAST.advanceChildToEnd();
				subtype_declaration_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_40);
		}
		returnAST = subtype_declaration_AST;
	}
	
	public final void abstract_supertype_declaration() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abstract_supertype_declaration_AST = null;
		
		try {      // for error handling
			match(LITERAL_abstract);
			match(LITERAL_supertype);
			{
			switch ( LA(1)) {
			case LITERAL_of:
			{
				subtype_constraint();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT:
			case SEMI:
			case LITERAL_unique:
			case LITERAL_self:
			case LITERAL_end_entity:
			case LITERAL_subtype:
			case LITERAL_derive:
			case LITERAL_inverse:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			abstract_supertype_declaration_AST = (AST)currentAST.root;
			abstract_supertype_declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ABSTRACT_SUPERTYPE_DECLARATION,"ABSTRACT_SUPERTYPE_DECLARATION")).add(abstract_supertype_declaration_AST));
			currentAST.root = abstract_supertype_declaration_AST;
			currentAST.child = abstract_supertype_declaration_AST!=null &&abstract_supertype_declaration_AST.getFirstChild()!=null ?
				abstract_supertype_declaration_AST.getFirstChild() : abstract_supertype_declaration_AST;
			currentAST.advanceChildToEnd();
			abstract_supertype_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_49);
		}
		returnAST = abstract_supertype_declaration_AST;
	}
	
	public final void supertype_rule() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_rule_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			{
				AST tmp152_AST = null;
				tmp152_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp152_AST);
				match(LITERAL_abstract);
				break;
			}
			case LITERAL_supertype:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_supertype);
			{
			switch ( LA(1)) {
			case LITERAL_of:
			{
				subtype_constraint();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT:
			case SEMI:
			case LITERAL_unique:
			case LITERAL_self:
			case LITERAL_end_entity:
			case LITERAL_subtype:
			case LITERAL_derive:
			case LITERAL_inverse:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			supertype_rule_AST = (AST)currentAST.root;
			supertype_rule_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_RULE,"SUPERTYPE_RULE")).add(supertype_rule_AST));
			currentAST.root = supertype_rule_AST;
			currentAST.child = supertype_rule_AST!=null &&supertype_rule_AST.getFirstChild()!=null ?
				supertype_rule_AST.getFirstChild() : supertype_rule_AST;
			currentAST.advanceChildToEnd();
			supertype_rule_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_49);
		}
		returnAST = supertype_rule_AST;
	}
	
	public final void subtype_constraint() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_AST = null;
		
		try {      // for error handling
			match(LITERAL_of);
			match(LPAREN);
			supertype_expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			{
			if ((LA(1)==SEMI)) {
				match(SEMI);
			}
			else if ((_tokenSet_49.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			subtype_constraint_AST = (AST)currentAST.root;
			subtype_constraint_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBTYPE_CONSTRAINT,"SUBTYPE_CONSTRAINT")).add(subtype_constraint_AST));
			currentAST.root = subtype_constraint_AST;
			currentAST.child = subtype_constraint_AST!=null &&subtype_constraint_AST.getFirstChild()!=null ?
				subtype_constraint_AST.getFirstChild() : subtype_constraint_AST;
			currentAST.advanceChildToEnd();
			subtype_constraint_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_49);
		}
		returnAST = subtype_constraint_AST;
	}
	
	public final void entity_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		Token  nid4 = null;
		AST nid4_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTITY_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ENTITY_IDENT);
				entity_ref_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); entity_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_REF,"ENTITY_REF")).add(entity_ref_AST));
				currentAST.root = entity_ref_AST;
				currentAST.child = entity_ref_AST!=null &&entity_ref_AST.getFirstChild()!=null ?
					entity_ref_AST.getFirstChild() : entity_ref_AST;
				currentAST.advanceChildToEnd();
				entity_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_ATTR_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_ATTR_IDENT);
				entity_ref_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); entity_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_REF,"ENTITY_REF")).add(entity_ref_AST));
				currentAST.root = entity_ref_AST;
				currentAST.child = entity_ref_AST!=null &&entity_ref_AST.getFirstChild()!=null ?
					entity_ref_AST.getFirstChild() : entity_ref_AST;
				currentAST.advanceChildToEnd();
				entity_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_VAR_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ENTITY_VAR_IDENT);
				entity_ref_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); entity_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_REF,"ENTITY_REF")).add(entity_ref_AST));
				currentAST.root = entity_ref_AST;
				currentAST.child = entity_ref_AST!=null &&entity_ref_AST.getFirstChild()!=null ?
					entity_ref_AST.getFirstChild() : entity_ref_AST;
				currentAST.advanceChildToEnd();
				entity_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_PARAM_IDENT:
			{
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				astFactory.addASTChild(currentAST, nid4_AST);
				match(ENTITY_PARAM_IDENT);
				entity_ref_AST = (AST)currentAST.root;
				nid4_AST.setType(IDENT); entity_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_REF,"ENTITY_REF")).add(entity_ref_AST));
				currentAST.root = entity_ref_AST;
				currentAST.child = entity_ref_AST!=null &&entity_ref_AST.getFirstChild()!=null ?
					entity_ref_AST.getFirstChild() : entity_ref_AST;
				currentAST.advanceChildToEnd();
				entity_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_50);
		}
		returnAST = entity_ref_AST;
	}
	
	public final void subtype_constraint_head() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_head_AST = null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_subtype_constraint))&&( isFirst )) {
				AST tmp158_AST = null;
				tmp158_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp158_AST);
				match(LITERAL_subtype_constraint);
				subtype_constraint_id();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp159_AST = null;
				tmp159_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp159_AST);
				match(LITERAL_for);
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp160_AST);
				match(IDENT);
				AST tmp161_AST = null;
				tmp161_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp161_AST);
				match(SEMI);
				subtype_constraint_head_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_subtype_constraint)) {
				match(LITERAL_subtype_constraint);
				subtype_constraint_id();
				astFactory.addASTChild(currentAST, returnAST);
				match(LITERAL_for);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				match(SEMI);
				subtype_constraint_head_AST = (AST)currentAST.root;
				subtype_constraint_head_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBTYPE_CONSTRAINT_HEAD,"SUBTYPE_CONSTRAINT_HEAD")).add(subtype_constraint_head_AST));
				currentAST.root = subtype_constraint_head_AST;
				currentAST.child = subtype_constraint_head_AST!=null &&subtype_constraint_head_AST.getFirstChild()!=null ?
					subtype_constraint_head_AST.getFirstChild() : subtype_constraint_head_AST;
				currentAST.advanceChildToEnd();
				subtype_constraint_head_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_51);
		}
		returnAST = subtype_constraint_head_AST;
	}
	
	public final void subtype_constraint_body() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_body_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abstract:
			{
				abstract_supertype();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case LPAREN:
			case IDENT:
			case LITERAL_end_subtype_constraint:
			case LITERAL_total_over:
			case LITERAL_oneof:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_total_over:
			{
				total_over();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case LPAREN:
			case IDENT:
			case LITERAL_end_subtype_constraint:
			case LITERAL_oneof:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case LPAREN:
			case IDENT:
			case LITERAL_oneof:
			{
				supertype_expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(SEMI);
				break;
			}
			case LITERAL_end_subtype_constraint:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			subtype_constraint_body_AST = (AST)currentAST.root;
			subtype_constraint_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBTYPE_CONSTRAINT_BODY,"SUBTYPE_CONSTRAINT_BODY")).add(subtype_constraint_body_AST));
			currentAST.root = subtype_constraint_body_AST;
			currentAST.child = subtype_constraint_body_AST!=null &&subtype_constraint_body_AST.getFirstChild()!=null ?
				subtype_constraint_body_AST.getFirstChild() : subtype_constraint_body_AST;
			currentAST.advanceChildToEnd();
			subtype_constraint_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_52);
		}
		returnAST = subtype_constraint_body_AST;
	}
	
	public final void subtype_constraint_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  id2 = null;
		AST id2_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				addId(id.getText(),SUBTYPE_CONSTRAINT_ID);
				subtype_constraint_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==SUBTYPE_CONSTRAINT_ID)) {
				id2 = LT(1);
				id2_AST = astFactory.create(id2);
				astFactory.addASTChild(currentAST, id2_AST);
				match(SUBTYPE_CONSTRAINT_ID);
				subtype_constraint_id_AST = (AST)currentAST.root;
				
						   id2_AST.setType(IDENT);
						   subtype_constraint_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBTYPE_CONSTRAINT_ID,"SUBTYPE_CONSTRAINT_ID")).add(subtype_constraint_id_AST));
						
				currentAST.root = subtype_constraint_id_AST;
				currentAST.child = subtype_constraint_id_AST!=null &&subtype_constraint_id_AST.getFirstChild()!=null ?
					subtype_constraint_id_AST.getFirstChild() : subtype_constraint_id_AST;
				currentAST.advanceChildToEnd();
				subtype_constraint_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_53);
		}
		returnAST = subtype_constraint_id_AST;
	}
	
	public final void abstract_supertype() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abstract_supertype_AST = null;
		
		try {      // for error handling
			match(LITERAL_abstract);
			match(LITERAL_supertype);
			match(SEMI);
			abstract_supertype_AST = (AST)currentAST.root;
			abstract_supertype_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ABSTRACT_SUPERTYPE,"ABSTRACT_SUPERTYPE")).add(abstract_supertype_AST));
			currentAST.root = abstract_supertype_AST;
			currentAST.child = abstract_supertype_AST!=null &&abstract_supertype_AST.getFirstChild()!=null ?
				abstract_supertype_AST.getFirstChild() : abstract_supertype_AST;
			currentAST.advanceChildToEnd();
			abstract_supertype_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_54);
		}
		returnAST = abstract_supertype_AST;
	}
	
	public final void total_over() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST total_over_AST = null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_total_over))&&( isFirst )) {
				AST tmp169_AST = null;
				tmp169_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp169_AST);
				match(LITERAL_total_over);
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp170_AST);
				match(LPAREN);
				AST tmp171_AST = null;
				tmp171_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp171_AST);
				match(IDENT);
				{
				_loop35607:
				do {
					if ((LA(1)==COMMA)) {
						AST tmp172_AST = null;
						tmp172_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp172_AST);
						match(COMMA);
						AST tmp173_AST = null;
						tmp173_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp173_AST);
						match(IDENT);
					}
					else {
						break _loop35607;
					}
					
				} while (true);
				}
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp174_AST);
				match(LPAREN);
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp175_AST);
				match(SEMI);
				total_over_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_total_over)) {
				match(LITERAL_total_over);
				match(LPAREN);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35609:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						entity_ref();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35609;
					}
					
				} while (true);
				}
				match(LPAREN);
				match(SEMI);
				total_over_AST = (AST)currentAST.root;
				total_over_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TOTAL_OVER,"TOTAL_OVER")).add(total_over_AST));
				currentAST.root = total_over_AST;
				currentAST.child = total_over_AST!=null &&total_over_AST.getFirstChild()!=null ?
					total_over_AST.getFirstChild() : total_over_AST;
				currentAST.advanceChildToEnd();
				total_over_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_55);
		}
		returnAST = total_over_AST;
	}
	
	public final void supertype_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_expression_AST = null;
		
		try {      // for error handling
			supertype_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35859:
			do {
				if ((LA(1)==LITERAL_andor)) {
					match(LITERAL_andor);
					supertype_factor();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35859;
				}
				
			} while (true);
			}
			supertype_expression_AST = (AST)currentAST.root;
			supertype_expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_EXPRESSION,"SUPERTYPE_EXPRESSION")).add(supertype_expression_AST));
			currentAST.root = supertype_expression_AST;
			currentAST.child = supertype_expression_AST!=null &&supertype_expression_AST.getFirstChild()!=null ?
				supertype_expression_AST.getFirstChild() : supertype_expression_AST;
			currentAST.advanceChildToEnd();
			supertype_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_56);
		}
		returnAST = supertype_expression_AST;
	}
	
	public final void attribute_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_decl_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT:
			{
				attribute_id();
				astFactory.addASTChild(currentAST, returnAST);
				attribute_decl_AST = (AST)currentAST.root;
				attribute_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_DECL,"ATTRIBUTE_DECL")).add(attribute_decl_AST));
				currentAST.root = attribute_decl_AST;
				currentAST.child = attribute_decl_AST!=null &&attribute_decl_AST.getFirstChild()!=null ?
					attribute_decl_AST.getFirstChild() : attribute_decl_AST;
				currentAST.advanceChildToEnd();
				attribute_decl_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_self:
			{
				redeclared_attribute();
				astFactory.addASTChild(currentAST, returnAST);
				attribute_decl_AST = (AST)currentAST.root;
				attribute_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_DECL,"ATTRIBUTE_DECL")).add(attribute_decl_AST));
				currentAST.root = attribute_decl_AST;
				currentAST.child = attribute_decl_AST!=null &&attribute_decl_AST.getFirstChild()!=null ?
					attribute_decl_AST.getFirstChild() : attribute_decl_AST;
				currentAST.advanceChildToEnd();
				attribute_decl_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_30);
		}
		returnAST = attribute_decl_AST;
	}
	
	public final void attribute_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid1 = null;
		AST nid1_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ATTRIBUTE_IDENT:
			{
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				astFactory.addASTChild(currentAST, nid1_AST);
				match(ATTRIBUTE_IDENT);
				attribute_id_AST = (AST)currentAST.root;
				nid1_AST.setType(IDENT); attribute_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_ID,"ATTRIBUTE_ID")).add(attribute_id_AST));
				currentAST.root = attribute_id_AST;
				currentAST.child = attribute_id_AST!=null &&attribute_id_AST.getFirstChild()!=null ?
					attribute_id_AST.getFirstChild() : attribute_id_AST;
				currentAST.advanceChildToEnd();
				attribute_id_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_ATTR_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_ATTR_IDENT);
				attribute_id_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); attribute_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_ID,"ATTRIBUTE_ID")).add(attribute_id_AST));
				currentAST.root = attribute_id_AST;
				currentAST.child = attribute_id_AST!=null &&attribute_id_AST.getFirstChild()!=null ?
					attribute_id_AST.getFirstChild() : attribute_id_AST;
				currentAST.advanceChildToEnd();
				attribute_id_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_ATTR_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_ATTR_IDENT);
				attribute_id_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); attribute_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_ID,"ATTRIBUTE_ID")).add(attribute_id_AST));
				currentAST.root = attribute_id_AST;
				currentAST.child = attribute_id_AST!=null &&attribute_id_AST.getFirstChild()!=null ?
					attribute_id_AST.getFirstChild() : attribute_id_AST;
				currentAST.advanceChildToEnd();
				attribute_id_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(IDENT);
					addId(id.getText(),ATTRIBUTE_IDENT);
					attribute_id_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_30);
		}
		returnAST = attribute_id_AST;
	}
	
	public final void redeclared_attribute() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST redeclared_attribute_AST = null;
		
		try {      // for error handling
			qualified_attribute();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_renamed:
			{
				match(LITERAL_renamed);
				attribute_id();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COMMA:
			case COLON:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			redeclared_attribute_AST = (AST)currentAST.root;
			redeclared_attribute_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REDECLARED_ATTRIBUTE,"REDECLARED_ATTRIBUTE")).add(redeclared_attribute_AST));
			currentAST.root = redeclared_attribute_AST;
			currentAST.child = redeclared_attribute_AST!=null &&redeclared_attribute_AST.getFirstChild()!=null ?
				redeclared_attribute_AST.getFirstChild() : redeclared_attribute_AST;
			currentAST.advanceChildToEnd();
			redeclared_attribute_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_30);
		}
		returnAST = redeclared_attribute_AST;
	}
	
	public final void qualified_attribute() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualified_attribute_AST = null;
		
		try {      // for error handling
			match(LITERAL_self);
			group_qualifier();
			astFactory.addASTChild(currentAST, returnAST);
			attribute_qualifier();
			astFactory.addASTChild(currentAST, returnAST);
			qualified_attribute_AST = (AST)currentAST.root;
			qualified_attribute_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIED_ATTRIBUTE,"QUALIFIED_ATTRIBUTE")).add(qualified_attribute_AST));
			currentAST.root = qualified_attribute_AST;
			currentAST.child = qualified_attribute_AST!=null &&qualified_attribute_AST.getFirstChild()!=null ?
				qualified_attribute_AST.getFirstChild() : qualified_attribute_AST;
			currentAST.advanceChildToEnd();
			qualified_attribute_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_57);
		}
		returnAST = qualified_attribute_AST;
	}
	
	public final void group_qualifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST group_qualifier_AST = null;
		
		try {      // for error handling
			if (((LA(1)==BACKSLASH))&&( isFirst )) {
				AST tmp184_AST = null;
				tmp184_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp184_AST);
				match(BACKSLASH);
				AST tmp185_AST = null;
				tmp185_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp185_AST);
				match(IDENT);
				group_qualifier_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BACKSLASH)) {
				match(BACKSLASH);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				group_qualifier_AST = (AST)currentAST.root;
				group_qualifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GROUP_QUALIFIER,"GROUP_QUALIFIER")).add(group_qualifier_AST));
				currentAST.root = group_qualifier_AST;
				currentAST.child = group_qualifier_AST!=null &&group_qualifier_AST.getFirstChild()!=null ?
					group_qualifier_AST.getFirstChild() : group_qualifier_AST;
				currentAST.advanceChildToEnd();
				group_qualifier_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = group_qualifier_AST;
	}
	
	public final void attribute_qualifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_qualifier_AST = null;
		
		try {      // for error handling
			match(DOT);
			global_ident();
			astFactory.addASTChild(currentAST, returnAST);
			attribute_qualifier_AST = (AST)currentAST.root;
			attribute_qualifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_QUALIFIER,"ATTRIBUTE_QUALIFIER")).add(attribute_qualifier_AST));
			currentAST.root = attribute_qualifier_AST;
			currentAST.child = attribute_qualifier_AST!=null &&attribute_qualifier_AST.getFirstChild()!=null ?
				attribute_qualifier_AST.getFirstChild() : attribute_qualifier_AST;
			currentAST.advanceChildToEnd();
			attribute_qualifier_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_58);
		}
		returnAST = attribute_qualifier_AST;
	}
	
	public final void derived_attr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST derived_attr_AST = null;
		
		try {      // for error handling
			attribute_decl();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLON);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLEQ);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			derived_attr_AST = (AST)currentAST.root;
			derived_attr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DERIVED_ATTR,"DERIVED_ATTR")).add(derived_attr_AST));
			currentAST.root = derived_attr_AST;
			currentAST.child = derived_attr_AST!=null &&derived_attr_AST.getFirstChild()!=null ?
				derived_attr_AST.getFirstChild() : derived_attr_AST;
			currentAST.advanceChildToEnd();
			derived_attr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_59);
		}
		returnAST = derived_attr_AST;
	}
	
	public final void inverse_attr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inverse_attr_AST = null;
		
		try {      // for error handling
			if (((_tokenSet_43.member(LA(1))))&&( isFirst )) {
				attribute_decl();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp191_AST = null;
				tmp191_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp191_AST);
				match(COLON);
				{
				switch ( LA(1)) {
				case LITERAL_bag:
				case LITERAL_set:
				{
					{
					switch ( LA(1)) {
					case LITERAL_set:
					{
						AST tmp192_AST = null;
						tmp192_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp192_AST);
						match(LITERAL_set);
						break;
					}
					case LITERAL_bag:
					{
						AST tmp193_AST = null;
						tmp193_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp193_AST);
						match(LITERAL_bag);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case LBRACK:
					{
						bound_spec();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LITERAL_of:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					AST tmp194_AST = null;
					tmp194_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp194_AST);
					match(LITERAL_of);
					break;
				}
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp195_AST = null;
				tmp195_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp195_AST);
				match(IDENT);
				AST tmp196_AST = null;
				tmp196_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp196_AST);
				match(LITERAL_for);
				AST tmp197_AST = null;
				tmp197_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp197_AST);
				match(IDENT);
				AST tmp198_AST = null;
				tmp198_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp198_AST);
				match(SEMI);
				inverse_attr_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_43.member(LA(1)))) {
				attribute_decl();
				astFactory.addASTChild(currentAST, returnAST);
				match(COLON);
				{
				switch ( LA(1)) {
				case LITERAL_bag:
				case LITERAL_set:
				{
					{
					switch ( LA(1)) {
					case LITERAL_set:
					{
						AST tmp200_AST = null;
						tmp200_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp200_AST);
						match(LITERAL_set);
						break;
					}
					case LITERAL_bag:
					{
						AST tmp201_AST = null;
						tmp201_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp201_AST);
						match(LITERAL_bag);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case LBRACK:
					{
						bound_spec();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LITERAL_of:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(LITERAL_of);
					break;
				}
				case ENTITY_IDENT:
				case ENTITY_ATTR_IDENT:
				case ENTITY_VAR_IDENT:
				case ENTITY_PARAM_IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				match(LITERAL_for);
				global_ident();
				astFactory.addASTChild(currentAST, returnAST);
				match(SEMI);
				inverse_attr_AST = (AST)currentAST.root;
				inverse_attr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INVERSE_ATTR,"INVERSE_ATTR")).add(inverse_attr_AST));
				currentAST.root = inverse_attr_AST;
				currentAST.child = inverse_attr_AST!=null &&inverse_attr_AST.getFirstChild()!=null ?
					inverse_attr_AST.getFirstChild() : inverse_attr_AST;
				currentAST.advanceChildToEnd();
				inverse_attr_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_60);
		}
		returnAST = inverse_attr_AST;
	}
	
/**** special rule ****/
	public final void global_ident() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST global_ident_AST = null;
		Token  nid1 = null;
		AST nid1_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		Token  nid4 = null;
		AST nid4_AST = null;
		Token  nid5 = null;
		AST nid5_AST = null;
		Token  nid6 = null;
		AST nid6_AST = null;
		Token  nid7 = null;
		AST nid7_AST = null;
		Token  nid8 = null;
		AST nid8_AST = null;
		Token  nid9 = null;
		AST nid9_AST = null;
		Token  nid10 = null;
		AST nid10_AST = null;
		Token  nid11 = null;
		AST nid11_AST = null;
		Token  nid12 = null;
		AST nid12_AST = null;
		Token  nid13 = null;
		AST nid13_AST = null;
		Token  nid14 = null;
		AST nid14_AST = null;
		Token  nid15 = null;
		AST nid15_AST = null;
		Token  nid16 = null;
		AST nid16_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			{
				AST tmp205_AST = null;
				tmp205_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp205_AST);
				match(IDENT);
				global_ident_AST = (AST)currentAST.root;
				global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case CONSTANT_IDENT:
			{
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				astFactory.addASTChild(currentAST, nid1_AST);
				match(CONSTANT_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid1_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case FUNCTION_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(FUNCTION_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case PROCEDURE_IDENT:
			{
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				astFactory.addASTChild(currentAST, nid4_AST);
				match(PROCEDURE_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid4_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case PARAMETER_IDENT:
			{
				nid5 = LT(1);
				nid5_AST = astFactory.create(nid5);
				astFactory.addASTChild(currentAST, nid5_AST);
				match(PARAMETER_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid5_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case SCHEMA_IDENT:
			{
				nid6 = LT(1);
				nid6_AST = astFactory.create(nid6);
				astFactory.addASTChild(currentAST, nid6_AST);
				match(SCHEMA_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid6_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_IDENT:
			{
				nid7 = LT(1);
				nid7_AST = astFactory.create(nid7);
				astFactory.addASTChild(currentAST, nid7_AST);
				match(TYPE_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid7_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case VARIABLE_IDENT:
			{
				nid8 = LT(1);
				nid8_AST = astFactory.create(nid8);
				astFactory.addASTChild(currentAST, nid8_AST);
				match(VARIABLE_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid8_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case ENUMERATION_IDENT:
			{
				nid9 = LT(1);
				nid9_AST = astFactory.create(nid9);
				astFactory.addASTChild(currentAST, nid9_AST);
				match(ENUMERATION_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid9_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case ATTRIBUTE_IDENT:
			{
				nid10 = LT(1);
				nid10_AST = astFactory.create(nid10);
				astFactory.addASTChild(currentAST, nid10_AST);
				match(ATTRIBUTE_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid10_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_ATTR_IDENT:
			{
				nid11 = LT(1);
				nid11_AST = astFactory.create(nid11);
				astFactory.addASTChild(currentAST, nid11_AST);
				match(ENTITY_ATTR_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid11_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_ATTR_IDENT:
			{
				nid12 = LT(1);
				nid12_AST = astFactory.create(nid12);
				astFactory.addASTChild(currentAST, nid12_AST);
				match(TYPE_ATTR_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid12_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_VAR_IDENT:
			{
				nid13 = LT(1);
				nid13_AST = astFactory.create(nid13);
				astFactory.addASTChild(currentAST, nid13_AST);
				match(ENTITY_VAR_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid13_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_VAR_IDENT:
			{
				nid14 = LT(1);
				nid14_AST = astFactory.create(nid14);
				astFactory.addASTChild(currentAST, nid14_AST);
				match(TYPE_VAR_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid14_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_PARAM_IDENT:
			{
				nid15 = LT(1);
				nid15_AST = astFactory.create(nid15);
				astFactory.addASTChild(currentAST, nid15_AST);
				match(ENTITY_PARAM_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid15_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_PARAM_IDENT:
			{
				nid16 = LT(1);
				nid16_AST = astFactory.create(nid16);
				astFactory.addASTChild(currentAST, nid16_AST);
				match(TYPE_PARAM_IDENT);
				global_ident_AST = (AST)currentAST.root;
				nid16_AST.setType(IDENT); global_ident_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(global_ident_AST));
				currentAST.root = global_ident_AST;
				currentAST.child = global_ident_AST!=null &&global_ident_AST.getFirstChild()!=null ?
					global_ident_AST.getFirstChild() : global_ident_AST;
				currentAST.advanceChildToEnd();
				global_ident_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_61);
		}
		returnAST = global_ident_AST;
	}
	
	public final void unique_rule() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unique_rule_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT||LA(1)==LITERAL_self))&&( isFirst )) {
				{
				switch ( LA(1)) {
				case IDENT:
				{
					AST tmp206_AST = null;
					tmp206_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp206_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case COLON:
					{
						AST tmp207_AST = null;
						tmp207_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp207_AST);
						match(COLON);
						referenced_attribute();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case COMMA:
					case SEMI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case LITERAL_self:
				{
					qualified_attribute();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				_loop35640:
				do {
					if ((LA(1)==COMMA)) {
						AST tmp208_AST = null;
						tmp208_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp208_AST);
						match(COMMA);
						referenced_attribute();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35640;
					}
					
				} while (true);
				}
				unique_rule_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_43.member(LA(1)))) {
				{
				if ((LA(1)==IDENT)) {
					label();
					astFactory.addASTChild(currentAST, returnAST);
					match(COLON);
				}
				else if ((_tokenSet_43.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				referenced_attribute();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35643:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						referenced_attribute();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35643;
					}
					
				} while (true);
				}
				unique_rule_AST = (AST)currentAST.root;
				unique_rule_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNIQUE_RULE,"UNIQUE_RULE")).add(unique_rule_AST));
				currentAST.root = unique_rule_AST;
				currentAST.child = unique_rule_AST!=null &&unique_rule_AST.getFirstChild()!=null ?
					unique_rule_AST.getFirstChild() : unique_rule_AST;
				currentAST.advanceChildToEnd();
				unique_rule_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = unique_rule_AST;
	}
	
	public final void referenced_attribute() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST referenced_attribute_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			{
				attribute_ref();
				astFactory.addASTChild(currentAST, returnAST);
				referenced_attribute_AST = (AST)currentAST.root;
				referenced_attribute_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REFERENCED_ATTRIBUTE,"REFERENCED_ATTRIBUTE")).add(referenced_attribute_AST));
				currentAST.root = referenced_attribute_AST;
				currentAST.child = referenced_attribute_AST!=null &&referenced_attribute_AST.getFirstChild()!=null ?
					referenced_attribute_AST.getFirstChild() : referenced_attribute_AST;
				currentAST.advanceChildToEnd();
				referenced_attribute_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_self:
			{
				qualified_attribute();
				astFactory.addASTChild(currentAST, returnAST);
				referenced_attribute_AST = (AST)currentAST.root;
				referenced_attribute_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REFERENCED_ATTRIBUTE,"REFERENCED_ATTRIBUTE")).add(referenced_attribute_AST));
				currentAST.root = referenced_attribute_AST;
				currentAST.child = referenced_attribute_AST!=null &&referenced_attribute_AST.getFirstChild()!=null ?
					referenced_attribute_AST.getFirstChild() : referenced_attribute_AST;
				currentAST.advanceChildToEnd();
				referenced_attribute_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					AST tmp211_AST = null;
					tmp211_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp211_AST);
					match(IDENT);
					referenced_attribute_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_62);
		}
		returnAST = referenced_attribute_AST;
	}
	
	public final void attribute_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_ref_AST = null;
		Token  nid1 = null;
		AST nid1_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ATTRIBUTE_IDENT:
			{
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				astFactory.addASTChild(currentAST, nid1_AST);
				match(ATTRIBUTE_IDENT);
				attribute_ref_AST = (AST)currentAST.root;
				nid1_AST.setType(IDENT); attribute_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(attribute_ref_AST));
				currentAST.root = attribute_ref_AST;
				currentAST.child = attribute_ref_AST!=null &&attribute_ref_AST.getFirstChild()!=null ?
					attribute_ref_AST.getFirstChild() : attribute_ref_AST;
				currentAST.advanceChildToEnd();
				attribute_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_ATTR_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_ATTR_IDENT);
				attribute_ref_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); attribute_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(attribute_ref_AST));
				currentAST.root = attribute_ref_AST;
				currentAST.child = attribute_ref_AST!=null &&attribute_ref_AST.getFirstChild()!=null ?
					attribute_ref_AST.getFirstChild() : attribute_ref_AST;
				currentAST.advanceChildToEnd();
				attribute_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_ATTR_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_ATTR_IDENT);
				attribute_ref_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); attribute_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE_REF,"ATTRIBUTE_REF")).add(attribute_ref_AST));
				currentAST.root = attribute_ref_AST;
				currentAST.child = attribute_ref_AST!=null &&attribute_ref_AST.getFirstChild()!=null ?
					attribute_ref_AST.getFirstChild() : attribute_ref_AST;
				currentAST.advanceChildToEnd();
				attribute_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = attribute_ref_AST;
	}
	
	public final void entity_constructor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_constructor_AST = null;
		
		try {      // for error handling
			entity_ref();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case CONSTANT_IDENT:
			case ENTITY_IDENT:
			case FUNCTION_IDENT:
			case PARAMETER_IDENT:
			case TYPE_IDENT:
			case VARIABLE_IDENT:
			case ENUMERATION_IDENT:
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LPAREN:
			case PLUS:
			case MINUS:
			case LBRACK:
			case IDENT:
			case LITERAL_const_e:
			case LITERAL_pi:
			case LITERAL_self:
			case QUESTION:
			case STAR:
			case LITERAL_abs:
			case LITERAL_acos:
			case LITERAL_asin:
			case LITERAL_atan:
			case LITERAL_blength:
			case LITERAL_cos:
			case LITERAL_exists:
			case LITERAL_exp:
			case LITERAL_format:
			case LITERAL_hibound:
			case LITERAL_hiindex:
			case LITERAL_length:
			case LITERAL_lobound:
			case LITERAL_loindex:
			case LITERAL_log:
			case 256:
			case 257:
			case LITERAL_nvl:
			case LITERAL_odd:
			case LITERAL_rolesof:
			case LITERAL_sin:
			case LITERAL_sizeof:
			case LITERAL_sqrt:
			case LITERAL_tan:
			case LITERAL_typeof:
			case LITERAL_usedin:
			case LITERAL_value:
			case LITERAL_value_in:
			case LITERAL_value_unique:
			case LCURLY:
			case INT:
			case STRING:
			case LITERAL_false:
			case LITERAL_true:
			case LITERAL_unknown:
			case LITERAL_query:
			case LITERAL_not:
			{
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35648:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						expression();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35648;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			entity_constructor_AST = (AST)currentAST.root;
			entity_constructor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_CONSTRUCTOR,"ENTITY_CONSTRUCTOR")).add(entity_constructor_AST));
			currentAST.root = entity_constructor_AST;
			currentAST.child = entity_constructor_AST!=null &&entity_constructor_AST.getFirstChild()!=null ?
				entity_constructor_AST.getFirstChild() : entity_constructor_AST;
			currentAST.advanceChildToEnd();
			entity_constructor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = entity_constructor_AST;
	}
	
	public final void enumeration_reference() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_reference_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				AST tmp215_AST = null;
				tmp215_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp215_AST);
				match(IDENT);
				{
				switch ( LA(1)) {
				case DOT:
				{
					AST tmp216_AST = null;
					tmp216_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp216_AST);
					match(DOT);
					AST tmp217_AST = null;
					tmp217_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp217_AST);
					match(IDENT);
					break;
				}
				case COMMA:
				case RPAREN:
				case PLUS:
				case MINUS:
				case LITERAL_or:
				case LITERAL_xor:
				case RBRACK:
				case COLON:
				case LITERAL_of:
				case SEMI:
				case STAR:
				case DOUBLESTAR:
				case LITERAL_then:
				case LITERAL_to:
				case LITERAL_by:
				case RCURLY:
				case LT:
				case LE:
				case DIVSIGN:
				case LITERAL_div:
				case LITERAL_mod:
				case LITERAL_and:
				case DOUBLEBAR:
				case BAR:
				case GT:
				case GE:
				case LTGT:
				case ASSIGN:
				case COLLTGT:
				case COLEQCOL:
				case LITERAL_in:
				case LITERAL_like:
				case LITERAL_until:
				case LITERAL_while:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				enumeration_reference_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_63.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case TYPE_IDENT:
				case TYPE_ATTR_IDENT:
				case TYPE_VAR_IDENT:
				case TYPE_PARAM_IDENT:
				{
					type_ref();
					astFactory.addASTChild(currentAST, returnAST);
					match(DOT);
					break;
				}
				case ENUMERATION_IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				enumeration_ref();
				astFactory.addASTChild(currentAST, returnAST);
				enumeration_reference_AST = (AST)currentAST.root;
				enumeration_reference_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENUMERATION_REFERENCE,"ENUMERATION_REFERENCE")).add(enumeration_reference_AST));
				currentAST.root = enumeration_reference_AST;
				currentAST.child = enumeration_reference_AST!=null &&enumeration_reference_AST.getFirstChild()!=null ?
					enumeration_reference_AST.getFirstChild() : enumeration_reference_AST;
				currentAST.advanceChildToEnd();
				enumeration_reference_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = enumeration_reference_AST;
	}
	
	public final void type_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		Token  nid4 = null;
		AST nid4_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TYPE_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(TYPE_IDENT);
				type_ref_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); type_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_REF,"TYPE_REF")).add(type_ref_AST));
				currentAST.root = type_ref_AST;
				currentAST.child = type_ref_AST!=null &&type_ref_AST.getFirstChild()!=null ?
					type_ref_AST.getFirstChild() : type_ref_AST;
				currentAST.advanceChildToEnd();
				type_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_ATTR_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(TYPE_ATTR_IDENT);
				type_ref_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); type_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_REF,"TYPE_REF")).add(type_ref_AST));
				currentAST.root = type_ref_AST;
				currentAST.child = type_ref_AST!=null &&type_ref_AST.getFirstChild()!=null ?
					type_ref_AST.getFirstChild() : type_ref_AST;
				currentAST.advanceChildToEnd();
				type_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_VAR_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_VAR_IDENT);
				type_ref_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); type_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_REF,"TYPE_REF")).add(type_ref_AST));
				currentAST.root = type_ref_AST;
				currentAST.child = type_ref_AST!=null &&type_ref_AST.getFirstChild()!=null ?
					type_ref_AST.getFirstChild() : type_ref_AST;
				currentAST.advanceChildToEnd();
				type_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_PARAM_IDENT:
			{
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				astFactory.addASTChild(currentAST, nid4_AST);
				match(TYPE_PARAM_IDENT);
				type_ref_AST = (AST)currentAST.root;
				nid4_AST.setType(IDENT); type_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_REF,"TYPE_REF")).add(type_ref_AST));
				currentAST.root = type_ref_AST;
				currentAST.child = type_ref_AST!=null &&type_ref_AST.getFirstChild()!=null ?
					type_ref_AST.getFirstChild() : type_ref_AST;
				currentAST.advanceChildToEnd();
				type_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_64);
		}
		returnAST = type_ref_AST;
	}
	
	public final void enumeration_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(ENUMERATION_IDENT);
			enumeration_ref_AST = (AST)currentAST.root;
			nid_AST.setType(IDENT); enumeration_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENUMERATION_REF,"ENUMERATION_REF")).add(enumeration_ref_AST));
			currentAST.root = enumeration_ref_AST;
			currentAST.child = enumeration_ref_AST!=null &&enumeration_ref_AST.getFirstChild()!=null ?
				enumeration_ref_AST.getFirstChild() : enumeration_ref_AST;
			currentAST.advanceChildToEnd();
			enumeration_ref_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = enumeration_ref_AST;
	}
	
	public final void escape_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST escape_stmt_AST = null;
		
		try {      // for error handling
			match(LITERAL_escape);
			match(SEMI);
			escape_stmt_AST = (AST)currentAST.root;
			escape_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ESCAPE_STMT,"ESCAPE_STMT")).add(escape_stmt_AST));
			currentAST.root = escape_stmt_AST;
			currentAST.child = escape_stmt_AST!=null &&escape_stmt_AST.getFirstChild()!=null ?
				escape_stmt_AST.getFirstChild() : escape_stmt_AST;
			currentAST.advanceChildToEnd();
			escape_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = escape_stmt_AST;
	}
	
	public final void rel_op_extended() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_op_extended_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LT:
			case LE:
			case GT:
			case GE:
			case LTGT:
			case ASSIGN:
			case COLLTGT:
			case COLEQCOL:
			{
				rel_op();
				astFactory.addASTChild(currentAST, returnAST);
				rel_op_extended_AST = (AST)currentAST.root;
				rel_op_extended_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP_EXTENDED,"REL_OP_EXTENDED")).add(rel_op_extended_AST));
				currentAST.root = rel_op_extended_AST;
				currentAST.child = rel_op_extended_AST!=null &&rel_op_extended_AST.getFirstChild()!=null ?
					rel_op_extended_AST.getFirstChild() : rel_op_extended_AST;
				currentAST.advanceChildToEnd();
				rel_op_extended_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_in:
			{
				AST tmp221_AST = null;
				tmp221_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp221_AST);
				match(LITERAL_in);
				rel_op_extended_AST = (AST)currentAST.root;
				rel_op_extended_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP_EXTENDED,"REL_OP_EXTENDED")).add(rel_op_extended_AST));
				currentAST.root = rel_op_extended_AST;
				currentAST.child = rel_op_extended_AST!=null &&rel_op_extended_AST.getFirstChild()!=null ?
					rel_op_extended_AST.getFirstChild() : rel_op_extended_AST;
				currentAST.advanceChildToEnd();
				rel_op_extended_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_like:
			{
				AST tmp222_AST = null;
				tmp222_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp222_AST);
				match(LITERAL_like);
				rel_op_extended_AST = (AST)currentAST.root;
				rel_op_extended_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP_EXTENDED,"REL_OP_EXTENDED")).add(rel_op_extended_AST));
				currentAST.root = rel_op_extended_AST;
				currentAST.child = rel_op_extended_AST!=null &&rel_op_extended_AST.getFirstChild()!=null ?
					rel_op_extended_AST.getFirstChild() : rel_op_extended_AST;
				currentAST.advanceChildToEnd();
				rel_op_extended_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = rel_op_extended_AST;
	}
	
	public final void factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST factor_AST = null;
		
		try {      // for error handling
			simple_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case DOUBLESTAR:
			{
				match(DOUBLESTAR);
				simple_factor();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COMMA:
			case RPAREN:
			case PLUS:
			case MINUS:
			case LITERAL_or:
			case LITERAL_xor:
			case RBRACK:
			case COLON:
			case LITERAL_of:
			case SEMI:
			case STAR:
			case LITERAL_then:
			case LITERAL_to:
			case LITERAL_by:
			case RCURLY:
			case LT:
			case LE:
			case DIVSIGN:
			case LITERAL_div:
			case LITERAL_mod:
			case LITERAL_and:
			case DOUBLEBAR:
			case BAR:
			case GT:
			case GE:
			case LTGT:
			case ASSIGN:
			case COLLTGT:
			case COLEQCOL:
			case LITERAL_in:
			case LITERAL_like:
			case LITERAL_until:
			case LITERAL_while:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			factor_AST = (AST)currentAST.root;
			factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FACTOR,"FACTOR")).add(factor_AST));
			currentAST.root = factor_AST;
			currentAST.child = factor_AST!=null &&factor_AST.getFirstChild()!=null ?
				factor_AST.getFirstChild() : factor_AST;
			currentAST.advanceChildToEnd();
			factor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_65);
		}
		returnAST = factor_AST;
	}
	
	public final void simple_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_factor_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LBRACK:
			{
				aggregate_initializer();
				astFactory.addASTChild(currentAST, returnAST);
				simple_factor_AST = (AST)currentAST.root;
				simple_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_FACTOR,"SIMPLE_FACTOR")).add(simple_factor_AST));
				currentAST.root = simple_factor_AST;
				currentAST.child = simple_factor_AST!=null &&simple_factor_AST.getFirstChild()!=null ?
					simple_factor_AST.getFirstChild() : simple_factor_AST;
				currentAST.advanceChildToEnd();
				simple_factor_AST = (AST)currentAST.root;
				break;
			}
			case LCURLY:
			{
				interval();
				astFactory.addASTChild(currentAST, returnAST);
				simple_factor_AST = (AST)currentAST.root;
				simple_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_FACTOR,"SIMPLE_FACTOR")).add(simple_factor_AST));
				currentAST.root = simple_factor_AST;
				currentAST.child = simple_factor_AST!=null &&simple_factor_AST.getFirstChild()!=null ?
					simple_factor_AST.getFirstChild() : simple_factor_AST;
				currentAST.advanceChildToEnd();
				simple_factor_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_query:
			{
				query_expression();
				astFactory.addASTChild(currentAST, returnAST);
				simple_factor_AST = (AST)currentAST.root;
				simple_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_FACTOR,"SIMPLE_FACTOR")).add(simple_factor_AST));
				currentAST.root = simple_factor_AST;
				currentAST.child = simple_factor_AST!=null &&simple_factor_AST.getFirstChild()!=null ?
					simple_factor_AST.getFirstChild() : simple_factor_AST;
				currentAST.advanceChildToEnd();
				simple_factor_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==PLUS||LA(1)==MINUS||LA(1)==LITERAL_not))&&( isFirst )) {
					unary_op();
					astFactory.addASTChild(currentAST, returnAST);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						AST tmp224_AST = null;
						tmp224_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp224_AST);
						match(LPAREN);
						expression();
						astFactory.addASTChild(currentAST, returnAST);
						AST tmp225_AST = null;
						tmp225_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp225_AST);
						match(RPAREN);
						break;
					}
					case CONSTANT_IDENT:
					case ENTITY_IDENT:
					case FUNCTION_IDENT:
					case PARAMETER_IDENT:
					case VARIABLE_IDENT:
					case ATTRIBUTE_IDENT:
					case ENTITY_ATTR_IDENT:
					case TYPE_ATTR_IDENT:
					case ENTITY_VAR_IDENT:
					case TYPE_VAR_IDENT:
					case ENTITY_PARAM_IDENT:
					case TYPE_PARAM_IDENT:
					case IDENT:
					case LITERAL_const_e:
					case LITERAL_pi:
					case LITERAL_self:
					case QUESTION:
					case STAR:
					case LITERAL_abs:
					case LITERAL_acos:
					case LITERAL_asin:
					case LITERAL_atan:
					case LITERAL_blength:
					case LITERAL_cos:
					case LITERAL_exists:
					case LITERAL_exp:
					case LITERAL_format:
					case LITERAL_hibound:
					case LITERAL_hiindex:
					case LITERAL_length:
					case LITERAL_lobound:
					case LITERAL_loindex:
					case LITERAL_log:
					case 256:
					case 257:
					case LITERAL_nvl:
					case LITERAL_odd:
					case LITERAL_rolesof:
					case LITERAL_sin:
					case LITERAL_sizeof:
					case LITERAL_sqrt:
					case LITERAL_tan:
					case LITERAL_typeof:
					case LITERAL_usedin:
					case LITERAL_value:
					case LITERAL_value_in:
					case LITERAL_value_unique:
					case INT:
					case STRING:
					case LITERAL_false:
					case LITERAL_true:
					case LITERAL_unknown:
					{
						primary();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					simple_factor_AST = (AST)currentAST.root;
				}
				else if (((LA(1)==LPAREN))&&( isFirst )) {
					AST tmp226_AST = null;
					tmp226_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp226_AST);
					match(LPAREN);
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp227_AST = null;
					tmp227_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp227_AST);
					match(RPAREN);
					simple_factor_AST = (AST)currentAST.root;
				}
				else if (((_tokenSet_66.member(LA(1))))&&( isFirst )) {
					literal();
					astFactory.addASTChild(currentAST, returnAST);
					simple_factor_AST = (AST)currentAST.root;
				}
				else if ((((LA(1) >= LITERAL_const_e && LA(1) <= STAR)))&&( isFirst )) {
					built_in_constant();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop35832:
					do {
						if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop35832;
						}
						
					} while (true);
					}
					simple_factor_AST = (AST)currentAST.root;
				}
				else if ((((LA(1) >= LITERAL_abs && LA(1) <= LITERAL_value_unique)))&&( isFirst )) {
					built_in_function();
					astFactory.addASTChild(currentAST, returnAST);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						actual_parameter_list();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case COMMA:
					case RPAREN:
					case PLUS:
					case MINUS:
					case LITERAL_or:
					case LITERAL_xor:
					case LBRACK:
					case RBRACK:
					case COLON:
					case LITERAL_of:
					case SEMI:
					case STAR:
					case DOT:
					case DOUBLESTAR:
					case BACKSLASH:
					case LITERAL_then:
					case LITERAL_to:
					case LITERAL_by:
					case RCURLY:
					case LT:
					case LE:
					case DIVSIGN:
					case LITERAL_div:
					case LITERAL_mod:
					case LITERAL_and:
					case DOUBLEBAR:
					case BAR:
					case GT:
					case GE:
					case LTGT:
					case ASSIGN:
					case COLLTGT:
					case COLEQCOL:
					case LITERAL_in:
					case LITERAL_like:
					case LITERAL_until:
					case LITERAL_while:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					_loop35835:
					do {
						if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop35835;
						}
						
					} while (true);
					}
					simple_factor_AST = (AST)currentAST.root;
				}
				else if (((LA(1)==IDENT))&&( isFirst )) {
					AST tmp228_AST = null;
					tmp228_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp228_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						AST tmp229_AST = null;
						tmp229_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp229_AST);
						match(LPAREN);
						{
						switch ( LA(1)) {
						case CONSTANT_IDENT:
						case ENTITY_IDENT:
						case FUNCTION_IDENT:
						case PARAMETER_IDENT:
						case TYPE_IDENT:
						case VARIABLE_IDENT:
						case ENUMERATION_IDENT:
						case ATTRIBUTE_IDENT:
						case ENTITY_ATTR_IDENT:
						case TYPE_ATTR_IDENT:
						case ENTITY_VAR_IDENT:
						case TYPE_VAR_IDENT:
						case ENTITY_PARAM_IDENT:
						case TYPE_PARAM_IDENT:
						case LPAREN:
						case PLUS:
						case MINUS:
						case LBRACK:
						case IDENT:
						case LITERAL_const_e:
						case LITERAL_pi:
						case LITERAL_self:
						case QUESTION:
						case STAR:
						case LITERAL_abs:
						case LITERAL_acos:
						case LITERAL_asin:
						case LITERAL_atan:
						case LITERAL_blength:
						case LITERAL_cos:
						case LITERAL_exists:
						case LITERAL_exp:
						case LITERAL_format:
						case LITERAL_hibound:
						case LITERAL_hiindex:
						case LITERAL_length:
						case LITERAL_lobound:
						case LITERAL_loindex:
						case LITERAL_log:
						case 256:
						case 257:
						case LITERAL_nvl:
						case LITERAL_odd:
						case LITERAL_rolesof:
						case LITERAL_sin:
						case LITERAL_sizeof:
						case LITERAL_sqrt:
						case LITERAL_tan:
						case LITERAL_typeof:
						case LITERAL_usedin:
						case LITERAL_value:
						case LITERAL_value_in:
						case LITERAL_value_unique:
						case LCURLY:
						case INT:
						case STRING:
						case LITERAL_false:
						case LITERAL_true:
						case LITERAL_unknown:
						case LITERAL_query:
						case LITERAL_not:
						{
							expression();
							astFactory.addASTChild(currentAST, returnAST);
							{
							_loop35839:
							do {
								if ((LA(1)==COMMA)) {
									AST tmp230_AST = null;
									tmp230_AST = astFactory.create(LT(1));
									astFactory.addASTChild(currentAST, tmp230_AST);
									match(COMMA);
									expression();
									astFactory.addASTChild(currentAST, returnAST);
								}
								else {
									break _loop35839;
								}
								
							} while (true);
							}
							break;
						}
						case RPAREN:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						AST tmp231_AST = null;
						tmp231_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp231_AST);
						match(RPAREN);
						break;
					}
					case COMMA:
					case RPAREN:
					case PLUS:
					case MINUS:
					case LITERAL_or:
					case LITERAL_xor:
					case LBRACK:
					case RBRACK:
					case COLON:
					case LITERAL_of:
					case SEMI:
					case STAR:
					case DOT:
					case DOUBLESTAR:
					case BACKSLASH:
					case LITERAL_then:
					case LITERAL_to:
					case LITERAL_by:
					case RCURLY:
					case LT:
					case LE:
					case DIVSIGN:
					case LITERAL_div:
					case LITERAL_mod:
					case LITERAL_and:
					case DOUBLEBAR:
					case BAR:
					case GT:
					case GE:
					case LTGT:
					case ASSIGN:
					case COLLTGT:
					case COLEQCOL:
					case LITERAL_in:
					case LITERAL_like:
					case LITERAL_until:
					case LITERAL_while:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					if ((LA(1)==DOT)) {
						AST tmp232_AST = null;
						tmp232_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp232_AST);
						match(DOT);
						AST tmp233_AST = null;
						tmp233_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp233_AST);
						match(IDENT);
					}
					else if ((_tokenSet_0.member(LA(1)))) {
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					
					}
					{
					_loop35842:
					do {
						if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop35842;
						}
						
					} while (true);
					}
					simple_factor_AST = (AST)currentAST.root;
				}
				else if (((_tokenSet_67.member(LA(1))))&&( LA(2)==LPAREN )) {
					entity_constructor();
					astFactory.addASTChild(currentAST, returnAST);
					simple_factor_AST = (AST)currentAST.root;
					simple_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_FACTOR,"SIMPLE_FACTOR")).add(simple_factor_AST));
					currentAST.root = simple_factor_AST;
					currentAST.child = simple_factor_AST!=null &&simple_factor_AST.getFirstChild()!=null ?
						simple_factor_AST.getFirstChild() : simple_factor_AST;
					currentAST.advanceChildToEnd();
					simple_factor_AST = (AST)currentAST.root;
				}
				else if (((_tokenSet_68.member(LA(1))))&&( LA(1)==ENUMERATION_IDENT||LA(3)==ENUMERATION_IDENT )) {
					enumeration_reference();
					astFactory.addASTChild(currentAST, returnAST);
					simple_factor_AST = (AST)currentAST.root;
					simple_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_FACTOR,"SIMPLE_FACTOR")).add(simple_factor_AST));
					currentAST.root = simple_factor_AST;
					currentAST.child = simple_factor_AST!=null &&simple_factor_AST.getFirstChild()!=null ?
						simple_factor_AST.getFirstChild() : simple_factor_AST;
					currentAST.advanceChildToEnd();
					simple_factor_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_69.member(LA(1)))) {
					{
					{
					switch ( LA(1)) {
					case PLUS:
					case MINUS:
					case LITERAL_not:
					{
						unary_op();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case CONSTANT_IDENT:
					case ENTITY_IDENT:
					case FUNCTION_IDENT:
					case PARAMETER_IDENT:
					case VARIABLE_IDENT:
					case ATTRIBUTE_IDENT:
					case ENTITY_ATTR_IDENT:
					case TYPE_ATTR_IDENT:
					case ENTITY_VAR_IDENT:
					case TYPE_VAR_IDENT:
					case ENTITY_PARAM_IDENT:
					case TYPE_PARAM_IDENT:
					case LPAREN:
					case IDENT:
					case LITERAL_const_e:
					case LITERAL_pi:
					case LITERAL_self:
					case QUESTION:
					case STAR:
					case LITERAL_abs:
					case LITERAL_acos:
					case LITERAL_asin:
					case LITERAL_atan:
					case LITERAL_blength:
					case LITERAL_cos:
					case LITERAL_exists:
					case LITERAL_exp:
					case LITERAL_format:
					case LITERAL_hibound:
					case LITERAL_hiindex:
					case LITERAL_length:
					case LITERAL_lobound:
					case LITERAL_loindex:
					case LITERAL_log:
					case 256:
					case 257:
					case LITERAL_nvl:
					case LITERAL_odd:
					case LITERAL_rolesof:
					case LITERAL_sin:
					case LITERAL_sizeof:
					case LITERAL_sqrt:
					case LITERAL_tan:
					case LITERAL_typeof:
					case LITERAL_usedin:
					case LITERAL_value:
					case LITERAL_value_in:
					case LITERAL_value_unique:
					case INT:
					case STRING:
					case LITERAL_false:
					case LITERAL_true:
					case LITERAL_unknown:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						match(LPAREN);
						expression();
						astFactory.addASTChild(currentAST, returnAST);
						match(RPAREN);
						break;
					}
					case CONSTANT_IDENT:
					case ENTITY_IDENT:
					case FUNCTION_IDENT:
					case PARAMETER_IDENT:
					case VARIABLE_IDENT:
					case ATTRIBUTE_IDENT:
					case ENTITY_ATTR_IDENT:
					case TYPE_ATTR_IDENT:
					case ENTITY_VAR_IDENT:
					case TYPE_VAR_IDENT:
					case ENTITY_PARAM_IDENT:
					case TYPE_PARAM_IDENT:
					case IDENT:
					case LITERAL_const_e:
					case LITERAL_pi:
					case LITERAL_self:
					case QUESTION:
					case STAR:
					case LITERAL_abs:
					case LITERAL_acos:
					case LITERAL_asin:
					case LITERAL_atan:
					case LITERAL_blength:
					case LITERAL_cos:
					case LITERAL_exists:
					case LITERAL_exp:
					case LITERAL_format:
					case LITERAL_hibound:
					case LITERAL_hiindex:
					case LITERAL_length:
					case LITERAL_lobound:
					case LITERAL_loindex:
					case LITERAL_log:
					case 256:
					case 257:
					case LITERAL_nvl:
					case LITERAL_odd:
					case LITERAL_rolesof:
					case LITERAL_sin:
					case LITERAL_sizeof:
					case LITERAL_sqrt:
					case LITERAL_tan:
					case LITERAL_typeof:
					case LITERAL_usedin:
					case LITERAL_value:
					case LITERAL_value_in:
					case LITERAL_value_unique:
					case INT:
					case STRING:
					case LITERAL_false:
					case LITERAL_true:
					case LITERAL_unknown:
					{
						primary();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					}
					simple_factor_AST = (AST)currentAST.root;
					simple_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_FACTOR,"SIMPLE_FACTOR")).add(simple_factor_AST));
					currentAST.root = simple_factor_AST;
					currentAST.child = simple_factor_AST!=null &&simple_factor_AST.getFirstChild()!=null ?
						simple_factor_AST.getFirstChild() : simple_factor_AST;
					currentAST.advanceChildToEnd();
					simple_factor_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = simple_factor_AST;
	}
	
	public final void formal_parameter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST formal_parameter_AST = null;
		
		try {      // for error handling
			parameter_id();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35660:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					parameter_id();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35660;
				}
				
			} while (true);
			}
			match(COLON);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			formal_parameter_AST = (AST)currentAST.root;
			formal_parameter_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FORMAL_PARAMETER,"FORMAL_PARAMETER")).add(formal_parameter_AST));
			currentAST.root = formal_parameter_AST;
			currentAST.child = formal_parameter_AST!=null &&formal_parameter_AST.getFirstChild()!=null ?
				formal_parameter_AST.getFirstChild() : formal_parameter_AST;
			currentAST.advanceChildToEnd();
			formal_parameter_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_70);
		}
		returnAST = formal_parameter_AST;
	}
	
	public final void parameter_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case PARAMETER_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(PARAMETER_IDENT);
				parameter_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); parameter_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_ID,"PARAMETER_ID")).add(parameter_id_AST));
				currentAST.root = parameter_id_AST;
				currentAST.child = parameter_id_AST!=null &&parameter_id_AST.getFirstChild()!=null ?
					parameter_id_AST.getFirstChild() : parameter_id_AST;
				currentAST.advanceChildToEnd();
				parameter_id_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_PARAM_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_PARAM_IDENT);
				parameter_id_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); parameter_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_ID,"PARAMETER_ID")).add(parameter_id_AST));
				currentAST.root = parameter_id_AST;
				currentAST.child = parameter_id_AST!=null &&parameter_id_AST.getFirstChild()!=null ?
					parameter_id_AST.getFirstChild() : parameter_id_AST;
				currentAST.advanceChildToEnd();
				parameter_id_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_PARAM_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_PARAM_IDENT);
				parameter_id_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); parameter_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_ID,"PARAMETER_ID")).add(parameter_id_AST));
				currentAST.root = parameter_id_AST;
				currentAST.child = parameter_id_AST!=null &&parameter_id_AST.getFirstChild()!=null ?
					parameter_id_AST.getFirstChild() : parameter_id_AST;
				currentAST.advanceChildToEnd();
				parameter_id_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(IDENT);
					addId(id.getText(), PARAMETER_IDENT);
					parameter_id_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_30);
		}
		returnAST = parameter_id_AST;
	}
	
	public final void function_call() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_call_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_abs:
			case LITERAL_acos:
			case LITERAL_asin:
			case LITERAL_atan:
			case LITERAL_blength:
			case LITERAL_cos:
			case LITERAL_exists:
			case LITERAL_exp:
			case LITERAL_format:
			case LITERAL_hibound:
			case LITERAL_hiindex:
			case LITERAL_length:
			case LITERAL_lobound:
			case LITERAL_loindex:
			case LITERAL_log:
			case 256:
			case 257:
			case LITERAL_nvl:
			case LITERAL_odd:
			case LITERAL_rolesof:
			case LITERAL_sin:
			case LITERAL_sizeof:
			case LITERAL_sqrt:
			case LITERAL_tan:
			case LITERAL_typeof:
			case LITERAL_usedin:
			case LITERAL_value:
			case LITERAL_value_in:
			case LITERAL_value_unique:
			{
				built_in_function();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case FUNCTION_IDENT:
			{
				function_ref();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				actual_parameter_list();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COMMA:
			case RPAREN:
			case PLUS:
			case MINUS:
			case LITERAL_or:
			case LITERAL_xor:
			case LBRACK:
			case RBRACK:
			case COLON:
			case LITERAL_of:
			case SEMI:
			case STAR:
			case DOT:
			case DOUBLESTAR:
			case BACKSLASH:
			case LITERAL_then:
			case LITERAL_to:
			case LITERAL_by:
			case RCURLY:
			case LT:
			case LE:
			case DIVSIGN:
			case LITERAL_div:
			case LITERAL_mod:
			case LITERAL_and:
			case DOUBLEBAR:
			case BAR:
			case GT:
			case GE:
			case LTGT:
			case ASSIGN:
			case COLLTGT:
			case COLEQCOL:
			case LITERAL_in:
			case LITERAL_like:
			case LITERAL_until:
			case LITERAL_while:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			function_call_AST = (AST)currentAST.root;
			function_call_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_CALL,"FUNCTION_CALL")).add(function_call_AST));
			currentAST.root = function_call_AST;
			currentAST.child = function_call_AST!=null &&function_call_AST.getFirstChild()!=null ?
				function_call_AST.getFirstChild() : function_call_AST;
			currentAST.advanceChildToEnd();
			function_call_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = function_call_AST;
	}
	
	public final void function_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(FUNCTION_IDENT);
			function_ref_AST = (AST)currentAST.root;
			nid_AST.setType(IDENT); function_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_REF,"FUNCTION_REF")).add(function_ref_AST));
			currentAST.root = function_ref_AST;
			currentAST.child = function_ref_AST!=null &&function_ref_AST.getFirstChild()!=null ?
				function_ref_AST.getFirstChild() : function_ref_AST;
			currentAST.advanceChildToEnd();
			function_ref_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_71);
		}
		returnAST = function_ref_AST;
	}
	
	public final void function_head() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_head_AST = null;
		
		try {      // for error handling
			match(LITERAL_function);
			function_id();
			astFactory.addASTChild(currentAST, returnAST);
			newScope();
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				formal_parameter();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35672:
				do {
					if ((LA(1)==SEMI)) {
						match(SEMI);
						formal_parameter();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35672;
					}
					
				} while (true);
				}
				match(RPAREN);
				break;
			}
			case COLON:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(COLON);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			function_head_AST = (AST)currentAST.root;
			function_head_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_HEAD,"FUNCTION_HEAD")).add(function_head_AST));
			currentAST.root = function_head_AST;
			currentAST.child = function_head_AST!=null &&function_head_AST.getFirstChild()!=null ?
				function_head_AST.getFirstChild() : function_head_AST;
			currentAST.advanceChildToEnd();
			function_head_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_34);
		}
		returnAST = function_head_AST;
	}
	
	public final void function_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				addId(id.getText(),FUNCTION_IDENT);
				function_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==FUNCTION_IDENT)) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(FUNCTION_IDENT);
				function_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); function_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_ID,"FUNCTION_ID")).add(function_id_AST));
				currentAST.root = function_id_AST;
				currentAST.child = function_id_AST!=null &&function_id_AST.getFirstChild()!=null ?
					function_id_AST.getFirstChild() : function_id_AST;
				currentAST.advanceChildToEnd();
				function_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_72);
		}
		returnAST = function_id_AST;
	}
	
	public final void general_aggregation_types() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_aggregation_types_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_array:
			{
				general_array_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = (AST)currentAST.root;
				general_aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_AGGREGATION_TYPES,"GENERAL_AGGREGATION_TYPES")).add(general_aggregation_types_AST));
				currentAST.root = general_aggregation_types_AST;
				currentAST.child = general_aggregation_types_AST!=null &&general_aggregation_types_AST.getFirstChild()!=null ?
					general_aggregation_types_AST.getFirstChild() : general_aggregation_types_AST;
				currentAST.advanceChildToEnd();
				general_aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_bag:
			{
				general_bag_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = (AST)currentAST.root;
				general_aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_AGGREGATION_TYPES,"GENERAL_AGGREGATION_TYPES")).add(general_aggregation_types_AST));
				currentAST.root = general_aggregation_types_AST;
				currentAST.child = general_aggregation_types_AST!=null &&general_aggregation_types_AST.getFirstChild()!=null ?
					general_aggregation_types_AST.getFirstChild() : general_aggregation_types_AST;
				currentAST.advanceChildToEnd();
				general_aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_list:
			{
				general_list_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = (AST)currentAST.root;
				general_aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_AGGREGATION_TYPES,"GENERAL_AGGREGATION_TYPES")).add(general_aggregation_types_AST));
				currentAST.root = general_aggregation_types_AST;
				currentAST.child = general_aggregation_types_AST!=null &&general_aggregation_types_AST.getFirstChild()!=null ?
					general_aggregation_types_AST.getFirstChild() : general_aggregation_types_AST;
				currentAST.advanceChildToEnd();
				general_aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_set:
			{
				general_set_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = (AST)currentAST.root;
				general_aggregation_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_AGGREGATION_TYPES,"GENERAL_AGGREGATION_TYPES")).add(general_aggregation_types_AST));
				currentAST.root = general_aggregation_types_AST;
				currentAST.child = general_aggregation_types_AST!=null &&general_aggregation_types_AST.getFirstChild()!=null ?
					general_aggregation_types_AST.getFirstChild() : general_aggregation_types_AST;
				currentAST.advanceChildToEnd();
				general_aggregation_types_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = general_aggregation_types_AST;
	}
	
	public final void generic_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generic_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_generic);
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				type_label();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case RPAREN:
			case SEMI:
			case COLEQ:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			generic_type_AST = (AST)currentAST.root;
			generic_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERIC_TYPE,"GENERAL_TYPE")).add(generic_type_AST));
			currentAST.root = generic_type_AST;
			currentAST.child = generic_type_AST!=null &&generic_type_AST.getFirstChild()!=null ?
				generic_type_AST.getFirstChild() : generic_type_AST;
			currentAST.advanceChildToEnd();
			generic_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = generic_type_AST;
	}
	
	public final void generic_entity_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generic_entity_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_generic_entity);
			generic_entity_type_AST = (AST)currentAST.root;
			generic_entity_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERIC_ENTITY_TYPE,"GENERIC_ENTITY_TYPE")).add(generic_entity_type_AST));
			currentAST.root = generic_entity_type_AST;
			currentAST.child = generic_entity_type_AST!=null &&generic_entity_type_AST.getFirstChild()!=null ?
				generic_entity_type_AST.getFirstChild() : generic_entity_type_AST;
			currentAST.advanceChildToEnd();
			generic_entity_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = generic_entity_type_AST;
	}
	
	public final void general_array_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_array_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_array);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			{
			switch ( LA(1)) {
			case LITERAL_optional:
			{
				AST tmp249_AST = null;
				tmp249_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp249_AST);
				match(LITERAL_optional);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_unique:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_unique:
			{
				AST tmp250_AST = null;
				tmp250_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp250_AST);
				match(LITERAL_unique);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_array_type_AST = (AST)currentAST.root;
			general_array_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_ARRAY_TYPE,"GENERAL_ARRAY_TYPE")).add(general_array_type_AST));
			currentAST.root = general_array_type_AST;
			currentAST.child = general_array_type_AST!=null &&general_array_type_AST.getFirstChild()!=null ?
				general_array_type_AST.getFirstChild() : general_array_type_AST;
			currentAST.advanceChildToEnd();
			general_array_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = general_array_type_AST;
	}
	
	public final void general_bag_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_bag_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_bag);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_bag_type_AST = (AST)currentAST.root;
			general_bag_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_BAG_TYPE,"GENERAL_BAG_TYPE")).add(general_bag_type_AST));
			currentAST.root = general_bag_type_AST;
			currentAST.child = general_bag_type_AST!=null &&general_bag_type_AST.getFirstChild()!=null ?
				general_bag_type_AST.getFirstChild() : general_bag_type_AST;
			currentAST.advanceChildToEnd();
			general_bag_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = general_bag_type_AST;
	}
	
	public final void general_list_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_list_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_list);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			{
			switch ( LA(1)) {
			case LITERAL_unique:
			{
				AST tmp255_AST = null;
				tmp255_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp255_AST);
				match(LITERAL_unique);
				break;
			}
			case ENTITY_IDENT:
			case TYPE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case LITERAL_aggregate:
			case IDENT:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_list_type_AST = (AST)currentAST.root;
			general_list_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_LIST_TYPE,"GENERAL_LIST_TYPE")).add(general_list_type_AST));
			currentAST.root = general_list_type_AST;
			currentAST.child = general_list_type_AST!=null &&general_list_type_AST.getFirstChild()!=null ?
				general_list_type_AST.getFirstChild() : general_list_type_AST;
			currentAST.advanceChildToEnd();
			general_list_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = general_list_type_AST;
	}
	
	public final void general_set_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_set_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_set);
			{
			switch ( LA(1)) {
			case LBRACK:
			{
				bound_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_of:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_of);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_set_type_AST = (AST)currentAST.root;
			general_set_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERAL_SET_TYPE,"GENERAL_SET_TYPE")).add(general_set_type_AST));
			currentAST.root = general_set_type_AST;
			currentAST.child = general_set_type_AST!=null &&general_set_type_AST.getFirstChild()!=null ?
				general_set_type_AST.getFirstChild() : general_set_type_AST;
			currentAST.advanceChildToEnd();
			general_set_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = general_set_type_AST;
	}
	
	public final void parameter_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case PARAMETER_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(PARAMETER_IDENT);
				parameter_ref_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); parameter_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_REF,"PARAMETER_REF")).add(parameter_ref_AST));
				currentAST.root = parameter_ref_AST;
				currentAST.child = parameter_ref_AST!=null &&parameter_ref_AST.getFirstChild()!=null ?
					parameter_ref_AST.getFirstChild() : parameter_ref_AST;
				currentAST.advanceChildToEnd();
				parameter_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_PARAM_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_PARAM_IDENT);
				parameter_ref_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); parameter_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_REF,"PARAMETER_REF")).add(parameter_ref_AST));
				currentAST.root = parameter_ref_AST;
				currentAST.child = parameter_ref_AST!=null &&parameter_ref_AST.getFirstChild()!=null ?
					parameter_ref_AST.getFirstChild() : parameter_ref_AST;
				currentAST.advanceChildToEnd();
				parameter_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_PARAM_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_PARAM_IDENT);
				parameter_ref_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); parameter_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_REF,"PARAMETER_REF")).add(parameter_ref_AST));
				currentAST.root = parameter_ref_AST;
				currentAST.child = parameter_ref_AST!=null &&parameter_ref_AST.getFirstChild()!=null ?
					parameter_ref_AST.getFirstChild() : parameter_ref_AST;
				currentAST.advanceChildToEnd();
				parameter_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = parameter_ref_AST;
	}
	
	public final void variable_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case VARIABLE_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(VARIABLE_IDENT);
				variable_ref_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); variable_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_REF,"VARIABLE_REF")).add(variable_ref_AST));
				currentAST.root = variable_ref_AST;
				currentAST.child = variable_ref_AST!=null &&variable_ref_AST.getFirstChild()!=null ?
					variable_ref_AST.getFirstChild() : variable_ref_AST;
				currentAST.advanceChildToEnd();
				variable_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_VAR_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ENTITY_VAR_IDENT);
				variable_ref_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); variable_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_REF,"VARIABLE_REF")).add(variable_ref_AST));
				currentAST.root = variable_ref_AST;
				currentAST.child = variable_ref_AST!=null &&variable_ref_AST.getFirstChild()!=null ?
					variable_ref_AST.getFirstChild() : variable_ref_AST;
				currentAST.advanceChildToEnd();
				variable_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_VAR_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(TYPE_VAR_IDENT);
				variable_ref_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); variable_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_REF,"VARIABLE_REF")).add(variable_ref_AST));
				currentAST.root = variable_ref_AST;
				currentAST.child = variable_ref_AST!=null &&variable_ref_AST.getFirstChild()!=null ?
					variable_ref_AST.getFirstChild() : variable_ref_AST;
				currentAST.advanceChildToEnd();
				variable_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = variable_ref_AST;
	}
	
	public final void if_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST if_stmt_AST = null;
		
		try {      // for error handling
			match(LITERAL_if);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_then);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35694:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35694;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_else:
			{
				else_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end_if:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_end_if);
			match(SEMI);
			if_stmt_AST = (AST)currentAST.root;
			if_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IF_STMT,"IF_STMT")).add(if_stmt_AST));
			currentAST.root = if_stmt_AST;
			currentAST.child = if_stmt_AST!=null &&if_stmt_AST.getFirstChild()!=null ?
				if_stmt_AST.getFirstChild() : if_stmt_AST;
			currentAST.advanceChildToEnd();
			if_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = if_stmt_AST;
	}
	
	public final void else_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST else_clause_AST = null;
		
		try {      // for error handling
			match(LITERAL_else);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35698:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35698;
				}
				
			} while (true);
			}
			else_clause_AST = (AST)currentAST.root;
			else_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELSE_CLAUSE,"ELSE_CLAUSE")).add(else_clause_AST));
			currentAST.root = else_clause_AST;
			currentAST.child = else_clause_AST!=null &&else_clause_AST.getFirstChild()!=null ?
				else_clause_AST.getFirstChild() : else_clause_AST;
			currentAST.advanceChildToEnd();
			else_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_73);
		}
		returnAST = else_clause_AST;
	}
	
	public final void increment() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST increment_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			increment_AST = (AST)currentAST.root;
			increment_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INCREMENT,"INCREMENT")).add(increment_AST));
			currentAST.root = increment_AST;
			currentAST.child = increment_AST!=null &&increment_AST.getFirstChild()!=null ?
				increment_AST.getFirstChild() : increment_AST;
			currentAST.advanceChildToEnd();
			increment_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_74);
		}
		returnAST = increment_AST;
	}
	
	public final void increment_control() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST increment_control_AST = null;
		
		try {      // for error handling
			variable_id();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLEQ);
			bound_1();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_to);
			bound_2();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_by:
			{
				match(LITERAL_by);
				increment();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_until:
			case LITERAL_while:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			increment_control_AST = (AST)currentAST.root;
			increment_control_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INCREMENT_CONTROL,"INCREMENT_CONTROL")).add(increment_control_AST));
			currentAST.root = increment_control_AST;
			currentAST.child = increment_control_AST!=null &&increment_control_AST.getFirstChild()!=null ?
				increment_control_AST.getFirstChild() : increment_control_AST;
			currentAST.advanceChildToEnd();
			increment_control_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_74);
		}
		returnAST = increment_control_AST;
	}
	
	public final void index() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			index_AST = (AST)currentAST.root;
			index_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INDEX,"INDEX")).add(index_AST));
			currentAST.root = index_AST;
			currentAST.child = index_AST!=null &&index_AST.getFirstChild()!=null ?
				index_AST.getFirstChild() : index_AST;
			currentAST.advanceChildToEnd();
			index_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_75);
		}
		returnAST = index_AST;
	}
	
	public final void index_1() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_1_AST = null;
		
		try {      // for error handling
			index();
			astFactory.addASTChild(currentAST, returnAST);
			index_1_AST = (AST)currentAST.root;
			index_1_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INDEX_1,"INDEX_1")).add(index_1_AST));
			currentAST.root = index_1_AST;
			currentAST.child = index_1_AST!=null &&index_1_AST.getFirstChild()!=null ?
				index_1_AST.getFirstChild() : index_1_AST;
			currentAST.advanceChildToEnd();
			index_1_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_75);
		}
		returnAST = index_1_AST;
	}
	
	public final void index_2() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_2_AST = null;
		
		try {      // for error handling
			index();
			astFactory.addASTChild(currentAST, returnAST);
			index_2_AST = (AST)currentAST.root;
			index_2_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INDEX_2,"INDEX_2")).add(index_2_AST));
			currentAST.root = index_2_AST;
			currentAST.child = index_2_AST!=null &&index_2_AST.getFirstChild()!=null ?
				index_2_AST.getFirstChild() : index_2_AST;
			currentAST.advanceChildToEnd();
			index_2_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_76);
		}
		returnAST = index_2_AST;
	}
	
	public final void index_qualifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_qualifier_AST = null;
		
		try {      // for error handling
			match(LBRACK);
			index_1();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				index_2();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case RBRACK:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RBRACK);
			index_qualifier_AST = (AST)currentAST.root;
			index_qualifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INDEX_QUALIFIER,"INDEX_QUALIFIER")).add(index_qualifier_AST));
			currentAST.root = index_qualifier_AST;
			currentAST.child = index_qualifier_AST!=null &&index_qualifier_AST.getFirstChild()!=null ?
				index_qualifier_AST.getFirstChild() : index_qualifier_AST;
			currentAST.advanceChildToEnd();
			index_qualifier_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = index_qualifier_AST;
	}
	
	public final void integer_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integer_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_integer);
			integer_type_AST = (AST)currentAST.root;
			integer_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTEGER_TYPE,"INTEGER_TYPE")).add(integer_type_AST));
			currentAST.root = integer_type_AST;
			currentAST.child = integer_type_AST!=null &&integer_type_AST.getFirstChild()!=null ?
				integer_type_AST.getFirstChild() : integer_type_AST;
			currentAST.advanceChildToEnd();
			integer_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = integer_type_AST;
	}
	
	public final void interval() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_AST = null;
		
		try {      // for error handling
			match(LCURLY);
			interval_low();
			astFactory.addASTChild(currentAST, returnAST);
			interval_op();
			astFactory.addASTChild(currentAST, returnAST);
			interval_item();
			astFactory.addASTChild(currentAST, returnAST);
			interval_op();
			astFactory.addASTChild(currentAST, returnAST);
			interval_high();
			astFactory.addASTChild(currentAST, returnAST);
			match(RCURLY);
			interval_AST = (AST)currentAST.root;
			interval_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERVAL,"INTERVAL")).add(interval_AST));
			currentAST.root = interval_AST;
			currentAST.child = interval_AST!=null &&interval_AST.getFirstChild()!=null ?
				interval_AST.getFirstChild() : interval_AST;
			currentAST.advanceChildToEnd();
			interval_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = interval_AST;
	}
	
	public final void interval_low() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_low_AST = null;
		
		try {      // for error handling
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			interval_low_AST = (AST)currentAST.root;
			interval_low_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERVAL_LOW,"INTERVAL_LOW")).add(interval_low_AST));
			currentAST.root = interval_low_AST;
			currentAST.child = interval_low_AST!=null &&interval_low_AST.getFirstChild()!=null ?
				interval_low_AST.getFirstChild() : interval_low_AST;
			currentAST.advanceChildToEnd();
			interval_low_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_77);
		}
		returnAST = interval_low_AST;
	}
	
	public final void interval_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LT:
			{
				AST tmp272_AST = null;
				tmp272_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp272_AST);
				match(LT);
				interval_op_AST = (AST)currentAST.root;
				interval_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERVAL_OP,"INTERVAL_OP")).add(interval_op_AST));
				currentAST.root = interval_op_AST;
				currentAST.child = interval_op_AST!=null &&interval_op_AST.getFirstChild()!=null ?
					interval_op_AST.getFirstChild() : interval_op_AST;
				currentAST.advanceChildToEnd();
				interval_op_AST = (AST)currentAST.root;
				break;
			}
			case LE:
			{
				AST tmp273_AST = null;
				tmp273_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp273_AST);
				match(LE);
				interval_op_AST = (AST)currentAST.root;
				interval_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERVAL_OP,"INTERVAL_OP")).add(interval_op_AST));
				currentAST.root = interval_op_AST;
				currentAST.child = interval_op_AST!=null &&interval_op_AST.getFirstChild()!=null ?
					interval_op_AST.getFirstChild() : interval_op_AST;
				currentAST.advanceChildToEnd();
				interval_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = interval_op_AST;
	}
	
	public final void interval_item() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_item_AST = null;
		
		try {      // for error handling
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			interval_item_AST = (AST)currentAST.root;
			interval_item_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERVAL_ITEM,"INTERVAL_ITEM")).add(interval_item_AST));
			currentAST.root = interval_item_AST;
			currentAST.child = interval_item_AST!=null &&interval_item_AST.getFirstChild()!=null ?
				interval_item_AST.getFirstChild() : interval_item_AST;
			currentAST.advanceChildToEnd();
			interval_item_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_77);
		}
		returnAST = interval_item_AST;
	}
	
	public final void interval_high() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_high_AST = null;
		
		try {      // for error handling
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			interval_high_AST = (AST)currentAST.root;
			interval_high_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERVAL_HIGH,"INTERVAL_HIGH")).add(interval_high_AST));
			currentAST.root = interval_high_AST;
			currentAST.child = interval_high_AST!=null &&interval_high_AST.getFirstChild()!=null ?
				interval_high_AST.getFirstChild() : interval_high_AST;
			currentAST.advanceChildToEnd();
			interval_high_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_78);
		}
		returnAST = interval_high_AST;
	}
	
	public final void literal() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST literal_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  f = null;
		AST f_AST = null;
		AST ll_AST = null;
		Token  sl = null;
		AST sl_AST = null;
		
				boolean fl=false; 
			
		
		try {      // for error handling
			switch ( LA(1)) {
			case INT:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				match(INT);
				{
				switch ( LA(1)) {
				case FLOAT:
				{
					f = LT(1);
					f_AST = astFactory.create(f);
					match(FLOAT);
					fl=true;
					break;
				}
				case COMMA:
				case RPAREN:
				case PLUS:
				case MINUS:
				case LITERAL_or:
				case LITERAL_xor:
				case RBRACK:
				case COLON:
				case LITERAL_of:
				case SEMI:
				case STAR:
				case DOUBLESTAR:
				case LITERAL_then:
				case LITERAL_to:
				case LITERAL_by:
				case RCURLY:
				case LT:
				case LE:
				case DIVSIGN:
				case LITERAL_div:
				case LITERAL_mod:
				case LITERAL_and:
				case DOUBLEBAR:
				case BAR:
				case GT:
				case GE:
				case LTGT:
				case ASSIGN:
				case COLLTGT:
				case COLEQCOL:
				case LITERAL_in:
				case LITERAL_like:
				case LITERAL_until:
				case LITERAL_while:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				literal_AST = (AST)currentAST.root;
				if (fl) {
								f_AST.setText(i.getText()+f.getText());
								literal_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LITERAL,"LITERAL")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REAL,"REAL")).add(f_AST))));
								}
							  else literal_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LITERAL,"LITERAL")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTEGER,"INTEGER")).add(i_AST))));
							
				currentAST.root = literal_AST;
				currentAST.child = literal_AST!=null &&literal_AST.getFirstChild()!=null ?
					literal_AST.getFirstChild() : literal_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case LITERAL_false:
			case LITERAL_true:
			case LITERAL_unknown:
			{
				logical();
				ll_AST = (AST)returnAST;
				literal_AST = (AST)currentAST.root;
				literal_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LITERAL,"LITERAL")).add(ll_AST));
				currentAST.root = literal_AST;
				currentAST.child = literal_AST!=null &&literal_AST.getFirstChild()!=null ?
					literal_AST.getFirstChild() : literal_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case STRING:
			{
				sl = LT(1);
				sl_AST = astFactory.create(sl);
				match(STRING);
				literal_AST = (AST)currentAST.root;
				literal_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LITERAL,"LITERAL")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STRING,"STRING")).add(sl_AST))));
				currentAST.root = literal_AST;
				currentAST.child = literal_AST!=null &&literal_AST.getFirstChild()!=null ?
					literal_AST.getFirstChild() : literal_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = literal_AST;
	}
	
	public final void logical() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_false:
			{
				AST tmp274_AST = null;
				tmp274_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp274_AST);
				match(LITERAL_false);
				logical_AST = (AST)currentAST.root;
				logical_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL,"LOGICAL")).add(logical_AST));
				currentAST.root = logical_AST;
				currentAST.child = logical_AST!=null &&logical_AST.getFirstChild()!=null ?
					logical_AST.getFirstChild() : logical_AST;
				currentAST.advanceChildToEnd();
				logical_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_true:
			{
				AST tmp275_AST = null;
				tmp275_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp275_AST);
				match(LITERAL_true);
				logical_AST = (AST)currentAST.root;
				logical_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL,"LOGICAL")).add(logical_AST));
				currentAST.root = logical_AST;
				currentAST.child = logical_AST!=null &&logical_AST.getFirstChild()!=null ?
					logical_AST.getFirstChild() : logical_AST;
				currentAST.advanceChildToEnd();
				logical_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_unknown:
			{
				AST tmp276_AST = null;
				tmp276_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp276_AST);
				match(LITERAL_unknown);
				logical_AST = (AST)currentAST.root;
				logical_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL,"LOGICAL")).add(logical_AST));
				currentAST.root = logical_AST;
				currentAST.child = logical_AST!=null &&logical_AST.getFirstChild()!=null ?
					logical_AST.getFirstChild() : logical_AST;
				currentAST.advanceChildToEnd();
				logical_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = logical_AST;
	}
	
	public final void local_variable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST local_variable_AST = null;
		
		try {      // for error handling
			variable_id();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35724:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					variable_id();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35724;
				}
				
			} while (true);
			}
			match(COLON);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COLEQ:
			{
				match(COLEQ);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			local_variable_AST = (AST)currentAST.root;
			local_variable_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOCAL_VARIABLE,"LOCAL_VARIABLE")).add(local_variable_AST));
			currentAST.root = local_variable_AST;
			currentAST.child = local_variable_AST!=null &&local_variable_AST.getFirstChild()!=null ?
				local_variable_AST.getFirstChild() : local_variable_AST;
			currentAST.advanceChildToEnd();
			local_variable_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_79);
		}
		returnAST = local_variable_AST;
	}
	
	public final void logical_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_logical);
			logical_type_AST = (AST)currentAST.root;
			logical_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_TYPE,"LOGICAL_TYPE")).add(logical_type_AST));
			currentAST.root = logical_type_AST;
			currentAST.child = logical_type_AST!=null &&logical_type_AST.getFirstChild()!=null ?
				logical_type_AST.getFirstChild() : logical_type_AST;
			currentAST.advanceChildToEnd();
			logical_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = logical_type_AST;
	}
	
	public final void multiplication_like_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiplication_like_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case STAR:
			{
				AST tmp282_AST = null;
				tmp282_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp282_AST);
				match(STAR);
				multiplication_like_op_AST = (AST)currentAST.root;
				multiplication_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTIPLICATION_LIKE_OP,"MULTIPLICATION_LIKE_OP")).add(multiplication_like_op_AST));
				currentAST.root = multiplication_like_op_AST;
				currentAST.child = multiplication_like_op_AST!=null &&multiplication_like_op_AST.getFirstChild()!=null ?
					multiplication_like_op_AST.getFirstChild() : multiplication_like_op_AST;
				currentAST.advanceChildToEnd();
				multiplication_like_op_AST = (AST)currentAST.root;
				break;
			}
			case DIVSIGN:
			{
				AST tmp283_AST = null;
				tmp283_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp283_AST);
				match(DIVSIGN);
				multiplication_like_op_AST = (AST)currentAST.root;
				multiplication_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTIPLICATION_LIKE_OP,"MULTIPLICATION_LIKE_OP")).add(multiplication_like_op_AST));
				currentAST.root = multiplication_like_op_AST;
				currentAST.child = multiplication_like_op_AST!=null &&multiplication_like_op_AST.getFirstChild()!=null ?
					multiplication_like_op_AST.getFirstChild() : multiplication_like_op_AST;
				currentAST.advanceChildToEnd();
				multiplication_like_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_div:
			{
				AST tmp284_AST = null;
				tmp284_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp284_AST);
				match(LITERAL_div);
				multiplication_like_op_AST = (AST)currentAST.root;
				multiplication_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTIPLICATION_LIKE_OP,"MULTIPLICATION_LIKE_OP")).add(multiplication_like_op_AST));
				currentAST.root = multiplication_like_op_AST;
				currentAST.child = multiplication_like_op_AST!=null &&multiplication_like_op_AST.getFirstChild()!=null ?
					multiplication_like_op_AST.getFirstChild() : multiplication_like_op_AST;
				currentAST.advanceChildToEnd();
				multiplication_like_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_mod:
			{
				AST tmp285_AST = null;
				tmp285_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp285_AST);
				match(LITERAL_mod);
				multiplication_like_op_AST = (AST)currentAST.root;
				multiplication_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTIPLICATION_LIKE_OP,"MULTIPLICATION_LIKE_OP")).add(multiplication_like_op_AST));
				currentAST.root = multiplication_like_op_AST;
				currentAST.child = multiplication_like_op_AST!=null &&multiplication_like_op_AST.getFirstChild()!=null ?
					multiplication_like_op_AST.getFirstChild() : multiplication_like_op_AST;
				currentAST.advanceChildToEnd();
				multiplication_like_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_and:
			{
				AST tmp286_AST = null;
				tmp286_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp286_AST);
				match(LITERAL_and);
				multiplication_like_op_AST = (AST)currentAST.root;
				multiplication_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTIPLICATION_LIKE_OP,"MULTIPLICATION_LIKE_OP")).add(multiplication_like_op_AST));
				currentAST.root = multiplication_like_op_AST;
				currentAST.child = multiplication_like_op_AST!=null &&multiplication_like_op_AST.getFirstChild()!=null ?
					multiplication_like_op_AST.getFirstChild() : multiplication_like_op_AST;
				currentAST.advanceChildToEnd();
				multiplication_like_op_AST = (AST)currentAST.root;
				break;
			}
			case DOUBLEBAR:
			{
				AST tmp287_AST = null;
				tmp287_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp287_AST);
				match(DOUBLEBAR);
				multiplication_like_op_AST = (AST)currentAST.root;
				multiplication_like_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTIPLICATION_LIKE_OP,"MULTIPLICATION_LIKE_OP")).add(multiplication_like_op_AST));
				currentAST.root = multiplication_like_op_AST;
				currentAST.child = multiplication_like_op_AST!=null &&multiplication_like_op_AST.getFirstChild()!=null ?
					multiplication_like_op_AST.getFirstChild() : multiplication_like_op_AST;
				currentAST.advanceChildToEnd();
				multiplication_like_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = multiplication_like_op_AST;
	}
	
	public final void null_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST null_stmt_AST = null;
		
		try {      // for error handling
			match(SEMI);
			null_stmt_AST = (AST)currentAST.root;
			null_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(NULL_STMT,"NULL_STMT")).add(null_stmt_AST));
			currentAST.root = null_stmt_AST;
			currentAST.child = null_stmt_AST!=null &&null_stmt_AST.getFirstChild()!=null ?
				null_stmt_AST.getFirstChild() : null_stmt_AST;
			currentAST.advanceChildToEnd();
			null_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = null_stmt_AST;
	}
	
	public final void number_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_number);
			number_type_AST = (AST)currentAST.root;
			number_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(NUMBER_TYPE,"NUMBER_TYPE")).add(number_type_AST));
			currentAST.root = number_type_AST;
			currentAST.child = number_type_AST!=null &&number_type_AST.getFirstChild()!=null ?
				number_type_AST.getFirstChild() : number_type_AST;
			currentAST.advanceChildToEnd();
			number_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = number_type_AST;
	}
	
	public final void one_of() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_of_AST = null;
		
		try {      // for error handling
			match(LITERAL_oneof);
			match(LPAREN);
			supertype_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35736:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					supertype_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35736;
				}
				
			} while (true);
			}
			match(RPAREN);
			one_of_AST = (AST)currentAST.root;
			one_of_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ONE_OF,"ONE_OF")).add(one_of_AST));
			currentAST.root = one_of_AST;
			currentAST.child = one_of_AST!=null &&one_of_AST.getFirstChild()!=null ?
				one_of_AST.getFirstChild() : one_of_AST;
			currentAST.advanceChildToEnd();
			one_of_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_80);
		}
		returnAST = one_of_AST;
	}
	
	public final void population() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST population_AST = null;
		
		try {      // for error handling
			entity_ref();
			astFactory.addASTChild(currentAST, returnAST);
			population_AST = (AST)currentAST.root;
			population_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(POPULATION,"POPULATION")).add(population_AST));
			currentAST.root = population_AST;
			currentAST.child = population_AST!=null &&population_AST.getFirstChild()!=null ?
				population_AST.getFirstChild() : population_AST;
			currentAST.advanceChildToEnd();
			population_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = population_AST;
	}
	
	public final void precision_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST precision_spec_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			precision_spec_AST = (AST)currentAST.root;
			precision_spec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRECISION_SPEC,"PRECISION_SPEC")).add(precision_spec_AST));
			currentAST.root = precision_spec_AST;
			currentAST.child = precision_spec_AST!=null &&precision_spec_AST.getFirstChild()!=null ?
				precision_spec_AST.getFirstChild() : precision_spec_AST;
			currentAST.advanceChildToEnd();
			precision_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_81);
		}
		returnAST = precision_spec_AST;
	}
	
	public final void primary() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primary_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case INT:
			case STRING:
			case LITERAL_false:
			case LITERAL_true:
			case LITERAL_unknown:
			{
				literal();
				astFactory.addASTChild(currentAST, returnAST);
				primary_AST = (AST)currentAST.root;
				primary_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRIMARY,"PRIMARY")).add(primary_AST));
				currentAST.root = primary_AST;
				currentAST.child = primary_AST!=null &&primary_AST.getFirstChild()!=null ?
					primary_AST.getFirstChild() : primary_AST;
				currentAST.advanceChildToEnd();
				primary_AST = (AST)currentAST.root;
				break;
			}
			case CONSTANT_IDENT:
			case ENTITY_IDENT:
			case FUNCTION_IDENT:
			case PARAMETER_IDENT:
			case VARIABLE_IDENT:
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT:
			case IDENT:
			case LITERAL_const_e:
			case LITERAL_pi:
			case LITERAL_self:
			case QUESTION:
			case STAR:
			case LITERAL_abs:
			case LITERAL_acos:
			case LITERAL_asin:
			case LITERAL_atan:
			case LITERAL_blength:
			case LITERAL_cos:
			case LITERAL_exists:
			case LITERAL_exp:
			case LITERAL_format:
			case LITERAL_hibound:
			case LITERAL_hiindex:
			case LITERAL_length:
			case LITERAL_lobound:
			case LITERAL_loindex:
			case LITERAL_log:
			case 256:
			case 257:
			case LITERAL_nvl:
			case LITERAL_odd:
			case LITERAL_rolesof:
			case LITERAL_sin:
			case LITERAL_sizeof:
			case LITERAL_sqrt:
			case LITERAL_tan:
			case LITERAL_typeof:
			case LITERAL_usedin:
			case LITERAL_value:
			case LITERAL_value_in:
			case LITERAL_value_unique:
			{
				qualifiable_factor();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35744:
				do {
					if ((LA(1)==LBRACK||LA(1)==DOT||LA(1)==BACKSLASH)) {
						qualifier();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35744;
					}
					
				} while (true);
				}
				primary_AST = (AST)currentAST.root;
				primary_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRIMARY,"PRIMARY")).add(primary_AST));
				currentAST.root = primary_AST;
				currentAST.child = primary_AST!=null &&primary_AST.getFirstChild()!=null ?
					primary_AST.getFirstChild() : primary_AST;
				currentAST.advanceChildToEnd();
				primary_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = primary_AST;
	}
	
	public final void qualifiable_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifiable_factor_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				AST tmp294_AST = null;
				tmp294_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp294_AST);
				match(IDENT);
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					actual_parameter_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				case RPAREN:
				case PLUS:
				case MINUS:
				case LITERAL_or:
				case LITERAL_xor:
				case LBRACK:
				case RBRACK:
				case COLON:
				case LITERAL_of:
				case SEMI:
				case STAR:
				case DOT:
				case DOUBLESTAR:
				case BACKSLASH:
				case LITERAL_then:
				case LITERAL_to:
				case LITERAL_by:
				case RCURLY:
				case LT:
				case LE:
				case DIVSIGN:
				case LITERAL_div:
				case LITERAL_mod:
				case LITERAL_and:
				case DOUBLEBAR:
				case BAR:
				case GT:
				case GE:
				case LTGT:
				case ASSIGN:
				case COLLTGT:
				case COLEQCOL:
				case LITERAL_in:
				case LITERAL_like:
				case LITERAL_until:
				case LITERAL_while:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if ((((LA(1) >= LITERAL_const_e && LA(1) <= STAR)))&&( isFirst )) {
				built_in_constant();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if ((((LA(1) >= LITERAL_abs && LA(1) <= LITERAL_value_unique)))&&( isFirst )) {
				built_in_function();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					actual_parameter_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				case RPAREN:
				case PLUS:
				case MINUS:
				case LITERAL_or:
				case LITERAL_xor:
				case LBRACK:
				case RBRACK:
				case COLON:
				case LITERAL_of:
				case SEMI:
				case STAR:
				case DOT:
				case DOUBLESTAR:
				case BACKSLASH:
				case LITERAL_then:
				case LITERAL_to:
				case LITERAL_by:
				case RCURLY:
				case LT:
				case LE:
				case DIVSIGN:
				case LITERAL_div:
				case LITERAL_mod:
				case LITERAL_and:
				case DOUBLEBAR:
				case BAR:
				case GT:
				case GE:
				case LTGT:
				case ASSIGN:
				case COLLTGT:
				case COLEQCOL:
				case LITERAL_in:
				case LITERAL_like:
				case LITERAL_until:
				case LITERAL_while:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if (((LA(1) >= ATTRIBUTE_IDENT && LA(1) <= TYPE_ATTR_IDENT))) {
				attribute_ref();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST)currentAST.root;
				qualifiable_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIABLE_FACTOR,"QUALIFIABLE_FACTOR")).add(qualifiable_factor_AST));
				currentAST.root = qualifiable_factor_AST;
				currentAST.child = qualifiable_factor_AST!=null &&qualifiable_factor_AST.getFirstChild()!=null ?
					qualifiable_factor_AST.getFirstChild() : qualifiable_factor_AST;
				currentAST.advanceChildToEnd();
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_82.member(LA(1)))) {
				constant_factor();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST)currentAST.root;
				qualifiable_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIABLE_FACTOR,"QUALIFIABLE_FACTOR")).add(qualifiable_factor_AST));
				currentAST.root = qualifiable_factor_AST;
				currentAST.child = qualifiable_factor_AST!=null &&qualifiable_factor_AST.getFirstChild()!=null ?
					qualifiable_factor_AST.getFirstChild() : qualifiable_factor_AST;
				currentAST.advanceChildToEnd();
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_83.member(LA(1)))) {
				function_call();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST)currentAST.root;
				qualifiable_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIABLE_FACTOR,"QUALIFIABLE_FACTOR")).add(qualifiable_factor_AST));
				currentAST.root = qualifiable_factor_AST;
				currentAST.child = qualifiable_factor_AST!=null &&qualifiable_factor_AST.getFirstChild()!=null ?
					qualifiable_factor_AST.getFirstChild() : qualifiable_factor_AST;
				currentAST.advanceChildToEnd();
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_67.member(LA(1)))) {
				population();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST)currentAST.root;
				qualifiable_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIABLE_FACTOR,"QUALIFIABLE_FACTOR")).add(qualifiable_factor_AST));
				currentAST.root = qualifiable_factor_AST;
				currentAST.child = qualifiable_factor_AST!=null &&qualifiable_factor_AST.getFirstChild()!=null ?
					qualifiable_factor_AST.getFirstChild() : qualifiable_factor_AST;
				currentAST.advanceChildToEnd();
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_84.member(LA(1)))) {
				general_ref();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST)currentAST.root;
				qualifiable_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUALIFIABLE_FACTOR,"QUALIFIABLE_FACTOR")).add(qualifiable_factor_AST));
				currentAST.root = qualifiable_factor_AST;
				currentAST.child = qualifiable_factor_AST!=null &&qualifiable_factor_AST.getFirstChild()!=null ?
					qualifiable_factor_AST.getFirstChild() : qualifiable_factor_AST;
				currentAST.advanceChildToEnd();
				qualifiable_factor_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = qualifiable_factor_AST;
	}
	
	public final void procedure_call_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_call_stmt_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_insert:
			case LITERAL_remove:
			{
				built_in_procedure();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case PROCEDURE_IDENT:
			{
				procedure_ref();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				actual_parameter_list();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			procedure_call_stmt_AST = (AST)currentAST.root;
			procedure_call_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_CALL_STMT,"PROCEDURE_CALL_STMT")).add(procedure_call_stmt_AST));
			currentAST.root = procedure_call_stmt_AST;
			currentAST.child = procedure_call_stmt_AST!=null &&procedure_call_stmt_AST.getFirstChild()!=null ?
				procedure_call_stmt_AST.getFirstChild() : procedure_call_stmt_AST;
			currentAST.advanceChildToEnd();
			procedure_call_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = procedure_call_stmt_AST;
	}
	
	public final void procedure_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(PROCEDURE_IDENT);
			procedure_ref_AST = (AST)currentAST.root;
			nid_AST.setType(IDENT); procedure_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_REF,"PROCEDURE_REF")).add(procedure_ref_AST));
			currentAST.root = procedure_ref_AST;
			currentAST.child = procedure_ref_AST!=null &&procedure_ref_AST.getFirstChild()!=null ?
				procedure_ref_AST.getFirstChild() : procedure_ref_AST;
			currentAST.advanceChildToEnd();
			procedure_ref_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_85);
		}
		returnAST = procedure_ref_AST;
	}
	
	public final void procedure_head() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_head_AST = null;
		
		try {      // for error handling
			match(LITERAL_procedure);
			procedure_id();
			astFactory.addASTChild(currentAST, returnAST);
			newScope();
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				{
				switch ( LA(1)) {
				case LITERAL_var:
				{
					AST tmp298_AST = null;
					tmp298_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp298_AST);
					match(LITERAL_var);
					break;
				}
				case PARAMETER_IDENT:
				case ENTITY_PARAM_IDENT:
				case TYPE_PARAM_IDENT:
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				formal_parameter();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35757:
				do {
					if ((LA(1)==SEMI)) {
						match(SEMI);
						{
						switch ( LA(1)) {
						case LITERAL_var:
						{
							AST tmp300_AST = null;
							tmp300_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp300_AST);
							match(LITERAL_var);
							break;
						}
						case PARAMETER_IDENT:
						case ENTITY_PARAM_IDENT:
						case TYPE_PARAM_IDENT:
						case IDENT:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						formal_parameter();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35757;
					}
					
				} while (true);
				}
				match(RPAREN);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			procedure_head_AST = (AST)currentAST.root;
			procedure_head_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_HEAD,"PROCEDURE_HEAD")).add(procedure_head_AST));
			currentAST.root = procedure_head_AST;
			currentAST.child = procedure_head_AST!=null &&procedure_head_AST.getFirstChild()!=null ?
				procedure_head_AST.getFirstChild() : procedure_head_AST;
			currentAST.advanceChildToEnd();
			procedure_head_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_35);
		}
		returnAST = procedure_head_AST;
	}
	
	public final void procedure_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				addId(id.getText(),PROCEDURE_IDENT);
				procedure_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==PROCEDURE_IDENT)) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(PROCEDURE_IDENT);
				procedure_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); procedure_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_ID,"PROCEDURE_ID")).add(procedure_id_AST));
				currentAST.root = procedure_id_AST;
				currentAST.child = procedure_id_AST!=null &&procedure_id_AST.getFirstChild()!=null ?
					procedure_id_AST.getFirstChild() : procedure_id_AST;
				currentAST.advanceChildToEnd();
				procedure_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_28);
		}
		returnAST = procedure_id_AST;
	}
	
	public final void query_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST query_expression_AST = null;
		if (isFirst) newScope1();
		
		try {      // for error handling
			match(LITERAL_query);
			match(LPAREN);
			variable_id();
			astFactory.addASTChild(currentAST, returnAST);
			match(LTSTAR);
			aggregate_source();
			astFactory.addASTChild(currentAST, returnAST);
			match(BAR);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			query_expression_AST = (AST)currentAST.root;
			upScope(); 
					query_expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(QUERY_EXPRESSION,"QUERY_EXPRESSION")).add(query_expression_AST));
					
			currentAST.root = query_expression_AST;
			currentAST.child = query_expression_AST!=null &&query_expression_AST.getFirstChild()!=null ?
				query_expression_AST.getFirstChild() : query_expression_AST;
			currentAST.advanceChildToEnd();
			query_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = query_expression_AST;
	}
	
	public final void real_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST real_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_real);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				precision_spec();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				break;
			}
			case RPAREN:
			case SEMI:
			case COLEQ:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			real_type_AST = (AST)currentAST.root;
			real_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REAL_TYPE,"REAL_TYPE")).add(real_type_AST));
			currentAST.root = real_type_AST;
			currentAST.child = real_type_AST!=null &&real_type_AST.getFirstChild()!=null ?
				real_type_AST.getFirstChild() : real_type_AST;
			currentAST.advanceChildToEnd();
			real_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = real_type_AST;
	}
	
	public final void reference_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reference_clause_AST = null;
		Token  id = null;
		AST id_AST = null;
		
				ExternalId ei=null;
			
		
		try {      // for error handling
			if (((LA(1)==LITERAL_reference))&&( isFirst )) {
				AST tmp311_AST = null;
				tmp311_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp311_AST);
				match(LITERAL_reference);
				AST tmp312_AST = null;
				tmp312_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp312_AST);
				match(LITERAL_from);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					AST tmp313_AST = null;
					tmp313_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp313_AST);
					match(LPAREN);
					ei=resource_or_rename();
					astFactory.addASTChild(currentAST, returnAST);
					ei.setSchema(id.getText()); addExternal(ei);
					{
					_loop35769:
					do {
						if ((LA(1)==COMMA)) {
							AST tmp314_AST = null;
							tmp314_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp314_AST);
							match(COMMA);
							ei=resource_or_rename();
							astFactory.addASTChild(currentAST, returnAST);
							ei.setSchema(id.getText()); addExternal(ei);
						}
						else {
							break _loop35769;
						}
						
					} while (true);
					}
					AST tmp315_AST = null;
					tmp315_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp315_AST);
					match(RPAREN);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp316_AST = null;
				tmp316_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp316_AST);
				match(SEMI);
				if (ei==null) addAllReferenceExternals(id.getText());
				reference_clause_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_reference)) {
				match(LITERAL_reference);
				match(LITERAL_from);
				schema_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					match(LPAREN);
					resource_or_rename();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop35772:
					do {
						if ((LA(1)==COMMA)) {
							match(COMMA);
							resource_or_rename();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop35772;
						}
						
					} while (true);
					}
					match(RPAREN);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(SEMI);
				reference_clause_AST = (AST)currentAST.root;
				reference_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REFERENCE_CLAUSE,"REFERENCE_CLAUSE")).add(reference_clause_AST));
				currentAST.root = reference_clause_AST;
				currentAST.child = reference_clause_AST!=null &&reference_clause_AST.getFirstChild()!=null ?
					reference_clause_AST.getFirstChild() : reference_clause_AST;
				currentAST.advanceChildToEnd();
				reference_clause_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_86);
		}
		returnAST = reference_clause_AST;
	}
	
	public final ExternalId  resource_or_rename() throws RecognitionException, TokenStreamException {
		ExternalId ei;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST resource_or_rename_AST = null;
		Token  id = null;
		AST id_AST = null;
		
				ei=null;
				String s=null;
			
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				ei = new ExternalId(id.getText());
				{
				switch ( LA(1)) {
				case LITERAL_as:
				{
					AST tmp323_AST = null;
					tmp323_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp323_AST);
					match(LITERAL_as);
					s=rename_id();
					astFactory.addASTChild(currentAST, returnAST);
					ei.setRename(s);
					break;
				}
				case COMMA:
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				resource_or_rename_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_87.member(LA(1)))) {
				resource_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_as:
				{
					match(LITERAL_as);
					rename_id();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				resource_or_rename_AST = (AST)currentAST.root;
				resource_or_rename_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_OR_RENAME,"RESOURCE_OR_RENAME")).add(resource_or_rename_AST));
				currentAST.root = resource_or_rename_AST;
				currentAST.child = resource_or_rename_AST!=null &&resource_or_rename_AST.getFirstChild()!=null ?
					resource_or_rename_AST.getFirstChild() : resource_or_rename_AST;
				currentAST.advanceChildToEnd();
				resource_or_rename_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_88.member(LA(1)))) {
				global_ident();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_as:
				{
					match(LITERAL_as);
					rename_id();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				resource_or_rename_AST = (AST)currentAST.root;
				resource_or_rename_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_OR_RENAME,"RESOURCE_OR_RENAME")).add(resource_or_rename_AST));
				currentAST.root = resource_or_rename_AST;
				currentAST.child = resource_or_rename_AST!=null &&resource_or_rename_AST.getFirstChild()!=null ?
					resource_or_rename_AST.getFirstChild() : resource_or_rename_AST;
				currentAST.advanceChildToEnd();
				resource_or_rename_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = resource_or_rename_AST;
		return ei;
	}
	
	public final void schema_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_ref_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		
		try {      // for error handling
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(SCHEMA_IDENT);
			schema_ref_AST = (AST)currentAST.root;
			nid_AST.setType(IDENT); schema_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCHEMA_REF,"SCHEMA_REF")).add(schema_ref_AST));
			currentAST.root = schema_ref_AST;
			currentAST.child = schema_ref_AST!=null &&schema_ref_AST.getFirstChild()!=null ?
				schema_ref_AST.getFirstChild() : schema_ref_AST;
			currentAST.advanceChildToEnd();
			schema_ref_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_28);
		}
		returnAST = schema_ref_AST;
	}
	
	public final void rel_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LT:
			{
				AST tmp326_AST = null;
				tmp326_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp326_AST);
				match(LT);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case GT:
			{
				AST tmp327_AST = null;
				tmp327_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp327_AST);
				match(GT);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case LE:
			{
				AST tmp328_AST = null;
				tmp328_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp328_AST);
				match(LE);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case GE:
			{
				AST tmp329_AST = null;
				tmp329_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp329_AST);
				match(GE);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case LTGT:
			{
				AST tmp330_AST = null;
				tmp330_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp330_AST);
				match(LTGT);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case ASSIGN:
			{
				AST tmp331_AST = null;
				tmp331_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp331_AST);
				match(ASSIGN);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case COLLTGT:
			{
				AST tmp332_AST = null;
				tmp332_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp332_AST);
				match(COLLTGT);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			case COLEQCOL:
			{
				AST tmp333_AST = null;
				tmp333_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp333_AST);
				match(COLEQCOL);
				rel_op_AST = (AST)currentAST.root;
				rel_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REL_OP,"REL_OP")).add(rel_op_AST));
				currentAST.root = rel_op_AST;
				currentAST.child = rel_op_AST!=null &&rel_op_AST.getFirstChild()!=null ?
					rel_op_AST.getFirstChild() : rel_op_AST;
				currentAST.advanceChildToEnd();
				rel_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = rel_op_AST;
	}
	
	public final String  rename_id() throws RecognitionException, TokenStreamException {
		String s;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rename_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid1 = null;
		AST nid1_AST = null;
		Token  nid2 = null;
		AST nid2_AST = null;
		Token  nid3 = null;
		AST nid3_AST = null;
		Token  nid4 = null;
		AST nid4_AST = null;
		Token  nid5 = null;
		AST nid5_AST = null;
		s=null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			{
				id = LT(1);
				id_AST = astFactory.create(id);
				match(IDENT);
				s=id.getText();
				break;
			}
			case CONSTANT_IDENT:
			{
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				match(CONSTANT_IDENT);
				rename_id_AST = (AST)currentAST.root;
				nid1_AST.setType(IDENT); rename_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RENAME_ID,"RENAME_ID")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTANT_ID,"CONSTANT_ID")).add(nid1_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = rename_id_AST!=null &&rename_id_AST.getFirstChild()!=null ?
					rename_id_AST.getFirstChild() : rename_id_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case ENTITY_IDENT:
			{
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				match(ENTITY_IDENT);
				rename_id_AST = (AST)currentAST.root;
				nid2_AST.setType(IDENT); rename_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RENAME_ID,"RENAME_ID")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENTITY_ID,"ENTITY_ID")).add(nid2_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = rename_id_AST!=null &&rename_id_AST.getFirstChild()!=null ?
					rename_id_AST.getFirstChild() : rename_id_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case FUNCTION_IDENT:
			{
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				match(FUNCTION_IDENT);
				rename_id_AST = (AST)currentAST.root;
				nid3_AST.setType(IDENT); rename_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RENAME_ID,"RENAME_ID")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_ID,"FUNCTION_ID")).add(nid3_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = rename_id_AST!=null &&rename_id_AST.getFirstChild()!=null ?
					rename_id_AST.getFirstChild() : rename_id_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case PROCEDURE_IDENT:
			{
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				match(PROCEDURE_IDENT);
				rename_id_AST = (AST)currentAST.root;
				nid4_AST.setType(IDENT); rename_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RENAME_ID,"RENAME_ID")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_ID,"PROCEDURE_ID")).add(nid4_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = rename_id_AST!=null &&rename_id_AST.getFirstChild()!=null ?
					rename_id_AST.getFirstChild() : rename_id_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case TYPE_IDENT:
			{
				nid5 = LT(1);
				nid5_AST = astFactory.create(nid5);
				match(TYPE_IDENT);
				rename_id_AST = (AST)currentAST.root;
				nid5_AST.setType(IDENT); rename_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RENAME_ID,"RENAME_ID")).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_ID,"TYPE_ID")).add(nid5_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = rename_id_AST!=null &&rename_id_AST.getFirstChild()!=null ?
					rename_id_AST.getFirstChild() : rename_id_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = rename_id_AST;
		return s;
	}
	
	public final void repeat_control() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repeat_control_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case IDENT:
			{
				increment_control();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_until:
			case LITERAL_while:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_while:
			{
				while_control();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_until:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_until:
			{
				until_control();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			repeat_control_AST = (AST)currentAST.root;
			repeat_control_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REPEAT_CONTROL,"REPEAT_CONTROL")).add(repeat_control_AST));
			currentAST.root = repeat_control_AST;
			currentAST.child = repeat_control_AST!=null &&repeat_control_AST.getFirstChild()!=null ?
				repeat_control_AST.getFirstChild() : repeat_control_AST;
			currentAST.advanceChildToEnd();
			repeat_control_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = repeat_control_AST;
	}
	
	public final void while_control() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST while_control_AST = null;
		
		try {      // for error handling
			match(LITERAL_while);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			while_control_AST = (AST)currentAST.root;
			while_control_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WHILE_CONTROL,"WHILE_CONTROL")).add(while_control_AST));
			currentAST.root = while_control_AST;
			currentAST.child = while_control_AST!=null &&while_control_AST.getFirstChild()!=null ?
				while_control_AST.getFirstChild() : while_control_AST;
			currentAST.advanceChildToEnd();
			while_control_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_89);
		}
		returnAST = while_control_AST;
	}
	
	public final void until_control() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST until_control_AST = null;
		
		try {      // for error handling
			match(LITERAL_until);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			until_control_AST = (AST)currentAST.root;
			until_control_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNTIL_CONTROL,"UNTIL_CONTROL")).add(until_control_AST));
			currentAST.root = until_control_AST;
			currentAST.child = until_control_AST!=null &&until_control_AST.getFirstChild()!=null ?
				until_control_AST.getFirstChild() : until_control_AST;
			currentAST.advanceChildToEnd();
			until_control_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = until_control_AST;
	}
	
	public final void repeat_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repeat_stmt_AST = null;
		if (isFirst) newScope1();
		
		try {      // for error handling
			match(LITERAL_repeat);
			repeat_control();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35782:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35782;
				}
				
			} while (true);
			}
			match(LITERAL_end_repeat);
			upScope();
			match(SEMI);
			repeat_stmt_AST = (AST)currentAST.root;
			repeat_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(REPEAT_STMT,"REPEAT_STMT")).add(repeat_stmt_AST));
			currentAST.root = repeat_stmt_AST;
			currentAST.child = repeat_stmt_AST!=null &&repeat_stmt_AST.getFirstChild()!=null ?
				repeat_stmt_AST.getFirstChild() : repeat_stmt_AST;
			currentAST.advanceChildToEnd();
			repeat_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = repeat_stmt_AST;
	}
	
	public final void resource_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST resource_ref_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case CONSTANT_IDENT:
			{
				constant_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = (AST)currentAST.root;
				resource_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_REF,"RESOURCE_REF")).add(resource_ref_AST));
				currentAST.root = resource_ref_AST;
				currentAST.child = resource_ref_AST!=null &&resource_ref_AST.getFirstChild()!=null ?
					resource_ref_AST.getFirstChild() : resource_ref_AST;
				currentAST.advanceChildToEnd();
				resource_ref_AST = (AST)currentAST.root;
				break;
			}
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			{
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = (AST)currentAST.root;
				resource_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_REF,"RESOURCE_REF")).add(resource_ref_AST));
				currentAST.root = resource_ref_AST;
				currentAST.child = resource_ref_AST!=null &&resource_ref_AST.getFirstChild()!=null ?
					resource_ref_AST.getFirstChild() : resource_ref_AST;
				currentAST.advanceChildToEnd();
				resource_ref_AST = (AST)currentAST.root;
				break;
			}
			case FUNCTION_IDENT:
			{
				function_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = (AST)currentAST.root;
				resource_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_REF,"RESOURCE_REF")).add(resource_ref_AST));
				currentAST.root = resource_ref_AST;
				currentAST.child = resource_ref_AST!=null &&resource_ref_AST.getFirstChild()!=null ?
					resource_ref_AST.getFirstChild() : resource_ref_AST;
				currentAST.advanceChildToEnd();
				resource_ref_AST = (AST)currentAST.root;
				break;
			}
			case PROCEDURE_IDENT:
			{
				procedure_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = (AST)currentAST.root;
				resource_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_REF,"RESOURCE_REF")).add(resource_ref_AST));
				currentAST.root = resource_ref_AST;
				currentAST.child = resource_ref_AST!=null &&resource_ref_AST.getFirstChild()!=null ?
					resource_ref_AST.getFirstChild() : resource_ref_AST;
				currentAST.advanceChildToEnd();
				resource_ref_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_IDENT:
			case TYPE_ATTR_IDENT:
			case TYPE_VAR_IDENT:
			case TYPE_PARAM_IDENT:
			{
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = (AST)currentAST.root;
				resource_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RESOURCE_REF,"RESOURCE_REF")).add(resource_ref_AST));
				currentAST.root = resource_ref_AST;
				currentAST.child = resource_ref_AST!=null &&resource_ref_AST.getFirstChild()!=null ?
					resource_ref_AST.getFirstChild() : resource_ref_AST;
				currentAST.advanceChildToEnd();
				resource_ref_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_90);
		}
		returnAST = resource_ref_AST;
	}
	
	public final void return_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST return_stmt_AST = null;
		
		try {      // for error handling
			match(LITERAL_return);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			return_stmt_AST = (AST)currentAST.root;
			return_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RETURN_STMT,"RETURN_STMT")).add(return_stmt_AST));
			currentAST.root = return_stmt_AST;
			currentAST.child = return_stmt_AST!=null &&return_stmt_AST.getFirstChild()!=null ?
				return_stmt_AST.getFirstChild() : return_stmt_AST;
			currentAST.advanceChildToEnd();
			return_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = return_stmt_AST;
	}
	
	public final void rule_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_decl_AST = null;
		
		try {      // for error handling
			rule_head();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((_tokenSet_91.member(LA(1)))) {
				algorithm_head();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_92.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop35794:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35794;
				}
				
			} while (true);
			}
			where_clause();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_end_rule);
			upScope();
			match(SEMI);
			rule_decl_AST = (AST)currentAST.root;
			rule_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RULE_DECL,"RULE_DECL")).add(rule_decl_AST));
			currentAST.root = rule_decl_AST;
			currentAST.child = rule_decl_AST!=null &&rule_decl_AST.getFirstChild()!=null ?
				rule_decl_AST.getFirstChild() : rule_decl_AST;
			currentAST.advanceChildToEnd();
			rule_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_93);
		}
		returnAST = rule_decl_AST;
	}
	
	public final void rule_head() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_head_AST = null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_rule))&&( isFirst )) {
				AST tmp346_AST = null;
				tmp346_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp346_AST);
				match(LITERAL_rule);
				rule_id();
				astFactory.addASTChild(currentAST, returnAST);
				newScope1();
				AST tmp347_AST = null;
				tmp347_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp347_AST);
				match(LITERAL_for);
				AST tmp348_AST = null;
				tmp348_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp348_AST);
				match(LPAREN);
				AST tmp349_AST = null;
				tmp349_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp349_AST);
				match(IDENT);
				{
				_loop35797:
				do {
					if ((LA(1)==COMMA)) {
						AST tmp350_AST = null;
						tmp350_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp350_AST);
						match(COMMA);
						AST tmp351_AST = null;
						tmp351_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp351_AST);
						match(IDENT);
					}
					else {
						break _loop35797;
					}
					
				} while (true);
				}
				AST tmp352_AST = null;
				tmp352_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp352_AST);
				match(RPAREN);
				AST tmp353_AST = null;
				tmp353_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp353_AST);
				match(SEMI);
				rule_head_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_rule)) {
				match(LITERAL_rule);
				rule_id();
				astFactory.addASTChild(currentAST, returnAST);
				match(LITERAL_for);
				match(LPAREN);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop35799:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						entity_ref();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop35799;
					}
					
				} while (true);
				}
				match(RPAREN);
				match(SEMI);
				rule_head_AST = (AST)currentAST.root;
				rule_head_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RULE_HEAD,"RULE_HEAD")).add(rule_head_AST));
				currentAST.root = rule_head_AST;
				currentAST.child = rule_head_AST!=null &&rule_head_AST.getFirstChild()!=null ?
					rule_head_AST.getFirstChild() : rule_head_AST;
				currentAST.advanceChildToEnd();
				rule_head_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_91);
		}
		returnAST = rule_head_AST;
	}
	
	public final void rule_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_id_AST = null;
		
		try {      // for error handling
			AST tmp360_AST = null;
			tmp360_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp360_AST);
			match(IDENT);
			rule_id_AST = (AST)currentAST.root;
			rule_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(RULE_ID,"RULE_ID")).add(rule_id_AST));
			currentAST.root = rule_id_AST;
			currentAST.child = rule_id_AST!=null &&rule_id_AST.getFirstChild()!=null ?
				rule_id_AST.getFirstChild() : rule_id_AST;
			currentAST.advanceChildToEnd();
			rule_id_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_53);
		}
		returnAST = rule_id_AST;
	}
	
	public final String  schema_id() throws RecognitionException, TokenStreamException {
		String s;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		s=null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			{
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				schema_id_AST = (AST)currentAST.root;
				s=id.getText(); addId(s,SCHEMA_IDENT); schema_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCHEMA_ID,"SCHEMA_ID")).add(schema_id_AST));
				currentAST.root = schema_id_AST;
				currentAST.child = schema_id_AST!=null &&schema_id_AST.getFirstChild()!=null ?
					schema_id_AST.getFirstChild() : schema_id_AST;
				currentAST.advanceChildToEnd();
				schema_id_AST = (AST)currentAST.root;
				break;
			}
			case SCHEMA_IDENT:
			{
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(SCHEMA_IDENT);
				schema_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); schema_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCHEMA_ID,"SCHEMA_ID")).add(schema_id_AST));
				currentAST.root = schema_id_AST;
				currentAST.child = schema_id_AST!=null &&schema_id_AST.getFirstChild()!=null ?
					schema_id_AST.getFirstChild() : schema_id_AST;
				currentAST.advanceChildToEnd();
				schema_id_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_94);
		}
		returnAST = schema_id_AST;
		return s;
	}
	
	public final void schema_body() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_body_AST = null;
		
		try {      // for error handling
			{
			_loop35804:
			do {
				if ((LA(1)==LITERAL_reference||LA(1)==LITERAL_use)) {
					interface_specification();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35804;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_constant:
			{
				constant_decl();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_entity:
			case LITERAL_subtype_constraint:
			case LITERAL_function:
			case LITERAL_procedure:
			case LITERAL_rule:
			case LITERAL_end_schema:
			case LITERAL_type:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop35807:
			do {
				switch ( LA(1)) {
				case LITERAL_entity:
				case LITERAL_subtype_constraint:
				case LITERAL_function:
				case LITERAL_procedure:
				case LITERAL_type:
				{
					declaration();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_rule:
				{
					rule_decl();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					break _loop35807;
				}
				}
			} while (true);
			}
			schema_body_AST = (AST)currentAST.root;
			schema_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCHEMA_BODY,"SCHEMA_BODY")).add(schema_body_AST));
			currentAST.root = schema_body_AST;
			currentAST.child = schema_body_AST!=null &&schema_body_AST.getFirstChild()!=null ?
				schema_body_AST.getFirstChild() : schema_body_AST;
			currentAST.advanceChildToEnd();
			schema_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_95);
		}
		returnAST = schema_body_AST;
	}
	
	public final void interface_specification() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interface_specification_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_reference:
			{
				reference_clause();
				astFactory.addASTChild(currentAST, returnAST);
				interface_specification_AST = (AST)currentAST.root;
				interface_specification_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERFACE_SPECIFICATION,"INTERFACE_SPECIFICATION")).add(interface_specification_AST));
				currentAST.root = interface_specification_AST;
				currentAST.child = interface_specification_AST!=null &&interface_specification_AST.getFirstChild()!=null ?
					interface_specification_AST.getFirstChild() : interface_specification_AST;
				currentAST.advanceChildToEnd();
				interface_specification_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_use:
			{
				use_clause();
				astFactory.addASTChild(currentAST, returnAST);
				interface_specification_AST = (AST)currentAST.root;
				interface_specification_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INTERFACE_SPECIFICATION,"INTERFACE_SPECIFICATION")).add(interface_specification_AST));
				currentAST.root = interface_specification_AST;
				currentAST.child = interface_specification_AST!=null &&interface_specification_AST.getFirstChild()!=null ?
					interface_specification_AST.getFirstChild() : interface_specification_AST;
				currentAST.advanceChildToEnd();
				interface_specification_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_86);
		}
		returnAST = interface_specification_AST;
	}
	
	public final void schema_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_decl_AST = null;
		String id=null;
		
		try {      // for error handling
			match(LITERAL_schema);
			id=schema_id();
			astFactory.addASTChild(currentAST, returnAST);
			newSchemaScope(id);
			{
			switch ( LA(1)) {
			case STRING:
			{
				schema_version_id();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			schema_body();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_end_schema);
			match(SEMI);
			schema_decl_AST = (AST)currentAST.root;
			upScope();
					schema_decl_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCHEMA_DECL,"SCHEMA_DECL")).add(schema_decl_AST));
			currentAST.root = schema_decl_AST;
			currentAST.child = schema_decl_AST!=null &&schema_decl_AST.getFirstChild()!=null ?
				schema_decl_AST.getFirstChild() : schema_decl_AST;
			currentAST.advanceChildToEnd();
			schema_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_96);
		}
		returnAST = schema_decl_AST;
	}
	
	public final void schema_version_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_version_id_AST = null;
		
		try {      // for error handling
			AST tmp365_AST = null;
			tmp365_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp365_AST);
			match(STRING);
			schema_version_id_AST = (AST)currentAST.root;
			schema_version_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCHEMA_VERSION_ID,"SCHEMA_VERSION_ID")).add(schema_version_id_AST));
			currentAST.root = schema_version_id_AST;
			currentAST.child = schema_version_id_AST!=null &&schema_version_id_AST.getFirstChild()!=null ?
				schema_version_id_AST.getFirstChild() : schema_version_id_AST;
			currentAST.advanceChildToEnd();
			schema_version_id_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = schema_version_id_AST;
	}
	
	public final void use_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST use_clause_AST = null;
		Token  id = null;
		AST id_AST = null;
		
			     ExternalId ei=null;
			
		
		try {      // for error handling
			if (((LA(1)==LITERAL_use))&&( isFirst )) {
				AST tmp366_AST = null;
				tmp366_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp366_AST);
				match(LITERAL_use);
				AST tmp367_AST = null;
				tmp367_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp367_AST);
				match(LITERAL_from);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					AST tmp368_AST = null;
					tmp368_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp368_AST);
					match(LPAREN);
					ei=named_type_or_rename();
					astFactory.addASTChild(currentAST, returnAST);
					ei.setSchema(id.getText()); addExternal(ei);
					{
					_loop35815:
					do {
						if ((LA(1)==COMMA)) {
							AST tmp369_AST = null;
							tmp369_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp369_AST);
							match(COMMA);
							ei=named_type_or_rename();
							astFactory.addASTChild(currentAST, returnAST);
							ei.setSchema(id.getText()); addExternal(ei);
						}
						else {
							break _loop35815;
						}
						
					} while (true);
					}
					AST tmp370_AST = null;
					tmp370_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp370_AST);
					match(RPAREN);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp371_AST = null;
				tmp371_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp371_AST);
				match(SEMI);
				if (ei==null) addAllUseExternals(id.getText());
				use_clause_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_use)) {
				match(LITERAL_use);
				match(LITERAL_from);
				schema_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					match(LPAREN);
					named_type_or_rename();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop35818:
					do {
						if ((LA(1)==COMMA)) {
							match(COMMA);
							named_type_or_rename();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop35818;
						}
						
					} while (true);
					}
					match(RPAREN);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(SEMI);
				use_clause_AST = (AST)currentAST.root;
				use_clause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(USE_CLAUSE,"USE_CLAUSE")).add(use_clause_AST));
				currentAST.root = use_clause_AST;
				currentAST.child = use_clause_AST!=null &&use_clause_AST.getFirstChild()!=null ?
					use_clause_AST.getFirstChild() : use_clause_AST;
				currentAST.advanceChildToEnd();
				use_clause_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_86);
		}
		returnAST = use_clause_AST;
	}
	
	public final ExternalId  named_type_or_rename() throws RecognitionException, TokenStreamException {
		ExternalId ei;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST named_type_or_rename_AST = null;
		Token  id = null;
		AST id_AST = null;
		
				String s=null;
				ei=null;
			
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				ei = new ExternalId(id.getText());
				{
				switch ( LA(1)) {
				case LITERAL_as:
				{
					AST tmp378_AST = null;
					tmp378_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp378_AST);
					match(LITERAL_as);
					s=rename_id();
					astFactory.addASTChild(currentAST, returnAST);
					ei.setRename(s);
					break;
				}
				case COMMA:
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				named_type_or_rename_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_97.member(LA(1)))) {
				named_types();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_as:
				{
					match(LITERAL_as);
					{
					if ((LA(1)==ENTITY_IDENT||LA(1)==IDENT)) {
						entity_id();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else if ((LA(1)==TYPE_IDENT||LA(1)==IDENT)) {
						type_id();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					
					}
					break;
				}
				case COMMA:
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				named_type_or_rename_AST = (AST)currentAST.root;
				named_type_or_rename_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(NAMED_TYPE_OR_RENAME,"NAMED_TYPE_OR_RENAME")).add(named_type_or_rename_AST));
				currentAST.root = named_type_or_rename_AST;
				currentAST.child = named_type_or_rename_AST!=null &&named_type_or_rename_AST.getFirstChild()!=null ?
					named_type_or_rename_AST.getFirstChild() : named_type_or_rename_AST;
				currentAST.advanceChildToEnd();
				named_type_or_rename_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = named_type_or_rename_AST;
		return ei;
	}
	
	public final String  type_id() throws RecognitionException, TokenStreamException {
		String s;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		s=null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				addId(id.getText(),TYPE_IDENT); s=id.getText();
				type_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==TYPE_IDENT)) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(TYPE_IDENT);
				type_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); type_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_ID,"TYPE_ID")).add(type_id_AST));
				currentAST.root = type_id_AST;
				currentAST.child = type_id_AST!=null &&type_id_AST.getFirstChild()!=null ?
					type_id_AST.getFirstChild() : type_id_AST;
				currentAST.advanceChildToEnd();
				type_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_98);
		}
		returnAST = type_id_AST;
		return s;
	}
	
	public final void term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST term_AST = null;
		
		try {      // for error handling
			factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35874:
			do {
				if ((_tokenSet_99.member(LA(1)))) {
					multiplication_like_op();
					astFactory.addASTChild(currentAST, returnAST);
					factor();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35874;
				}
				
			} while (true);
			}
			term_AST = (AST)currentAST.root;
			term_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TERM,"TERM")).add(term_AST));
			currentAST.root = term_AST;
			currentAST.child = term_AST!=null &&term_AST.getFirstChild()!=null ?
				term_AST.getFirstChild() : term_AST;
			currentAST.advanceChildToEnd();
			term_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_100);
		}
		returnAST = term_AST;
	}
	
	public final void unary_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unary_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case PLUS:
			{
				AST tmp380_AST = null;
				tmp380_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp380_AST);
				match(PLUS);
				unary_op_AST = (AST)currentAST.root;
				unary_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNARY_OP,"UNARY_OP")).add(unary_op_AST));
				currentAST.root = unary_op_AST;
				currentAST.child = unary_op_AST!=null &&unary_op_AST.getFirstChild()!=null ?
					unary_op_AST.getFirstChild() : unary_op_AST;
				currentAST.advanceChildToEnd();
				unary_op_AST = (AST)currentAST.root;
				break;
			}
			case MINUS:
			{
				AST tmp381_AST = null;
				tmp381_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp381_AST);
				match(MINUS);
				unary_op_AST = (AST)currentAST.root;
				unary_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNARY_OP,"UNARY_OP")).add(unary_op_AST));
				currentAST.root = unary_op_AST;
				currentAST.child = unary_op_AST!=null &&unary_op_AST.getFirstChild()!=null ?
					unary_op_AST.getFirstChild() : unary_op_AST;
				currentAST.advanceChildToEnd();
				unary_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_not:
			{
				AST tmp382_AST = null;
				tmp382_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp382_AST);
				match(LITERAL_not);
				unary_op_AST = (AST)currentAST.root;
				unary_op_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNARY_OP,"UNARY_OP")).add(unary_op_AST));
				currentAST.root = unary_op_AST;
				currentAST.child = unary_op_AST!=null &&unary_op_AST.getFirstChild()!=null ?
					unary_op_AST.getFirstChild() : unary_op_AST;
				currentAST.advanceChildToEnd();
				unary_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_101);
		}
		returnAST = unary_op_AST;
	}
	
	public final void string_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST string_type_AST = null;
		
		try {      // for error handling
			match(LITERAL_string);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				width_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case RPAREN:
			case SEMI:
			case COLEQ:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			string_type_AST = (AST)currentAST.root;
			string_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STRING_TYPE,"STRING_TYPE")).add(string_type_AST));
			currentAST.root = string_type_AST;
			currentAST.child = string_type_AST!=null &&string_type_AST.getFirstChild()!=null ?
				string_type_AST.getFirstChild() : string_type_AST;
			currentAST.advanceChildToEnd();
			string_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = string_type_AST;
	}
	
	public final void skip_stmt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST skip_stmt_AST = null;
		
		try {      // for error handling
			match(LITERAL_skip);
			match(SEMI);
			skip_stmt_AST = (AST)currentAST.root;
			skip_stmt_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SKIP_STMT,"SKIP_STMT")).add(skip_stmt_AST));
			currentAST.root = skip_stmt_AST;
			currentAST.child = skip_stmt_AST!=null &&skip_stmt_AST.getFirstChild()!=null ?
				skip_stmt_AST.getFirstChild() : skip_stmt_AST;
			currentAST.advanceChildToEnd();
			skip_stmt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = skip_stmt_AST;
	}
	
	public final void supertype_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_factor_AST = null;
		
		try {      // for error handling
			supertype_term();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35862:
			do {
				if ((LA(1)==LITERAL_and)) {
					match(LITERAL_and);
					supertype_term();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35862;
				}
				
			} while (true);
			}
			supertype_factor_AST = (AST)currentAST.root;
			supertype_factor_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_FACTOR,"SUPERTYPE_FACTOR")).add(supertype_factor_AST));
			currentAST.root = supertype_factor_AST;
			currentAST.child = supertype_factor_AST!=null &&supertype_factor_AST.getFirstChild()!=null ?
				supertype_factor_AST.getFirstChild() : supertype_factor_AST;
			currentAST.advanceChildToEnd();
			supertype_factor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_102);
		}
		returnAST = supertype_factor_AST;
	}
	
	public final void supertype_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_term_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			{
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_term_AST = (AST)currentAST.root;
				supertype_term_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_TERM,"SUPERTYPE_TERM")).add(supertype_term_AST));
				currentAST.root = supertype_term_AST;
				currentAST.child = supertype_term_AST!=null &&supertype_term_AST.getFirstChild()!=null ?
					supertype_term_AST.getFirstChild() : supertype_term_AST;
				currentAST.advanceChildToEnd();
				supertype_term_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_oneof:
			{
				one_of();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_term_AST = (AST)currentAST.root;
				supertype_term_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_TERM,"SUPERTYPE_TERM")).add(supertype_term_AST));
				currentAST.root = supertype_term_AST;
				currentAST.child = supertype_term_AST!=null &&supertype_term_AST.getFirstChild()!=null ?
					supertype_term_AST.getFirstChild() : supertype_term_AST;
				currentAST.advanceChildToEnd();
				supertype_term_AST = (AST)currentAST.root;
				break;
			}
			case LPAREN:
			{
				match(LPAREN);
				supertype_expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				supertype_term_AST = (AST)currentAST.root;
				supertype_term_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUPERTYPE_TERM,"SUPERTYPE_TERM")).add(supertype_term_AST));
				currentAST.root = supertype_term_AST;
				currentAST.child = supertype_term_AST!=null &&supertype_term_AST.getFirstChild()!=null ?
					supertype_term_AST.getFirstChild() : supertype_term_AST;
				currentAST.advanceChildToEnd();
				supertype_term_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					AST tmp389_AST = null;
					tmp389_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp389_AST);
					match(IDENT);
					supertype_term_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_80);
		}
		returnAST = supertype_term_AST;
	}
	
	public final void syntax() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST syntax_AST = null;
		if (isFirst) {
					rootScope = new Scope(null);
					lastCreatedScope=rootScope;
					currentScope=rootScope;
					schemas = new Hashtable();
				}
			
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LCURLY:
			{
				language_version_id();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_schema:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			schema_decl();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35870:
			do {
				if ((LA(1)==LITERAL_schema)) {
					schema_decl();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35870;
				}
				
			} while (true);
			}
			syntax_AST = (AST)currentAST.root;
			syntax_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SYNTAX,"SYNTAX")).add(syntax_AST));
			currentAST.root = syntax_AST;
			currentAST.child = syntax_AST!=null &&syntax_AST.getFirstChild()!=null ?
				syntax_AST.getFirstChild() : syntax_AST;
			currentAST.advanceChildToEnd();
			syntax_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_103);
		}
		returnAST = syntax_AST;
	}
	
	public final void language_version_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST language_version_id_AST = null;
		
		try {      // for error handling
			match(LCURLY);
			match(LANG_VERSION);
			match(RCURLY);
			language_version_id_AST = (AST)currentAST.root;
			language_version_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LANGUAGE_VERSION_ID,"LANGUAGE_VERSION_ID")).add(language_version_id_AST));
			currentAST.root = language_version_id_AST;
			currentAST.child = language_version_id_AST!=null &&language_version_id_AST.getFirstChild()!=null ?
				language_version_id_AST.getFirstChild() : language_version_id_AST;
			currentAST.advanceChildToEnd();
			language_version_id_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_104);
		}
		returnAST = language_version_id_AST;
	}
	
	public final EnumerationType  underlying_type() throws RecognitionException, TokenStreamException {
		EnumerationType eids;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST underlying_type_AST = null;
		eids=null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_generic_entity:
			case LITERAL_extensible:
			case LITERAL_enumeration:
			case LITERAL_select:
			{
				eids=constructed_types();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = (AST)currentAST.root;
				underlying_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNDERLYING_TYPE,"UNDERLYING_TYPE")).add(underlying_type_AST));
				currentAST.root = underlying_type_AST;
				currentAST.child = underlying_type_AST!=null &&underlying_type_AST.getFirstChild()!=null ?
					underlying_type_AST.getFirstChild() : underlying_type_AST;
				currentAST.advanceChildToEnd();
				underlying_type_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list:
			{
				aggregation_types();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = (AST)currentAST.root;
				underlying_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNDERLYING_TYPE,"UNDERLYING_TYPE")).add(underlying_type_AST));
				currentAST.root = underlying_type_AST;
				currentAST.child = underlying_type_AST!=null &&underlying_type_AST.getFirstChild()!=null ?
					underlying_type_AST.getFirstChild() : underlying_type_AST;
				currentAST.advanceChildToEnd();
				underlying_type_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string:
			{
				simple_types();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = (AST)currentAST.root;
				underlying_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNDERLYING_TYPE,"UNDERLYING_TYPE")).add(underlying_type_AST));
				currentAST.root = underlying_type_AST;
				currentAST.child = underlying_type_AST!=null &&underlying_type_AST.getFirstChild()!=null ?
					underlying_type_AST.getFirstChild() : underlying_type_AST;
				currentAST.advanceChildToEnd();
				underlying_type_AST = (AST)currentAST.root;
				break;
			}
			case TYPE_IDENT:
			case TYPE_ATTR_IDENT:
			case TYPE_VAR_IDENT:
			case TYPE_PARAM_IDENT:
			{
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = (AST)currentAST.root;
				underlying_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNDERLYING_TYPE,"UNDERLYING_TYPE")).add(underlying_type_AST));
				currentAST.root = underlying_type_AST;
				currentAST.child = underlying_type_AST!=null &&underlying_type_AST.getFirstChild()!=null ?
					underlying_type_AST.getFirstChild() : underlying_type_AST;
				currentAST.advanceChildToEnd();
				underlying_type_AST = (AST)currentAST.root;
				break;
			}
			default:
				if (((LA(1)==IDENT))&&( isFirst )) {
					AST tmp393_AST = null;
					tmp393_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp393_AST);
					match(IDENT);
					underlying_type_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = underlying_type_AST;
		return eids;
	}
	
	public final EnumerationType  constructed_types() throws RecognitionException, TokenStreamException {
		EnumerationType eids;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constructed_types_AST = null;
		eids=null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_extensible||LA(1)==LITERAL_enumeration))&&( LA(1)==LITERAL_enumeration||LA(2)==LITERAL_enumeration )) {
				eids=enumeration_type();
				astFactory.addASTChild(currentAST, returnAST);
				constructed_types_AST = (AST)currentAST.root;
				constructed_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTRUCTED_TYPES,"CONSTRUCTED_TYPES")).add(constructed_types_AST));
				currentAST.root = constructed_types_AST;
				currentAST.child = constructed_types_AST!=null &&constructed_types_AST.getFirstChild()!=null ?
					constructed_types_AST.getFirstChild() : constructed_types_AST;
				currentAST.advanceChildToEnd();
				constructed_types_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_generic_entity||LA(1)==LITERAL_extensible||LA(1)==LITERAL_select)) {
				select_type();
				astFactory.addASTChild(currentAST, returnAST);
				constructed_types_AST = (AST)currentAST.root;
				constructed_types_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONSTRUCTED_TYPES,"CONSTRUCTED_TYPES")).add(constructed_types_AST));
				currentAST.root = constructed_types_AST;
				currentAST.child = constructed_types_AST!=null &&constructed_types_AST.getFirstChild()!=null ?
					constructed_types_AST.getFirstChild() : constructed_types_AST;
				currentAST.advanceChildToEnd();
				constructed_types_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = constructed_types_AST;
		return eids;
	}
	
	public final EnumerationType  enumeration_type() throws RecognitionException, TokenStreamException {
		EnumerationType eids;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_type_AST = null;
		
				boolean ext=false;
			        eids=null; 
			
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_extensible:
			{
				AST tmp394_AST = null;
				tmp394_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp394_AST);
				match(LITERAL_extensible);
				ext=true;
				break;
			}
			case LITERAL_enumeration:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_enumeration);
			{
			switch ( LA(1)) {
			case LITERAL_of:
			case LITERAL_based_on:
			{
				{
				switch ( LA(1)) {
				case LITERAL_of:
				{
					{
					match(LITERAL_of);
					eids=enumeration_items();
					astFactory.addASTChild(currentAST, returnAST);
					}
					break;
				}
				case LITERAL_based_on:
				{
					eids=enumeration_extension();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			enumeration_type_AST = (AST)currentAST.root;
			enumeration_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENUMERATION_TYPE,"ENUMERATION_TYPE")).add(enumeration_type_AST)); 
					if (eids==null) eids = new EnumerationType();
					 eids.setExtensible(ext);
					
			currentAST.root = enumeration_type_AST;
			currentAST.child = enumeration_type_AST!=null &&enumeration_type_AST.getFirstChild()!=null ?
				enumeration_type_AST.getFirstChild() : enumeration_type_AST;
			currentAST.advanceChildToEnd();
			enumeration_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = enumeration_type_AST;
		return eids;
	}
	
	public final void select_type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_type_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_extensible:
			{
				AST tmp397_AST = null;
				tmp397_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp397_AST);
				match(LITERAL_extensible);
				break;
			}
			case LITERAL_generic_entity:
			case LITERAL_select:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_generic_entity:
			{
				AST tmp398_AST = null;
				tmp398_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp398_AST);
				match(LITERAL_generic_entity);
				break;
			}
			case LITERAL_select:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_select);
			{
			switch ( LA(1)) {
			case LPAREN:
			case LITERAL_based_on:
			{
				{
				switch ( LA(1)) {
				case LPAREN:
				{
					select_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_based_on:
				{
					select_extension();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			select_type_AST = (AST)currentAST.root;
			select_type_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_TYPE,"SELECT_TYPE")).add(select_type_AST));
			currentAST.root = select_type_AST;
			currentAST.child = select_type_AST!=null &&select_type_AST.getFirstChild()!=null ?
				select_type_AST.getFirstChild() : select_type_AST;
			currentAST.advanceChildToEnd();
			select_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = select_type_AST;
	}
	
	public final EnumerationType  enumeration_items() throws RecognitionException, TokenStreamException {
		EnumerationType eids;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_items_AST = null;
		
				String id=null;
				if (isFirst) eids = new EnumerationType();
				else eids=null;
			
		
		try {      // for error handling
			match(LPAREN);
			id=enumeration_id();
			astFactory.addASTChild(currentAST, returnAST);
			if (isFirst) eids.add(id);
			{
			_loop35886:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					id=enumeration_id();
					astFactory.addASTChild(currentAST, returnAST);
					if (isFirst) eids.add(id);
				}
				else {
					break _loop35886;
				}
				
			} while (true);
			}
			match(RPAREN);
			enumeration_items_AST = (AST)currentAST.root;
			enumeration_items_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENUMERATION_ITEMS,"ENUMERATION_ITEMS")).add(enumeration_items_AST));
			currentAST.root = enumeration_items_AST;
			currentAST.child = enumeration_items_AST!=null &&enumeration_items_AST.getFirstChild()!=null ?
				enumeration_items_AST.getFirstChild() : enumeration_items_AST;
			currentAST.advanceChildToEnd();
			enumeration_items_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = enumeration_items_AST;
		return eids;
	}
	
	public final EnumerationType  enumeration_extension() throws RecognitionException, TokenStreamException {
		EnumerationType eids;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_extension_AST = null;
		Token  id = null;
		AST id_AST = null;
		eids=null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_based_on))&&( isFirst )) {
				AST tmp403_AST = null;
				tmp403_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp403_AST);
				match(LITERAL_based_on);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				{
				switch ( LA(1)) {
				case LITERAL_with:
				{
					AST tmp404_AST = null;
					tmp404_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp404_AST);
					match(LITERAL_with);
					eids=enumeration_items();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if (eids==null) eids = new EnumerationType(); eids.setBasedOn(id.getText());
				enumeration_extension_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_based_on)) {
				match(LITERAL_based_on);
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_with:
				{
					match(LITERAL_with);
					enumeration_items();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				enumeration_extension_AST = (AST)currentAST.root;
				enumeration_extension_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENUMERATION_EXTENSION,"ENUMERATION_EXTENSION")).add(enumeration_extension_AST));
				currentAST.root = enumeration_extension_AST;
				currentAST.child = enumeration_extension_AST!=null &&enumeration_extension_AST.getFirstChild()!=null ?
					enumeration_extension_AST.getFirstChild() : enumeration_extension_AST;
				currentAST.advanceChildToEnd();
				enumeration_extension_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = enumeration_extension_AST;
		return eids;
	}
	
	public final String  enumeration_id() throws RecognitionException, TokenStreamException {
		String eid;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_id_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  nid = null;
		AST nid_AST = null;
		eid=null;
		
		try {      // for error handling
			if (((LA(1)==IDENT))&&( isFirst )) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(IDENT);
				eid=id.getText();
				enumeration_id_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==ENUMERATION_IDENT)) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ENUMERATION_IDENT);
				enumeration_id_AST = (AST)currentAST.root;
				nid_AST.setType(IDENT); enumeration_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ENUMERATION_ID,"ENUMERATION_ID")).add(enumeration_id_AST));
				currentAST.root = enumeration_id_AST;
				currentAST.child = enumeration_id_AST!=null &&enumeration_id_AST.getFirstChild()!=null ?
					enumeration_id_AST.getFirstChild() : enumeration_id_AST;
				currentAST.advanceChildToEnd();
				enumeration_id_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = enumeration_id_AST;
		return eid;
	}
	
	public final void select_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;
		
		try {      // for error handling
			match(LPAREN);
			named_types();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35898:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					named_types();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35898;
				}
				
			} while (true);
			}
			match(RPAREN);
			select_list_AST = (AST)currentAST.root;
			select_list_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_LIST,"SELECT_LIST")).add(select_list_AST));
			currentAST.root = select_list_AST;
			currentAST.child = select_list_AST!=null &&select_list_AST.getFirstChild()!=null ?
				select_list_AST.getFirstChild() : select_list_AST;
			currentAST.advanceChildToEnd();
			select_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = select_list_AST;
	}
	
	public final void select_extension() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_extension_AST = null;
		
		try {      // for error handling
			if (((LA(1)==LITERAL_based_on))&&( isFirst )) {
				AST tmp410_AST = null;
				tmp410_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp410_AST);
				match(LITERAL_based_on);
				AST tmp411_AST = null;
				tmp411_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp411_AST);
				match(IDENT);
				{
				switch ( LA(1)) {
				case LITERAL_with:
				{
					AST tmp412_AST = null;
					tmp412_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp412_AST);
					match(LITERAL_with);
					select_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				select_extension_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_based_on)) {
				match(LITERAL_based_on);
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_with:
				{
					match(LITERAL_with);
					select_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				select_extension_AST = (AST)currentAST.root;
				select_extension_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_EXTENSION,"SELECT_EXTENSION")).add(select_extension_AST));
				currentAST.root = select_extension_AST;
				currentAST.child = select_extension_AST!=null &&select_extension_AST.getFirstChild()!=null ?
					select_extension_AST.getFirstChild() : select_extension_AST;
				currentAST.advanceChildToEnd();
				select_extension_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = select_extension_AST;
	}
	
	public final void type_label_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_id_AST = null;
		
		try {      // for error handling
			AST tmp415_AST = null;
			tmp415_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp415_AST);
			match(IDENT);
			type_label_id_AST = (AST)currentAST.root;
			type_label_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_LABEL_ID,"TYPE_LABEL_ID")).add(type_label_id_AST));
			currentAST.root = type_label_id_AST;
			currentAST.child = type_label_id_AST!=null &&type_label_id_AST.getFirstChild()!=null ?
				type_label_id_AST.getFirstChild() : type_label_id_AST;
			currentAST.advanceChildToEnd();
			type_label_id_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_103);
		}
		returnAST = type_label_id_AST;
	}
	
	public final void width() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST width_AST = null;
		
		try {      // for error handling
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			width_AST = (AST)currentAST.root;
			width_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WIDTH,"WIDTH")).add(width_AST));
			currentAST.root = width_AST;
			currentAST.child = width_AST!=null &&width_AST.getFirstChild()!=null ?
				width_AST.getFirstChild() : width_AST;
			currentAST.advanceChildToEnd();
			width_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_81);
		}
		returnAST = width_AST;
	}
	
	public final void simple_id() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_id_AST = null;
		
		try {      // for error handling
			AST tmp416_AST = null;
			tmp416_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp416_AST);
			match(IDENT);
			simple_id_AST = (AST)currentAST.root;
			simple_id_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_ID,"SIMPLE_ID")).add(simple_id_AST));
			currentAST.root = simple_id_AST;
			currentAST.child = simple_id_AST!=null &&simple_id_AST.getFirstChild()!=null ?
				simple_id_AST.getFirstChild() : simple_id_AST;
			currentAST.advanceChildToEnd();
			simple_id_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_103);
		}
		returnAST = simple_id_AST;
	}
	
	public final void type_label_ref() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_ref_AST = null;
		
		try {      // for error handling
			AST tmp417_AST = null;
			tmp417_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp417_AST);
			match(IDENT);
			type_label_ref_AST = (AST)currentAST.root;
			type_label_ref_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_LABEL_REF,"TYPE_LABEL_REF")).add(type_label_ref_AST));
			currentAST.root = type_label_ref_AST;
			currentAST.child = type_label_ref_AST!=null &&type_label_ref_AST.getFirstChild()!=null ?
				type_label_ref_AST.getFirstChild() : type_label_ref_AST;
			currentAST.advanceChildToEnd();
			type_label_ref_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_103);
		}
		returnAST = type_label_ref_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"CONSTANT_IDENT",
		"ENTITY_IDENT",
		"FUNCTION_IDENT",
		"PROCEDURE_IDENT",
		"PARAMETER_IDENT",
		"SCHEMA_IDENT",
		"TYPE_IDENT",
		"VARIABLE_IDENT",
		"ENUMERATION_IDENT",
		"ATTRIBUTE_IDENT",
		"ENTITY_ATTR_IDENT",
		"TYPE_ATTR_IDENT",
		"ENTITY_VAR_IDENT",
		"TYPE_VAR_IDENT",
		"ENTITY_PARAM_IDENT",
		"TYPE_PARAM_IDENT",
		"SUBTYPE_CONSTRAINT_ID",
		"ACTUAL_PARAMETER_LIST",
		"ADD_LIKE_OP",
		"AGGREGATE_INITIALIZER",
		"AGGREGATE_SOURCE",
		"AGGREGATE_TYPE",
		"AGGREGATION_TYPES",
		"ALGORITHM_HEAD",
		"ALIAS_STMT",
		"ARRAY_TYPE",
		"ASSIGNMENT_STMT",
		"BAG_TYPE",
		"BASE_TYPE",
		"BINARY_TYPE",
		"BOOLEAN_TYPE",
		"BOUND_1",
		"BOUND_2",
		"BOUND_SPEC",
		"BUILT_IN_CONSTANT",
		"BUILT_IN_FUNCTION",
		"BUILT_IN_PROCEDURE",
		"CASE_ACTION",
		"CASE_LABEL",
		"CASE_STMT",
		"COMPOUND_STMT",
		"CONSTANT_BODY",
		"CONSTANT_DECL",
		"CONSTANT_FACTOR",
		"CONSTANT_ID",
		"DECLARATION",
		"DOMAIN_RULE",
		"ELEMENT",
		"ENTITY_HEAD",
		"ENTITY_DECL",
		"ENTITY_BODY",
		"SUBSUPER",
		"SUPERTYPE_CONSTRAINT",
		"ABSTRACT_SUPERTYPE_DECLARATION",
		"SUBTYPE_DECLARATION",
		"EXPLICIT_ATTR",
		"ATTRIBUTE_DECL",
		"ATTRIBUTE_ID",
		"QUALIFIED_ATTRIBUTE",
		"DERIVE_CLAUSE",
		"DERIVED_ATTR",
		"INVERSE_CLAUSE",
		"INVERSE_ATTR",
		"UNIQUE_CLAUSE",
		"UNIQUE_RULE",
		"REFERENCED_ATTRIBUTE",
		"ENTITY_CONSTRUCTOR",
		"ENTITY_ID",
		"ENUMERATION_REFERENCE",
		"ESCAPE_STMT",
		"EXPRESSION",
		"FACTOR",
		"FORMAL_PARAMETER",
		"ATTRIBUTE_QUALIFIER",
		"FUNCTION_CALL",
		"FUNCTION_DECL",
		"FUNCTION_HEAD",
		"FUNCTION_ID",
		"GENERALIZED_TYPES",
		"GENERAL_AGGREGATION_TYPES",
		"GENERAL_ARRAY_TYPE",
		"GENERAL_BAG_TYPE",
		"GENERAL_LIST_TYPE",
		"GENERAL_REF",
		"GENERAL_SET_TYPE",
		"GENERIC_TYPE",
		"GROUP_QUALIFIER",
		"IF_STMT",
		"INCREMENT",
		"INCREMENT_CONTROL",
		"INDEX",
		"INDEX_1",
		"INDEX_2",
		"INDEX_QUALIFIER",
		"INTEGER_TYPE",
		"INTERVAL",
		"INTERVAL_HIGH",
		"INTERVAL_ITEM",
		"INTERVAL_LOW",
		"INTERVAL_OP",
		"LABEL",
		"LIST_TYPE",
		"LITERAL",
		"REAL",
		"INTEGER",
		"STRING",
		"LOCAL_DECL",
		"LOCAL_VARIABLE",
		"LOGICAL_EXPRESSION",
		"LOGICAL",
		"LOGICAL_TYPE",
		"MULTIPLICATION_LIKE_OP",
		"NAMED_TYPES",
		"NULL_STMT",
		"NUMBER_TYPE",
		"NUMERIC_EXPRESSION",
		"ONE_OF",
		"PARAMETER",
		"PARAMETER_ID",
		"PARAMETER_TYPE",
		"POPULATION",
		"PRECISION_SPEC",
		"PRIMARY",
		"PROCEDURE_CALL_STMT",
		"PROCEDURE_DECL",
		"PROCEDURE_HEAD",
		"PROCEDURE_ID",
		"QUALIFIABLE_FACTOR",
		"QUALIFIER",
		"QUERY_EXPRESSION",
		"REAL_TYPE",
		"REFERENCE_CLAUSE",
		"REL_OP",
		"REL_OP_EXTENDED",
		"REPEAT_CONTROL",
		"REPEAT_STMT",
		"REPETITION",
		"RESOURCE_OR_RENAME",
		"RESOURCE_REF",
		"RETURN_STMT",
		"RULE_DECL",
		"RULE_HEAD",
		"RULE_ID",
		"SCHEMA_ID",
		"SCHEMA_BODY",
		"SCHEMA_DECL",
		"INTERFACE_SPECIFICATION",
		"USE_CLAUSE",
		"NAMED_TYPE_OR_RENAME",
		"SELECTOR",
		"SET_TYPE",
		"SIMPLE_EXPRESSION",
		"SIMPLE_FACTOR",
		"SIMPLE_TYPES",
		"SKIP_STMT",
		"STMT",
		"STRING_TYPE",
		"SUBTYPE_CONSTRAINT",
		"SUPERTYPE_EXPRESSION",
		"SUPERTYPE_FACTOR",
		"SUPERTYPE_RULE",
		"SUPERTYPE_TERM",
		"SYNTAX",
		"TERM",
		"TYPE_DECL",
		"UNDERLYING_TYPE",
		"CONSTRUCTED_TYPES",
		"ENUMERATION_TYPE",
		"ENUMERATION_ID",
		"SELECT_TYPE",
		"TYPE_ID",
		"TYPE_LABEL",
		"TYPE_LABEL_ID",
		"UNARY_OP",
		"UNTIL_CONTROL",
		"VARIABLE_ID",
		"WHERE_CLAUSE",
		"WHILE_CONTROL",
		"WIDTH",
		"WIDTH_SPEC",
		"ENTITY_REF",
		"TYPE_REF",
		"ENUMERATION_REF",
		"ATTRIBUTE_REF",
		"CONSTANT_REF",
		"FUNCTION_REF",
		"PARAMETER_REF",
		"VARIABLE_REF",
		"SCHEMA_REF",
		"TYPE_LABEL_REF",
		"PROCEDURE_REF",
		"SIMPLE_ID",
		"ELSE_CLAUSE",
		"RENAME_ID",
		"ENUMERATION_ITEMS",
		"ENUMERATION_EXTENSION",
		"SELECT_LIST",
		"SELECT_EXTENSION",
		"REDECLARED_ATTRIBUTE",
		"SUBTYPE_CONSTRAINT_DECL",
		"SUBTYPE_CONSTRAINT_HEAD",
		"SUBTYPE_CONSTRAINT_BODY",
		"ABSTRACT_SUPERTYPE",
		"TOTAL_OVER",
		"CONCRETE_TYPES",
		"GENERIC_ENTITY_TYPE",
		"SCHEMA_VERSION_ID",
		"LANGUAGE_VERSION_ID",
		"(",
		",",
		")",
		"+",
		"-",
		"\"or\"",
		"\"xor\"",
		"[",
		"]",
		"\"aggregate\"",
		":",
		"\"of\"",
		"\"alias\"",
		"\"for\"",
		"an identifer",
		";",
		"\"end_alias\"",
		"\"array\"",
		"\"optional\"",
		"\"unique\"",
		":=",
		"\"bag\"",
		"\"binary\"",
		"\"boolean\"",
		"\"const_e\"",
		"\"pi\"",
		"\"self\"",
		"?",
		"*",
		"\"abs\"",
		"\"acos\"",
		"\"asin\"",
		"\"atan\"",
		"\"blength\"",
		"\"cos\"",
		"\"exists\"",
		"\"exp\"",
		"\"format\"",
		"\"hibound\"",
		"\"hiindex\"",
		"\"length\"",
		"\"lobound\"",
		"\"loindex\"",
		"\"log\"",
		"\"log2\"",
		"\"log10\"",
		"\"nvl\"",
		"\"odd\"",
		"\"rolesof\"",
		"\"sin\"",
		"\"sizeof\"",
		"\"sqrt\"",
		"\"tan\"",
		"\"typeof\"",
		"\"usedin\"",
		"\"value\"",
		"\"value_in\"",
		"\"value_unique\"",
		"\"insert\"",
		"\"remove\"",
		"\"case\"",
		"\"otherwise\"",
		"\"end_case\"",
		"\"begin\"",
		"\"end\"",
		"\"constant\"",
		"\"end_constant\"",
		"\"entity\"",
		"\"abstract\"",
		"\"end_entity\"",
		"\"supertype\"",
		"\"subtype\"",
		"\"end_subtype_constraint\"",
		"\"subtype_constraint\"",
		"\"total_over\"",
		"\"renamed\"",
		"\"derive\"",
		"\"inverse\"",
		"\"set\"",
		".",
		"\"escape\"",
		"double star",
		"\"end_function\"",
		"\"function\"",
		"\"list\"",
		"\"generic\"",
		"\"generic_entity\"",
		"backslash",
		"\"if\"",
		"\"then\"",
		"\"end_if\"",
		"\"else\"",
		"\"to\"",
		"\"by\"",
		"\"integer\"",
		"{",
		"}",
		"<",
		"<=",
		"an integer value",
		"an floating point value",
		"a string literal",
		"\"local\"",
		"\"end_local\"",
		"\"false\"",
		"\"true\"",
		"\"unknown\"",
		"\"logical\"",
		"/",
		"\"div\"",
		"\"mod\"",
		"\"and\"",
		"double bar",
		"\"number\"",
		"\"oneof\"",
		"\"end_procedure\"",
		"\"procedure\"",
		"\"var\"",
		"\"query\"",
		"less than star",
		"|",
		"\"real\"",
		"\"reference\"",
		"\"from\"",
		">",
		">=",
		"less-than/greater-than thing",
		"=",
		":<>:",
		":=:",
		"\"in\"",
		"\"like\"",
		"\"repeat\"",
		"\"end_repeat\"",
		"\"as\"",
		"\"return\"",
		"\"end_rule\"",
		"\"rule\"",
		"\"schema\"",
		"\"end_schema\"",
		"\"use\"",
		"\"skip\"",
		"\"string\"",
		"\"andor\"",
		"language version id",
		"\"type\"",
		"\"end_type\"",
		"\"extensible\"",
		"\"enumeration\"",
		"\"based_on\"",
		"\"with\"",
		"\"select\"",
		"\"not\"",
		"\"until\"",
		"\"where\"",
		"\"while\"",
		"\"fixed\"",
		"a comment",
		"a EXPRESS one line comment",
		"&",
		"@",
		"white space",
		"a digit"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[12];
		data[3]=281513092448256L;
		data[4]=32413774585528320L;
		data[5]=175921877159967L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[3]=6291456L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[12];
		data[0]=1047920L;
		data[3]=-17574845743104L;
		data[4]=8252846317156450303L;
		data[5]=17592186045440L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[12];
		data[3]=281512958230528L;
		data[4]=32404944132767744L;
		data[5]=175921877159967L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[3]=270532608L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[12];
		data[5]=4096L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[12];
		data[3]=37855690752L;
		data[4]=32404806693814272L;
		data[5]=175921877159936L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[8];
		data[3]=1133875560448L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[8];
		data[3]=1136023044096L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[8];
		data[3]=1133871366144L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = new long[12];
		data[4]=550301073408L;
		data[5]=137438953728L;
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=17660906160128L;
		data[5]=70377485107328L;
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=288248587361042432L;
		data[5]=70517608415616L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=288248587358945280L;
		data[5]=70517608415616L;
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[8];
		data[0]=198656L;
		data[3]=17179869184L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=17660906160128L;
		data[5]=8740929536L;
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[12];
		data[0]=1048048L;
		data[3]=-17467471560704L;
		data[4]=8253075359174492159L;
		data[5]=87969704707200L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[12];
		data[3]=1109177401344L;
		data[5]=2048L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[12];
		data[3]=282612604076032L;
		data[4]=32413774585528320L;
		data[5]=175921877159967L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = new long[8];
		data[3]=2147483648L;
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = new long[12];
		data[0]=1033248L;
		data[3]=15547781611520L;
		data[4]=-9222245020256436224L;
		data[5]=17179877408L;
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = new long[10];
		data[3]=2336999079936L;
		data[4]=7713761263616L;
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = new long[12];
		data[3]=37855690752L;
		for (int i = 4; i<=5; i++) { data[i]=35184372088832L; }
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = new long[12];
		data[3]=1133877657600L;
		data[5]=67108864L;
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = new long[10];
		data[3]=1073741824L;
		data[4]=281474976710656L;
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = new long[12];
		data[3]=35708207104L;
		data[4]=844424930131968L;
		data[5]=175921860444160L;
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[12];
		data[3]=34628173824L;
		data[4]=562949953421312L;
		data[5]=175921860444160L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = new long[12];
		data[3]=281513093496832L;
		data[4]=32413774585528320L;
		data[5]=175921877159967L;
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = new long[8];
		data[3]=34360786944L;
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = new long[12];
		data[0]=1047920L;
		data[3]=-17574845743104L;
		data[4]=8252846317156843519L;
		data[5]=17592186045440L;
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = new long[8];
		data[3]=1075838976L;
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = new long[10];
		data[0]=16L;
		data[3]=17179869184L;
		data[4]=4194304L;
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = new long[8];
		data[3]=1073741824L;
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = new long[12];
		data[3]=281513092448256L;
		data[4]=32413774585528320L;
		data[5]=175921944268831L;
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=288248587361042432L;
		data[5]=146179883264L;
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=288248587361042432L;
		data[5]=146179883392L;
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=17660906160128L;
		data[5]=8740929664L;
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = new long[8];
		data[3]=34359738368L;
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = new long[12];
		data[3]=34363932672L;
		for (int i = 4; i<=5; i++) { data[i]=35184372088832L; }
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70970039599104L;
		data[4]=13136560128L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70970039599104L;
		data[4]=12918456320L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70935679860736L;
		data[4]=12918456320L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70970045890560L;
		data[4]=13136560128L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = new long[8];
		data[0]=57344L;
		data[3]=70385924046848L;
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = new long[10];
		data[4]=33554432L;
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = new long[12];
		data[3]=549755813888L;
		data[4]=8623489024L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = new long[12];
		data[3]=549755813888L;
		data[4]=33554432L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = new long[12];
		data[4]=33554432L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = new long[12];
		data[4]=33554432L;
		data[5]=275146342400L;
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70970039599104L;
		data[4]=13052674048L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = new long[12];
		data[3]=282621195059200L;
		data[4]=32413774585528320L;
		data[5]=175956304007199L;
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = new long[12];
		data[0]=344096L;
		data[3]=17180917760L;
		data[4]=1358954496L;
		data[5]=64L;
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = new long[10];
		data[4]=268435456L;
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = new long[8];
		data[3]=8589934592L;
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = new long[12];
		data[0]=344096L;
		data[3]=17180917760L;
		data[4]=1342177280L;
		data[5]=64L;
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = new long[12];
		data[0]=344096L;
		data[3]=17180917760L;
		data[4]=268435456L;
		data[5]=64L;
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = new long[8];
		data[3]=34366029824L;
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = new long[10];
		data[3]=35435577344L;
		data[4]=2147483648L;
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = new long[12];
		data[3]=282612604076032L;
		data[4]=32413776733011968L;
		data[5]=175921877159967L;
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70935679860736L;
		data[4]=8623489024L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = new long[12];
		data[0]=57344L;
		data[3]=70935679860736L;
		data[4]=33554432L;
		data[5]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = new long[12];
		data[3]=282612604076032L;
		data[4]=32413776733011968L;
		data[5]=175921944268831L;
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = new long[8];
		data[3]=34361835520L;
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	private static final long[] mk_tokenSet_63() {
		long[] data = { 693248L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	private static final long[] mk_tokenSet_64() {
		long[] data = new long[12];
		data[3]=1133877657600L;
		data[4]=34359738368L;
		data[5]=4398113619968L;
		return data;
	}
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	private static final long[] mk_tokenSet_65() {
		long[] data = new long[12];
		data[3]=281512958230528L;
		data[4]=32404806693814272L;
		data[5]=175921877159967L;
		return data;
	}
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	private static final long[] mk_tokenSet_66() {
		long[] data = new long[10];
		data[4]=8250594517342748672L;
		return data;
	}
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	private static final long[] mk_tokenSet_67() {
		long[] data = { 344096L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	private static final long[] mk_tokenSet_68() {
		long[] data = new long[8];
		data[0]=693248L;
		data[3]=17179869184L;
		return data;
	}
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	private static final long[] mk_tokenSet_69() {
		long[] data = new long[12];
		data[0]=1042800L;
		data[3]=-17574979960832L;
		data[4]=8250594517342765055L;
		data[5]=17592186044416L;
		return data;
	}
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	private static final long[] mk_tokenSet_70() {
		long[] data = new long[8];
		data[3]=34363932672L;
		return data;
	}
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	private static final long[] mk_tokenSet_71() {
		long[] data = new long[12];
		data[3]=281513093496832L;
		data[4]=32413774585528320L;
		data[5]=175921944268831L;
		return data;
	}
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	private static final long[] mk_tokenSet_72() {
		long[] data = new long[8];
		data[3]=1074790400L;
		return data;
	}
	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());
	private static final long[] mk_tokenSet_73() {
		long[] data = new long[10];
		data[4]=70368744177664L;
		return data;
	}
	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());
	private static final long[] mk_tokenSet_74() {
		long[] data = new long[12];
		data[3]=34359738368L;
		data[5]=175921860444160L;
		return data;
	}
	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());
	private static final long[] mk_tokenSet_75() {
		long[] data = new long[8];
		data[3]=1342177280L;
		return data;
	}
	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());
	private static final long[] mk_tokenSet_76() {
		long[] data = new long[8];
		data[3]=268435456L;
		return data;
	}
	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());
	private static final long[] mk_tokenSet_77() {
		long[] data = new long[10];
		data[4]=27021597764222976L;
		return data;
	}
	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());
	private static final long[] mk_tokenSet_78() {
		long[] data = new long[10];
		data[4]=4503599627370496L;
		return data;
	}
	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());
	private static final long[] mk_tokenSet_79() {
		long[] data = new long[10];
		data[0]=198656L;
		data[3]=17179869184L;
		data[4]=576460752303423488L;
		return data;
	}
	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());
	private static final long[] mk_tokenSet_80() {
		long[] data = new long[12];
		data[3]=34366029824L;
		data[5]=34359738376L;
		return data;
	}
	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());
	private static final long[] mk_tokenSet_81() {
		long[] data = new long[8];
		data[3]=4194304L;
		return data;
	}
	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());
	private static final long[] mk_tokenSet_82() {
		long[] data = new long[8];
		data[0]=16L;
		data[3]=545357767376896L;
		return data;
	}
	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());
	private static final long[] mk_tokenSet_83() {
		long[] data = new long[10];
		data[0]=64L;
		data[3]=-562949953421312L;
		data[4]=16383L;
		return data;
	}
	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());
	private static final long[] mk_tokenSet_84() {
		long[] data = { 985344L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());
	private static final long[] mk_tokenSet_85() {
		long[] data = new long[12];
		data[3]=34367078400L;
		data[5]=67108864L;
		return data;
	}
	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());
	private static final long[] mk_tokenSet_86() {
		long[] data = new long[12];
		data[4]=550303170560L;
		data[5]=144418291968L;
		return data;
	}
	public static final BitSet _tokenSet_86 = new BitSet(mk_tokenSet_86());
	private static final long[] mk_tokenSet_87() {
		long[] data = { 1033456L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_87 = new BitSet(mk_tokenSet_87());
	private static final long[] mk_tokenSet_88() {
		long[] data = new long[8];
		data[0]=1048560L;
		data[3]=17179869184L;
		return data;
	}
	public static final BitSet _tokenSet_88 = new BitSet(mk_tokenSet_88());
	private static final long[] mk_tokenSet_89() {
		long[] data = new long[12];
		data[3]=34359738368L;
		data[5]=35184372088832L;
		return data;
	}
	public static final BitSet _tokenSet_89 = new BitSet(mk_tokenSet_89());
	private static final long[] mk_tokenSet_90() {
		long[] data = new long[12];
		data[3]=6291456L;
		data[5]=67108864L;
		return data;
	}
	public static final BitSet _tokenSet_90 = new BitSet(mk_tokenSet_90());
	private static final long[] mk_tokenSet_91() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=288248587361042432L;
		data[5]=70514924060928L;
		return data;
	}
	public static final BitSet _tokenSet_91 = new BitSet(mk_tokenSet_91());
	private static final long[] mk_tokenSet_92() {
		long[] data = new long[12];
		data[0]=985472L;
		data[3]=55834574848L;
		data[4]=17660906160128L;
		data[5]=70377485107200L;
		return data;
	}
	public static final BitSet _tokenSet_92 = new BitSet(mk_tokenSet_92());
	private static final long[] mk_tokenSet_93() {
		long[] data = new long[12];
		data[4]=550301073408L;
		data[5]=140123308288L;
		return data;
	}
	public static final BitSet _tokenSet_93 = new BitSet(mk_tokenSet_93());
	private static final long[] mk_tokenSet_94() {
		long[] data = new long[10];
		data[3]=34359738368L;
		data[4]=144115188075855872L;
		return data;
	}
	public static final BitSet _tokenSet_94 = new BitSet(mk_tokenSet_94());
	private static final long[] mk_tokenSet_95() {
		long[] data = new long[12];
		data[5]=2147483648L;
		return data;
	}
	public static final BitSet _tokenSet_95 = new BitSet(mk_tokenSet_95());
	private static final long[] mk_tokenSet_96() {
		long[] data = new long[12];
		data[0]=2L;
		data[5]=1073741824L;
		return data;
	}
	public static final BitSet _tokenSet_96 = new BitSet(mk_tokenSet_96());
	private static final long[] mk_tokenSet_97() {
		long[] data = new long[8];
		data[0]=1033248L;
		data[3]=17179869184L;
		return data;
	}
	public static final BitSet _tokenSet_97 = new BitSet(mk_tokenSet_97());
	private static final long[] mk_tokenSet_98() {
		long[] data = new long[12];
		data[3]=6291456L;
		data[5]=524288L;
		return data;
	}
	public static final BitSet _tokenSet_98 = new BitSet(mk_tokenSet_98());
	private static final long[] mk_tokenSet_99() {
		long[] data = new long[12];
		data[3]=281474976710656L;
		data[5]=31L;
		return data;
	}
	public static final BitSet _tokenSet_99 = new BitSet(mk_tokenSet_99());
	private static final long[] mk_tokenSet_100() {
		long[] data = new long[12];
		data[3]=37981519872L;
		data[4]=32404806693814272L;
		data[5]=175921877159936L;
		return data;
	}
	public static final BitSet _tokenSet_100 = new BitSet(mk_tokenSet_100());
	private static final long[] mk_tokenSet_101() {
		long[] data = new long[10];
		data[0]=1042800L;
		data[3]=-17575005126656L;
		data[4]=8250594517342765055L;
		return data;
	}
	public static final BitSet _tokenSet_101 = new BitSet(mk_tokenSet_101());
	private static final long[] mk_tokenSet_102() {
		long[] data = new long[12];
		data[3]=34366029824L;
		data[5]=34359738368L;
		return data;
	}
	public static final BitSet _tokenSet_102 = new BitSet(mk_tokenSet_102());
	private static final long[] mk_tokenSet_103() {
		long[] data = { 2L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_103 = new BitSet(mk_tokenSet_103());
	private static final long[] mk_tokenSet_104() {
		long[] data = new long[12];
		data[5]=1073741824L;
		return data;
	}
	public static final BitSet _tokenSet_104 = new BitSet(mk_tokenSet_104());
	
	}
