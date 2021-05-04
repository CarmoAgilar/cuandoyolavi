/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fer
 */

public class Registrarse extends HttpServlet {

        
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
            //colocamos el tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            
            /*
            en algunas ocaciones enviar error al conectarse con la bd
            y eso se debe a que ya estegrado el puerto en el driver
            URL = "jdbc:mysql://localhost/registro4iv8";
            */
            URL = "jdbc:mysql://localhost/heladosjimin";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no exitosa");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom, appat, domicilio, apmat, password, birth, tel, cel, ip, iph;
            int edad, puerto, puertoh;
            
            nom = request.getParameter("nom");
            appat = request.getParameter("appa");
            apmat = request.getParameter("apma");
            password = request.getParameter("passwor");
            domicilio = request.getParameter("domicili");
            birth = request.getParameter("birt");
            tel = request.getParameter("te");
            cel = request.getParameter("ce");
            
            edad = Integer.parseInt(request.getParameter("eda"));
            
            
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            iph = request.getRemoteAddr();
            puertoh = request.getRemotePort();
            
            /*
            Una vez que tengamos los datos vamos a insertarlos en la bd
            insert into nombre_tabla (definicion_atrivuto, definicion_atributo, ...)
            value ("valores_cadena", valores numericos, ...)
            */
                    
            try{
                
                String q = "INSERT INTO heladeriaschalco"
                         + "(nom_usu, appat_usu, apmat_usu, edad_usu, password_usu, birth_usu, domicilio_usu, tel_usu, cel_usu) "
                         + "VALUES ('"+nom+"', '"+appat+"', '"+apmat+"', "+edad+", '"+password+"', '"+birth+"', '"+domicilio+"', '"+tel+"', '"+cel+"')";           
//Ejecutar la sentencia

                set.executeUpdate(q);
                
                System.out.println("Registro exitoso");

                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro Sesion</title>"
+"<meta charset='UTF-8'>" 
+"<meta http-equiv='X-UA-Compatible' content='IE=edge'>" 
+"<meta name='viewport' content='width=device-width', initial-scale='1.0'>" 
+"<script src='https://kit.fontawesome.com/1ff3fcc7d1.js' crossorigin='anonymous'></script>" 
+"<script language='JavaScript' type='text/JavaScript' src='js/validacion.js'></script>");
                
                out.println("</head>");
                out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
           
                out.println("<style>"
                        + ".table{\n"
                        + "margin-right; 4 rem;\n"
  
                        + "}\n"
                                    + "a{\n" +
                                    "  color: #58f0f0;\n" +
                                    "  font-family: 'Montserrat', sans-serif;\n" +
                                    "  text-decoration: none;\n" +
                                    "}\n" +
                                    "a:hover{\n" +
                                    "  color: #a0d5f3;\n" +
                                    "}"
                                    + ".boton{\n" +
                                    "    width: 100%;\n" +
                                    "    background: none;\n" +
                                    "    border: 2px solid rgb(0, 225, 255);\n" +
                                    "    border-radius: 3px;\n" +
                                    "    color: white;\n" +
                                    "    margin-top: 10px;\n" +
                                    "    font-size: 18px;\n" +
                                    "}\n" +
                                    ".boton:hover{\n" +
                                    "    background-color: rgb(0, 225, 255);\n" +
                                    "}"
                                    + ".login-box{\n" +
"    width: 500px;\n" +
"    position: absolute;\n" +
"    top: 50%;\n" +
"    left: 50%;\n" +
"    transform: translate(-50%,-50%);\n" +
"    color: white;\n" +
"}\n" +
".login-box h1{\n" +
"    float: left;\n" +
"    font-size: 40px;\n" +
"    border-bottom: 6px solid rgb(0, 225, 255);\n" +
"    margin-bottom: 50px;\n" +
"}"
                                    
                                    + "</style>");
                out.println("<div class = 'login-box'>");
                out.println("<h1>Registro exitoso</h1>");
               
                out.println("<br>"
                        + "<hr>"
                        + "<br>");
                out.println("<table border='2' style=\"margin-right; 8 rem;\">"
                    + "<thead>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Fecha de Nacimiento</th>"
                        + "<th>Domicilio</th>"
                        + "<th>Numero de telefono fijo</th>"
                        + "<th>Numero de telefono de casa</tr>"
                        
                    + "</thead>");
                out.println("<tbody>"
                            + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                            + "<td>"+edad+"</td>"
                            + "<td>"+birth+"</td>"
                            + "<td>"+domicilio+"</td>"
                            + "<td>"+tel+"</td>"
                            + "<td>"+cel+"</td></tr>"
                            + "</tbody>");
                
                out.println("</table>");
                out.println("<br>"
                        + "<hr>");
                out.println("<a href=\"index.html\"><input class=\"boton\" type=\"button\" name=\"Volver\" value=\"Volver\"></a>");
                out.println("<br>"
                        + "<br>");
                       out.println("<br>"
                               + "<hr>"
                               + "  <footer style=\"padding-top: 100px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> "); 
                out.println("</body>");
                out.println("</html>");
            
            }catch(Exception e){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>BEN AND JERRY’S</title>");            
                out.println("</head>");
                out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
                out.println("<div = 'login-box'>");
                                out.println("<style>"
                                    + "a{\n" +
                                    "  color: #58f0f0;\n" +
                                    "  font-family: 'Montserrat', sans-serif;\n" +
                                    "  text-decoration: none;\n" +
                                    "}\n" +
                                    "a:hover{\n" +
                                    "  color: #a0d5f3;\n" +
                                    "}"
                                    + ".boton{\n" +
                                    "    width: 100%;\n" +
                                    "    background: none;\n" +
                                    "    border: 2px solid rgb(0, 225, 255);\n" +
                                    "    border-radius: 3px;\n" +
                                    "    color: white;\n" +
                                    "    margin-top: 10px;\n" +
                                    "    font-size: 18px;\n" +
                                    "}\n" +
                                    ".boton:hover{\n" +
                                    "    background-color: rgb(0, 225, 255);\n" +
                                    "}"
                                    + ".login-box{\n" +
"    width: 280px;\n" +
"    position: absolute;\n" +
"    top: 50%;\n" +
"    left: 50%;\n" +
"    transform: translate(-50%,-50%);\n" +
"    color: white;\n" +
"}\n" +
".login-box h1{\n" +
"    float: left;\n" +
"    font-size: 40px;\n" +
"    border-bottom: 6px solid rgb(0, 225, 255);\n" +
"    margin-bottom: 50px;\n" +
"}"
                                    
                                    + "</style>");
                out.println("<h1>Registro no exitoso, vuelva a intentarlo</h1>" 
                        + "<a href=\"index.html\"><input class=\"boton\" type=\"button\" name=\"Volver\" value=\"Volver\"></a>");
                out.println("  <footer style=\"padding-top: 300px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> "
                        + "</div>");
                out.println("</body>");
                out.println("</html>");
                
                System.out.println("No se registró en la tabla");
                System.out.println(nom);
                System.out.println(apmat);
                System.out.println(cel);
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    //hace falta un destructor, el destructor libera las conexiones y la memoria de las variables
    
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