package org.bimserver.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.google.gson.JsonObject;

public class GetLicense extends HttpServlet {
	public void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		PrintWriter printWriter=servletResponse.getWriter();
		try
		{
		System.out.println("inside getLicense");
		File file = new File(System.getProperty("java.io.tmpdir").replace("/temp", "/expiration"+File.separator+"expiration.txt"));
		InputStream inputStream = new FileInputStream(file);
		System.out.println("inputStream:::::"+inputStream);
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, "UTF-8");
		String expirationdate = writer.toString();
		
		if(!"trial version".equalsIgnoreCase(expirationdate))
		{
			byte[] valueDecoded = Base64.decodeBase64(expirationdate);
			System.out.println("Decoded value is " + new String(valueDecoded));
			expirationdate=new String(valueDecoded);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate expDate = LocalDate.parse(expirationdate, formatter);
			LocalDate localDate = LocalDate.now();
			if(expDate.isBefore(localDate))
			{
				expirationdate="license expired";
			}
		}
		System.out.println("expirationdate:::::::"+expirationdate);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("result", expirationdate);
		printWriter.print(jsonObject);  
		}
		catch (Exception e) {
			System.out.println(e);
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("result", "trial version");
			printWriter.print(jsonObject);  
		}
	}
}
