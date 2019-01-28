package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltTest {
	public static void main(String[] args) {
		new XsltTest().start();
	}

	private void start() {
		Path xslt = Paths.get("../BimServer/xslt/_Report1.xhtml.xsl");
		TransformerFactory factory = TransformerFactory.newInstance();

		StreamSource xslStream = new StreamSource(xslt.toFile());
		try {
			Transformer transformer = factory.newTransformer(xslStream);
			transformer.setErrorListener(new ErrorListener() {

				@Override
				public void warning(TransformerException exception) throws TransformerException {
//					exception.printStackTrace();
				}

				@Override
				public void fatalError(TransformerException exception) throws TransformerException {
					exception.printStackTrace();
				}

				@Override
				public void error(TransformerException exception) throws TransformerException {
					exception.printStackTrace();
				}
			});

			StreamSource in = new StreamSource(new FileInputStream(TestFile.AC11_XML.getFile().toFile()));
			StreamResult out = new StreamResult(new FileOutputStream(Paths.get("test.txt").toFile()));
			transformer.transform(in, out);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
