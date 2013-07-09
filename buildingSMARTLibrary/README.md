Author: Jakob Beetz <jakob_beetz@sourceforge.net> Eindhoven University of Technology
This is the initial dump of some utility libraries to access STEP schemas and population files.

Currently only a very limited amount of javadoc tags has been added to the packages
and the sources.

The library consists of 6 packages:

- net.sourceforge.osexpress.parser 
	a parser generator written by Josh Lubel et al in the context of the 
	OSEXPRESS project.
	https://sourceforge.net/projects/osexpress/
	modified and adapted slightly 
	
- nl.tue.buildingsmart.express.parser
	a modfied ANTLR grammar Express2SDAI.g 
	it makes use of the dictionary package to store an in-memory meta-model of an
	ISO 10303 part 11 EXPRESS schema definition file.
	The main schemas that have been tested with it are different versions of the
	Industry Foundation Classes (IFC) model developed under the umbrella of the 
	buildingSMART / IAI organization:
	http://www.iai-international.org/
	http://www.iai-international.org/Model/IFC(ifcXML)Specs.html
	
- nl.tue.buildingsmart.express.dictionary
	a meta model structure to capture some of the essential modeling constructs
	of the EXPRESS schema definition language.
	Many advanced features such as RULE, FUNCTION, QUERY etc. are not implemnted yet
	
- nl.tue.buildingsmart.express.population
	a JavaCC based file-reader for ISO 10303 part 21 Step Physical File Format (SPFF)
	files. This primitive piece creates a large Hashmap of ENTITY and ATTRIBUTE instances
	and will quickly go through the memory roof of large population files.
	It has been particularly developed with reading in IFC files in mind
	The original JavaCC grammar has been developed by Singva Ma

- nl.tue.buildingsmart.express.population.test
	a primitive test that reads in a SPFF (IFC) file given in argv and provided an .exp 
	EXPRESS schema will spit out some statistics.
	
- nl.tue.buildingsmart.emf
	a primitive generator that takes and EXPRESS .exp schema and converts it into an ecore
	model for the use in the Eclipse Modeling Framework (EMF)
	
other highly experimental mappings to RDF(S) and OWL, graphical editors, network visualizers
etc. are available upon request
 
	
TODO: loads and loads of cleanup, refactoring and documentation.
