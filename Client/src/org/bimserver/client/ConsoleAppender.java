package org.bimserver.client;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class ConsoleAppender extends AppenderSkeleton  {

	private static LogHandler logHandler;
	private static PrintWriter printWriter;
	
	static {
		printWriter = new PrintWriter(new Writer(){

			@Override
			public void close() throws IOException {
			}

			@Override
			public void flush() throws IOException {
			}

			@Override
			public void write(char[] cbuf, int off, int len) throws IOException {
				ConsoleAppender.append(new String(cbuf, off, len));
			}});
	}
	
	public static void setLogHandler(LogHandler logHandler) {
		ConsoleAppender.logHandler = logHandler;
	}
	
	public static void append(String str) {
		if (logHandler != null) {
			logHandler.log(str);
		} else {
			System.out.println(str);
		}
	}
	
	@Override
	public void append(LoggingEvent loggingEvent) {
		append(loggingEvent.getMessage().toString());
	}

	@Override
	public void close() {
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	public static PrintWriter getPrintWriter() {
		return printWriter;
	}
}