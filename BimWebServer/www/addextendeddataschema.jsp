<%@page import="org.bimserver.interfaces.objects.SFile"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.bimserver.interfaces.objects.SExtendedDataSchemaType"%>
<%@page import="org.bimserver.interfaces.objects.SExtendedDataSchema"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Add Extended Data Schema</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService(request);
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {
		SExtendedDataSchema extendedDataSchema = new SExtendedDataSchema();
		SFile sFile = new SFile();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 500);
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem next = iter.next();
			if (!next.isFormField()) {
				sFile.setData(next.get());
			} else {
				String fieldName = next.getFieldName();
				if ("name".equals(fieldName)) {
					extendedDataSchema.setName(next.getString());
				} else if ("validate".equals(fieldName)) {
					extendedDataSchema.setValidate(true);
				} else if ("url".equals(fieldName)) {
					extendedDataSchema.setUrl(next.getString());
				} else if ("namespace".equals(fieldName)) {
					extendedDataSchema.setNamespace(next.getString());
				} else if ("type".equals(fieldName)) {
					extendedDataSchema.setType(SExtendedDataSchemaType.valueOf(next.getString()));
				}
			}
		}
		long fid = loginManager.getService(request).uploadFile(sFile);
		extendedDataSchema.setFileId(fid);
		loginManager.getService(request).addExtendedDataSchema(extendedDataSchema);
		response.sendRedirect("extendeddataschemas.jsp");
	}
%>
<form enctype="multipart/form-data" method="post">
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" class="focusme"></input></td>
</tr>
<tr>
	<td><label for="namespace">Namespace</label></td>
	<td><input name="namespace" id="namespace"></input></td>
</tr>
<tr>
	<td><label for="url">URL to Schema</label></td>
	<td><input name="url" id="url" size="40"></input></td>
	<td> OR </td>
	<td><label for="file">File</label></td>
	<td><input name="file" type="file" id="file"></input></td>
</tr>
<tr>
	<td><label for="validate">Validate</label></td>
	<td><input name="validate" type="checkbox" id="validate"></input></td>
</tr>
<tr>
	<td><label for="type">Type</label></td>
	<td><select name="type" id="type">
<%
	for (SExtendedDataSchemaType type : SExtendedDataSchemaType.values()) {
		out.print("<option value=\"" + type.name() + "\">" + type.name() + "</option>");
	}
%>
	</select></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" name="add" value="Add"/></td>
</tr>
</table>
</form>
</fieldset>
</div>
<%@ include file="footer.jsp"%>