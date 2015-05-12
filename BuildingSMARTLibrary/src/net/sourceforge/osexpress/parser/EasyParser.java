package net.sourceforge.osexpress.parser;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

	/*
	 * An easy way to parse Express by Stephane Lardet
	 * (stephane.lardet@nist.gov)
	 * 
	 * Development of this software was funded by the United States Government,
	 * and is not subject to copyright.
	 * 
	 * DISCLAIMER: Recipients of this software assume all responsibility
	 * associated with its operation, modification, maintenance, and subsequent
	 * re-distribution.
	 */

	private InputStream expin;

	private static final String TOKENOBJECTCLASS = "antlr.CommonHiddenStreamToken";

	public EasyParser(String filename) throws IOException {
		File file;
		FileInputStream in = null;
		ByteArrayInputStream buff = null;
		byte[] fileContent;
		int length;

		file = new File(filename);
		length = (int) file.length();
		fileContent = new byte[length];

		in = new FileInputStream(file);
		in.read(fileContent);
		in.close();

		buff = new ByteArrayInputStream(fileContent);
		buff.mark(length);
		expin = buff;
	}

	public EasyParser(BufferedInputStream bis) throws IOException {
		bis.mark(Integer.MAX_VALUE);
		expin = bis;
	}

	public EasyParser(Vector<String> filenames) throws IOException {
		/*
		 * put all files in a single buffer and parse them as a file with
		 * multiple schemas
		 */

		FileInputStream in = null;
		ByteArrayInputStream buff = null;
		byte[] filesContent;
		int wlength = 0;
		int tlength, length;
		int sz = filenames.size();
		File[] fs = new File[sz];
		int[] flength = new int[sz];

		for (int i = 0; i < sz; i++) {
			fs[i] = new File(filenames.elementAt(i));
			flength[i] = (int) fs[i].length();
			wlength += flength[i];
		}

		filesContent = new byte[wlength];
		tlength = 0;
		for (int i = 0; i < sz; i++) {
			length = flength[i];
			in = new FileInputStream(fs[i]);
			in.read(filesContent, tlength, length);
			in.close();
			tlength += length;
		}

		buff = new ByteArrayInputStream(filesContent);
		buff.mark(wlength);
		expin = buff;
	}

	public CommonAST parse() throws IOException, RecognitionException, TokenStreamException {
		ExpressParser parser;
		// Scope rootScope;

		parser = createFirstPassParser();

		/* First pass */
		parser.syntax();

		/* manage reference and use clauses */
		parser.processExternals();

		Scope rootScope = parser.rootScope;

		/* second pass initialization */
		parser = createSecondPassParser(rootScope);

		/* second pass */
		parser.syntax();

		this.expin.close();

		/* AST returning */
		CommonAST cast = (CommonAST) parser.getAST();

		return cast;
	}

	private ExpressParser createFirstPassParser() {
		ExpressLexer lexer = new ExpressLexer(this.expin);

		ExpressParser parser = new ExpressParser(lexer);

		lexer.setParser(parser);

		return parser;
	}

	private ExpressParser createSecondPassParser(Scope rootScope) throws IOException {
		this.expin.reset();

		ExpressLexer lexer = new ExpressLexer(this.expin);
		lexer.setTokenObjectClass(TOKENOBJECTCLASS);

		TokenStreamHiddenTokenFilter filter = createFilter(lexer);

		ExpressParser parser = new ExpressParser(filter);
		lexer.setParser(parser);

		parser.setRootScope(rootScope);
		return parser;
	}

	private TokenStreamHiddenTokenFilter createFilter(ExpressLexer lexer) {
		TokenStreamHiddenTokenFilter filter = new TokenStreamHiddenTokenFilter(lexer);
		filter.discard(ExpressParserTokenTypes.COMMENT.getIndex());
		filter.discard(ExpressParserTokenTypes.LINECOMMENT.getIndex());
		filter.discard(ExpressParserTokenTypes.WHERE_CLAUSE.getIndex());
		return filter;
	}
}
