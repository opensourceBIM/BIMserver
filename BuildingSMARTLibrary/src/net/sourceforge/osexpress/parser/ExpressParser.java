// $ANTLR : "express.g" -> "ExpressParser.java"$

package net.sourceforge.osexpress.parser;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Hashtable;

import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.MismatchedTokenException;
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
 * The Express grammar written as ANTLR productions. Peter Denno,
 * pdenno@nist.gov Stephane Lardet, stephane.lardet@nist.gov
 * 
 * Development of this software was funded by the United States Government, and
 * is not subject to copyright.
 * 
 * DISCLAIMER: Recipients of this software assume all responsibility associated
 * with its operation, modification, maintenance, and subsequent
 * re-distribution.
 */
public class ExpressParser extends antlr.LLkParser {

	public Scope rootScope;
	public Scope currentScope;
	private Scope lastCreatedScope;

	/*
	 * We keep track of scopes defined by schemas. It is useful when multiple
	 * schemas are parsed, to deal with external elements
	 */
	private Hashtable<String, Scope> schemas;

	public boolean isFirst = true; /* is the first pass running ? */

	public void newScope() {
		if (isFirst)
			newScope1();
		else
			retrievePreviousScope();
	}

	/**
	 * creates a new Scope when entering a rule defining a scope in the grammar.
	 */
	public void newScope1() {
		Scope ns = new Scope(currentScope);
		currentScope = ns;
		lastCreatedScope.setNext(ns);
		lastCreatedScope = ns;
	}

	/**
	 * retrieve the scope created in the first pass when entering the same rule.
	 * See comments in the lexer's IDENT rule definition
	 */
	public void retrievePreviousScope() {
		currentScope = lastCreatedScope.next;
		lastCreatedScope = currentScope;
	}

	/**
	 * Go to the parent scope. Used when exiting a scope
	 */
	public void upScope() {
		currentScope = currentScope.parent;
	}

	/**
	 * we record schema scopes so as to retrieve external elements when parsing
	 * multiple schemas
	 * 
	 * @param id
	 */
	private void newSchemaScope(String id) {
		newScope();
		if (isFirst)
			schemas.put(id, currentScope);
	}

	/**
	 * entity case: additional information is recorded to build the entity
	 * inheritance tree
	 * 
	 * @param id
	 */
	private void newEntityScope(String id) {
		newScope();
		if (isFirst) {
			currentScope.setEntity();
			currentScope.parent.addEntityScope(id, currentScope);
		}
	}

	/**
	 * record an id in the current scope
	 * 
	 * @param id
	 * @param type
	 */
	private void addId(String id, ExpressParserTokenTypes type) {
		currentScope.addId(id, type);
	}

	/**
	 * add superentity in the current entity scope
	 * 
	 * @param name
	 */
	private void addSuper(String name) {
		currentScope.addSuperEntity(name);
	}

	public void setRootScope(Scope rs) {
		rootScope = rs;
		currentScope = rootScope;
		lastCreatedScope = rootScope;
		isFirst = false;
	}

	/**
	 * add an element referenced or used from another schema
	 * 
	 * @param ei
	 */
	public void addExternal(ExternalId ei) {
		currentScope.addExternal(ei);
	}

	/**
	 * when all elements of another schema are referenced
	 * 
	 * @param schema
	 */
	public void addAllReferenceExternals(String schema) {
		currentScope.addAllReferenceExternals(schema);
	}

	/**
	 * when all elements of another schema are used
	 * 
	 * @param schema
	 */
	public void addAllUseExternals(String schema) {
		currentScope.addAllUseExternals(schema);
	}

	/**
	 * after the first pass, adds external ids to schema scopes
	 */
	public void processExternals() {
		for (Scope scope : schemas.values()) {
			scope.processExternals(schemas);
		}
	}

	protected void match(ExpressParserTokenTypes tokenType) throws MismatchedTokenException, TokenStreamException {
		super.match(tokenType.getIndex());
	}

	protected boolean LA1Equals(ExpressParserTokenTypes tokenType) throws TokenStreamException {
		return LA(1) == tokenType.getIndex();
	}

	protected ExpressParser(TokenBuffer tokenBuf, int k) {
		super(tokenBuf, k);
		tokenNames = _tokenNames;
		buildTokenTypeASTClassMap();
		astFactory = new ASTFactory(getTokenTypeToASTClassMap());
	}

	public ExpressParser(TokenBuffer tokenBuf) {
		this(tokenBuf, 1);
	}

	protected ExpressParser(TokenStream lexer, int k) {
		super(lexer, k);
		tokenNames = _tokenNames;
		buildTokenTypeASTClassMap();
		astFactory = new ASTFactory(getTokenTypeToASTClassMap());
	}

	public ExpressParser(TokenStream lexer) {
		this(lexer, 1);
	}

	public ExpressParser(ParserSharedInputState state) {
		super(state, 1);
		tokenNames = _tokenNames;
		buildTokenTypeASTClassMap();
		astFactory = new ASTFactory(getTokenTypeToASTClassMap());
	}

	protected AST parseAST(ASTPair currentAST, ExpressParserTokenTypes tokenType) {
		// FIXME not sure if this function name is necessarily descriptive of
		// what's happening
		AST AST = (AST) currentAST.root;
		AST = makeAST(tokenType, AST);
		currentAST.root = AST;
		currentAST.child = getChild(AST);
		currentAST.advanceChildToEnd();
		AST = (AST) currentAST.root;
		return AST;
	}

	protected AST makeAST(ExpressParserTokenTypes tokenType, AST root) {
		return (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(tokenType.getIndex(), tokenType.name())).add(root));
	}

	protected AST getChild(AST root) {
		return root != null && root.getFirstChild() != null ? root.getFirstChild() : root;
	}

	public final void actual_parameter_list() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST actual_parameter_list_AST = null;

		try {
			match(ExpressParserTokenTypes.LPAREN);
			parameter();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35506: do {
					if (LA1Equals(ExpressParserTokenTypes.COMMA)) {
						match(ExpressParserTokenTypes.COMMA);
						parameter();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35506;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.RPAREN);
			actual_parameter_list_AST = parseAST(currentAST, ExpressParserTokenTypes.ACTUAL_PARAMETER_LIST);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = actual_parameter_list_AST;
	}

	public final void parameter() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_AST = null;

		try {
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			parameter_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_1);
		}
		returnAST = parameter_AST;
	}

	public final void add_like_op() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST add_like_op_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case PLUS: {
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(ExpressParserTokenTypes.PLUS);
				add_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.ADD_LIKE_OP);
				break;
			}
			case MINUS: {
				AST tmp5_AST = null;
				tmp5_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp5_AST);
				match(ExpressParserTokenTypes.MINUS);
				add_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.ADD_LIKE_OP);
				break;
			}
			case LITERAL_or: {
				AST tmp6_AST = null;
				tmp6_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp6_AST);
				match(ExpressParserTokenTypes.LITERAL_or);
				add_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.ADD_LIKE_OP);
				break;
			}
			case LITERAL_xor: {
				AST tmp7_AST = null;
				tmp7_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp7_AST);
				match(ExpressParserTokenTypes.LITERAL_xor);
				add_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.ADD_LIKE_OP);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_2);
		}
		returnAST = add_like_op_AST;
	}

	public final void aggregate_initializer() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_initializer_AST = null;

		try {
			match(ExpressParserTokenTypes.LBRACK);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
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
				case LOG2:
				case LOG10:
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
				case LITERAL_not: {
					element();
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop35511: do {
							if (LA1Equals(ExpressParserTokenTypes.COMMA)) {
								match(ExpressParserTokenTypes.COMMA);
								element();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35511;
							}

						} while (true);
					}
					break;
				}
				case RBRACK: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.RBRACK);
			aggregate_initializer_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATE_INITIALIZER);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = aggregate_initializer_AST;
	}

	public final void element() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST element_AST = null;

		try {
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case COLON: {
					match(ExpressParserTokenTypes.COLON);
					repetition();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				case RBRACK: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			element_AST = parseAST(currentAST, ExpressParserTokenTypes.ELEMENT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_4);
		}
		returnAST = element_AST;
	}

	public final void aggregate_source() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_source_AST = null;

		try {
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_source_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATE_SOURCE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_5);
		}
		returnAST = aggregate_source_AST;
	}

	public final void simple_expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_expression_AST = null;

		try {
			term();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35828: do {
					if (((LA(1) >= ExpressParserTokenTypes.PLUS.getIndex() && LA(1) <= ExpressParserTokenTypes.LITERAL_xor.getIndex()))) {
						add_like_op();
						astFactory.addASTChild(currentAST, returnAST);
						term();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35828;
					}

				} while (true);
			}
			simple_expression_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_EXPRESSION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_6);
		}
		returnAST = simple_expression_AST;
	}

	public final void aggregate_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_aggregate);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case COLON: {
					match(ExpressParserTokenTypes.COLON);
					type_label();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_type_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATE_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = aggregate_type_AST;
	}

	public final void type_label() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_AST = null;

		try {
			AST tmp15_AST = null;
			tmp15_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp15_AST);
			match(ExpressParserTokenTypes.IDENT);
			type_label_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_LABEL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_8);
		}
		returnAST = type_label_AST;
	}

	public final void parameter_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_type_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_aggregate:
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list:
			case LITERAL_generic:
			case LITERAL_generic_entity: {
				generalized_types();
				astFactory.addASTChild(currentAST, returnAST);
				parameter_type_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_TYPE);
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
			case IDENT: {
				named_types();
				astFactory.addASTChild(currentAST, returnAST);
				parameter_type_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_TYPE);
				break;
			}
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string: {
				simple_types();
				astFactory.addASTChild(currentAST, returnAST);
				parameter_type_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_TYPE);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = parameter_type_AST;
	}

	public final void aggregation_types() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregation_types_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_array: {
				array_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATION_TYPES);
				break;
			}
			case LITERAL_bag: {
				bag_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATION_TYPES);
				break;
			}
			case LITERAL_list: {
				list_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATION_TYPES);
				break;
			}
			case LITERAL_set: {
				set_type();
				astFactory.addASTChild(currentAST, returnAST);
				aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.AGGREGATION_TYPES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = aggregation_types_AST;
	}

	public final void array_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST array_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_array);
			bound_spec();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_of);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_optional: {
					match(ExpressParserTokenTypes.LITERAL_optional);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_unique: {
					match(ExpressParserTokenTypes.LITERAL_unique);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			array_type_AST = parseAST(currentAST, ExpressParserTokenTypes.ARRAY_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = array_type_AST;
	}

	public final void bag_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bag_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_bag);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			bag_type_AST = parseAST(currentAST, ExpressParserTokenTypes.BAG_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = bag_type_AST;
	}

	public final void list_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST list_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_list);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_unique: {
					AST tmp24_AST = null;
					tmp24_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp24_AST);
					match(ExpressParserTokenTypes.LITERAL_unique);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			list_type_AST = parseAST(currentAST, ExpressParserTokenTypes.LIST_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = list_type_AST;
	}

	public final void set_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST set_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_set);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			set_type_AST = parseAST(currentAST, ExpressParserTokenTypes.SET_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = set_type_AST;
	}

	public final void algorithm_head() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST algorithm_head_AST = null;

		try {
			{
				_loop35518: do {
					if ((_tokenSet_10.member(LA(1)))) {
						declaration();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35518;
					}

				} while (true);
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_constant: {
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_local: {
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			algorithm_head_AST = parseAST(currentAST, ExpressParserTokenTypes.ALGORITHM_HEAD);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_11);
		}
		returnAST = algorithm_head_AST;
	}

	public final void declaration() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaration_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_entity: {
				entity_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.DECLARATION);
				break;
			}
			case LITERAL_subtype_constraint: {
				subtype_constraint_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.DECLARATION);
				break;
			}
			case LITERAL_function: {
				function_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.DECLARATION);
				break;
			}
			case LITERAL_procedure: {
				procedure_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.DECLARATION);
				break;
			}
			case LITERAL_type: {
				type_decl();
				astFactory.addASTChild(currentAST, returnAST);
				declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.DECLARATION);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_12);
		}
		returnAST = declaration_AST;
	}

	public final void constant_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_decl_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_constant);
			constant_body();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35564: do {
					if (LA1Equals(ExpressParserTokenTypes.CONSTANT_IDENT) || LA1Equals(ExpressParserTokenTypes.IDENT)) {
						constant_body();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35564;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.LITERAL_end_constant);
			match(ExpressParserTokenTypes.SEMI);
			constant_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTANT_DECL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_13);
		}
		returnAST = constant_decl_AST;
	}

	public final void local_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST local_decl_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_local);
			local_variable();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35721: do {
					if ((_tokenSet_14.member(LA(1)))) {
						local_variable();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35721;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.LITERAL_end_local);
			match(ExpressParserTokenTypes.SEMI);
			local_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.LOCAL_DECL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_11);
		}
		returnAST = local_decl_AST;
	}

	public final void alias_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_stmt_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_alias))) && (isFirst)) {
				newScope1();
				AST tmp33_AST = null;
				tmp33_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp33_AST);
				match(ExpressParserTokenTypes.LITERAL_alias);
				variable_id();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp34_AST);
				match(ExpressParserTokenTypes.LITERAL_for);
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					_loop35523: do {
						if (LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH)) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35523;
						}

					} while (true);
				}
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp36_AST);
				match(ExpressParserTokenTypes.SEMI);
				stmt();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35525: do {
						if ((_tokenSet_15.member(LA(1)))) {
							stmt();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35525;
						}

					} while (true);
				}
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp37_AST);
				match(ExpressParserTokenTypes.LITERAL_end_alias);
				upScope();
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(ExpressParserTokenTypes.SEMI);
				alias_stmt_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_alias))) {
				match(ExpressParserTokenTypes.LITERAL_alias);
				variable_id();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.LITERAL_for);
				general_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35527: do {
						if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35527;
						}

					} while (true);
				}
				match(ExpressParserTokenTypes.SEMI);
				stmt();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35529: do {
						if ((_tokenSet_15.member(LA(1)))) {
							stmt();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35529;
						}

					} while (true);
				}
				match(ExpressParserTokenTypes.LITERAL_end_alias);
				upScope();
				match(ExpressParserTokenTypes.SEMI);
				alias_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.ALIAS_STMT);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = alias_stmt_AST;
	}

	public final void variable_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case VARIABLE_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.VARIABLE_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				variable_id_AST = parseAST(currentAST, ExpressParserTokenTypes.VARIABLE_ID);
				break;
			}
			case ENTITY_VAR_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_VAR_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				variable_id_AST = parseAST(currentAST, ExpressParserTokenTypes.VARIABLE_ID);
				break;
			}
			case TYPE_VAR_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_VAR_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				variable_id_AST = parseAST(currentAST, ExpressParserTokenTypes.VARIABLE_ID);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(ExpressParserTokenTypes.IDENT);
					addId(id.getText(), ExpressParserTokenTypes.VARIABLE_IDENT);
					variable_id_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_17);
		}
		returnAST = variable_id_AST;
	}

	public final void qualifier() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifier_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case DOT: {
				attribute_qualifier();
				astFactory.addASTChild(currentAST, returnAST);
				qualifier_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIER);
				break;
			}
			case BACKSLASH: {
				group_qualifier();
				astFactory.addASTChild(currentAST, returnAST);
				qualifier_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIER);
				break;
			}
			case LBRACK: {
				index_qualifier();
				astFactory.addASTChild(currentAST, returnAST);
				qualifier_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIER);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_18);
		}
		returnAST = qualifier_AST;
	}

	public final void stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stmt_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_alias: {
				alias_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case PARAMETER_IDENT:
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT: {
				assignment_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_case: {
				case_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_begin: {
				compound_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_escape: {
				escape_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_if: {
				if_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case SEMI: {
				null_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case PROCEDURE_IDENT:
			case LITERAL_insert:
			case LITERAL_remove: {
				procedure_call_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_repeat: {
				repeat_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_return: {
				return_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			case LITERAL_skip: {
				skip_stmt();
				astFactory.addASTChild(currentAST, returnAST);
				stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.STMT);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					AST tmp44_AST = null;
					tmp44_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp44_AST);
					match(ExpressParserTokenTypes.IDENT);
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LBRACK:
						case COLEQ:
						case DOT:
						case BACKSLASH: {
							{
								_loop35851: do {
									if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
										qualifier();
										astFactory.addASTChild(currentAST, returnAST);
									} else {
										break _loop35851;
									}

								} while (true);
							}
							AST tmp45_AST = null;
							tmp45_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp45_AST);
							match(ExpressParserTokenTypes.COLEQ);
							expression();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case LPAREN:
						case SEMI: {
							{
								switch (ExpressParserTokenTypes.getToken(LA(1))) {
								case LPAREN: {
									actual_parameter_list();
									astFactory.addASTChild(currentAST, returnAST);
									break;
								}
								case SEMI: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
							}
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					AST tmp46_AST = null;
					tmp46_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp46_AST);
					match(ExpressParserTokenTypes.SEMI);
					stmt_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = stmt_AST;
	}

	public final void general_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_ref_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case PARAMETER_IDENT:
			case ENTITY_PARAM_IDENT:
			case TYPE_PARAM_IDENT: {
				parameter_ref();
				astFactory.addASTChild(currentAST, returnAST);
				general_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_REF);
				break;
			}
			case VARIABLE_IDENT:
			case ENTITY_VAR_IDENT:
			case TYPE_VAR_IDENT: {
				variable_ref();
				astFactory.addASTChild(currentAST, returnAST);
				general_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_18);
		}
		returnAST = general_ref_AST;
	}

	public final void bound_spec() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_spec_AST = null;

		try {
			match(ExpressParserTokenTypes.LBRACK);
			bound_1();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.COLON);
			bound_2();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.RBRACK);
			bound_spec_AST = parseAST(currentAST, ExpressParserTokenTypes.BOUND_SPEC);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_19);
		}
		returnAST = bound_spec_AST;
	}

	public final void base_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST base_type_AST = null;

		try {
			if ((_tokenSet_20.member(LA(1)))) {
				concrete_types();
				astFactory.addASTChild(currentAST, returnAST);
				base_type_AST = parseAST(currentAST, ExpressParserTokenTypes.BASE_TYPE);
			} else if ((_tokenSet_21.member(LA(1)))) {
				generalized_types();
				astFactory.addASTChild(currentAST, returnAST);
				base_type_AST = parseAST(currentAST, ExpressParserTokenTypes.BASE_TYPE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = base_type_AST;
	}

	public final void assignment_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignment_stmt_AST = null;

		try {
			{
				general_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35536: do {
						if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35536;
						}

					} while (true);
				}
			}
			match(ExpressParserTokenTypes.COLEQ);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			assignment_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.ASSIGNMENT_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = assignment_stmt_AST;
	}

	public final void expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;

		try {
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LT:
				case LE:
				case GT:
				case GE:
				case LTGT:
				case ASSIGN:
				case COLLTGT:
				case COLEQCOL:
				case LITERAL_in:
				case LITERAL_like: {
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
				case LITERAL_until: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			expression_AST = parseAST(currentAST, ExpressParserTokenTypes.EXPRESSION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_22);
		}
		returnAST = expression_AST;
	}

	public final void concrete_types() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST concrete_types_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list: {
				aggregation_types();
				astFactory.addASTChild(currentAST, returnAST);
				concrete_types_AST = parseAST(currentAST, ExpressParserTokenTypes.CONCRETE_TYPES);
				break;
			}
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string: {
				simple_types();
				astFactory.addASTChild(currentAST, returnAST);
				concrete_types_AST = parseAST(currentAST, ExpressParserTokenTypes.CONCRETE_TYPES);
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
			case IDENT: {
				named_types();
				astFactory.addASTChild(currentAST, returnAST);
				concrete_types_AST = parseAST(currentAST, ExpressParserTokenTypes.CONCRETE_TYPES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_9);
		}
		returnAST = concrete_types_AST;
	}

	public final void generalized_types() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generalized_types_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_aggregate: {
				aggregate_type();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERALIZED_TYPES);
				break;
			}
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list: {
				general_aggregation_types();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERALIZED_TYPES);
				break;
			}
			case LITERAL_generic: {
				generic_type();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERALIZED_TYPES);
				break;
			}
			case LITERAL_generic_entity: {
				generic_entity_type();
				astFactory.addASTChild(currentAST, returnAST);
				generalized_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERALIZED_TYPES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = generalized_types_AST;
	}

	public final void simple_types() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_types_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_binary: {
				binary_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			case LITERAL_boolean: {
				boolean_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			case LITERAL_integer: {
				integer_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			case LITERAL_logical: {
				logical_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			case LITERAL_number: {
				number_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			case LITERAL_real: {
				real_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			case LITERAL_string: {
				string_type();
				astFactory.addASTChild(currentAST, returnAST);
				simple_types_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_TYPES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = simple_types_AST;
	}

	public final void named_types() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST named_types_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT: {
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				named_types_AST = parseAST(currentAST, ExpressParserTokenTypes.NAMED_TYPES);
				break;
			}
			case TYPE_IDENT:
			case TYPE_ATTR_IDENT:
			case TYPE_VAR_IDENT:
			case TYPE_PARAM_IDENT: {
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				named_types_AST = parseAST(currentAST, ExpressParserTokenTypes.NAMED_TYPES);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					AST tmp52_AST = null;
					tmp52_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp52_AST);
					match(ExpressParserTokenTypes.IDENT);
					named_types_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_23);
		}
		returnAST = named_types_AST;
	}

	public final void binary_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST binary_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_binary);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					width_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case RPAREN:
				case SEMI:
				case COLEQ: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			binary_type_AST = parseAST(currentAST, ExpressParserTokenTypes.BINARY_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = binary_type_AST;
	}

	public final void width_spec() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST width_spec_AST = null;

		try {
			match(ExpressParserTokenTypes.LPAREN);
			width();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.RPAREN);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_fixed: {
					AST tmp56_AST = null;
					tmp56_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp56_AST);
					match(ExpressParserTokenTypes.LITERAL_fixed);
					break;
				}
				case RPAREN:
				case SEMI:
				case COLEQ: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			width_spec_AST = parseAST(currentAST, ExpressParserTokenTypes.WIDTH_SPEC);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = width_spec_AST;
	}

	public final void boolean_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_boolean);
			boolean_type_AST = parseAST(currentAST, ExpressParserTokenTypes.BOOLEAN_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = boolean_type_AST;
	}

	public final void bound_1() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_1_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			bound_1_AST = parseAST(currentAST, ExpressParserTokenTypes.BOUND_1);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_24);
		}
		returnAST = bound_1_AST;
	}

	public final void numeric_expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numeric_expression_AST = null;

		try {
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			numeric_expression_AST = parseAST(currentAST, ExpressParserTokenTypes.NUMERIC_EXPRESSION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_25);
		}
		returnAST = numeric_expression_AST;
	}

	public final void bound_2() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_2_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			bound_2_AST = parseAST(currentAST, ExpressParserTokenTypes.BOUND_2);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_26);
		}
		returnAST = bound_2_AST;
	}

	public final void built_in_constant() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_constant_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_const_e: {
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp58_AST);
				match(ExpressParserTokenTypes.LITERAL_const_e);
				built_in_constant_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_CONSTANT);
				break;
			}
			case LITERAL_pi: {
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(ExpressParserTokenTypes.LITERAL_pi);
				built_in_constant_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_CONSTANT);
				break;
			}
			case LITERAL_self: {
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(ExpressParserTokenTypes.LITERAL_self);
				built_in_constant_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_CONSTANT);
				break;
			}
			case QUESTION: {
				AST tmp61_AST = null;
				tmp61_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp61_AST);
				match(ExpressParserTokenTypes.QUESTION);
				built_in_constant_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_CONSTANT);
				break;
			}
			case STAR: {
				AST tmp62_AST = null;
				tmp62_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp62_AST);
				match(ExpressParserTokenTypes.STAR);
				built_in_constant_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_CONSTANT);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = built_in_constant_AST;
	}

	public final void built_in_function() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_function_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_abs: {
				AST tmp63_AST = null;
				tmp63_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp63_AST);
				match(ExpressParserTokenTypes.LITERAL_abs);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_acos: {
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(ExpressParserTokenTypes.LITERAL_acos);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_asin: {
				AST tmp65_AST = null;
				tmp65_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp65_AST);
				match(ExpressParserTokenTypes.LITERAL_asin);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_atan: {
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(ExpressParserTokenTypes.LITERAL_atan);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_blength: {
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(ExpressParserTokenTypes.LITERAL_blength);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_cos: {
				AST tmp68_AST = null;
				tmp68_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp68_AST);
				match(ExpressParserTokenTypes.LITERAL_cos);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_exists: {
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(ExpressParserTokenTypes.LITERAL_exists);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_exp: {
				AST tmp70_AST = null;
				tmp70_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp70_AST);
				match(ExpressParserTokenTypes.LITERAL_exp);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_format: {
				AST tmp71_AST = null;
				tmp71_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp71_AST);
				match(ExpressParserTokenTypes.LITERAL_format);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_hibound: {
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
				match(ExpressParserTokenTypes.LITERAL_hibound);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_hiindex: {
				AST tmp73_AST = null;
				tmp73_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp73_AST);
				match(ExpressParserTokenTypes.LITERAL_hiindex);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_length: {
				AST tmp74_AST = null;
				tmp74_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp74_AST);
				match(ExpressParserTokenTypes.LITERAL_length);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_lobound: {
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp75_AST);
				match(ExpressParserTokenTypes.LITERAL_lobound);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_loindex: {
				AST tmp76_AST = null;
				tmp76_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp76_AST);
				match(ExpressParserTokenTypes.LITERAL_loindex);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_log: {
				AST tmp77_AST = null;
				tmp77_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp77_AST);
				match(ExpressParserTokenTypes.LITERAL_log);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LOG2: {
				AST tmp78_AST = null;
				tmp78_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp78_AST);
				match(ExpressParserTokenTypes.LOG2);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LOG10: {
				AST tmp79_AST = null;
				tmp79_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp79_AST);
				match(ExpressParserTokenTypes.LOG10);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_nvl: {
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp80_AST);
				match(ExpressParserTokenTypes.LITERAL_nvl);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_odd: {
				AST tmp81_AST = null;
				tmp81_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp81_AST);
				match(ExpressParserTokenTypes.LITERAL_odd);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_rolesof: {
				AST tmp82_AST = null;
				tmp82_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp82_AST);
				match(ExpressParserTokenTypes.LITERAL_rolesof);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_sin: {
				AST tmp83_AST = null;
				tmp83_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp83_AST);
				match(ExpressParserTokenTypes.LITERAL_sin);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_sizeof: {
				AST tmp84_AST = null;
				tmp84_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp84_AST);
				match(ExpressParserTokenTypes.LITERAL_sizeof);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_sqrt: {
				AST tmp85_AST = null;
				tmp85_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp85_AST);
				match(ExpressParserTokenTypes.LITERAL_sqrt);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_tan: {
				AST tmp86_AST = null;
				tmp86_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp86_AST);
				match(ExpressParserTokenTypes.LITERAL_tan);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_typeof: {
				AST tmp87_AST = null;
				tmp87_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp87_AST);
				match(ExpressParserTokenTypes.LITERAL_typeof);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_usedin: {
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(ExpressParserTokenTypes.LITERAL_usedin);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_value: {
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp89_AST);
				match(ExpressParserTokenTypes.LITERAL_value);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_value_in: {
				AST tmp90_AST = null;
				tmp90_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp90_AST);
				match(ExpressParserTokenTypes.LITERAL_value_in);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			case LITERAL_value_unique: {
				AST tmp91_AST = null;
				tmp91_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp91_AST);
				match(ExpressParserTokenTypes.LITERAL_value_unique);
				built_in_function_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_FUNCTION);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_27);
		}
		returnAST = built_in_function_AST;
	}

	public final void built_in_procedure() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_procedure_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_insert: {
				AST tmp92_AST = null;
				tmp92_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp92_AST);
				match(ExpressParserTokenTypes.LITERAL_insert);
				built_in_procedure_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_PROCEDURE);
				break;
			}
			case LITERAL_remove: {
				AST tmp93_AST = null;
				tmp93_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp93_AST);
				match(ExpressParserTokenTypes.LITERAL_remove);
				built_in_procedure_AST = parseAST(currentAST, ExpressParserTokenTypes.BUILT_IN_PROCEDURE);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_28);
		}
		returnAST = built_in_procedure_AST;
	}

	public final void case_action() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_action_AST = null;

		try {
			case_label();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35552: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						case_label();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35552;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.COLON);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			case_action_AST = parseAST(currentAST, ExpressParserTokenTypes.CASE_ACTION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_29);
		}
		returnAST = case_action_AST;
	}

	public final void case_label() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_label_AST = null;

		try {
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			case_label_AST = parseAST(currentAST, ExpressParserTokenTypes.CASE_LABEL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_30);
		}
		returnAST = case_label_AST;
	}

	public final void case_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_case);
			selector();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_of);
			{
				_loop35556: do {
					if ((_tokenSet_2.member(LA(1)))) {
						case_action();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35556;
					}

				} while (true);
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_otherwise: {
					match(ExpressParserTokenTypes.LITERAL_otherwise);
					match(ExpressParserTokenTypes.COLON);
					stmt();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_end_case: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_end_case);
			match(ExpressParserTokenTypes.SEMI);
			case_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.CASE_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = case_stmt_AST;
	}

	public final void selector() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST selector_AST = null;

		try {
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			selector_AST = parseAST(currentAST, ExpressParserTokenTypes.SELECTOR);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_19);
		}
		returnAST = selector_AST;
	}

	public final void compound_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compound_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_begin);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35560: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35560;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.LITERAL_end);
			match(ExpressParserTokenTypes.SEMI);
			compound_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.COMPOUND_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = compound_stmt_AST;
	}

	public final void constant_body() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_body_AST = null;

		try {
			constant_id();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.COLON);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.COLEQ);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			constant_body_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTANT_BODY);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_31);
		}
		returnAST = constant_body_AST;
	}

	public final void constant_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				addId(id.getText(), ExpressParserTokenTypes.CONSTANT_IDENT);
				constant_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.CONSTANT_IDENT))) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.CONSTANT_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				constant_id_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTANT_ID);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_32);
		}
		returnAST = constant_id_AST;
	}

	public final void constant_factor() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_factor_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_const_e:
			case LITERAL_pi:
			case LITERAL_self:
			case QUESTION:
			case STAR: {
				built_in_constant();
				astFactory.addASTChild(currentAST, returnAST);
				constant_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTANT_FACTOR);
				break;
			}
			case CONSTANT_IDENT: {
				constant_ref();
				astFactory.addASTChild(currentAST, returnAST);
				constant_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTANT_FACTOR);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = constant_factor_AST;
	}

	public final void constant_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(ExpressParserTokenTypes.CONSTANT_IDENT);
			nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
			constant_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTANT_REF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_33);
		}
		returnAST = constant_ref_AST;
	}

	public final void entity_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_decl_AST = null;

		try {
			entity_head();
			astFactory.addASTChild(currentAST, returnAST);
			entity_body();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_end_entity);
			upScope();
			match(ExpressParserTokenTypes.SEMI);
			entity_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_DECL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_12);
		}
		returnAST = entity_decl_AST;
	}

	public final void subtype_constraint_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_decl_AST = null;

		try {
			subtype_constraint_head();
			astFactory.addASTChild(currentAST, returnAST);
			subtype_constraint_body();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_end_subtype_constraint);
			match(ExpressParserTokenTypes.SEMI);
			subtype_constraint_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_DECL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_12);
		}
		returnAST = subtype_constraint_decl_AST;
	}

	public final void function_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_decl_AST = null;

		try {
			function_head();
			astFactory.addASTChild(currentAST, returnAST);
			{
				if ((_tokenSet_34.member(LA(1)))) {
					algorithm_head();
					astFactory.addASTChild(currentAST, returnAST);
				} else if ((_tokenSet_15.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35668: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35668;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.LITERAL_end_function);
			match(ExpressParserTokenTypes.SEMI);
			function_decl_AST = (AST) currentAST.root;
			upScope();
			function_decl_AST = makeAST(ExpressParserTokenTypes.FUNCTION_DECL, function_decl_AST);
			currentAST.root = function_decl_AST;
			currentAST.child = getChild(function_decl_AST);
			currentAST.advanceChildToEnd();
			function_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_12);
		}
		returnAST = function_decl_AST;
	}

	public final void procedure_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_decl_AST = null;

		try {
			procedure_head();
			astFactory.addASTChild(currentAST, returnAST);
			{
				if ((_tokenSet_35.member(LA(1)))) {
					algorithm_head();
					astFactory.addASTChild(currentAST, returnAST);
				} else if ((_tokenSet_36.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				_loop35751: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35751;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.LITERAL_end_procedure);
			match(ExpressParserTokenTypes.SEMI);
			procedure_decl_AST = (AST) currentAST.root;
			upScope();
			procedure_decl_AST = makeAST(ExpressParserTokenTypes.PROCEDURE_DECL, procedure_decl_AST);
			currentAST.root = procedure_decl_AST;
			currentAST.child = getChild(procedure_decl_AST);
			currentAST.advanceChildToEnd();
			procedure_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_12);
		}
		returnAST = procedure_decl_AST;
	}

	public final void type_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_decl_AST = null;

		String id = null;
		EnumerationType eids = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_type);
			id = type_id();
			astFactory.addASTChild(currentAST, returnAST);
			newScope();
			match(ExpressParserTokenTypes.ASSIGN);
			eids = underlying_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_where: {
					where_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_end_type: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_end_type);
			match(ExpressParserTokenTypes.SEMI);
			type_decl_AST = (AST) currentAST.root;
			upScope();
			if (eids != null) {
				eids.setTypeName(id);
				currentScope.addEnumerationType(eids);
			}
			type_decl_AST = makeAST(ExpressParserTokenTypes.TYPE_DECL, type_decl_AST);
			currentAST.root = type_decl_AST;
			currentAST.child = getChild(type_decl_AST);
			currentAST.advanceChildToEnd();
			type_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_12);
		}
		returnAST = type_decl_AST;
	}

	public final void domain_rule() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST domain_rule_AST = null;

		try {
			if (((_tokenSet_2.member(LA(1)))) && (isFirst && (LA(2) != ExpressParserTokenTypes.COLON.getIndex()))) {
				logical_expression();
				astFactory.addASTChild(currentAST, returnAST);
				domain_rule_AST = (AST) currentAST.root;
			} else if ((_tokenSet_2.member(LA(1)))) {
				{
					if ((LA1Equals(ExpressParserTokenTypes.IDENT))) {
						label();
						astFactory.addASTChild(currentAST, returnAST);
						match(ExpressParserTokenTypes.COLON);
					} else if ((_tokenSet_2.member(LA(1)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				logical_expression();
				astFactory.addASTChild(currentAST, returnAST);
				domain_rule_AST = parseAST(currentAST, ExpressParserTokenTypes.DOMAIN_RULE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = domain_rule_AST;
	}

	public final void logical_expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_expression_AST = null;

		try {
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			logical_expression_AST = parseAST(currentAST, ExpressParserTokenTypes.LOGICAL_EXPRESSION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_38);
		}
		returnAST = logical_expression_AST;
	}

	public final void label() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST label_AST = null;

		try {
			AST tmp122_AST = null;
			tmp122_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp122_AST);
			match(ExpressParserTokenTypes.IDENT);
			label_AST = parseAST(currentAST, ExpressParserTokenTypes.LABEL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_32);
		}
		returnAST = label_AST;
	}

	public final void repetition() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repetition_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			repetition_AST = parseAST(currentAST, ExpressParserTokenTypes.REPETITION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_4);
		}
		returnAST = repetition_AST;
	}

	public final void entity_head() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_head_AST = null;
		String id = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_entity);
			id = entity_id();
			astFactory.addASTChild(currentAST, returnAST);
			newEntityScope(id);
			{
				if (((LA1Equals(ExpressParserTokenTypes.LITERAL_abstract))) && (LA(2) != ExpressParserTokenTypes.LITERAL_supertype.getIndex())) {
					AST tmp124_AST = null;
					tmp124_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp124_AST);
					match(ExpressParserTokenTypes.LITERAL_abstract);
				} else if ((_tokenSet_39.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				if ((_tokenSet_39.member(LA(1)))) {
					subsuper();
					astFactory.addASTChild(currentAST, returnAST);
				} else if ((_tokenSet_40.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case SEMI: {
					match(ExpressParserTokenTypes.SEMI);
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			entity_head_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_HEAD);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_41);
		}
		returnAST = entity_head_AST;
	}

	public final String entity_id() throws RecognitionException, TokenStreamException {
		String eid;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token id2 = null;
		AST id2_AST = null;
		eid = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT.getIndex());
				eid = id.getText();
				addId(eid, ExpressParserTokenTypes.ENTITY_IDENT);
				entity_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.ENTITY_IDENT))) {
				id2 = LT(1);
				id2_AST = astFactory.create(id2);
				astFactory.addASTChild(currentAST, id2_AST);
				match(ExpressParserTokenTypes.ENTITY_IDENT);
				entity_id_AST = (AST) currentAST.root;
				eid = id2.getText();
				id2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				entity_id_AST = makeAST(ExpressParserTokenTypes.ENTITY_ID, entity_id_AST);

				currentAST.root = entity_id_AST;
				currentAST.child = getChild(entity_id_AST);
				currentAST.advanceChildToEnd();
				entity_id_AST = (AST) currentAST.root;
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_42);
		}
		returnAST = entity_id_AST;
		return eid;
	}

	public final void subsuper() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subsuper_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_abstract:
				case LITERAL_supertype: {
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_subtype: {
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			subsuper_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBSUPER);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_40);
		}
		returnAST = subsuper_AST;
	}

	public final void entity_body() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_body_AST = null;

		try {
			{
				_loop35579: do {
					if ((_tokenSet_43.member(LA(1)))) {
						explicit_attr();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35579;
					}

				} while (true);
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_derive: {
					derive_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_unique:
				case LITERAL_end_entity:
				case LITERAL_inverse:
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_inverse: {
					inverse_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_unique:
				case LITERAL_end_entity:
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_unique: {
					unique_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_end_entity:
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_where: {
					where_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_end_entity: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			entity_body_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_BODY);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_44);
		}
		returnAST = entity_body_AST;
	}

	public final void explicit_attr() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST explicit_attr_AST = null;

		try {
			attribute_decl();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35612: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						attribute_decl();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35612;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.COLON);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_optional: {
					AST tmp128_AST = null;
					tmp128_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp128_AST);
					match(ExpressParserTokenTypes.LITERAL_optional);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			explicit_attr_AST = parseAST(currentAST, ExpressParserTokenTypes.EXPLICIT_ATTR);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_41);
		}
		returnAST = explicit_attr_AST;
	}

	public final void derive_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST derive_clause_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_derive);
			derived_attr();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35621: do {
					if ((_tokenSet_43.member(LA(1)))) {
						derived_attr();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35621;
					}

				} while (true);
			}
			derive_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.DERIVE_CLAUSE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_45);
		}
		returnAST = derive_clause_AST;
	}

	public final void inverse_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inverse_clause_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_inverse);
			inverse_attr();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35625: do {
					if ((_tokenSet_43.member(LA(1)))) {
						inverse_attr();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35625;
					}

				} while (true);
			}
			inverse_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.INVERSE_CLAUSE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_46);
		}
		returnAST = inverse_clause_AST;
	}

	public final void unique_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unique_clause_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_unique);
			unique_rule();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			{
				_loop35635: do {
					if ((_tokenSet_43.member(LA(1)))) {
						unique_rule();
						astFactory.addASTChild(currentAST, returnAST);
						match(ExpressParserTokenTypes.SEMI);
					} else {
						break _loop35635;
					}

				} while (true);
			}
			unique_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.UNIQUE_CLAUSE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_47);
		}
		returnAST = unique_clause_AST;
	}

	public final void where_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST where_clause_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_where);
			domain_rule();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			{
				_loop35910: do {
					if ((_tokenSet_2.member(LA(1)))) {
						domain_rule();
						astFactory.addASTChild(currentAST, returnAST);
						match(ExpressParserTokenTypes.SEMI);
					} else {
						break _loop35910;
					}

				} while (true);
			}
			where_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.WHERE_CLAUSE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_48);
		}
		returnAST = where_clause_AST;
	}

	public final void supertype_constraint() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_constraint_AST = null;

		try {
			if ((LA1Equals(ExpressParserTokenTypes.LITERAL_abstract))) {
				abstract_supertype_declaration();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_constraint_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_CONSTRAINT);
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_abstract) || LA1Equals(ExpressParserTokenTypes.LITERAL_supertype))) {
				supertype_rule();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_constraint_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_CONSTRAINT);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_49);
		}
		returnAST = supertype_constraint_AST;
	}

	public final void subtype_declaration() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_declaration_AST = null;
		Token id = null;
		AST id_AST = null;
		Token id2 = null;
		AST id2_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_subtype))) && (isFirst)) {
				AST tmp138_AST = null;
				tmp138_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp138_AST);
				match(ExpressParserTokenTypes.LITERAL_subtype);
				AST tmp139_AST = null;
				tmp139_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp139_AST);
				match(ExpressParserTokenTypes.LITERAL_of);
				AST tmp140_AST = null;
				tmp140_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp140_AST);
				match(ExpressParserTokenTypes.LPAREN);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				addSuper(id.getText());
				{
					_loop35592: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							AST tmp141_AST = null;
							tmp141_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp141_AST);
							match(ExpressParserTokenTypes.COMMA);
							id2 = LT(1);
							id2_AST = astFactory.create(id2);
							astFactory.addASTChild(currentAST, id2_AST);
							match(ExpressParserTokenTypes.IDENT);
							addSuper(id2.getText());
						} else {
							break _loop35592;
						}

					} while (true);
				}
				AST tmp142_AST = null;
				tmp142_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp142_AST);
				match(ExpressParserTokenTypes.RPAREN);
				{
					if ((LA1Equals(ExpressParserTokenTypes.SEMI))) {
						AST tmp143_AST = null;
						tmp143_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp143_AST);
						match(ExpressParserTokenTypes.SEMI);
					} else if ((_tokenSet_40.member(LA(1)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				subtype_declaration_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_subtype))) {
				match(ExpressParserTokenTypes.LITERAL_subtype);
				match(ExpressParserTokenTypes.LITERAL_of);
				match(ExpressParserTokenTypes.LPAREN);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35595: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							match(ExpressParserTokenTypes.COMMA);
							entity_ref();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35595;
						}

					} while (true);
				}
				match(ExpressParserTokenTypes.RPAREN);
				{
					if ((LA1Equals(ExpressParserTokenTypes.SEMI))) {
						match(ExpressParserTokenTypes.SEMI);
					} else if ((_tokenSet_40.member(LA(1)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				subtype_declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBTYPE_DECLARATION);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_40);
		}
		returnAST = subtype_declaration_AST;
	}

	public final void abstract_supertype_declaration() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abstract_supertype_declaration_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_abstract);
			match(ExpressParserTokenTypes.LITERAL_supertype);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_of: {
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			abstract_supertype_declaration_AST = parseAST(currentAST, ExpressParserTokenTypes.ABSTRACT_SUPERTYPE_DECLARATION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_49);
		}
		returnAST = abstract_supertype_declaration_AST;
	}

	public final void supertype_rule() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_rule_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_abstract: {
					AST tmp152_AST = null;
					tmp152_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp152_AST);
					match(ExpressParserTokenTypes.LITERAL_abstract);
					break;
				}
				case LITERAL_supertype: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_supertype);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_of: {
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
				case LITERAL_where: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			supertype_rule_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_RULE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_49);
		}
		returnAST = supertype_rule_AST;
	}

	public final void subtype_constraint() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_of);
			match(ExpressParserTokenTypes.LPAREN);
			supertype_expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.RPAREN);
			{
				if ((LA1Equals(ExpressParserTokenTypes.SEMI))) {
					match(ExpressParserTokenTypes.SEMI);
				} else if ((_tokenSet_49.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			subtype_constraint_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBTYPE_CONSTRAINT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_49);
		}
		returnAST = subtype_constraint_AST;
	}

	public final void entity_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;
		Token nid4 = null;
		AST nid4_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ENTITY_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.ENTITY_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				entity_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_REF);
				break;
			}
			case ENTITY_ATTR_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_ATTR_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				entity_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_REF);
				break;
			}
			case ENTITY_VAR_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.ENTITY_VAR_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				entity_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_REF);
				break;
			}
			case ENTITY_PARAM_IDENT: {
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				astFactory.addASTChild(currentAST, nid4_AST);
				match(ExpressParserTokenTypes.ENTITY_PARAM_IDENT);
				nid4_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				entity_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_50);
		}
		returnAST = entity_ref_AST;
	}

	public final void subtype_constraint_head() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_head_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_subtype_constraint))) && (isFirst)) {
				AST tmp158_AST = null;
				tmp158_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp158_AST);
				match(ExpressParserTokenTypes.LITERAL_subtype_constraint);
				subtype_constraint_id();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp159_AST = null;
				tmp159_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp159_AST);
				match(ExpressParserTokenTypes.LITERAL_for);
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp160_AST);
				match(ExpressParserTokenTypes.IDENT);
				AST tmp161_AST = null;
				tmp161_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp161_AST);
				match(ExpressParserTokenTypes.SEMI);
				subtype_constraint_head_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_subtype_constraint))) {
				match(ExpressParserTokenTypes.LITERAL_subtype_constraint);
				subtype_constraint_id();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.LITERAL_for);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.SEMI);
				subtype_constraint_head_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_HEAD);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_51);
		}
		returnAST = subtype_constraint_head_AST;
	}

	public final void subtype_constraint_body() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_body_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_abstract: {
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
				case LITERAL_oneof: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_total_over: {
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
				case LITERAL_oneof: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case ENTITY_IDENT:
				case ENTITY_ATTR_IDENT:
				case ENTITY_VAR_IDENT:
				case ENTITY_PARAM_IDENT:
				case LPAREN:
				case IDENT:
				case LITERAL_oneof: {
					supertype_expression();
					astFactory.addASTChild(currentAST, returnAST);
					match(ExpressParserTokenTypes.SEMI);
					break;
				}
				case LITERAL_end_subtype_constraint: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			subtype_constraint_body_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_BODY);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_52);
		}
		returnAST = subtype_constraint_body_AST;
	}

	public final void subtype_constraint_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token id2 = null;
		AST id2_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				addId(id.getText(), ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_ID);
				subtype_constraint_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_ID))) {
				id2 = LT(1);
				id2_AST = astFactory.create(id2);
				astFactory.addASTChild(currentAST, id2_AST);
				match(ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_ID);
				id2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				subtype_constraint_id_AST = parseAST(currentAST, ExpressParserTokenTypes.SUBTYPE_CONSTRAINT_ID);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_53);
		}
		returnAST = subtype_constraint_id_AST;
	}

	public final void abstract_supertype() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abstract_supertype_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_abstract);
			match(ExpressParserTokenTypes.LITERAL_supertype);
			match(ExpressParserTokenTypes.SEMI);
			abstract_supertype_AST = parseAST(currentAST, ExpressParserTokenTypes.ABSTRACT_SUPERTYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_54);
		}
		returnAST = abstract_supertype_AST;
	}

	public final void total_over() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST total_over_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_total_over))) && (isFirst)) {
				AST tmp169_AST = null;
				tmp169_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp169_AST);
				match(ExpressParserTokenTypes.LITERAL_total_over);
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp170_AST);
				match(ExpressParserTokenTypes.LPAREN);
				AST tmp171_AST = null;
				tmp171_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp171_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					_loop35607: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							AST tmp172_AST = null;
							tmp172_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp172_AST);
							match(ExpressParserTokenTypes.COMMA);
							AST tmp173_AST = null;
							tmp173_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp173_AST);
							match(ExpressParserTokenTypes.IDENT);
						} else {
							break _loop35607;
						}

					} while (true);
				}
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp174_AST);
				match(ExpressParserTokenTypes.LPAREN);
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp175_AST);
				match(ExpressParserTokenTypes.SEMI);
				total_over_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_total_over))) {
				match(ExpressParserTokenTypes.LITERAL_total_over);
				match(ExpressParserTokenTypes.LPAREN);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35609: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							match(ExpressParserTokenTypes.COMMA);
							entity_ref();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35609;
						}

					} while (true);
				}
				match(ExpressParserTokenTypes.LPAREN);
				match(ExpressParserTokenTypes.SEMI);
				total_over_AST = parseAST(currentAST, ExpressParserTokenTypes.TOTAL_OVER);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_55);
		}
		returnAST = total_over_AST;
	}

	public final void supertype_expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_expression_AST = null;

		try {
			supertype_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35859: do {
					if ((LA1Equals(ExpressParserTokenTypes.LITERAL_andor))) {
						match(ExpressParserTokenTypes.LITERAL_andor);
						supertype_factor();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35859;
					}

				} while (true);
			}
			supertype_expression_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_EXPRESSION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_56);
		}
		returnAST = supertype_expression_AST;
	}

	public final void attribute_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_decl_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT:
			case IDENT: {
				attribute_id();
				astFactory.addASTChild(currentAST, returnAST);
				attribute_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_DECL);
				break;
			}
			case LITERAL_self: {
				redeclared_attribute();
				astFactory.addASTChild(currentAST, returnAST);
				attribute_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_DECL);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_30);
		}
		returnAST = attribute_decl_AST;
	}

	public final void attribute_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid1 = null;
		AST nid1_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ATTRIBUTE_IDENT: {
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				astFactory.addASTChild(currentAST, nid1_AST);
				match(ExpressParserTokenTypes.ATTRIBUTE_IDENT);
				nid1_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				attribute_id_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_ID);
				break;
			}
			case ENTITY_ATTR_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_ATTR_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				attribute_id_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_ID);
				break;
			}
			case TYPE_ATTR_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_ATTR_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				attribute_id_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_ID);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(ExpressParserTokenTypes.IDENT);
					addId(id.getText(), ExpressParserTokenTypes.ATTRIBUTE_IDENT);
					attribute_id_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_30);
		}
		returnAST = attribute_id_AST;
	}

	public final void redeclared_attribute() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST redeclared_attribute_AST = null;

		try {
			qualified_attribute();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_renamed: {
					match(ExpressParserTokenTypes.LITERAL_renamed);
					attribute_id();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				case COLON: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			redeclared_attribute_AST = parseAST(currentAST, ExpressParserTokenTypes.REDECLARED_ATTRIBUTE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_30);
		}
		returnAST = redeclared_attribute_AST;
	}

	public final void qualified_attribute() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualified_attribute_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_self);
			group_qualifier();
			astFactory.addASTChild(currentAST, returnAST);
			attribute_qualifier();
			astFactory.addASTChild(currentAST, returnAST);
			qualified_attribute_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIED_ATTRIBUTE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_57);
		}
		returnAST = qualified_attribute_AST;
	}

	public final void group_qualifier() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST group_qualifier_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.BACKSLASH))) && (isFirst)) {
				AST tmp184_AST = null;
				tmp184_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp184_AST);
				match(ExpressParserTokenTypes.BACKSLASH);
				AST tmp185_AST = null;
				tmp185_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp185_AST);
				match(ExpressParserTokenTypes.IDENT);
				group_qualifier_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
				match(ExpressParserTokenTypes.BACKSLASH);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				group_qualifier_AST = parseAST(currentAST, ExpressParserTokenTypes.GROUP_QUALIFIER);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_18);
		}
		returnAST = group_qualifier_AST;
	}

	public final void attribute_qualifier() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_qualifier_AST = null;

		try {
			match(ExpressParserTokenTypes.DOT);
			global_ident();
			astFactory.addASTChild(currentAST, returnAST);
			attribute_qualifier_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_QUALIFIER);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_58);
		}
		returnAST = attribute_qualifier_AST;
	}

	public final void derived_attr() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST derived_attr_AST = null;

		try {
			attribute_decl();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.COLON);
			base_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.COLEQ);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			derived_attr_AST = parseAST(currentAST, ExpressParserTokenTypes.DERIVED_ATTR);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_59);
		}
		returnAST = derived_attr_AST;
	}

	public final void inverse_attr() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inverse_attr_AST = null;

		try {
			if (((_tokenSet_43.member(LA(1)))) && (isFirst)) {
				attribute_decl();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp191_AST = null;
				tmp191_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp191_AST);
				match(ExpressParserTokenTypes.COLON);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_bag:
					case LITERAL_set: {
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case LITERAL_set: {
								AST tmp192_AST = null;
								tmp192_AST = astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp192_AST);
								match(ExpressParserTokenTypes.LITERAL_set);
								break;
							}
							case LITERAL_bag: {
								AST tmp193_AST = null;
								tmp193_AST = astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp193_AST);
								match(ExpressParserTokenTypes.LITERAL_bag);
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case LBRACK: {
								bound_spec();
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							case LITERAL_of: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						AST tmp194_AST = null;
						tmp194_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp194_AST);
						match(ExpressParserTokenTypes.LITERAL_of);
						break;
					}
					case IDENT: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				AST tmp195_AST = null;
				tmp195_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp195_AST);
				match(ExpressParserTokenTypes.IDENT);
				AST tmp196_AST = null;
				tmp196_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp196_AST);
				match(ExpressParserTokenTypes.LITERAL_for);
				AST tmp197_AST = null;
				tmp197_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp197_AST);
				match(ExpressParserTokenTypes.IDENT);
				AST tmp198_AST = null;
				tmp198_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp198_AST);
				match(ExpressParserTokenTypes.SEMI);
				inverse_attr_AST = (AST) currentAST.root;
			} else if ((_tokenSet_43.member(LA(1)))) {
				attribute_decl();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.COLON);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_bag:
					case LITERAL_set: {
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case LITERAL_set: {
								AST tmp200_AST = null;
								tmp200_AST = astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp200_AST);
								match(ExpressParserTokenTypes.LITERAL_set);
								break;
							}
							case LITERAL_bag: {
								AST tmp201_AST = null;
								tmp201_AST = astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp201_AST);
								match(ExpressParserTokenTypes.LITERAL_bag);
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case LBRACK: {
								bound_spec();
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							case LITERAL_of: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						match(ExpressParserTokenTypes.LITERAL_of);
						break;
					}
					case ENTITY_IDENT:
					case ENTITY_ATTR_IDENT:
					case ENTITY_VAR_IDENT:
					case ENTITY_PARAM_IDENT: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.LITERAL_for);
				global_ident();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.SEMI);
				inverse_attr_AST = parseAST(currentAST, ExpressParserTokenTypes.INVERSE_ATTR);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_60);
		}
		returnAST = inverse_attr_AST;
	}

	/**** special rule ****/
	public final void global_ident() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST global_ident_AST = null;
		Token nid1 = null;
		AST nid1_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;
		Token nid4 = null;
		AST nid4_AST = null;
		Token nid5 = null;
		AST nid5_AST = null;
		Token nid6 = null;
		AST nid6_AST = null;
		Token nid7 = null;
		AST nid7_AST = null;
		Token nid8 = null;
		AST nid8_AST = null;
		Token nid9 = null;
		AST nid9_AST = null;
		Token nid10 = null;
		AST nid10_AST = null;
		Token nid11 = null;
		AST nid11_AST = null;
		Token nid12 = null;
		AST nid12_AST = null;
		Token nid13 = null;
		AST nid13_AST = null;
		Token nid14 = null;
		AST nid14_AST = null;
		Token nid15 = null;
		AST nid15_AST = null;
		Token nid16 = null;
		AST nid16_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case IDENT: {
				AST tmp205_AST = null;
				tmp205_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp205_AST);
				match(ExpressParserTokenTypes.IDENT);
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case CONSTANT_IDENT: {
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				astFactory.addASTChild(currentAST, nid1_AST);
				match(ExpressParserTokenTypes.CONSTANT_IDENT);
				nid1_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ENTITY_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case FUNCTION_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.FUNCTION_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case PROCEDURE_IDENT: {
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				astFactory.addASTChild(currentAST, nid4_AST);
				match(ExpressParserTokenTypes.PROCEDURE_IDENT);
				nid4_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case PARAMETER_IDENT: {
				nid5 = LT(1);
				nid5_AST = astFactory.create(nid5);
				astFactory.addASTChild(currentAST, nid5_AST);
				match(ExpressParserTokenTypes.PARAMETER_IDENT);
				nid5_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case SCHEMA_IDENT: {
				nid6 = LT(1);
				nid6_AST = astFactory.create(nid6);
				astFactory.addASTChild(currentAST, nid6_AST);
				match(ExpressParserTokenTypes.SCHEMA_IDENT);
				nid6_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case TYPE_IDENT: {
				nid7 = LT(1);
				nid7_AST = astFactory.create(nid7);
				astFactory.addASTChild(currentAST, nid7_AST);
				match(ExpressParserTokenTypes.TYPE_IDENT);
				nid7_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case VARIABLE_IDENT: {
				nid8 = LT(1);
				nid8_AST = astFactory.create(nid8);
				astFactory.addASTChild(currentAST, nid8_AST);
				match(ExpressParserTokenTypes.VARIABLE_IDENT);
				nid8_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ENUMERATION_IDENT: {
				nid9 = LT(1);
				nid9_AST = astFactory.create(nid9);
				astFactory.addASTChild(currentAST, nid9_AST);
				match(ExpressParserTokenTypes.ENUMERATION_IDENT);
				nid9_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ATTRIBUTE_IDENT: {
				nid10 = LT(1);
				nid10_AST = astFactory.create(nid10);
				astFactory.addASTChild(currentAST, nid10_AST);
				match(ExpressParserTokenTypes.ATTRIBUTE_IDENT);
				nid10_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ENTITY_ATTR_IDENT: {
				nid11 = LT(1);
				nid11_AST = astFactory.create(nid11);
				astFactory.addASTChild(currentAST, nid11_AST);
				match(ExpressParserTokenTypes.ENTITY_ATTR_IDENT);
				nid11_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case TYPE_ATTR_IDENT: {
				nid12 = LT(1);
				nid12_AST = astFactory.create(nid12);
				astFactory.addASTChild(currentAST, nid12_AST);
				match(ExpressParserTokenTypes.TYPE_ATTR_IDENT);
				nid12_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ENTITY_VAR_IDENT: {
				nid13 = LT(1);
				nid13_AST = astFactory.create(nid13);
				astFactory.addASTChild(currentAST, nid13_AST);
				match(ExpressParserTokenTypes.ENTITY_VAR_IDENT);
				nid13_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case TYPE_VAR_IDENT: {
				nid14 = LT(1);
				nid14_AST = astFactory.create(nid14);
				astFactory.addASTChild(currentAST, nid14_AST);
				match(ExpressParserTokenTypes.TYPE_VAR_IDENT);
				nid14_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ENTITY_PARAM_IDENT: {
				nid15 = LT(1);
				nid15_AST = astFactory.create(nid15);
				astFactory.addASTChild(currentAST, nid15_AST);
				match(ExpressParserTokenTypes.ENTITY_PARAM_IDENT);
				nid15_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case TYPE_PARAM_IDENT: {
				nid16 = LT(1);
				nid16_AST = astFactory.create(nid16);
				astFactory.addASTChild(currentAST, nid16_AST);
				match(ExpressParserTokenTypes.TYPE_PARAM_IDENT);
				nid16_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				global_ident_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_61);
		}
		returnAST = global_ident_AST;
	}

	public final void unique_rule() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unique_rule_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT) || LA1Equals(ExpressParserTokenTypes.LITERAL_self))) && (isFirst)) {
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case IDENT: {
						AST tmp206_AST = null;
						tmp206_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp206_AST);
						match(ExpressParserTokenTypes.IDENT);
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case COLON: {
								AST tmp207_AST = null;
								tmp207_AST = astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp207_AST);
								match(ExpressParserTokenTypes.COLON);
								referenced_attribute();
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							case COMMA:
							case SEMI: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						break;
					}
					case LITERAL_self: {
						qualified_attribute();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				{
					_loop35640: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							AST tmp208_AST = null;
							tmp208_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp208_AST);
							match(ExpressParserTokenTypes.COMMA);
							referenced_attribute();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35640;
						}

					} while (true);
				}
				unique_rule_AST = (AST) currentAST.root;
			} else if ((_tokenSet_43.member(LA(1)))) {
				{
					if ((LA1Equals(ExpressParserTokenTypes.IDENT))) {
						label();
						astFactory.addASTChild(currentAST, returnAST);
						match(ExpressParserTokenTypes.COLON);
					} else if ((_tokenSet_43.member(LA(1)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				referenced_attribute();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35643: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							match(ExpressParserTokenTypes.COMMA);
							referenced_attribute();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35643;
						}

					} while (true);
				}
				unique_rule_AST = parseAST(currentAST, ExpressParserTokenTypes.UNIQUE_RULE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = unique_rule_AST;
	}

	public final void referenced_attribute() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST referenced_attribute_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ATTRIBUTE_IDENT:
			case ENTITY_ATTR_IDENT:
			case TYPE_ATTR_IDENT: {
				attribute_ref();
				astFactory.addASTChild(currentAST, returnAST);
				referenced_attribute_AST = parseAST(currentAST, ExpressParserTokenTypes.REFERENCED_ATTRIBUTE);
				break;
			}
			case LITERAL_self: {
				qualified_attribute();
				astFactory.addASTChild(currentAST, returnAST);
				referenced_attribute_AST = parseAST(currentAST, ExpressParserTokenTypes.REFERENCED_ATTRIBUTE);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					AST tmp211_AST = null;
					tmp211_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp211_AST);
					match(ExpressParserTokenTypes.IDENT);
					referenced_attribute_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_62);
		}
		returnAST = referenced_attribute_AST;
	}

	public final void attribute_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_ref_AST = null;
		Token nid1 = null;
		AST nid1_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ATTRIBUTE_IDENT: {
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				astFactory.addASTChild(currentAST, nid1_AST);
				match(ExpressParserTokenTypes.ATTRIBUTE_IDENT);
				nid1_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				attribute_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case ENTITY_ATTR_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_ATTR_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				attribute_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			case TYPE_ATTR_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_ATTR_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				attribute_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ATTRIBUTE_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = attribute_ref_AST;
	}

	public final void entity_constructor() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_constructor_AST = null;

		try {
			entity_ref();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LPAREN);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
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
				case LOG2:
				case LOG10:
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
				case LITERAL_not: {
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop35648: do {
							if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
								match(ExpressParserTokenTypes.COMMA);
								expression();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35648;
							}

						} while (true);
					}
					break;
				}
				case RPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.RPAREN);
			entity_constructor_AST = parseAST(currentAST, ExpressParserTokenTypes.ENTITY_CONSTRUCTOR);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = entity_constructor_AST;
	}

	public final void enumeration_reference() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_reference_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				AST tmp215_AST = null;
				tmp215_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp215_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case DOT: {
						AST tmp216_AST = null;
						tmp216_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp216_AST);
						match(ExpressParserTokenTypes.DOT);
						AST tmp217_AST = null;
						tmp217_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp217_AST);
						match(ExpressParserTokenTypes.IDENT);
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
					case LITERAL_while: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				enumeration_reference_AST = (AST) currentAST.root;
			} else if ((_tokenSet_63.member(LA(1)))) {
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case TYPE_IDENT:
					case TYPE_ATTR_IDENT:
					case TYPE_VAR_IDENT:
					case TYPE_PARAM_IDENT: {
						type_ref();
						astFactory.addASTChild(currentAST, returnAST);
						match(ExpressParserTokenTypes.DOT);
						break;
					}
					case ENUMERATION_IDENT: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				enumeration_ref();
				astFactory.addASTChild(currentAST, returnAST);
				enumeration_reference_AST = parseAST(currentAST, ExpressParserTokenTypes.ENUMERATION_REFERENCE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = enumeration_reference_AST;
	}

	public final void type_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;
		Token nid4 = null;
		AST nid4_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case TYPE_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.TYPE_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				type_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_REF);
				break;
			}
			case TYPE_ATTR_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.TYPE_ATTR_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				type_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_REF);
				break;
			}
			case TYPE_VAR_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_VAR_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				type_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_REF);
				break;
			}
			case TYPE_PARAM_IDENT: {
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				astFactory.addASTChild(currentAST, nid4_AST);
				match(ExpressParserTokenTypes.TYPE_PARAM_IDENT);
				nid4_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				type_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_64);
		}
		returnAST = type_ref_AST;
	}

	public final void enumeration_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(ExpressParserTokenTypes.ENUMERATION_IDENT);
			nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
			enumeration_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.ENUMERATION_REF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = enumeration_ref_AST;
	}

	public final void escape_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST escape_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_escape);
			match(ExpressParserTokenTypes.SEMI);
			escape_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.ESCAPE_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = escape_stmt_AST;
	}

	public final void rel_op_extended() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_op_extended_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LT:
			case LE:
			case GT:
			case GE:
			case LTGT:
			case ASSIGN:
			case COLLTGT:
			case COLEQCOL: {
				rel_op();
				astFactory.addASTChild(currentAST, returnAST);
				rel_op_extended_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP_EXTENDED);
				break;
			}
			case LITERAL_in: {
				AST tmp221_AST = null;
				tmp221_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp221_AST);
				match(ExpressParserTokenTypes.LITERAL_in);
				rel_op_extended_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP_EXTENDED);
				break;
			}
			case LITERAL_like: {
				AST tmp222_AST = null;
				tmp222_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp222_AST);
				match(ExpressParserTokenTypes.LITERAL_like);
				rel_op_extended_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP_EXTENDED);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_2);
		}
		returnAST = rel_op_extended_AST;
	}

	public final void factor() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST factor_AST = null;

		try {
			simple_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case DOUBLESTAR: {
					match(ExpressParserTokenTypes.DOUBLESTAR);
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
				case LITERAL_while: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			factor_AST = parseAST(currentAST, ExpressParserTokenTypes.FACTOR);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_65);
		}
		returnAST = factor_AST;
	}

	public final void simple_factor() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_factor_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LBRACK: {
				aggregate_initializer();
				astFactory.addASTChild(currentAST, returnAST);
				simple_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_FACTOR);
				break;
			}
			case LCURLY: {
				interval();
				astFactory.addASTChild(currentAST, returnAST);
				simple_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_FACTOR);
				break;
			}
			case LITERAL_query: {
				query_expression();
				astFactory.addASTChild(currentAST, returnAST);
				simple_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_FACTOR);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.PLUS) || LA1Equals(ExpressParserTokenTypes.MINUS) || LA1Equals(ExpressParserTokenTypes.LITERAL_not))) && (isFirst)) {
					unary_op();
					astFactory.addASTChild(currentAST, returnAST);
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LPAREN: {
							AST tmp224_AST = null;
							tmp224_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp224_AST);
							match(ExpressParserTokenTypes.LPAREN);
							expression();
							astFactory.addASTChild(currentAST, returnAST);
							AST tmp225_AST = null;
							tmp225_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp225_AST);
							match(ExpressParserTokenTypes.RPAREN);
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
						case LOG2:
						case LOG10:
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
						case LITERAL_unknown: {
							primary();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					simple_factor_AST = (AST) currentAST.root;
				} else if (((LA1Equals(ExpressParserTokenTypes.LPAREN))) && (isFirst)) {
					AST tmp226_AST = null;
					tmp226_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp226_AST);
					match(ExpressParserTokenTypes.LPAREN);
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp227_AST = null;
					tmp227_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp227_AST);
					match(ExpressParserTokenTypes.RPAREN);
					simple_factor_AST = (AST) currentAST.root;
				} else if (((_tokenSet_66.member(LA(1)))) && (isFirst)) {
					literal();
					astFactory.addASTChild(currentAST, returnAST);
					simple_factor_AST = (AST) currentAST.root;
				} else if ((((LA(1) >= ExpressParserTokenTypes.LITERAL_const_e.getIndex() && LA(1) <= ExpressParserTokenTypes.STAR.getIndex()))) && (isFirst)) {
					built_in_constant();
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop35832: do {
							if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
								qualifier();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35832;
							}

						} while (true);
					}
					simple_factor_AST = (AST) currentAST.root;
				} else if ((((LA(1) >= ExpressParserTokenTypes.LITERAL_abs.getIndex() && LA(1) <= ExpressParserTokenTypes.LITERAL_value_unique.getIndex()))) && (isFirst)) {
					built_in_function();
					astFactory.addASTChild(currentAST, returnAST);
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LPAREN: {
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
						case LITERAL_while: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					{
						_loop35835: do {
							if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
								qualifier();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35835;
							}

						} while (true);
					}
					simple_factor_AST = (AST) currentAST.root;
				} else if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					AST tmp228_AST = null;
					tmp228_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp228_AST);
					match(ExpressParserTokenTypes.IDENT);
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LPAREN: {
							AST tmp229_AST = null;
							tmp229_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp229_AST);
							match(ExpressParserTokenTypes.LPAREN);
							{
								switch (ExpressParserTokenTypes.getToken(LA(1))) {
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
								case LOG2:
								case LOG10:
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
								case LITERAL_not: {
									expression();
									astFactory.addASTChild(currentAST, returnAST);
									{
										_loop35839: do {
											if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
												AST tmp230_AST = null;
												tmp230_AST = astFactory.create(LT(1));
												astFactory.addASTChild(currentAST, tmp230_AST);
												match(ExpressParserTokenTypes.COMMA);
												expression();
												astFactory.addASTChild(currentAST, returnAST);
											} else {
												break _loop35839;
											}

										} while (true);
									}
									break;
								}
								case RPAREN: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
							}
							AST tmp231_AST = null;
							tmp231_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp231_AST);
							match(ExpressParserTokenTypes.RPAREN);
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
						case LITERAL_while: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					{
						if ((LA1Equals(ExpressParserTokenTypes.DOT))) {
							AST tmp232_AST = null;
							tmp232_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp232_AST);
							match(ExpressParserTokenTypes.DOT);
							AST tmp233_AST = null;
							tmp233_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp233_AST);
							match(ExpressParserTokenTypes.IDENT);
						} else if ((_tokenSet_0.member(LA(1)))) {
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}

					}
					{
						_loop35842: do {
							if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
								qualifier();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35842;
							}

						} while (true);
					}
					simple_factor_AST = (AST) currentAST.root;
				} else if (((_tokenSet_67.member(LA(1)))) && (LA(2) == ExpressParserTokenTypes.LPAREN.getIndex())) {
					entity_constructor();
					astFactory.addASTChild(currentAST, returnAST);
					simple_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_FACTOR);
				} else if (((_tokenSet_68.member(LA(1))))
						&& (LA1Equals(ExpressParserTokenTypes.ENUMERATION_IDENT) || LA(3) == ExpressParserTokenTypes.ENUMERATION_IDENT.getIndex())) {
					enumeration_reference();
					astFactory.addASTChild(currentAST, returnAST);
					simple_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_FACTOR);
				} else if ((_tokenSet_69.member(LA(1)))) {
					{
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case PLUS:
							case MINUS:
							case LITERAL_not: {
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
							case LOG2:
							case LOG10:
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
							case LITERAL_unknown: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
						{
							switch (ExpressParserTokenTypes.getToken(LA(1))) {
							case LPAREN: {
								match(ExpressParserTokenTypes.LPAREN);
								expression();
								astFactory.addASTChild(currentAST, returnAST);
								match(ExpressParserTokenTypes.RPAREN);
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
							case LOG2:
							case LOG10:
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
							case LITERAL_unknown: {
								primary();
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							default: {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
						}
					}
					simple_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_FACTOR);
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = simple_factor_AST;
	}

	public final void formal_parameter() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST formal_parameter_AST = null;

		try {
			parameter_id();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35660: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						parameter_id();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35660;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.COLON);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			formal_parameter_AST = parseAST(currentAST, ExpressParserTokenTypes.FORMAL_PARAMETER);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_70);
		}
		returnAST = formal_parameter_AST;
	}

	public final void parameter_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case PARAMETER_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.PARAMETER_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				parameter_id_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_ID);
				break;
			}
			case ENTITY_PARAM_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_PARAM_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				parameter_id_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_ID);
				break;
			}
			case TYPE_PARAM_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_PARAM_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				parameter_id_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_ID);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(ExpressParserTokenTypes.IDENT);
					addId(id.getText(), ExpressParserTokenTypes.PARAMETER_IDENT);
					parameter_id_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_30);
		}
		returnAST = parameter_id_AST;
	}

	public final void function_call() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_call_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
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
				case LOG2:
				case LOG10:
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
				case LITERAL_value_unique: {
					built_in_function();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case FUNCTION_IDENT: {
					function_ref();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
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
				case LITERAL_while: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			function_call_AST = parseAST(currentAST, ExpressParserTokenTypes.FUNCTION_CALL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = function_call_AST;
	}

	public final void function_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(ExpressParserTokenTypes.FUNCTION_IDENT);
			nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
			function_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.FUNCTION_REF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_71);
		}
		returnAST = function_ref_AST;
	}

	public final void function_head() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_head_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_function);
			function_id();
			astFactory.addASTChild(currentAST, returnAST);
			newScope();
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					match(ExpressParserTokenTypes.LPAREN);
					formal_parameter();
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop35672: do {
							if ((LA1Equals(ExpressParserTokenTypes.SEMI))) {
								match(ExpressParserTokenTypes.SEMI);
								formal_parameter();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35672;
							}

						} while (true);
					}
					match(ExpressParserTokenTypes.RPAREN);
					break;
				}
				case COLON: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.COLON);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			function_head_AST = parseAST(currentAST, ExpressParserTokenTypes.FUNCTION_HEAD);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_34);
		}
		returnAST = function_head_AST;
	}

	public final void function_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				addId(id.getText(), ExpressParserTokenTypes.FUNCTION_IDENT);
				function_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.FUNCTION_IDENT))) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.FUNCTION_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				function_id_AST = parseAST(currentAST, ExpressParserTokenTypes.FUNCTION_ID);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_72);
		}
		returnAST = function_id_AST;
	}

	public final void general_aggregation_types() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_aggregation_types_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_array: {
				general_array_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_AGGREGATION_TYPES);
				break;
			}
			case LITERAL_bag: {
				general_bag_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_AGGREGATION_TYPES);
				break;
			}
			case LITERAL_list: {
				general_list_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_AGGREGATION_TYPES);
				break;
			}
			case LITERAL_set: {
				general_set_type();
				astFactory.addASTChild(currentAST, returnAST);
				general_aggregation_types_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_AGGREGATION_TYPES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = general_aggregation_types_AST;
	}

	public final void generic_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generic_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_generic);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case COLON: {
					match(ExpressParserTokenTypes.COLON);
					type_label();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case RPAREN:
				case SEMI:
				case COLEQ: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			generic_type_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERIC_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = generic_type_AST;
	}

	public final void generic_entity_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generic_entity_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_generic_entity);
			generic_entity_type_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERIC_ENTITY_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = generic_entity_type_AST;
	}

	public final void general_array_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_array_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_array);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_optional: {
					AST tmp249_AST = null;
					tmp249_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp249_AST);
					match(ExpressParserTokenTypes.LITERAL_optional);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_unique: {
					AST tmp250_AST = null;
					tmp250_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp250_AST);
					match(ExpressParserTokenTypes.LITERAL_unique);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_array_type_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_ARRAY_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = general_array_type_AST;
	}

	public final void general_bag_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_bag_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_bag);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_bag_type_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_BAG_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = general_bag_type_AST;
	}

	public final void general_list_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_list_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_list);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_unique: {
					AST tmp255_AST = null;
					tmp255_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp255_AST);
					match(ExpressParserTokenTypes.LITERAL_unique);
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
				case LITERAL_string: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_list_type_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_LIST_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = general_list_type_AST;
	}

	public final void general_set_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_set_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_set);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LBRACK: {
					bound_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_of: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_of);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			general_set_type_AST = parseAST(currentAST, ExpressParserTokenTypes.GENERAL_SET_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = general_set_type_AST;
	}

	public final void parameter_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case PARAMETER_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.PARAMETER_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				parameter_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_REF);
				break;
			}
			case ENTITY_PARAM_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_PARAM_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				parameter_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_REF);
				break;
			}
			case TYPE_PARAM_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_PARAM_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				parameter_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.PARAMETER_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_18);
		}
		returnAST = parameter_ref_AST;
	}

	public final void variable_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case VARIABLE_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.VARIABLE_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				variable_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.VARIABLE_REF);
				break;
			}
			case ENTITY_VAR_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				astFactory.addASTChild(currentAST, nid2_AST);
				match(ExpressParserTokenTypes.ENTITY_VAR_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				variable_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.VARIABLE_REF);
				break;
			}
			case TYPE_VAR_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				astFactory.addASTChild(currentAST, nid3_AST);
				match(ExpressParserTokenTypes.TYPE_VAR_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				variable_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.VARIABLE_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_18);
		}
		returnAST = variable_ref_AST;
	}

	public final void if_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST if_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_if);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_then);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35694: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35694;
					}

				} while (true);
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_else: {
					else_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_end_if: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_end_if);
			match(ExpressParserTokenTypes.SEMI);
			if_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.IF_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = if_stmt_AST;
	}

	public final void else_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST else_clause_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_else);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35698: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35698;
					}

				} while (true);
			}
			else_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.ELSE_CLAUSE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_73);
		}
		returnAST = else_clause_AST;
	}

	public final void increment() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST increment_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			increment_AST = parseAST(currentAST, ExpressParserTokenTypes.INCREMENT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_74);
		}
		returnAST = increment_AST;
	}

	public final void increment_control() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST increment_control_AST = null;

		try {
			variable_id();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.COLEQ);
			bound_1();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_to);
			bound_2();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_by: {
					match(ExpressParserTokenTypes.LITERAL_by);
					increment();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case LITERAL_until:
				case LITERAL_while: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			increment_control_AST = parseAST(currentAST, ExpressParserTokenTypes.INCREMENT_CONTROL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_74);
		}
		returnAST = increment_control_AST;
	}

	public final void index() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			index_AST = parseAST(currentAST, ExpressParserTokenTypes.INDEX);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_75);
		}
		returnAST = index_AST;
	}

	public final void index_1() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_1_AST = null;

		try {
			index();
			astFactory.addASTChild(currentAST, returnAST);
			index_1_AST = parseAST(currentAST, ExpressParserTokenTypes.INDEX_1);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_75);
		}
		returnAST = index_1_AST;
	}

	public final void index_2() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_2_AST = null;

		try {
			index();
			astFactory.addASTChild(currentAST, returnAST);
			index_2_AST = parseAST(currentAST, ExpressParserTokenTypes.INDEX_2);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_76);
		}
		returnAST = index_2_AST;
	}

	public final void index_qualifier() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_qualifier_AST = null;

		try {
			match(ExpressParserTokenTypes.LBRACK);
			index_1();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case COLON: {
					match(ExpressParserTokenTypes.COLON);
					index_2();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case RBRACK: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.RBRACK);
			index_qualifier_AST = parseAST(currentAST, ExpressParserTokenTypes.INDEX_QUALIFIER);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_18);
		}
		returnAST = index_qualifier_AST;
	}

	public final void integer_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integer_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_integer);
			integer_type_AST = parseAST(currentAST, ExpressParserTokenTypes.INTEGER_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = integer_type_AST;
	}

	public final void interval() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_AST = null;

		try {
			match(ExpressParserTokenTypes.LCURLY);
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
			match(ExpressParserTokenTypes.RCURLY);
			interval_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERVAL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = interval_AST;
	}

	public final void interval_low() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_low_AST = null;

		try {
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			interval_low_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERVAL_LOW);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_77);
		}
		returnAST = interval_low_AST;
	}

	public final void interval_op() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_op_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LT: {
				AST tmp272_AST = null;
				tmp272_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp272_AST);
				match(ExpressParserTokenTypes.LT);
				interval_op_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERVAL_OP);
				break;
			}
			case LE: {
				AST tmp273_AST = null;
				tmp273_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp273_AST);
				match(ExpressParserTokenTypes.LE);
				interval_op_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERVAL_OP);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_2);
		}
		returnAST = interval_op_AST;
	}

	public final void interval_item() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_item_AST = null;

		try {
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			interval_item_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERVAL_ITEM);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_77);
		}
		returnAST = interval_item_AST;
	}

	public final void interval_high() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_high_AST = null;

		try {
			simple_expression();
			astFactory.addASTChild(currentAST, returnAST);
			interval_high_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERVAL_HIGH);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_78);
		}
		returnAST = interval_high_AST;
	}

	public final void literal() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST literal_AST = null;
		Token i = null;
		AST i_AST = null;
		Token f = null;
		AST f_AST = null;
		AST ll_AST = null;
		Token sl = null;
		AST sl_AST = null;

		boolean fl = false;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case INT: {
				i = LT(1);
				i_AST = astFactory.create(i);
				match(ExpressParserTokenTypes.INT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case FLOAT: {
						f = LT(1);
						f_AST = astFactory.create(f);
						match(ExpressParserTokenTypes.FLOAT);
						fl = true;
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
					case LITERAL_while: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				literal_AST = (AST) currentAST.root;
				if (fl) {
					f_AST.setText(i.getText() + f.getText());
					literal_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.LITERAL.getIndex(), "LITERAL")).add(
							(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.REAL.getIndex(), "REAL")).add(f_AST))));
				} else
					literal_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.LITERAL.getIndex(), "LITERAL")).add(
							(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.INTEGER.getIndex(), "INTEGER")).add(i_AST))));

				currentAST.root = literal_AST;
				currentAST.child = getChild(literal_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			case LITERAL_false:
			case LITERAL_true:
			case LITERAL_unknown: {
				logical();
				ll_AST = (AST) returnAST;
				literal_AST = (AST) currentAST.root;
				literal_AST = makeAST(ExpressParserTokenTypes.LITERAL, ll_AST);
				currentAST.root = literal_AST;
				currentAST.child = getChild(literal_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			case STRING: {
				sl = LT(1);
				sl_AST = astFactory.create(sl);
				match(ExpressParserTokenTypes.STRING);
				literal_AST = (AST) currentAST.root;
				literal_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.LITERAL.getIndex(), "LITERAL")).add(
						(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.STRING.getIndex(), "STRING")).add(sl_AST))));
				currentAST.root = literal_AST;
				currentAST.child = getChild(literal_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = literal_AST;
	}

	public final void logical() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_false: {
				AST tmp274_AST = null;
				tmp274_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp274_AST);
				match(ExpressParserTokenTypes.LITERAL_false);
				logical_AST = parseAST(currentAST, ExpressParserTokenTypes.LOGICAL);
				break;
			}
			case LITERAL_true: {
				AST tmp275_AST = null;
				tmp275_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp275_AST);
				match(ExpressParserTokenTypes.LITERAL_true);
				logical_AST = parseAST(currentAST, ExpressParserTokenTypes.LOGICAL);
				break;
			}
			case LITERAL_unknown: {
				AST tmp276_AST = null;
				tmp276_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp276_AST);
				match(ExpressParserTokenTypes.LITERAL_unknown);
				logical_AST = parseAST(currentAST, ExpressParserTokenTypes.LOGICAL);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = logical_AST;
	}

	public final void local_variable() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST local_variable_AST = null;

		try {
			variable_id();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35724: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						variable_id();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35724;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.COLON);
			parameter_type();
			astFactory.addASTChild(currentAST, returnAST);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case COLEQ: {
					match(ExpressParserTokenTypes.COLEQ);
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.SEMI);
			local_variable_AST = parseAST(currentAST, ExpressParserTokenTypes.LOCAL_VARIABLE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_79);
		}
		returnAST = local_variable_AST;
	}

	public final void logical_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_logical);
			logical_type_AST = parseAST(currentAST, ExpressParserTokenTypes.LOGICAL_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = logical_type_AST;
	}

	public final void multiplication_like_op() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiplication_like_op_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case STAR: {
				AST tmp282_AST = null;
				tmp282_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp282_AST);
				match(ExpressParserTokenTypes.STAR);
				multiplication_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.MULTIPLICATION_LIKE_OP);
				break;
			}
			case DIVSIGN: {
				AST tmp283_AST = null;
				tmp283_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp283_AST);
				match(ExpressParserTokenTypes.DIVSIGN);
				multiplication_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.MULTIPLICATION_LIKE_OP);
				break;
			}
			case LITERAL_div: {
				AST tmp284_AST = null;
				tmp284_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp284_AST);
				match(ExpressParserTokenTypes.LITERAL_div);
				multiplication_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.MULTIPLICATION_LIKE_OP);
				break;
			}
			case LITERAL_mod: {
				AST tmp285_AST = null;
				tmp285_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp285_AST);
				match(ExpressParserTokenTypes.LITERAL_mod);
				multiplication_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.MULTIPLICATION_LIKE_OP);
				break;
			}
			case LITERAL_and: {
				AST tmp286_AST = null;
				tmp286_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp286_AST);
				match(ExpressParserTokenTypes.LITERAL_and);
				multiplication_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.MULTIPLICATION_LIKE_OP);
				break;
			}
			case DOUBLEBAR: {
				AST tmp287_AST = null;
				tmp287_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp287_AST);
				match(ExpressParserTokenTypes.DOUBLEBAR);
				multiplication_like_op_AST = parseAST(currentAST, ExpressParserTokenTypes.MULTIPLICATION_LIKE_OP);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_2);
		}
		returnAST = multiplication_like_op_AST;
	}

	public final void null_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST null_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.SEMI);
			null_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.NULL_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = null_stmt_AST;
	}

	public final void number_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_number);
			number_type_AST = parseAST(currentAST, ExpressParserTokenTypes.NUMBER_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = number_type_AST;
	}

	public final void one_of() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_of_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_oneof);
			match(ExpressParserTokenTypes.LPAREN);
			supertype_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35736: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						supertype_expression();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35736;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.RPAREN);
			one_of_AST = parseAST(currentAST, ExpressParserTokenTypes.ONE_OF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_80);
		}
		returnAST = one_of_AST;
	}

	public final void population() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST population_AST = null;

		try {
			entity_ref();
			astFactory.addASTChild(currentAST, returnAST);
			population_AST = parseAST(currentAST, ExpressParserTokenTypes.POPULATION);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = population_AST;
	}

	public final void precision_spec() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST precision_spec_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			precision_spec_AST = parseAST(currentAST, ExpressParserTokenTypes.PRECISION_SPEC);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_81);
		}
		returnAST = precision_spec_AST;
	}

	public final void primary() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primary_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case INT:
			case STRING:
			case LITERAL_false:
			case LITERAL_true:
			case LITERAL_unknown: {
				literal();
				astFactory.addASTChild(currentAST, returnAST);
				primary_AST = parseAST(currentAST, ExpressParserTokenTypes.PRIMARY);
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
			case LOG2:
			case LOG10:
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
			case LITERAL_value_unique: {
				qualifiable_factor();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35744: do {
						if ((LA1Equals(ExpressParserTokenTypes.LBRACK) || LA1Equals(ExpressParserTokenTypes.DOT) || LA1Equals(ExpressParserTokenTypes.BACKSLASH))) {
							qualifier();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35744;
						}

					} while (true);
				}
				primary_AST = parseAST(currentAST, ExpressParserTokenTypes.PRIMARY);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = primary_AST;
	}

	public final void qualifiable_factor() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifiable_factor_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				AST tmp294_AST = null;
				tmp294_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp294_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LPAREN: {
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
					case LITERAL_while: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				qualifiable_factor_AST = (AST) currentAST.root;
			} else if ((((LA(1) >= ExpressParserTokenTypes.LITERAL_const_e.getIndex() && LA(1) <= ExpressParserTokenTypes.STAR.getIndex()))) && (isFirst)) {
				built_in_constant();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = (AST) currentAST.root;
			} else if ((((LA(1) >= ExpressParserTokenTypes.LITERAL_abs.getIndex() && LA(1) <= ExpressParserTokenTypes.LITERAL_value_unique.getIndex()))) && (isFirst)) {
				built_in_function();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LPAREN: {
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
					case LITERAL_while: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				qualifiable_factor_AST = (AST) currentAST.root;
			} else if (((LA(1) >= ExpressParserTokenTypes.ATTRIBUTE_IDENT.getIndex() && LA(1) <= ExpressParserTokenTypes.TYPE_ATTR_IDENT.getIndex()))) {
				attribute_ref();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIABLE_FACTOR);
			} else if ((_tokenSet_82.member(LA(1)))) {
				constant_factor();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIABLE_FACTOR);
			} else if ((_tokenSet_83.member(LA(1)))) {
				function_call();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIABLE_FACTOR);
			} else if ((_tokenSet_67.member(LA(1)))) {
				population();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIABLE_FACTOR);
			} else if ((_tokenSet_84.member(LA(1)))) {
				general_ref();
				astFactory.addASTChild(currentAST, returnAST);
				qualifiable_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.QUALIFIABLE_FACTOR);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_0);
		}
		returnAST = qualifiable_factor_AST;
	}

	public final void procedure_call_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_call_stmt_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_insert:
				case LITERAL_remove: {
					built_in_procedure();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PROCEDURE_IDENT: {
					procedure_ref();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					actual_parameter_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.SEMI);
			procedure_call_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.PROCEDURE_CALL_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = procedure_call_stmt_AST;
	}

	public final void procedure_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(ExpressParserTokenTypes.PROCEDURE_IDENT);
			nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
			procedure_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.PROCEDURE_REF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_85);
		}
		returnAST = procedure_ref_AST;
	}

	public final void procedure_head() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_head_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_procedure);
			procedure_id();
			astFactory.addASTChild(currentAST, returnAST);
			newScope();
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					match(ExpressParserTokenTypes.LPAREN);
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LITERAL_var: {
							AST tmp298_AST = null;
							tmp298_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp298_AST);
							match(ExpressParserTokenTypes.LITERAL_var);
							break;
						}
						case PARAMETER_IDENT:
						case ENTITY_PARAM_IDENT:
						case TYPE_PARAM_IDENT:
						case IDENT: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					formal_parameter();
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop35757: do {
							if ((LA1Equals(ExpressParserTokenTypes.SEMI))) {
								match(ExpressParserTokenTypes.SEMI);
								{
									switch (ExpressParserTokenTypes.getToken(LA(1))) {
									case LITERAL_var: {
										AST tmp300_AST = null;
										tmp300_AST = astFactory.create(LT(1));
										astFactory.addASTChild(currentAST, tmp300_AST);
										match(ExpressParserTokenTypes.LITERAL_var);
										break;
									}
									case PARAMETER_IDENT:
									case ENTITY_PARAM_IDENT:
									case TYPE_PARAM_IDENT:
									case IDENT: {
										break;
									}
									default: {
										throw new NoViableAltException(LT(1), getFilename());
									}
									}
								}
								formal_parameter();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop35757;
							}

						} while (true);
					}
					match(ExpressParserTokenTypes.RPAREN);
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.SEMI);
			procedure_head_AST = parseAST(currentAST, ExpressParserTokenTypes.PROCEDURE_HEAD);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_35);
		}
		returnAST = procedure_head_AST;
	}

	public final void procedure_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				addId(id.getText(), ExpressParserTokenTypes.PROCEDURE_IDENT);
				procedure_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.PROCEDURE_IDENT))) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.PROCEDURE_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				procedure_id_AST = parseAST(currentAST, ExpressParserTokenTypes.PROCEDURE_ID);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_28);
		}
		returnAST = procedure_id_AST;
	}

	public final void query_expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST query_expression_AST = null;
		if (isFirst)
			newScope1();

		try {
			match(ExpressParserTokenTypes.LITERAL_query);
			match(ExpressParserTokenTypes.LPAREN);
			variable_id();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LTSTAR);
			aggregate_source();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.BAR);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.RPAREN);
			query_expression_AST = (AST) currentAST.root;
			upScope();
			query_expression_AST = makeAST(ExpressParserTokenTypes.QUERY_EXPRESSION, query_expression_AST);

			currentAST.root = query_expression_AST;
			currentAST.child = getChild(query_expression_AST);
			currentAST.advanceChildToEnd();
			query_expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_3);
		}
		returnAST = query_expression_AST;
	}

	public final void real_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST real_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_real);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					match(ExpressParserTokenTypes.LPAREN);
					precision_spec();
					astFactory.addASTChild(currentAST, returnAST);
					match(ExpressParserTokenTypes.RPAREN);
					break;
				}
				case RPAREN:
				case SEMI:
				case COLEQ: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			real_type_AST = parseAST(currentAST, ExpressParserTokenTypes.REAL_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = real_type_AST;
	}

	public final void reference_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reference_clause_AST = null;
		Token id = null;
		AST id_AST = null;

		ExternalId ei = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_reference))) && (isFirst)) {
				AST tmp311_AST = null;
				tmp311_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp311_AST);
				match(ExpressParserTokenTypes.LITERAL_reference);
				AST tmp312_AST = null;
				tmp312_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp312_AST);
				match(ExpressParserTokenTypes.LITERAL_from);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LPAREN: {
						AST tmp313_AST = null;
						tmp313_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp313_AST);
						match(ExpressParserTokenTypes.LPAREN);
						ei = resource_or_rename();
						astFactory.addASTChild(currentAST, returnAST);
						ei.setSchema(id.getText());
						addExternal(ei);
						{
							_loop35769: do {
								if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
									AST tmp314_AST = null;
									tmp314_AST = astFactory.create(LT(1));
									astFactory.addASTChild(currentAST, tmp314_AST);
									match(ExpressParserTokenTypes.COMMA);
									ei = resource_or_rename();
									astFactory.addASTChild(currentAST, returnAST);
									ei.setSchema(id.getText());
									addExternal(ei);
								} else {
									break _loop35769;
								}

							} while (true);
						}
						AST tmp315_AST = null;
						tmp315_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp315_AST);
						match(ExpressParserTokenTypes.RPAREN);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				AST tmp316_AST = null;
				tmp316_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp316_AST);
				match(ExpressParserTokenTypes.SEMI);
				if (ei == null)
					addAllReferenceExternals(id.getText());
				reference_clause_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_reference))) {
				match(ExpressParserTokenTypes.LITERAL_reference);
				match(ExpressParserTokenTypes.LITERAL_from);
				schema_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LPAREN: {
						match(ExpressParserTokenTypes.LPAREN);
						resource_or_rename();
						astFactory.addASTChild(currentAST, returnAST);
						{
							_loop35772: do {
								if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
									match(ExpressParserTokenTypes.COMMA);
									resource_or_rename();
									astFactory.addASTChild(currentAST, returnAST);
								} else {
									break _loop35772;
								}

							} while (true);
						}
						match(ExpressParserTokenTypes.RPAREN);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(ExpressParserTokenTypes.SEMI);
				reference_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.REFERENCE_CLAUSE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_86);
		}
		returnAST = reference_clause_AST;
	}

	public final ExternalId resource_or_rename() throws RecognitionException, TokenStreamException {
		ExternalId ei;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST resource_or_rename_AST = null;
		Token id = null;
		AST id_AST = null;

		ei = null;
		String s = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				ei = new ExternalId(id.getText());
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_as: {
						AST tmp323_AST = null;
						tmp323_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp323_AST);
						match(ExpressParserTokenTypes.LITERAL_as);
						s = rename_id();
						astFactory.addASTChild(currentAST, returnAST);
						ei.setRename(s);
						break;
					}
					case COMMA:
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				resource_or_rename_AST = (AST) currentAST.root;
			} else if ((_tokenSet_87.member(LA(1)))) {
				resource_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_as: {
						match(ExpressParserTokenTypes.LITERAL_as);
						rename_id();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case COMMA:
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				resource_or_rename_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_OR_RENAME);
			} else if ((_tokenSet_88.member(LA(1)))) {
				global_ident();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_as: {
						match(ExpressParserTokenTypes.LITERAL_as);
						rename_id();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case COMMA:
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				resource_or_rename_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_OR_RENAME);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_1);
		}
		returnAST = resource_or_rename_AST;
		return ei;
	}

	public final void schema_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_ref_AST = null;
		Token nid = null;
		AST nid_AST = null;

		try {
			nid = LT(1);
			nid_AST = astFactory.create(nid);
			astFactory.addASTChild(currentAST, nid_AST);
			match(ExpressParserTokenTypes.SCHEMA_IDENT);
			nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
			schema_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.SCHEMA_REF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_28);
		}
		returnAST = schema_ref_AST;
	}

	public final void rel_op() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_op_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LT: {
				AST tmp326_AST = null;
				tmp326_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp326_AST);
				match(ExpressParserTokenTypes.LT);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case GT: {
				AST tmp327_AST = null;
				tmp327_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp327_AST);
				match(ExpressParserTokenTypes.GT);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case LE: {
				AST tmp328_AST = null;
				tmp328_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp328_AST);
				match(ExpressParserTokenTypes.LE);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case GE: {
				AST tmp329_AST = null;
				tmp329_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp329_AST);
				match(ExpressParserTokenTypes.GE);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case LTGT: {
				AST tmp330_AST = null;
				tmp330_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp330_AST);
				match(ExpressParserTokenTypes.LTGT);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case ASSIGN: {
				AST tmp331_AST = null;
				tmp331_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp331_AST);
				match(ExpressParserTokenTypes.ASSIGN);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case COLLTGT: {
				AST tmp332_AST = null;
				tmp332_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp332_AST);
				match(ExpressParserTokenTypes.COLLTGT);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			case COLEQCOL: {
				AST tmp333_AST = null;
				tmp333_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp333_AST);
				match(ExpressParserTokenTypes.COLEQCOL);
				rel_op_AST = parseAST(currentAST, ExpressParserTokenTypes.REL_OP);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_2);
		}
		returnAST = rel_op_AST;
	}

	public final String rename_id() throws RecognitionException, TokenStreamException {
		String s;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rename_id_AST = null;
		Token id = null;
		Token nid1 = null;
		AST nid1_AST = null;
		Token nid2 = null;
		AST nid2_AST = null;
		Token nid3 = null;
		AST nid3_AST = null;
		Token nid4 = null;
		AST nid4_AST = null;
		Token nid5 = null;
		AST nid5_AST = null;
		s = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case IDENT: {
				id = LT(1);
				astFactory.create(id);
				match(ExpressParserTokenTypes.IDENT);
				s = id.getText();
				break;
			}
			case CONSTANT_IDENT: {
				nid1 = LT(1);
				nid1_AST = astFactory.create(nid1);
				match(ExpressParserTokenTypes.CONSTANT_IDENT);
				nid1_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				rename_id_AST = (AST) currentAST.root;
				rename_id_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.RENAME_ID.getIndex(), "RENAME_ID")).add(
						(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.CONSTANT_ID.getIndex(), "CONSTANT_ID")).add(nid1_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = getChild(rename_id_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			case ENTITY_IDENT: {
				nid2 = LT(1);
				nid2_AST = astFactory.create(nid2);
				match(ExpressParserTokenTypes.ENTITY_IDENT);
				nid2_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				rename_id_AST = (AST) currentAST.root;
				rename_id_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.RENAME_ID.getIndex(), "RENAME_ID")).add(
						(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.ENTITY_ID.getIndex(), "ENTITY_ID")).add(nid2_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = getChild(rename_id_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			case FUNCTION_IDENT: {
				nid3 = LT(1);
				nid3_AST = astFactory.create(nid3);
				match(ExpressParserTokenTypes.FUNCTION_IDENT);
				nid3_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				rename_id_AST = (AST) currentAST.root;
				rename_id_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.RENAME_ID.getIndex(), "RENAME_ID")).add(
						(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.FUNCTION_ID.getIndex(), "FUNCTION_ID")).add(nid3_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = getChild(rename_id_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			case PROCEDURE_IDENT: {
				nid4 = LT(1);
				nid4_AST = astFactory.create(nid4);
				match(ExpressParserTokenTypes.PROCEDURE_IDENT);
				nid4_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				rename_id_AST = (AST) currentAST.root;
				rename_id_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.RENAME_ID.getIndex(), "RENAME_ID")).add(
						(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.PROCEDURE_ID.getIndex(), "PROCEDURE_ID")).add(nid4_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = getChild(rename_id_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			case TYPE_IDENT: {
				nid5 = LT(1);
				nid5_AST = astFactory.create(nid5);
				match(ExpressParserTokenTypes.TYPE_IDENT);
				nid5_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				rename_id_AST = (AST) currentAST.root;
				rename_id_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.RENAME_ID.getIndex(), "RENAME_ID")).add(
						(AST) astFactory.make((new ASTArray(2)).add(astFactory.create(ExpressParserTokenTypes.TYPE_ID.getIndex(), "TYPE_ID")).add(nid5_AST))));
				currentAST.root = rename_id_AST;
				currentAST.child = getChild(rename_id_AST);
				currentAST.advanceChildToEnd();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_1);
		}
		returnAST = rename_id_AST;
		return s;
	}

	public final void repeat_control() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repeat_control_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case VARIABLE_IDENT:
				case ENTITY_VAR_IDENT:
				case TYPE_VAR_IDENT:
				case IDENT: {
					increment_control();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case LITERAL_until:
				case LITERAL_while: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_while: {
					while_control();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case LITERAL_until: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_until: {
					until_control();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			repeat_control_AST = parseAST(currentAST, ExpressParserTokenTypes.REPEAT_CONTROL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = repeat_control_AST;
	}

	public final void while_control() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST while_control_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_while);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			while_control_AST = parseAST(currentAST, ExpressParserTokenTypes.WHILE_CONTROL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_89);
		}
		returnAST = while_control_AST;
	}

	public final void until_control() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST until_control_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_until);
			logical_expression();
			astFactory.addASTChild(currentAST, returnAST);
			until_control_AST = parseAST(currentAST, ExpressParserTokenTypes.UNTIL_CONTROL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = until_control_AST;
	}

	public final void repeat_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repeat_stmt_AST = null;
		if (isFirst)
			newScope1();

		try {
			match(ExpressParserTokenTypes.LITERAL_repeat);
			repeat_control();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.SEMI);
			stmt();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35782: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35782;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.LITERAL_end_repeat);
			upScope();
			match(ExpressParserTokenTypes.SEMI);
			repeat_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.REPEAT_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = repeat_stmt_AST;
	}

	public final void resource_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST resource_ref_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case CONSTANT_IDENT: {
				constant_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_REF);
				break;
			}
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT: {
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_REF);
				break;
			}
			case FUNCTION_IDENT: {
				function_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_REF);
				break;
			}
			case PROCEDURE_IDENT: {
				procedure_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_REF);
				break;
			}
			case TYPE_IDENT:
			case TYPE_ATTR_IDENT:
			case TYPE_VAR_IDENT:
			case TYPE_PARAM_IDENT: {
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				resource_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.RESOURCE_REF);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_90);
		}
		returnAST = resource_ref_AST;
	}

	public final void return_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST return_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_return);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					match(ExpressParserTokenTypes.LPAREN);
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					match(ExpressParserTokenTypes.RPAREN);
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.SEMI);
			return_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.RETURN_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = return_stmt_AST;
	}

	public final void rule_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_decl_AST = null;

		try {
			rule_head();
			astFactory.addASTChild(currentAST, returnAST);
			{
				if ((_tokenSet_91.member(LA(1)))) {
					algorithm_head();
					astFactory.addASTChild(currentAST, returnAST);
				} else if ((_tokenSet_92.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				_loop35794: do {
					if ((_tokenSet_15.member(LA(1)))) {
						stmt();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35794;
					}

				} while (true);
			}
			where_clause();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_end_rule);
			upScope();
			match(ExpressParserTokenTypes.SEMI);
			rule_decl_AST = parseAST(currentAST, ExpressParserTokenTypes.RULE_DECL);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_93);
		}
		returnAST = rule_decl_AST;
	}

	public final void rule_head() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_head_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_rule))) && (isFirst)) {
				AST tmp346_AST = null;
				tmp346_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp346_AST);
				match(ExpressParserTokenTypes.LITERAL_rule);
				rule_id();
				astFactory.addASTChild(currentAST, returnAST);
				newScope1();
				AST tmp347_AST = null;
				tmp347_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp347_AST);
				match(ExpressParserTokenTypes.LITERAL_for);
				AST tmp348_AST = null;
				tmp348_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp348_AST);
				match(ExpressParserTokenTypes.LPAREN);
				AST tmp349_AST = null;
				tmp349_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp349_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					_loop35797: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							AST tmp350_AST = null;
							tmp350_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp350_AST);
							match(ExpressParserTokenTypes.COMMA);
							AST tmp351_AST = null;
							tmp351_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp351_AST);
							match(ExpressParserTokenTypes.IDENT);
						} else {
							break _loop35797;
						}

					} while (true);
				}
				AST tmp352_AST = null;
				tmp352_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp352_AST);
				match(ExpressParserTokenTypes.RPAREN);
				AST tmp353_AST = null;
				tmp353_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp353_AST);
				match(ExpressParserTokenTypes.SEMI);
				rule_head_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_rule))) {
				match(ExpressParserTokenTypes.LITERAL_rule);
				rule_id();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.LITERAL_for);
				match(ExpressParserTokenTypes.LPAREN);
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop35799: do {
						if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
							match(ExpressParserTokenTypes.COMMA);
							entity_ref();
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop35799;
						}

					} while (true);
				}
				match(ExpressParserTokenTypes.RPAREN);
				match(ExpressParserTokenTypes.SEMI);
				rule_head_AST = parseAST(currentAST, ExpressParserTokenTypes.RULE_HEAD);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_91);
		}
		returnAST = rule_head_AST;
	}

	public final void rule_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_id_AST = null;

		try {
			AST tmp360_AST = null;
			tmp360_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp360_AST);
			match(ExpressParserTokenTypes.IDENT);
			rule_id_AST = parseAST(currentAST, ExpressParserTokenTypes.RULE_ID);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_53);
		}
		returnAST = rule_id_AST;
	}

	public final String schema_id() throws RecognitionException, TokenStreamException {
		String s;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;
		s = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case IDENT: {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				schema_id_AST = (AST) currentAST.root;
				s = id.getText();
				addId(s, ExpressParserTokenTypes.SCHEMA_IDENT);
				schema_id_AST = makeAST(ExpressParserTokenTypes.SCHEMA_ID, schema_id_AST);
				currentAST.root = schema_id_AST;
				currentAST.child = getChild(schema_id_AST);
				currentAST.advanceChildToEnd();
				schema_id_AST = (AST) currentAST.root;
				break;
			}
			case SCHEMA_IDENT: {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.SCHEMA_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				schema_id_AST = parseAST(currentAST, ExpressParserTokenTypes.SCHEMA_ID);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_94);
		}
		returnAST = schema_id_AST;
		return s;
	}

	public final void schema_body() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_body_AST = null;

		try {
			{
				_loop35804: do {
					if ((LA1Equals(ExpressParserTokenTypes.LITERAL_reference) || LA1Equals(ExpressParserTokenTypes.LITERAL_use))) {
						interface_specification();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35804;
					}

				} while (true);
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_constant: {
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
				case LITERAL_type: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				_loop35807: do {
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_entity:
					case LITERAL_subtype_constraint:
					case LITERAL_function:
					case LITERAL_procedure:
					case LITERAL_type: {
						declaration();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LITERAL_rule: {
						rule_decl();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default: {
						break _loop35807;
					}
					}
				} while (true);
			}
			schema_body_AST = parseAST(currentAST, ExpressParserTokenTypes.SCHEMA_BODY);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_95);
		}
		returnAST = schema_body_AST;
	}

	public final void interface_specification() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interface_specification_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_reference: {
				reference_clause();
				astFactory.addASTChild(currentAST, returnAST);
				interface_specification_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERFACE_SPECIFICATION);
				break;
			}
			case LITERAL_use: {
				use_clause();
				astFactory.addASTChild(currentAST, returnAST);
				interface_specification_AST = parseAST(currentAST, ExpressParserTokenTypes.INTERFACE_SPECIFICATION);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_86);
		}
		returnAST = interface_specification_AST;
	}

	public final void schema_decl() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_decl_AST = null;
		String id = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_schema);
			id = schema_id();
			astFactory.addASTChild(currentAST, returnAST);
			newSchemaScope(id);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case STRING: {
					schema_version_id();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.SEMI);
			schema_body();
			astFactory.addASTChild(currentAST, returnAST);
			match(ExpressParserTokenTypes.LITERAL_end_schema);
			match(ExpressParserTokenTypes.SEMI);
			schema_decl_AST = (AST) currentAST.root;
			upScope();
			schema_decl_AST = makeAST(ExpressParserTokenTypes.SCHEMA_DECL, schema_decl_AST);
			currentAST.root = schema_decl_AST;
			currentAST.child = getChild(schema_decl_AST);
			currentAST.advanceChildToEnd();
			schema_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_96);
		}
		returnAST = schema_decl_AST;
	}

	public final void schema_version_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_version_id_AST = null;

		try {
			AST tmp365_AST = null;
			tmp365_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp365_AST);
			match(ExpressParserTokenTypes.STRING);
			schema_version_id_AST = parseAST(currentAST, ExpressParserTokenTypes.SCHEMA_VERSION_ID);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = schema_version_id_AST;
	}

	public final void use_clause() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST use_clause_AST = null;
		Token id = null;
		AST id_AST = null;

		ExternalId ei = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_use))) && (isFirst)) {
				AST tmp366_AST = null;
				tmp366_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp366_AST);
				match(ExpressParserTokenTypes.LITERAL_use);
				AST tmp367_AST = null;
				tmp367_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp367_AST);
				match(ExpressParserTokenTypes.LITERAL_from);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LPAREN: {
						AST tmp368_AST = null;
						tmp368_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp368_AST);
						match(ExpressParserTokenTypes.LPAREN);
						ei = named_type_or_rename();
						astFactory.addASTChild(currentAST, returnAST);
						ei.setSchema(id.getText());
						addExternal(ei);
						{
							_loop35815: do {
								if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
									AST tmp369_AST = null;
									tmp369_AST = astFactory.create(LT(1));
									astFactory.addASTChild(currentAST, tmp369_AST);
									match(ExpressParserTokenTypes.COMMA);
									ei = named_type_or_rename();
									astFactory.addASTChild(currentAST, returnAST);
									ei.setSchema(id.getText());
									addExternal(ei);
								} else {
									break _loop35815;
								}

							} while (true);
						}
						AST tmp370_AST = null;
						tmp370_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp370_AST);
						match(ExpressParserTokenTypes.RPAREN);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				AST tmp371_AST = null;
				tmp371_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp371_AST);
				match(ExpressParserTokenTypes.SEMI);
				if (ei == null)
					addAllUseExternals(id.getText());
				use_clause_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_use))) {
				match(ExpressParserTokenTypes.LITERAL_use);
				match(ExpressParserTokenTypes.LITERAL_from);
				schema_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LPAREN: {
						match(ExpressParserTokenTypes.LPAREN);
						named_type_or_rename();
						astFactory.addASTChild(currentAST, returnAST);
						{
							_loop35818: do {
								if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
									match(ExpressParserTokenTypes.COMMA);
									named_type_or_rename();
									astFactory.addASTChild(currentAST, returnAST);
								} else {
									break _loop35818;
								}

							} while (true);
						}
						match(ExpressParserTokenTypes.RPAREN);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(ExpressParserTokenTypes.SEMI);
				use_clause_AST = parseAST(currentAST, ExpressParserTokenTypes.USE_CLAUSE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_86);
		}
		returnAST = use_clause_AST;
	}

	public final ExternalId named_type_or_rename() throws RecognitionException, TokenStreamException {
		ExternalId ei;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST named_type_or_rename_AST = null;
		Token id = null;
		AST id_AST = null;

		String s = null;
		ei = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				ei = new ExternalId(id.getText());
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_as: {
						AST tmp378_AST = null;
						tmp378_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp378_AST);
						match(ExpressParserTokenTypes.LITERAL_as);
						s = rename_id();
						astFactory.addASTChild(currentAST, returnAST);
						ei.setRename(s);
						break;
					}
					case COMMA:
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				named_type_or_rename_AST = (AST) currentAST.root;
			} else if ((_tokenSet_97.member(LA(1)))) {
				named_types();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_as: {
						match(ExpressParserTokenTypes.LITERAL_as);
						{
							if ((LA1Equals(ExpressParserTokenTypes.ENTITY_IDENT) || LA1Equals(ExpressParserTokenTypes.IDENT))) {
								entity_id();
								astFactory.addASTChild(currentAST, returnAST);
							} else if ((LA1Equals(ExpressParserTokenTypes.TYPE_IDENT) || LA1Equals(ExpressParserTokenTypes.IDENT))) {
								type_id();
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								throw new NoViableAltException(LT(1), getFilename());
							}

						}
						break;
					}
					case COMMA:
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				named_type_or_rename_AST = parseAST(currentAST, ExpressParserTokenTypes.NAMED_TYPE_OR_RENAME);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_1);
		}
		returnAST = named_type_or_rename_AST;
		return ei;
	}

	public final String type_id() throws RecognitionException, TokenStreamException {
		String s;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;
		s = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				addId(id.getText(), ExpressParserTokenTypes.TYPE_IDENT);
				s = id.getText();
				type_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.TYPE_IDENT))) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.TYPE_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				type_id_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_ID);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_98);
		}
		returnAST = type_id_AST;
		return s;
	}

	public final void term() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST term_AST = null;

		try {
			factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35874: do {
					if ((_tokenSet_99.member(LA(1)))) {
						multiplication_like_op();
						astFactory.addASTChild(currentAST, returnAST);
						factor();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35874;
					}

				} while (true);
			}
			term_AST = parseAST(currentAST, ExpressParserTokenTypes.TERM);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_100);
		}
		returnAST = term_AST;
	}

	public final void unary_op() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unary_op_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case PLUS: {
				AST tmp380_AST = null;
				tmp380_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp380_AST);
				match(ExpressParserTokenTypes.PLUS);
				unary_op_AST = parseAST(currentAST, ExpressParserTokenTypes.UNARY_OP);
				break;
			}
			case MINUS: {
				AST tmp381_AST = null;
				tmp381_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp381_AST);
				match(ExpressParserTokenTypes.MINUS);
				unary_op_AST = parseAST(currentAST, ExpressParserTokenTypes.UNARY_OP);
				break;
			}
			case LITERAL_not: {
				AST tmp382_AST = null;
				tmp382_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp382_AST);
				match(ExpressParserTokenTypes.LITERAL_not);
				unary_op_AST = parseAST(currentAST, ExpressParserTokenTypes.UNARY_OP);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_101);
		}
		returnAST = unary_op_AST;
	}

	public final void string_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST string_type_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_string);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN: {
					width_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case RPAREN:
				case SEMI:
				case COLEQ: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			string_type_AST = parseAST(currentAST, ExpressParserTokenTypes.STRING_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_7);
		}
		returnAST = string_type_AST;
	}

	public final void skip_stmt() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST skip_stmt_AST = null;

		try {
			match(ExpressParserTokenTypes.LITERAL_skip);
			match(ExpressParserTokenTypes.SEMI);
			skip_stmt_AST = parseAST(currentAST, ExpressParserTokenTypes.SKIP_STMT);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_16);
		}
		returnAST = skip_stmt_AST;
	}

	public final void supertype_factor() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_factor_AST = null;

		try {
			supertype_term();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35862: do {
					if ((LA1Equals(ExpressParserTokenTypes.LITERAL_and))) {
						match(ExpressParserTokenTypes.LITERAL_and);
						supertype_term();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35862;
					}

				} while (true);
			}
			supertype_factor_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_FACTOR);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_102);
		}
		returnAST = supertype_factor_AST;
	}

	public final void supertype_term() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_term_AST = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case ENTITY_IDENT:
			case ENTITY_ATTR_IDENT:
			case ENTITY_VAR_IDENT:
			case ENTITY_PARAM_IDENT: {
				entity_ref();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_term_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_TERM);
				break;
			}
			case LITERAL_oneof: {
				one_of();
				astFactory.addASTChild(currentAST, returnAST);
				supertype_term_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_TERM);
				break;
			}
			case LPAREN: {
				match(ExpressParserTokenTypes.LPAREN);
				supertype_expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(ExpressParserTokenTypes.RPAREN);
				supertype_term_AST = parseAST(currentAST, ExpressParserTokenTypes.SUPERTYPE_TERM);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					AST tmp389_AST = null;
					tmp389_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp389_AST);
					match(ExpressParserTokenTypes.IDENT);
					supertype_term_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_80);
		}
		returnAST = supertype_term_AST;
	}

	public final void syntax() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST syntax_AST = null;
		if (isFirst) {
			rootScope = new Scope(null);
			lastCreatedScope = rootScope;
			currentScope = rootScope;
			schemas = new Hashtable<String, Scope>();
		}

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LCURLY: {
					language_version_id();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_schema: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			schema_decl();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35870: do {
					if ((LA1Equals(ExpressParserTokenTypes.LITERAL_schema))) {
						schema_decl();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35870;
					}

				} while (true);
			}
			syntax_AST = parseAST(currentAST, ExpressParserTokenTypes.SYNTAX);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_103);
		}
		returnAST = syntax_AST;
	}

	public final void language_version_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST language_version_id_AST = null;

		try {
			match(ExpressParserTokenTypes.LCURLY);
			match(ExpressParserTokenTypes.LANG_VERSION);
			match(ExpressParserTokenTypes.RCURLY);
			language_version_id_AST = parseAST(currentAST, ExpressParserTokenTypes.LANGUAGE_VERSION_ID);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_104);
		}
		returnAST = language_version_id_AST;
	}

	public final EnumerationType underlying_type() throws RecognitionException, TokenStreamException {
		EnumerationType eids;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST underlying_type_AST = null;
		eids = null;

		try {
			switch (ExpressParserTokenTypes.getToken(LA(1))) {
			case LITERAL_generic_entity:
			case LITERAL_extensible:
			case LITERAL_enumeration:
			case LITERAL_select: {
				eids = constructed_types();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = parseAST(currentAST, ExpressParserTokenTypes.UNDERLYING_TYPE);
				break;
			}
			case LITERAL_array:
			case LITERAL_bag:
			case LITERAL_set:
			case LITERAL_list: {
				aggregation_types();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = parseAST(currentAST, ExpressParserTokenTypes.UNDERLYING_TYPE);
				break;
			}
			case LITERAL_binary:
			case LITERAL_boolean:
			case LITERAL_integer:
			case LITERAL_logical:
			case LITERAL_number:
			case LITERAL_real:
			case LITERAL_string: {
				simple_types();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = parseAST(currentAST, ExpressParserTokenTypes.UNDERLYING_TYPE);
				break;
			}
			case TYPE_IDENT:
			case TYPE_ATTR_IDENT:
			case TYPE_VAR_IDENT:
			case TYPE_PARAM_IDENT: {
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				underlying_type_AST = parseAST(currentAST, ExpressParserTokenTypes.UNDERLYING_TYPE);
				break;
			}
			default:
				if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
					AST tmp393_AST = null;
					tmp393_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp393_AST);
					match(ExpressParserTokenTypes.IDENT);
					underlying_type_AST = (AST) currentAST.root;
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = underlying_type_AST;
		return eids;
	}

	public final EnumerationType constructed_types() throws RecognitionException, TokenStreamException {
		EnumerationType eids;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constructed_types_AST = null;
		eids = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_extensible) || LA1Equals(ExpressParserTokenTypes.LITERAL_enumeration)))
					&& (LA1Equals(ExpressParserTokenTypes.LITERAL_enumeration) || LA(2) == ExpressParserTokenTypes.LITERAL_enumeration.getIndex())) {
				eids = enumeration_type();
				astFactory.addASTChild(currentAST, returnAST);
				constructed_types_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTRUCTED_TYPES);
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_generic_entity) || LA1Equals(ExpressParserTokenTypes.LITERAL_extensible) || LA1Equals(ExpressParserTokenTypes.LITERAL_select))) {
				select_type();
				astFactory.addASTChild(currentAST, returnAST);
				constructed_types_AST = parseAST(currentAST, ExpressParserTokenTypes.CONSTRUCTED_TYPES);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = constructed_types_AST;
		return eids;
	}

	public final EnumerationType enumeration_type() throws RecognitionException, TokenStreamException {
		EnumerationType eids;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_type_AST = null;

		boolean ext = false;
		eids = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_extensible: {
					AST tmp394_AST = null;
					tmp394_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp394_AST);
					match(ExpressParserTokenTypes.LITERAL_extensible);
					ext = true;
					break;
				}
				case LITERAL_enumeration: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_enumeration);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_of:
				case LITERAL_based_on: {
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LITERAL_of: {
							{
								match(ExpressParserTokenTypes.LITERAL_of);
								eids = enumeration_items();
								astFactory.addASTChild(currentAST, returnAST);
							}
							break;
						}
						case LITERAL_based_on: {
							eids = enumeration_extension();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			enumeration_type_AST = (AST) currentAST.root;
			enumeration_type_AST = makeAST(ExpressParserTokenTypes.ENUMERATION_TYPE, enumeration_type_AST);
			if (eids == null)
				eids = new EnumerationType();
			eids.setExtensible(ext);

			currentAST.root = enumeration_type_AST;
			currentAST.child = getChild(enumeration_type_AST);
			currentAST.advanceChildToEnd();
			enumeration_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = enumeration_type_AST;
		return eids;
	}

	public final void select_type() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_type_AST = null;

		try {
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_extensible: {
					AST tmp397_AST = null;
					tmp397_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp397_AST);
					match(ExpressParserTokenTypes.LITERAL_extensible);
					break;
				}
				case LITERAL_generic_entity:
				case LITERAL_select: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LITERAL_generic_entity: {
					AST tmp398_AST = null;
					tmp398_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp398_AST);
					match(ExpressParserTokenTypes.LITERAL_generic_entity);
					break;
				}
				case LITERAL_select: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(ExpressParserTokenTypes.LITERAL_select);
			{
				switch (ExpressParserTokenTypes.getToken(LA(1))) {
				case LPAREN:
				case LITERAL_based_on: {
					{
						switch (ExpressParserTokenTypes.getToken(LA(1))) {
						case LPAREN: {
							select_list();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case LITERAL_based_on: {
							select_extension();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case SEMI: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			select_type_AST = parseAST(currentAST, ExpressParserTokenTypes.SELECT_TYPE);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = select_type_AST;
	}

	public final EnumerationType enumeration_items() throws RecognitionException, TokenStreamException {
		EnumerationType eids;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_items_AST = null;

		String id = null;
		if (isFirst)
			eids = new EnumerationType();
		else
			eids = null;

		try {
			match(ExpressParserTokenTypes.LPAREN);
			id = enumeration_id();
			astFactory.addASTChild(currentAST, returnAST);
			if (isFirst)
				eids.add(id);
			{
				_loop35886: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						id = enumeration_id();
						astFactory.addASTChild(currentAST, returnAST);
						if (isFirst)
							eids.add(id);
					} else {
						break _loop35886;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.RPAREN);
			enumeration_items_AST = parseAST(currentAST, ExpressParserTokenTypes.ENUMERATION_ITEMS);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = enumeration_items_AST;
		return eids;
	}

	public final EnumerationType enumeration_extension() throws RecognitionException, TokenStreamException {
		EnumerationType eids;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_extension_AST = null;
		Token id = null;
		AST id_AST = null;
		eids = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_based_on))) && (isFirst)) {
				AST tmp403_AST = null;
				tmp403_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp403_AST);
				match(ExpressParserTokenTypes.LITERAL_based_on);
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_with: {
						AST tmp404_AST = null;
						tmp404_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp404_AST);
						match(ExpressParserTokenTypes.LITERAL_with);
						eids = enumeration_items();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				if (eids == null)
					eids = new EnumerationType();
				eids.setBasedOn(id.getText());
				enumeration_extension_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_based_on))) {
				match(ExpressParserTokenTypes.LITERAL_based_on);
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_with: {
						match(ExpressParserTokenTypes.LITERAL_with);
						enumeration_items();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				enumeration_extension_AST = parseAST(currentAST, ExpressParserTokenTypes.ENUMERATION_EXTENSION);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = enumeration_extension_AST;
		return eids;
	}

	public final String enumeration_id() throws RecognitionException, TokenStreamException {
		String eid;

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_id_AST = null;
		Token id = null;
		AST id_AST = null;
		Token nid = null;
		AST nid_AST = null;
		eid = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.IDENT))) && (isFirst)) {
				id = LT(1);
				id_AST = astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ExpressParserTokenTypes.IDENT);
				eid = id.getText();
				enumeration_id_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.ENUMERATION_IDENT))) {
				nid = LT(1);
				nid_AST = astFactory.create(nid);
				astFactory.addASTChild(currentAST, nid_AST);
				match(ExpressParserTokenTypes.ENUMERATION_IDENT);
				nid_AST.setType(ExpressParserTokenTypes.IDENT.getIndex());
				enumeration_id_AST = parseAST(currentAST, ExpressParserTokenTypes.ENUMERATION_ID);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_1);
		}
		returnAST = enumeration_id_AST;
		return eid;
	}

	public final void select_list() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;

		try {
			match(ExpressParserTokenTypes.LPAREN);
			named_types();
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop35898: do {
					if ((LA1Equals(ExpressParserTokenTypes.COMMA))) {
						match(ExpressParserTokenTypes.COMMA);
						named_types();
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop35898;
					}

				} while (true);
			}
			match(ExpressParserTokenTypes.RPAREN);
			select_list_AST = parseAST(currentAST, ExpressParserTokenTypes.SELECT_LIST);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = select_list_AST;
	}

	public final void select_extension() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_extension_AST = null;

		try {
			if (((LA1Equals(ExpressParserTokenTypes.LITERAL_based_on))) && (isFirst)) {
				AST tmp410_AST = null;
				tmp410_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp410_AST);
				match(ExpressParserTokenTypes.LITERAL_based_on);
				AST tmp411_AST = null;
				tmp411_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp411_AST);
				match(ExpressParserTokenTypes.IDENT);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_with: {
						AST tmp412_AST = null;
						tmp412_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp412_AST);
						match(ExpressParserTokenTypes.LITERAL_with);
						select_list();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				select_extension_AST = (AST) currentAST.root;
			} else if ((LA1Equals(ExpressParserTokenTypes.LITERAL_based_on))) {
				match(ExpressParserTokenTypes.LITERAL_based_on);
				type_ref();
				astFactory.addASTChild(currentAST, returnAST);
				{
					switch (ExpressParserTokenTypes.getToken(LA(1))) {
					case LITERAL_with: {
						match(ExpressParserTokenTypes.LITERAL_with);
						select_list();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case SEMI: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				select_extension_AST = parseAST(currentAST, ExpressParserTokenTypes.SELECT_EXTENSION);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_37);
		}
		returnAST = select_extension_AST;
	}

	public final void type_label_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_id_AST = null;

		try {
			AST tmp415_AST = null;
			tmp415_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp415_AST);
			match(ExpressParserTokenTypes.IDENT);
			type_label_id_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_LABEL_ID);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_103);
		}
		returnAST = type_label_id_AST;
	}

	public final void width() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST width_AST = null;

		try {
			numeric_expression();
			astFactory.addASTChild(currentAST, returnAST);
			width_AST = parseAST(currentAST, ExpressParserTokenTypes.WIDTH);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_81);
		}
		returnAST = width_AST;
	}

	public final void simple_id() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_id_AST = null;

		try {
			AST tmp416_AST = null;
			tmp416_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp416_AST);
			match(ExpressParserTokenTypes.IDENT);
			simple_id_AST = parseAST(currentAST, ExpressParserTokenTypes.SIMPLE_ID);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_103);
		}
		returnAST = simple_id_AST;
	}

	public final void type_label_ref() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_ref_AST = null;

		try {
			AST tmp417_AST = null;
			tmp417_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp417_AST);
			match(ExpressParserTokenTypes.IDENT);
			type_label_ref_AST = parseAST(currentAST, ExpressParserTokenTypes.TYPE_LABEL_REF);
		} catch (RecognitionException ex) {
			reportError(ex);
			recover(ex, _tokenSet_103);
		}
		returnAST = type_label_ref_AST;
	}

	public static final String[] _tokenNames = { "<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "CONSTANT_IDENT", "ENTITY_IDENT", "FUNCTION_IDENT", "PROCEDURE_IDENT",
			"PARAMETER_IDENT", "SCHEMA_IDENT", "TYPE_IDENT", "VARIABLE_IDENT", "ENUMERATION_IDENT", "ATTRIBUTE_IDENT", "ENTITY_ATTR_IDENT", "TYPE_ATTR_IDENT", "ENTITY_VAR_IDENT",
			"TYPE_VAR_IDENT", "ENTITY_PARAM_IDENT", "TYPE_PARAM_IDENT", "SUBTYPE_CONSTRAINT_ID", "ACTUAL_PARAMETER_LIST", "ADD_LIKE_OP", "AGGREGATE_INITIALIZER",
			"AGGREGATE_SOURCE", "AGGREGATE_TYPE", "AGGREGATION_TYPES", "ALGORITHM_HEAD", "ALIAS_STMT", "ARRAY_TYPE", "ASSIGNMENT_STMT", "BAG_TYPE", "BASE_TYPE", "BINARY_TYPE",
			"BOOLEAN_TYPE", "BOUND_1", "BOUND_2", "BOUND_SPEC", "BUILT_IN_CONSTANT", "BUILT_IN_FUNCTION", "BUILT_IN_PROCEDURE", "CASE_ACTION", "CASE_LABEL", "CASE_STMT",
			"COMPOUND_STMT", "CONSTANT_BODY", "CONSTANT_DECL", "CONSTANT_FACTOR", "CONSTANT_ID", "DECLARATION", "DOMAIN_RULE", "ELEMENT", "ENTITY_HEAD", "ENTITY_DECL",
			"ENTITY_BODY", "SUBSUPER", "SUPERTYPE_CONSTRAINT", "ABSTRACT_SUPERTYPE_DECLARATION", "SUBTYPE_DECLARATION", "EXPLICIT_ATTR", "ATTRIBUTE_DECL", "ATTRIBUTE_ID",
			"QUALIFIED_ATTRIBUTE", "DERIVE_CLAUSE", "DERIVED_ATTR", "INVERSE_CLAUSE", "INVERSE_ATTR", "UNIQUE_CLAUSE", "UNIQUE_RULE", "REFERENCED_ATTRIBUTE", "ENTITY_CONSTRUCTOR",
			"ENTITY_ID", "ENUMERATION_REFERENCE", "ESCAPE_STMT", "EXPRESSION", "FACTOR", "FORMAL_PARAMETER", "ATTRIBUTE_QUALIFIER", "FUNCTION_CALL", "FUNCTION_DECL",
			"FUNCTION_HEAD", "FUNCTION_ID", "GENERALIZED_TYPES", "GENERAL_AGGREGATION_TYPES", "GENERAL_ARRAY_TYPE", "GENERAL_BAG_TYPE", "GENERAL_LIST_TYPE", "GENERAL_REF",
			"GENERAL_SET_TYPE", "GENERIC_TYPE", "GROUP_QUALIFIER", "IF_STMT", "INCREMENT", "INCREMENT_CONTROL", "INDEX", "INDEX_1", "INDEX_2", "INDEX_QUALIFIER", "INTEGER_TYPE",
			"INTERVAL", "INTERVAL_HIGH", "INTERVAL_ITEM", "INTERVAL_LOW", "INTERVAL_OP", "LABEL", "LIST_TYPE", "LITERAL", "REAL", "INTEGER", "STRING", "LOCAL_DECL",
			"LOCAL_VARIABLE", "LOGICAL_EXPRESSION", "LOGICAL", "LOGICAL_TYPE", "MULTIPLICATION_LIKE_OP", "NAMED_TYPES", "NULL_STMT", "NUMBER_TYPE", "NUMERIC_EXPRESSION", "ONE_OF",
			"PARAMETER", "PARAMETER_ID", "PARAMETER_TYPE", "POPULATION", "PRECISION_SPEC", "PRIMARY", "PROCEDURE_CALL_STMT", "PROCEDURE_DECL", "PROCEDURE_HEAD", "PROCEDURE_ID",
			"QUALIFIABLE_FACTOR", "QUALIFIER", "QUERY_EXPRESSION", "REAL_TYPE", "REFERENCE_CLAUSE", "REL_OP", "REL_OP_EXTENDED", "REPEAT_CONTROL", "REPEAT_STMT", "REPETITION",
			"RESOURCE_OR_RENAME", "RESOURCE_REF", "RETURN_STMT", "RULE_DECL", "RULE_HEAD", "RULE_ID", "SCHEMA_ID", "SCHEMA_BODY", "SCHEMA_DECL", "INTERFACE_SPECIFICATION",
			"USE_CLAUSE", "NAMED_TYPE_OR_RENAME", "SELECTOR", "SET_TYPE", "SIMPLE_EXPRESSION", "SIMPLE_FACTOR", "SIMPLE_TYPES", "SKIP_STMT", "STMT", "STRING_TYPE",
			"SUBTYPE_CONSTRAINT", "SUPERTYPE_EXPRESSION", "SUPERTYPE_FACTOR", "SUPERTYPE_RULE", "SUPERTYPE_TERM", "SYNTAX", "TERM", "TYPE_DECL", "UNDERLYING_TYPE",
			"CONSTRUCTED_TYPES", "ENUMERATION_TYPE", "ENUMERATION_ID", "SELECT_TYPE", "TYPE_ID", "TYPE_LABEL", "TYPE_LABEL_ID", "UNARY_OP", "UNTIL_CONTROL", "VARIABLE_ID",
			"WHERE_CLAUSE", "WHILE_CONTROL", "WIDTH", "WIDTH_SPEC", "ENTITY_REF", "TYPE_REF", "ENUMERATION_REF", "ATTRIBUTE_REF", "CONSTANT_REF", "FUNCTION_REF", "PARAMETER_REF",
			"VARIABLE_REF", "SCHEMA_REF", "TYPE_LABEL_REF", "PROCEDURE_REF", "SIMPLE_ID", "ELSE_CLAUSE", "RENAME_ID", "ENUMERATION_ITEMS", "ENUMERATION_EXTENSION", "SELECT_LIST",
			"SELECT_EXTENSION", "REDECLARED_ATTRIBUTE", "SUBTYPE_CONSTRAINT_DECL", "SUBTYPE_CONSTRAINT_HEAD", "SUBTYPE_CONSTRAINT_BODY", "ABSTRACT_SUPERTYPE", "TOTAL_OVER",
			"CONCRETE_TYPES", "GENERIC_ENTITY_TYPE", "SCHEMA_VERSION_ID", "LANGUAGE_VERSION_ID", "(", ",", ")", "+", "-", "\"or\"", "\"xor\"", "[", "]", "\"aggregate\"", ":",
			"\"of\"", "\"alias\"", "\"for\"", "an identifer", ";", "\"end_alias\"", "\"array\"", "\"optional\"", "\"unique\"", ":=", "\"bag\"", "\"binary\"", "\"boolean\"",
			"\"const_e\"", "\"pi\"", "\"self\"", "?", "*", "\"abs\"", "\"acos\"", "\"asin\"", "\"atan\"", "\"blength\"", "\"cos\"", "\"exists\"", "\"exp\"", "\"format\"",
			"\"hibound\"", "\"hiindex\"", "\"length\"", "\"lobound\"", "\"loindex\"", "\"log\"", "\"log2\"", "\"log10\"", "\"nvl\"", "\"odd\"", "\"rolesof\"", "\"sin\"",
			"\"sizeof\"", "\"sqrt\"", "\"tan\"", "\"typeof\"", "\"usedin\"", "\"value\"", "\"value_in\"", "\"value_unique\"", "\"insert\"", "\"remove\"", "\"case\"",
			"\"otherwise\"", "\"end_case\"", "\"begin\"", "\"end\"", "\"constant\"", "\"end_constant\"", "\"entity\"", "\"abstract\"", "\"end_entity\"", "\"supertype\"",
			"\"subtype\"", "\"end_subtype_constraint\"", "\"subtype_constraint\"", "\"total_over\"", "\"renamed\"", "\"derive\"", "\"inverse\"", "\"set\"", ".", "\"escape\"",
			"double star", "\"end_function\"", "\"function\"", "\"list\"", "\"generic\"", "\"generic_entity\"", "backslash", "\"if\"", "\"then\"", "\"end_if\"", "\"else\"",
			"\"to\"", "\"by\"", "\"integer\"", "{", "}", "<", "<=", "an integer value", "an floating point value", "a string literal", "\"local\"", "\"end_local\"", "\"false\"",
			"\"true\"", "\"unknown\"", "\"logical\"", "/", "\"div\"", "\"mod\"", "\"and\"", "double bar", "\"number\"", "\"oneof\"", "\"end_procedure\"", "\"procedure\"",
			"\"var\"", "\"query\"", "less than star", "|", "\"real\"", "\"reference\"", "\"from\"", ">", ">=", "less-than/greater-than thing", "=", ":<>:", ":=:", "\"in\"",
			"\"like\"", "\"repeat\"", "\"end_repeat\"", "\"as\"", "\"return\"", "\"end_rule\"", "\"rule\"", "\"schema\"", "\"end_schema\"", "\"use\"", "\"skip\"", "\"string\"",
			"\"andor\"", "language version id", "\"type\"", "\"end_type\"", "\"extensible\"", "\"enumeration\"", "\"based_on\"", "\"with\"", "\"select\"", "\"not\"", "\"until\"",
			"\"where\"", "\"while\"", "\"fixed\"", "a comment", "a EXPRESS one line comment", "&", "@", "white space", "a digit" };

	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap = null;
	};

	private static final long[] mk_tokenSet_0() {
		long[] data = new long[12];
		data[3] = 281513092448256L;
		data[4] = 32413774585528320L;
		data[5] = 175921877159967L;
		return data;
	}

	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[3] = 6291456L;
		return data;
	}

	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());

	private static final long[] mk_tokenSet_2() {
		long[] data = new long[12];
		data[0] = 1047920L;
		data[3] = -17574845743104L;
		data[4] = 8252846317156450303L;
		data[5] = 17592186045440L;
		return data;
	}

	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());

	private static final long[] mk_tokenSet_3() {
		long[] data = new long[12];
		data[3] = 281512958230528L;
		data[4] = 32404944132767744L;
		data[5] = 175921877159967L;
		return data;
	}

	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[3] = 270532608L;
		return data;
	}

	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());

	private static final long[] mk_tokenSet_5() {
		long[] data = new long[12];
		data[5] = 4096L;
		return data;
	}

	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());

	private static final long[] mk_tokenSet_6() {
		long[] data = new long[12];
		data[3] = 37855690752L;
		data[4] = 32404806693814272L;
		data[5] = 175921877159936L;
		return data;
	}

	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

	private static final long[] mk_tokenSet_7() {
		long[] data = new long[8];
		data[3] = 1133875560448L;
		return data;
	}

	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());

	private static final long[] mk_tokenSet_8() {
		long[] data = new long[8];
		data[3] = 1136023044096L;
		return data;
	}

	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());

	private static final long[] mk_tokenSet_9() {
		long[] data = new long[8];
		data[3] = 1133871366144L;
		return data;
	}

	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());

	private static final long[] mk_tokenSet_10() {
		long[] data = new long[12];
		data[4] = 550301073408L;
		data[5] = 137438953728L;
		return data;
	}

	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());

	private static final long[] mk_tokenSet_11() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 17660906160128L;
		data[5] = 70377485107328L;
		return data;
	}

	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());

	private static final long[] mk_tokenSet_12() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 288248587361042432L;
		data[5] = 70517608415616L;
		return data;
	}

	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());

	private static final long[] mk_tokenSet_13() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 288248587358945280L;
		data[5] = 70517608415616L;
		return data;
	}

	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());

	private static final long[] mk_tokenSet_14() {
		long[] data = new long[8];
		data[0] = 198656L;
		data[3] = 17179869184L;
		return data;
	}

	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());

	private static final long[] mk_tokenSet_15() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 17660906160128L;
		data[5] = 8740929536L;
		return data;
	}

	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());

	private static final long[] mk_tokenSet_16() {
		long[] data = new long[12];
		data[0] = 1048048L;
		data[3] = -17467471560704L;
		data[4] = 8253075359174492159L;
		data[5] = 87969704707200L;
		return data;
	}

	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());

	private static final long[] mk_tokenSet_17() {
		long[] data = new long[12];
		data[3] = 1109177401344L;
		data[5] = 2048L;
		return data;
	}

	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());

	private static final long[] mk_tokenSet_18() {
		long[] data = new long[12];
		data[3] = 282612604076032L;
		data[4] = 32413774585528320L;
		data[5] = 175921877159967L;
		return data;
	}

	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());

	private static final long[] mk_tokenSet_19() {
		long[] data = new long[8];
		data[3] = 2147483648L;
		return data;
	}

	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());

	private static final long[] mk_tokenSet_20() {
		long[] data = new long[12];
		data[0] = 1033248L;
		data[3] = 15547781611520L;
		data[4] = -9222245020256436224L;
		data[5] = 17179877408L;
		return data;
	}

	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());

	private static final long[] mk_tokenSet_21() {
		long[] data = new long[10];
		data[3] = 2336999079936L;
		data[4] = 7713761263616L;
		return data;
	}

	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());

	private static final long[] mk_tokenSet_22() {
		long[] data = new long[12];
		data[3] = 37855690752L;
		for (int i = 4; i <= 5; i++) {
			data[i] = 35184372088832L;
		}
		return data;
	}

	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());

	private static final long[] mk_tokenSet_23() {
		long[] data = new long[12];
		data[3] = 1133877657600L;
		data[5] = 67108864L;
		return data;
	}

	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());

	private static final long[] mk_tokenSet_24() {
		long[] data = new long[10];
		data[3] = 1073741824L;
		data[4] = 281474976710656L;
		return data;
	}

	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());

	private static final long[] mk_tokenSet_25() {
		long[] data = new long[12];
		data[3] = 35708207104L;
		data[4] = 844424930131968L;
		data[5] = 175921860444160L;
		return data;
	}

	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());

	private static final long[] mk_tokenSet_26() {
		long[] data = new long[12];
		data[3] = 34628173824L;
		data[4] = 562949953421312L;
		data[5] = 175921860444160L;
		return data;
	}

	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());

	private static final long[] mk_tokenSet_27() {
		long[] data = new long[12];
		data[3] = 281513093496832L;
		data[4] = 32413774585528320L;
		data[5] = 175921877159967L;
		return data;
	}

	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());

	private static final long[] mk_tokenSet_28() {
		long[] data = new long[8];
		data[3] = 34360786944L;
		return data;
	}

	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());

	private static final long[] mk_tokenSet_29() {
		long[] data = new long[12];
		data[0] = 1047920L;
		data[3] = -17574845743104L;
		data[4] = 8252846317156843519L;
		data[5] = 17592186045440L;
		return data;
	}

	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());

	private static final long[] mk_tokenSet_30() {
		long[] data = new long[8];
		data[3] = 1075838976L;
		return data;
	}

	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());

	private static final long[] mk_tokenSet_31() {
		long[] data = new long[10];
		data[0] = 16L;
		data[3] = 17179869184L;
		data[4] = 4194304L;
		return data;
	}

	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());

	private static final long[] mk_tokenSet_32() {
		long[] data = new long[8];
		data[3] = 1073741824L;
		return data;
	}

	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());

	private static final long[] mk_tokenSet_33() {
		long[] data = new long[12];
		data[3] = 281513092448256L;
		data[4] = 32413774585528320L;
		data[5] = 175921944268831L;
		return data;
	}

	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());

	private static final long[] mk_tokenSet_34() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 288248587361042432L;
		data[5] = 146179883264L;
		return data;
	}

	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());

	private static final long[] mk_tokenSet_35() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 288248587361042432L;
		data[5] = 146179883392L;
		return data;
	}

	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());

	private static final long[] mk_tokenSet_36() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 17660906160128L;
		data[5] = 8740929664L;
		return data;
	}

	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());

	private static final long[] mk_tokenSet_37() {
		long[] data = new long[8];
		data[3] = 34359738368L;
		return data;
	}

	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());

	private static final long[] mk_tokenSet_38() {
		long[] data = new long[12];
		data[3] = 34363932672L;
		for (int i = 4; i <= 5; i++) {
			data[i] = 35184372088832L;
		}
		return data;
	}

	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());

	private static final long[] mk_tokenSet_39() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70970039599104L;
		data[4] = 13136560128L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());

	private static final long[] mk_tokenSet_40() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70970039599104L;
		data[4] = 12918456320L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());

	private static final long[] mk_tokenSet_41() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70935679860736L;
		data[4] = 12918456320L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());

	private static final long[] mk_tokenSet_42() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70970045890560L;
		data[4] = 13136560128L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());

	private static final long[] mk_tokenSet_43() {
		long[] data = new long[8];
		data[0] = 57344L;
		data[3] = 70385924046848L;
		return data;
	}

	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());

	private static final long[] mk_tokenSet_44() {
		long[] data = new long[10];
		data[4] = 33554432L;
		return data;
	}

	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());

	private static final long[] mk_tokenSet_45() {
		long[] data = new long[12];
		data[3] = 549755813888L;
		data[4] = 8623489024L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());

	private static final long[] mk_tokenSet_46() {
		long[] data = new long[12];
		data[3] = 549755813888L;
		data[4] = 33554432L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());

	private static final long[] mk_tokenSet_47() {
		long[] data = new long[12];
		data[4] = 33554432L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());

	private static final long[] mk_tokenSet_48() {
		long[] data = new long[12];
		data[4] = 33554432L;
		data[5] = 275146342400L;
		return data;
	}

	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());

	private static final long[] mk_tokenSet_49() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70970039599104L;
		data[4] = 13052674048L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());

	private static final long[] mk_tokenSet_50() {
		long[] data = new long[12];
		data[3] = 282621195059200L;
		data[4] = 32413774585528320L;
		data[5] = 175956304007199L;
		return data;
	}

	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());

	private static final long[] mk_tokenSet_51() {
		long[] data = new long[12];
		data[0] = 344096L;
		data[3] = 17180917760L;
		data[4] = 1358954496L;
		data[5] = 64L;
		return data;
	}

	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());

	private static final long[] mk_tokenSet_52() {
		long[] data = new long[10];
		data[4] = 268435456L;
		return data;
	}

	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());

	private static final long[] mk_tokenSet_53() {
		long[] data = new long[8];
		data[3] = 8589934592L;
		return data;
	}

	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());

	private static final long[] mk_tokenSet_54() {
		long[] data = new long[12];
		data[0] = 344096L;
		data[3] = 17180917760L;
		data[4] = 1342177280L;
		data[5] = 64L;
		return data;
	}

	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());

	private static final long[] mk_tokenSet_55() {
		long[] data = new long[12];
		data[0] = 344096L;
		data[3] = 17180917760L;
		data[4] = 268435456L;
		data[5] = 64L;
		return data;
	}

	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());

	private static final long[] mk_tokenSet_56() {
		long[] data = new long[8];
		data[3] = 34366029824L;
		return data;
	}

	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());

	private static final long[] mk_tokenSet_57() {
		long[] data = new long[10];
		data[3] = 35435577344L;
		data[4] = 2147483648L;
		return data;
	}

	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());

	private static final long[] mk_tokenSet_58() {
		long[] data = new long[12];
		data[3] = 282612604076032L;
		data[4] = 32413776733011968L;
		data[5] = 175921877159967L;
		return data;
	}

	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());

	private static final long[] mk_tokenSet_59() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70935679860736L;
		data[4] = 8623489024L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());

	private static final long[] mk_tokenSet_60() {
		long[] data = new long[12];
		data[0] = 57344L;
		data[3] = 70935679860736L;
		data[4] = 33554432L;
		data[5] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());

	private static final long[] mk_tokenSet_61() {
		long[] data = new long[12];
		data[3] = 282612604076032L;
		data[4] = 32413776733011968L;
		data[5] = 175921944268831L;
		return data;
	}

	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());

	private static final long[] mk_tokenSet_62() {
		long[] data = new long[8];
		data[3] = 34361835520L;
		return data;
	}

	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());

	private static final long[] mk_tokenSet_63() {
		long[] data = { 693248L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());

	private static final long[] mk_tokenSet_64() {
		long[] data = new long[12];
		data[3] = 1133877657600L;
		data[4] = 34359738368L;
		data[5] = 4398113619968L;
		return data;
	}

	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());

	private static final long[] mk_tokenSet_65() {
		long[] data = new long[12];
		data[3] = 281512958230528L;
		data[4] = 32404806693814272L;
		data[5] = 175921877159967L;
		return data;
	}

	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());

	private static final long[] mk_tokenSet_66() {
		long[] data = new long[10];
		data[4] = 8250594517342748672L;
		return data;
	}

	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());

	private static final long[] mk_tokenSet_67() {
		long[] data = { 344096L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());

	private static final long[] mk_tokenSet_68() {
		long[] data = new long[8];
		data[0] = 693248L;
		data[3] = 17179869184L;
		return data;
	}

	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());

	private static final long[] mk_tokenSet_69() {
		long[] data = new long[12];
		data[0] = 1042800L;
		data[3] = -17574979960832L;
		data[4] = 8250594517342765055L;
		data[5] = 17592186044416L;
		return data;
	}

	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());

	private static final long[] mk_tokenSet_70() {
		long[] data = new long[8];
		data[3] = 34363932672L;
		return data;
	}

	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());

	private static final long[] mk_tokenSet_71() {
		long[] data = new long[12];
		data[3] = 281513093496832L;
		data[4] = 32413774585528320L;
		data[5] = 175921944268831L;
		return data;
	}

	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());

	private static final long[] mk_tokenSet_72() {
		long[] data = new long[8];
		data[3] = 1074790400L;
		return data;
	}

	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());

	private static final long[] mk_tokenSet_73() {
		long[] data = new long[10];
		data[4] = 70368744177664L;
		return data;
	}

	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());

	private static final long[] mk_tokenSet_74() {
		long[] data = new long[12];
		data[3] = 34359738368L;
		data[5] = 175921860444160L;
		return data;
	}

	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());

	private static final long[] mk_tokenSet_75() {
		long[] data = new long[8];
		data[3] = 1342177280L;
		return data;
	}

	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());

	private static final long[] mk_tokenSet_76() {
		long[] data = new long[8];
		data[3] = 268435456L;
		return data;
	}

	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());

	private static final long[] mk_tokenSet_77() {
		long[] data = new long[10];
		data[4] = 27021597764222976L;
		return data;
	}

	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());

	private static final long[] mk_tokenSet_78() {
		long[] data = new long[10];
		data[4] = 4503599627370496L;
		return data;
	}

	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());

	private static final long[] mk_tokenSet_79() {
		long[] data = new long[10];
		data[0] = 198656L;
		data[3] = 17179869184L;
		data[4] = 576460752303423488L;
		return data;
	}

	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());

	private static final long[] mk_tokenSet_80() {
		long[] data = new long[12];
		data[3] = 34366029824L;
		data[5] = 34359738376L;
		return data;
	}

	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());

	private static final long[] mk_tokenSet_81() {
		long[] data = new long[8];
		data[3] = 4194304L;
		return data;
	}

	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());

	private static final long[] mk_tokenSet_82() {
		long[] data = new long[8];
		data[0] = 16L;
		data[3] = 545357767376896L;
		return data;
	}

	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());

	private static final long[] mk_tokenSet_83() {
		long[] data = new long[10];
		data[0] = 64L;
		data[3] = -562949953421312L;
		data[4] = 16383L;
		return data;
	}

	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());

	private static final long[] mk_tokenSet_84() {
		long[] data = { 985344L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());

	private static final long[] mk_tokenSet_85() {
		long[] data = new long[12];
		data[3] = 34367078400L;
		data[5] = 67108864L;
		return data;
	}

	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());

	private static final long[] mk_tokenSet_86() {
		long[] data = new long[12];
		data[4] = 550303170560L;
		data[5] = 144418291968L;
		return data;
	}

	public static final BitSet _tokenSet_86 = new BitSet(mk_tokenSet_86());

	private static final long[] mk_tokenSet_87() {
		long[] data = { 1033456L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_87 = new BitSet(mk_tokenSet_87());

	private static final long[] mk_tokenSet_88() {
		long[] data = new long[8];
		data[0] = 1048560L;
		data[3] = 17179869184L;
		return data;
	}

	public static final BitSet _tokenSet_88 = new BitSet(mk_tokenSet_88());

	private static final long[] mk_tokenSet_89() {
		long[] data = new long[12];
		data[3] = 34359738368L;
		data[5] = 35184372088832L;
		return data;
	}

	public static final BitSet _tokenSet_89 = new BitSet(mk_tokenSet_89());

	private static final long[] mk_tokenSet_90() {
		long[] data = new long[12];
		data[3] = 6291456L;
		data[5] = 67108864L;
		return data;
	}

	public static final BitSet _tokenSet_90 = new BitSet(mk_tokenSet_90());

	private static final long[] mk_tokenSet_91() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 288248587361042432L;
		data[5] = 70514924060928L;
		return data;
	}

	public static final BitSet _tokenSet_91 = new BitSet(mk_tokenSet_91());

	private static final long[] mk_tokenSet_92() {
		long[] data = new long[12];
		data[0] = 985472L;
		data[3] = 55834574848L;
		data[4] = 17660906160128L;
		data[5] = 70377485107200L;
		return data;
	}

	public static final BitSet _tokenSet_92 = new BitSet(mk_tokenSet_92());

	private static final long[] mk_tokenSet_93() {
		long[] data = new long[12];
		data[4] = 550301073408L;
		data[5] = 140123308288L;
		return data;
	}

	public static final BitSet _tokenSet_93 = new BitSet(mk_tokenSet_93());

	private static final long[] mk_tokenSet_94() {
		long[] data = new long[10];
		data[3] = 34359738368L;
		data[4] = 144115188075855872L;
		return data;
	}

	public static final BitSet _tokenSet_94 = new BitSet(mk_tokenSet_94());

	private static final long[] mk_tokenSet_95() {
		long[] data = new long[12];
		data[5] = 2147483648L;
		return data;
	}

	public static final BitSet _tokenSet_95 = new BitSet(mk_tokenSet_95());

	private static final long[] mk_tokenSet_96() {
		long[] data = new long[12];
		data[0] = 2L;
		data[5] = 1073741824L;
		return data;
	}

	public static final BitSet _tokenSet_96 = new BitSet(mk_tokenSet_96());

	private static final long[] mk_tokenSet_97() {
		long[] data = new long[8];
		data[0] = 1033248L;
		data[3] = 17179869184L;
		return data;
	}

	public static final BitSet _tokenSet_97 = new BitSet(mk_tokenSet_97());

	private static final long[] mk_tokenSet_98() {
		long[] data = new long[12];
		data[3] = 6291456L;
		data[5] = 524288L;
		return data;
	}

	public static final BitSet _tokenSet_98 = new BitSet(mk_tokenSet_98());

	private static final long[] mk_tokenSet_99() {
		long[] data = new long[12];
		data[3] = 281474976710656L;
		data[5] = 31L;
		return data;
	}

	public static final BitSet _tokenSet_99 = new BitSet(mk_tokenSet_99());

	private static final long[] mk_tokenSet_100() {
		long[] data = new long[12];
		data[3] = 37981519872L;
		data[4] = 32404806693814272L;
		data[5] = 175921877159936L;
		return data;
	}

	public static final BitSet _tokenSet_100 = new BitSet(mk_tokenSet_100());

	private static final long[] mk_tokenSet_101() {
		long[] data = new long[10];
		data[0] = 1042800L;
		data[3] = -17575005126656L;
		data[4] = 8250594517342765055L;
		return data;
	}

	public static final BitSet _tokenSet_101 = new BitSet(mk_tokenSet_101());

	private static final long[] mk_tokenSet_102() {
		long[] data = new long[12];
		data[3] = 34366029824L;
		data[5] = 34359738368L;
		return data;
	}

	public static final BitSet _tokenSet_102 = new BitSet(mk_tokenSet_102());

	private static final long[] mk_tokenSet_103() {
		long[] data = { 2L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_103 = new BitSet(mk_tokenSet_103());

	private static final long[] mk_tokenSet_104() {
		long[] data = new long[12];
		data[5] = 1073741824L;
		return data;
	}

	public static final BitSet _tokenSet_104 = new BitSet(mk_tokenSet_104());

}
