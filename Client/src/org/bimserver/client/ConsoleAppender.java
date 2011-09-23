package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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