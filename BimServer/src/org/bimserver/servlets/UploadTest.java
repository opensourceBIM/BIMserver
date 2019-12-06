package org.bimserver.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bimserver.custom.CustomBim;
import org.bimserver.custom.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadTest extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadTest.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poid = request.getParameter("poid");
		String oid = request.getParameter("oid");
		String fieldName = request.getParameter("fieldName");
		String fieldType = request.getParameter("fieldType");
		String revisionId = request.getParameter("revisionId");
		System.out.println("poid::"+poid);
		//System.out.println(fieldValue.getName());
		String imgFilePath=uploadImage(request);
		if(!"failed".equalsIgnoreCase(imgFilePath))
		{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CustomBim customBim = new CustomBim(poid, oid, fieldName);
		CustomBim newBim = em.find(CustomBim.class, customBim);
		System.out.println("customBim  " + newBim);
		
		if (newBim == null) {
			CustomBim bim = new CustomBim(poid, oid, fieldName, fieldType, imgFilePath, revisionId);
			System.out.println("before create");
			session.save(bim);
			System.out.println("after create ");
		} else {
			/*if(imgFilePath.isEmpty())
			{
			imgFilePath=newBim.getFieldValue();
			}*/
			System.out.println("imgFilePath:::"+imgFilePath);
			 CustomBim bim = new CustomBim(poid,oid,fieldName,fieldType,imgFilePath,revisionId) ;
			newBim.setFieldType(fieldType);
			newBim.setFieldValue(imgFilePath);
			newBim.setRevisionId(revisionId);
			System.out.println("before update");
			session.update(newBim);
			System.out.println("after update");

		}
		session.getTransaction().commit();
		session.close();
		System.out.println("inside servlet");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("successfully uploaded");
		LOGGER.info("successfully uploaded");
		}
		else
		{
			System.out.println("inside servlet");
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.print("unable to upload the file");
			LOGGER.error("unable to upload the file");
		}
		

	}

	public String uploadImage(HttpServletRequest request) {
		  final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
		  final int MAX_FILE_SIZE = 1024 * 1024 * 40;
		  final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
		  String ImgFilePath="";
		  String poid = request.getParameter("poid");
		  String oid = request.getParameter("oid");
		//if (ServletFileUpload.isMultipartContent(request)) {
		  try {
			System.out.println("inside is multipart");
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            factory.setSizeThreshold(MEMORY_THRESHOLD);
	            System.out.println("System.getProperty(\"java.io.tmpdir\"))::::::::"+System.getProperty("java.io.tmpdir"));
	            //factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            upload.setFileSizeMax(MAX_FILE_SIZE);
	            upload.setSizeMax(MAX_REQUEST_SIZE);
	            ServletContext context = request.getServletContext();
	            //String realContextPath = context.getRealPath(request.getContextPath());
	            String tempPath=System.getProperty("java.io.tmpdir").replace("/temp", "/upload");
	            System.out.println("uploadPath::"+tempPath);
	            File uploadDir = new File(tempPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdir();
	            }
	            System.out.println("abs path"+uploadDir.getAbsolutePath());
	
		
            List<FileItem> formItems = upload.parseRequest(request);
            System.out.println("formItems size:"+formItems.size());
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        System.out.println("fileName::"+fileName);
                        String ext=fileName.substring(fileName.lastIndexOf("."), fileName.length());
                        String partialName=fileName.replace(ext, "");
                        String filePath = tempPath + File.separator + partialName+"_"+poid+"_"+oid+ext;
                        ImgFilePath=filePath;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        request.setAttribute("message", "File " + partialName + " has uploaded successfully!");
                    }
                }
            }
            return ImgFilePath;
        } catch (Exception ex) {
        	ex.printStackTrace();
            request.setAttribute("message", "There was an error: " + ex.getMessage());
            return "failed";
        }
	}
	//}
}
