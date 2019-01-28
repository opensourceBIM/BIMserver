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

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.concurrent.Callable;
//import java.util.concurrent.CompletionService;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Future;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.ifc.file.compare.NewIfcFileCompare;
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
//import org.bimserver.ifc.file.writer.IfcStepSerializer;
//
//public class IfcToEmfAndBackTest {
//	private final HtmlWriter htmlWriter = new HtmlWriter(Paths.get("result.html"));
//
//	private class Result {
//		public Result(File sourceFile) {
//			file = sourceFile;
//		}
//
//		private File file;
//		private boolean readSuccess;
//		private boolean writeSuccess;
//		private boolean compareResult;
//		private String readError;
//		private String writeError;
//
//		public File getFile() {
//			return file;
//		}
//
//		public boolean isCompareResult() {
//			return compareResult;
//		}
//
//		public void setCompareResult(boolean compareResult) {
//			this.compareResult = compareResult;
//		}
//
//		public boolean isReadSuccess() {
//			return readSuccess;
//		}
//
//		public void setReadSuccess(boolean readSuccess) {
//			this.readSuccess = readSuccess;
//		}
//
//		public boolean isWriteSuccess() {
//			return writeSuccess;
//		}
//
//		public void setWriteSucces(boolean writeSuccess) {
//			this.writeSuccess = writeSuccess;
//		}
//
//		public String getReadError() {
//			return readError;
//		}
//
//		public void setReadError(String readError) {
//			this.readError = readError;
//		}
//
//		public String getWriteError() {
//			return writeError;
//		}
//
//		public void setWriteError(String writeError) {
//			this.writeError = writeError;
//		}
//	}
//
//	private SchemaDefinition schema;
//	private ExecutorService executorService = new ThreadPoolExecutor(4, 4, Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingDeque<Runnable>());
//	private CompletionService<Result> completionService = new ExecutorCompletionService<Result>(executorService);
//
//	public static void main(String[] args) {
//		if (args.length > 0) {
//			String action = args[0];
//			if (action.equalsIgnoreCase("test")) {
//				new IfcToEmfAndBackTest(args[1]).start();
//			}
//		} else {
//			new IfcToEmfAndBackTest("G:\\ifc selected").start();
//		}
//	}
//	
//	public IfcToEmfAndBackTest(String testFilesDir) {
//		
//	}
//
//	private void start() {
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		htmlWriter.startTable("File", "Successfull read", "Successfull write", "Compare result", "Error");
//		completionService.submit(new Callable<Result>(){
//			@Override
//			public Result call() throws Exception {
//				return test(TestFile.PAOLO.getFile());
//			}});
////		 for (final TestFile testFile : TestFile.values()) {
////		 completionService.submit(new Callable<Result>() {
////		 @Override
////		 public Result call() throws Exception {
////		 return test(testFile.getFile());
////		 }
////		 });
////		 }
////		File dir = Paths.get("G:\\ifc selected");
////		for (final File file : dir.listFiles()) {
////			if (file.getName().endsWith(".ifc")) {
////				completionService.submit(new Callable<Result>() {
////					@Override
////					public Result call() throws Exception {
////						return test(file);
////					}
////				});
////			}
////		}
//		try {
//			Future<Result> take = completionService.take();
//			while (take != null) {
//				Result result = take.get();
//				String error = "";
//				if (!result.isReadSuccess()) {
//					error = result.getReadError();
//				} else {
//					if (!result.isWriteSuccess()) {
//						error = result.getWriteError();
//					}
//				}
//				htmlWriter.addRow(result.getFile().getName(), "" + result.isReadSuccess(), "" + result.isWriteSuccess(), "" + result.isCompareResult(), error);
//				take = completionService.take();
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//		htmlWriter.endTable();
//		htmlWriter.close();
//		// test(Paths.get("G:\\ifc selected\\00000 test.ifc"));
//	}
//
//	private Result test(File sourceFile) {
//		File destFile = Paths.get(sourceFile.getAbsolutePath() + ".dump");
//		Result result = new Result(sourceFile);
//		IfcModel model = null;
//		try {
//			FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
//			fastIfcFileReader.read(sourceFile);
//			model = fastIfcFileReader.getModel();
//		} catch (IncorrectIfcFileException e) {
//			result.setReadSuccess(false);
//			result.setReadError("Incorrect IFC File " + e.getMessage());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//			sourceFile.renameTo(Paths.get("incorrect\\" + sourceFile.getName()));
//			return result;
//		} catch (Exception e) {
//			e.printStackTrace();
//			result.setReadSuccess(false);
//			result.setReadError(e.getMessage());
//			sourceFile.renameTo(Paths.get("incorrect\\" + sourceFile.getName()));
//			return result;
//		}
//		result.setReadSuccess(true);
//		try {
//			IfcStepSerializer writer = new IfcStepSerializer(project, user, "", model, schema);
//			writer.writeToFile(destFile);
//		} catch (Exception e) {
//			result.setWriteSuccess(false);
//			result.setWriteError(e.getMessage());
//			return result;
//		}
//		model = null;
//		result.setWriteSuccess(true);
//		try {
//			NewIfcFileCompare compare = new NewIfcFileCompare(sourceFile, destFile);
//			boolean compare2 = compare.compare();
//			if (compare2) {
//				sourceFile.renameTo(Paths.get("oke\\" + sourceFile.getName()));
//			} else {
//				compare.dumpSource(Paths.get("faults\\" + sourceFile.getName() + ".1"));
//				compare.dumpGenerated(Paths.get("faults\\" + sourceFile.getName() + ".2"));
//			}
//			result.setCompareResult(compare2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//}