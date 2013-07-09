header { 
  package net.sourceforge.osexpress.parser;

  import java.io.*;
  import java.util.Vector;
  import java.util.Hashtable;
 }

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

/* This grammar is the result of merging 2 grammars. 
The first one is a
degenerative grammar used to record ids, the second is the actual grammar
generating the parse tree. */

class ExpressParser extends Parser;
options {
        k=1;
	buildAST=true;
}

tokens {
	/* id types */
        CONSTANT_IDENT;
        ENTITY_IDENT;
        FUNCTION_IDENT;
        PROCEDURE_IDENT;
        PARAMETER_IDENT;
        SCHEMA_IDENT;
        TYPE_IDENT;
        VARIABLE_IDENT;
        ENUMERATION_IDENT;
        ATTRIBUTE_IDENT;
	ENTITY_ATTR_IDENT;
	TYPE_ATTR_IDENT;
	ENTITY_VAR_IDENT;
	TYPE_VAR_IDENT;
	ENTITY_PARAM_IDENT;
	TYPE_PARAM_IDENT;
	/* id types Express V2 */
	SUBTYPE_CONSTRAINT_ID;

	/* nodes types */
	ACTUAL_PARAMETER_LIST; ADD_LIKE_OP; AGGREGATE_INITIALIZER; 
	AGGREGATE_SOURCE; AGGREGATE_TYPE; AGGREGATION_TYPES; ALGORITHM_HEAD; 
	ALIAS_STMT; ARRAY_TYPE; ASSIGNMENT_STMT; BAG_TYPE; BASE_TYPE; 
	BINARY_TYPE; BOOLEAN_TYPE; BOUND_1; BOUND_2; BOUND_SPEC; 
	BUILT_IN_CONSTANT; BUILT_IN_FUNCTION; BUILT_IN_PROCEDURE; CASE_ACTION;
 	CASE_LABEL; CASE_STMT; COMPOUND_STMT; CONSTANT_BODY; CONSTANT_DECL; 
	CONSTANT_FACTOR; CONSTANT_ID; DECLARATION; DOMAIN_RULE; ELEMENT; 
	ENTITY_HEAD; ENTITY_DECL; ENTITY_BODY; SUBSUPER; SUPERTYPE_CONSTRAINT;
 	ABSTRACT_SUPERTYPE_DECLARATION; SUBTYPE_DECLARATION; EXPLICIT_ATTR; 
	ATTRIBUTE_DECL; ATTRIBUTE_ID; QUALIFIED_ATTRIBUTE; DERIVE_CLAUSE; 
	DERIVED_ATTR; INVERSE_CLAUSE; INVERSE_ATTR; UNIQUE_CLAUSE; UNIQUE_RULE;
 	REFERENCED_ATTRIBUTE; ENTITY_CONSTRUCTOR; ENTITY_ID; 
	ENUMERATION_REFERENCE; ESCAPE_STMT; EXPRESSION; FACTOR; 
	FORMAL_PARAMETER; ATTRIBUTE_QUALIFIER; FUNCTION_CALL; FUNCTION_DECL; 
	FUNCTION_HEAD; FUNCTION_ID; GENERALIZED_TYPES; 
	GENERAL_AGGREGATION_TYPES; GENERAL_ARRAY_TYPE; GENERAL_BAG_TYPE; 
	GENERAL_LIST_TYPE; GENERAL_REF; GENERAL_SET_TYPE; GENERIC_TYPE; 
	GROUP_QUALIFIER; IF_STMT; INCREMENT; INCREMENT_CONTROL; INDEX; INDEX_1;
 	INDEX_2; INDEX_QUALIFIER; INTEGER_TYPE; INTERVAL; INTERVAL_HIGH; 
	INTERVAL_ITEM; INTERVAL_LOW; INTERVAL_OP; LABEL; LIST_TYPE; LITERAL;
	REAL_LITERAL; INTEGER_LITERAL; STRING_LITERAL; 
	LOCAL_DECL; LOCAL_VARIABLE; LOGICAL_EXPRESSION; LOGICAL_LITERAL; 
	LOGICAL_TYPE; MULTIPLICATION_LIKE_OP; NAMED_TYPES; NULL_STMT; 
	NUMBER_TYPE; NUMERIC_EXPRESSION; ONE_OF; PARAMETER; PARAMETER_ID; 
	PARAMETER_TYPE; POPULATION; PRECISION_SPEC; PRIMARY; 
	PROCEDURE_CALL_STMT; PROCEDURE_DECL; PROCEDURE_HEAD; PROCEDURE_ID; 
	QUALIFIABLE_FACTOR; QUALIFIER; QUERY_EXPRESSION; REAL_TYPE; 
	REFERENCE_CLAUSE; REL_OP; REL_OP_EXTENDED; REPEAT_CONTROL; REPEAT_STMT;
	REPETITION; RESOURCE_OR_RENAME; RESOURCE_REF; RETURN_STMT; RULE_DECL;
	RULE_HEAD; RULE_ID; SCHEMA_ID; SCHEMA_BODY; SCHEMA_DECL; 
	INTERFACE_SPECIFICATION; USE_CLAUSE; NAMED_TYPE_OR_RENAME; SELECTOR; 
	SET_TYPE; SIMPLE_EXPRESSION; SIMPLE_FACTOR; SIMPLE_TYPES; SKIP_STMT; 
	STMT; STRING_TYPE; SUBTYPE_CONSTRAINT; SUPERTYPE_EXPRESSION; 
	SUPERTYPE_FACTOR; SUPERTYPE_RULE; SUPERTYPE_TERM; SYNTAX; TERM; 
	TYPE_DECL; UNDERLYING_TYPE; CONSTRUCTED_TYPES; ENUMERATION_TYPE; 
	ENUMERATION_ID; SELECT_TYPE; TYPE_ID; TYPE_LABEL; TYPE_LABEL_ID; 
	UNARY_OP; UNTIL_CONTROL; VARIABLE_ID; WHERE_CLAUSE; WHILE_CONTROL; 
	WIDTH; WIDTH_SPEC; ENTITY_REF; TYPE_REF; ENUMERATION_REF; 
	ATTRIBUTE_REF; CONSTANT_REF; FUNCTION_REF; PARAMETER_REF; VARIABLE_REF;
 	SCHEMA_REF; TYPE_LABEL_REF; PROCEDURE_REF; SIMPLE_ID; ELSE_CLAUSE;
	RENAME_ID;
	/* Express amendment nodes */
	ENUMERATION_ITEMS; ENUMERATION_EXTENSION;
	SELECT_LIST; SELECT_EXTENSION;
	REDECLARED_ATTRIBUTE;
	SUBTYPE_CONSTRAINT_DECL; SUBTYPE_CONSTRAINT_HEAD; SUBTYPE_CONSTRAINT_BODY;
	ABSTRACT_SUPERTYPE; TOTAL_OVER;	
	CONCRETE_TYPES;
	GENERIC_ENTITY_TYPE;
	SCHEMA_VERSION_ID;
	LANGUAGE_VERSION_ID;
}

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
}


actual_parameter_list 
             :  LPAREN!  parameter (  COMMA!  parameter )*  RPAREN!
		{ #actual_parameter_list = #([ACTUAL_PARAMETER_LIST, "ACTUAL_PARAMETER_LIST"], #actual_parameter_list); } 
             ;

add_like_op
             :  PLUS { #add_like_op = #([ADD_LIKE_OP, "ADD_LIKE_OP"], #add_like_op); }
             |  MINUS  { #add_like_op = #([ADD_LIKE_OP, "ADD_LIKE_OP"], #add_like_op); }
             |  "or"  { #add_like_op = #([ADD_LIKE_OP, "ADD_LIKE_OP"], #add_like_op); }
             |  "xor" { #add_like_op = #([ADD_LIKE_OP, "ADD_LIKE_OP"], #add_like_op); }
             ;

aggregate_initializer
             :  LBRACK!  (  element  (  COMMA!  element )*  )?  RBRACK!
		{ #aggregate_initializer = #([AGGREGATE_INITIALIZER, "AGGREGATE_INITIALIZER"], #aggregate_initializer); }
             ;

aggregate_source
             :  simple_expression
		{ #aggregate_source = #([AGGREGATE_SOURCE, "AGGREGATE_SOURCE"], #aggregate_source); } 
             ;

aggregate_type
             :  "aggregate"!  (  COLON!  type_label )?  "of"!  parameter_type
	        { #aggregate_type = #([AGGREGATE_TYPE, "AGGREGATE_TYPE"], #aggregate_type); }
             ;

aggregation_types
             :  array_type { #aggregation_types = #([AGGREGATION_TYPES, "AGGREGATION_TYPES"], #aggregation_types); }
             |  bag_type  { #aggregation_types = #([AGGREGATION_TYPES, "AGGREGATION_TYPES"], #aggregation_types); }
             |  list_type { #aggregation_types = #([AGGREGATION_TYPES, "AGGREGATION_TYPES"], #aggregation_types); } 
             |  set_type { #aggregation_types = #([AGGREGATION_TYPES, "AGGREGATION_TYPES"], #aggregation_types); }
             ;

algorithm_head
	     :  ( declaration )* ( constant_decl )? ( local_decl )?
		{ #algorithm_head = #([ALGORITHM_HEAD, "ALGORITHM_HEAD"], #algorithm_head); }
	     ;

alias_stmt
	     : { isFirst }? { newScope1(); } "alias" variable_id "for" IDENT ( qualifier )* SEMI stmt ( stmt )* "end_alias" { upScope(); } SEMI
             |  "alias"! variable_id "for"! general_ref ( qualifier )* SEMI! stmt ( stmt )* "end_alias"! { upScope(); } SEMI!
		{ #alias_stmt = #([ALIAS_STMT, "ALIAS_STMT"], #alias_stmt); }
	     ;

array_type
             :  "array"!  bound_spec  "of"!  (  "optional"! )?  (  "unique"! )?  base_type   { #array_type = #([ARRAY_TYPE, "ARRAY_TYPE"], #array_type); }
             ;

assignment_stmt
	     : ( general_ref  (  qualifier )* ) COLEQ!  expression  SEMI!
		{ #assignment_stmt = #([ASSIGNMENT_STMT, "ASSIGNMENT_STMT"], #assignment_stmt); }
             ;

bag_type
             :  "bag"!  (  bound_spec )?  "of"!  base_type
	      { #bag_type = #([BAG_TYPE, "BAG_TYPE"], #bag_type); } 
             ;

base_type
	     :  concrete_types { #base_type = #([BASE_TYPE, "BASE_TYPE"], #base_type); }
	     |  generalized_types { #base_type = #([BASE_TYPE, "BASE_TYPE"], #base_type); }
	     ;

concrete_types
	     :  aggregation_types { #concrete_types = #([CONCRETE_TYPES, "CONCRETE_TYPES"], #concrete_types); }
	     |  simple_types { #concrete_types = #([CONCRETE_TYPES, "CONCRETE_TYPES"], #concrete_types); }
	     |  named_types { #concrete_types = #([CONCRETE_TYPES, "CONCRETE_TYPES"], #concrete_types); }
	     ;


binary_type
             :  "binary"!  (  width_spec )?
		{ #binary_type = #([BINARY_TYPE, "BINARY_TYPE"], #binary_type); } 
             ;

boolean_type
             :  "boolean"! { #boolean_type = #([BOOLEAN_TYPE, "BOOLEAN_TYPE"], #boolean_type); }
             ;

bound_1
             :  numeric_expression { #bound_1 = #([BOUND_1, "BOUND_1"], #bound_1); }
             ;

bound_2
             :  numeric_expression { #bound_2 = #([BOUND_2, "BOUND_2"], #bound_2); }
             ;

bound_spec
             :  LBRACK!  bound_1  COLON!  bound_2  RBRACK!
		{ #bound_spec = #([BOUND_SPEC, "BOUND_SPEC"], #bound_spec); }
             ;

built_in_constant
             :  "const_e" { #built_in_constant = #([BUILT_IN_CONSTANT, "BUILT_IN_CONSTANT"], #built_in_constant); }
             |  "pi"     { #built_in_constant = #([BUILT_IN_CONSTANT, "BUILT_IN_CONSTANT"], #built_in_constant); }
             |  "self"   { #built_in_constant = #([BUILT_IN_CONSTANT, "BUILT_IN_CONSTANT"], #built_in_constant); }
             |  QUESTION { #built_in_constant = #([BUILT_IN_CONSTANT, "BUILT_IN_CONSTANT"], #built_in_constant); }
             |  STAR     { #built_in_constant = #([BUILT_IN_CONSTANT, "BUILT_IN_CONSTANT"], #built_in_constant); }
             ;

built_in_function
             :  "abs"  { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "acos" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "asin"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "atan" 	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "blength" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "cos"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "exists"{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "exp"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "format"  { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "hibound" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "hiindex" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             |  "length" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "lobound" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "loindex" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "log"  	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "log2"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "log10"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "nvl"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "odd" 	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "rolesof" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "sin"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "sizeof" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "sqrt"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "tan"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "typeof" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "usedin" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "value" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "value_in" { #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }	
             |  "value_unique"	{ #built_in_function = #([BUILT_IN_FUNCTION, "BUILT_IN_FUNCTIONS"], #built_in_function); }
             ;

built_in_procedure
             :  "insert"  { #built_in_procedure = #([BUILT_IN_PROCEDURE, "BUILT_IN_PROCEDURE"], #built_in_procedure); }	
             |  "remove"  { #built_in_procedure = #([BUILT_IN_PROCEDURE, "BUILT_IN_PROCEDURE"], #built_in_procedure); }	
             ;

case_action
             :  case_label  (  COMMA!  case_label )*  COLON!  stmt
	     { #case_action = #([CASE_ACTION, "CASE_ACTION"], #case_action); } 
             ;

case_label
             :  expression
	     { #case_label = #([CASE_LABEL, "CASE_LABEL"], #case_label); } 
             ;

case_stmt
             :  "case"!  selector  "of"!  (  case_action )*  (  "otherwise"!  COLON!  stmt )?  "end_case"!  SEMI!
		{ #case_stmt = #([CASE_STMT, "CASE_STMT"], #case_stmt); } 
             ;

compound_stmt
             :  "begin"!  stmt  ( stmt )*  "end"!  SEMI!
		{ #compound_stmt = #([COMPOUND_STMT, "COMPOUND_STMT"], #compound_stmt); } 
             ;

constant_body
             :  constant_id  COLON!  base_type  COLEQ!  expression  SEMI!
		{ #constant_body = #([CONSTANT_BODY, "CONSTANT_BODY"], #constant_body); } 
             ;

constant_decl
             :  "constant"!  constant_body ( constant_body )*  "end_constant"!  SEMI!
		{ #constant_decl = #([CONSTANT_DECL, "CONSTANT_DECL"], #constant_decl); } 
             ;

constant_factor
             :  built_in_constant  { #constant_factor = #([CONSTANT_FACTOR, "CONSTANT_FACTOR"], #constant_factor); }
             |  constant_ref  { #constant_factor = #([CONSTANT_FACTOR, "CONSTANT_FACTOR"], #constant_factor); }
             ;

constant_id
             :  { isFirst }? id:IDENT { addId(id.getText(),CONSTANT_IDENT); }
	     |  nid:CONSTANT_IDENT { #nid.setType(IDENT); #constant_id = #([CONSTANT_ID, "CONSTANT_ID"], #constant_id); } 
             ;

declaration
	     :  entity_decl { #declaration = #([DECLARATION, "DECLARATION"], #declaration); }
	     |  subtype_constraint_decl { #declaration = #([DECLARATION, "DECLARATION"], #declaration); }
             |  function_decl { #declaration = #([DECLARATION, "DECLARATION"], #declaration); } 
             |  procedure_decl { #declaration = #([DECLARATION, "DECLARATION"], #declaration); }
	     |  type_decl { #declaration = #([DECLARATION, "DECLARATION"], #declaration); }
             ;

domain_rule
	     : { isFirst&&(LA(2)!=COLON) }? logical_expression /* to avoid confusion with qualifiable_factor at first pass */
             |  ( label  COLON! )?  logical_expression
		{ #domain_rule = #([DOMAIN_RULE, "DOMAIN_RULE"], #domain_rule); } 
             ;

element
             :  expression  (  COLON!  repetition  )?
		{ #element = #([ELEMENT, "ELEMENT"], #element); } 
             ;

entity_head
	     { String id=null; }
	     :  "entity"! id=entity_id { newEntityScope(id); } ({ LA(2)!=LITERAL_supertype }? "abstract" )?  ( subsuper )? (SEMI!)?		{ #entity_head = #([ENTITY_HEAD, "ENTITY_HEAD"], #entity_head); }
	     ;

entity_decl
	     :  entity_head entity_body "end_entity"! { upScope(); } SEMI!
		{ #entity_decl = #([ENTITY_DECL, "ENTITY_DECL"], #entity_decl); }
	     ;

entity_body
	     :  (explicit_attr)* (derive_clause)? (inverse_clause)? (unique_clause)? (where_clause)?
		{ #entity_body = #([ENTITY_BODY, "ENTITY_BODY"], #entity_body); }
	     ;

subsuper
	     :  ( supertype_constraint )? ( subtype_declaration )?
		{ #subsuper = #([SUBSUPER, "SUBSUPER"], #subsuper); }
	     ;

supertype_constraint
	     :  abstract_supertype_declaration { #supertype_constraint = #([SUPERTYPE_CONSTRAINT, "SUPERTYPE_CONSTRAINT"], #supertype_constraint); }
	     |  supertype_rule { #supertype_constraint = #([SUPERTYPE_CONSTRAINT, "SUPERTYPE_CONSTRAINT"], #supertype_constraint); }
	     ;

abstract_supertype_declaration
	     :  "abstract"! "supertype"! ( subtype_constraint )?
		{ #abstract_supertype_declaration = #([ABSTRACT_SUPERTYPE_DECLARATION, "ABSTRACT_SUPERTYPE_DECLARATION"], #abstract_supertype_declaration); } 
	     ;

subtype_declaration
	     :  { isFirst }? "subtype" "of" LPAREN id:IDENT { addSuper(id.getText()); } ( COMMA id2:IDENT { addSuper(id2.getText()); } )* RPAREN (SEMI)?
	     |  "subtype"! "of"! LPAREN! entity_ref ( COMMA! entity_ref )* RPAREN! (SEMI!)?  { #subtype_declaration = #([SUBTYPE_DECLARATION, "SUBTYPE_DECLARATION"], #subtype_declaration); }
	     ;


subtype_constraint_decl
	     : subtype_constraint_head subtype_constraint_body "end_subtype_constraint"! SEMI!
	     { #subtype_constraint_decl = #([SUBTYPE_CONSTRAINT_DECL, "SUBTYPE_CONSTRAINT_DECL"], #subtype_constraint_decl); }
	     ;

subtype_constraint_head
	     : { isFirst }? "subtype_constraint" subtype_constraint_id "for" IDENT SEMI
	     | "subtype_constraint"! subtype_constraint_id "for"! entity_ref SEMI!
	    { #subtype_constraint_head = #([SUBTYPE_CONSTRAINT_HEAD, "SUBTYPE_CONSTRAINT_HEAD"], #subtype_constraint_head); }
	     ;

subtype_constraint_body 
	     : ( abstract_supertype )? ( total_over )? ( supertype_expression SEMI! )?
	    { #subtype_constraint_body = #([SUBTYPE_CONSTRAINT_BODY, "SUBTYPE_CONSTRAINT_BODY"], #subtype_constraint_body); }
	     ;

subtype_constraint_id
	     : { isFirst }? id:IDENT { addId(id.getText(),SUBTYPE_CONSTRAINT_ID); }
	     | id2:SUBTYPE_CONSTRAINT_ID
		{
		   #id2.setType(IDENT);
		   #subtype_constraint_id = #([SUBTYPE_CONSTRAINT_ID, "SUBTYPE_CONSTRAINT_ID"], #subtype_constraint_id);
		}
	     ; 

abstract_supertype
	     : "abstract"! "supertype"! SEMI!
	     { #abstract_supertype = #([ABSTRACT_SUPERTYPE, "ABSTRACT_SUPERTYPE"], #abstract_supertype); } 
	     ;

total_over
	     : { isFirst }? "total_over" LPAREN IDENT ( COMMA IDENT )* LPAREN SEMI
	     | "total_over"! LPAREN! entity_ref ( COMMA! entity_ref )* LPAREN! SEMI! 
	    { #total_over = #([TOTAL_OVER, "TOTAL_OVER"], #total_over); }
	     ;

explicit_attr
	     :  attribute_decl (COMMA! attribute_decl)* COLON! ("optional")? base_type SEMI!  { #explicit_attr = #([EXPLICIT_ATTR, "EXPLICIT_ATTR"], #explicit_attr); }
	     ;


attribute_decl
	     : attribute_id { #attribute_decl = #([ATTRIBUTE_DECL, "ATTRIBUTE_DECL"], #attribute_decl); }
	     | redeclared_attribute { #attribute_decl = #([ATTRIBUTE_DECL, "ATTRIBUTE_DECL"], #attribute_decl); }
	     ; 

redeclared_attribute
	     :  qualified_attribute ( "renamed"! attribute_id )?
	      { #redeclared_attribute = #([REDECLARED_ATTRIBUTE, "REDECLARED_ATTRIBUTE"], #redeclared_attribute); }
	     ;

attribute_id
	     :  { isFirst }? id:IDENT { addId(id.getText(),ATTRIBUTE_IDENT); }
	     |  nid1:ATTRIBUTE_IDENT { #nid1.setType(IDENT); #attribute_id = #([ATTRIBUTE_ID, "ATTRIBUTE_ID"], #attribute_id); }
	     |  nid2:ENTITY_ATTR_IDENT { #nid2.setType(IDENT); #attribute_id = #([ATTRIBUTE_ID, "ATTRIBUTE_ID"], #attribute_id); }
	     |  nid3:TYPE_ATTR_IDENT { #nid3.setType(IDENT); #attribute_id = #([ATTRIBUTE_ID, "ATTRIBUTE_ID"], #attribute_id); }
	     ;

qualified_attribute
	     :  "self"! group_qualifier attribute_qualifier
		{ #qualified_attribute = #([QUALIFIED_ATTRIBUTE, "QUALIFIED_ATTRIBUTE"], #qualified_attribute); }
	     ;

derive_clause
	     :  "derive"! derived_attr (derived_attr)*
		{ #derive_clause = #([DERIVE_CLAUSE, "DERIVE_CLAUSE"], #derive_clause); }
	     ;

derived_attr
	     :  attribute_decl COLON! base_type COLEQ! expression SEMI!
	      { #derived_attr = #([DERIVED_ATTR, "DERIVED_ATTR"], #derived_attr); }
	     ;

inverse_clause
	     :  "inverse"! inverse_attr (inverse_attr)*
	      { #inverse_clause = #([INVERSE_CLAUSE, "INVERSE_CLAUSE"], #inverse_clause); }
	     ;

inverse_attr
	     :  { isFirst }? attribute_decl COLON ( ( "set" | "bag" ) ( bound_spec )? "of" )? IDENT "for" IDENT SEMI
	     |  attribute_decl COLON! ( ( "set" | "bag" ) ( bound_spec )? "of"! )? entity_ref "for"!  global_ident /* attribute_ref */ SEMI!
		{ #inverse_attr = #([INVERSE_ATTR, "INVERSE_ATTR"], #inverse_attr); }
	     ;

unique_clause
	     :  "unique"! unique_rule SEMI! ( unique_rule SEMI! )*
		{ #unique_clause = #([UNIQUE_CLAUSE, "UNIQUE_CLAUSE"], #unique_clause); }
	     ;

unique_rule
	     : { isFirst }? ( IDENT ( COLON referenced_attribute )? | qualified_attribute ) ( COMMA referenced_attribute )*
	     |  ( label COLON! )? referenced_attribute ( COMMA! referenced_attribute)*		{ #unique_rule = #([UNIQUE_RULE, "UNIQUE_RULE"], #unique_rule); }
	     ;

referenced_attribute
	     :  { isFirst }? IDENT
	     |  attribute_ref { #referenced_attribute = #([REFERENCED_ATTRIBUTE, "REFERENCED_ATTRIBUTE"], #referenced_attribute); }
	     |  qualified_attribute { #referenced_attribute = #([REFERENCED_ATTRIBUTE, "REFERENCED_ATTRIBUTE"], #referenced_attribute); }
	     ;



entity_constructor
             :  entity_ref LPAREN!  (  expression  (  COMMA!  expression  )*  )?  RPAREN!
		{ #entity_constructor = #([ENTITY_CONSTRUCTOR, "ENTITY_CONSTRUCTOR"], #entity_constructor); }
             ;

entity_id returns [String eid]
	     { eid=null; }
	     : { isFirst }? id:IDENT { eid=id.getText(); addId(eid,ENTITY_IDENT); }
             |  id2:ENTITY_IDENT { eid=id2.getText();
		#id2.setType(IDENT); 
		#entity_id = #([ENTITY_ID, "ENTITY_ID"], #entity_id);
		}
             ;

enumeration_reference
	     : { isFirst }? IDENT ( DOT IDENT)?
             | (  type_ref  DOT! )?  enumeration_ref
		{ #enumeration_reference = #([ENUMERATION_REFERENCE, "ENUMERATION_REFERENCE"], #enumeration_reference); }
             ;

escape_stmt
             :  "escape"!  SEMI!
	     { #escape_stmt = #([ESCAPE_STMT, "ESCAPE_STMT"], #escape_stmt); } 
             ;

expression
             :  simple_expression  (  rel_op_extended  simple_expression  )?
	     { #expression = #([EXPRESSION, "EXPRESSION"], #expression); } 
             ;

factor
             :  simple_factor  (  DOUBLESTAR!  simple_factor  )?
	     { #factor = #([FACTOR, "FACTOR"], #factor); } 
             ;

formal_parameter
             :  parameter_id  (  COMMA!  parameter_id  )*  COLON!  parameter_type 
	     { #formal_parameter = #([FORMAL_PARAMETER, "FORMAL_PARAMETER"], #formal_parameter); }
             ;

attribute_qualifier
             : DOT!  global_ident
	     { #attribute_qualifier = #([ATTRIBUTE_QUALIFIER, "ATTRIBUTE_QUALIFIER"], #attribute_qualifier); }
             ; 

function_call
             :  (  built_in_function  |  function_ref  )  (  actual_parameter_list  )?
	     { #function_call = #([FUNCTION_CALL, "FUNCTION_CALL"], #function_call); } 
             ;

function_decl
             :  function_head ( algorithm_head)?  stmt  (  stmt  )*  "end_function"!  SEMI! { upScope(); #function_decl = #([FUNCTION_DECL, "FUNCTION_DECL"], #function_decl); }
             ;

function_head
             :  "function"!  function_id { newScope(); } (  LPAREN!  formal_parameter  (  SEMI!  formal_parameter  )*  RPAREN!  )?  COLON!  parameter_type  SEMI!
	     { #function_head = #([FUNCTION_HEAD, "FUNCTION_HEAD"], #function_head); } 
             ;

function_id
	     : { isFirst }? id:IDENT { addId(id.getText(),FUNCTION_IDENT); }
             |  nid:FUNCTION_IDENT
	     { #nid.setType(IDENT); #function_id = #([FUNCTION_ID, "FUNCTION_ID"], #function_id); } 
             ;

generalized_types
             :  aggregate_type { #generalized_types = #([GENERALIZED_TYPES, "GENERALIZED_TYPES"], #generalized_types); } 
             |  general_aggregation_types  { #generalized_types = #([GENERALIZED_TYPES, "GENERALIZED_TYPES"], #generalized_types); }
             |  generic_type { #generalized_types = #([GENERALIZED_TYPES, "GENERALIZED_TYPES"], #generalized_types); }
	     |  generic_entity_type { #generalized_types = #([GENERALIZED_TYPES, "GENERALIZED_TYPES"], #generalized_types); }
             ;

general_aggregation_types
             :  general_array_type  { #general_aggregation_types = #([GENERAL_AGGREGATION_TYPES, "GENERAL_AGGREGATION_TYPES"], #general_aggregation_types); }
             |  general_bag_type  { #general_aggregation_types = #([GENERAL_AGGREGATION_TYPES, "GENERAL_AGGREGATION_TYPES"], #general_aggregation_types); }
             |  general_list_type  { #general_aggregation_types = #([GENERAL_AGGREGATION_TYPES, "GENERAL_AGGREGATION_TYPES"], #general_aggregation_types); }
             |  general_set_type { #general_aggregation_types = #([GENERAL_AGGREGATION_TYPES, "GENERAL_AGGREGATION_TYPES"], #general_aggregation_types); }
             ;

general_array_type
             :  "array"!  (  bound_spec  )?  "of"!  (  "optional"  )?  (  "unique"  )?  parameter_type
	     { #general_array_type = #([GENERAL_ARRAY_TYPE, "GENERAL_ARRAY_TYPE"], #general_array_type); } 
             ;

general_bag_type
             :  "bag"!  (  bound_spec  )?  "of"!  parameter_type
	     { #general_bag_type = #([GENERAL_BAG_TYPE, "GENERAL_BAG_TYPE"], #general_bag_type); } 
             ;

general_list_type
             :  "list"!  (  bound_spec  )?  "of"!  (  "unique"  )?  parameter_type
	     { #general_list_type = #([GENERAL_LIST_TYPE, "GENERAL_LIST_TYPE"], #general_list_type); } 
             ;

general_ref
             :  parameter_ref { #general_ref = #([GENERAL_REF, "GENERAL_REF"], #general_ref); }
             |  variable_ref  { #general_ref = #([GENERAL_REF, "GENERAL_REF"], #general_ref); }
             ;

general_set_type
             :  "set"!  (  bound_spec  )?  "of"!  parameter_type
	     { #general_set_type = #([GENERAL_SET_TYPE, "GENERAL_SET_TYPE"], #general_set_type); } 
             ;

generic_type
             :  "generic"!  (  COLON!  type_label  )?
	     { #generic_type = #([GENERIC_TYPE, "GENERAL_TYPE"], #generic_type); } 
             ;

generic_entity_type
	     : "generic_entity"!
	      { #generic_entity_type = #([GENERIC_ENTITY_TYPE, "GENERIC_ENTITY_TYPE"], #generic_entity_type); }
	     ;

group_qualifier
	     :  { isFirst }? BACKSLASH IDENT
             |  BACKSLASH!  entity_ref
	     { #group_qualifier = #([GROUP_QUALIFIER, "GROUP_QUALIFIER"], #group_qualifier); }
             ;

if_stmt
             :  "if"!  logical_expression  "then"!  stmt  (  stmt  )*  ( else_clause )?  "end_if"!  SEMI!
	     { #if_stmt = #([IF_STMT, "IF_STMT"], #if_stmt); } 
             ;

/* added rule (and node) to break a nondeterminism (stmt) */
else_clause
	     :  "else"! stmt ( stmt )*
		{ #else_clause = #([ELSE_CLAUSE, "ELSE_CLAUSE"], #else_clause); }
	     ;

increment
             :  numeric_expression 
	     { #increment = #([INCREMENT, "INCREMENT"], #increment); }
             ;

increment_control
             :  variable_id  COLEQ!  bound_1  "to"!  bound_2  (  "by"!  increment  )?
	     { #increment_control = #([INCREMENT_CONTROL, "INCREMENT_CONTROL"], #increment_control); } 
             ;

index
             :  numeric_expression 
	     { #index = #([INDEX, "INDEX"], #index); }
             ;

index_1
             :  index 
	     { #index_1 = #([INDEX_1, "INDEX_1"], #index_1); }
             ;

index_2
             :  index 
	     { #index_2 = #([INDEX_2, "INDEX_2"], #index_2); }
             ;

index_qualifier
             :  LBRACK!  index_1  (  COLON!  index_2  )?  RBRACK!
	     { #index_qualifier = #([INDEX_QUALIFIER, "INDEX_QUALIFIER"], #index_qualifier); } 
             ;

integer_type
             :  "integer"!
	     { #integer_type = #([INTEGER_TYPE, "INTEGER_TYPE"], #integer_type); } 
             ;

interval
             :  LCURLY!  interval_low  interval_op  interval_item  interval_op  interval_high  RCURLY!
	     { #interval = #([INTERVAL, "INTERVAL"], #interval); } 
             ;

interval_high
             :  simple_expression 
	     { #interval_high = #([INTERVAL_HIGH, "INTERVAL_HIGH"],#interval_high); }
             ;

interval_item
             :  simple_expression 
	     { #interval_item = #([INTERVAL_ITEM, "INTERVAL_ITEM"],#interval_item); }
             ;

interval_low
             :  simple_expression 
	     { #interval_low = #([INTERVAL_LOW, "INTERVAL_LOW"],#interval_low); }
             ;

interval_op
             :  LT { #interval_op = #([INTERVAL_OP, "INTERVAL_OP"],#interval_op); }  
             |  LE { #interval_op = #([INTERVAL_OP, "INTERVAL_OP"],#interval_op); }
             ;

label
             :  IDENT
	     { #label = #([LABEL, "LABEL"], #label); } 
             ;

list_type
             :  "list"!  (  bound_spec  )?  "of"!  (  "unique"  )?  base_type
	     { #list_type = #([LIST_TYPE, "LIST_TYPE"], #list_type); } 
             ;

/* POD removed binary_literal */
literal!
	     { 
		boolean fl=false; 
	     }
             :  i:INT (f:FLOAT { fl=true; })? 
			{ if (fl) {
				#f.setText(i.getText()+f.getText());
				#literal = #([LITERAL, "LITERAL"], #([REAL_LITERAL, "REAL_LITERAL"], #f));
				}
			  else #literal = #([LITERAL, "LITERAL"], #([INTEGER_LITERAL, "INTEGER_LITERAL"], #i));
			}
             |  ll:logical_literal { #literal = #([LITERAL, "LITERAL"], #ll); } 
             |  sl:STRING { #literal = #([LITERAL, "LITERAL"], #([STRING_LITERAL, "STRING_LITERAL"], #sl)); } 
             ;

local_decl
             :  "local"!  local_variable  (  local_variable  )*  "end_local"!  SEMI!
	     { #local_decl = #([LOCAL_DECL, "LOCAL_DECL"], #local_decl); } 
             ;

local_variable
             :  variable_id  (  COMMA!  variable_id  )*  COLON!  parameter_type  (  COLEQ!  expression  )?  SEMI!
	     { #local_variable = #([LOCAL_VARIABLE, "LOCAL_VARIABLE"], #local_variable); } 
             ;

logical_expression
             :  expression 
	     { #logical_expression = #([LOGICAL_EXPRESSION, "LOGICAL_EXPRESSION"], #logical_expression); }
             ;

logical_literal
             :  "false"  { #logical_literal = #([LOGICAL_LITERAL, "LOGICAL_LITERAL"], #logical_literal); }
             |  "true"  { #logical_literal = #([LOGICAL_LITERAL, "LOGICAL_LITERAL"], #logical_literal); }
             |  "unknown" { #logical_literal = #([LOGICAL_LITERAL, "LOGICAL_LITERAL"], #logical_literal); }
             ;

logical_type
             :  "logical"!
	     { #logical_type = #([LOGICAL_TYPE, "LOGICAL_TYPE"], #logical_type); } 
             ;

multiplication_like_op
             :  STAR { #multiplication_like_op = #([MULTIPLICATION_LIKE_OP, "MULTIPLICATION_LIKE_OP"], #multiplication_like_op); }
             |  DIVSIGN { #multiplication_like_op = #([MULTIPLICATION_LIKE_OP, "MULTIPLICATION_LIKE_OP"], #multiplication_like_op); }
             |  "div" { #multiplication_like_op = #([MULTIPLICATION_LIKE_OP, "MULTIPLICATION_LIKE_OP"], #multiplication_like_op); }
             |  "mod"  { #multiplication_like_op = #([MULTIPLICATION_LIKE_OP, "MULTIPLICATION_LIKE_OP"], #multiplication_like_op); }
             |  "and"  { #multiplication_like_op = #([MULTIPLICATION_LIKE_OP, "MULTIPLICATION_LIKE_OP"], #multiplication_like_op); }
             |  DOUBLEBAR { #multiplication_like_op = #([MULTIPLICATION_LIKE_OP, "MULTIPLICATION_LIKE_OP"], #multiplication_like_op); }
             ;

named_types  
	     : { isFirst }? IDENT
             |  er:entity_ref { #named_types = #([NAMED_TYPES, "NAMED_TYPES"], #er); }
             |  tr:type_ref { #named_types = #([NAMED_TYPES, "NAMED_TYPES"], #tr); }
             ;
	     

null_stmt
             :  SEMI!
	      { #null_stmt = #([NULL_STMT, "NULL_STMT"], #null_stmt); }
             ;

number_type
             :  "number"!
	     { #number_type = #([NUMBER_TYPE, "NUMBER_TYPE"], #number_type); } 
             ;

numeric_expression
             :  simple_expression 
	     { #numeric_expression = #([NUMERIC_EXPRESSION, "NUMERIC_EXPRESSION"], #numeric_expression); }
             ;

one_of
             :  "oneof"!  LPAREN!  supertype_expression  (  COMMA!  supertype_expression  )*  RPAREN!
	     { #one_of = #([ONE_OF, "ONE_OF"], #one_of); } 
             ;

parameter
             :  expression 
	     { #parameter = #([PARAMETER, "PARAMETER"], #parameter); }
             ;

parameter_id
	     : { isFirst }? id:IDENT { addId(id.getText(), PARAMETER_IDENT); }
             |  nid:PARAMETER_IDENT { #nid.setType(IDENT); #parameter_id = #([PARAMETER_ID, "PARAMETER_ID"], #parameter_id); }
	     |  nid2:ENTITY_PARAM_IDENT { #nid2.setType(IDENT); #parameter_id = #([PARAMETER_ID, "PARAMETER_ID"], #parameter_id); }
	     |  nid3:TYPE_PARAM_IDENT { #nid3.setType(IDENT); #parameter_id = #([PARAMETER_ID, "PARAMETER_ID"], #parameter_id); } 
             ;

parameter_type
             :  generalized_types { #parameter_type = #([PARAMETER_TYPE, "PARAMETER_TYPE"], #parameter_type); } 
             |  named_types  { #parameter_type = #([PARAMETER_TYPE, "PARAMETER_TYPE"], #parameter_type); } 
             |  simple_types { #parameter_type = #([PARAMETER_TYPE, "PARAMETER_TYPE"], #parameter_type); } 
             ;

population
             :  entity_ref
	     { #population = #([POPULATION, "POPULATION"], #population); }
             ;

precision_spec
             :  numeric_expression 
	     { #precision_spec = #([PRECISION_SPEC, "PRECISION_SPEC"], #precision_spec); }
             ;

primary
             :  literal  { #primary = #([PRIMARY, "PRIMARY"], #primary); }
             |  qualifiable_factor (  qualifier  )* { #primary = #([PRIMARY, "PRIMARY"], #primary); }
             ;

procedure_call_stmt
	     : (  built_in_procedure  |  procedure_ref  )  (  actual_parameter_list  )?  SEMI!
		{ #procedure_call_stmt = #([PROCEDURE_CALL_STMT, "PROCEDURE_CALL_STMT"], #procedure_call_stmt); } 
             ;

procedure_decl
             :  procedure_head ( algorithm_head )? (  stmt  )*  "end_procedure"!  SEMI! { upScope(); #procedure_decl = #([PROCEDURE_DECL, "PROCEDURE_DECL"], #procedure_decl); }
             ;

procedure_head
             :  "procedure"!  procedure_id { newScope(); } (  LPAREN!  (  "var"  )?  formal_parameter  (  SEMI!  (  "var"  )?  formal_parameter  )*  RPAREN!  )?  SEMI!
	     { #procedure_head = #([PROCEDURE_HEAD, "PROCEDURE_HEAD"], #procedure_head); } 
             ;

procedure_id
	     : { isFirst }? id:IDENT { addId(id.getText(),PROCEDURE_IDENT); }
             |  nid:PROCEDURE_IDENT { #nid.setType(IDENT); #procedure_id = #([PROCEDURE_ID, "PROCEDURE_ID"], #procedure_id); }
             ;

qualifiable_factor
	     : { isFirst }? IDENT ( actual_parameter_list )?
	     | { isFirst }? built_in_constant
	     | { isFirst }? built_in_function ( actual_parameter_list )?
             |  attribute_ref { #qualifiable_factor = #([QUALIFIABLE_FACTOR, "QUALIFIABLE_FACTOR"], #qualifiable_factor); }
             |  constant_factor { #qualifiable_factor = #([QUALIFIABLE_FACTOR, "QUALIFIABLE_FACTOR"], #qualifiable_factor); }
             |  function_call { #qualifiable_factor = #([QUALIFIABLE_FACTOR, "QUALIFIABLE_FACTOR"], #qualifiable_factor); }
             |  population { #qualifiable_factor = #([QUALIFIABLE_FACTOR, "QUALIFIABLE_FACTOR"], #qualifiable_factor); }
             |  general_ref { #qualifiable_factor = #([QUALIFIABLE_FACTOR, "QUALIFIABLE_FACTOR"], #qualifiable_factor); }
             ;

qualifier
             :  attribute_qualifier { #qualifier = #([QUALIFIER, "QUALIFIER"], #qualifier); }
             |  group_qualifier { #qualifier = #([QUALIFIER, "QUALIFIER"], #qualifier); }
             |  index_qualifier { #qualifier = #([QUALIFIER, "QUALIFIER"], #qualifier); }
             ;

query_expression
	     { if (isFirst) newScope1(); }
             :  "query"!  LPAREN!  variable_id  LTSTAR!  aggregate_source  BAR!  logical_expression  RPAREN! { upScope(); 
		#query_expression = #([QUERY_EXPRESSION, "QUERY_EXPRESSION"], #query_expression);
		}
             ;

real_type
             :  "real"!  (  LPAREN!  precision_spec  RPAREN!  )?
	     { #real_type = #([REAL_TYPE, "REAL_TYPE"], #real_type); } 
             ;

reference_clause
	     {
		ExternalId ei=null;
	     }
	     : { isFirst }? "reference"  "from"  id:IDENT  
                 (  LPAREN  ei=resource_or_rename { ei.setSchema(id.getText()); addExternal(ei); }  (  COMMA  ei=resource_or_rename { ei.setSchema(id.getText()); addExternal(ei); }  )*  RPAREN  )?  SEMI { if (ei==null) addAllReferenceExternals(id.getText()); }
             |  "reference"!  "from"!  schema_ref  
                 (  LPAREN!  resource_or_rename  (  COMMA!  resource_or_rename  )*  RPAREN!  )?  SEMI!
	      { #reference_clause = #([REFERENCE_CLAUSE, "REFERENCE_CLAUSE"], #reference_clause); } 
             ;

rel_op
             :  LT  { #rel_op = #([REL_OP, "REL_OP"], #rel_op); }
             |  GT  { #rel_op = #([REL_OP, "REL_OP"], #rel_op); } 
             |  LE   { #rel_op = #([REL_OP, "REL_OP"], #rel_op); }
             |  GE   { #rel_op = #([REL_OP, "REL_OP"], #rel_op); }
             |  LTGT { #rel_op = #([REL_OP, "REL_OP"], #rel_op); }
             |  ASSIGN  { #rel_op = #([REL_OP, "REL_OP"], #rel_op); } 
             |  COLLTGT { #rel_op = #([REL_OP, "REL_OP"], #rel_op); }
             |  COLEQCOL { #rel_op = #([REL_OP, "REL_OP"], #rel_op); }
             ;

rel_op_extended
             :  rel_op  { #rel_op_extended = #([REL_OP_EXTENDED, "REL_OP_EXTENDED"], #rel_op_extended); }
             |  "in"  { #rel_op_extended = #([REL_OP_EXTENDED, "REL_OP_EXTENDED"], #rel_op_extended); }
             |  "like" { #rel_op_extended = #([REL_OP_EXTENDED, "REL_OP_EXTENDED"], #rel_op_extended); }
             ;

rename_id! returns [String s]
	     { s=null; }
             :  id:IDENT { s=id.getText(); }
	     |  nid1:CONSTANT_IDENT { #nid1.setType(IDENT); #rename_id = #([RENAME_ID, "RENAME_ID"], #([CONSTANT_ID, "CONSTANT_ID"], #nid1)); }
	     |  nid2:ENTITY_IDENT { #nid2.setType(IDENT); #rename_id = #([RENAME_ID, "RENAME_ID"], #([ENTITY_ID, "ENTITY_ID"], #nid2)); }
	     |  nid3:FUNCTION_IDENT { #nid3.setType(IDENT); #rename_id = #([RENAME_ID, "RENAME_ID"], #([FUNCTION_ID, "FUNCTION_ID"], #nid3)); }
	     |  nid4:PROCEDURE_IDENT { #nid4.setType(IDENT); #rename_id = #([RENAME_ID, "RENAME_ID"], #([PROCEDURE_ID, "PROCEDURE_ID"], #nid4)); }
	     |  nid5:TYPE_IDENT { #nid5.setType(IDENT); #rename_id = #([RENAME_ID, "RENAME_ID"], #([TYPE_ID, "TYPE_ID"], #nid5)); }
             ;

repeat_control
             :  (  increment_control  )?  (  while_control  )?  (  until_control  )? 
	     { #repeat_control = #([REPEAT_CONTROL, "REPEAT_CONTROL"], #repeat_control); }
             ;

repeat_stmt
	     { if (isFirst) newScope1(); }
             :  "repeat"! repeat_control  SEMI!  stmt  (  stmt  )*  "end_repeat"! { upScope(); } SEMI!
	      { #repeat_stmt = #([REPEAT_STMT, "REPEAT_STMT"], #repeat_stmt); }
             ;

repetition
             :  numeric_expression
	      { #repetition = #([REPETITION, "REPETITION"], #repetition); } 
             ;

resource_or_rename returns [ExternalId ei]
	     {
		ei=null;
		String s=null;
	     }
	     : { isFirst }? id:IDENT { ei = new ExternalId(id.getText()); } ( "as" s=rename_id { ei.setRename(s); } )?
             |  resource_ref ( "as"! rename_id )?
		 { #resource_or_rename = #([RESOURCE_OR_RENAME, "RESOURCE_OR_RENAME"], #resource_or_rename); }
	     |  global_ident (  "as"!  rename_id )? /* global_ident because since the id is renamed, the original id is no longer visible, so it can be declared in this schema */
		 { #resource_or_rename = #([RESOURCE_OR_RENAME, "RESOURCE_OR_RENAME"], #resource_or_rename); }
             ;

resource_ref
             : constant_ref { #resource_ref = #([RESOURCE_REF, "RESOURCE_REF"], #resource_ref); }
	     | entity_ref { #resource_ref = #([RESOURCE_REF, "RESOURCE_REF"], #resource_ref); }
             | function_ref { #resource_ref = #([RESOURCE_REF, "RESOURCE_REF"], #resource_ref); }
             | procedure_ref { #resource_ref = #([RESOURCE_REF, "RESOURCE_REF"], #resource_ref); }
             | type_ref { #resource_ref = #([RESOURCE_REF, "RESOURCE_REF"], #resource_ref); }
             ;

return_stmt
             :  "return"!  (  LPAREN!  expression  RPAREN!  )?  SEMI!
	      { #return_stmt = #([RETURN_STMT, "RETURN_STMT"], #return_stmt); } 
             ;

rule_decl
             :  rule_head ( algorithm_head )? (  stmt  )*  where_clause  "end_rule"! { upScope(); } SEMI!
		{ #rule_decl = #([RULE_DECL, "RULE_DECL"], #rule_decl); }
             ;

rule_head
	     : { isFirst }? "rule" rule_id { newScope1(); } "for" LPAREN IDENT ( COMMA IDENT )* RPAREN SEMI
             |  "rule"!  rule_id  "for"!  LPAREN!  entity_ref  (  COMMA!  entity_ref  )*  RPAREN!  SEMI!
	     { #rule_head = #([RULE_HEAD, "RULE_HEAD"], #rule_head); } 
             ;

rule_id
             :  IDENT
	     { #rule_id = #([RULE_ID, "RULE_ID"], #rule_id); }
             ;

schema_id returns [String s]
	     { s=null; }
	     :  id:IDENT { s=id.getText(); addId(s,SCHEMA_IDENT); #schema_id = #([SCHEMA_ID, "SCHEMA_ID"], #schema_id); }
             |  nid:SCHEMA_IDENT { #nid.setType(IDENT); #schema_id = #([SCHEMA_ID, "SCHEMA_ID"], #schema_id); }
             ;

schema_body
	     : ( interface_specification )* ( constant_decl )? ( declaration | rule_decl )*
	     { #schema_body = #([SCHEMA_BODY, "SCHEMA_BODY"], #schema_body); }
	     ;

schema_decl
	   { String id=null; }
	     :  "schema"! id=schema_id { newSchemaScope(id); } ( schema_version_id )?  SEMI! schema_body "end_schema"! SEMI! { upScope();
		#schema_decl = #([SCHEMA_DECL, "SCHEMA_DECL"], #schema_decl); }
	     ;

schema_version_id
	     :  STRING
		{ #schema_version_id = #([SCHEMA_VERSION_ID, "SCHEMA_VERSION_ID"], #schema_version_id); }
	     ;

interface_specification
	     :  reference_clause { #interface_specification = #([INTERFACE_SPECIFICATION, "INTERFACE_SPECIFICATION"], #interface_specification); }
	     |  use_clause { #interface_specification = #([INTERFACE_SPECIFICATION, "INTERFACE_SPECIFICATION"], #interface_specification); }
	     ;

use_clause
	   {
	     ExternalId ei=null;
	   }
	     : { isFirst }? "use" "from" id:IDENT ( LPAREN ei=named_type_or_rename { ei.setSchema(id.getText()); addExternal(ei); } ( COMMA ei=named_type_or_rename { ei.setSchema(id.getText()); addExternal(ei); } )* RPAREN )? SEMI 
		{ if (ei==null) addAllUseExternals(id.getText()); }
	     |  "use"! "from"! schema_ref ( LPAREN! named_type_or_rename ( COMMA! named_type_or_rename )* RPAREN! )? SEMI!
	      { #use_clause = #([USE_CLAUSE, "USE_CLAUSE"], #use_clause); }
	     ;

named_type_or_rename returns [ExternalId ei]
	     {
		String s=null;
		ei=null;
	     }
	     : { isFirst }? id:IDENT { ei = new ExternalId(id.getText()); } ( "as" s=rename_id { ei.setRename(s); } )?
	     |  named_types ( "as"! ( entity_id | type_id ) )?
	     { #named_type_or_rename = #([NAMED_TYPE_OR_RENAME, "NAMED_TYPE_OR_RENAME"], #named_type_or_rename); }
	     ;


selector
             :  expression
	     { #selector = #([SELECTOR, "SELECTOR"], #selector); } 
             ;

set_type
             :  "set"!  (  bound_spec  )?  "of"!  base_type
	     { #set_type = #([SET_TYPE, "SET_TYPE"], #set_type); } 
             ;

simple_expression
             :  term  (  add_like_op  term  )* 
	     { #simple_expression = #([SIMPLE_EXPRESSION, "SIMPLE_EXPRESSION"], #simple_expression); }
             ;

simple_factor /* you may want to think about it if you like torture :-) */
             :  aggregate_initializer  { #simple_factor = #([SIMPLE_FACTOR, "SIMPLE_FACTOR"], #simple_factor); }  
             |  interval  { #simple_factor = #([SIMPLE_FACTOR, "SIMPLE_FACTOR"], #simple_factor); }
             |  query_expression  { #simple_factor = #([SIMPLE_FACTOR, "SIMPLE_FACTOR"], #simple_factor); }
	     |  { isFirst }? unary_op ( LPAREN expression RPAREN | primary )
	     |  { isFirst }? LPAREN expression RPAREN
	     |  { isFirst }? literal
	     |  { isFirst }? built_in_constant ( qualifier )*
	     |  { isFirst }? built_in_function ( actual_parameter_list )? ( qualifier )*
	     |  { isFirst }? IDENT ( LPAREN ( expression ( COMMA expression )* )? RPAREN )? ( DOT IDENT )? ( qualifier )*
	     |  { LA(2)==LPAREN }? entity_constructor /* lookahead is the only
					way to break the ambiguous situation
					(with population) */
			{ #simple_factor = #([SIMPLE_FACTOR, "SIMPLE_FACTOR"], #simple_factor); }
	     |  { LA(1)==ENUMERATION_IDENT||LA(3)==ENUMERATION_IDENT }? enumeration_reference { #simple_factor = #([SIMPLE_FACTOR, "SIMPLE_FACTOR"], #simple_factor); }
             |  (  (  unary_op  )?  (  LPAREN!  expression  RPAREN!  |  primary  )  )  { #simple_factor = #([SIMPLE_FACTOR, "SIMPLE_FACTOR"], #simple_factor); }
             ;

simple_types
             :  binary_type  { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); }
             |  boolean_type { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); } 
             |  integer_type { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); } 
             |  logical_type { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); } 
             |  number_type  { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); }
             |  real_type  { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); }
             |  string_type { #simple_types = #([SIMPLE_TYPES, "SIMPLE_TYPES"], #simple_types); }
             ;

skip_stmt
             :  "skip"!  SEMI!
	     { #skip_stmt = #([SKIP_STMT, "SKIP_STMT"], #skip_stmt); } 
             ;

stmt
	     : { isFirst }? IDENT ( (qualifier)* COLEQ expression | (actual_parameter_list)? ) SEMI /* mix between assignment_stmt and procedure_call_stmt */
	     |  alias_stmt { #stmt = #([STMT, "STMT"], #stmt); }
             |  assignment_stmt  { #stmt = #([STMT, "STMT"], #stmt); }
             |  case_stmt  { #stmt = #([STMT, "STMT"], #stmt); }
             |  compound_stmt  { #stmt = #([STMT, "STMT"], #stmt); }
             |  escape_stmt { #stmt = #([STMT, "STMT"], #stmt); } 
             |  if_stmt  { #stmt = #([STMT, "STMT"], #stmt); }
             |  null_stmt  { #stmt = #([STMT, "STMT"], #stmt); }
             |  procedure_call_stmt { #stmt = #([STMT, "STMT"], #stmt); } 
             |  repeat_stmt  { #stmt = #([STMT, "STMT"], #stmt); }
             |  return_stmt { #stmt = #([STMT, "STMT"], #stmt); } 
             |  skip_stmt { #stmt = #([STMT, "STMT"], #stmt); }
             ;

string_type
             :  "string"!  (  width_spec  )?
	     { #string_type = #([STRING_TYPE, "STRING_TYPE"], #string_type); } 
             ;

subtype_constraint
             :  "of"!  LPAREN!  supertype_expression  RPAREN! (SEMI!)?
	     { #subtype_constraint = #([SUBTYPE_CONSTRAINT, "SUBTYPE_CONSTRAINT"], #subtype_constraint); }
             ;

supertype_expression
             :  supertype_factor  (  "andor"!  supertype_factor  )*
	     { #supertype_expression = #([SUPERTYPE_EXPRESSION, "SUPERTYPE_EXPRESSION"], supertype_expression); } 
             ;

supertype_factor
             :  supertype_term  (  "and"!  supertype_term  )*
	     { #supertype_factor = #([SUPERTYPE_FACTOR, "SUPERTYPE_FACTOR"], #supertype_factor); } 
             ;

supertype_rule
             :  (  "abstract"  )?  "supertype"!  (  subtype_constraint  )?
	     { #supertype_rule = #([SUPERTYPE_RULE, "SUPERTYPE_RULE"], #supertype_rule); } 
             ;

supertype_term
	     : { isFirst }? IDENT
             |  entity_ref { #supertype_term = #([SUPERTYPE_TERM, "SUPERTYPE_TERM"], #supertype_term); }
             |  one_of { #supertype_term = #([SUPERTYPE_TERM, "SUPERTYPE_TERM"], #supertype_term); } 
             |  LPAREN!  supertype_expression  RPAREN! { #supertype_term = #([SUPERTYPE_TERM, "SUPERTYPE_TERM"], #supertype_term); }
             ;

syntax
	     { if (isFirst) {
			rootScope = new Scope(null);
			lastCreatedScope=rootScope;
			currentScope=rootScope;
			schemas = new Hashtable();
		}
	     }
             : ( language_version_id )? schema_decl ( schema_decl )* 
	     { #syntax = #([SYNTAX, "SYNTAX"], #syntax); }
             ;

language_version_id
	     : LCURLY! LANG_VERSION! RCURLY!
		{ #language_version_id = #([LANGUAGE_VERSION_ID, "LANGUAGE_VERSION_ID"], #language_version_id); }
	     ;

term
             :  factor  (  multiplication_like_op  factor  )*
	     { #term = #([TERM, "TERM"], #term); } 
             ;


type_decl
	     {
	       String id=null;
	       EnumerationType eids=null;
	     }
	     :  "type"! id=type_id { newScope(); } ASSIGN! eids=underlying_type SEMI! ( where_clause )? "end_type"! SEMI! { upScope();
			if (eids!=null) {
			   eids.setTypeName(id);
			   currentScope.addEnumerationType(eids);
			}
			#type_decl = #([TYPE_DECL, "TYPE_DECL"], #type_decl); }
	     ;

underlying_type returns [EnumerationType eids]
	     { eids=null; }
	     :  eids=constructed_types { #underlying_type = #([UNDERLYING_TYPE, "UNDERLYING_TYPE"], #underlying_type); }
	     |  aggregation_types { #underlying_type = #([UNDERLYING_TYPE, "UNDERLYING_TYPE"], #underlying_type); }
	     |  simple_types { #underlying_type = #([UNDERLYING_TYPE, "UNDERLYING_TYPE"], #underlying_type); }
	     | { isFirst }? IDENT
	     |  type_ref { #underlying_type = #([UNDERLYING_TYPE, "UNDERLYING_TYPE"], #underlying_type); }
	     ;

constructed_types returns [EnumerationType eids]
	/* syntactic predicate useful with "extensible" keyword : can be select,or enumeration */
	     { eids=null; }
	     : { LA(1)==LITERAL_enumeration||LA(2)==LITERAL_enumeration }? eids=enumeration_type { #constructed_types = #([CONSTRUCTED_TYPES, "CONSTRUCTED_TYPES"], #constructed_types); }
	     |  select_type { #constructed_types = #([CONSTRUCTED_TYPES, "CONSTRUCTED_TYPES"], #constructed_types); }
	     ;

enumeration_type returns [EnumerationType eids] /* Express amendment modified rule */	     { 
		boolean ext=false;
	        eids=null; 
	     }
	     : ( "extensible" { ext=true; } )? "enumeration"! ( (( "of"! eids=enumeration_items ) | eids=enumeration_extension ) )?
	       { #enumeration_type = #([ENUMERATION_TYPE, "ENUMERATION_TYPE"], #enumeration_type); 
		if (eids==null) eids = new EnumerationType();
		 eids.setExtensible(ext);
		}
	     ;

enumeration_items returns [EnumerationType eids]
	     {
		String id=null;
		if (isFirst) eids = new EnumerationType();
		else eids=null;
	     }
	     : LPAREN! id=enumeration_id { if (isFirst) eids.add(id); } ( COMMA! id=enumeration_id { if (isFirst) eids.add(id); } )* RPAREN!
		{ #enumeration_items = #([ENUMERATION_ITEMS, "ENUMERATION_ITEMS"], #enumeration_items); }
	     ;

enumeration_extension returns [EnumerationType eids]
	     { eids=null; }
	     : { isFirst }? "based_on" id:IDENT ( "with" eids=enumeration_items )? { if (eids==null) eids = new EnumerationType(); eids.setBasedOn(id.getText()); }
	     | "based_on"! type_ref ( "with"! enumeration_items )?
 		{ #enumeration_extension = #([ENUMERATION_EXTENSION, "ENUMERATION_EXTENSION"], #enumeration_extension); }
	     ;

enumeration_id returns [String eid]
	     { eid=null; }
	     : { isFirst }? id:IDENT { eid=id.getText(); }
	     |  nid:ENUMERATION_IDENT { #nid.setType(IDENT); #enumeration_id = #([ENUMERATION_ID, "ENUMERATION_ID"], #enumeration_id); }
	     ;

select_type
	     :  ( "extensible" )? ( "generic_entity" )? "select"! ( ( select_list | select_extension ) )?
	       { #select_type = #([SELECT_TYPE, "SELECT_TYPE"], #select_type); }
	     ;

select_list
	     :  LPAREN! named_types ( COMMA! named_types )* RPAREN!
		{ #select_list = #([SELECT_LIST, "SELECT_LIST"], #select_list); }
	     ;

select_extension
	     : { isFirst }?  "based_on" IDENT ( "with" select_list )?
	     |  "based_on"! type_ref ( "with"! select_list )?
		{ #select_extension = #([SELECT_EXTENSION, "SELECT_EXTENSION"], #select_extension); }
	     ; 

type_id returns [String s]
	     { s=null; }
	     : { isFirst }? id:IDENT { addId(id.getText(),TYPE_IDENT); s=id.getText(); }
             |  nid:TYPE_IDENT { #nid.setType(IDENT); #type_id = #([TYPE_ID, "TYPE_ID"], #type_id); }
             ;

type_label
             :  IDENT
	     { #type_label = #([TYPE_LABEL, "TYPE_LABEL"], #type_label); }
             ;

type_label_id
             :  IDENT 
	     { #type_label_id = #([TYPE_LABEL_ID, "TYPE_LABEL_ID"], #type_label_id); }
             ;

unary_op
             :  PLUS  { #unary_op = #([UNARY_OP, "UNARY_OP"], #unary_op); }
             |  MINUS  { #unary_op = #([UNARY_OP, "UNARY_OP"], #unary_op); }
             |  "not" { #unary_op = #([UNARY_OP, "UNARY_OP"], #unary_op); }
             ;

until_control
             :  "until"!  logical_expression
	     { #until_control = #([UNTIL_CONTROL, "UNTIL_CONTROL"], #until_control); } 
             ;

variable_id
	     : { isFirst }? id:IDENT { addId(id.getText(),VARIABLE_IDENT); }
             |  nid:VARIABLE_IDENT
	     { #nid.setType(IDENT); #variable_id = #([VARIABLE_ID, "VARIABLE_ID"], #variable_id); }
	     |  nid2:ENTITY_VAR_IDENT
	     { #nid2.setType(IDENT); #variable_id = #([VARIABLE_ID, "VARIABLE_ID"], #variable_id); }
	     |  nid3:TYPE_VAR_IDENT
	     { #nid3.setType(IDENT); #variable_id = #([VARIABLE_ID, "VARIABLE_ID"], #variable_id); }	
             ;

where_clause
             :  "where"!  domain_rule  SEMI!  (  domain_rule  SEMI! )*
	     { #where_clause = #([WHERE_CLAUSE, "WHERE_CLAUSE"], #where_clause); } 
             ;

while_control
             :  "while"!  logical_expression
	     { #while_control = #([WHILE_CONTROL, "WHILE_CONTROL"], #while_control); } 
             ;

width
             :  numeric_expression
	     { #width = #([WIDTH, "WIDTH"], #width); } 
             ;

width_spec
             :  LPAREN!  width  RPAREN!  (  "fixed"  )?
	     { #width_spec = #([WIDTH_SPEC, "WIDTH_SPEC"], #width_spec); } 
             ;


entity_ref
	 : nid:ENTITY_IDENT
	 { #nid.setType(IDENT); #entity_ref = #([ENTITY_REF, "ENTITY_REF"], #entity_ref); }
	 | nid2:ENTITY_ATTR_IDENT
	 { #nid2.setType(IDENT); #entity_ref = #([ENTITY_REF, "ENTITY_REF"], #entity_ref); }
	 | nid3:ENTITY_VAR_IDENT
	 { #nid3.setType(IDENT); #entity_ref = #([ENTITY_REF, "ENTITY_REF"], #entity_ref); }
	 | nid4:ENTITY_PARAM_IDENT
	 { #nid4.setType(IDENT); #entity_ref = #([ENTITY_REF, "ENTITY_REF"], #entity_ref); }
         ;

type_ref
         : nid:TYPE_IDENT
	 { #nid.setType(IDENT); #type_ref = #([TYPE_REF, "TYPE_REF"], #type_ref); }
	 | nid2:TYPE_ATTR_IDENT
	 { #nid2.setType(IDENT); #type_ref = #([TYPE_REF, "TYPE_REF"], #type_ref); }
	 | nid3:TYPE_VAR_IDENT
	 { #nid3.setType(IDENT); #type_ref = #([TYPE_REF, "TYPE_REF"], #type_ref); }
	 | nid4:TYPE_PARAM_IDENT
	 { #nid4.setType(IDENT); #type_ref = #([TYPE_REF, "TYPE_REF"], #type_ref); }
         ;

enumeration_ref
         : nid:ENUMERATION_IDENT
	 { #nid.setType(IDENT); #enumeration_ref = #([ENUMERATION_REF, "ENUMERATION_REF"], #enumeration_ref); }
         ;

attribute_ref
	 : nid1:ATTRIBUTE_IDENT { #nid1.setType(IDENT); #attribute_ref = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #attribute_ref); }
	 | nid2:ENTITY_ATTR_IDENT { #nid2.setType(IDENT); #attribute_ref = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #attribute_ref); }
	 | nid3:TYPE_ATTR_IDENT { #nid3.setType(IDENT); #attribute_ref = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #attribute_ref); }
         ;

constant_ref
         : nid:CONSTANT_IDENT
	 { #nid.setType(IDENT); #constant_ref = #([CONSTANT_REF, "CONSTANT_REF"], #constant_ref); }
         ;

function_ref
         : nid:FUNCTION_IDENT
	 { #nid.setType(IDENT); #function_ref = #([FUNCTION_REF, "FUNCTION_REF"], #function_ref); }
         ;

parameter_ref
         : nid:PARAMETER_IDENT
	 { #nid.setType(IDENT); #parameter_ref = #([PARAMETER_REF, "PARAMETER_REF"], #parameter_ref); }
	 | nid2:ENTITY_PARAM_IDENT
	 { #nid2.setType(IDENT); #parameter_ref = #([PARAMETER_REF, "PARAMETER_REF"], #parameter_ref); }
	 | nid3:TYPE_PARAM_IDENT
	 { #nid3.setType(IDENT); #parameter_ref = #([PARAMETER_REF, "PARAMETER_REF"], #parameter_ref); }
         ;

variable_ref
         : nid:VARIABLE_IDENT
	 { #nid.setType(IDENT); #variable_ref = #([VARIABLE_REF, "VARIABLE_REF"], #variable_ref); }
	 | nid2:ENTITY_VAR_IDENT
	 { #nid2.setType(IDENT); #variable_ref = #([VARIABLE_REF, "VARIABLE_REF"], #variable_ref); }
	 | nid3:TYPE_VAR_IDENT
	 { #nid3.setType(IDENT); #variable_ref = #([VARIABLE_REF, "VARIABLE_REF"], #variable_ref); }
         ;

schema_ref
         : nid:SCHEMA_IDENT
	 { #nid.setType(IDENT); #schema_ref = #([SCHEMA_REF, "SCHEMA_REF"], #schema_ref); }
         ;

simple_id
         : IDENT
	 { #simple_id = #([SIMPLE_ID, "SIMPLE_ID"], #simple_id); }
         ;

type_label_ref
         : IDENT
	 { #type_label_ref = #([TYPE_LABEL_REF, "TYPE_LABEL_REF"], #type_label_ref); }
         ;

procedure_ref
         : nid:PROCEDURE_IDENT
	 { #nid.setType(IDENT); #procedure_ref = #([PROCEDURE_REF, "PROCEDURE_REF"], #procedure_ref); }
         ;

/**** special rule ****/

global_ident
	     :  IDENT  { #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     |  nid1:CONSTANT_IDENT { #nid1.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
       	     |  nid2:ENTITY_IDENT { #nid2.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
       	     |  nid3:FUNCTION_IDENT { #nid3.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid4:PROCEDURE_IDENT { #nid4.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid5:PARAMETER_IDENT { #nid5.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid6:SCHEMA_IDENT { #nid6.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid7:TYPE_IDENT { #nid7.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid8:VARIABLE_IDENT { #nid8.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid9:ENUMERATION_IDENT { #nid9.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid10:ATTRIBUTE_IDENT { #nid10.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     |  nid11:ENTITY_ATTR_IDENT { #nid11.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     |  nid12:TYPE_ATTR_IDENT { #nid12.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
             |  nid13:ENTITY_VAR_IDENT { #nid13.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     |  nid14:TYPE_VAR_IDENT { #nid14.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     |  nid15:ENTITY_PARAM_IDENT { #nid15.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     |  nid16:TYPE_PARAM_IDENT { #nid16.setType(IDENT); #global_ident = #([ATTRIBUTE_REF, "ATTRIBUTE_REF"], #global_ident); }
	     ;

/* By using the token IDENT in the parser's rules, I mean "whatever the id
type, I just want an identifier" and not "I want an identifier that doesn't
exist". Since the lexer runs an id research algorithm each time an identifier
is encountered in the second pass, it returns IDENT only if no id is found
during the search, so I had to add this pseudo-token to get the right
behavior 

NOTE: global_ident is only used to replace attribute_ref in some places, so
a ATTRIBUTE_REF node is created here
*/


/* Express LEXICAL RULES  */
class ExpressLexer extends Lexer;
options {
	k=4;
	caseSensitiveLiterals=false;
	charVocabulary='\3'..'\377'; 
}
{

	private ExpressParser parser;

	public void setParser(ExpressParser parser) {
		this.parser=parser;
	}

	private int globalSearchId(String id) {
		if(id.equals("repeat")||id.equals("REPEAT")||id.equals("alias")||id.equals("ALIAS")||id.equals("query")||id.equals("QUERY")||id.equals("rule")||id.equals("RULE")) parser.newScope();
		/* Since id research is performed from a scope, this scope
		should be the good one, but the lexer seems to "bufferize"
		tokens, so the id research begins sometimes from the previous
		scope in the tree because the token that triggers the research
		process is read from the input stream before the parser 
		semantic action (newScope) is done. That's why in those
		cases, the semantic action is performed from the lexer (here)
		as soon as the keyword defining the new scope is encountered
		(ie: REPEAT, ALIAS...) */

		return parser.currentScope.searchId(id);

	}
}


COMMENT 
options {
  paraphrase = "a comment";
}
	:	"(*"
		(	/*	'\r' '\n' can be matched in one alternative or by matching
				'\r' in one iteration and '\n' in another.  I am trying to
				handle any flavor of newline that comes in, but the language
				that allows both "\r\n" and "\r" and "\n" to all be valid
				newline is ambiguous.  Consequently, the resulting grammar
				must be ambiguous.  I'm shutting this warning off.
			 */
			options { greedy=false;
				generateAmbigWarnings=false;
			}
		:
			{ LA(2)!='(' }? '*'
		|	'\r' '\n'		{newline();}
		|	'\n' '\r'		{newline();}
		|	'\r'			{newline();}
		|	'\n'			{newline();}
		|	~('*'|'\n'|'\r'))* "*)"
	 	{ if (parser.isFirst) $setType(Token.SKIP); }       ;

LINECOMMENT
options {
  paraphrase = "a EXPRESS one line comment";
}
	:
	"--" ( options { generateAmbigWarnings=false; }
		: 	~('\n'|'\r') )*
		{ if (parser.isFirst) $setType(Token.SKIP); }
	;

LANG_VERSION
options {
  paraphrase = "language version id";
}
	:
	"iso standard 10303 part (11) version (4)"
	;

SEMI
options {
  paraphrase = ";";
}
	:	';'
	;

QUESTION
options {
  paraphrase = "?";
}
	:	'?'
	;

LPAREN
options {
  paraphrase = "(";
}
	:	'('
	;

RPAREN
options {
  paraphrase = ")";
}
	:	')'
	;

LBRACK
options {
  paraphrase = "[";
}
	:	'['
	;

RBRACK
options {
  paraphrase = "]";
}
	:	']'
	;

LCURLY
options {
  paraphrase = "{";
}
	:	'{'
	;

RCURLY
options {
  paraphrase = "}";
}
	:	'}'
	;

BACKSLASH
options {
  paraphrase = "backslash";
}
	:	'\\'
	;

BAR
options {
  paraphrase = "|";
}
	:	'|'
	;

AMPERSAND
options {
  paraphrase = "&";
}
	:	'&'
	;

COLON
options {
  paraphrase = ":";
}
	:	':'
	;

COLEQ
options {
  paraphrase = ":=";
}
	:	':'
		'='
	;

COLEQCOL
options {
 paraphrase = ":=:";
}
	:	':'
		'='
		':'
	;

COLLTGT
options {
  paraphrase = ":<>:";
}
	:	':'
		'<'
		'>'
		':'
	;

COMMA
options {
  paraphrase = ",";
}
	:	','
	;

DOT
options {
  paraphrase = ".";
}
	:	'.'
	;

ASSIGN
options {
  paraphrase = "=";
}
	:	'='
	;

LT
options {
  paraphrase = "<";
}
	:	'<'
	;

GT
options {
  paraphrase = ">";
}
	:	'>'
	;

LE
options {
  paraphrase = "<=";
}
	:	'<' '='
	;

GE
options {
  paraphrase = ">=";
}
	:	'>' '='
	;

DIVSIGN
options {
  paraphrase = "/";
}
	:	'/'
	;

PLUS
options {
  paraphrase = "+";
}
	:	'+'
	;

MINUS
options {
  paraphrase = "-";
}
	:	'-'
	;

STAR
options {
  paraphrase = "*";
}
	:	'*'
	;

AT
options {
  paraphrase = "@";
}
	:	'@'
	;

WS	
options {
  paraphrase = "white space";
}
	:	(		' '
			|	'\f'
			|	'\t'
			|	(		"\r\n"		// Evil Dos
					|	"\n\r"		// Unknown
					|	'\n'		// Unix
					|	'\r'		// Macintosh
				)
				{
					newline();
				}
			
		)
		{ $setType(Token.SKIP); }
	;

LTSTAR
options {
  paraphrase = "less than star";
}
        : '<' 
          '*'
        ;

LTGT
options {
  paraphrase = "less-than/greater-than thing";
}
        : '<' 
          '>'
        ;

DOUBLESTAR
options {
  paraphrase = "double star";
}
        : '*' 
          '*'
        ;

DOUBLEBAR
options {
  paraphrase = "double bar";
}
        : '|' 
          '|'
        ;

STRING
options {
  paraphrase = "a string literal";
}
	:
	'\'' 
	(~'\'')* 
	'\''
	;

protected
DIGIT
options {
  paraphrase = "a digit";
}
	:	'0'..'9'
	;

INT	
options {
  paraphrase = "an integer value";
}
	:    (DIGIT)+                  
	;

FLOAT
options {
  paraphrase = "an floating point value";
}

	:    '.' (DIGIT)+ (('e' | 'E') ('+' | '-')? (DIGIT)+)?
     	;

IDENT
options {
  testLiterals = true;
  paraphrase = "an identifer";
}

	:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
			{ 
			if (!parser.isFirst) $setType(globalSearchId($getText));
			}
	;

