// $ANTLR 2.7.7 (20060930): "Express2SDAI.g" -> "Express2DictWalker.java"$

package nl.tue.buildingsmart.express.parser;

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bimserver.plugins.schema.AggregationType;
import org.bimserver.plugins.schema.ArrayType;
import org.bimserver.plugins.schema.BagType;
import org.bimserver.plugins.schema.BaseType;
import org.bimserver.plugins.schema.BinaryType;
import org.bimserver.plugins.schema.BooleanType;
import org.bimserver.plugins.schema.Bound;
import org.bimserver.plugins.schema.DefinedType;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.EnumerationType;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.schema.IntegerBound;
import org.bimserver.plugins.schema.IntegerType;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.ListType;
import org.bimserver.plugins.schema.LogicalType;
import org.bimserver.plugins.schema.NamedType;
import org.bimserver.plugins.schema.NumberType;
import org.bimserver.plugins.schema.RealType;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SelectType;
import org.bimserver.plugins.schema.SetType;
import org.bimserver.plugins.schema.SimpleType;
import org.bimserver.plugins.schema.StringType;
import org.bimserver.plugins.schema.UnderlyingType;
import org.bimserver.plugins.schema.VariableSizeAggregationType;

import antlr.ASTPair;
import antlr.MismatchedTokenException;
import antlr.NoViableAltException;
import antlr.RecognitionException;
import antlr.collections.AST;

@SuppressWarnings("all")
public class Express2DictWalker extends antlr.TreeParser {

	// Express2OwlMethods methods=new Express2OwlMethods();

	private int pass = 1;
	private SchemaDefinition schema = new SchemaDefinition();

	/**
	 * this is a very, very ugly shortcut to the unlimited bounds "?" token
	 */
	// HACK
	private static boolean unlimited_bound = false;

	/**
	 * stores the last INTEGER that was parsed. Is used in bounds
	 */
	private String nextInt;

	public SchemaDefinition getSchema() {
		return this.schema;
	}

	public void setPass(int i) {
		this.pass = i;
	}

	public boolean isPass2() {
		if (this.pass == 2)
			return true;
		else
			return false;
	}

	public int getPass() {
		return this.pass;
	}

	public void echo(String s) {
		System.out.println(s);
	}

	public Express2DictWalker() {
		super.tokenNames = _tokenNames;
	}

	private void match(AST tree, Express2DictWalkerTokenTypes type) throws MismatchedTokenException {
		super.match(tree, type.getIndex());
	}

	/**
	 * Checks for null trees and returns null accordingly
	 * 
	 * @return
	 */
	private AST handleNullTree(AST treeToCheck) {
		if (treeToCheck == ASTNULL) {
			return null;
		} else {
			return treeToCheck;
		}
	}

	public final void actual_parameter_list(AST _tree) throws RecognitionException {

		AST actual_parameter_list_AST_in = handleNullTree(_tree);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST actual_parameter_list_AST = null;

		try { // for error handling
			AST __t2 = _tree;
			AST tmp1_AST = null;
			AST tmp1_AST_in = null;
			tmp1_AST = astFactory.create(_tree);
			tmp1_AST_in = _tree;
			astFactory.addASTChild(currentAST, tmp1_AST);
			ASTPair __currentAST2 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_tree, Express2DictWalkerTokenTypes.ACTUAL_PARAMETER_LIST);
			_tree = _tree.getFirstChild();
			parameter(_tree);
			_tree = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop4: do {
					if (_tree == null) {
						_tree = ASTNULL;
					}
					if (_tree.getType() == Express2DictWalkerTokenTypes.PARAMETER.getIndex()) {
						parameter(_tree);
						_tree = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop4;
					}

				} while (true);
			}
			currentAST = __currentAST2;
			_tree = __t2;
			_tree = _tree.getNextSibling();
			actual_parameter_list_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_tree != null) {
				_tree = _tree.getNextSibling();
			}
		}
		returnAST = actual_parameter_list_AST;
		_retTree = _tree;
	}

	public final void parameter(AST _tree) throws RecognitionException {

		AST parameter_AST_in = handleNullTree(_tree);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_AST = null;

		try { // for error handling
			AST __t357 = _tree;
			AST tmp2_AST = null;
			AST tmp2_AST_in = null;
			tmp2_AST = super.astFactory.create(_tree);
			tmp2_AST_in = _tree;
			super.astFactory.addASTChild(currentAST, tmp2_AST);
			ASTPair __currentAST357 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_tree, Express2DictWalkerTokenTypes.PARAMETER);
			_tree = _tree.getFirstChild();
			expression(_tree);
			_tree = this._retTree;
			super.astFactory.addASTChild(currentAST, this.returnAST);
			currentAST = __currentAST357;
			_tree = __t357;
			_tree = _tree.getNextSibling();
			parameter_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_tree != null) {
				_tree = _tree.getNextSibling();
			}
		}
		returnAST = parameter_AST;
		_retTree = _tree;
	}

	public final void aggregate_initializer(AST _t) throws RecognitionException {

		AST aggregate_initializer_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_initializer_AST = null;

		try { // for error handling
			AST __t6 = _t;
			AST tmp3_AST = null;
			AST tmp3_AST_in = null;
			tmp3_AST = astFactory.create((AST) _t);
			tmp3_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp3_AST);
			ASTPair __currentAST6 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.AGGREGATE_INITIALIZER);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ELEMENT: {
					element(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop9: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.ELEMENT.getIndex())) {
								element(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop9;
							}

						} while (true);
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST6;
			_t = __t6;
			_t = _t.getNextSibling();
			aggregate_initializer_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = aggregate_initializer_AST;
		_retTree = _t;
	}

	public final void element(AST _t) throws RecognitionException {

		AST element_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST element_AST = null;

		try { // for error handling
			AST __t99 = _t;
			AST tmp4_AST = null;
			AST tmp4_AST_in = null;
			tmp4_AST = astFactory.create((AST) _t);
			tmp4_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp4_AST);
			ASTPair __currentAST99 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ELEMENT);
			_t = _t.getFirstChild();
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case REPETITION: {
					repetition(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST99;
			_t = __t99;
			_t = _t.getNextSibling();
			element_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = element_AST;
		_retTree = _t;
	}

	public final void aggregate_source(AST _t) throws RecognitionException {

		AST aggregate_source_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_source_AST = null;

		try { // for error handling
			AST __t11 = _t;
			AST tmp5_AST = null;
			AST tmp5_AST_in = null;
			tmp5_AST = astFactory.create((AST) _t);
			tmp5_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp5_AST);
			ASTPair __currentAST11 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.AGGREGATE_SOURCE);
			_t = _t.getFirstChild();
			simple_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST11;
			_t = __t11;
			_t = _t.getNextSibling();
			aggregate_source_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = aggregate_source_AST;
		_retTree = _t;
	}

	public final void simple_expression(AST _t) throws RecognitionException {

		AST simple_expression_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_expression_AST = null;

		try { // for error handling
			AST __t475 = _t;
			AST tmp6_AST = null;
			AST tmp6_AST_in = null;
			tmp6_AST = astFactory.create((AST) _t);
			tmp6_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp6_AST);
			ASTPair __currentAST475 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SIMPLE_EXPRESSION);
			_t = _t.getFirstChild();
			term(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop477: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.ADD_LIKE_OP.getIndex())) {
						add_like_op(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
						term(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop477;
					}

				} while (true);
			}
			currentAST = __currentAST475;
			_t = __t475;
			_t = _t.getNextSibling();
			simple_expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = simple_expression_AST;
		_retTree = _t;
	}

	public final String aggregate_type(AST _t) throws RecognitionException {
		String TypeName = "aggregate";

		AST aggregate_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_type_AST = null;

		try { // for error handling
			AST __t13 = _t;
			AST tmp7_AST = null;
			AST tmp7_AST_in = null;
			tmp7_AST = astFactory.create((AST) _t);
			tmp7_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp7_AST);
			ASTPair __currentAST13 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.AGGREGATE_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case TYPE_LABEL: {
					type_label(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PARAMETER_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST13;
			_t = __t13;
			_t = _t.getNextSibling();
			aggregate_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = aggregate_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void type_label(AST _t) throws RecognitionException {

		AST type_label_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_AST = null;

		try { // for error handling
			AST __t576 = _t;
			AST tmp8_AST = null;
			AST tmp8_AST_in = null;
			tmp8_AST = astFactory.create((AST) _t);
			tmp8_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp8_AST);
			ASTPair __currentAST576 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TYPE_LABEL);
			_t = _t.getFirstChild();
			AST tmp9_AST = null;
			AST tmp9_AST_in = null;
			tmp9_AST = astFactory.create((AST) _t);
			tmp9_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp9_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST576;
			_t = __t576;
			_t = _t.getNextSibling();
			type_label_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = type_label_AST;
		_retTree = _t;
	}

	public final String parameter_type(AST _t) throws RecognitionException {
		String TypeName = "";

		AST parameter_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_type_AST = null;

		try { // for error handling
			AST __t361 = _t;
			AST tmp10_AST = null;
			AST tmp10_AST_in = null;
			tmp10_AST = astFactory.create((AST) _t);
			tmp10_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp10_AST);
			ASTPair __currentAST361 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PARAMETER_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case GENERALIZED_TYPES: {
					TypeName = generalized_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NAMED_TYPES: {
					TypeName = named_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SIMPLE_TYPES: {
					TypeName = simple_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST361;
			_t = __t361;
			_t = _t.getNextSibling();
			parameter_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = parameter_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String[] aggregation_types(AST _t) throws RecognitionException {
		String[] TypeName = new String[4];

		AST aggregation_types_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregation_types_AST = null;

		try { // for error handling
			AST __t16 = _t;
			AST tmp11_AST = null;
			AST tmp11_AST_in = null;
			tmp11_AST = astFactory.create((AST) _t);
			tmp11_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp11_AST);
			ASTPair __currentAST16 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.AGGREGATION_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ARRAY_TYPE: {
					TypeName = array_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BAG_TYPE: {
					TypeName = bag_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LIST_TYPE: {
					TypeName = list_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SET_TYPE: {
					TypeName = set_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST16;
			_t = __t16;
			_t = _t.getNextSibling();
			aggregation_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = aggregation_types_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String[] array_type(AST _t) throws RecognitionException {
		String[] TypeName = new String[4];

		AST array_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST array_type_AST = null;

		String[] bounds = new String[2];
		String type = "";

		try { // for error handling
			AST __t31 = _t;
			AST tmp12_AST = null;
			AST tmp12_AST_in = null;
			tmp12_AST = astFactory.create((AST) _t);
			tmp12_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp12_AST);
			ASTPair __currentAST31 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ARRAY_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bounds = bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BASE_TYPE:
				case LITERAL_unique: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_unique: {
					AST tmp13_AST = null;
					AST tmp13_AST_in = null;
					tmp13_AST = astFactory.create((AST) _t);
					tmp13_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp13_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_unique);
					_t = _t.getNextSibling();
					break;
				}
				case BASE_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			type = base_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST31;
			_t = __t31;
			_t = _t.getNextSibling();

			TypeName[0] = type;
			TypeName[1] = bounds[0];
			TypeName[2] = bounds[1];
			TypeName[3] = "ARRAY";

			array_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = array_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String[] bag_type(AST _t) throws RecognitionException {
		String[] TypeName = new String[4];

		AST bag_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bag_type_AST = null;

		String[] bounds = new String[2];
		String type = "";

		try { // for error handling
			AST __t40 = _t;
			AST tmp14_AST = null;
			AST tmp14_AST_in = null;
			tmp14_AST = astFactory.create((AST) _t);
			tmp14_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp14_AST);
			ASTPair __currentAST40 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BAG_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bounds = bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BASE_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			type = base_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST40;
			_t = __t40;
			_t = _t.getNextSibling();

			TypeName[0] = type;
			TypeName[1] = bounds[0];
			TypeName[2] = bounds[1];
			TypeName[3] = "BAG";

			bag_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = bag_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String[] list_type(AST _t) throws RecognitionException {
		String[] TypeName = new String[4];

		AST list_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST list_type_AST = null;

		String[] bounds = new String[2];
		String type = "";

		try { // for error handling
			AST __t315 = _t;
			AST tmp15_AST = null;
			AST tmp15_AST_in = null;
			tmp15_AST = astFactory.create((AST) _t);
			tmp15_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp15_AST);
			ASTPair __currentAST315 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LIST_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bounds = bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BASE_TYPE:
				case LITERAL_unique: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_unique: {
					AST tmp16_AST = null;
					AST tmp16_AST_in = null;
					tmp16_AST = astFactory.create((AST) _t);
					tmp16_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp16_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_unique);
					_t = _t.getNextSibling();
					break;
				}
				case BASE_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			type = base_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST315;
			_t = __t315;
			_t = _t.getNextSibling();

			// TypeName=" is a List of " + test + TypeName ;
			// System.out.println ("L I S T" + test);
			TypeName[0] = type;
			TypeName[1] = bounds[0];
			TypeName[2] = bounds[1];
			TypeName[3] = "LIST";

			list_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = list_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String[] set_type(AST _t) throws RecognitionException {
		String[] TypeName = new String[4];

		AST set_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST set_type_AST = null;

		String[] bounds = new String[2];
		String type = "";

		try { // for error handling
			AST __t471 = _t;
			AST tmp17_AST = null;
			AST tmp17_AST_in = null;
			tmp17_AST = astFactory.create((AST) _t);
			tmp17_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp17_AST);
			ASTPair __currentAST471 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SET_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bounds = bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BASE_TYPE:
				case LITERAL_unique: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_unique: {
					AST tmp18_AST = null;
					AST tmp18_AST_in = null;
					tmp18_AST = astFactory.create((AST) _t);
					tmp18_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp18_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_unique);
					_t = _t.getNextSibling();
					break;
				}
				case BASE_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			type = base_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST471;
			_t = __t471;
			_t = _t.getNextSibling();

			// TypeName=" is a List of " + test + TypeName ;
			// System.out.println ("L I S T" + test);
			TypeName[0] = type;
			TypeName[1] = bounds[0];
			TypeName[2] = bounds[1];
			TypeName[3] = "SET";

			set_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = set_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void algorithm_head(AST _t) throws RecognitionException {

		AST algorithm_head_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST algorithm_head_AST = null;

		try { // for error handling
			AST __t19 = _t;
			AST tmp19_AST = null;
			AST tmp19_AST_in = null;
			tmp19_AST = astFactory.create((AST) _t);
			tmp19_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp19_AST);
			ASTPair __currentAST19 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ALGORITHM_HEAD);
			_t = _t.getFirstChild();
			{
				_loop21: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.DECLARATION.getIndex())) {
						declaration(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop21;
					}

				} while (true);
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONSTANT_DECL: {
					constant_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case LOCAL_DECL: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LOCAL_DECL: {
					local_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST19;
			_t = __t19;
			_t = _t.getNextSibling();
			algorithm_head_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = algorithm_head_AST;
		_retTree = _t;
	}

	public final void declaration(AST _t) throws RecognitionException {

		AST declaration_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaration_AST = null;

		try { // for error handling
			AST __t93 = _t;
			AST tmp20_AST = null;
			AST tmp20_AST_in = null;
			tmp20_AST = astFactory.create((AST) _t);
			tmp20_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp20_AST);
			ASTPair __currentAST93 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.DECLARATION);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENTITY_DECL: {
					entity_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SUBTYPE_CONSTRAINT_DECL: {
					subtype_constraint_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case FUNCTION_DECL: {
					function_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PROCEDURE_DECL: {
					procedure_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case TYPE_DECL: {
					type_decl(_t, "test");
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST93;
			_t = __t93;
			_t = _t.getNextSibling();
			declaration_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = declaration_AST;
		_retTree = _t;
	}

	public final void constant_decl(AST _t) throws RecognitionException {

		AST constant_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_decl_AST = null;

		try { // for error handling
			AST __t84 = _t;
			AST tmp21_AST = null;
			AST tmp21_AST_in = null;
			tmp21_AST = astFactory.create((AST) _t);
			tmp21_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp21_AST);
			ASTPair __currentAST84 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONSTANT_DECL);
			_t = _t.getFirstChild();
			constant_body(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop86: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.CONSTANT_BODY.getIndex())) {
						constant_body(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop86;
					}

				} while (true);
			}
			currentAST = __currentAST84;
			_t = __t84;
			_t = _t.getNextSibling();
			constant_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = constant_decl_AST;
		_retTree = _t;
	}

	public final void local_decl(AST _t) throws RecognitionException {

		AST local_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST local_decl_AST = null;

		try { // for error handling
			AST __t328 = _t;
			AST tmp22_AST = null;
			AST tmp22_AST_in = null;
			tmp22_AST = astFactory.create((AST) _t);
			tmp22_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp22_AST);
			ASTPair __currentAST328 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LOCAL_DECL);
			_t = _t.getFirstChild();
			local_variable(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop330: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.LOCAL_VARIABLE.getIndex())) {
						local_variable(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop330;
					}

				} while (true);
			}
			currentAST = __currentAST328;
			_t = __t328;
			_t = _t.getNextSibling();
			local_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = local_decl_AST;
		_retTree = _t;
	}

	public final void alias_stmt(AST _t) throws RecognitionException {

		AST alias_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_stmt_AST = null;

		try { // for error handling
			AST __t25 = _t;
			AST tmp23_AST = null;
			AST tmp23_AST_in = null;
			tmp23_AST = astFactory.create((AST) _t);
			tmp23_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp23_AST);
			ASTPair __currentAST25 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ALIAS_STMT);
			_t = _t.getFirstChild();
			variable_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			general_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop27: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.QUALIFIER.getIndex())) {
						qualifier(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop27;
					}

				} while (true);
			}
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop29: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop29;
					}

				} while (true);
			}
			currentAST = __currentAST25;
			_t = __t25;
			_t = _t.getNextSibling();
			alias_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = alias_stmt_AST;
		_retTree = _t;
	}

	public final void variable_id(AST _t) throws RecognitionException {

		AST variable_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_id_AST = null;

		try { // for error handling
			AST __t585 = _t;
			AST tmp24_AST = null;
			AST tmp24_AST_in = null;
			tmp24_AST = astFactory.create((AST) _t);
			tmp24_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp24_AST);
			ASTPair __currentAST585 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.VARIABLE_ID);
			_t = _t.getFirstChild();
			AST tmp25_AST = null;
			AST tmp25_AST_in = null;
			tmp25_AST = astFactory.create((AST) _t);
			tmp25_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp25_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST585;
			_t = __t585;
			_t = _t.getNextSibling();
			variable_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = variable_id_AST;
		_retTree = _t;
	}

	public final void general_ref(AST _t) throws RecognitionException {

		AST general_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_ref_AST = null;

		try { // for error handling
			AST __t266 = _t;
			AST tmp26_AST = null;
			AST tmp26_AST_in = null;
			tmp26_AST = astFactory.create((AST) _t);
			tmp26_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp26_AST);
			ASTPair __currentAST266 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERAL_REF);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case PARAMETER_REF: {
					parameter_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case VARIABLE_REF: {
					variable_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST266;
			_t = __t266;
			_t = _t.getNextSibling();
			general_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = general_ref_AST;
		_retTree = _t;
	}

	public final void qualifier(AST _t) throws RecognitionException {

		AST qualifier_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifier_AST = null;

		try { // for error handling
			AST __t397 = _t;
			AST tmp27_AST = null;
			AST tmp27_AST_in = null;
			tmp27_AST = astFactory.create((AST) _t);
			tmp27_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp27_AST);
			ASTPair __currentAST397 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.QUALIFIER);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ATTRIBUTE_QUALIFIER: {
					attribute_qualifier(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GROUP_QUALIFIER: {
					group_qualifier(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case INDEX_QUALIFIER: {
					index_qualifier(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST397;
			_t = __t397;
			_t = _t.getNextSibling();
			qualifier_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = qualifier_AST;
		_retTree = _t;
	}

	public final void stmt(AST _t) throws RecognitionException {

		AST stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stmt_AST = null;

		try { // for error handling
			AST __t495 = _t;
			AST tmp28_AST = null;
			AST tmp28_AST_in = null;
			tmp28_AST = astFactory.create((AST) _t);
			tmp28_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp28_AST);
			ASTPair __currentAST495 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.STMT);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ALIAS_STMT: {
					alias_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ASSIGNMENT_STMT: {
					assignment_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case CASE_STMT: {
					case_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMPOUND_STMT: {
					compound_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ESCAPE_STMT: {
					escape_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case IF_STMT: {
					if_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_STMT: {
					null_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PROCEDURE_CALL_STMT: {
					procedure_call_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case REPEAT_STMT: {
					repeat_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case RETURN_STMT: {
					return_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SKIP_STMT: {
					skip_stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST495;
			_t = __t495;
			_t = _t.getNextSibling();
			stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = stmt_AST;
		_retTree = _t;
	}

	public final String[] bound_spec(AST _t) throws RecognitionException {
		String[] bound = new String[2];

		AST bound_spec_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_spec_AST = null;

		String lower, upper = "";

		try { // for error handling
			AST __t62 = _t;
			AST tmp29_AST = null;
			AST tmp29_AST_in = null;
			tmp29_AST = astFactory.create((AST) _t);
			tmp29_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp29_AST);
			ASTPair __currentAST62 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BOUND_SPEC);
			_t = _t.getFirstChild();
			lower = bound_1(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			upper = bound_2(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST62;
			_t = __t62;
			_t = _t.getNextSibling();

			bound[0] = lower;
			bound[1] = upper;
			;

			bound_spec_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = bound_spec_AST;
		_retTree = _t;
		return bound;
	}

	public final String base_type(AST _t) throws RecognitionException {
		String TypeName = "";

		AST base_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST base_type_AST = null;

		try { // for error handling
			AST __t43 = _t;
			AST tmp30_AST = null;
			AST tmp30_AST_in = null;
			tmp30_AST = astFactory.create((AST) _t);
			tmp30_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp30_AST);
			ASTPair __currentAST43 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BASE_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONCRETE_TYPES: {
					TypeName = concrete_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERALIZED_TYPES: {
					TypeName = generalized_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST43;
			_t = __t43;
			_t = _t.getNextSibling();
			base_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = base_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void assignment_stmt(AST _t) throws RecognitionException {

		AST assignment_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignment_stmt_AST = null;

		try { // for error handling
			AST __t35 = _t;
			AST tmp31_AST = null;
			AST tmp31_AST_in = null;
			tmp31_AST = astFactory.create((AST) _t);
			tmp31_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp31_AST);
			ASTPair __currentAST35 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ASSIGNMENT_STMT);
			_t = _t.getFirstChild();
			{
				general_ref(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop38: do {
						if (_t == null)
							_t = ASTNULL;
						if ((_t.getType() == Express2DictWalkerTokenTypes.QUALIFIER.getIndex())) {
							qualifier(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop38;
						}

					} while (true);
				}
			}
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST35;
			_t = __t35;
			_t = _t.getNextSibling();
			assignment_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = assignment_stmt_AST;
		_retTree = _t;
	}

	public final void expression(AST _t) throws RecognitionException {

		AST expression_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;

		try { // for error handling
			AST __t209 = _t;
			AST tmp32_AST = null;
			AST tmp32_AST_in = null;
			tmp32_AST = astFactory.create((AST) _t);
			tmp32_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp32_AST);
			ASTPair __currentAST209 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.EXPRESSION);
			_t = _t.getFirstChild();
			simple_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case REL_OP_EXTENDED: {
					rel_op_extended(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					simple_expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST209;
			_t = __t209;
			_t = _t.getNextSibling();
			expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = expression_AST;
		_retTree = _t;
	}

	public final String concrete_types(AST _t) throws RecognitionException {
		String TypeName = "";

		AST concrete_types_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST concrete_types_AST = null;

		String[] aggregate = new String[2];

		try { // for error handling
			AST __t46 = _t;
			AST tmp33_AST = null;
			AST tmp33_AST_in = null;
			tmp33_AST = astFactory.create((AST) _t);
			tmp33_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp33_AST);
			ASTPair __currentAST46 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONCRETE_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case AGGREGATION_TYPES: {
					aggregate = aggregation_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					System.out.println("aggregat");
					break;
				}
				case SIMPLE_TYPES: {
					TypeName = simple_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NAMED_TYPES: {
					TypeName = named_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST46;
			_t = __t46;
			_t = _t.getNextSibling();
			concrete_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = concrete_types_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String generalized_types(AST _t) throws RecognitionException {
		String TypeName = "";

		AST generalized_types_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generalized_types_AST = null;

		try { // for error handling
			AST __t246 = _t;
			AST tmp34_AST = null;
			AST tmp34_AST_in = null;
			tmp34_AST = astFactory.create((AST) _t);
			tmp34_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp34_AST);
			ASTPair __currentAST246 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERALIZED_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case AGGREGATE_TYPE: {
					aggregate_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERAL_AGGREGATION_TYPES: {
					TypeName = general_aggregation_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERIC_TYPE: {
					generic_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERIC_ENTITY_TYPE: {
					generic_entity_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST246;
			_t = __t246;
			_t = _t.getNextSibling();
			generalized_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = generalized_types_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String simple_types(AST _t) throws RecognitionException {
		String TypeName = "simpleType";

		AST simple_types_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_types_AST = null;

		SimpleType st;

		try { // for error handling
			AST __t487 = _t;
			AST tmp35_AST = null;
			AST tmp35_AST_in = null;
			tmp35_AST = astFactory.create((AST) _t);
			tmp35_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp35_AST);
			ASTPair __currentAST487 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SIMPLE_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BINARY_TYPE: {
					TypeName = binary_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BOOLEAN_TYPE: {
					TypeName = boolean_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case INTEGER_TYPE: {
					TypeName = integer_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LOGICAL_TYPE: {
					TypeName = logical_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NUMBER_TYPE: {
					TypeName = number_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case REAL_TYPE: {
					TypeName = real_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case STRING_TYPE: {
					TypeName = string_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST487;
			_t = __t487;
			_t = _t.getNextSibling();
			simple_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = simple_types_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String named_types(AST _t) throws RecognitionException {
		String TypeName = "";

		AST named_types_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST named_types_AST = null;

		try { // for error handling
			AST __t344 = _t;
			AST tmp36_AST = null;
			AST tmp36_AST_in = null;
			tmp36_AST = astFactory.create((AST) _t);
			tmp36_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp36_AST);
			ASTPair __currentAST344 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.NAMED_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENTITY_REF: {
					TypeName = entity_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					TypeName = TypeName;
					break;
				}
				case TYPE_REF: {
					TypeName = type_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					TypeName = TypeName;
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST344;
			_t = __t344;
			_t = _t.getNextSibling();
			named_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = named_types_AST;
		_retTree = _t;
		return TypeName;
	}

	public final String binary_type(AST _t) throws RecognitionException {
		String TypeName = "BINARY";

		AST binary_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST binary_type_AST = null;

		try { // for error handling
			AST __t49 = _t;
			AST tmp37_AST = null;
			AST tmp37_AST_in = null;
			tmp37_AST = astFactory.create((AST) _t);
			tmp37_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp37_AST);
			ASTPair __currentAST49 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BINARY_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case WIDTH_SPEC: {
					width_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST49;
			_t = __t49;
			_t = _t.getNextSibling();
			binary_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = binary_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void width_spec(AST _t) throws RecognitionException {

		AST width_spec_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST width_spec_AST = null;

		try { // for error handling
			AST __t595 = _t;
			AST tmp38_AST = null;
			AST tmp38_AST_in = null;
			tmp38_AST = astFactory.create((AST) _t);
			tmp38_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp38_AST);
			ASTPair __currentAST595 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.WIDTH_SPEC);
			_t = _t.getFirstChild();
			width(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_fixed: {
					AST tmp39_AST = null;
					AST tmp39_AST_in = null;
					tmp39_AST = astFactory.create((AST) _t);
					tmp39_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp39_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_fixed);
					_t = _t.getNextSibling();
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST595;
			_t = __t595;
			_t = _t.getNextSibling();
			width_spec_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = width_spec_AST;
		_retTree = _t;
	}

	public final String boolean_type(AST _t) throws RecognitionException {
		String TypeName = "BOOLEAN";

		AST boolean_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_type_AST = null;

		try { // for error handling
			AST __t52 = _t;
			AST tmp40_AST = null;
			AST tmp40_AST_in = null;
			tmp40_AST = astFactory.create((AST) _t);
			tmp40_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp40_AST);
			ASTPair __currentAST52 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BOOLEAN_TYPE);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST52;
			_t = __t52;
			_t = _t.getNextSibling();
			boolean_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = boolean_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void nothing(AST _t) throws RecognitionException {

		AST nothing_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nothing_AST = null;

		try { // for error handling
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_: {
					AST tmp41_AST = null;
					AST tmp41_AST_in = null;
					tmp41_AST = astFactory.create((AST) _t);
					tmp41_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp41_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_);
					_t = _t.getNextSibling();
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			nothing_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = nothing_AST;
		_retTree = _t;
	}

	public final String bound_1(AST _t) throws RecognitionException {
		String NumEx = "";

		AST bound_1_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_1_AST = null;

		String se = "";

		try { // for error handling
			AST __t54 = _t;
			AST tmp42_AST = null;
			AST tmp42_AST_in = null;
			tmp42_AST = astFactory.create((AST) _t);
			tmp42_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp42_AST);
			ASTPair __currentAST54 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BOUND_1);
			_t = _t.getFirstChild();
			se = numeric_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST54;
			_t = __t54;
			_t = _t.getNextSibling();

			/*
			 * The little bugger "?" to denote no limit in a bound hides in this
			 * patth: SIMPLE_EXPRESSION ( TERM ( FACTOR ( SIMPLE_FACTOR (
			 * PRIMARY ( QUALIFIABLE_FACTOR ( CONSTANT_FACTOR (
			 * BUILT_IN_CONSTANT ? Here is a VERY LAZY QUICKHACK to get a
			 * shortcut to it:
			 */

			if (unlimited_bound) {
				NumEx = "?";
				unlimited_bound = false;
			} else
				NumEx = nextInt;

			bound_1_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = bound_1_AST;
		_retTree = _t;
		return NumEx;
	}

	public final String numeric_expression(AST _t) throws RecognitionException {
		String se = "";

		AST numeric_expression_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numeric_expression_AST = null;
		AST s_AST = null;
		AST s = null;

		try { // for error handling
			AST __t351 = _t;
			AST tmp43_AST = null;
			AST tmp43_AST_in = null;
			tmp43_AST = astFactory.create((AST) _t);
			tmp43_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp43_AST);
			ASTPair __currentAST351 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.NUMERIC_EXPRESSION);
			_t = _t.getFirstChild();
			s = _t == ASTNULL ? null : (AST) _t;
			simple_expression(_t);
			_t = _retTree;
			s_AST = (AST) returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST351;
			_t = __t351;
			_t = _t.getNextSibling();

			se = s.toStringList();

			numeric_expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = numeric_expression_AST;
		_retTree = _t;
		return se;
	}

	public final void unlimited_upper_bound(AST _t) throws RecognitionException {

		AST unlimited_upper_bound_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unlimited_upper_bound_AST = null;

		try { // for error handling
			AST __t56 = _t;
			AST tmp44_AST = null;
			AST tmp44_AST_in = null;
			tmp44_AST = astFactory.create((AST) _t);
			tmp44_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp44_AST);
			ASTPair __currentAST56 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BOUND_2);
			_t = _t.getFirstChild();
			simple_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				term(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
					factor(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			currentAST = __currentAST56;
			_t = __t56;
			_t = _t.getNextSibling();

			System.out.println("unlimited upper bound");

			unlimited_upper_bound_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = unlimited_upper_bound_AST;
		_retTree = _t;
	}

	public final void term(AST _t) throws RecognitionException {

		AST term_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST term_AST = null;

		try { // for error handling
			AST __t528 = _t;
			AST tmp45_AST = null;
			AST tmp45_AST_in = null;
			tmp45_AST = astFactory.create((AST) _t);
			tmp45_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp45_AST);
			ASTPair __currentAST528 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TERM);
			_t = _t.getFirstChild();
			factor(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop530: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.MULTIPLICATION_LIKE_OP.getIndex())) {
						multiplication_like_op(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
						factor(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop530;
					}

				} while (true);
			}
			currentAST = __currentAST528;
			_t = __t528;
			_t = _t.getNextSibling();
			term_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = term_AST;
		_retTree = _t;
	}

	public final void factor(AST _t) throws RecognitionException {

		AST factor_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST factor_AST = null;

		try { // for error handling
			AST __t218 = _t;
			AST tmp46_AST = null;
			AST tmp46_AST_in = null;
			tmp46_AST = astFactory.create((AST) _t);
			tmp46_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp46_AST);
			ASTPair __currentAST218 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FACTOR);
			_t = _t.getFirstChild();
			simple_factor(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SIMPLE_FACTOR: {
					simple_factor(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST218;
			_t = __t218;
			_t = _t.getNextSibling();
			factor_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = factor_AST;
		_retTree = _t;
	}

	public final String bound_2(AST _t) throws RecognitionException {
		String NumEx = "";

		AST bound_2_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bound_2_AST = null;
		AST ne_AST = null;
		AST ne = null;

		try { // for error handling
			AST __t60 = _t;
			AST tmp47_AST = null;
			AST tmp47_AST_in = null;
			tmp47_AST = astFactory.create((AST) _t);
			tmp47_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp47_AST);
			ASTPair __currentAST60 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BOUND_2);
			_t = _t.getFirstChild();
			ne = _t == ASTNULL ? null : (AST) _t;
			numeric_expression(_t);
			_t = _retTree;
			ne_AST = (AST) returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST60;
			_t = __t60;
			_t = _t.getNextSibling();

			if (unlimited_bound) {
				NumEx = "?";
				unlimited_bound = false;
			} else
				NumEx = nextInt;

			bound_2_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = bound_2_AST;
		_retTree = _t;
		return NumEx;
	}

	public final void built_in_constant(AST _t) throws RecognitionException {

		AST built_in_constant_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_constant_AST = null;

		try { // for error handling
			AST __t64 = _t;
			AST tmp48_AST = null;
			AST tmp48_AST_in = null;
			tmp48_AST = astFactory.create((AST) _t);
			tmp48_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp48_AST);
			ASTPair __currentAST64 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BUILT_IN_CONSTANT);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_const_e: {
					AST tmp49_AST = null;
					AST tmp49_AST_in = null;
					tmp49_AST = astFactory.create((AST) _t);
					tmp49_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp49_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_const_e);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_pi: {
					AST tmp50_AST = null;
					AST tmp50_AST_in = null;
					tmp50_AST = astFactory.create((AST) _t);
					tmp50_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp50_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_pi);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_self: {
					AST tmp51_AST = null;
					AST tmp51_AST_in = null;
					tmp51_AST = astFactory.create((AST) _t);
					tmp51_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp51_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_self);
					_t = _t.getNextSibling();
					break;
				}
				case QUESTION: {
					AST tmp52_AST = null;
					AST tmp52_AST_in = null;
					tmp52_AST = astFactory.create((AST) _t);
					tmp52_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp52_AST);
					match(_t, Express2DictWalkerTokenTypes.QUESTION);
					_t = _t.getNextSibling();
					unlimited_bound = true;
					break;
				}
				case STAR: {
					AST tmp53_AST = null;
					AST tmp53_AST_in = null;
					tmp53_AST = astFactory.create((AST) _t);
					tmp53_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp53_AST);
					match(_t, Express2DictWalkerTokenTypes.STAR);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST64;
			_t = __t64;
			_t = _t.getNextSibling();
			built_in_constant_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = built_in_constant_AST;
		_retTree = _t;
	}

	public final void case_action(AST _t) throws RecognitionException {

		AST case_action_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_action_AST = null;

		try { // for error handling
			AST __t67 = _t;
			AST tmp54_AST = null;
			AST tmp54_AST_in = null;
			tmp54_AST = astFactory.create((AST) _t);
			tmp54_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp54_AST);
			ASTPair __currentAST67 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CASE_ACTION);
			_t = _t.getFirstChild();
			case_label(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop69: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.CASE_LABEL.getIndex())) {
						case_label(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop69;
					}

				} while (true);
			}
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST67;
			_t = __t67;
			_t = _t.getNextSibling();
			case_action_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = case_action_AST;
		_retTree = _t;
	}

	public final void case_label(AST _t) throws RecognitionException {

		AST case_label_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_label_AST = null;

		try { // for error handling
			AST __t71 = _t;
			AST tmp55_AST = null;
			AST tmp55_AST_in = null;
			tmp55_AST = astFactory.create((AST) _t);
			tmp55_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp55_AST);
			ASTPair __currentAST71 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CASE_LABEL);
			_t = _t.getFirstChild();
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST71;
			_t = __t71;
			_t = _t.getNextSibling();
			case_label_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = case_label_AST;
		_retTree = _t;
	}

	public final void case_stmt(AST _t) throws RecognitionException {

		AST case_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_stmt_AST = null;

		try { // for error handling
			AST __t73 = _t;
			AST tmp56_AST = null;
			AST tmp56_AST_in = null;
			tmp56_AST = astFactory.create((AST) _t);
			tmp56_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp56_AST);
			ASTPair __currentAST73 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CASE_STMT);
			_t = _t.getFirstChild();
			selector(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop75: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.CASE_ACTION.getIndex())) {
						case_action(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop75;
					}

				} while (true);
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case STMT: {
					stmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST73;
			_t = __t73;
			_t = _t.getNextSibling();
			case_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = case_stmt_AST;
		_retTree = _t;
	}

	public final void selector(AST _t) throws RecognitionException {

		AST selector_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST selector_AST = null;

		try { // for error handling
			AST __t469 = _t;
			AST tmp57_AST = null;
			AST tmp57_AST_in = null;
			tmp57_AST = astFactory.create((AST) _t);
			tmp57_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp57_AST);
			ASTPair __currentAST469 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SELECTOR);
			_t = _t.getFirstChild();
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST469;
			_t = __t469;
			_t = _t.getNextSibling();
			selector_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = selector_AST;
		_retTree = _t;
	}

	public final void compound_stmt(AST _t) throws RecognitionException {

		AST compound_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compound_stmt_AST = null;

		try { // for error handling
			AST __t78 = _t;
			AST tmp58_AST = null;
			AST tmp58_AST_in = null;
			tmp58_AST = astFactory.create((AST) _t);
			tmp58_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp58_AST);
			ASTPair __currentAST78 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.COMPOUND_STMT);
			_t = _t.getFirstChild();
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop80: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop80;
					}

				} while (true);
			}
			currentAST = __currentAST78;
			_t = __t78;
			_t = _t.getNextSibling();
			compound_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = compound_stmt_AST;
		_retTree = _t;
	}

	public final void constant_body(AST _t) throws RecognitionException {

		AST constant_body_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_body_AST = null;

		try { // for error handling
			AST __t82 = _t;
			AST tmp59_AST = null;
			AST tmp59_AST_in = null;
			tmp59_AST = astFactory.create((AST) _t);
			tmp59_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp59_AST);
			ASTPair __currentAST82 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONSTANT_BODY);
			_t = _t.getFirstChild();
			constant_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			base_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST82;
			_t = __t82;
			_t = _t.getNextSibling();
			constant_body_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = constant_body_AST;
		_retTree = _t;
	}

	public final void constant_id(AST _t) throws RecognitionException {

		AST constant_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_id_AST = null;

		try { // for error handling
			AST __t91 = _t;
			AST tmp60_AST = null;
			AST tmp60_AST_in = null;
			tmp60_AST = astFactory.create((AST) _t);
			tmp60_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp60_AST);
			ASTPair __currentAST91 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONSTANT_ID);
			_t = _t.getFirstChild();
			AST tmp61_AST = null;
			AST tmp61_AST_in = null;
			tmp61_AST = astFactory.create((AST) _t);
			tmp61_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp61_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST91;
			_t = __t91;
			_t = _t.getNextSibling();
			constant_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = constant_id_AST;
		_retTree = _t;
	}

	public final void constant_factor(AST _t) throws RecognitionException {

		AST constant_factor_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_factor_AST = null;

		try { // for error handling
			AST __t88 = _t;
			AST tmp62_AST = null;
			AST tmp62_AST_in = null;
			tmp62_AST = astFactory.create((AST) _t);
			tmp62_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp62_AST);
			ASTPair __currentAST88 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONSTANT_FACTOR);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BUILT_IN_CONSTANT: {
					built_in_constant(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case CONSTANT_REF: {
					constant_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST88;
			_t = __t88;
			_t = _t.getNextSibling();
			constant_factor_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = constant_factor_AST;
		_retTree = _t;
	}

	public final void constant_ref(AST _t) throws RecognitionException {

		AST constant_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_ref_AST = null;

		try { // for error handling
			AST __t608 = _t;
			AST tmp63_AST = null;
			AST tmp63_AST_in = null;
			tmp63_AST = astFactory.create((AST) _t);
			tmp63_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp63_AST);
			ASTPair __currentAST608 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONSTANT_REF);
			_t = _t.getFirstChild();
			AST tmp64_AST = null;
			AST tmp64_AST_in = null;
			tmp64_AST = astFactory.create((AST) _t);
			tmp64_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp64_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST608;
			_t = __t608;
			_t = _t.getNextSibling();
			constant_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = constant_ref_AST;
		_retTree = _t;
	}

	public final void entity_decl(AST _t) throws RecognitionException {

		AST entity_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_decl_AST = null;

		String className = "";

		try { // for error handling
			AST __t106 = _t;
			AST tmp65_AST = null;
			AST tmp65_AST_in = null;
			tmp65_AST = astFactory.create((AST) _t);
			tmp65_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp65_AST);
			ASTPair __currentAST106 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_DECL);
			_t = _t.getFirstChild();
			className = entity_head(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);

			entity_body(_t, className);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST106;
			_t = __t106;
			_t = _t.getNextSibling();
			entity_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = entity_decl_AST;
		_retTree = _t;
	}

	public final void subtype_constraint_decl(AST _t) throws RecognitionException {

		AST subtype_constraint_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_decl_AST = null;

		try { // for error handling
			AST __t128 = _t;
			AST tmp66_AST = null;
			AST tmp66_AST_in = null;
			tmp66_AST = astFactory.create((AST) _t);
			tmp66_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp66_AST);
			ASTPair __currentAST128 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBTYPE_CONSTRAINT_DECL);
			_t = _t.getFirstChild();
			subtype_constraint_head(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			subtype_constraint_body(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST128;
			_t = __t128;
			_t = _t.getNextSibling();
			subtype_constraint_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subtype_constraint_decl_AST;
		_retTree = _t;
	}

	public final void function_decl(AST _t) throws RecognitionException {

		AST function_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_decl_AST = null;

		try { // for error handling
			AST __t234 = _t;
			AST tmp67_AST = null;
			AST tmp67_AST_in = null;
			tmp67_AST = astFactory.create((AST) _t);
			tmp67_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp67_AST);
			ASTPair __currentAST234 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FUNCTION_DECL);
			_t = _t.getFirstChild();
			function_head(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ALGORITHM_HEAD: {
					algorithm_head(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case STMT: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop237: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop237;
					}

				} while (true);
			}
			currentAST = __currentAST234;
			_t = __t234;
			_t = _t.getNextSibling();
			function_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = function_decl_AST;
		_retTree = _t;
	}

	public final void procedure_decl(AST _t) throws RecognitionException {

		AST procedure_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_decl_AST = null;

		try { // for error handling
			AST __t380 = _t;
			AST tmp68_AST = null;
			AST tmp68_AST_in = null;
			tmp68_AST = astFactory.create((AST) _t);
			tmp68_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp68_AST);
			ASTPair __currentAST380 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PROCEDURE_DECL);
			_t = _t.getFirstChild();
			procedure_head(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ALGORITHM_HEAD: {
					algorithm_head(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case STMT: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				_loop383: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop383;
					}

				} while (true);
			}
			currentAST = __currentAST380;
			_t = __t380;
			_t = _t.getNextSibling();
			procedure_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = procedure_decl_AST;
		_retTree = _t;
	}

	public final void type_decl(AST _t, String IDName) throws RecognitionException {

		AST type_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_decl_AST = null;
		String UTN, TypeID = "";
		UnderlyingType ut = null;

		try { // for error handling
			AST __t535 = _t;
			AST tmp69_AST = null;
			AST tmp69_AST_in = null;
			tmp69_AST = astFactory.create((AST) _t);
			tmp69_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp69_AST);
			ASTPair __currentAST535 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TYPE_DECL);
			_t = _t.getFirstChild();
			TypeID = type_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			ut = underlying_type_decl(_t, TypeID);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case WHERE_CLAUSE: {
					where_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST535;
			_t = __t535;
			_t = _t.getNextSibling();

			if (!(ut instanceof SelectType) && !(ut instanceof EnumerationType)) {
				DefinedType dt;
				if (pass == 1) {
					dt = new DefinedType(TypeID);
					if (schema.getTypeBN(TypeID) == null)
						schema.addType(dt);
				} else if (pass == 2) {
					schema.getTypeBN(TypeID).setDomain(ut);

				}
			}

			// methods.createOrExtendDatatypeProperty("",TypeID,UnderlyingTypeName);
			// if (UnderlyingTypeName.startsWith("SIMPLETYPE")) {
			//
			// UnderlyingTypeName=UnderlyingTypeName.substring(new
			// String("SIMPLETYPE").length());
			// methods.createDatatypePropertyListInstance("",
			// TypeID,
			// UnderlyingTypeName);
			// }
			// else if (UnderlyingTypeName.startsWith("UNDERLYING_TYPE")) {
			//
			// UnderlyingTypeName=UnderlyingTypeName.substring(new
			// String("UNDERLYING_TYPE").length());
			// {
			// methods.createDerivedType("",
			// TypeID,
			// UnderlyingTypeName);
			// }
			// }
			// else{
			// //methods.createOrExtendDatatypeProperty("",TypeID,UnderlyingTypeName);
			// }

			type_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = type_decl_AST;
		_retTree = _t;
	}

	public final void domain_rule(AST _t) throws RecognitionException {

		AST domain_rule_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST domain_rule_AST = null;

		try { // for error handling
			AST __t96 = _t;
			AST tmp70_AST = null;
			AST tmp70_AST_in = null;
			tmp70_AST = astFactory.create((AST) _t);
			tmp70_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp70_AST);
			ASTPair __currentAST96 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.DOMAIN_RULE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LABEL: {
					label(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LOGICAL_EXPRESSION: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			logical_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST96;
			_t = __t96;
			_t = _t.getNextSibling();
			domain_rule_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = domain_rule_AST;
		_retTree = _t;
	}

	public final void label(AST _t) throws RecognitionException {

		AST label_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST label_AST = null;

		try { // for error handling
			AST __t313 = _t;
			AST tmp71_AST = null;
			AST tmp71_AST_in = null;
			tmp71_AST = astFactory.create((AST) _t);
			tmp71_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp71_AST);
			ASTPair __currentAST313 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LABEL);
			_t = _t.getFirstChild();
			AST tmp72_AST = null;
			AST tmp72_AST_in = null;
			tmp72_AST = astFactory.create((AST) _t);
			tmp72_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp72_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST313;
			_t = __t313;
			_t = _t.getNextSibling();
			label_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = label_AST;
		_retTree = _t;
	}

	public final void logical_expression(AST _t) throws RecognitionException {

		AST logical_expression_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_expression_AST = null;

		try { // for error handling
			AST __t337 = _t;
			AST tmp73_AST = null;
			AST tmp73_AST_in = null;
			tmp73_AST = astFactory.create((AST) _t);
			tmp73_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp73_AST);
			ASTPair __currentAST337 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LOGICAL_EXPRESSION);
			_t = _t.getFirstChild();
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST337;
			_t = __t337;
			_t = _t.getNextSibling();
			logical_expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = logical_expression_AST;
		_retTree = _t;
	}

	public final void repetition(AST _t) throws RecognitionException {

		AST repetition_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repetition_AST = null;

		try { // for error handling
			AST __t422 = _t;
			AST tmp74_AST = null;
			AST tmp74_AST_in = null;
			tmp74_AST = astFactory.create((AST) _t);
			tmp74_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp74_AST);
			ASTPair __currentAST422 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REPETITION);
			_t = _t.getFirstChild();
			numeric_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST422;
			_t = __t422;
			_t = _t.getNextSibling();
			repetition_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = repetition_AST;
		_retTree = _t;
	}

	public final String entity_head(AST _t) throws RecognitionException {
		String className = "";

		AST entity_head_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_head_AST = null;
		// System.out.println("creating subclass for "+ cl.getName());
		// OWLNamedClass cl=null;
		String name = "";
		String[] sub = { "", "" };

		try { // for error handling
			AST __t102 = _t;
			AST tmp75_AST = null;
			AST tmp75_AST_in = null;
			tmp75_AST = astFactory.create((AST) _t);
			tmp75_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp75_AST);
			ASTPair __currentAST102 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_HEAD);
			_t = _t.getFirstChild();
			name = entity_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_abstract: {
					AST tmp76_AST = null;
					AST tmp76_AST_in = null;
					tmp76_AST = astFactory.create((AST) _t);
					tmp76_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp76_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_abstract);
					_t = _t.getNextSibling();
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case SUBSUPER: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}

			// // methods.order=0;
			// if (methods.owlModel.getOWLNamedClass(name)== null)
			// {
			// cl=methods.owlModel.createOWLNamedClass(name);
			//
			//
			// }
			// else cl=methods.owlModel.getOWLNamedClass(name);
			// className=cl.getName();
			// // System.out.println("name:"+name+", "+className);

			EntityDefinition ent = schema.getEntityBN(name);
			if (pass == 1) {
				if (ent == null) {
					ent = new EntityDefinition(name);
					schema.addEntity(ent);
				}

			}
			className = name;

			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SUBSUPER: {
					sub = subsuper(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST102;
			_t = __t102;
			_t = _t.getNextSibling();

			// System.out.println("Subtype of "+name+" sub "+sub);
			if (pass == 2 && !sub[0].equals("")) {
				EntityDefinition parent = schema.getEntityBN(sub[0]);
				ent.addSupertype(parent);
			}
			if (pass == 2 && !sub[1].equals("true")) {
				ent.setInstantiable(true);
			}

			entity_head_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = entity_head_AST;
		_retTree = _t;
		return className;
	}

	public final String entity_id(AST _t) throws RecognitionException {
		String name;

		AST entity_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_id_AST = null;
		AST id = null;
		AST id_AST = null;

		String entityName = null;
		name = "";

		try { // for error handling
			AST __t202 = _t;
			AST tmp77_AST = null;
			AST tmp77_AST_in = null;
			tmp77_AST = astFactory.create((AST) _t);
			tmp77_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp77_AST);
			ASTPair __currentAST202 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_ID);
			_t = _t.getFirstChild();
			id = (AST) _t;
			AST id_AST_in = null;
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST202;
			_t = __t202;
			_t = _t.getNextSibling();

			entityName = id.getText();
			name = entityName;

			entity_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = entity_id_AST;
		_retTree = _t;
		return name;
	}

	public final String[] subsuper(AST _t) throws RecognitionException {
		String[] sub;

		AST subsuper_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subsuper_AST = null;
		// System.out.println("working on "+cl.getName());
		// sub={"",""};
		sub = new String[] { "", "" };
		String subcls = "";
		String abst = "";

		try { // for error handling
			AST __t116 = _t;
			AST tmp78_AST = null;
			AST tmp78_AST_in = null;
			tmp78_AST = astFactory.create((AST) _t);
			tmp78_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp78_AST);
			ASTPair __currentAST116 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBSUPER);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SUPERTYPE_CONSTRAINT: {
					abst = supertype_constraint(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case SUBTYPE_DECLARATION: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SUBTYPE_DECLARATION: {
					subcls = subtype_declaration(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST116;
			_t = __t116;
			_t = _t.getNextSibling();
			sub[0] = subcls;
			sub[1] = abst;
			subsuper_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subsuper_AST;
		_retTree = _t;
		return sub;
	}

	public final String entity_body(AST _t, String forClass) throws RecognitionException {
		String atrribs = "";

		AST entity_body_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_body_AST = null;

		try { // for error handling
			AST __t108 = _t;
			AST tmp79_AST = null;
			AST tmp79_AST_in = null;
			tmp79_AST = astFactory.create((AST) _t);
			tmp79_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp79_AST);
			ASTPair __currentAST108 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_BODY);
			_t = _t.getFirstChild();
			{
				_loop110: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.EXPLICIT_ATTR.getIndex())) {
						explicit_attr(_t, forClass);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop110;
					}

				} while (true);
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case DERIVE_CLAUSE: {
					derive_clause(_t, forClass);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case INVERSE_CLAUSE:
				case UNIQUE_CLAUSE:
				case WHERE_CLAUSE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case INVERSE_CLAUSE: {
					inverse_clause(_t, forClass);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case UNIQUE_CLAUSE:
				case WHERE_CLAUSE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case UNIQUE_CLAUSE: {
					unique_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case WHERE_CLAUSE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case WHERE_CLAUSE: {
					where_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST108;
			_t = __t108;
			_t = _t.getNextSibling();
			entity_body_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = entity_body_AST;
		_retTree = _t;
		return atrribs;
	}

	public final void explicit_attr(AST _t, String forClass) throws RecognitionException {

		AST explicit_attr_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST explicit_attr_AST = null;

		String PropName, TypeName = "";
		boolean isOptional = false;
		String ConcreteType = "";
		String[] BoundedType = new String[4];

		try { // for error handling
			if (_t == null)
				_t = ASTNULL;
			if ((_t.getType() == Express2DictWalkerTokenTypes.EXPLICIT_ATTR.getIndex())) {
				AST __t145 = _t;
				AST tmp80_AST = null;
				AST tmp80_AST_in = null;
				tmp80_AST = astFactory.create((AST) _t);
				tmp80_AST_in = (AST) _t;
				astFactory.addASTChild(currentAST, tmp80_AST);
				ASTPair __currentAST145 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				match(_t, Express2DictWalkerTokenTypes.EXPLICIT_ATTR);
				_t = _t.getFirstChild();
				PropName = attribute_decl(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop147: do {
						if (_t == null)
							_t = ASTNULL;
						if ((_t.getType() == Express2DictWalkerTokenTypes.ATTRIBUTE_DECL.getIndex())) {
							attribute_decl(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop147;
						}

					} while (true);
				}
				{
					if (_t == null)
						_t = ASTNULL;
					switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
					case LITERAL_optional: {
						AST tmp81_AST = null;
						AST tmp81_AST_in = null;
						tmp81_AST = astFactory.create((AST) _t);
						tmp81_AST_in = (AST) _t;
						astFactory.addASTChild(currentAST, tmp81_AST);
						match(_t, Express2DictWalkerTokenTypes.LITERAL_optional);
						_t = _t.getNextSibling();
						isOptional = true;
						break;
					}
					case BASE_TYPE: {
						break;
					}
					default: {
						throw new NoViableAltException(_t);
					}
					}
				}
				AST __t149 = _t;
				AST tmp82_AST = null;
				AST tmp82_AST_in = null;
				tmp82_AST = astFactory.create((AST) _t);
				tmp82_AST_in = (AST) _t;
				astFactory.addASTChild(currentAST, tmp82_AST);
				ASTPair __currentAST149 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				match(_t, Express2DictWalkerTokenTypes.BASE_TYPE);
				_t = _t.getFirstChild();
				{
					if (_t == null)
						_t = ASTNULL;
					switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
					case CONCRETE_TYPES: {
						AST __t151 = _t;
						AST tmp83_AST = null;
						AST tmp83_AST_in = null;
						tmp83_AST = astFactory.create((AST) _t);
						tmp83_AST_in = (AST) _t;
						astFactory.addASTChild(currentAST, tmp83_AST);
						ASTPair __currentAST151 = currentAST.copy();
						currentAST.root = currentAST.child;
						currentAST.child = null;
						match(_t, Express2DictWalkerTokenTypes.CONCRETE_TYPES);
						_t = _t.getFirstChild();
						{
							if (_t == null)
								_t = ASTNULL;
							switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
							case SIMPLE_TYPES: {
								ConcreteType = simple_types(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							case NAMED_TYPES: {
								ConcreteType = named_types(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							case AGGREGATION_TYPES: {
								BoundedType = aggregation_types(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							default: {
								throw new NoViableAltException(_t);
							}
							}
						}
						currentAST = __currentAST151;
						_t = __t151;
						_t = _t.getNextSibling();
						break;
					}
					case GENERALIZED_TYPES: {
						{
							TypeName = generalized_types(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
						}
						break;
					}
					default: {
						throw new NoViableAltException(_t);
					}
					}
				}
				currentAST = __currentAST149;
				_t = __t149;
				_t = _t.getNextSibling();
				currentAST = __currentAST145;
				_t = __t145;
				_t = _t.getNextSibling();

				if (pass == 2) {
					EntityDefinition ent = schema.getEntityBN(forClass);
					if ((BoundedType[0] != null) && (ent != null)) {
						/* ConcreteType=BoundedType[0]; */
						AggregationType aggr = null;
						BaseType bt = schema.getBaseTypeBN(BoundedType[0]);
						if (bt == null)
							System.err.println("WARNING: could not find " + BoundedType[0] + "(for +" + forClass + ")");
						if (BoundedType[3].equals("LIST"))
							aggr = new ListType(schema.getBaseTypeBN(BoundedType[0]));
						else if (BoundedType[3].equals("BAG"))
							aggr = new BagType(schema.getBaseTypeBN(BoundedType[0]));
						else if (BoundedType[3].equals("ARRAY"))
							aggr = new ArrayType(schema.getBaseTypeBN(BoundedType[0]));
						else if (BoundedType[3].equals("SET"))
							aggr = new SetType(schema.getBaseTypeBN(BoundedType[0]));

						String lbs = BoundedType[1];
						String ubs = BoundedType[2];
						if (lbs == "" || lbs == "?")
							lbs = "-1";
						if (ubs == "" || ubs == "?")
							ubs = "-1";

						IntegerBound lb = new IntegerBound(new Integer(lbs));
						IntegerBound ub = new IntegerBound(new Integer(ubs));
						if (aggr instanceof VariableSizeAggregationType) {

							((VariableSizeAggregationType) aggr).setUpper_bound(ub);
							((VariableSizeAggregationType) aggr).setLower_bound(ub);
						} else if (aggr instanceof ArrayType) {
							((ArrayType) aggr).setLower_index(lb);
							((ArrayType) aggr).setUpper_index(ub);
						}
						ExplicitAttribute attr = new ExplicitAttribute(PropName, ent);
						attr.setOptional(isOptional);
						attr.setDomain(aggr);
						ent.addAttribute(attr);
						// System.out.println(forClass +" has Prop " +PropName +
						// " of " + aggr.getClass() +
						// "["+lb.getBound_value()+":"+ub.getBound_value()+"]"+" of Type "+aggr.getElement_type());

					}
					// System.out.println(forClass +" has Prop " +PropName +
					// " of Type "+ConcreteType);

					else if ((ent != null)) {
						ExplicitAttribute attr = new ExplicitAttribute(PropName, ent);
						attr.setDomain(schema.getBaseTypeBN(ConcreteType));
						attr.setOptional(isOptional);
						ent.addAttribute(attr);
						// System.out.println(forClass +" has Prop " +PropName +
						// " of Type "+ConcreteType);
					}
				}
				String optString = "";
				// if (test!="")System.out.println("entity_ref fires:"+test);
				if (isOptional)
					optString = " OPTIONAL";

				// System.out.println(forClass +" has"+optString+" Prop "
				// +PropName + " of Type "+ConcreteType);
				if (ConcreteType.indexOf("SIMPLETYPE") == 0) {
					if (pass == 2) {
						EntityDefinition ent = schema.getEntityBN(forClass);
						if ((ent != null)) {
							ExplicitAttribute attr = new ExplicitAttribute(PropName, ent);
							attr.setDomain(schema.getBaseTypeBN(ConcreteType));
							attr.setOptional(isOptional);
							ent.addAttribute(attr);
							// System.out.println(forClass +" has Prop "
							// +PropName + " of Type "+ConcreteType);
						}
					}

					// methods.createSimpleTypeInstance(forClass, PropName,
					// ConcreteType.substring(new
					// String("SIMPLETYPE").length()));

				} else if (ConcreteType.startsWith("TYPE")) {
					// methods.createDerivedListProperty(forClass, PropName,
					// ConcreteType.substring(new String("TYPE").length()));
				} else if (ConcreteType.indexOf("UNDERLYING_TYPE") > -1) {

					// for a working version
					// methods.createDatatypePropFromNamedType(forClass,
					// PropName,
					// ConcreteType.substring(new
					// String("UNDERLYING_TYPE").length()));

				}

				else if (ConcreteType.indexOf("ENTITY_REF") > -1) {
					String type = ConcreteType.substring(new String("ENTITY_REF").length());
					// methods.createOrExtendObjectProperty(forClass,
					// PropName,type );
				}

				if (BoundedType[0] != null) {
					// methods.addCardinalityConstraint(forClass,PropName,BoundedType[1],BoundedType[2]);

				}

				explicit_attr_AST = (AST) currentAST.root;
			} else if ((_t.getType() == Express2DictWalkerTokenTypes.EXPLICIT_ATTR.getIndex())) {
				AST __t154 = _t;
				AST tmp84_AST = null;
				AST tmp84_AST_in = null;
				tmp84_AST = astFactory.create((AST) _t);
				tmp84_AST_in = (AST) _t;
				astFactory.addASTChild(currentAST, tmp84_AST);
				ASTPair __currentAST154 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				match(_t, Express2DictWalkerTokenTypes.EXPLICIT_ATTR);
				_t = _t.getFirstChild();
				PropName = attribute_decl(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
					_loop156: do {
						if (_t == null)
							_t = ASTNULL;
						if ((_t.getType() == Express2DictWalkerTokenTypes.ATTRIBUTE_DECL.getIndex())) {
							attribute_decl(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
						} else {
							break _loop156;
						}

					} while (true);
				}
				{
					if (_t == null)
						_t = ASTNULL;
					switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
					case LITERAL_optional: {
						AST tmp85_AST = null;
						AST tmp85_AST_in = null;
						tmp85_AST = astFactory.create((AST) _t);
						tmp85_AST_in = (AST) _t;
						astFactory.addASTChild(currentAST, tmp85_AST);
						match(_t, Express2DictWalkerTokenTypes.LITERAL_optional);
						_t = _t.getNextSibling();
						isOptional = true;
						break;
					}
					case SIMPLE_TYPES: {
						break;
					}
					default: {
						throw new NoViableAltException(_t);
					}
					}
				}
				TypeName = simple_types(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST154;
				_t = __t154;
				_t = _t.getNextSibling();

				// System.out.println("SimpleType");

				explicit_attr_AST = (AST) currentAST.root;
			} else {
				throw new NoViableAltException(_t);
			}

		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = explicit_attr_AST;
		_retTree = _t;
	}

	public final void derive_clause(AST _t, String forClass) throws RecognitionException {

		AST derive_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST derive_clause_AST = null;

		try { // for error handling
			AST __t169 = _t;
			AST tmp86_AST = null;
			AST tmp86_AST_in = null;
			tmp86_AST = astFactory.create((AST) _t);
			tmp86_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp86_AST);
			ASTPair __currentAST169 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.DERIVE_CLAUSE);
			_t = _t.getFirstChild();
			derived_attr(_t, forClass);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop171: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.DERIVED_ATTR.getIndex())) {
						derived_attr(_t, forClass);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop171;
					}

				} while (true);
			}
			currentAST = __currentAST169;
			_t = __t169;
			_t = _t.getNextSibling();
			derive_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = derive_clause_AST;
		_retTree = _t;
	}

	public final void inverse_clause(AST _t, String forClass) throws RecognitionException {

		AST inverse_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inverse_clause_AST = null;

		try { // for error handling
			AST __t176 = _t;
			AST tmp87_AST = null;
			AST tmp87_AST_in = null;
			tmp87_AST = astFactory.create((AST) _t);
			tmp87_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp87_AST);
			ASTPair __currentAST176 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INVERSE_CLAUSE);
			_t = _t.getFirstChild();
			inverse_attr(_t, forClass);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop178: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.INVERSE_ATTR.getIndex())) {
						inverse_attr(_t, forClass);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop178;
					}

				} while (true);
			}
			currentAST = __currentAST176;
			_t = __t176;
			_t = _t.getNextSibling();
			inverse_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = inverse_clause_AST;
		_retTree = _t;
	}

	public final void unique_clause(AST _t) throws RecognitionException {

		AST unique_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unique_clause_AST = null;

		try { // for error handling
			AST __t185 = _t;
			AST tmp88_AST = null;
			AST tmp88_AST_in = null;
			tmp88_AST = astFactory.create((AST) _t);
			tmp88_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp88_AST);
			ASTPair __currentAST185 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.UNIQUE_CLAUSE);
			_t = _t.getFirstChild();
			unique_rule(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop187: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.UNIQUE_RULE.getIndex())) {
						unique_rule(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop187;
					}

				} while (true);
			}
			currentAST = __currentAST185;
			_t = __t185;
			_t = _t.getNextSibling();
			unique_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = unique_clause_AST;
		_retTree = _t;
	}

	public final void where_clause(AST _t) throws RecognitionException {

		AST where_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST where_clause_AST = null;

		try { // for error handling
			AST __t587 = _t;
			AST tmp89_AST = null;
			AST tmp89_AST_in = null;
			tmp89_AST = astFactory.create((AST) _t);
			tmp89_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp89_AST);
			ASTPair __currentAST587 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.WHERE_CLAUSE);
			_t = _t.getFirstChild();
			domain_rule(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop589: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.DOMAIN_RULE.getIndex())) {
						domain_rule(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop589;
					}

				} while (true);
			}
			currentAST = __currentAST587;
			_t = __t587;
			_t = _t.getNextSibling();
			where_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = where_clause_AST;
		_retTree = _t;
	}

	public final String supertype_constraint(AST _t) throws RecognitionException {
		String isAbstract = "";

		AST supertype_constraint_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_constraint_AST = null;

		try { // for error handling
			AST __t120 = _t;
			AST tmp90_AST = null;
			AST tmp90_AST_in = null;
			tmp90_AST = astFactory.create((AST) _t);
			tmp90_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp90_AST);
			ASTPair __currentAST120 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUPERTYPE_CONSTRAINT);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ABSTRACT_SUPERTYPE_DECLARATION: {
					isAbstract = abstract_supertype_declaration(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SUPERTYPE_RULE: {
					supertype_rule(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST120;
			_t = __t120;
			_t = _t.getNextSibling();
			supertype_constraint_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = supertype_constraint_AST;
		_retTree = _t;
		return isAbstract;
	}

	public final String subtype_declaration(AST _t) throws RecognitionException {
		String subent = "";

		AST subtype_declaration_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_declaration_AST = null;

		// String subent = "t";
		String sub = "";

		try { // for error handling
			AST __t126 = _t;
			AST tmp91_AST = null;
			AST tmp91_AST_in = null;
			tmp91_AST = astFactory.create((AST) _t);
			tmp91_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp91_AST);
			ASTPair __currentAST126 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBTYPE_DECLARATION);
			_t = _t.getFirstChild();
			subent = get_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST126;
			_t = __t126;
			_t = _t.getNextSibling();

			// System.out.println("subtype_declaration: "+subent);

			// // if (cl.getName().indexOf("IfcApprovalActorRelationship")>-1)
			// // System.out.println("debug");
			// if(methods.owlModel.getOWLNamedClass(subent) == null)
			// {
			// // System.out.println(": creating root class "+subent);
			// methods.owlModel.createOWLNamedClass(subent);
			//
			// }
			// //
			// System.out.println(": adding EXISTING superclass ..."+subent);}
			// cl.addSuperclass(methods.owlModel.getOWLNamedClass(subent));
			// cl.removeSuperclass(methods.owlModel.getOWLThingClass());
			// //}
			// //System.out.println(subent);
			// sub = subent;
			// System.out.println("subtype for "+ cl.getName() +" is "+ subent
			// );

			subtype_declaration_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subtype_declaration_AST;
		_retTree = _t;
		return subent;
	}

	public final String abstract_supertype_declaration(AST _t) throws RecognitionException {
		String isAbstract = "true";

		AST abstract_supertype_declaration_AST_in = (_t == ASTNULL) ? null : (AST) _t;
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abstract_supertype_declaration_AST = null;

		try { // for error handling
			AST __t123 = _t;
			AST tmp92_AST = null;
			AST tmp92_AST_in = null;
			tmp92_AST = astFactory.create((AST) _t);
			tmp92_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp92_AST);
			ASTPair __currentAST123 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ABSTRACT_SUPERTYPE_DECLARATION);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SUBTYPE_CONSTRAINT: {
					subtype_constraint(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST123;
			_t = __t123;
			_t = _t.getNextSibling();
			abstract_supertype_declaration_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = abstract_supertype_declaration_AST;
		_retTree = _t;
		return isAbstract;
	}

	public final void supertype_rule(AST _t) throws RecognitionException {

		AST supertype_rule_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_rule_AST = null;

		try { // for error handling
			AST __t511 = _t;
			AST tmp93_AST = null;
			AST tmp93_AST_in = null;
			tmp93_AST = astFactory.create((AST) _t);
			tmp93_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp93_AST);
			ASTPair __currentAST511 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUPERTYPE_RULE);
			_t = _t.getFirstChild();
			subtype_constraint(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST511;
			_t = __t511;
			_t = _t.getNextSibling();
			supertype_rule_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = supertype_rule_AST;
		_retTree = _t;
	}

	public final void subtype_constraint(AST _t) throws RecognitionException {

		AST subtype_constraint_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_AST = null;

		try { // for error handling
			AST __t501 = _t;
			AST tmp94_AST = null;
			AST tmp94_AST_in = null;
			tmp94_AST = astFactory.create((AST) _t);
			tmp94_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp94_AST);
			ASTPair __currentAST501 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBTYPE_CONSTRAINT);
			_t = _t.getFirstChild();
			supertype_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST501;
			_t = __t501;
			_t = _t.getNextSibling();
			subtype_constraint_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subtype_constraint_AST;
		_retTree = _t;
	}

	public final String get_ref(AST _t) throws RecognitionException {
		String subent = "test";

		AST get_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST get_ref_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t600 = _t;
			AST tmp95_AST = null;
			AST tmp95_AST_in = null;
			tmp95_AST = astFactory.create((AST) _t);
			tmp95_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp95_AST);
			ASTPair __currentAST600 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_REF);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST600;
			_t = __t600;
			_t = _t.getNextSibling();
			subent = i.getText();
			get_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = get_ref_AST;
		_retTree = _t;
		return subent;
	}

	public final void subtype_constraint_head(AST _t) throws RecognitionException {

		AST subtype_constraint_head_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_head_AST = null;

		try { // for error handling
			AST __t130 = _t;
			AST tmp96_AST = null;
			AST tmp96_AST_in = null;
			tmp96_AST = astFactory.create((AST) _t);
			tmp96_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp96_AST);
			ASTPair __currentAST130 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBTYPE_CONSTRAINT_HEAD);
			_t = _t.getFirstChild();
			subtype_constraint_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST130;
			_t = __t130;
			_t = _t.getNextSibling();
			subtype_constraint_head_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subtype_constraint_head_AST;
		_retTree = _t;
	}

	public final void subtype_constraint_body(AST _t) throws RecognitionException {

		AST subtype_constraint_body_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_body_AST = null;

		try { // for error handling
			AST __t132 = _t;
			AST tmp97_AST = null;
			AST tmp97_AST_in = null;
			tmp97_AST = astFactory.create((AST) _t);
			tmp97_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp97_AST);
			ASTPair __currentAST132 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBTYPE_CONSTRAINT_BODY);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ABSTRACT_SUPERTYPE: {
					abstract_supertype(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case SUPERTYPE_EXPRESSION:
				case TOTAL_OVER: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case TOTAL_OVER: {
					total_over(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case SUPERTYPE_EXPRESSION: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SUPERTYPE_EXPRESSION: {
					supertype_expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST132;
			_t = __t132;
			_t = _t.getNextSibling();
			subtype_constraint_body_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subtype_constraint_body_AST;
		_retTree = _t;
	}

	public final void subtype_constraint_id(AST _t) throws RecognitionException {

		AST subtype_constraint_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_constraint_id_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t137 = _t;
			AST tmp98_AST = null;
			AST tmp98_AST_in = null;
			tmp98_AST = astFactory.create((AST) _t);
			tmp98_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp98_AST);
			ASTPair __currentAST137 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUBTYPE_CONSTRAINT_ID);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST137;
			_t = __t137;
			_t = _t.getNextSibling();
			// System.out.println(i.getText());

			subtype_constraint_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = subtype_constraint_id_AST;
		_retTree = _t;
	}

	public final String entity_ref(AST _t) throws RecognitionException {
		String TypeName = "";

		AST entity_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_ref_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t598 = _t;
			AST tmp99_AST = null;
			AST tmp99_AST_in = null;
			tmp99_AST = astFactory.create((AST) _t);
			tmp99_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp99_AST);
			ASTPair __currentAST598 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_REF);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST598;
			_t = __t598;
			_t = _t.getNextSibling();

			TypeName = i.getText();

			entity_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = entity_ref_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void abstract_supertype(AST _t) throws RecognitionException {

		AST abstract_supertype_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abstract_supertype_AST = null;

		try { // for error handling
			AST __t139 = _t;
			AST tmp100_AST = null;
			AST tmp100_AST_in = null;
			tmp100_AST = astFactory.create((AST) _t);
			tmp100_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp100_AST);
			ASTPair __currentAST139 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ABSTRACT_SUPERTYPE);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST139;
			_t = __t139;
			_t = _t.getNextSibling();
			abstract_supertype_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = abstract_supertype_AST;
		_retTree = _t;
	}

	public final void total_over(AST _t) throws RecognitionException {

		AST total_over_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST total_over_AST = null;

		try { // for error handling
			AST __t141 = _t;
			AST tmp101_AST = null;
			AST tmp101_AST_in = null;
			tmp101_AST = astFactory.create((AST) _t);
			tmp101_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp101_AST);
			ASTPair __currentAST141 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TOTAL_OVER);
			_t = _t.getFirstChild();
			entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop143: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.ENTITY_REF.getIndex())) {
						entity_ref(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop143;
					}

				} while (true);
			}
			currentAST = __currentAST141;
			_t = __t141;
			_t = _t.getNextSibling();
			total_over_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = total_over_AST;
		_retTree = _t;
	}

	public final void supertype_expression(AST _t) throws RecognitionException {

		AST supertype_expression_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_expression_AST = null;

		try { // for error handling
			AST __t503 = _t;
			AST tmp102_AST = null;
			AST tmp102_AST_in = null;
			tmp102_AST = astFactory.create((AST) _t);
			tmp102_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp102_AST);
			ASTPair __currentAST503 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUPERTYPE_EXPRESSION);
			_t = _t.getFirstChild();
			supertype_factor(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop505: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.SUPERTYPE_FACTOR.getIndex())) {
						supertype_factor(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop505;
					}

				} while (true);
			}
			currentAST = __currentAST503;
			_t = __t503;
			_t = _t.getNextSibling();
			supertype_expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = supertype_expression_AST;
		_retTree = _t;
	}

	public final String attribute_decl(AST _t) throws RecognitionException {
		String PropName = "";

		AST attribute_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_decl_AST = null;

		try { // for error handling
			AST __t159 = _t;
			AST tmp103_AST = null;
			AST tmp103_AST_in = null;
			tmp103_AST = astFactory.create((AST) _t);
			tmp103_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp103_AST);
			ASTPair __currentAST159 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ATTRIBUTE_DECL);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ATTRIBUTE_ID: {
					PropName = attribute_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case REDECLARED_ATTRIBUTE: {
					redeclared_attribute(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST159;
			_t = __t159;
			_t = _t.getNextSibling();

			attribute_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = attribute_decl_AST;
		_retTree = _t;
		return PropName;
	}

	public final String attribute_id(AST _t) throws RecognitionException {
		String PropName = "";

		AST attribute_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_id_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t165 = _t;
			AST tmp104_AST = null;
			AST tmp104_AST_in = null;
			tmp104_AST = astFactory.create((AST) _t);
			tmp104_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp104_AST);
			ASTPair __currentAST165 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ATTRIBUTE_ID);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST165;
			_t = __t165;
			_t = _t.getNextSibling();
			PropName = i.getText();
			attribute_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = attribute_id_AST;
		_retTree = _t;
		return PropName;
	}

	public final String redeclared_attribute(AST _t) throws RecognitionException {
		String PropName = "";

		AST redeclared_attribute_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST redeclared_attribute_AST = null;

		try { // for error handling
			AST __t162 = _t;
			AST tmp105_AST = null;
			AST tmp105_AST_in = null;
			tmp105_AST = astFactory.create((AST) _t);
			tmp105_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp105_AST);
			ASTPair __currentAST162 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REDECLARED_ATTRIBUTE);
			_t = _t.getFirstChild();
			qualified_attribute(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ATTRIBUTE_ID: {
					PropName = attribute_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST162;
			_t = __t162;
			_t = _t.getNextSibling();
			redeclared_attribute_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = redeclared_attribute_AST;
		_retTree = _t;
		return PropName;
	}

	public final void qualified_attribute(AST _t) throws RecognitionException {

		AST qualified_attribute_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualified_attribute_AST = null;

		try { // for error handling
			AST __t167 = _t;
			AST tmp106_AST = null;
			AST tmp106_AST_in = null;
			tmp106_AST = astFactory.create((AST) _t);
			tmp106_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp106_AST);
			ASTPair __currentAST167 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.QUALIFIED_ATTRIBUTE);
			_t = _t.getFirstChild();
			group_qualifier(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			attribute_qualifier(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST167;
			_t = __t167;
			_t = _t.getNextSibling();
			qualified_attribute_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = qualified_attribute_AST;
		_retTree = _t;
	}

	public final void group_qualifier(AST _t) throws RecognitionException {

		AST group_qualifier_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST group_qualifier_AST = null;

		try { // for error handling
			AST __t275 = _t;
			AST tmp107_AST = null;
			AST tmp107_AST_in = null;
			tmp107_AST = astFactory.create((AST) _t);
			tmp107_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp107_AST);
			ASTPair __currentAST275 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GROUP_QUALIFIER);
			_t = _t.getFirstChild();
			entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST275;
			_t = __t275;
			_t = _t.getNextSibling();
			group_qualifier_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = group_qualifier_AST;
		_retTree = _t;
	}

	public final void attribute_qualifier(AST _t) throws RecognitionException {

		AST attribute_qualifier_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_qualifier_AST = null;

		try { // for error handling
			AST __t225 = _t;
			AST tmp108_AST = null;
			AST tmp108_AST_in = null;
			tmp108_AST = astFactory.create((AST) _t);
			tmp108_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp108_AST);
			ASTPair __currentAST225 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ATTRIBUTE_QUALIFIER);
			_t = _t.getFirstChild();
			attribute_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST225;
			_t = __t225;
			_t = _t.getNextSibling();
			attribute_qualifier_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = attribute_qualifier_AST;
		_retTree = _t;
	}

	public final void derived_attr(AST _t, String forClass) throws RecognitionException {

		AST derived_attr_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST derived_attr_AST = null;

		String attrib = "";

		try { // for error handling
			AST __t173 = _t;
			AST tmp109_AST = null;
			AST tmp109_AST_in = null;
			tmp109_AST = astFactory.create((AST) _t);
			tmp109_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp109_AST);
			ASTPair __currentAST173 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.DERIVED_ATTR);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SELF: {
					AST tmp110_AST = null;
					AST tmp110_AST_in = null;
					tmp110_AST = astFactory.create((AST) _t);
					tmp110_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp110_AST);
					match(_t, Express2DictWalkerTokenTypes.SELF);
					_t = _t.getNextSibling();
					AST tmp111_AST = null;
					AST tmp111_AST_in = null;
					tmp111_AST = astFactory.create((AST) _t);
					tmp111_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp111_AST);
					match(_t, Express2DictWalkerTokenTypes.IDENT);
					_t = _t.getNextSibling();
					AST tmp112_AST = null;
					AST tmp112_AST_in = null;
					tmp112_AST = astFactory.create((AST) _t);
					tmp112_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp112_AST);
					match(_t, 376);
					_t = _t.getNextSibling();
					break;
				}
				case ATTRIBUTE_DECL: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			attrib = attribute_decl(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			base_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST173;
			_t = __t173;
			_t = _t.getNextSibling();

			if (pass == 4) {
				EntityDefinition ent = schema.getEntityBN(forClass);
				// ent.addDerived(attrib);
				// Attribute att = ent.getAttributeBNWithSuper(attrib);
				// LOGGER.info(forClass + "." + attrib);
				// if (att == null) {
				// LOGGER.info("null");
				// } else {
				// LOGGER.info(att.toString());
				// }
				// att.setDerived(true);
			}

			derived_attr_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = derived_attr_AST;
		_retTree = _t;
	}

	public final void inverse_attr(AST _t, String forClass) throws RecognitionException {

		AST inverse_attr_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inverse_attr_AST = null;

		String attrib, entity, attrib_ref = "";
		String[] bounds = new String[2];

		try { // for error handling
			AST __t180 = _t;
			AST tmp113_AST = null;
			AST tmp113_AST_in = null;
			tmp113_AST = astFactory.create((AST) _t);
			tmp113_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp113_AST);
			ASTPair __currentAST180 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INVERSE_ATTR);
			_t = _t.getFirstChild();
			attrib = attribute_decl(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_bag:
				case LITERAL_set: {
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case LITERAL_set: {
							AST tmp114_AST = null;
							AST tmp114_AST_in = null;
							tmp114_AST = astFactory.create((AST) _t);
							tmp114_AST_in = (AST) _t;
							astFactory.addASTChild(currentAST, tmp114_AST);
							match(_t, Express2DictWalkerTokenTypes.LITERAL_set);
							_t = _t.getNextSibling();
							break;
						}
						case LITERAL_bag: {
							AST tmp115_AST = null;
							AST tmp115_AST_in = null;
							tmp115_AST = astFactory.create((AST) _t);
							tmp115_AST_in = (AST) _t;
							astFactory.addASTChild(currentAST, tmp115_AST);
							match(_t, Express2DictWalkerTokenTypes.LITERAL_bag);
							_t = _t.getNextSibling();
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case BOUND_SPEC: {
							bounds = bound_spec(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case ENTITY_REF: {
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					break;
				}
				case ENTITY_REF: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			entity = entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			attrib_ref = attribute_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST180;
			_t = __t180;
			_t = _t.getNextSibling();

			// wait filling out the inverse attributes until the 3rd pass, when
			// all other
			// attributes have been filled in

			if (pass == 3) {
				EntityDefinition ent = schema.getEntityBN(entity);
				EntityDefinition forEnt = schema.getEntityBN(forClass);
				if (ent != null) {
					ExplicitAttribute attr = (ExplicitAttribute) ent.getAttributeBN(attrib_ref);
					if (attr != null) {
						// System.out.println("INVERSE "+attrib+" of " +
						// ent.getName()+" for " +attrib_ref);
						InverseAttribute inv = new InverseAttribute(attrib, ent);
						if (bounds[0] != null && bounds[1] != null) {
							if ((bounds[0].equals("")) || (bounds[0].equals("?")))
								bounds[0] = "-1";
							if ((bounds[1].equals("")) || (bounds[1].equals("?")))
								bounds[1] = "-1";
							Bound lb = new IntegerBound(new Integer(bounds[0]));
							Bound ub = new IntegerBound(new Integer(bounds[1]));
							inv.setMin_cardinality(lb);
							inv.setMax_cardinality(ub);
						}
						inv.setDomain(ent);
						inv.setInverted_attr(attr);
						forEnt.addAttribute(inv);

					}
				}

			}

			// methods.createInverseObjectProperty
			// (forClass,attrib,attrib_ref,entity);
			// if (bounds[0]!=null)
			// {
			// methods.addCardinalityConstraint(forClass,attrib,bounds[0],bounds[1]);
			// }
			//
			// System.out.println("Inverse " + attrib + " for " + entity);

			inverse_attr_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = inverse_attr_AST;
		_retTree = _t;
	}

	public final String attribute_ref(AST _t) throws RecognitionException {
		String attrib_ref = "";

		AST attribute_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_ref_AST = null;
		AST id = null;
		AST id_AST = null;

		try { // for error handling
			AST __t606 = _t;
			AST tmp116_AST = null;
			AST tmp116_AST_in = null;
			tmp116_AST = astFactory.create((AST) _t);
			tmp116_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp116_AST);
			ASTPair __currentAST606 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ATTRIBUTE_REF);
			_t = _t.getFirstChild();
			id = (AST) _t;
			AST id_AST_in = null;
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			attrib_ref = id.getText();
			currentAST = __currentAST606;
			_t = __t606;
			_t = _t.getNextSibling();
			attribute_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = attribute_ref_AST;
		_retTree = _t;
		return attrib_ref;
	}

	public final void unique_rule(AST _t) throws RecognitionException {

		AST unique_rule_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unique_rule_AST = null;

		try { // for error handling
			AST __t189 = _t;
			AST tmp117_AST = null;
			AST tmp117_AST_in = null;
			tmp117_AST = astFactory.create((AST) _t);
			tmp117_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp117_AST);
			ASTPair __currentAST189 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.UNIQUE_RULE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LABEL: {
					label(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case REFERENCED_ATTRIBUTE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			referenced_attribute(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop192: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.REFERENCED_ATTRIBUTE.getIndex())) {
						referenced_attribute(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop192;
					}

				} while (true);
			}
			currentAST = __currentAST189;
			_t = __t189;
			_t = _t.getNextSibling();
			unique_rule_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = unique_rule_AST;
		_retTree = _t;
	}

	public final void referenced_attribute(AST _t) throws RecognitionException {

		AST referenced_attribute_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST referenced_attribute_AST = null;

		try { // for error handling
			AST __t194 = _t;
			AST tmp118_AST = null;
			AST tmp118_AST_in = null;
			tmp118_AST = astFactory.create((AST) _t);
			tmp118_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp118_AST);
			ASTPair __currentAST194 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REFERENCED_ATTRIBUTE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ATTRIBUTE_REF: {
					attribute_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case QUALIFIED_ATTRIBUTE: {
					qualified_attribute(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST194;
			_t = __t194;
			_t = _t.getNextSibling();
			referenced_attribute_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = referenced_attribute_AST;
		_retTree = _t;
	}

	public final void entity_constructor(AST _t) throws RecognitionException {

		AST entity_constructor_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entity_constructor_AST = null;

		try { // for error handling
			AST __t197 = _t;
			AST tmp119_AST = null;
			AST tmp119_AST_in = null;
			tmp119_AST = astFactory.create((AST) _t);
			tmp119_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp119_AST);
			ASTPair __currentAST197 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENTITY_CONSTRUCTOR);
			_t = _t.getFirstChild();
			entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case EXPRESSION: {
					expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop200: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.EXPRESSION.getIndex())) {
								expression(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop200;
							}

						} while (true);
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST197;
			_t = __t197;
			_t = _t.getNextSibling();
			entity_constructor_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = entity_constructor_AST;
		_retTree = _t;
	}

	public final void enumeration_reference(AST _t) throws RecognitionException {

		AST enumeration_reference_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_reference_AST = null;

		try { // for error handling
			AST __t204 = _t;
			AST tmp120_AST = null;
			AST tmp120_AST_in = null;
			tmp120_AST = astFactory.create((AST) _t);
			tmp120_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp120_AST);
			ASTPair __currentAST204 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENUMERATION_REFERENCE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case TYPE_REF: {
					type_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ENUMERATION_REF: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			enumeration_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST204;
			_t = __t204;
			_t = _t.getNextSibling();
			enumeration_reference_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = enumeration_reference_AST;
		_retTree = _t;
	}

	public final String type_ref(AST _t) throws RecognitionException {
		String TypeName = "";

		AST type_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_ref_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t602 = _t;
			AST tmp121_AST = null;
			AST tmp121_AST_in = null;
			tmp121_AST = astFactory.create((AST) _t);
			tmp121_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp121_AST);
			ASTPair __currentAST602 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TYPE_REF);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST602;
			_t = __t602;
			_t = _t.getNextSibling();

			TypeName = i.getText();

			type_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = type_ref_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void enumeration_ref(AST _t) throws RecognitionException {

		AST enumeration_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_ref_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t604 = _t;
			AST tmp122_AST = null;
			AST tmp122_AST_in = null;
			tmp122_AST = astFactory.create((AST) _t);
			tmp122_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp122_AST);
			ASTPair __currentAST604 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENUMERATION_REF);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST604;
			_t = __t604;
			_t = _t.getNextSibling();
			enumeration_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = enumeration_ref_AST;
		_retTree = _t;
	}

	public final void escape_stmt(AST _t) throws RecognitionException {

		AST escape_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST escape_stmt_AST = null;

		try { // for error handling
			AST __t207 = _t;
			AST tmp123_AST = null;
			AST tmp123_AST_in = null;
			tmp123_AST = astFactory.create((AST) _t);
			tmp123_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp123_AST);
			ASTPair __currentAST207 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ESCAPE_STMT);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST207;
			_t = __t207;
			_t = _t.getNextSibling();
			escape_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = escape_stmt_AST;
		_retTree = _t;
	}

	public final void rel_op_extended(AST _t) throws RecognitionException {

		AST rel_op_extended_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_op_extended_AST = null;

		try { // for error handling
			AST __t212 = _t;
			AST tmp124_AST = null;
			AST tmp124_AST_in = null;
			tmp124_AST = astFactory.create((AST) _t);
			tmp124_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp124_AST);
			ASTPair __currentAST212 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REL_OP_EXTENDED);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case REL_OP: {
					rel_op(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_in: {
					AST tmp125_AST = null;
					AST tmp125_AST_in = null;
					tmp125_AST = astFactory.create((AST) _t);
					tmp125_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp125_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_in);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_like: {
					AST tmp126_AST = null;
					AST tmp126_AST_in = null;
					tmp126_AST = astFactory.create((AST) _t);
					tmp126_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp126_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_like);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST212;
			_t = __t212;
			_t = _t.getNextSibling();
			rel_op_extended_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = rel_op_extended_AST;
		_retTree = _t;
	}

	public final void rel_op(AST _t) throws RecognitionException {

		AST rel_op_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rel_op_AST = null;

		try { // for error handling
			AST __t215 = _t;
			AST tmp127_AST = null;
			AST tmp127_AST_in = null;
			tmp127_AST = astFactory.create((AST) _t);
			tmp127_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp127_AST);
			ASTPair __currentAST215 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REL_OP);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LT: {
					AST tmp128_AST = null;
					AST tmp128_AST_in = null;
					tmp128_AST = astFactory.create((AST) _t);
					tmp128_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp128_AST);
					match(_t, Express2DictWalkerTokenTypes.LT);
					_t = _t.getNextSibling();
					break;
				}
				case GT: {
					AST tmp129_AST = null;
					AST tmp129_AST_in = null;
					tmp129_AST = astFactory.create((AST) _t);
					tmp129_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp129_AST);
					match(_t, Express2DictWalkerTokenTypes.GT);
					_t = _t.getNextSibling();
					break;
				}
				case LE: {
					AST tmp130_AST = null;
					AST tmp130_AST_in = null;
					tmp130_AST = astFactory.create((AST) _t);
					tmp130_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp130_AST);
					match(_t, Express2DictWalkerTokenTypes.LE);
					_t = _t.getNextSibling();
					break;
				}
				case GE: {
					AST tmp131_AST = null;
					AST tmp131_AST_in = null;
					tmp131_AST = astFactory.create((AST) _t);
					tmp131_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp131_AST);
					match(_t, Express2DictWalkerTokenTypes.GE);
					_t = _t.getNextSibling();
					break;
				}
				case LTGT: {
					AST tmp132_AST = null;
					AST tmp132_AST_in = null;
					tmp132_AST = astFactory.create((AST) _t);
					tmp132_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp132_AST);
					match(_t, Express2DictWalkerTokenTypes.LTGT);
					_t = _t.getNextSibling();
					break;
				}
				case ASSIGN: {
					AST tmp133_AST = null;
					AST tmp133_AST_in = null;
					tmp133_AST = astFactory.create((AST) _t);
					tmp133_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp133_AST);
					match(_t, Express2DictWalkerTokenTypes.ASSIGN);
					_t = _t.getNextSibling();
					break;
				}
				case COLLTGT: {
					AST tmp134_AST = null;
					AST tmp134_AST_in = null;
					tmp134_AST = astFactory.create((AST) _t);
					tmp134_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp134_AST);
					match(_t, Express2DictWalkerTokenTypes.COLLTGT);
					_t = _t.getNextSibling();
					break;
				}
				case COLEQCOL: {
					AST tmp135_AST = null;
					AST tmp135_AST_in = null;
					tmp135_AST = astFactory.create((AST) _t);
					tmp135_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp135_AST);
					match(_t, Express2DictWalkerTokenTypes.COLEQCOL);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST215;
			_t = __t215;
			_t = _t.getNextSibling();
			rel_op_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = rel_op_AST;
		_retTree = _t;
	}

	public final void simple_factor(AST _t) throws RecognitionException {

		AST simple_factor_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_factor_AST = null;

		try { // for error handling
			AST __t482 = _t;
			AST tmp136_AST = null;
			AST tmp136_AST_in = null;
			tmp136_AST = astFactory.create((AST) _t);
			tmp136_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp136_AST);
			ASTPair __currentAST482 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SIMPLE_FACTOR);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case AGGREGATE_INITIALIZER: {
					aggregate_initializer(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case INTERVAL: {
					interval(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case QUERY_EXPRESSION: {
					query_expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ENTITY_CONSTRUCTOR: {
					entity_constructor(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ENUMERATION_REFERENCE: {
					enumeration_reference(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case EXPRESSION:
				case PRIMARY:
				case UNARY_OP: {
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case UNARY_OP: {
							unary_op(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case EXPRESSION:
						case PRIMARY: {
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case EXPRESSION: {
							expression(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case PRIMARY: {
							primary(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST482;
			_t = __t482;
			_t = _t.getNextSibling();
			simple_factor_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = simple_factor_AST;
		_retTree = _t;
	}

	public final void formal_parameter(AST _t) throws RecognitionException {

		AST formal_parameter_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST formal_parameter_AST = null;

		try { // for error handling
			AST __t221 = _t;
			AST tmp137_AST = null;
			AST tmp137_AST_in = null;
			tmp137_AST = astFactory.create((AST) _t);
			tmp137_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp137_AST);
			ASTPair __currentAST221 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FORMAL_PARAMETER);
			_t = _t.getFirstChild();
			parameter_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop223: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.PARAMETER_ID.getIndex())) {
						parameter_id(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop223;
					}

				} while (true);
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST221;
			_t = __t221;
			_t = _t.getNextSibling();
			formal_parameter_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = formal_parameter_AST;
		_retTree = _t;
	}

	public final void parameter_id(AST _t) throws RecognitionException {

		AST parameter_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_id_AST = null;

		try { // for error handling
			AST __t359 = _t;
			AST tmp138_AST = null;
			AST tmp138_AST_in = null;
			tmp138_AST = astFactory.create((AST) _t);
			tmp138_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp138_AST);
			ASTPair __currentAST359 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PARAMETER_ID);
			_t = _t.getFirstChild();
			AST tmp139_AST = null;
			AST tmp139_AST_in = null;
			tmp139_AST = astFactory.create((AST) _t);
			tmp139_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp139_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST359;
			_t = __t359;
			_t = _t.getNextSibling();
			parameter_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = parameter_id_AST;
		_retTree = _t;
	}

	public final void function_call(AST _t) throws RecognitionException {

		AST function_call_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_call_AST = null;

		try { // for error handling
			AST __t227 = _t;
			AST tmp140_AST = null;
			AST tmp140_AST_in = null;
			tmp140_AST = astFactory.create((AST) _t);
			tmp140_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp140_AST);
			ASTPair __currentAST227 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FUNCTION_CALL);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case FUNCTION_REF: {
					function_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BUILT_IN_FUNCTION: {
					built_in_function(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ACTUAL_PARAMETER_LIST: {
					actual_parameter_list(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST227;
			_t = __t227;
			_t = _t.getNextSibling();
			function_call_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = function_call_AST;
		_retTree = _t;
	}

	public final void function_ref(AST _t) throws RecognitionException {

		AST function_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_ref_AST = null;

		try { // for error handling
			AST __t610 = _t;
			AST tmp141_AST = null;
			AST tmp141_AST_in = null;
			tmp141_AST = astFactory.create((AST) _t);
			tmp141_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp141_AST);
			ASTPair __currentAST610 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FUNCTION_REF);
			_t = _t.getFirstChild();
			AST tmp142_AST = null;
			AST tmp142_AST_in = null;
			tmp142_AST = astFactory.create((AST) _t);
			tmp142_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp142_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST610;
			_t = __t610;
			_t = _t.getNextSibling();
			function_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = function_ref_AST;
		_retTree = _t;
	}

	public final void built_in_function(AST _t) throws RecognitionException {

		AST built_in_function_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_function_AST = null;

		try { // for error handling
			AST __t231 = _t;
			AST tmp143_AST = null;
			AST tmp143_AST_in = null;
			tmp143_AST = astFactory.create((AST) _t);
			tmp143_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp143_AST);
			ASTPair __currentAST231 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BUILT_IN_FUNCTION);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_abs: {
					AST tmp144_AST = null;
					AST tmp144_AST_in = null;
					tmp144_AST = astFactory.create((AST) _t);
					tmp144_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp144_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_abs);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_acos: {
					AST tmp145_AST = null;
					AST tmp145_AST_in = null;
					tmp145_AST = astFactory.create((AST) _t);
					tmp145_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp145_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_acos);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_asin: {
					AST tmp146_AST = null;
					AST tmp146_AST_in = null;
					tmp146_AST = astFactory.create((AST) _t);
					tmp146_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp146_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_asin);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_atan: {
					AST tmp147_AST = null;
					AST tmp147_AST_in = null;
					tmp147_AST = astFactory.create((AST) _t);
					tmp147_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp147_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_atan);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_blength: {
					AST tmp148_AST = null;
					AST tmp148_AST_in = null;
					tmp148_AST = astFactory.create((AST) _t);
					tmp148_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp148_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_blength);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_cos: {
					AST tmp149_AST = null;
					AST tmp149_AST_in = null;
					tmp149_AST = astFactory.create((AST) _t);
					tmp149_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp149_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_cos);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_exists: {
					AST tmp150_AST = null;
					AST tmp150_AST_in = null;
					tmp150_AST = astFactory.create((AST) _t);
					tmp150_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp150_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_exists);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_exp: {
					AST tmp151_AST = null;
					AST tmp151_AST_in = null;
					tmp151_AST = astFactory.create((AST) _t);
					tmp151_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp151_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_exp);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_format: {
					AST tmp152_AST = null;
					AST tmp152_AST_in = null;
					tmp152_AST = astFactory.create((AST) _t);
					tmp152_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp152_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_format);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_hibound: {
					AST tmp153_AST = null;
					AST tmp153_AST_in = null;
					tmp153_AST = astFactory.create((AST) _t);
					tmp153_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp153_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_hibound);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_hiindex: {
					AST tmp154_AST = null;
					AST tmp154_AST_in = null;
					tmp154_AST = astFactory.create((AST) _t);
					tmp154_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp154_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_hiindex);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_length: {
					AST tmp155_AST = null;
					AST tmp155_AST_in = null;
					tmp155_AST = astFactory.create((AST) _t);
					tmp155_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp155_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_length);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_lobound: {
					AST tmp156_AST = null;
					AST tmp156_AST_in = null;
					tmp156_AST = astFactory.create((AST) _t);
					tmp156_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp156_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_lobound);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_loindex: {
					AST tmp157_AST = null;
					AST tmp157_AST_in = null;
					tmp157_AST = astFactory.create((AST) _t);
					tmp157_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp157_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_loindex);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_log: {
					AST tmp158_AST = null;
					AST tmp158_AST_in = null;
					tmp158_AST = astFactory.create((AST) _t);
					tmp158_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp158_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_log);
					_t = _t.getNextSibling();
					break;
				}
				case LOG2: {
					AST tmp159_AST = null;
					AST tmp159_AST_in = null;
					tmp159_AST = astFactory.create((AST) _t);
					tmp159_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp159_AST);
					match(_t, Express2DictWalkerTokenTypes.LOG2);
					_t = _t.getNextSibling();
					break;
				}
				case LOG10: {
					AST tmp160_AST = null;
					AST tmp160_AST_in = null;
					tmp160_AST = astFactory.create((AST) _t);
					tmp160_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp160_AST);
					match(_t, Express2DictWalkerTokenTypes.LOG10);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_nvl: {
					AST tmp161_AST = null;
					AST tmp161_AST_in = null;
					tmp161_AST = astFactory.create((AST) _t);
					tmp161_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp161_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_nvl);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_odd: {
					AST tmp162_AST = null;
					AST tmp162_AST_in = null;
					tmp162_AST = astFactory.create((AST) _t);
					tmp162_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp162_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_odd);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_rolesof: {
					AST tmp163_AST = null;
					AST tmp163_AST_in = null;
					tmp163_AST = astFactory.create((AST) _t);
					tmp163_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp163_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_rolesof);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_sin: {
					AST tmp164_AST = null;
					AST tmp164_AST_in = null;
					tmp164_AST = astFactory.create((AST) _t);
					tmp164_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp164_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_sin);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_sizeof: {
					AST tmp165_AST = null;
					AST tmp165_AST_in = null;
					tmp165_AST = astFactory.create((AST) _t);
					tmp165_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp165_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_sizeof);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_sqrt: {
					AST tmp166_AST = null;
					AST tmp166_AST_in = null;
					tmp166_AST = astFactory.create((AST) _t);
					tmp166_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp166_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_sqrt);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_tan: {
					AST tmp167_AST = null;
					AST tmp167_AST_in = null;
					tmp167_AST = astFactory.create((AST) _t);
					tmp167_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp167_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_tan);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_typeof: {
					AST tmp168_AST = null;
					AST tmp168_AST_in = null;
					tmp168_AST = astFactory.create((AST) _t);
					tmp168_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp168_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_typeof);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_usedin: {
					AST tmp169_AST = null;
					AST tmp169_AST_in = null;
					tmp169_AST = astFactory.create((AST) _t);
					tmp169_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp169_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_usedin);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_value: {
					AST tmp170_AST = null;
					AST tmp170_AST_in = null;
					tmp170_AST = astFactory.create((AST) _t);
					tmp170_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp170_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_value);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_value_in: {
					AST tmp171_AST = null;
					AST tmp171_AST_in = null;
					tmp171_AST = astFactory.create((AST) _t);
					tmp171_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp171_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_value_in);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_value_unique: {
					AST tmp172_AST = null;
					AST tmp172_AST_in = null;
					tmp172_AST = astFactory.create((AST) _t);
					tmp172_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp172_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_value_unique);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST231;
			_t = __t231;
			_t = _t.getNextSibling();
			built_in_function_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = built_in_function_AST;
		_retTree = _t;
	}

	public final void function_head(AST _t) throws RecognitionException {

		AST function_head_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_head_AST = null;

		try { // for error handling
			AST __t239 = _t;
			AST tmp173_AST = null;
			AST tmp173_AST_in = null;
			tmp173_AST = astFactory.create((AST) _t);
			tmp173_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp173_AST);
			ASTPair __currentAST239 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FUNCTION_HEAD);
			_t = _t.getFirstChild();
			function_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case FORMAL_PARAMETER: {
					formal_parameter(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop242: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.FORMAL_PARAMETER.getIndex())) {
								formal_parameter(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop242;
							}

						} while (true);
					}
					break;
				}
				case PARAMETER_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST239;
			_t = __t239;
			_t = _t.getNextSibling();
			function_head_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = function_head_AST;
		_retTree = _t;
	}

	public final void function_id(AST _t) throws RecognitionException {

		AST function_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_id_AST = null;

		try { // for error handling
			AST __t244 = _t;
			AST tmp174_AST = null;
			AST tmp174_AST_in = null;
			tmp174_AST = astFactory.create((AST) _t);
			tmp174_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp174_AST);
			ASTPair __currentAST244 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.FUNCTION_ID);
			_t = _t.getFirstChild();
			AST tmp175_AST = null;
			AST tmp175_AST_in = null;
			tmp175_AST = astFactory.create((AST) _t);
			tmp175_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp175_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST244;
			_t = __t244;
			_t = _t.getNextSibling();
			function_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = function_id_AST;
		_retTree = _t;
	}

	public final String general_aggregation_types(AST _t) throws RecognitionException {
		String TypeName = "";

		AST general_aggregation_types_AST_in = (_t == ASTNULL) ? null : (AST) _t;
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_aggregation_types_AST = null;

		try { // for error handling
			AST __t251 = _t;
			AST tmp176_AST = null;
			AST tmp176_AST_in = null;
			tmp176_AST = astFactory.create((AST) _t);
			tmp176_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp176_AST);
			ASTPair __currentAST251 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERAL_AGGREGATION_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case GENERAL_ARRAY_TYPE: {
					general_array_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERAL_BAG_TYPE: {
					general_bag_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERAL_LIST_TYPE: {
					TypeName = general_list_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERAL_SET_TYPE: {
					general_set_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST251;
			_t = __t251;
			_t = _t.getNextSibling();
			general_aggregation_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = general_aggregation_types_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void generic_type(AST _t) throws RecognitionException {

		AST generic_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generic_type_AST = null;

		try { // for error handling
			AST __t272 = _t;
			AST tmp177_AST = null;
			AST tmp177_AST_in = null;
			tmp177_AST = astFactory.create((AST) _t);
			tmp177_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp177_AST);
			ASTPair __currentAST272 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERIC_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case TYPE_LABEL: {
					type_label(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST272;
			_t = __t272;
			_t = _t.getNextSibling();
			generic_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = generic_type_AST;
		_retTree = _t;
	}

	public final void generic_entity_type(AST _t) throws RecognitionException {

		AST generic_entity_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST generic_entity_type_AST = null;

		try { // for error handling
			AST __t249 = _t;
			AST tmp178_AST = null;
			AST tmp178_AST_in = null;
			tmp178_AST = astFactory.create((AST) _t);
			tmp178_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp178_AST);
			ASTPair __currentAST249 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERIC_ENTITY_TYPE);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST249;
			_t = __t249;
			_t = _t.getNextSibling();
			generic_entity_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = generic_entity_type_AST;
		_retTree = _t;
	}

	public final void general_array_type(AST _t) throws RecognitionException {

		AST general_array_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_array_type_AST = null;

		try { // for error handling
			AST __t254 = _t;
			AST tmp179_AST = null;
			AST tmp179_AST_in = null;
			tmp179_AST = astFactory.create((AST) _t);
			tmp179_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp179_AST);
			ASTPair __currentAST254 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERAL_ARRAY_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PARAMETER_TYPE:
				case LITERAL_optional:
				case LITERAL_unique: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_optional: {
					AST tmp180_AST = null;
					AST tmp180_AST_in = null;
					tmp180_AST = astFactory.create((AST) _t);
					tmp180_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp180_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_optional);
					_t = _t.getNextSibling();
					break;
				}
				case PARAMETER_TYPE:
				case LITERAL_unique: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_unique: {
					AST tmp181_AST = null;
					AST tmp181_AST_in = null;
					tmp181_AST = astFactory.create((AST) _t);
					tmp181_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp181_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_unique);
					_t = _t.getNextSibling();
					break;
				}
				case PARAMETER_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST254;
			_t = __t254;
			_t = _t.getNextSibling();

			// System.out.println("array");

			general_array_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = general_array_type_AST;
		_retTree = _t;
	}

	public final void general_bag_type(AST _t) throws RecognitionException {

		AST general_bag_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_bag_type_AST = null;

		try { // for error handling
			AST __t259 = _t;
			AST tmp182_AST = null;
			AST tmp182_AST_in = null;
			tmp182_AST = astFactory.create((AST) _t);
			tmp182_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp182_AST);
			ASTPair __currentAST259 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERAL_BAG_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PARAMETER_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST259;
			_t = __t259;
			_t = _t.getNextSibling();
			general_bag_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = general_bag_type_AST;
		_retTree = _t;
	}

	public final String general_list_type(AST _t) throws RecognitionException {
		String TypeName = "";

		AST general_list_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_list_type_AST = null;
		AST tn_AST = null;
		AST tn = null;

		try { // for error handling
			AST __t262 = _t;
			AST tmp183_AST = null;
			AST tmp183_AST_in = null;
			tmp183_AST = astFactory.create((AST) _t);
			tmp183_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp183_AST);
			ASTPair __currentAST262 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERAL_LIST_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PARAMETER_TYPE:
				case LITERAL_unique: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_unique: {
					AST tmp184_AST = null;
					AST tmp184_AST_in = null;
					tmp184_AST = astFactory.create((AST) _t);
					tmp184_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp184_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_unique);
					_t = _t.getNextSibling();
					break;
				}
				case PARAMETER_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			tn = _t == ASTNULL ? null : (AST) _t;
			parameter_type(_t);
			_t = _retTree;
			tn_AST = (AST) returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST262;
			_t = __t262;
			_t = _t.getNextSibling();

			// System.out.println("list");
			// TypeName += tn.getText();

			general_list_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = general_list_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void general_set_type(AST _t) throws RecognitionException {

		AST general_set_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST general_set_type_AST = null;

		try { // for error handling
			AST __t269 = _t;
			AST tmp185_AST = null;
			AST tmp185_AST_in = null;
			tmp185_AST = astFactory.create((AST) _t);
			tmp185_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp185_AST);
			ASTPair __currentAST269 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.GENERAL_SET_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BOUND_SPEC: {
					bound_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PARAMETER_TYPE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST269;
			_t = __t269;
			_t = _t.getNextSibling();
			general_set_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = general_set_type_AST;
		_retTree = _t;
	}

	public final void parameter_ref(AST _t) throws RecognitionException {

		AST parameter_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_ref_AST = null;

		try { // for error handling
			AST __t612 = _t;
			AST tmp186_AST = null;
			AST tmp186_AST_in = null;
			tmp186_AST = astFactory.create((AST) _t);
			tmp186_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp186_AST);
			ASTPair __currentAST612 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PARAMETER_REF);
			_t = _t.getFirstChild();
			AST tmp187_AST = null;
			AST tmp187_AST_in = null;
			tmp187_AST = astFactory.create((AST) _t);
			tmp187_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp187_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST612;
			_t = __t612;
			_t = _t.getNextSibling();
			parameter_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = parameter_ref_AST;
		_retTree = _t;
	}

	public final void variable_ref(AST _t) throws RecognitionException {

		AST variable_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_ref_AST = null;

		try { // for error handling
			AST __t614 = _t;
			AST tmp188_AST = null;
			AST tmp188_AST_in = null;
			tmp188_AST = astFactory.create((AST) _t);
			tmp188_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp188_AST);
			ASTPair __currentAST614 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.VARIABLE_REF);
			_t = _t.getFirstChild();
			AST tmp189_AST = null;
			AST tmp189_AST_in = null;
			tmp189_AST = astFactory.create((AST) _t);
			tmp189_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp189_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST614;
			_t = __t614;
			_t = _t.getNextSibling();
			variable_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = variable_ref_AST;
		_retTree = _t;
	}

	public final void if_stmt(AST _t) throws RecognitionException {

		AST if_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST if_stmt_AST = null;

		try { // for error handling
			AST __t277 = _t;
			AST tmp190_AST = null;
			AST tmp190_AST_in = null;
			tmp190_AST = astFactory.create((AST) _t);
			tmp190_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp190_AST);
			ASTPair __currentAST277 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.IF_STMT);
			_t = _t.getFirstChild();
			logical_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop279: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop279;
					}

				} while (true);
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ELSE_CLAUSE: {
					else_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST277;
			_t = __t277;
			_t = _t.getNextSibling();
			if_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = if_stmt_AST;
		_retTree = _t;
	}

	public final void else_clause(AST _t) throws RecognitionException {

		AST else_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST else_clause_AST = null;

		try { // for error handling
			AST __t282 = _t;
			AST tmp191_AST = null;
			AST tmp191_AST_in = null;
			tmp191_AST = astFactory.create((AST) _t);
			tmp191_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp191_AST);
			ASTPair __currentAST282 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ELSE_CLAUSE);
			_t = _t.getFirstChild();
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop284: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop284;
					}

				} while (true);
			}
			currentAST = __currentAST282;
			_t = __t282;
			_t = _t.getNextSibling();
			else_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = else_clause_AST;
		_retTree = _t;
	}

	public final void increment(AST _t) throws RecognitionException {

		AST increment_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST increment_AST = null;

		try { // for error handling
			AST __t286 = _t;
			AST tmp192_AST = null;
			AST tmp192_AST_in = null;
			tmp192_AST = astFactory.create((AST) _t);
			tmp192_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp192_AST);
			ASTPair __currentAST286 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INCREMENT);
			_t = _t.getFirstChild();
			numeric_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST286;
			_t = __t286;
			_t = _t.getNextSibling();
			increment_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = increment_AST;
		_retTree = _t;
	}

	public final void increment_control(AST _t) throws RecognitionException {

		AST increment_control_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST increment_control_AST = null;

		try { // for error handling
			AST __t288 = _t;
			AST tmp193_AST = null;
			AST tmp193_AST_in = null;
			tmp193_AST = astFactory.create((AST) _t);
			tmp193_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp193_AST);
			ASTPair __currentAST288 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INCREMENT_CONTROL);
			_t = _t.getFirstChild();
			variable_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			bound_1(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			bound_2(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case INCREMENT: {
					increment(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST288;
			_t = __t288;
			_t = _t.getNextSibling();
			increment_control_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = increment_control_AST;
		_retTree = _t;
	}

	public final void index(AST _t) throws RecognitionException {

		AST index_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_AST = null;

		try { // for error handling
			AST __t291 = _t;
			AST tmp194_AST = null;
			AST tmp194_AST_in = null;
			tmp194_AST = astFactory.create((AST) _t);
			tmp194_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp194_AST);
			ASTPair __currentAST291 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INDEX);
			_t = _t.getFirstChild();
			numeric_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST291;
			_t = __t291;
			_t = _t.getNextSibling();
			index_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = index_AST;
		_retTree = _t;
	}

	public final void index_1(AST _t) throws RecognitionException {

		AST index_1_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_1_AST = null;

		try { // for error handling
			AST __t293 = _t;
			AST tmp195_AST = null;
			AST tmp195_AST_in = null;
			tmp195_AST = astFactory.create((AST) _t);
			tmp195_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp195_AST);
			ASTPair __currentAST293 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INDEX_1);
			_t = _t.getFirstChild();
			index(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST293;
			_t = __t293;
			_t = _t.getNextSibling();
			index_1_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = index_1_AST;
		_retTree = _t;
	}

	public final void index_2(AST _t) throws RecognitionException {

		AST index_2_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_2_AST = null;

		try { // for error handling
			AST __t295 = _t;
			AST tmp196_AST = null;
			AST tmp196_AST_in = null;
			tmp196_AST = astFactory.create((AST) _t);
			tmp196_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp196_AST);
			ASTPair __currentAST295 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INDEX_2);
			_t = _t.getFirstChild();
			index(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST295;
			_t = __t295;
			_t = _t.getNextSibling();
			index_2_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = index_2_AST;
		_retTree = _t;
	}

	public final void index_qualifier(AST _t) throws RecognitionException {

		AST index_qualifier_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_qualifier_AST = null;

		try { // for error handling
			AST __t297 = _t;
			AST tmp197_AST = null;
			AST tmp197_AST_in = null;
			tmp197_AST = astFactory.create((AST) _t);
			tmp197_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp197_AST);
			ASTPair __currentAST297 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INDEX_QUALIFIER);
			_t = _t.getFirstChild();
			index_1(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case INDEX_2: {
					index_2(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST297;
			_t = __t297;
			_t = _t.getNextSibling();
			index_qualifier_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = index_qualifier_AST;
		_retTree = _t;
	}

	public final String integer_type(AST _t) throws RecognitionException {
		String TypeName = "INTEGER";

		AST integer_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integer_type_AST = null;

		try { // for error handling
			AST __t300 = _t;
			AST tmp198_AST = null;
			AST tmp198_AST_in = null;
			tmp198_AST = astFactory.create((AST) _t);
			tmp198_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp198_AST);
			ASTPair __currentAST300 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTEGER_TYPE);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST300;
			_t = __t300;
			_t = _t.getNextSibling();
			integer_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = integer_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void interval(AST _t) throws RecognitionException {

		AST interval_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_AST = null;

		try { // for error handling
			AST __t302 = _t;
			AST tmp199_AST = null;
			AST tmp199_AST_in = null;
			tmp199_AST = astFactory.create((AST) _t);
			tmp199_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp199_AST);
			ASTPair __currentAST302 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTERVAL);
			_t = _t.getFirstChild();
			interval_low(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			interval_op(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			interval_item(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			interval_op(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			interval_high(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST302;
			_t = __t302;
			_t = _t.getNextSibling();
			interval_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = interval_AST;
		_retTree = _t;
	}

	public final void interval_low(AST _t) throws RecognitionException {

		AST interval_low_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_low_AST = null;

		try { // for error handling
			AST __t308 = _t;
			AST tmp200_AST = null;
			AST tmp200_AST_in = null;
			tmp200_AST = astFactory.create((AST) _t);
			tmp200_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp200_AST);
			ASTPair __currentAST308 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTERVAL_LOW);
			_t = _t.getFirstChild();
			simple_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST308;
			_t = __t308;
			_t = _t.getNextSibling();
			interval_low_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = interval_low_AST;
		_retTree = _t;
	}

	public final void interval_op(AST _t) throws RecognitionException {

		AST interval_op_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_op_AST = null;

		try { // for error handling
			AST __t310 = _t;
			AST tmp201_AST = null;
			AST tmp201_AST_in = null;
			tmp201_AST = astFactory.create((AST) _t);
			tmp201_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp201_AST);
			ASTPair __currentAST310 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTERVAL_OP);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LT: {
					AST tmp202_AST = null;
					AST tmp202_AST_in = null;
					tmp202_AST = astFactory.create((AST) _t);
					tmp202_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp202_AST);
					match(_t, Express2DictWalkerTokenTypes.LT);
					_t = _t.getNextSibling();
					break;
				}
				case LE: {
					AST tmp203_AST = null;
					AST tmp203_AST_in = null;
					tmp203_AST = astFactory.create((AST) _t);
					tmp203_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp203_AST);
					match(_t, Express2DictWalkerTokenTypes.LE);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST310;
			_t = __t310;
			_t = _t.getNextSibling();
			interval_op_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = interval_op_AST;
		_retTree = _t;
	}

	public final void interval_item(AST _t) throws RecognitionException {

		AST interval_item_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_item_AST = null;

		try { // for error handling
			AST __t306 = _t;
			AST tmp204_AST = null;
			AST tmp204_AST_in = null;
			tmp204_AST = astFactory.create((AST) _t);
			tmp204_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp204_AST);
			ASTPair __currentAST306 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTERVAL_ITEM);
			_t = _t.getFirstChild();
			simple_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST306;
			_t = __t306;
			_t = _t.getNextSibling();
			interval_item_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = interval_item_AST;
		_retTree = _t;
	}

	public final void interval_high(AST _t) throws RecognitionException {

		AST interval_high_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interval_high_AST = null;

		try { // for error handling
			AST __t304 = _t;
			AST tmp205_AST = null;
			AST tmp205_AST_in = null;
			tmp205_AST = astFactory.create((AST) _t);
			tmp205_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp205_AST);
			ASTPair __currentAST304 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTERVAL_HIGH);
			_t = _t.getFirstChild();
			simple_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST304;
			_t = __t304;
			_t = _t.getNextSibling();
			interval_high_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = interval_high_AST;
		_retTree = _t;
	}

	public final void literal(AST _t) throws RecognitionException {

		AST literal_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST literal_AST = null;

		try { // for error handling
			AST __t319 = _t;
			AST tmp206_AST = null;
			AST tmp206_AST_in = null;
			tmp206_AST = astFactory.create((AST) _t);
			tmp206_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp206_AST);
			ASTPair __currentAST319 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LITERAL);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case REAL: {
					real(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case INTEGER: {
					integer(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LOGICAL: {
					logical(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case STRING: {
					string(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST319;
			_t = __t319;
			_t = _t.getNextSibling();
			literal_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = literal_AST;
		_retTree = _t;
	}

	public final void real(AST _t) throws RecognitionException {

		AST real_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST real_AST = null;

		try { // for error handling
			AST __t324 = _t;
			AST tmp207_AST = null;
			AST tmp207_AST_in = null;
			tmp207_AST = astFactory.create((AST) _t);
			tmp207_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp207_AST);
			ASTPair __currentAST324 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REAL);
			_t = _t.getFirstChild();
			AST tmp208_AST = null;
			AST tmp208_AST_in = null;
			tmp208_AST = astFactory.create((AST) _t);
			tmp208_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(_t, Express2DictWalkerTokenTypes.FLOAT);
			_t = _t.getNextSibling();
			currentAST = __currentAST324;
			_t = __t324;
			_t = _t.getNextSibling();
			real_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = real_AST;
		_retTree = _t;
	}

	public final void integer(AST _t) throws RecognitionException {

		AST integer_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integer_AST = null;
		AST i = null;
		AST i_AST = null;

		try { // for error handling
			AST __t322 = _t;
			AST tmp209_AST = null;
			AST tmp209_AST_in = null;
			tmp209_AST = astFactory.create((AST) _t);
			tmp209_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp209_AST);
			ASTPair __currentAST322 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTEGER);
			_t = _t.getFirstChild();
			i = (AST) _t;
			AST i_AST_in = null;
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(_t, Express2DictWalkerTokenTypes.INT);
			_t = _t.getNextSibling();
			currentAST = __currentAST322;
			_t = __t322;
			_t = _t.getNextSibling();

			nextInt = i.getText();

			integer_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = integer_AST;
		_retTree = _t;
	}

	public final void logical(AST _t) throws RecognitionException {

		AST logical_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_AST = null;

		try { // for error handling
			AST __t339 = _t;
			AST tmp210_AST = null;
			AST tmp210_AST_in = null;
			tmp210_AST = astFactory.create((AST) _t);
			tmp210_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp210_AST);
			ASTPair __currentAST339 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LOGICAL);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_false: {
					AST tmp211_AST = null;
					AST tmp211_AST_in = null;
					tmp211_AST = astFactory.create((AST) _t);
					tmp211_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp211_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_false);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_true: {
					AST tmp212_AST = null;
					AST tmp212_AST_in = null;
					tmp212_AST = astFactory.create((AST) _t);
					tmp212_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp212_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_true);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_unknown: {
					AST tmp213_AST = null;
					AST tmp213_AST_in = null;
					tmp213_AST = astFactory.create((AST) _t);
					tmp213_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp213_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_unknown);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST339;
			_t = __t339;
			_t = _t.getNextSibling();
			logical_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = logical_AST;
		_retTree = _t;
	}

	public final void string(AST _t) throws RecognitionException {

		AST string_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST string_AST = null;

		try { // for error handling
			AST __t326 = _t;
			AST tmp214_AST = null;
			AST tmp214_AST_in = null;
			tmp214_AST = astFactory.create((AST) _t);
			tmp214_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp214_AST);
			ASTPair __currentAST326 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.STRING);
			_t = _t.getFirstChild();
			AST tmp215_AST = null;
			AST tmp215_AST_in = null;
			tmp215_AST = astFactory.create((AST) _t);
			tmp215_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp215_AST);
			match(_t, Express2DictWalkerTokenTypes.STRING);
			_t = _t.getNextSibling();
			currentAST = __currentAST326;
			_t = __t326;
			_t = _t.getNextSibling();
			string_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = string_AST;
		_retTree = _t;
	}

	public final void local_variable(AST _t) throws RecognitionException {

		AST local_variable_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST local_variable_AST = null;

		try { // for error handling
			AST __t332 = _t;
			AST tmp216_AST = null;
			AST tmp216_AST_in = null;
			tmp216_AST = astFactory.create((AST) _t);
			tmp216_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp216_AST);
			ASTPair __currentAST332 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LOCAL_VARIABLE);
			_t = _t.getFirstChild();
			variable_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop334: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.VARIABLE_ID.getIndex())) {
						variable_id(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop334;
					}

				} while (true);
			}
			parameter_type(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case EXPRESSION: {
					expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST332;
			_t = __t332;
			_t = _t.getNextSibling();
			local_variable_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = local_variable_AST;
		_retTree = _t;
	}

	public final String logical_type(AST _t) throws RecognitionException {
		String TypeName = "LOGICAL";

		AST logical_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_type_AST = null;

		try { // for error handling
			AST __t342 = _t;
			AST tmp217_AST = null;
			AST tmp217_AST_in = null;
			tmp217_AST = astFactory.create((AST) _t);
			tmp217_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp217_AST);
			ASTPair __currentAST342 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LOGICAL_TYPE);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST342;
			_t = __t342;
			_t = _t.getNextSibling();
			logical_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = logical_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void null_stmt(AST _t) throws RecognitionException {

		AST null_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST null_stmt_AST = null;

		try { // for error handling
			AST __t347 = _t;
			AST tmp218_AST = null;
			AST tmp218_AST_in = null;
			tmp218_AST = astFactory.create((AST) _t);
			tmp218_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp218_AST);
			ASTPair __currentAST347 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.NULL_STMT);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST347;
			_t = __t347;
			_t = _t.getNextSibling();
			null_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = null_stmt_AST;
		_retTree = _t;
	}

	public final String number_type(AST _t) throws RecognitionException {
		String TypeName = "NUMBER";

		AST number_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_type_AST = null;

		try { // for error handling
			AST __t349 = _t;
			AST tmp219_AST = null;
			AST tmp219_AST_in = null;
			tmp219_AST = astFactory.create((AST) _t);
			tmp219_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp219_AST);
			ASTPair __currentAST349 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.NUMBER_TYPE);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST349;
			_t = __t349;
			_t = _t.getNextSibling();
			number_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = number_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void one_of(AST _t) throws RecognitionException {

		AST one_of_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_of_AST = null;

		try { // for error handling
			AST __t353 = _t;
			AST tmp220_AST = null;
			AST tmp220_AST_in = null;
			tmp220_AST = astFactory.create((AST) _t);
			tmp220_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp220_AST);
			ASTPair __currentAST353 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ONE_OF);
			_t = _t.getFirstChild();
			supertype_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop355: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.SUPERTYPE_EXPRESSION.getIndex())) {
						supertype_expression(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop355;
					}

				} while (true);
			}
			currentAST = __currentAST353;
			_t = __t353;
			_t = _t.getNextSibling();
			one_of_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = one_of_AST;
		_retTree = _t;
	}

	public final void population(AST _t) throws RecognitionException {

		AST population_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST population_AST = null;

		try { // for error handling
			AST __t364 = _t;
			AST tmp221_AST = null;
			AST tmp221_AST_in = null;
			tmp221_AST = astFactory.create((AST) _t);
			tmp221_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp221_AST);
			ASTPair __currentAST364 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.POPULATION);
			_t = _t.getFirstChild();
			entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST364;
			_t = __t364;
			_t = _t.getNextSibling();
			population_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = population_AST;
		_retTree = _t;
	}

	public final void precision_spec(AST _t) throws RecognitionException {

		AST precision_spec_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST precision_spec_AST = null;

		try { // for error handling
			AST __t366 = _t;
			AST tmp222_AST = null;
			AST tmp222_AST_in = null;
			tmp222_AST = astFactory.create((AST) _t);
			tmp222_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp222_AST);
			ASTPair __currentAST366 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PRECISION_SPEC);
			_t = _t.getFirstChild();
			numeric_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST366;
			_t = __t366;
			_t = _t.getNextSibling();
			precision_spec_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = precision_spec_AST;
		_retTree = _t;
	}

	public final void primary(AST _t) throws RecognitionException {

		AST primary_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primary_AST = null;

		try { // for error handling
			AST __t368 = _t;
			AST tmp223_AST = null;
			AST tmp223_AST_in = null;
			tmp223_AST = astFactory.create((AST) _t);
			tmp223_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp223_AST);
			ASTPair __currentAST368 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PRIMARY);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL: {
					literal(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case QUALIFIABLE_FACTOR: {
					qualifiable_factor(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop371: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.QUALIFIER.getIndex())) {
								qualifier(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop371;
							}

						} while (true);
					}
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST368;
			_t = __t368;
			_t = _t.getNextSibling();
			primary_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = primary_AST;
		_retTree = _t;
	}

	public final void qualifiable_factor(AST _t) throws RecognitionException {

		AST qualifiable_factor_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifiable_factor_AST = null;

		try { // for error handling
			AST __t394 = _t;
			AST tmp224_AST = null;
			AST tmp224_AST_in = null;
			tmp224_AST = astFactory.create((AST) _t);
			tmp224_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp224_AST);
			ASTPair __currentAST394 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.QUALIFIABLE_FACTOR);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ATTRIBUTE_REF: {
					attribute_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case CONSTANT_FACTOR: {
					constant_factor(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case FUNCTION_CALL: {
					function_call(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case POPULATION: {
					population(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case GENERAL_REF: {
					general_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST394;
			_t = __t394;
			_t = _t.getNextSibling();
			qualifiable_factor_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = qualifiable_factor_AST;
		_retTree = _t;
	}

	public final void procedure_call_stmt(AST _t) throws RecognitionException {

		AST procedure_call_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_call_stmt_AST = null;

		try { // for error handling
			AST __t373 = _t;
			AST tmp225_AST = null;
			AST tmp225_AST_in = null;
			tmp225_AST = astFactory.create((AST) _t);
			tmp225_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp225_AST);
			ASTPair __currentAST373 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PROCEDURE_CALL_STMT);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case PROCEDURE_REF: {
					procedure_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case BUILT_IN_PROCEDURE: {
					built_in_procedure(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ACTUAL_PARAMETER_LIST: {
					actual_parameter_list(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST373;
			_t = __t373;
			_t = _t.getNextSibling();
			procedure_call_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = procedure_call_stmt_AST;
		_retTree = _t;
	}

	public final void procedure_ref(AST _t) throws RecognitionException {

		AST procedure_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_ref_AST = null;

		try { // for error handling
			AST __t620 = _t;
			AST tmp226_AST = null;
			AST tmp226_AST_in = null;
			tmp226_AST = astFactory.create((AST) _t);
			tmp226_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp226_AST);
			ASTPair __currentAST620 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PROCEDURE_REF);
			_t = _t.getFirstChild();
			AST tmp227_AST = null;
			AST tmp227_AST_in = null;
			tmp227_AST = astFactory.create((AST) _t);
			tmp227_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp227_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST620;
			_t = __t620;
			_t = _t.getNextSibling();
			procedure_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = procedure_ref_AST;
		_retTree = _t;
	}

	public final void built_in_procedure(AST _t) throws RecognitionException {

		AST built_in_procedure_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_procedure_AST = null;

		try { // for error handling
			AST __t377 = _t;
			AST tmp228_AST = null;
			AST tmp228_AST_in = null;
			tmp228_AST = astFactory.create((AST) _t);
			tmp228_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp228_AST);
			ASTPair __currentAST377 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.BUILT_IN_PROCEDURE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_insert: {
					AST tmp229_AST = null;
					AST tmp229_AST_in = null;
					tmp229_AST = astFactory.create((AST) _t);
					tmp229_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp229_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_insert);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_remove: {
					AST tmp230_AST = null;
					AST tmp230_AST_in = null;
					tmp230_AST = astFactory.create((AST) _t);
					tmp230_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp230_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_remove);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST377;
			_t = __t377;
			_t = _t.getNextSibling();
			built_in_procedure_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = built_in_procedure_AST;
		_retTree = _t;
	}

	public final void procedure_head(AST _t) throws RecognitionException {

		AST procedure_head_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_head_AST = null;

		try { // for error handling
			AST __t385 = _t;
			AST tmp231_AST = null;
			AST tmp231_AST_in = null;
			tmp231_AST = astFactory.create((AST) _t);
			tmp231_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp231_AST);
			ASTPair __currentAST385 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PROCEDURE_HEAD);
			_t = _t.getFirstChild();
			procedure_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case FORMAL_PARAMETER:
				case LITERAL_var: {
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case LITERAL_var: {
							AST tmp232_AST = null;
							AST tmp232_AST_in = null;
							tmp232_AST = astFactory.create((AST) _t);
							tmp232_AST_in = (AST) _t;
							astFactory.addASTChild(currentAST, tmp232_AST);
							match(_t, Express2DictWalkerTokenTypes.LITERAL_var);
							_t = _t.getNextSibling();
							break;
						}
						case FORMAL_PARAMETER: {
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					formal_parameter(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop390: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.FORMAL_PARAMETER.getIndex() || _t.getType() == Express2DictWalkerTokenTypes.LITERAL_var.getIndex())) {
								{
									if (_t == null)
										_t = ASTNULL;
									switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
									case LITERAL_var: {
										AST tmp233_AST = null;
										AST tmp233_AST_in = null;
										tmp233_AST = astFactory.create((AST) _t);
										tmp233_AST_in = (AST) _t;
										astFactory.addASTChild(currentAST, tmp233_AST);
										match(_t, Express2DictWalkerTokenTypes.LITERAL_var);
										_t = _t.getNextSibling();
										break;
									}
									case FORMAL_PARAMETER: {
										break;
									}
									default: {
										throw new NoViableAltException(_t);
									}
									}
								}
								formal_parameter(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop390;
							}

						} while (true);
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST385;
			_t = __t385;
			_t = _t.getNextSibling();
			procedure_head_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = procedure_head_AST;
		_retTree = _t;
	}

	public final void procedure_id(AST _t) throws RecognitionException {

		AST procedure_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_id_AST = null;

		try { // for error handling
			AST __t392 = _t;
			AST tmp234_AST = null;
			AST tmp234_AST_in = null;
			tmp234_AST = astFactory.create((AST) _t);
			tmp234_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp234_AST);
			ASTPair __currentAST392 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.PROCEDURE_ID);
			_t = _t.getFirstChild();
			AST tmp235_AST = null;
			AST tmp235_AST_in = null;
			tmp235_AST = astFactory.create((AST) _t);
			tmp235_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp235_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST392;
			_t = __t392;
			_t = _t.getNextSibling();
			procedure_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = procedure_id_AST;
		_retTree = _t;
	}

	public final void query_expression(AST _t) throws RecognitionException {

		AST query_expression_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST query_expression_AST = null;

		try { // for error handling
			AST __t400 = _t;
			AST tmp236_AST = null;
			AST tmp236_AST_in = null;
			tmp236_AST = astFactory.create((AST) _t);
			tmp236_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp236_AST);
			ASTPair __currentAST400 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.QUERY_EXPRESSION);
			_t = _t.getFirstChild();
			variable_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_source(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			logical_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST400;
			_t = __t400;
			_t = _t.getNextSibling();
			query_expression_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = query_expression_AST;
		_retTree = _t;
	}

	public final String real_type(AST _t) throws RecognitionException {
		String TypeName = "REAL";

		AST real_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST real_type_AST = null;

		try { // for error handling
			AST __t402 = _t;
			AST tmp237_AST = null;
			AST tmp237_AST_in = null;
			tmp237_AST = astFactory.create((AST) _t);
			tmp237_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp237_AST);
			ASTPair __currentAST402 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REAL_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case PRECISION_SPEC: {
					precision_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST402;
			_t = __t402;
			_t = _t.getNextSibling();
			real_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = real_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final void reference_clause(AST _t) throws RecognitionException {

		AST reference_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reference_clause_AST = null;

		try { // for error handling
			AST __t405 = _t;
			AST tmp238_AST = null;
			AST tmp238_AST_in = null;
			tmp238_AST = astFactory.create((AST) _t);
			tmp238_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp238_AST);
			ASTPair __currentAST405 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REFERENCE_CLAUSE);
			_t = _t.getFirstChild();
			schema_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case RESOURCE_OR_RENAME: {
					resource_or_rename(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop408: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.RESOURCE_OR_RENAME.getIndex())) {
								resource_or_rename(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop408;
							}

						} while (true);
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST405;
			_t = __t405;
			_t = _t.getNextSibling();
			reference_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = reference_clause_AST;
		_retTree = _t;
	}

	public final void schema_ref(AST _t) throws RecognitionException {

		AST schema_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_ref_AST = null;

		try { // for error handling
			AST __t616 = _t;
			AST tmp239_AST = null;
			AST tmp239_AST_in = null;
			tmp239_AST = astFactory.create((AST) _t);
			tmp239_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp239_AST);
			ASTPair __currentAST616 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SCHEMA_REF);
			_t = _t.getFirstChild();
			AST tmp240_AST = null;
			AST tmp240_AST_in = null;
			tmp240_AST = astFactory.create((AST) _t);
			tmp240_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp240_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST616;
			_t = __t616;
			_t = _t.getNextSibling();
			schema_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = schema_ref_AST;
		_retTree = _t;
	}

	public final void resource_or_rename(AST _t) throws RecognitionException {

		AST resource_or_rename_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST resource_or_rename_AST = null;

		try { // for error handling
			AST __t424 = _t;
			AST tmp241_AST = null;
			AST tmp241_AST_in = null;
			tmp241_AST = astFactory.create((AST) _t);
			tmp241_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp241_AST);
			ASTPair __currentAST424 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RESOURCE_OR_RENAME);
			_t = _t.getFirstChild();
			resource_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case RENAME_ID: {
					rename_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST424;
			_t = __t424;
			_t = _t.getNextSibling();
			resource_or_rename_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = resource_or_rename_AST;
		_retTree = _t;
	}

	public final void rename_id(AST _t) throws RecognitionException {

		AST rename_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rename_id_AST = null;

		try { // for error handling
			AST __t410 = _t;
			AST tmp242_AST = null;
			AST tmp242_AST_in = null;
			tmp242_AST = astFactory.create((AST) _t);
			tmp242_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp242_AST);
			ASTPair __currentAST410 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RENAME_ID);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONSTANT_ID: {
					constant_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ENTITY_ID: {
					entity_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case FUNCTION_ID: {
					function_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PROCEDURE_ID: {
					procedure_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case TYPE_ID: {
					type_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST410;
			_t = __t410;
			_t = _t.getNextSibling();
			rename_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = rename_id_AST;
		_retTree = _t;
	}

	public final String type_id(AST _t) throws RecognitionException {
		String identifyer = "";

		AST type_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_id_AST = null;
		AST id = null;
		AST id_AST = null;

		try { // for error handling
			AST __t574 = _t;
			AST tmp243_AST = null;
			AST tmp243_AST_in = null;
			tmp243_AST = astFactory.create((AST) _t);
			tmp243_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp243_AST);
			ASTPair __currentAST574 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TYPE_ID);
			_t = _t.getFirstChild();
			id = (AST) _t;
			AST id_AST_in = null;
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST574;
			_t = __t574;
			_t = _t.getNextSibling();
			identifyer = id.getText();
			type_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = type_id_AST;
		_retTree = _t;
		return identifyer;
	}

	public final void repeat_control(AST _t) throws RecognitionException {

		AST repeat_control_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repeat_control_AST = null;

		try { // for error handling
			AST __t413 = _t;
			AST tmp244_AST = null;
			AST tmp244_AST_in = null;
			tmp244_AST = astFactory.create((AST) _t);
			tmp244_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp244_AST);
			ASTPair __currentAST413 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REPEAT_CONTROL);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case INCREMENT_CONTROL: {
					increment_control(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case UNTIL_CONTROL:
				case WHILE_CONTROL: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case WHILE_CONTROL: {
					while_control(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case UNTIL_CONTROL: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case UNTIL_CONTROL: {
					until_control(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST413;
			_t = __t413;
			_t = _t.getNextSibling();
			repeat_control_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = repeat_control_AST;
		_retTree = _t;
	}

	public final void while_control(AST _t) throws RecognitionException {

		AST while_control_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST while_control_AST = null;

		try { // for error handling
			AST __t591 = _t;
			AST tmp245_AST = null;
			AST tmp245_AST_in = null;
			tmp245_AST = astFactory.create((AST) _t);
			tmp245_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp245_AST);
			ASTPair __currentAST591 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.WHILE_CONTROL);
			_t = _t.getFirstChild();
			logical_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST591;
			_t = __t591;
			_t = _t.getNextSibling();
			while_control_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = while_control_AST;
		_retTree = _t;
	}

	public final void until_control(AST _t) throws RecognitionException {

		AST until_control_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST until_control_AST = null;

		try { // for error handling
			AST __t583 = _t;
			AST tmp246_AST = null;
			AST tmp246_AST_in = null;
			tmp246_AST = astFactory.create((AST) _t);
			tmp246_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp246_AST);
			ASTPair __currentAST583 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.UNTIL_CONTROL);
			_t = _t.getFirstChild();
			logical_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST583;
			_t = __t583;
			_t = _t.getNextSibling();
			until_control_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = until_control_AST;
		_retTree = _t;
	}

	public final void repeat_stmt(AST _t) throws RecognitionException {

		AST repeat_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST repeat_stmt_AST = null;

		try { // for error handling
			AST __t418 = _t;
			AST tmp247_AST = null;
			AST tmp247_AST_in = null;
			tmp247_AST = astFactory.create((AST) _t);
			tmp247_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp247_AST);
			ASTPair __currentAST418 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.REPEAT_STMT);
			_t = _t.getFirstChild();
			repeat_control(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			stmt(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop420: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop420;
					}

				} while (true);
			}
			currentAST = __currentAST418;
			_t = __t418;
			_t = _t.getNextSibling();
			repeat_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = repeat_stmt_AST;
		_retTree = _t;
	}

	public final void resource_ref(AST _t) throws RecognitionException {

		AST resource_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST resource_ref_AST = null;

		try { // for error handling
			AST __t427 = _t;
			AST tmp248_AST = null;
			AST tmp248_AST_in = null;
			tmp248_AST = astFactory.create((AST) _t);
			tmp248_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp248_AST);
			ASTPair __currentAST427 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RESOURCE_REF);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONSTANT_REF: {
					constant_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ENTITY_REF: {
					entity_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case FUNCTION_REF: {
					function_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PROCEDURE_REF: {
					procedure_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case TYPE_REF: {
					type_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST427;
			_t = __t427;
			_t = _t.getNextSibling();
			resource_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = resource_ref_AST;
		_retTree = _t;
	}

	public final void return_stmt(AST _t) throws RecognitionException {

		AST return_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST return_stmt_AST = null;

		try { // for error handling
			AST __t430 = _t;
			AST tmp249_AST = null;
			AST tmp249_AST_in = null;
			tmp249_AST = astFactory.create((AST) _t);
			tmp249_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp249_AST);
			ASTPair __currentAST430 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RETURN_STMT);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case EXPRESSION: {
					expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST430;
			_t = __t430;
			_t = _t.getNextSibling();
			return_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = return_stmt_AST;
		_retTree = _t;
	}

	public final void rule_decl(AST _t) throws RecognitionException {

		AST rule_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_decl_AST = null;

		try { // for error handling
			AST __t433 = _t;
			AST tmp250_AST = null;
			AST tmp250_AST_in = null;
			tmp250_AST = astFactory.create((AST) _t);
			tmp250_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp250_AST);
			ASTPair __currentAST433 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RULE_DECL);
			_t = _t.getFirstChild();
			rule_head(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ALGORITHM_HEAD: {
					algorithm_head(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case STMT:
				case WHERE_CLAUSE: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				_loop436: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.STMT.getIndex())) {
						stmt(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop436;
					}

				} while (true);
			}
			where_clause(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST433;
			_t = __t433;
			_t = _t.getNextSibling();
			rule_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = rule_decl_AST;
		_retTree = _t;
	}

	public final void rule_head(AST _t) throws RecognitionException {

		AST rule_head_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_head_AST = null;

		try { // for error handling
			AST __t438 = _t;
			AST tmp251_AST = null;
			AST tmp251_AST_in = null;
			tmp251_AST = astFactory.create((AST) _t);
			tmp251_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp251_AST);
			ASTPair __currentAST438 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RULE_HEAD);
			_t = _t.getFirstChild();
			rule_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			entity_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop440: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.ENTITY_REF.getIndex())) {
						entity_ref(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop440;
					}

				} while (true);
			}
			currentAST = __currentAST438;
			_t = __t438;
			_t = _t.getNextSibling();
			rule_head_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = rule_head_AST;
		_retTree = _t;
	}

	public final void rule_id(AST _t) throws RecognitionException {

		AST rule_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rule_id_AST = null;

		try { // for error handling
			AST __t442 = _t;
			AST tmp252_AST = null;
			AST tmp252_AST_in = null;
			tmp252_AST = astFactory.create((AST) _t);
			tmp252_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp252_AST);
			ASTPair __currentAST442 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.RULE_ID);
			_t = _t.getFirstChild();
			AST tmp253_AST = null;
			AST tmp253_AST_in = null;
			tmp253_AST = astFactory.create((AST) _t);
			tmp253_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp253_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST442;
			_t = __t442;
			_t = _t.getNextSibling();
			rule_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = rule_id_AST;
		_retTree = _t;
	}

	public final String schema_id(AST _t) throws RecognitionException {
		String schemaName;

		AST schema_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_id_AST = null;
		AST id = null;
		AST id_AST = null;

		schemaName = null;

		try { // for error handling
			AST __t444 = _t;
			AST tmp254_AST = null;
			AST tmp254_AST_in = null;
			tmp254_AST = astFactory.create((AST) _t);
			tmp254_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp254_AST);
			ASTPair __currentAST444 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SCHEMA_ID);
			_t = _t.getFirstChild();
			id = (AST) _t;
			AST id_AST_in = null;
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST444;
			_t = __t444;
			_t = _t.getNextSibling();

			schemaName = id.getText();

			schema_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = schema_id_AST;
		_retTree = _t;
		return schemaName;
	}

	public final void schema_body(AST _t) throws RecognitionException {

		AST schema_body_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_body_AST = null;

		try { // for error handling
			AST __t446 = _t;
			AST tmp255_AST = null;
			AST tmp255_AST_in = null;
			tmp255_AST = astFactory.create((AST) _t);
			tmp255_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp255_AST);
			ASTPair __currentAST446 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SCHEMA_BODY);
			_t = _t.getFirstChild();
			{
				_loop448: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.INTERFACE_SPECIFICATION.getIndex())) {
						interface_specification(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop448;
					}

				} while (true);
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONSTANT_DECL: {
					constant_decl(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case DECLARATION:
				case RULE_DECL: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				_loop451: do {
					if (_t == null)
						_t = ASTNULL;
					switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
					case DECLARATION: {
						declaration(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case RULE_DECL: {
						rule_decl(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default: {
						break _loop451;
					}
					}
				} while (true);
			}
			currentAST = __currentAST446;
			_t = __t446;
			_t = _t.getNextSibling();
			schema_body_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = schema_body_AST;
		_retTree = _t;
	}

	public final void interface_specification(AST _t) throws RecognitionException {

		AST interface_specification_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interface_specification_AST = null;

		try { // for error handling
			AST __t458 = _t;
			AST tmp256_AST = null;
			AST tmp256_AST_in = null;
			tmp256_AST = astFactory.create((AST) _t);
			tmp256_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp256_AST);
			ASTPair __currentAST458 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.INTERFACE_SPECIFICATION);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case REFERENCE_CLAUSE: {
					reference_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case USE_CLAUSE: {
					use_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST458;
			_t = __t458;
			_t = _t.getNextSibling();
			interface_specification_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = interface_specification_AST;
		_retTree = _t;
	}

	public final void schema_decl(AST _t) throws RecognitionException {

		AST schema_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_decl_AST = null;

		// schemaElement = null;
		// Element contents = new Element("complexType", methods.xsd);;
		// String schemaName = null;
		// methods.schemaContents = methods.makeChoiceElement("0", "unbounded");

		try { // for error handling
			AST __t453 = _t;
			AST tmp257_AST = null;
			AST tmp257_AST_in = null;
			tmp257_AST = astFactory.create((AST) _t);
			tmp257_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp257_AST);
			ASTPair __currentAST453 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SCHEMA_DECL);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SCHEMA_VERSION_ID: {
					schema_version_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SCHEMA_ID: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			schema_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);

			/*
			 * schemaElement = (new Element("element",
			 * methods.xsd).addContent(contents)); schemaElement.setAttribute
			 * (new Attribute("name", "schema-instance"));
			 * contents.addContent(methods.schemaContents); contents.addContent
			 * (new Element ("attributeGroup", methods.xsd).setAttribute (new
			 * Attribute("ref", "schema-instance.atts"))); contents.addContent
			 * (new Element ("attribute", methods.xsd).setAttribute (new
			 * Attribute ("name", "express_schema_name")).setAttribute (new
			 * Attribute ("type",
			 * methods.xsd.getPrefix()+":NMTOKEN")).setAttribute (new Attribute
			 * ("fixed", methods.capitalizeFirstLetter(schemaName))));
			 */
			schema_body(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST453;
			_t = __t453;
			_t = _t.getNextSibling();
			schema_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = schema_decl_AST;
		_retTree = _t;
	}

	public final void schema_version_id(AST _t) throws RecognitionException {

		AST schema_version_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_version_id_AST = null;

		try { // for error handling
			AST __t456 = _t;
			AST tmp258_AST = null;
			AST tmp258_AST_in = null;
			tmp258_AST = astFactory.create((AST) _t);
			tmp258_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp258_AST);
			ASTPair __currentAST456 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SCHEMA_VERSION_ID);
			_t = _t.getFirstChild();
			string(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST456;
			_t = __t456;
			_t = _t.getNextSibling();
			schema_version_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = schema_version_id_AST;
		_retTree = _t;
	}

	public final void use_clause(AST _t) throws RecognitionException {

		AST use_clause_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST use_clause_AST = null;

		try { // for error handling
			AST __t461 = _t;
			AST tmp259_AST = null;
			AST tmp259_AST_in = null;
			tmp259_AST = astFactory.create((AST) _t);
			tmp259_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp259_AST);
			ASTPair __currentAST461 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.USE_CLAUSE);
			_t = _t.getFirstChild();
			schema_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case NAMED_TYPE_OR_RENAME: {
					named_type_or_rename(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					{
						_loop464: do {
							if (_t == null)
								_t = ASTNULL;
							if ((_t.getType() == Express2DictWalkerTokenTypes.NAMED_TYPE_OR_RENAME.getIndex())) {
								named_type_or_rename(_t);
								_t = _retTree;
								astFactory.addASTChild(currentAST, returnAST);
							} else {
								break _loop464;
							}

						} while (true);
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST461;
			_t = __t461;
			_t = _t.getNextSibling();
			use_clause_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = use_clause_AST;
		_retTree = _t;
	}

	public final void named_type_or_rename(AST _t) throws RecognitionException {

		AST named_type_or_rename_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST named_type_or_rename_AST = null;

		try { // for error handling
			AST __t466 = _t;
			AST tmp260_AST = null;
			AST tmp260_AST_in = null;
			tmp260_AST = astFactory.create((AST) _t);
			tmp260_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp260_AST);
			ASTPair __currentAST466 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.NAMED_TYPE_OR_RENAME);
			_t = _t.getFirstChild();
			named_types(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENTITY_ID: {
					entity_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case TYPE_ID: {
					type_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST466;
			_t = __t466;
			_t = _t.getNextSibling();
			named_type_or_rename_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = named_type_or_rename_AST;
		_retTree = _t;
	}

	public final void add_like_op(AST _t) throws RecognitionException {

		AST add_like_op_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST add_like_op_AST = null;

		try { // for error handling
			AST __t479 = _t;
			AST tmp261_AST = null;
			AST tmp261_AST_in = null;
			tmp261_AST = astFactory.create((AST) _t);
			tmp261_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp261_AST);
			ASTPair __currentAST479 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ADD_LIKE_OP);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case PLUS: {
					AST tmp262_AST = null;
					AST tmp262_AST_in = null;
					tmp262_AST = astFactory.create((AST) _t);
					tmp262_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp262_AST);
					match(_t, Express2DictWalkerTokenTypes.PLUS);
					_t = _t.getNextSibling();
					break;
				}
				case MINUS: {
					AST tmp263_AST = null;
					AST tmp263_AST_in = null;
					tmp263_AST = astFactory.create((AST) _t);
					tmp263_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp263_AST);
					match(_t, Express2DictWalkerTokenTypes.MINUS);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_or: {
					AST tmp264_AST = null;
					AST tmp264_AST_in = null;
					tmp264_AST = astFactory.create((AST) _t);
					tmp264_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp264_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_or);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_xor: {
					AST tmp265_AST = null;
					AST tmp265_AST_in = null;
					tmp265_AST = astFactory.create((AST) _t);
					tmp265_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp265_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_xor);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST479;
			_t = __t479;
			_t = _t.getNextSibling();
			add_like_op_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = add_like_op_AST;
		_retTree = _t;
	}

	public final void unary_op(AST _t) throws RecognitionException {

		AST unary_op_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unary_op_AST = null;

		try { // for error handling
			AST __t580 = _t;
			AST tmp266_AST = null;
			AST tmp266_AST_in = null;
			tmp266_AST = astFactory.create((AST) _t);
			tmp266_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp266_AST);
			ASTPair __currentAST580 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.UNARY_OP);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case PLUS: {
					AST tmp267_AST = null;
					AST tmp267_AST_in = null;
					tmp267_AST = astFactory.create((AST) _t);
					tmp267_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp267_AST);
					match(_t, Express2DictWalkerTokenTypes.PLUS);
					_t = _t.getNextSibling();
					break;
				}
				case MINUS: {
					AST tmp268_AST = null;
					AST tmp268_AST_in = null;
					tmp268_AST = astFactory.create((AST) _t);
					tmp268_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp268_AST);
					match(_t, Express2DictWalkerTokenTypes.MINUS);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_not: {
					AST tmp269_AST = null;
					AST tmp269_AST_in = null;
					tmp269_AST = astFactory.create((AST) _t);
					tmp269_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp269_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_not);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST580;
			_t = __t580;
			_t = _t.getNextSibling();
			unary_op_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = unary_op_AST;
		_retTree = _t;
	}

	public final String string_type(AST _t) throws RecognitionException {
		String TypeName = "STRING";

		AST string_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST string_type_AST = null;

		try { // for error handling
			AST __t498 = _t;
			AST tmp270_AST = null;
			AST tmp270_AST_in = null;
			tmp270_AST = astFactory.create((AST) _t);
			tmp270_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp270_AST);
			ASTPair __currentAST498 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.STRING_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case WIDTH_SPEC: {
					width_spec(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST498;
			_t = __t498;
			_t = _t.getNextSibling();
			string_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = string_type_AST;
		_retTree = _t;
		return TypeName;
	}

	public final SimpleType simple_types_decl_bt(AST _t) throws RecognitionException {
		SimpleType st = null;

		AST simple_types_decl_bt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_types_decl_bt_AST = null;

		String TypeName = "";

		try { // for error handling
			AST __t490 = _t;
			AST tmp271_AST = null;
			AST tmp271_AST_in = null;
			tmp271_AST = astFactory.create((AST) _t);
			tmp271_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp271_AST);
			ASTPair __currentAST490 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SIMPLE_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case BINARY_TYPE: {
					TypeName = binary_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new BinaryType();
					break;
				}
				case BOOLEAN_TYPE: {
					TypeName = boolean_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new BooleanType();
					break;
				}
				case INTEGER_TYPE: {
					TypeName = integer_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new IntegerType();
					break;
				}
				case LOGICAL_TYPE: {
					TypeName = logical_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new LogicalType();
					break;
				}
				case NUMBER_TYPE: {
					TypeName = number_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new NumberType();
					break;
				}
				case REAL_TYPE: {
					TypeName = real_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new RealType();
					break;
				}
				case STRING_TYPE: {
					TypeName = string_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					st = new StringType();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST490;
			_t = __t490;
			_t = _t.getNextSibling();
			simple_types_decl_bt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = simple_types_decl_bt_AST;
		_retTree = _t;
		return st;
	}

	public final void skip_stmt(AST _t) throws RecognitionException {

		AST skip_stmt_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST skip_stmt_AST = null;

		try { // for error handling
			AST __t493 = _t;
			AST tmp272_AST = null;
			AST tmp272_AST_in = null;
			tmp272_AST = astFactory.create((AST) _t);
			tmp272_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp272_AST);
			ASTPair __currentAST493 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SKIP_STMT);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST493;
			_t = __t493;
			_t = _t.getNextSibling();
			skip_stmt_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = skip_stmt_AST;
		_retTree = _t;
	}

	public final void supertype_factor(AST _t) throws RecognitionException {

		AST supertype_factor_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_factor_AST = null;

		try { // for error handling
			AST __t507 = _t;
			AST tmp273_AST = null;
			AST tmp273_AST_in = null;
			tmp273_AST = astFactory.create((AST) _t);
			tmp273_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp273_AST);
			ASTPair __currentAST507 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUPERTYPE_FACTOR);
			_t = _t.getFirstChild();
			supertype_term(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop509: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.SUPERTYPE_TERM.getIndex())) {
						supertype_term(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop509;
					}

				} while (true);
			}
			currentAST = __currentAST507;
			_t = __t507;
			_t = _t.getNextSibling();
			supertype_factor_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = supertype_factor_AST;
		_retTree = _t;
	}

	public final void supertype_term(AST _t) throws RecognitionException {

		AST supertype_term_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST supertype_term_AST = null;

		try { // for error handling
			AST __t513 = _t;
			AST tmp274_AST = null;
			AST tmp274_AST_in = null;
			tmp274_AST = astFactory.create((AST) _t);
			tmp274_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp274_AST);
			ASTPair __currentAST513 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SUPERTYPE_TERM);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENTITY_REF: {
					entity_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case ONE_OF: {
					one_of(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SUPERTYPE_EXPRESSION: {
					supertype_expression(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST513;
			_t = __t513;
			_t = _t.getNextSibling();
			supertype_term_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = supertype_term_AST;
		_retTree = _t;
	}

	public final void syntax(AST _tree) throws RecognitionException {

		AST syntax_AST_in = (_tree == ASTNULL) ? null : (AST) _tree;
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST syntax_AST = null;

		try { // for error handling
			AST __t516 = _tree;
			AST tmp275_AST = null;
			AST tmp275_AST_in = null;
			tmp275_AST = astFactory.create((AST) _tree);
			tmp275_AST_in = (AST) _tree;
			astFactory.addASTChild(currentAST, tmp275_AST);
			ASTPair __currentAST516 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_tree, Express2DictWalkerTokenTypes.SYNTAX);
			_tree = _tree.getFirstChild();
			{
				if (_tree == null)
					_tree = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_tree.getType())) {
				case LANGUAGE_VERSION_ID: {
					language_version_id(_tree);
					_tree = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SCHEMA_DECL: {
					break;
				}
				default: {
					throw new NoViableAltException(_tree);
				}
				}
			}
			schema_decl(_tree);
			_tree = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop519: do {
					if (_tree == null)
						_tree = ASTNULL;
					if ((_tree.getType() == Express2DictWalkerTokenTypes.SCHEMA_DECL.getIndex())) {
						schema_decl(_tree);
						_tree = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop519;
					}

				} while (true);
			}
			currentAST = __currentAST516;
			_tree = __t516;
			_tree = _tree.getNextSibling();
			syntax_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_tree != null) {
				_tree = _tree.getNextSibling();
			}
		}
		returnAST = syntax_AST;
		_retTree = _tree;
	}

	public final void language_version_id(AST _t) throws RecognitionException {

		AST language_version_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST language_version_id_AST = null;

		try { // for error handling
			AST __t526 = _t;
			AST tmp276_AST = null;
			AST tmp276_AST_in = null;
			tmp276_AST = astFactory.create((AST) _t);
			tmp276_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp276_AST);
			ASTPair __currentAST526 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.LANGUAGE_VERSION_ID);
			_t = _t.getFirstChild();
			nothing(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST526;
			_t = __t526;
			_t = _t.getNextSibling();
			language_version_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = language_version_id_AST;
		_retTree = _t;
	}

	public final void syntax_pass2(AST _t) throws RecognitionException {

		AST syntax_pass2_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST syntax_pass2_AST = null;

		try { // for error handling
			AST __t521 = _t;
			AST tmp277_AST = null;
			AST tmp277_AST_in = null;
			tmp277_AST = astFactory.create((AST) _t);
			tmp277_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp277_AST);
			ASTPair __currentAST521 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SYNTAX);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LANGUAGE_VERSION_ID: {
					language_version_id(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SCHEMA_DECL: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			schema_decl(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				_loop524: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.SCHEMA_DECL.getIndex())) {
						schema_decl(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					} else {
						break _loop524;
					}

				} while (true);
			}
			currentAST = __currentAST521;
			_t = __t521;
			_t = _t.getNextSibling();
			syntax_pass2_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = syntax_pass2_AST;
		_retTree = _t;
	}

	public final void multiplication_like_op(AST _t) throws RecognitionException {

		AST multiplication_like_op_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiplication_like_op_AST = null;

		try { // for error handling
			AST __t532 = _t;
			AST tmp278_AST = null;
			AST tmp278_AST_in = null;
			tmp278_AST = astFactory.create((AST) _t);
			tmp278_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp278_AST);
			ASTPair __currentAST532 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.MULTIPLICATION_LIKE_OP);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case STAR: {
					AST tmp279_AST = null;
					AST tmp279_AST_in = null;
					tmp279_AST = astFactory.create((AST) _t);
					tmp279_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp279_AST);
					match(_t, Express2DictWalkerTokenTypes.STAR);
					_t = _t.getNextSibling();
					break;
				}
				case DIVSIGN: {
					AST tmp280_AST = null;
					AST tmp280_AST_in = null;
					tmp280_AST = astFactory.create((AST) _t);
					tmp280_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp280_AST);
					match(_t, Express2DictWalkerTokenTypes.DIVSIGN);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_div: {
					AST tmp281_AST = null;
					AST tmp281_AST_in = null;
					tmp281_AST = astFactory.create((AST) _t);
					tmp281_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp281_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_div);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_mod: {
					AST tmp282_AST = null;
					AST tmp282_AST_in = null;
					tmp282_AST = astFactory.create((AST) _t);
					tmp282_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp282_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_mod);
					_t = _t.getNextSibling();
					break;
				}
				case LITERAL_and: {
					AST tmp283_AST = null;
					AST tmp283_AST_in = null;
					tmp283_AST = astFactory.create((AST) _t);
					tmp283_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp283_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_and);
					_t = _t.getNextSibling();
					break;
				}
				case DOUBLEBAR: {
					AST tmp284_AST = null;
					AST tmp284_AST_in = null;
					tmp284_AST = astFactory.create((AST) _t);
					tmp284_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp284_AST);
					match(_t, Express2DictWalkerTokenTypes.DOUBLEBAR);
					_t = _t.getNextSibling();
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST532;
			_t = __t532;
			_t = _t.getNextSibling();
			multiplication_like_op_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = multiplication_like_op_AST;
		_retTree = _t;
	}

	public final UnderlyingType underlying_type_decl(AST _t, String TypeName) throws RecognitionException {
		UnderlyingType ut = null;

		AST underlying_type_decl_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST underlying_type_decl_AST = null;

		String UTN = "";

		try { // for error handling
			AST __t538 = _t;
			AST tmp285_AST = null;
			AST tmp285_AST_in = null;
			tmp285_AST = astFactory.create((AST) _t);
			tmp285_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp285_AST);
			ASTPair __currentAST538 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.UNDERLYING_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONSTRUCTED_TYPES: {
					constructed_types(_t, TypeName);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					// System.out.println ("ENUMERATION"+TypeName);

					break;
				}
				case AGGREGATION_TYPES: {
					aggregation_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SIMPLE_TYPES: {
					ut = simple_types_decl_bt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					break;
				}
				case TYPE_REF: {
					UTN = type_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					if (isPass2()) {
						// TODO add Type Reference here
						ut = schema.getTypeBN(UTN);
						System.err.println(TypeName + "PASS 2 get TYPEREF:" + UTN);

					} else {
						System.err.println("PASS one:" + TypeName);
					}

					// UnderlyingTypeName="UNDERLYING_TYPE"+UnderlyingTypeName;
					// System.out.println("debug"+UnderlyingTypeName);

					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST538;
			_t = __t538;
			_t = _t.getNextSibling();
			underlying_type_decl_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = underlying_type_decl_AST;
		_retTree = _t;
		return ut;
	}

	public final void constructed_types(AST _t, String TypeName) throws RecognitionException {

		AST constructed_types_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constructed_types_AST = null;

		List ItemList = new ArrayList();

		try { // for error handling
			AST __t544 = _t;
			AST tmp286_AST = null;
			AST tmp286_AST_in = null;
			tmp286_AST = astFactory.create((AST) _t);
			tmp286_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp286_AST);
			ASTPair __currentAST544 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.CONSTRUCTED_TYPES);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENUMERATION_TYPE: {
					ItemList = enumeration_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					EnumerationType et;
					if (pass == 1) {
						et = new EnumerationType(TypeName);
						schema.addType(et);
					} else if (pass == 2) {
						et = (EnumerationType) schema.getTypeBN(TypeName);
						Iterator li = ItemList.iterator();
						while (li.hasNext()) {
							Object o = li.next();
							et.addElement(o.toString());
						}
					}

					break;
				}
				case SELECT_TYPE: {
					ItemList = select_type(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					SelectType st;
					// in the first pass, create the type for further use
					if (pass == 1) {

						st = new SelectType(TypeName);
						schema.addType(st);
					}
					// in the second one, get it from the schema and fill in the
					// actual selections
					if (isPass2()) {
						st = (SelectType) schema.getTypeBN(TypeName);
						Iterator li = ItemList.iterator();
						while (li.hasNext()) {
							Object o = li.next();

							// SELECT types can either be ENTITYs or TYPEs, so
							// check which one it it s and add it
							NamedType nt = schema.getTypeBN(o.toString());
							if (nt == null)
								nt = schema.getEntityBN(o.toString());
							if (nt != null)
								st.addSelection(nt);

						}

					}

					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST544;
			_t = __t544;
			_t = _t.getNextSibling();
			constructed_types_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = constructed_types_AST;
		_retTree = _t;
	}

	public final String underlying_type(AST _t, String TypeName) throws RecognitionException {
		String UnderlyingTypeName = "";

		AST underlying_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST underlying_type_AST = null;

		String UTN = "";

		try { // for error handling
			AST __t541 = _t;
			AST tmp287_AST = null;
			AST tmp287_AST_in = null;
			tmp287_AST = astFactory.create((AST) _t);
			tmp287_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp287_AST);
			ASTPair __currentAST541 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.UNDERLYING_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case CONSTRUCTED_TYPES: {
					constructed_types(_t, TypeName);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					// System.out.println ("ENUMERATION"+TypeName);

					break;
				}
				case AGGREGATION_TYPES: {
					aggregation_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SIMPLE_TYPES: {
					UnderlyingTypeName = simple_types(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					break;
				}
				case TYPE_REF: {
					UnderlyingTypeName = type_ref(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);

					if (isPass2()) {
						// TODO add Type Reference here
					}

					// UnderlyingTypeName="UNDERLYING_TYPE"+UnderlyingTypeName;
					// System.out.println("debug"+UnderlyingTypeName);

					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST541;
			_t = __t541;
			_t = _t.getNextSibling();

			if (UnderlyingTypeName.indexOf("IfcPositiveLength") > -1) {
				System.out.println("test");
			}

			underlying_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = underlying_type_AST;
		_retTree = _t;
		return UnderlyingTypeName;
	}

	public final List enumeration_type(AST _t) throws RecognitionException {
		List ItemList = new ArrayList();

		AST enumeration_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_type_AST = null;

		// String[] Items;

		try { // for error handling
			AST __t547 = _t;
			AST tmp288_AST = null;
			AST tmp288_AST_in = null;
			tmp288_AST = astFactory.create((AST) _t);
			tmp288_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp288_AST);
			ASTPair __currentAST547 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENUMERATION_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_extensible: {
					AST tmp289_AST = null;
					AST tmp289_AST_in = null;
					tmp289_AST = astFactory.create((AST) _t);
					tmp289_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp289_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_extensible);
					_t = _t.getNextSibling();
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case ENUMERATION_ITEMS:
				case ENUMERATION_EXTENSION: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENUMERATION_ITEMS:
				case ENUMERATION_EXTENSION: {
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case ENUMERATION_ITEMS: {
							ItemList = enumeration_items(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case ENUMERATION_EXTENSION: {
							enumeration_extension(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST547;
			_t = __t547;
			_t = _t.getNextSibling();
			enumeration_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = enumeration_type_AST;
		_retTree = _t;
		return ItemList;
	}

	public final List select_type(AST _t) throws RecognitionException {
		List items = new ArrayList();
		;

		AST select_type_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_type_AST = null;

		try { // for error handling
			AST __t561 = _t;
			AST tmp290_AST = null;
			AST tmp290_AST_in = null;
			tmp290_AST = astFactory.create((AST) _t);
			tmp290_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp290_AST);
			ASTPair __currentAST561 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SELECT_TYPE);
			_t = _t.getFirstChild();
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_extensible: {
					AST tmp291_AST = null;
					AST tmp291_AST_in = null;
					tmp291_AST = astFactory.create((AST) _t);
					tmp291_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp291_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_extensible);
					_t = _t.getNextSibling();
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case SELECT_LIST:
				case SELECT_EXTENSION:
				case LITERAL_generic_entity: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case LITERAL_generic_entity: {
					AST tmp292_AST = null;
					AST tmp292_AST_in = null;
					tmp292_AST = astFactory.create((AST) _t);
					tmp292_AST_in = (AST) _t;
					astFactory.addASTChild(currentAST, tmp292_AST);
					match(_t, Express2DictWalkerTokenTypes.LITERAL_generic_entity);
					_t = _t.getNextSibling();
					break;
				}
				case NULL_TREE_LOOKAHEAD:
				case SELECT_LIST:
				case SELECT_EXTENSION: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SELECT_LIST:
				case SELECT_EXTENSION: {
					{
						if (_t == null)
							_t = ASTNULL;
						switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
						case SELECT_LIST: {
							items = select_list(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case SELECT_EXTENSION: {
							select_extension(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default: {
							throw new NoViableAltException(_t);
						}
						}
					}
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST561;
			_t = __t561;
			_t = _t.getNextSibling();
			select_type_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = select_type_AST;
		_retTree = _t;
		return items;
	}

	public final List enumeration_items(AST _t) throws RecognitionException {
		List items = new ArrayList();

		AST enumeration_items_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_items_AST = null;

		String id0, id;

		try { // for error handling
			AST __t552 = _t;
			AST tmp293_AST = null;
			AST tmp293_AST_in = null;
			tmp293_AST = astFactory.create((AST) _t);
			tmp293_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp293_AST);
			ASTPair __currentAST552 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENUMERATION_ITEMS);
			_t = _t.getFirstChild();
			id0 = enumeration_id(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			items.add(id0);
			{
				_loop554: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.ENUMERATION_ID.getIndex())) {
						id = enumeration_id(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
						items.add(id);
					} else {
						break _loop554;
					}

				} while (true);
			}
			currentAST = __currentAST552;
			_t = __t552;
			_t = _t.getNextSibling();
			enumeration_items_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = enumeration_items_AST;
		_retTree = _t;
		return items;
	}

	public final void enumeration_extension(AST _t) throws RecognitionException {

		AST enumeration_extension_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_extension_AST = null;

		try { // for error handling
			AST __t556 = _t;
			AST tmp294_AST = null;
			AST tmp294_AST_in = null;
			tmp294_AST = astFactory.create((AST) _t);
			tmp294_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp294_AST);
			ASTPair __currentAST556 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENUMERATION_EXTENSION);
			_t = _t.getFirstChild();
			type_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case ENUMERATION_ITEMS: {
					enumeration_items(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST556;
			_t = __t556;
			_t = _t.getNextSibling();
			enumeration_extension_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = enumeration_extension_AST;
		_retTree = _t;
	}

	public final String enumeration_id(AST _t) throws RecognitionException {
		String identifier = "";

		AST enumeration_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumeration_id_AST = null;
		AST id = null;
		AST id_AST = null;

		try { // for error handling
			AST __t559 = _t;
			AST tmp295_AST = null;
			AST tmp295_AST_in = null;
			tmp295_AST = astFactory.create((AST) _t);
			tmp295_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp295_AST);
			ASTPair __currentAST559 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.ENUMERATION_ID);
			_t = _t.getFirstChild();
			id = (AST) _t;
			AST id_AST_in = null;
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			identifier = id.getText();
			currentAST = __currentAST559;
			_t = __t559;
			_t = _t.getNextSibling();
			enumeration_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = enumeration_id_AST;
		_retTree = _t;
		return identifier;
	}

	public final List select_list(AST _t) throws RecognitionException {
		List items = new ArrayList();

		AST select_list_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;

		String id0, id;

		try { // for error handling
			AST __t567 = _t;
			AST tmp296_AST = null;
			AST tmp296_AST_in = null;
			tmp296_AST = astFactory.create((AST) _t);
			tmp296_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp296_AST);
			ASTPair __currentAST567 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SELECT_LIST);
			_t = _t.getFirstChild();
			id0 = named_types(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			items.add(id0);
			{
				_loop569: do {
					if (_t == null)
						_t = ASTNULL;
					if ((_t.getType() == Express2DictWalkerTokenTypes.NAMED_TYPES.getIndex())) {
						id = named_types(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
						items.add(id);
					} else {
						break _loop569;
					}

				} while (true);
			}
			currentAST = __currentAST567;
			_t = __t567;
			_t = _t.getNextSibling();
			select_list_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = select_list_AST;
		_retTree = _t;
		return items;
	}

	public final void select_extension(AST _t) throws RecognitionException {

		AST select_extension_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_extension_AST = null;

		try { // for error handling
			AST __t571 = _t;
			AST tmp297_AST = null;
			AST tmp297_AST_in = null;
			tmp297_AST = astFactory.create((AST) _t);
			tmp297_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp297_AST);
			ASTPair __currentAST571 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.SELECT_EXTENSION);
			_t = _t.getFirstChild();
			type_ref(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			{
				if (_t == null)
					_t = ASTNULL;
				switch (Express2DictWalkerTokenTypes.getToken(_t.getType())) {
				case SELECT_LIST: {
					select_list(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NULL_TREE_LOOKAHEAD: {
					break;
				}
				default: {
					throw new NoViableAltException(_t);
				}
				}
			}
			currentAST = __currentAST571;
			_t = __t571;
			_t = _t.getNextSibling();
			select_extension_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = select_extension_AST;
		_retTree = _t;
	}

	public final void type_label_id(AST _t) throws RecognitionException {

		AST type_label_id_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_id_AST = null;

		try { // for error handling
			AST __t578 = _t;
			AST tmp298_AST = null;
			AST tmp298_AST_in = null;
			tmp298_AST = astFactory.create((AST) _t);
			tmp298_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp298_AST);
			ASTPair __currentAST578 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TYPE_LABEL_ID);
			_t = _t.getFirstChild();
			AST tmp299_AST = null;
			AST tmp299_AST_in = null;
			tmp299_AST = astFactory.create((AST) _t);
			tmp299_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp299_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST578;
			_t = __t578;
			_t = _t.getNextSibling();
			type_label_id_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = type_label_id_AST;
		_retTree = _t;
	}

	public final void width(AST _t) throws RecognitionException {

		AST width_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST width_AST = null;

		try { // for error handling
			AST __t593 = _t;
			AST tmp300_AST = null;
			AST tmp300_AST_in = null;
			tmp300_AST = astFactory.create((AST) _t);
			tmp300_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp300_AST);
			ASTPair __currentAST593 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.WIDTH);
			_t = _t.getFirstChild();
			numeric_expression(_t);
			_t = _retTree;
			astFactory.addASTChild(currentAST, returnAST);
			currentAST = __currentAST593;
			_t = __t593;
			_t = _t.getNextSibling();
			width_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = width_AST;
		_retTree = _t;
	}

	public final void type_label_ref(AST _t) throws RecognitionException {

		AST type_label_ref_AST_in = handleNullTree(_t);
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_label_ref_AST = null;

		try { // for error handling
			AST __t618 = _t;
			AST tmp301_AST = null;
			AST tmp301_AST_in = null;
			tmp301_AST = astFactory.create((AST) _t);
			tmp301_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp301_AST);
			ASTPair __currentAST618 = currentAST.copy();
			currentAST.root = currentAST.child;
			currentAST.child = null;
			match(_t, Express2DictWalkerTokenTypes.TYPE_LABEL_REF);
			_t = _t.getFirstChild();
			AST tmp302_AST = null;
			AST tmp302_AST_in = null;
			tmp302_AST = astFactory.create((AST) _t);
			tmp302_AST_in = (AST) _t;
			astFactory.addASTChild(currentAST, tmp302_AST);
			match(_t, Express2DictWalkerTokenTypes.IDENT);
			_t = _t.getNextSibling();
			currentAST = __currentAST618;
			_t = __t618;
			_t = _t.getNextSibling();
			type_label_ref_AST = (AST) currentAST.root;
		} catch (RecognitionException ex) {
			reportError(ex);
			if (_t != null) {
				_t = _t.getNextSibling();
			}
		}
		returnAST = type_label_ref_AST;
		_retTree = _t;
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
			"\"where\"", "\"while\"", "\"fixed\"", "a comment", "a EXPRESS one line comment", "&", "@", "white space", "a digit", "\"SELF\\\\\"", "\".\"", "\"\"" };

}
