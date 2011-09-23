package net.sourceforge.osexpress.parser;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.TokenStreamHiddenTokenFilter;

public class EasyParser {

   /* An easy way to parse Express by Stephane Lardet (stephane.lardet@nist.gov)
    *
    *   Development of this software was funded by the United States Government,
    *   and is not subject to copyright.
    *
    *   DISCLAIMER: Recipients of this software assume all responsibility
    *   associated with its operation, modification, maintenance, and subsequent
    *   re-distribution.
    */

    private InputStream expin;
    
    public EasyParser(String filename) throws IOException {
	File file;
	FileInputStream in=null;
	ByteArrayInputStream buff=null;
	byte[] fileContent;
	int length;

	file = new File(filename);
	length=(int)file.length();
	fileContent = new byte[length];

	in = new FileInputStream(file);
	in.read(fileContent);
	in.close();
	
	buff = new ByteArrayInputStream(fileContent);
	buff.mark(length);
	expin=buff;
    }

    public EasyParser(BufferedInputStream bis) throws IOException {
	bis.mark(Integer.MAX_VALUE);
	expin=bis;
    }

    @SuppressWarnings("rawtypes")
	public EasyParser(Vector filenames) throws IOException {
	/* put all files in a single buffer and parse them as a file with
	   multiple schemas */
	File[] fs;
	int[] flength;
	FileInputStream in=null;
	ByteArrayInputStream buff=null;
	byte[] filesContent;
	int wlength,tlength,length;
	int sz,i;

	wlength=0;
	sz=filenames.size();
	fs = new File[sz];
	flength = new int[sz];
	for (i=0;i<sz;i++) {
	    fs[i] = new File((String)filenames.elementAt(i));
	    flength[i]=(int)fs[i].length();
	    wlength+=flength[i];
	}
	
	filesContent = new byte[wlength];
	tlength=0;
	for (i=0;i<sz;i++) {
	    length=flength[i];
	    in = new FileInputStream(fs[i]);
	    in.read(filesContent,tlength,length);
	    in.close();
	    tlength+=length;
	}
	
	buff = new ByteArrayInputStream(filesContent);
	buff.mark(wlength);
	expin=buff;
    }

    public CommonAST parse() throws IOException, RecognitionException, TokenStreamException {
	ExpressLexer lexer;
	ExpressParser parser;
	TokenStreamHiddenTokenFilter filter;
	Scope rootScope;
	//very dirty hack to turn of all error messages from lexer and parser
//	PrintStream stdErrOld= System.err;
//	PrintStream stdOutOld= System.out;
//	FileOutputStream log = new FileOutputStream("parser.log");
//	PrintStream myErr = new PrintStream(log);
//	System.setErr(myErr);
//	System.setOut(myErr);
	
	/* First pass initialization */
	lexer = new ExpressLexer(expin);
	
	parser = new ExpressParser(lexer);
	
	lexer.setParser(parser);

	/* First pass */
	
		parser.syntax();
	

	/* manage reference and use clauses */
	parser.processExternals();
	    
	rootScope=parser.rootScope;

	/* second pass initialization */
	expin.reset();
	lexer = new ExpressLexer(expin);
	lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
	filter = new TokenStreamHiddenTokenFilter(lexer);
	filter.discard(ExpressParser.COMMENT);
	filter.discard(ExpressParser.LINECOMMENT);
	filter.discard(ExpressParser.WHERE_CLAUSE);
	
	parser = new ExpressParser(filter);
	lexer.setParser(parser);
	parser.setRootScope(rootScope);

	/* second pass */
	
		parser.syntax();
	
	expin.close();
	//turn on errors again
	
	/* AST returning */
	CommonAST cast = (CommonAST)parser.getAST();
//	System.setErr(stdErrOld);
//	System.setOut(stdOutOld);
//	myErr.close();
	return cast;
    }
}

