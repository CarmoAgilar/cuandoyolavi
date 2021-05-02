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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom, appat, domicilio, apmat, password, birth, tel, cel, ip, iph;
            int edad, puerto, puertoh;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            password = request.getParameter("password");
            domicilio = request.getParameter("domicilio");
            birth = request.getParameter("birth");
            tel = request.getParameter("tel");
            cel = request.getParameter("cel");
            
            edad = Integer.parseInt(request.getParameter("edad"));
            
            
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
                
                String m = "insert into cuentas (nom_usu, appat_usu, apmat_usu, edad_usu, , password_usu, birth_usu, domicilio_usu, tel_usu, cel_usu) values ('"+nom+"', '"+appat+"', '"+apmat+"', "+edad+", '"+password+"', '"+birth+"', '"+domicilio+"', '"+tel+"', '"+cel+"')";
                //Ejecutar la sentencia
                set.executeUpdate(m);
                System.out.println("Registro exitoso");
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registrarse</title>");
                out.println("<link rel='stylesheet' href='./CSS/style.css'>");
                out.println("<link href=\'https://fonts.googleapis.com/css2?family=Lemonada:wght@300&family=Merriweather:ital@1&family=Montserrat:wght@500&display=swap' rel='stylesheet\'>");
                out.println("</head>");
                out.println("<body>");
                //out.println("Tu nombre es: "+nom+"<br> Tu apellido paterno es: "+appat+"<br>"+"Tu apellido materno es: "+apmat+"<br> Tu correo es: "+correo+"<br> Tu edad es: "+edad);
                //out.println("<br> IP local: "+ip+"<br> Puerto local: "+puerto+"<br> IP Remota: "+iph+"<br> Puerto Remoto: "+puertoh);
                out.println("<div class = 'contenedora'>");
                out.println("<h1>Registro exitoso</h1>");
                out.println("</div>");
                out.println("<br>"
                        + "<hr>"
                        + "<br>");
                out.println("<table id = 'tabla' border='2'>"
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
                out.println("<a href='index.html'>Regresar</a>");
                out.println("<br>"
                        + "<br>");
                       out.println("<br>"
                               + "<br>"
                               + "<hr>"); 
                out.println("<div class = 'contenedorb'>");
                out.println("</div>");
        
                out.println("</body>");
                out.println("</html>");
            
            }catch(Exception e){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registro</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registro no exitoso, vuelva a intentarlo</h1>" + "<a href='Registrarme.html'>Regresar a la pagina principal</a>");
                out.println("</body>");
                out.println("</html>");
                
                System.out.println("No se registró en la tabla");
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
