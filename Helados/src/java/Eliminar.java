/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author crist
 */
public class Eliminar extends HttpServlet {
    
    //variables globales
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor del servlet
    //nos va a ayudar a inicializar la conexion con la base de datos
    
    public void init(ServletConfig cfg) throws ServletException{
        //lo primero que necesitamos es trazar la ruta al servidor de la bd
        String URL = "jdbc:mysql://localhost/heladosjimin";
        //driver:gestor:puerto//ip/nombreBD
        String userName = "root";
        String password = "diegoca";
                
        try{
            //tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Conexión no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //para eliminar necesitamos obtener el id
            
            String contrasena;
            contrasena = request.getParameter("contrasena");
            if(contrasena.equals("bebeconmetralleta")){
                int id;

                id = Integer.parseInt(request.getParameter("ideliminar"));

                //preparo mi sentencia: delete from tabla where atributo = valor

                String q = "delete from heladeriaschalco where id_usu = "+id;

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Eliminar</title>");
                out.println("<link rel=\"stylesheet\" href=\"./CSS/style.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class = 'contenedora'>");
                try{
                    //update hay una modificacion/actualizacion a la tabla
                    set.executeUpdate(q);
                    System.out.println("Registro Eliminado");
                    out.println("<h1 >Usuario Eliminado</h1>");
                    set.close();
                }catch(Exception e){
                    out.println("<h1>Usuario NO Eliminado</h1>");
                    System.out.println("No se pudo eliminar el usuario");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                }
                out.println("</div>");
                out.println("<hr>");
                out.println("<br>");
                out.println("<hr>");
                out.println("<a href='index.html'>Regresar a la pagina principal </a>"
                            + "<br>"
                            + "<a href='Consultar'>Consultar Usuarios</a>");
                out.println("<hr>");
                out.println("<div class = 'contenedorb'>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>BEN AND JERRY’S</title>");
                out.println("<link rel='stylesheet' href='./CSS/style.css'>");
                out.println("<link href=\'https://fonts.googleapis.com/css2?family=Lemonada:wght@300&family=Merriweather:ital@1&family=Montserrat:wght@500&display=swap' rel='stylesheet\'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class = 'contenedora'>");
                out.println("<h1>Contraseña incorrecta</h1>");
                out.println("</div>");

                out.println("<br>"
                        + "<hr>");
                out.println("<a href='index.html'>Regresar</a>");
                out.println("<br>"
                        + "<br>");
                       out.println("<br>"
                               + "<hr>"); 
                out.println("<div class = 'contenedorb'>");
                out.println("</div>");
        
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}