package com.tsoft.web.gluepad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Servlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3694568157820123146L;

	// File written for glue command integration
	// TODO should be moved to config along with any sensitive stuff
	private static final String GLUE_CMD_DIR = "g:\\source\\git\\Glue\\Tube\\bin\\Release\\gluecmd.txt";

	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		// This stuff is mostly hello world type placeholder content 
		// to prove servelet is working with a simple case
		resp.setContentType("text/plain"); 
		PrintWriter out = resp.getWriter();

		out.println("Gluepad home");

		Enumeration<String> names = req.getHeaderNames();
		while(names.hasMoreElements()) 
		{ 
			String name = (String) names.nextElement(); 
			String val = req.getHeader(name);
			
			if(val != null) 
			{ 
				out.println(name + " : " + val); 
			} 
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		String button = req.getParameter("button");
		
		switch (button)
		{
			case "button_mouse_hold":
				writeGlueCmd("auto-tool-begin");
			break;
			
			case "button_mouse_release":
				writeGlueCmd("auto-tool-end");
			break;
			
			case "button_mouse_lock":
				writeGlueCmd("mouse-lock");
			break;
			
			case "button_mouse_unlock":
				writeGlueCmd("mouse-unlock");
			break;
			
			default:
			break;
		}
		
		req.getRequestDispatcher("dash.jsp").forward(req, resp);		
	}
	
	public void  writeGlueCmd(String command)
	{
		try 
		{
			File file = new File(GLUE_CMD_DIR);
			FileWriter fileWriter = new FileWriter(file, true);
			
			// TODO occasionally need to clear old commands from the file
			fileWriter.write(command + "\r\n");
			fileWriter.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
