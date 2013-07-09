header {
    package nl.tue.buildingsmart.express.parser;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Vector;
    import java.util.Hashtable;
    import java.util.Collection;
    import java.util.Iterator;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

    import net.sourceforge.osexpress.parser.*;
    
    import nl.tue.buildingsmart.express.dictionary.*;
  
}


class 
Express2DictWalker extends TreeParser;
options {
    importVocab=ExpressParser;
    genHashLines=true;
    buildAST=true;
   
}
{
	//Express2OwlMethods methods=new Express2OwlMethods();
	
	private int pass=1;
	SchemaDefinition schema = new SchemaDefinition();
	
	//this is a very, very ugly shortcut to the unlimited bounds "?" token
	static boolean unlimited_bound=false;
	// stores the last INTEGER_LITERAL that was parsed. Is used in bounds
	String nextInt;
	private static final Logger LOGGER = LoggerFactory.getLogger(Express2DictWalker.class);
	
	public SchemaDefinition getSchema(){
		return schema;
	}
	public void setPass(int i)
	{
		this.pass=i;
	}
	public boolean isPass2(){
		if (pass==2) return true;
		else return false;
	}
	
	public int getPass(){return this.pass;}
	
	public void echo (String s){
		System.out.println(s);
	}
	
}


actual_parameter_list
    :  #(ACTUAL_PARAMETER_LIST parameter ( parameter )* )
    ;

aggregate_initializer
    :  #(AGGREGATE_INITIALIZER ( element ( element )* )? )
    ;

aggregate_source
             :  #(AGGREGATE_SOURCE simple_expression)
             ;

aggregate_type returns [String TypeName="aggregate"]
             :  #(AGGREGATE_TYPE  ( type_label )? parameter_type )
             ;

aggregation_types returns [String[] TypeName=new String[4]]
             :  #( AGGREGATION_TYPES (
		  TypeName=array_type
		| TypeName=bag_type
		| TypeName=list_type 
		| TypeName=set_type
		))
             ;

algorithm_head
	     :  #(ALGORITHM_HEAD ( declaration )* ( constant_decl )? ( local_decl )?)
	     ;

alias_stmt
	     : #(ALIAS_STMT variable_id general_ref ( qualifier )* stmt ( stmt )* )
	     ;

array_type returns  [String[] TypeName= new String[4]]
{
	String[] bounds= new String[2];
	String type="";
}
             : #(ARRAY_TYPE  (  bounds=bound_spec  )?  (  "unique"  )?  type=base_type )
             {
             	TypeName[0]=type;
             	TypeName[1]=bounds[0];
             	TypeName[2]=bounds[1];
             	TypeName[3]="ARRAY";
             }
         	;

assignment_stmt
	     : #(ASSIGNMENT_STMT ( general_ref  (  qualifier  )* ) expression )
             ;

bag_type returns  [String[] TypeName= new String[4]]
{
	String[] bounds= new String[2];
	String type="";
}
             : #(BAG_TYPE  (  bounds=bound_spec  )?   type=base_type )
             {
             	TypeName[0]=type;
             	TypeName[1]=bounds[0];
             	TypeName[2]=bounds[1];
             	TypeName[3]="BAG";
             }
         	;
            

base_type returns [String TypeName=""]
        :  #(BASE_TYPE (
		  		TypeName=concrete_types
             	|TypeName=generalized_types 
		))
             ;

concrete_types returns [String TypeName =""]
{
	String[] aggregate = new String[2];
}
	     :  #(CONCRETE_TYPES (
		  aggregate=aggregation_types {System.out.println("aggregat");}
		| TypeName=simple_types
		| TypeName=named_types
	        ))
	     ;

binary_type returns [String TypeName="BINARY"]
             : #(BINARY_TYPE  (  width_spec  )? )
             ;

boolean_type returns [String TypeName="BOOLEAN"]
             : #(BOOLEAN_TYPE nothing)
             ;

bound_1 returns [String NumEx=""]
{
	String se="";
}
             : #(BOUND_1 se=numeric_expression)
             {
       
 /*
The little bugger "?" to denote no limit in a bound hides in this patth:
 SIMPLE_EXPRESSION ( TERM ( FACTOR ( SIMPLE_FACTOR ( PRIMARY ( QUALIFIABLE_FACTOR ( CONSTANT_FACTOR ( BUILT_IN_CONSTANT ?
Here is a VERY LAZY QUICKHACK to get a shortcut to it: 

*/
					
                   
                   if (unlimited_bound)
                   {
                   		NumEx="?";
                   		unlimited_bound=false;
                   }
                   else NumEx=nextInt;
             }
       
             ;
             
             
// bound_1 returns [String NumEx=""]
// : #(BOUND_1 ne:numeric_expression)
// {
// 	
// 
// 	
// 	
// }
// ;

unlimited_upper_bound

	: #(BOUND_2 simple_expression (term(factor)))
	{
		System.out.println("unlimited upper bound");
	}
	;


bound_2 returns [String NumEx=""]
        
             : #(BOUND_2 ne:numeric_expression)
             {
             	   if (unlimited_bound)
                   {
                   		NumEx="?";
                   		unlimited_bound=false;
                   }
                   else NumEx=nextInt;
             }
             ;

bound_spec returns [String[] bound =new String[2]]
{
	String lower,upper="";
}
             : #(BOUND_SPEC  lower=bound_1 upper=bound_2 )
             	{
             		bound[0]=lower;
             		bound[1]=upper;
             		;
             		
             	}
             	//{System.out.println("Bounds:"+lower+":"+upper);}
             	
             ;

built_in_constant
             :  #(BUILT_IN_CONSTANT (
		  "const_e"
             	| "pi"
             	| "self"
             	| QUESTION {unlimited_bound=true;}
             	| STAR
		))
             ;

case_action
             :  #(CASE_ACTION case_label  ( case_label  )* stmt)
             ;

case_label
             :  #(CASE_LABEL expression)
             ;

case_stmt
             : #(CASE_STMT  selector (  case_action  )*  (  stmt  )? )
             ;

compound_stmt
             : #(COMPOUND_STMT  stmt  (  stmt  )* )
             ;

constant_body
             : #(CONSTANT_BODY constant_id base_type expression )
             ;

constant_decl
             : #(CONSTANT_DECL  constant_body  (  constant_body  )* )
             ;

constant_factor
             :  #(CONSTANT_FACTOR (
		  		built_in_constant
             	| constant_ref
		))
             ;

constant_id
             :  #(CONSTANT_ID IDENT)
             ;


declaration
             :  #(DECLARATION (
		  	entity_decl
			| subtype_constraint_decl
	     	| function_decl
            | procedure_decl
	     	| type_decl["test"]
		))
             ;

domain_rule
             :  #(DOMAIN_RULE ( label )?  logical_expression)
             ;

element
             :  #(ELEMENT expression  ( repetition  )?)
             ;
/*
simpleEntities
{
	OWLNamedClass cl=null;
	String name="";
}
: #(ENTITY_HEAD name=entity_id)
{
	System.out.println(name);
	if (owlModel.getOWLNamedClass(name)== null)
	
	     		cl=owlModel.createOWLNamedClass(name);
	     
}
;
*/
entity_head returns [String className=""]
{	//System.out.println("creating subclass for "+ cl.getName());
	//OWLNamedClass cl=null;
	String name="";
	String[] sub={"",""};
	
}
	     : #(ENTITY_HEAD name=entity_id( "abstract" )?   
	     {
//	     	// methods.order=0;
//	     	if (methods.owlModel.getOWLNamedClass(name)== null)
//	     	{
//	     				cl=methods.owlModel.createOWLNamedClass(name);
//	     			
//	     				
//	     	}
//	     	else cl=methods.owlModel.getOWLNamedClass(name);
//	     	className=cl.getName();
//	     //	System.out.println("name:"+name+", "+className);
	     
		   
		     EntityDefinition ent = schema.getEntityBN(name);
		     if (pass==1){
		     	  	 if (ent == null)
			     	 {
			     	 	ent = new EntityDefinition(name);
			     	 	schema.addEntity(ent);
			     	 }
		     	 
		     }
		     className=name;
	     }
	    (sub=subsuper/*[cl]*/)? ){
	    	
	    	//System.out.println("Subtype of "+name+" sub "+sub);
	    	if (pass==2 && !sub[0].equals("")){
		    	EntityDefinition parent = schema.getEntityBN(sub[0]);
		    	ent.addSupertype(parent);
	    	}
	    	if (pass==2 && !sub[1].equals("true")){
		    	ent.setInstantiable(true);
	    	}
	    }
			
	     ;

entity_decl
{
   
	String className ="";

}
	     : #(ENTITY_DECL className=entity_head 
		 {
	

		 }
		 entity_body[className])
	     ;

entity_body [String forClass] returns [String atrribs=""]

	     : #(ENTITY_BODY (explicit_attr[forClass])* (derive_clause[forClass])? (inverse_clause[forClass])? (unique_clause)? (where_clause)?)

	     ;

subsuper /*[OWLNamedClass cl]*/ returns [String[] sub]
{//System.out.println("working on "+cl.getName());
	//sub={"",""};
	sub=new String[]{"",""};
	String subcls="";
	String abst="";
}
	     : #(SUBSUPER ( abst=supertype_constraint )? ( subcls=subtype_declaration/*[cl]*/ )?)
			{	 sub[0]=subcls;
				sub[1]=abst;  }
	     ;

supertype_constraint returns [String isAbstract=""]

	     :  #(SUPERTYPE_CONSTRAINT (
		  isAbstract=abstract_supertype_declaration
	     	| supertype_rule
		))
	     ;

abstract_supertype_declaration returns [String isAbstract="true"]
	     : #(ABSTRACT_SUPERTYPE_DECLARATION ( subtype_constraint )? )
	     ;

/*subtype_declaration
	     :  #(SUBTYPE_DECLARATION entity_ref ( entity_ref )*)
	     ;*/
subtype_declaration /*[OWLNamedClass cl]*/ returns [String subent=""] 
{	
	
	//String subent = "t";
	String sub="";
	
}
	     :  #(SUBTYPE_DECLARATION subent=get_ref /*entity_ref ( entity_ref )* */)

	     {	
	     	//System.out.println("subtype_declaration: "+subent);
	     	
//	   //  	if (cl.getName().indexOf("IfcApprovalActorRelationship")>-1)	     	
//	   //  		System.out.println("debug");	     	
//	     	if(methods.owlModel.getOWLNamedClass(subent) == null)
//	    	{  
//	    		// System.out.println(": creating root class "+subent);
//		    	methods.owlModel.createOWLNamedClass(subent);
//			
//	    	}
//			//	System.out.println(": adding EXISTING superclass ..."+subent);}
//				cl.addSuperclass(methods.owlModel.getOWLNamedClass(subent));
//			    cl.removeSuperclass(methods.owlModel.getOWLThingClass());
//	     	//}
//				//System.out.println(subent);
//				sub = subent;
				//System.out.println("subtype for "+ cl.getName() +" is "+ subent );
		}
	     ;

subtype_constraint_decl
	     :  #(SUBTYPE_CONSTRAINT_DECL subtype_constraint_head subtype_constraint_body )
	     ;

subtype_constraint_head
	     :  #(SUBTYPE_CONSTRAINT_HEAD subtype_constraint_id entity_ref )
	     ;

subtype_constraint_body
	     :  #(SUBTYPE_CONSTRAINT_BODY ( abstract_supertype )? ( total_over )? ( supertype_expression )? )
	     ;

subtype_constraint_id
	     :  #(SUBTYPE_CONSTRAINT_ID  i:IDENT)
	     {	//System.out.println(i.getText());
	     }
	     ;

abstract_supertype
	     :  #(ABSTRACT_SUPERTYPE nothing)
	     ;

total_over
	     :  #(TOTAL_OVER entity_ref ( entity_ref )* )
	     ;

//definition of actual attributes. Not to be mistaken for TYPE definitions
explicit_attr [String forClass]
{
	String PropName,TypeName="";
	boolean isOptional = false;
	String ConcreteType="";
	String[] BoundedType=new String[4];
}
	     :  #(EXPLICIT_ATTR PropName=attribute_decl (attribute_decl)* ("optional" {isOptional=true;})
	     //? #( BASE_TYPE(ConcreteType=concrete_types | /*TypeName=base_type */TypeName=generalized_types)))
	     ? #( BASE_TYPE(  #(CONCRETE_TYPES
	     						(
	     							  ConcreteType=simple_types 
	     							| ConcreteType=named_types
	     							| BoundedType=aggregation_types 
	     						)
	     					)
	     				|( TypeName=generalized_types))
	     			    )
	     	 )
	    	 {
	    	 	if (pass==2){
	    	 		EntityDefinition ent = schema.getEntityBN(forClass);
		    	 	if ((BoundedType[0]!=null) && (ent!=null) )
		    	 	{
		    	 		/*ConcreteType=BoundedType[0];*/
		    	 		AggregationType aggr =null;
		    	 		BaseType bt = schema.getBaseTypeBN(BoundedType[0]);
		    	 		if (bt==null) System.err.println("WARNING: could not find "+ BoundedType[0]+"(for +"+forClass+")");
		    	 		if (BoundedType[3].equals("LIST")) aggr=new ListType (schema.getBaseTypeBN(BoundedType[0]));
		    	 		else if (BoundedType[3].equals("BAG")) aggr=new BagType (schema.getBaseTypeBN(BoundedType[0]));
		    			else if (BoundedType[3].equals("ARRAY")) aggr=new ArrayType (schema.getBaseTypeBN(BoundedType[0]));
		    			else if (BoundedType[3].equals("SET")) aggr=new SetType (schema.getBaseTypeBN(BoundedType[0]));
		    			
		    			String lbs = BoundedType[1];
		    			String ubs = BoundedType[2];
		    			if (lbs == "" || lbs == "?")lbs="-1";
		    			if (ubs == "" || ubs == "?")ubs="-1";
		    			
		    			IntegerBound lb = new IntegerBound (new Integer(lbs));
		    			IntegerBound ub = new IntegerBound (new Integer(ubs));
		    			if (aggr instanceof VariableSizeAggregationType){
		    				
		    				((VariableSizeAggregationType)aggr).setUpper_bound(ub);
		    				((VariableSizeAggregationType)aggr).setLower_bound(ub);
		    			}
		    			else if (aggr instanceof ArrayType){
		    				((ArrayType)aggr).setLower_index(lb);
		    				((ArrayType)aggr).setUpper_index(ub);
		    			}
		    			ExplicitAttribute attr= new ExplicitAttribute(PropName,ent);
		    			attr.setOptional(isOptional);
		    	 		attr.setDomain(aggr);
		    	 		ent.addAttribute(attr);
		    	 		//System.out.println(forClass +" has Prop " +PropName + " of " + aggr.getClass() + "["+lb.getBound_value()+":"+ub.getBound_value()+"]"+" of Type "+aggr.getElement_type());
		
		    	 	}
		    	 		//System.out.println(forClass +" has Prop " +PropName + " of Type "+ConcreteType);
		    
		    	 	
		    	 	else if ((ent!=null) ){
		    	 		ExplicitAttribute attr= new ExplicitAttribute(PropName,ent);
		    	 		attr.setDomain(schema.getBaseTypeBN(ConcreteType));
		    	 		attr.setOptional(isOptional);
		    	 		ent.addAttribute(attr);
		    	 		//System.out.println(forClass +" has Prop " +PropName + " of Type "+ConcreteType);
		    	 	}
	    	 	}
	    	 	 if (ConcreteType.indexOf("SIMPLETYPE")==0) 
	    	 	{
		    		if (pass==2){
		    			EntityDefinition ent = schema.getEntityBN(forClass);
		    			if ((ent!=null) ){
		    	 		ExplicitAttribute attr= new ExplicitAttribute(PropName,ent);
		    	 		attr.setDomain(schema.getBaseTypeBN(ConcreteType));
		    	 		attr.setOptional(isOptional);
		    	 		ent.addAttribute(attr);
		    	 		//System.out.println(forClass +" has Prop " +PropName + " of Type "+ConcreteType);
		    	 	}
		    	}
		    				 
//	    	 				methods.createSimpleTypeInstance(forClass, PropName, ConcreteType.substring(new String("SIMPLETYPE").length()));
	    	 	
	    	 	
	    	 	}
	    	 	else if (ConcreteType.startsWith("TYPE")) 
	    	 	{
//	    	 				methods.createDerivedListProperty(forClass, PropName, ConcreteType.substring(new String("TYPE").length()));
			 	}
	    	 	else if (ConcreteType.indexOf("UNDERLYING_TYPE")>-1)
	    	 	{
	    	
		    	//for a working version 
//		    		methods.createDatatypePropFromNamedType(forClass,
//	    	 											PropName,
//	    	 											ConcreteType.substring(new String("UNDERLYING_TYPE").length()));
	    				
	    	 	}
	    	 	
	    		else if (ConcreteType.indexOf("ENTITY_REF")>-1)     		{
	   			 	     			String type=ConcreteType.substring(new String("ENTITY_REF").length());
//	   					       			methods.createOrExtendObjectProperty(forClass, PropName,type );
	    		}
	    
	    
	    			if (BoundedType[0]!=null)	    			{
//	    				    methods.addCardinalityConstraint(forClass,PropName,BoundedType[1],BoundedType[2]);
	    
	    			}
		    		
	    		
	    		
	    		
	    		
		 	 }
	     | #(EXPLICIT_ATTR PropName=attribute_decl (attribute_decl)*  ("optional" {isOptional=true;})? TypeName=simple_types)
	     {
	     	
	     	//System.out.println("SimpleType");
	     }
	    	
	     ;

attribute_decl returns [String PropName=""]

	     :  #(ATTRIBUTE_DECL (
		  PropName=attribute_id
	     	| redeclared_attribute
		))
		{
			
		}
	     ;

redeclared_attribute returns [String PropName=""]
	     :  #(REDECLARED_ATTRIBUTE qualified_attribute ( PropName=attribute_id )? )
	     ;

attribute_id returns [String PropName=""]

	     :  #(ATTRIBUTE_ID i:IDENT)
	     //	{methods.entityElement.addContent(new Comment("Element" + methods.entityElement.getAttributeValue("name") + "." + i.getText()));
			{PropName = i.getText();}
				//OWLObjectProperty childrenProperty = owlModel.createOWLObjectProperty(entityElement.getAttributeValue("name") + "." +i.getText());
				//childrenProperty.setRange(owlClass);
				//childrenProperty.addUnionDomainClass(owlClass);
			//}
	     ;

qualified_attribute
	     :  #(QUALIFIED_ATTRIBUTE group_qualifier attribute_qualifier)
	     ;

derive_clause [String forClass]
	     :  #(DERIVE_CLAUSE derived_attr[forClass] (derived_attr[forClass])* )
	     ;

derived_attr [String forClass]
{
	String attrib = "";
}
	     :  #(DERIVED_ATTR ("SELF\\" IDENT ".")? attrib=attribute_decl base_type expression)
{
	if (pass==4) {
		EntityDefinition ent = schema.getEntityBN(forClass);
		ent.addDerived(attrib);
//		Attribute att = ent.getAttributeBNWithSuper(attrib);
//		LOGGER.info(forClass + "." + attrib);
//		if (att == null) {
//			LOGGER.info("null");
//		} else {
//			LOGGER.info(att.toString());
//		}
//		att.setDerived(true);
	}
}
	     ;

inverse_clause [String forClass]
	     :  #(INVERSE_CLAUSE inverse_attr[forClass] (inverse_attr[forClass])* )
	     ;

inverse_attr [String forClass]
{
	String attrib,entity,attrib_ref="";
	String[] bounds=new String[2];
	
}
	     :  #(INVERSE_ATTR attrib=attribute_decl ( ( "set" | "bag" ) ( bounds=bound_spec )? )? entity=entity_ref attrib_ref=attribute_ref)
	     {
	     	
	     	//wait filling out the inverse attributes until the 3rd pass, when all other
	     	//attributes have been filled in
	     	
	     	if (pass==3)
	     	{
	     			EntityDefinition ent = schema.getEntityBN(entity);
	     			EntityDefinition forEnt = schema.getEntityBN(forClass);
	     			if (ent != null){
	     				ExplicitAttribute attr = (ExplicitAttribute)ent.getAttributeBN(attrib_ref);
	     				if (attr != null)
	     				{
	     					//System.out.println("INVERSE "+attrib+" of " + ent.getName()+" for " +attrib_ref);
	     					InverseAttribute  inv = new InverseAttribute(attrib,ent);
		     				if (bounds[0]!=null && bounds[1]!=null){
		     					if ((bounds[0].equals("")) || (bounds[0].equals("?"))) bounds[0]="-1";
		     					if ((bounds[1].equals("")) || (bounds[1].equals("?"))) bounds[1]="-1";
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
	     	
//	     	methods.createInverseObjectProperty (forClass,attrib,attrib_ref,entity);
//	     	if (bounds[0]!=null)
//	     	{
//	     		methods.addCardinalityConstraint(forClass,attrib,bounds[0],bounds[1]);
//	     	}
//	     	
	    // 	System.out.println("Inverse " + attrib + " for " + entity);
	     }
	     ;

unique_clause
	     :  #(UNIQUE_CLAUSE unique_rule ( unique_rule )* )
	     ;

unique_rule
	     : #(UNIQUE_RULE ( label )? referenced_attribute ( referenced_attribute)*)
	     ;

referenced_attribute
	     :  #(REFERENCED_ATTRIBUTE (
		  attribute_ref
	     	| qualified_attribute
		))
	     ;

entity_constructor
             :  #(ENTITY_CONSTRUCTOR entity_ref  (  expression  ( expression  )*  )?  )
             ;

entity_id returns [String name]
{
    String entityName = null;
    name = "";
}
	     : #(ENTITY_ID id:IDENT)
{
    entityName = id.getText();
  	name=entityName;
   
}
             ;

enumeration_reference
	     : #(ENUMERATION_REFERENCE (  type_ref )?  enumeration_ref)
             ;

escape_stmt
             : #(ESCAPE_STMT nothing)
             ;

expression
             : #(EXPRESSION simple_expression ( rel_op_extended simple_expression )?)
	     ;

rel_op_extended
	     :  #(REL_OP_EXTENDED (
		  rel_op
	     	| "in"
	     	| "like"
		))
	     ;

rel_op
	     :  #(REL_OP (
		  LT
	     	| GT
	     	| LE
	     	| GE
	     	| LTGT
	     	| ASSIGN
	     	| COLLTGT
	     	| COLEQCOL
		))
	     ;

factor
	     : #(FACTOR simple_factor ( simple_factor )?)
             ;


formal_parameter
             : #(FORMAL_PARAMETER parameter_id  ( parameter_id  )*  parameter_type)
             ;


attribute_qualifier
             : #(ATTRIBUTE_QUALIFIER attribute_ref)
             ;


function_call
             : #(FUNCTION_CALL ( function_ref | built_in_function )  (  actual_parameter_list  )?)
	     ;

built_in_function
	     :  #(BUILT_IN_FUNCTION (
		  "abs"
             	| "acos"
             	| "asin"
             	| "atan"
             	| "blength"
             	| "cos"
             	| "exists"
             	| "exp"
             	| "format"
             	| "hibound"
             	| "hiindex"
             	| "length"
             	| "lobound"
             	| "loindex"
             	| "log"
             	| "log2"
             	| "log10"
             	| "nvl"
             	| "odd"
             	| "rolesof"
             	| "sin"
             	| "sizeof"
             	| "sqrt"
             	| "tan"
             	| "typeof"
             	| "usedin"
             	| "value"
             	| "value_in"
             	| "value_unique"
		))
	     ;

function_decl
             :  #(FUNCTION_DECL function_head ( algorithm_head)?  stmt  (  stmt  )*)
             ;

function_head
             :  #(FUNCTION_HEAD  function_id  ( formal_parameter  ( formal_parameter )* )?  parameter_type )
             ;

function_id
	     : #(FUNCTION_ID IDENT)
             ;

generalized_types returns [String TypeName=""]
             :  #(GENERALIZED_TYPES (
		  		aggregate_type
             	| TypeName=general_aggregation_types
             	| generic_type
				| generic_entity_type
		))
             ;

generic_entity_type
	     :  #(GENERIC_ENTITY_TYPE nothing)
	     ;

general_aggregation_types returns [String TypeName=""]
             :  #(GENERAL_AGGREGATION_TYPES (
					general_array_type
             	| general_bag_type
             	| TypeName=general_list_type
             	| general_set_type
		))
             ;

general_array_type
             :  #(GENERAL_ARRAY_TYPE  (  bound_spec  )?  (  "optional"  )?  (  "unique"  )?  parameter_type )
             {
           //  	System.out.println("array");
             }
             ;

general_bag_type
             :  #(GENERAL_BAG_TYPE  (  bound_spec  )?  parameter_type )
             ;

general_list_type returns [String TypeName=""]
             :  #(GENERAL_LIST_TYPE  (  bound_spec  )?  (  "unique"  )?  tn:parameter_type )
             {
             	//System.out.println("list");
             	//TypeName += tn.getText();
             }
             ;

general_ref
             :  #(GENERAL_REF (
		  parameter_ref
             	| variable_ref
		))
             ;

general_set_type
             :  #(GENERAL_SET_TYPE  (  bound_spec  )?  parameter_type )
             ;

generic_type
             :  #(GENERIC_TYPE  ( type_label  )? )
             ;

group_qualifier
	     :  #(GROUP_QUALIFIER  entity_ref )
             ;

if_stmt
             :  #(IF_STMT  logical_expression  stmt  (  stmt  )*  ( else_clause )?  )
             ;

/* added rule (and node) to break a nondeterminism (stmt) */
else_clause
	     :  #(ELSE_CLAUSE stmt ( stmt )* )
	     ;

increment
             :  #(INCREMENT numeric_expression)
             ;

increment_control
             :  #(INCREMENT_CONTROL variable_id  bound_1  bound_2  (  increment  )? )
             ;

index
             :  #(INDEX numeric_expression)
             ;

index_1
             :  #(INDEX_1 index)
             ;

index_2
             :  #(INDEX_2 index)
             ;

index_qualifier
             :  #(INDEX_QUALIFIER  index_1  ( index_2  )? )
             ;


integer_type returns [String TypeName="INTEGER"]
             :  #(INTEGER_TYPE nothing)
             ;

interval
             :  #(INTERVAL  interval_low  interval_op  interval_item  interval_op  interval_high )
             ;

interval_high
             :  #(INTERVAL_HIGH simple_expression)
             ;

interval_item
             :  #(INTERVAL_ITEM simple_expression)
             ;

interval_low
             :  #(INTERVAL_LOW simple_expression)
             ;

interval_op
             :  #(INTERVAL_OP (
		  LT
             	| LE
		))
             ;

label
             :  #(LABEL IDENT)
             ;

list_type returns [String[] TypeName= new String[4]]
{
	String[] bounds= new String[2];
	String type="";
}
             : #(LIST_TYPE  (  bounds=bound_spec  )?  (  "unique"  )?  type=base_type )
             {
             	
             	//TypeName=" is a List of " + test        	+ TypeName ;
             	//System.out.println ("L I S T" + test);
             	TypeName[0]=type;
             	TypeName[1]=bounds[0];
             	TypeName[2]=bounds[1];
             	TypeName[3]="LIST";
             }
           
             ;

/* POD removed binary_literal */
literal
             :  #(LITERAL (
            
		  		  real_literal
		  		| integer_literal
	     	    | logical_literal
             	| string_literal
             	
             	
		))
		
             ;

integer_literal
	     :  #(INTEGER_LITERAL i:INT)
	     {
	     	nextInt=i.getText();
	     }
	     ;

real_literal
	     :  #(REAL_LITERAL FLOAT)
	    
	     ;

string_literal
	     :  #(STRING_LITERAL STRING)
	     ;

local_decl
             : #(LOCAL_DECL  local_variable  (  local_variable  )* )
             ;

local_variable
             :  #(LOCAL_VARIABLE variable_id  ( variable_id  )* parameter_type  ( expression  )? )
             ;

logical_expression
             :  #(LOGICAL_EXPRESSION expression)
             ;

logical_literal
             :  #(LOGICAL_LITERAL (
		  "false"
             	| "true"
             	| "unknown"
		))
             ;

logical_type returns [String TypeName="LOGICAL"]
             :  #(LOGICAL_TYPE nothing)
             ;

named_types returns [String TypeName=""]

	     :  #(NAMED_TYPES (
		  		TypeName=entity_ref {TypeName = TypeName;}
             	| TypeName=type_ref {TypeName = TypeName; }
		))
             ;


null_stmt
             :  #(NULL_STMT nothing)
             ;

number_type returns [String TypeName="NUMBER"]
             :  #(NUMBER_TYPE nothing)
             ;


numeric_expression returns [String se=""]
             :  #(NUMERIC_EXPRESSION s:simple_expression)
             {
             	se=s.toStringList();
             	
             	
             }
             ;

one_of
             :  #(ONE_OF supertype_expression  ( supertype_expression  )* )
             ;

parameter
             :  #(PARAMETER expression)
             ;

parameter_id
	     : #(PARAMETER_ID IDENT)
             ;

parameter_type returns [String TypeName =""]
             :  #(PARAMETER_TYPE (
		 		 TypeName=generalized_types
             	| TypeName=named_types
             	| TypeName=simple_types
		))
             ;

population
             :  #(POPULATION entity_ref)
             ;

precision_spec
             :  #(PRECISION_SPEC numeric_expression)
             ;

primary
             :  #(PRIMARY (
		  literal
             	| qualifiable_factor (  qualifier  )*
		))
             ;

procedure_call_stmt
             : #(PROCEDURE_CALL_STMT ( procedure_ref | built_in_procedure ) (  actual_parameter_list  )?)
	     ;

built_in_procedure
	     : #(BUILT_IN_PROCEDURE (
		  "insert"
	     	| "remove"
		))
	     ;

procedure_decl
             : #(PROCEDURE_DECL procedure_head ( algorithm_head )? (  stmt  )*)
             ;

procedure_head
             :  #(PROCEDURE_HEAD  procedure_id ( (  "var"  )?  formal_parameter  ( (  "var"  )?  formal_parameter  )* )? )
             ;

procedure_id
	     : #(PROCEDURE_ID IDENT)
             ;

qualifiable_factor
	     :  #(QUALIFIABLE_FACTOR (
		  attribute_ref
             	| constant_factor
             	| function_call
             	| population
	     	| general_ref
		))
             ;

qualifier
             :  #(QUALIFIER (
		  attribute_qualifier
             	| group_qualifier
             	| index_qualifier
		))
             ;

query_expression
             :  #(QUERY_EXPRESSION variable_id  aggregate_source  logical_expression )
             ;

real_type returns [String TypeName="REAL"]
             :  #(REAL_TYPE  ( precision_spec )? )
             ;

reference_clause
             :  #(REFERENCE_CLAUSE schema_ref
                 ( resource_or_rename  ( resource_or_rename  )* )?)
             ;

rename_id
             :  #(RENAME_ID (
		  	constant_id
	     	| entity_id
	     	| function_id
	     	| procedure_id
	     	| type_id
		))
             ;

repeat_control
             :  #(REPEAT_CONTROL (  increment_control  )?  (  while_control  )?  (  until_control  )?)
             ;

repeat_stmt
	     : #(REPEAT_STMT repeat_control  stmt  (  stmt  )* )
             ;

repetition
             : #(REPETITION numeric_expression)
             ;

resource_or_rename
             :  #(RESOURCE_OR_RENAME resource_ref  ( rename_id  )?)
             ;

resource_ref
             :  #(RESOURCE_REF (
		  constant_ref
	     	| entity_ref
	     	| function_ref
	     	| procedure_ref
	     	| type_ref
		))
             ;

return_stmt
             : #(RETURN_STMT ( expression )? )
             ;

rule_decl
             :  #(RULE_DECL rule_head ( algorithm_head )? (  stmt  )*  where_clause)
             ;

rule_head
	     : #(RULE_HEAD  rule_id  entity_ref  ( entity_ref  )* )
             ;

rule_id
             :  #(RULE_ID IDENT)
             ;

schema_id returns [String schemaName]
{
    schemaName = null;
}
	     :  #(SCHEMA_ID id:IDENT)
{
    schemaName = id.getText();
}
             ;

schema_body
	     :  #(SCHEMA_BODY ( interface_specification )* ( constant_decl )? ( declaration | rule_decl )*)
	     ;

schema_decl //returns [Element schemaElement]
{
  //  schemaElement = null;
  //  Element contents = new Element("complexType", methods.xsd);;
  //  String schemaName = null;
  //  methods.schemaContents = methods.makeChoiceElement("0", "unbounded");
}
	     : #(SCHEMA_DECL ( schema_version_id )? /*schemaName=*/schema_id
	     {
/*		 schemaElement =
		 (new Element("element", methods.xsd).addContent(contents));
		 schemaElement.setAttribute
		 (new Attribute("name", "schema-instance"));
		 contents.addContent(methods.schemaContents);
		 contents.addContent
		 (new Element
		  ("attributeGroup", methods.xsd).setAttribute
		  (new Attribute("ref", "schema-instance.atts")));
		 contents.addContent
		 (new Element
		  ("attribute", methods.xsd).setAttribute
		  (new Attribute
		   ("name", "express_schema_name")).setAttribute
		  (new Attribute
		   ("type", methods.xsd.getPrefix()+":NMTOKEN")).setAttribute
		  (new Attribute
		   ("fixed", methods.capitalizeFirstLetter(schemaName))));
*/	     }
		 schema_body)
	     ;

schema_version_id
	     : #(SCHEMA_VERSION_ID string_literal)
	     ;

interface_specification
	     :  #(INTERFACE_SPECIFICATION (
		  reference_clause
	     	| use_clause
		))
	     ;

use_clause
	     : #(USE_CLAUSE schema_ref ( named_type_or_rename ( named_type_or_rename )* )? )
	     ;

named_type_or_rename
	     :  #(NAMED_TYPE_OR_RENAME named_types ( entity_id | type_id )?)
	     ;


selector
             :  #(SELECTOR expression)
             ;
/*
set_type 
             : #(SET_TYPE (  bound_spec  )?  base_type )
             ;

*/
set_type returns [String[] TypeName= new String[4]]
{
	String[] bounds= new String[2];
	String type="";
}
             : #(SET_TYPE  (  bounds=bound_spec  )?  (  "unique"  )?  type=base_type )
             {
             	
             	//TypeName=" is a List of " + test        	+ TypeName ;
             	//System.out.println ("L I S T" + test);
             	TypeName[0]=type;
             	TypeName[1]=bounds[0];
             	TypeName[2]=bounds[1];
             	TypeName[3]="SET";
             }
             
;


simple_expression
             : #(SIMPLE_EXPRESSION term ( add_like_op  term )* )
	     ;

add_like_op
	     :  #(ADD_LIKE_OP (
		  PLUS
	     	| MINUS
	     	| "or"
	     	| "xor"
		))
	     ;

simple_factor
             :  #(SIMPLE_FACTOR (
		  aggregate_initializer
             	| interval
             	| query_expression
	     	| entity_constructor
	     	| enumeration_reference
             	| (  unary_op  )?  ( expression |  primary  )
		))
             ;

simple_types   returns [String TypeName="simpleType"]
	{
		SimpleType st;
	}
             :  #(SIMPLE_TYPES (
		  		  TypeName=binary_type 
             	| TypeName=boolean_type 
             	| TypeName=integer_type 
             	| TypeName=logical_type 
             	| TypeName=number_type 
             	| TypeName=real_type
             	| TypeName=string_type 
		)
		
		)
		//{System.out.println("SimpleTYPE: "+ TypeName);}
             ;
             
             
//declares 
simple_types_decl_bt   returns [SimpleType st = null]
{
	String TypeName="";
}	
             :  #(SIMPLE_TYPES (
		  		  TypeName=binary_type {st = new BinaryType (); }
             	| TypeName=boolean_type {st = new BooleanType (); }
             	| TypeName=integer_type {st = new IntegerType ();}
             	| TypeName=logical_type {st = new LogicalType ();}
             	| TypeName=number_type {st = new NumberType ();}
             	| TypeName=real_type {st = new RealType (); }
             	| TypeName=string_type {st = new StringType ();}
             	//{if (schema.getBaseType(st)==null) schema.addType(st);}
		))
		
;        
             
    

skip_stmt
             :  #(SKIP_STMT nothing)
             ;

stmt
             :  #(STMT (
		  alias_stmt
	     	| assignment_stmt
             	| case_stmt
             	| compound_stmt
             	| escape_stmt
             	| if_stmt
             	| null_stmt
             	| procedure_call_stmt
             	| repeat_stmt
             	| return_stmt
             	| skip_stmt
		))
             ;

string_type returns [String TypeName="STRING"]
             : #(STRING_TYPE  (  width_spec  )? )
             
             ;

subtype_constraint
             : #(SUBTYPE_CONSTRAINT supertype_expression)
             ;

supertype_expression
             : #(SUPERTYPE_EXPRESSION supertype_factor ( supertype_factor )*)
             ;

supertype_factor
	     : #(SUPERTYPE_FACTOR supertype_term ( supertype_term )*)
             ;

supertype_rule
             : #(SUPERTYPE_RULE subtype_constraint )
             ;

supertype_term
	     : #(SUPERTYPE_TERM (
		  entity_ref
             	| one_of
	     	| supertype_expression
		))
             ;

syntax 
{
 
}
:  #(SYNTAX ( language_version_id )? schema_decl
  
     ( schema_decl )*)
      ;

syntax_pass2
{
 
}
:  #(SYNTAX ( language_version_id )? schema_decl
  
     ( schema_decl )*)
      ;


language_version_id
	     :  #(LANGUAGE_VERSION_ID nothing)
	     ;

term
             :  #(TERM factor ( multiplication_like_op factor )*)
	     ;

multiplication_like_op
	     :  #(MULTIPLICATION_LIKE_OP (
		  STAR
	     	| DIVSIGN
	     	| "div"
	     	| "mod"
	     	| "and"
	     	| DOUBLEBAR
		))
	     ;


type_decl [String IDName]
{String UTN, TypeID="";UnderlyingType ut=null;}
	     :  #(TYPE_DECL TypeID=type_id ut=underlying_type_decl[TypeID] ( where_clause )? )
	     {
		   if (!(ut instanceof SelectType) && !(ut instanceof EnumerationType)){
			   DefinedType dt;
			   if (pass==1){
			   		dt = new DefinedType(TypeID);
			   		if (schema.getTypeBN(TypeID)==null)schema.addType(dt);
			   }
			   else if (pass==2){
			    	 schema.getTypeBN(TypeID).setDomain(ut);
			    	
			   }
		   }
	   	
	   
	    //	methods.createOrExtendDatatypeProperty("",TypeID,UnderlyingTypeName);
//		    if (UnderlyingTypeName.startsWith("SIMPLETYPE")) {
//		    	
//		    	UnderlyingTypeName=UnderlyingTypeName.substring(new String("SIMPLETYPE").length());
//		    	methods.createDatatypePropertyListInstance("",
//		    	 											TypeID,
//		    	 											UnderlyingTypeName);
//		    }
//		    else if (UnderlyingTypeName.startsWith("UNDERLYING_TYPE")) {
//		    	
//		    	UnderlyingTypeName=UnderlyingTypeName.substring(new String("UNDERLYING_TYPE").length());
//		    {
//		    	methods.createDerivedType("",
//		    	 											TypeID,
//		    	 											UnderlyingTypeName);
//		    }	
//		    }
//		     else{
//		    	//methods.createOrExtendDatatypeProperty("",TypeID,UnderlyingTypeName);
//		    }	
		    
	     }
	     ;
underlying_type_decl [String TypeName] returns [UnderlyingType ut =null] 
{
	String UTN="";
	
}
	     :  #(UNDERLYING_TYPE (	  
	     	   constructed_types [TypeName]
	     	  {
	     	 // 	System.out.println ("ENUMERATION"+TypeName);
	     	  }
	     	| aggregation_types
	     	| ut=simple_types_decl_bt {
	     	
	     		
	     		
	     	
	     	}

	     	| UTN=type_ref {
	     		
	     			if (isPass2()){
	     				//TODO add Type Reference here	
	     				ut = schema.getTypeBN(UTN);
	     				System.err.println(TypeName+"PASS 2 get TYPEREF:"+UTN);
	     				
	     			}
	     			else {System.err.println("PASS one:"+TypeName);}
	     			
	     			//UnderlyingTypeName="UNDERLYING_TYPE"+UnderlyingTypeName;
	     			//System.out.println("debug"+UnderlyingTypeName);
	     		}
		))
		
		
;
	     
underlying_type [String TypeName] returns [String UnderlyingTypeName =""] 
{
	String UTN="";
}
	     :  #(UNDERLYING_TYPE (	  
	     	   constructed_types [TypeName]
	     	  {
	     	 // 	System.out.println ("ENUMERATION"+TypeName);
	     	  }
	     	| aggregation_types
	     	| UnderlyingTypeName=simple_types {
	     	
	     		
	     		
	     	
	     	}

	     	| UnderlyingTypeName=type_ref {
	     		
	     			if (isPass2()){
	     				//TODO add Type Reference here	
	     			}
	     			
	     			//UnderlyingTypeName="UNDERLYING_TYPE"+UnderlyingTypeName;
	     			//System.out.println("debug"+UnderlyingTypeName);
	     		}
		))
		{
			if(UnderlyingTypeName.indexOf("IfcPositiveLength")>-1)
			 {
					  	System.out.println("test");
					 }
			}
	     ;

constructed_types [String TypeName] 
{
	List ItemList = new ArrayList();
}
	     :  #(CONSTRUCTED_TYPES (
		  	ItemList=enumeration_type
		  		{
					 EnumerationType et;
					 if (pass==1){
					 	et = new EnumerationType(TypeName);
					 	schema.addType(et);
					 }
					 else if (pass==2){
					 	et = (EnumerationType)schema.getTypeBN(TypeName);
					 	Iterator li = ItemList.iterator();
						while (li.hasNext()){
							Object o =li.next();
							et.addElement(o.toString());
						}
					 }
					 
					 
				
				}
		  
	     	| ItemList=select_type
	     	{
    			SelectType st;
    			// in the first pass, create the type for further use
    			if (pass==1){
    				
    				 st = new SelectType(TypeName);
    				 schema.addType(st);
    			}
    			// in the second one, get it from the schema and fill in the
    			// actual selections
				if (isPass2()){
					st = (SelectType)schema.getTypeBN(TypeName);
					Iterator li = ItemList.iterator();
					while (li.hasNext()){
						Object o =li.next();
						
						
							//SELECT types can either be ENTITYs or TYPEs, so 
							//check which one it it s and add it	
							NamedType nt = schema.getTypeBN(o.toString());
							if (nt == null)
								nt = schema.getEntityBN(o.toString());
							if (nt!=null)
								st.addSelection(nt);
							
						
						
						
					}
					
					
				}
	     	}
		))
		
	
	     ;

enumeration_type returns [List ItemList = new ArrayList()]
{
	//String[] Items;
}
	     :  #(ENUMERATION_TYPE ( "extensible" )? ( ( ItemList=enumeration_items | enumeration_extension ) )? )
	     ;

enumeration_items returns [List items = new ArrayList();]
{
	String id0,id;
}
	     :  #(ENUMERATION_ITEMS id0=enumeration_id {items.add(id0);} ( id=enumeration_id {items.add(id);})* )
	     
	     
	     
	     ;

enumeration_extension
	     :  #(ENUMERATION_EXTENSION type_ref ( enumeration_items )? )
	     ;

enumeration_id returns [String identifier=""]
	     : #(ENUMERATION_ID id:IDENT{identifier=id.getText();})
	     ;

select_type returns [List items = new ArrayList();]
//{	System.out.println("SELECT_TYPE");}
	     : #(SELECT_TYPE ( "extensible" )? ( "generic_entity" )? ( ( items=select_list | select_extension ) )? )
	     ;

select_list returns [List items=new ArrayList();]
{
	String id0,id;
}

	     :  #(SELECT_LIST id0=named_types {items.add(id0);}( id=named_types {items.add(id);} )* )
	     ;

select_extension
	     :  #(SELECT_EXTENSION type_ref ( select_list )? )
	     ;

type_id returns [String identifyer=""]
	     : #(TYPE_ID id:IDENT)
	     {identifyer=id.getText();}
             ;

type_label
             :  #(TYPE_LABEL IDENT)
             ;

type_label_id
             :  #(TYPE_LABEL_ID IDENT)
             ;

unary_op
             :  #(UNARY_OP (
		  PLUS
             	| MINUS
             	| "not"
		))
             ;

until_control
             :  #(UNTIL_CONTROL  logical_expression)
             ;

variable_id
	     :  #(VARIABLE_ID IDENT)
             ;

where_clause
             :  #(WHERE_CLAUSE  domain_rule (  domain_rule )* )
             ;

while_control
             :  #(WHILE_CONTROL  logical_expression )
             ;

width
             :  #(WIDTH numeric_expression)
             ;

width_spec
             :  #(WIDTH_SPEC width  (  "fixed"  )?)
             ;

entity_ref returns [String TypeName=""]


	 : #(ENTITY_REF i:IDENT)

	 //{entityElement.addContent(new Comment("ENTITY REF: " + entityElement.getAttributeValue("name") + "." + i.getText()));}
         {
         	TypeName=i.getText();
         }
         ;
get_ref returns [String subent="test"]

	 : #(ENTITY_REF i:IDENT)
	 {subent=i.getText();}
	 ;

type_ref returns [String TypeName=""]
         : #(TYPE_REF i:IDENT)
        {
        	TypeName=i.getText();
        }

	 ;

enumeration_ref
         : #(ENUMERATION_REF i:IDENT)
	// {entityElement.addContent(new Comment("ENUMERATION REF: " + entityElement.getAttributeValue("name") + "." + i.getText()));}
    //{System.out.println("ENUMERATION------"+i.getText());}
         ;

attribute_ref returns [String attrib_ref = ""]
	 : #(ATTRIBUTE_REF id:IDENT {attrib_ref=id.getText();})
	// {entityElement.addContent(new Comment("ATTRIBUTE REF: " + entityElement.getAttributeValue("name") + "." + i.getText()));}

         ;

constant_ref
         : #(CONSTANT_REF IDENT)
         ;

function_ref
         : #(FUNCTION_REF IDENT)
         ;

parameter_ref
         : #(PARAMETER_REF IDENT)
         ;

variable_ref
         : #(VARIABLE_REF IDENT)
         ;

schema_ref
         : #(SCHEMA_REF IDENT)
         ;

type_label_ref
         : #(TYPE_LABEL_REF IDENT)
         ;

procedure_ref
         : #(PROCEDURE_REF IDENT)
         ;

/* added pseudo-rule because you can't have nodes without arguments */
	     
nothing
	 : ("")?
	 ;
	 