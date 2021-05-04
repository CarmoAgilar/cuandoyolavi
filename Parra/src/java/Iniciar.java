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
/*
Connection nos ayuda a realizar la conexion con las bd, con el servidor
*/
import java.sql.Connection;
import java.sql.DriverManager;
/*
Statement nos ayuda a poder definir y manipular los datos de las bd
creacion de la bd, insertar tablas, eleminar tablas,  create, drop, alter
    manipulacion de los datos, insert, update, delete
*/
import java.sql.Statement;
/*
nos ayuda para las querrys, o las consultas a la bd
*/
import java.sql.ResultSet;
import javax.servlet.ServletConfig;


/**
 *
 * @author demon
 */
public class Iniciar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //variables globales
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //el constructor del servlet
    //nos va a ayudar a inicializar la conexion con la bd
    
    public void init(ServletConfig cfg) throws ServletException{
        
        //lo primero que necesitamos es trazar la ruta al servidor DB
        String URL = "jdbc:mysql:3306//localhost/heladosjimin";
        //driver:gestor:puerto//IP/nombreBD
        
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Variables del formulario
            String nombre, password;
            
            
            //Variables para el ticket
            String nombre_iniciado, appat_iniciado, apmat_iniciado, birth_iniciado, domicilio_iniciado, tel_iniciado, cel_iniciado;
                    
            nombre = request.getParameter("nom_inicio");

            password = request.getParameter("password_inicio");
            /* TODO output your page here. You may use following sample code. */
            
            try{
                //codigo java para la consulta
                
                //tenemos que crear la querry
                
                String q = "select * from heladeriaschalco";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                boolean s = false;
                while(rs.next()){
                    
                    System.out.println("Nombre ecrito "+ nombre);
                    System.out.println("Nombre "+ rs.getString("nom_usu"));
                    System.out.println("Contra puesta "+ password);
                    System.out.println("Contraseña "+ rs.getString("password_usu"));
                //mientras exista un registro hay que obtener los datos de la consulta
                    if(nombre.equals(rs.getString("nom_usu")) && password.equals(rs.getString("password_usu")) ){
                              
                            s = true;
                        
                            nombre_iniciado = rs.getString("nom_usu");
                            appat_iniciado = rs.getString("appat_usu");
                            apmat_iniciado = rs.getString("apmat_usu");
                            birth_iniciado = rs.getString("birth_usu");
                            domicilio_iniciado = rs.getString("domicilio_usu");
                            tel_iniciado = rs.getString("tel_usu");
                            cel_iniciado = rs.getString("cel_usu");
                            
                              
                            break;
                          
                    }
                }
                    if(s == true){
                    
                        out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>BEN AND JERRY’S</title>");
                            out.println("<link rel='stylesheet' href='css/style.css'>");
                            out.println("<link href=\'https://fonts.googleapis.com/css2?family=Lemonada:wght@300&family=Merriweather:ital@1&family=Montserrat:wght@500&display=swap' rel='stylesheet\'>");
                            out.println("</head>");
                            out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">"
                                    + "<center>"
                                    + "<div class='login-box'>"
                                    + "<h1 style='color: white;'>Sesion iniciada</h1>");
                                    
                            
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
                                    
                                    + "</style>"
                                    + "<a href=\"PPrincipal.html\"><input class=\"boton\" type=\"button\" name=\"Entrar a la tienda\" value=\"Entrar a la tienda\"></a>" 
     
                                    + "<br>"
                                    + "<a href=\"index.html\"><input class=\"boton\" type=\"button\" name=\"Volver\" value=\"Volver\"></a>"
                                    + "<hr>"

                                    + "  <footer style=\"padding-top: 300px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> "
                                    + "</div>"
                                    + "</center>");
                            out.println("</body>");
                    
                            out.println("</html>");
                    }else{
                        out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>BEN AND JERRY’S</title>");
                            out.println("<link rel='stylesheet' href='./css/style.css'>");
                            out.println("</head>");
                            out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
                            
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
                            
                            out.println("<div class = 'login-box'>"
                                    + "<h1>Sesion no iniciada");
                            
                            out.println("<h2>Usuario no registrado</h2>"
                                    + "<a href=\"index.html\"><input class=\"boton\" type=\"button\" name=\"Volver\" value=\"Volver\"></a>"
                                    + "<hr>");

                            out.println("  <footer style=\"padding-top: 300px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> "
                                    + "</div>");
                            out.println("</body>");
                            out.println("</html>");
                    }
                    
               
                //hay que cerrar los hilos
                rs.close();
                set.close();
 
            }catch(Exception e){
                System.out.println("Error al realizar la consulta");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }

        }
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
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
            System.out.println("Se destruyo wiiii");
        
        }catch(Exception e){
            super.destroy();
        
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}