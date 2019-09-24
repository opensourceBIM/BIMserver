package org.bimserver.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.custom.CustomBim;
import org.bimserver.custom.HibernateUtil;
import org.hibernate.Session;

public class DownloadTest extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poid = request.getParameter("poid");
		String oid = request.getParameter("oid");
		System.out.println("poid::"+poid);
		String fieldName = request.getParameter("fieldName");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CustomBim customBim = new CustomBim(poid, oid, fieldName);
		CustomBim newBim = em.find(CustomBim.class, customBim);
		String filepath=newBim.getFieldValue();
		session.getTransaction().commit();
		session.close();
		File file = new File(filepath);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName().replaceAll("_"+poid+"_"+oid, "") + "\"");
        response.setContentType("application/octet-stream");
		InputStream inputStream = new FileInputStream(file);
		//InputStream inputStream = request.getServletContext().getResourceAsStream(filepath);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
}
