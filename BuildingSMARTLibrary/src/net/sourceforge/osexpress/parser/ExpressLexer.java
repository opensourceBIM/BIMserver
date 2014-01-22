// $ANTLR : "express.g" -> "ExpressLexer.java"$

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

import java.io.InputStream;
import java.io.Reader;
import java.util.Hashtable;

import antlr.ANTLRHashString;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.InputBuffer;
import antlr.LexerSharedInputState;
import antlr.NoViableAltForCharException;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.collections.impl.BitSet;

@SuppressWarnings("all")
public class ExpressLexer extends antlr.CharScanner implements TokenStream {

	private ExpressParser parser;

	public void setParser(ExpressParser parser) {
		this.parser = parser;
	}

	private ExpressParserTokenTypes globalSearchId(String id) {
		if (isNewScopeId(id))
			parser.newScope();

		return parser.currentScope.searchId(id);

	}

	/**
	 * Since id research is performed from a scope, this scope should be the
	 * good one, but the lexer seems to "bufferize" tokens, so the id research
	 * begins sometimes from the previous scope in the tree because the token
	 * that triggers the research process is read from the input stream before
	 * the parser semantic action (newScope) is done. That's why in those cases,
	 * the semantic action is performed from the lexer (here) as soon as the
	 * keyword defining the new scope is encountered (ie: REPEAT, ALIAS...)
	 */
	private boolean isNewScopeId(String id) {
		return id.toUpperCase().equals("REPEAT") || id.toUpperCase().equals("ALIAS") || id.toUpperCase().equals("QUERY") || id.toUpperCase().equals("RULE");
	}

	public ExpressLexer(InputStream in) {
		this(new ByteBuffer(in));
	}

	public ExpressLexer(Reader in) {
		this(new CharBuffer(in));
	}

	public ExpressLexer(InputBuffer ib) {
		this(new LexerSharedInputState(ib));
	}

	public ExpressLexer(LexerSharedInputState state) {
		super(state);
		caseSensitiveLiterals = false;
		setCaseSensitive(true);
		initializeLiterals();
	}

	private void addNewLiteral(String literalName, int key) {
		this.literals.put(new ANTLRHashString(literalName, this), new Integer(key));
	}

	private void initializeLiterals() {
		literals = new Hashtable();
		addNewLiteral("until", 365);
		addNewLiteral("xor", 218);
		addNewLiteral("abstract", 280);
		addNewLiteral("generic_entity", 298);
		addNewLiteral("entity", 279);
		addNewLiteral("logical", 319);
		addNewLiteral("use", 352);
		addNewLiteral("escape", 292);
		addNewLiteral("number", 325);
		addNewLiteral("with", 362);
		addNewLiteral("end_alias", 228);
		addNewLiteral("loindex", 254);
		addNewLiteral("tan", 264);
		addNewLiteral("end_if", 302);
		addNewLiteral("skip", 353);
		addNewLiteral("for", 225);
		addNewLiteral("else", 303);
		addNewLiteral("insert", 270);
		addNewLiteral("derive", 288);
		addNewLiteral("of", 223);
		addNewLiteral("end_schema", 351);
		addNewLiteral("length", 252);
		addNewLiteral("and", 323);
		addNewLiteral("integer", 306);
		addNewLiteral("begin", 275);
		addNewLiteral("as", 346);
		addNewLiteral("typeof", 265);
		addNewLiteral("div", 321);
		addNewLiteral("const_e", 236);
		addNewLiteral("oneof", 326);
		addNewLiteral("procedure", 328);
		addNewLiteral("exists", 247);
		addNewLiteral("end_rule", 348);
		addNewLiteral("supertype", 282);
		addNewLiteral("like", 343);
		addNewLiteral("renamed", 287);
		addNewLiteral("var", 329);
		addNewLiteral("lobound", 253);
		addNewLiteral("log2", 256);
		addNewLiteral("optional", 230);
		addNewLiteral("unique", 231);
		addNewLiteral("subtype_constraint", 285);
		addNewLiteral("function", 295);
		addNewLiteral("end_case", 274);
		addNewLiteral("end_constant", 278);
		addNewLiteral("binary", 234);
		addNewLiteral("not", 364);
		addNewLiteral("in", 342);
		addNewLiteral("based_on", 361);
		addNewLiteral("generic", 297);
		addNewLiteral("subtype", 283);
		addNewLiteral("real", 333);
		addNewLiteral("usedin", 266);
		addNewLiteral("extensible", 359);
		addNewLiteral("acos", 242);
		addNewLiteral("fixed", 368);
		addNewLiteral("hiindex", 251);
		addNewLiteral("unknown", 318);
		addNewLiteral("rule", 349);
		addNewLiteral("end_procedure", 327);
		addNewLiteral("bag", 233);
		addNewLiteral("repeat", 344);
		addNewLiteral("false", 316);
		addNewLiteral("end_entity", 281);
		addNewLiteral("local", 314);
		addNewLiteral("to", 304);
		addNewLiteral("case", 272);
		addNewLiteral("andor", 355);
		addNewLiteral("log", 255);
		addNewLiteral("true", 317);
		addNewLiteral("blength", 245);
		addNewLiteral("total_over", 286);
		addNewLiteral("format", 249);
		addNewLiteral("list", 296);
		addNewLiteral("abs", 241);
		addNewLiteral("remove", 271);
		addNewLiteral("aggregate", 221);
		addNewLiteral("constant", 277);
		addNewLiteral("hibound", 250);
		addNewLiteral("end_local", 315);
		addNewLiteral("inverse", 289);
		addNewLiteral("sqrt", 263);
		addNewLiteral("cos", 246);
		addNewLiteral("then", 301);
		addNewLiteral("enumeration", 360);
		addNewLiteral("set", 290);
		addNewLiteral("schema", 350);
		addNewLiteral("or", 217);
		addNewLiteral("if", 300);
		addNewLiteral("by", 305);
		addNewLiteral("end_type", 358);
		addNewLiteral("end_repeat", 345);
		addNewLiteral("string", 354);
		addNewLiteral("asin", 243);
		addNewLiteral("otherwise", 273);
		addNewLiteral("return", 347);
		addNewLiteral("from", 335);
		addNewLiteral("rolesof", 260);
		addNewLiteral("value", 267);
		addNewLiteral("log10", 257);
		addNewLiteral("array", 229);
		addNewLiteral("where", 366);
		addNewLiteral("pi", 237);
		addNewLiteral("exp", 248);
		addNewLiteral("self", 238);
		addNewLiteral("value_in", 268);
		addNewLiteral("end_subtype_constraint", 284);
		addNewLiteral("end", 276);
		addNewLiteral("mod", 322);
		addNewLiteral("reference", 334);
		addNewLiteral("sizeof", 262);
		addNewLiteral("select", 363);
		addNewLiteral("value_unique", 269);
		addNewLiteral("nvl", 258);
		addNewLiteral("atan", 244);
		addNewLiteral("sin", 261);
		addNewLiteral("query", 330);
		addNewLiteral("while", 367);
		addNewLiteral("boolean", 235);
		addNewLiteral("odd", 259);
		addNewLiteral("type", 357);
		addNewLiteral("end_function", 294);
		addNewLiteral("alias", 224);
	}

	public Token nextToken() throws TokenStreamException {
		Token theRetToken = null;
		tryAgain: for (;;) {
			Token _token = null;
			int _ttype = Token.INVALID_TYPE;
			resetText();
			try { // for char stream error handling
				try { // for lexical error handling
					getNextToken();
					if (_returnToken == null)
						continue tryAgain; // found SKIP token
					_ttype = _returnToken.getType();
					_ttype = testLiteralsTable(_ttype);
					_returnToken.setType(_ttype);
					return _returnToken;
				} catch (RecognitionException e) {
					throw new TokenStreamRecognitionException(e);
				}
			} catch (CharStreamException cse) {
				if (cse instanceof CharStreamIOException) {
					throw new TokenStreamIOException(((CharStreamIOException) cse).io);
				} else {
					throw new TokenStreamException(cse.getMessage());
				}
			}
		}
	}

	private Token getNextToken() throws RecognitionException, CharStreamException, TokenStreamException {
		Token theRetToken = null;
		switch (LA(1)) {
		case ';': {
			mSEMI(true);
			theRetToken = _returnToken;
			break;
		}
		case '?': {
			mQUESTION(true);
			theRetToken = _returnToken;
			break;
		}
		case ')': {
			mRPAREN(true);
			theRetToken = _returnToken;
			break;
		}
		case '[': {
			mLBRACK(true);
			theRetToken = _returnToken;
			break;
		}
		case ']': {
			mRBRACK(true);
			theRetToken = _returnToken;
			break;
		}
		case '{': {
			mLCURLY(true);
			theRetToken = _returnToken;
			break;
		}
		case '}': {
			mRCURLY(true);
			theRetToken = _returnToken;
			break;
		}
		case '\\': {
			mBACKSLASH(true);
			theRetToken = _returnToken;
			break;
		}
		case '&': {
			mAMPERSAND(true);
			theRetToken = _returnToken;
			break;
		}
		case ',': {
			mCOMMA(true);
			theRetToken = _returnToken;
			break;
		}
		case '=': {
			mASSIGN(true);
			theRetToken = _returnToken;
			break;
		}
		case '/': {
			mDIVSIGN(true);
			theRetToken = _returnToken;
			break;
		}
		case '+': {
			mPLUS(true);
			theRetToken = _returnToken;
			break;
		}
		case '@': {
			mAT(true);
			theRetToken = _returnToken;
			break;
		}
		case '\t':
		case '\n':
		case '\u000c':
		case '\r':
		case ' ': {
			mWS(true);
			theRetToken = _returnToken;
			break;
		}
		case '\'': {
			mSTRING(true);
			theRetToken = _returnToken;
			break;
		}
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': {
			mINT(true);
			theRetToken = _returnToken;
			break;
		}
		default:
			if ((LA(1) == 'i') && (LA(2) == 's') && (LA(3) == 'o') && (LA(4) == ' ')) {
				mLANG_VERSION(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == ':') && (LA(2) == '=') && (LA(3) == ':')) {
				mCOLEQCOL(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '(') && (LA(2) == '*')) {
				mCOMMENT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '-') && (LA(2) == '-')) {
				mLINECOMMENT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == ':') && (LA(2) == '=')) {
				mCOLEQ(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == ':') && (LA(2) == '<')) {
				mCOLLTGT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '<') && (LA(2) == '=')) {
				mLE(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '>') && (LA(2) == '=')) {
				mGE(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '<') && (LA(2) == '*')) {
				mLTSTAR(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '<') && (LA(2) == '>')) {
				mLTGT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '*') && (LA(2) == '*')) {
				mDOUBLESTAR(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '|') && (LA(2) == '|')) {
				mDOUBLEBAR(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '.') && ((LA(2) >= '0' && LA(2) <= '9'))) {
				mFLOAT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '(')) {
				mLPAREN(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '|')) {
				mBAR(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == ':')) {
				mCOLON(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '.')) {
				mDOT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '<')) {
				mLT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '>')) {
				mGT(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '-')) {
				mMINUS(true);
				theRetToken = _returnToken;
			} else if ((LA(1) == '*')) {
				mSTAR(true);
				theRetToken = _returnToken;
			} else if ((_tokenSet_0.member(LA(1)))) {
				mIDENT(true);
				theRetToken = _returnToken;
			} else {
				if (LA(1) == EOF_CHAR) {
					uponEOF();
					_returnToken = makeToken(Token.EOF_TYPE);
				} else {
					throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
				}
			}
		}
		return _returnToken;
	}

	public final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.COMMENT;
		int _saveIndex;

		match("(*");
		{
			_loop35931: do {
				// nongreedy exit test
				if (isCommentClose())
					break _loop35931;
				if ((LA(1) == '\r') && (LA(2) == '\n') && isControlOrLatin1(LA(3)) && isControlOrLatin1(LA(4))) {
					match('\r');
					match('\n');
					newline();
				} else if ((LA(1) == '\n') && (LA(2) == '\r') && isControlOrLatin1(LA(3)) && isControlOrLatin1(LA(4))) {
					match('\n');
					match('\r');
					newline();
				} else if (((LA(1) == '*') && isControlOrLatin1(LA(2)) && isControlOrLatin1(LA(3))) && (LA(2) != '(')) {
					match('*');
				} else if ((LA(1) == '\r') && isControlOrLatin1(LA(2)) && isControlOrLatin1(LA(3))) {
					match('\r');
					newline();
				} else if ((LA(1) == '\n') && isControlOrLatin1(LA(2)) && isControlOrLatin1(LA(3))) {
					match('\n');
					newline();
				} else if ((_tokenSet_1.member(LA(1)))) {
					{
						match(_tokenSet_1);
					}
				} else {
					break _loop35931;
				}

			} while (true);
		}
		match("*)");
		if (parser.isFirst)
			_ttype = ExpressParserTokenTypes.SKIP;
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	private boolean isCommentClose() throws CharStreamException {
		return (LA(1) == '*') && (LA(2) == ')');
	}

	/**
	 * Checks that the character is a control character (except for \u0000,
	 * \u0001, \u0002) or a Latin1 character (up to and including \u00ff)
	 * 
	 * @return
	 */
	private boolean isControlOrLatin1(char charToCheck) {
		return charToCheck >= '\u0003' && charToCheck <= '\u00ff';
	}

	public final void mLINECOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LINECOMMENT;
		int _saveIndex;

		match("--");
		{
			_loop35935: do {
				if ((_tokenSet_2.member(LA(1)))) {
					{
						match(_tokenSet_2);
					}
				} else {
					break _loop35935;
				}

			} while (true);
		}
		if (parser.isFirst)
			_ttype = ExpressParserTokenTypes.SKIP;
		if (canMakeToken(_createToken, _token, _ttype)) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	private boolean canMakeToken(boolean _createToken, Token _token, ExpressParserTokenTypes _ttype) {
		return _createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP;
	}

	public final void mLANG_VERSION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LANG_VERSION;
		int _saveIndex;

		match("iso standard 10303 part (11) version (4)");
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.SEMI;
		int _saveIndex;

		match(';');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mQUESTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.QUESTION;
		int _saveIndex;

		match('?');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LPAREN;
		int _saveIndex;

		match('(');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.RPAREN;
		int _saveIndex;

		match(')');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LBRACK;
		int _saveIndex;

		match('[');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mRBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.RBRACK;
		int _saveIndex;

		match(']');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LCURLY;
		int _saveIndex;

		match('{');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mRCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.RCURLY;
		int _saveIndex;

		match('}');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBACKSLASH(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.BACKSLASH;
		int _saveIndex;

		match('\\');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.BAR;
		int _saveIndex;

		match('|');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mAMPERSAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.AMPERSAND;
		int _saveIndex;

		match('&');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.COLON;
		int _saveIndex;

		match(':');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCOLEQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.COLEQ;
		int _saveIndex;

		match(':');
		match('=');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCOLEQCOL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.COLEQCOL;
		int _saveIndex;

		match(':');
		match('=');
		match(':');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCOLLTGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.COLLTGT;
		int _saveIndex;

		match(':');
		match('<');
		match('>');
		match(':');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.COMMA;
		int _saveIndex;

		match(',');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.DOT;
		int _saveIndex;

		match('.');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.ASSIGN;
		int _saveIndex;

		match('=');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LT;
		int _saveIndex;

		match('<');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.GT;
		int _saveIndex;

		match('>');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LE;
		int _saveIndex;

		match('<');
		match('=');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mGE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.GE;
		int _saveIndex;

		match('>');
		match('=');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDIVSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.DIVSIGN;
		int _saveIndex;

		match('/');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.PLUS;
		int _saveIndex;

		match('+');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.MINUS;
		int _saveIndex;

		match('-');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.STAR;
		int _saveIndex;

		match('*');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.AT;
		int _saveIndex;

		match('@');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.WS;
		int _saveIndex;

		{
			switch (LA(1)) {
			case ' ': {
				match(' ');
				break;
			}
			case '\u000c': {
				match('\f');
				break;
			}
			case '\t': {
				match('\t');
				break;
			}
			case '\n':
			case '\r': {
				{
					if ((LA(1) == '\r') && (LA(2) == '\n')) {
						match("\r\n");
					} else if ((LA(1) == '\n') && (LA(2) == '\r')) {
						match("\n\r");
					} else if ((LA(1) == '\n') && (true)) {
						match('\n');
					} else if ((LA(1) == '\r') && (true)) {
						match('\r');
					} else {
						throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
					}

				}

				newline();

				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		_ttype = ExpressParserTokenTypes.SKIP;
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLTSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LTSTAR;
		int _saveIndex;

		match('<');
		match('*');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLTGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.LTGT;
		int _saveIndex;

		match('<');
		match('>');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDOUBLESTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.DOUBLESTAR;
		int _saveIndex;

		match('*');
		match('*');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDOUBLEBAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.DOUBLEBAR;
		int _saveIndex;

		match('|');
		match('|');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSTRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.STRING;
		int _saveIndex;

		match('\'');
		{
			_loop35973: do {
				if ((_tokenSet_3.member(LA(1)))) {
					matchNot('\'');
				} else {
					break _loop35973;
				}

			} while (true);
		}
		match('\'');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.DIGIT;
		int _saveIndex;

		matchRange('0', '9');
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.INT;
		int _saveIndex;

		{
			int _cnt35977 = 0;
			_loop35977: do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mDIGIT(false);
				} else {
					if (_cnt35977 >= 1) {
						break _loop35977;
					} else {
						throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
					}
				}

				_cnt35977++;
			} while (true);
		}
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mFLOAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.FLOAT;
		int _saveIndex;

		match('.');
		{
			int _cnt35980 = 0;
			_loop35980: do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mDIGIT(false);
				} else {
					if (_cnt35980 >= 1) {
						break _loop35980;
					} else {
						throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
					}
				}

				_cnt35980++;
			} while (true);
		}
		{
			if ((LA(1) == 'E' || LA(1) == 'e')) {
				{
					switch (LA(1)) {
					case 'e': {
						match('e');
						break;
					}
					case 'E': {
						match('E');
						break;
					}
					default: {
						throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
					}
					}
				}
				{
					switch (LA(1)) {
					case '+': {
						match('+');
						break;
					}
					case '-': {
						match('-');
						break;
					}
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9': {
						break;
					}
					default: {
						throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
					}
					}
				}
				{
					int _cnt35985 = 0;
					_loop35985: do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							mDIGIT(false);
						} else {
							if (_cnt35985 >= 1) {
								break _loop35985;
							} else {
								throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
							}
						}

						_cnt35985++;
					} while (true);
				}
			} else {
			}

		}
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		ExpressParserTokenTypes _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ExpressParserTokenTypes.IDENT;
		int _saveIndex;

		{
			switch (LA(1)) {
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z': {
				matchRange('a', 'z');
				break;
			}
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z': {
				matchRange('A', 'Z');
				break;
			}
			case '_': {
				match('_');
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		{
			_loop35989: do {
				switch (LA(1)) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z': {
					matchRange('a', 'z');
					break;
				}
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z': {
					matchRange('A', 'Z');
					break;
				}
				case '_': {
					match('_');
					break;
				}
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					matchRange('0', '9');
					break;
				}
				default: {
					break _loop35989;
				}
				}
			} while (true);
		}

		if (!parser.isFirst)
			_ttype = globalSearchId(new String(text.getBuffer(), _begin, text.length() - _begin));

		_ttype = ExpressParserTokenTypes.getToken(testLiteralsTable(_ttype.getIndex()));
		if (_createToken && _token == null && _ttype != ExpressParserTokenTypes.SKIP) {
			_token = makeToken(_ttype.getIndex());
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	private static final long[] mk_tokenSet_0() {
		long[] data = { 0L, 576460745995190270L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0] = -4398046520328L;
		for (int i = 1; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());

	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0] = -9224L;
		for (int i = 1; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());

	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0] = -549755813896L;
		for (int i = 1; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

}
