package com.fp.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static int numDir;
	 static PrintWriter out ;
    /**
     * Default constructor. 
     */
	 
	 public static void walkin(File dir) {
		 
	        File listFile[] = dir.listFiles();
	        if (listFile != null && listFile.length > 0) {
	            for (int i = 0; i < listFile.length; i++) {
	                if (listFile[i].isDirectory())
	                    walkin(listFile[i]);
	                out.println (listFile[i]);
	        		out.println ("<BR>");
	                System.out.println(listFile[i]);
	            }
	        } else {
	            numDir++;
	            System.out.print(numDir + ", "); // Por Debug, pare ver los directorios que va encontrando.
	        }
	    }
	 
    public Principal() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		out = response.getWriter();
		out.println ("<HTML>");	
		out.println ("<BODY>");			
		out.println ("<H1>Directorios del ordenador</H1>");
		out.println ("<BR>");
		  try {

	            numDir = 0;
	            walkin(new File("C:\\Users\\dyang")); // Directorio raÃ­z, modificar para pruebas..
	            System.out.println("\nSe han encontrado: " + numDir + " directorios");
	            File salida = new File("C:\\Users\\apinon\\salida.txt");
	            BufferedWriter bw = new BufferedWriter(new FileWriter(salida));
	            bw.write("Se han encontrado: " + numDir + " directorios \n");
	            bw.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		  out.println ("<BR>");
          out.println ("<BR>");
          out.println ("<H2>Se han encontrado: " + numDir + " directorios </H2>");
		  out.println ("</BODY>");
		  out.println ("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}