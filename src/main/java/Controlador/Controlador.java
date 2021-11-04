/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.modeloInventario;
import Modelo.modeloUsuarios;
import ModeloDAO.inventarioDAO;
import ModeloDAO.usuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GEOVANNI
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    String mostrarProducto = "vistas/mostrarProducto.jsp";
    String agregarProducto = "vistas/agregarProducto.jsp";
    String editarProducto = "vistas/editarProducto.jsp"; 
    String index = "index.jsp";
    modeloInventario modeloInventario = new modeloInventario();
    inventarioDAO inventarioDAO = new inventarioDAO();
    int id;
    int i = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String acceso = ""; 
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("mostrarProducto")){
            acceso = mostrarProducto;            
        }else if(accion.equalsIgnoreCase("agregarProducto")){
            acceso = agregarProducto;
        }
        else if(accion.equalsIgnoreCase("Agregar")){
            String aux1=request.getParameter("txtIdInventario");
            String Clave=request.getParameter("txtClave");
            String Descripcion=request.getParameter("txtDescripcion");
            String Lote=request.getParameter("txtLote");
            String Caducidad=request.getParameter("txtCaducidad");
            String aux2=request.getParameter("txtCantidad");
            int IdInventario=Integer.parseInt(aux1);
            int Cantidad=Integer.parseInt(aux2);
            
            
            modeloInventario.setIdInventario(IdInventario);
            modeloInventario.setClave(Clave);
            modeloInventario.setDescripcion(Descripcion);
            modeloInventario.setLote(Lote);
            modeloInventario.setCaducidad(Caducidad);
            modeloInventario.setCantidad(Cantidad);
            
            inventarioDAO.agregarProducto(modeloInventario);
            acceso=mostrarProducto;
        }
        else if(accion.equalsIgnoreCase("editarProducto")){
            request.setAttribute("IdInventario",request.getParameter("id"));
            acceso=editarProducto;
        }
        else if(accion.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String Clave=request.getParameter("txtClave");
            String Descripcion=request.getParameter("txtDescripcion");
            String Lote=request.getParameter("txtLote");
            String Caducidad=request.getParameter("txtCaducidad");
            String aux2=request.getParameter("txtCantidad");
            int Cantidad=Integer.parseInt(aux2);
            modeloInventario.setIdInventario(id);
            modeloInventario.setClave(Clave);
            modeloInventario.setDescripcion(Descripcion);
            modeloInventario.setLote(Lote);
            modeloInventario.setCaducidad(Caducidad);
            modeloInventario.setCantidad(Cantidad);
            System.out.println("Prueba de funcina actualizar");
            inventarioDAO.editarProduto(modeloInventario);
            acceso=mostrarProducto;
        }
        else if(accion.equalsIgnoreCase("eliminarProducto")){
            
            id=Integer.parseInt(request.getParameter("id"));
            System.out.print(id);
            modeloInventario.setIdInventario(id);
            inventarioDAO.eliminarProducto(id);
            acceso=mostrarProducto;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = ""; 
        String accion = request.getParameter("accion");
        usuariosDAO usuariosDAO=new usuariosDAO();
        List<modeloUsuarios>list=usuariosDAO.adquirirUsuarios();
        Iterator<modeloUsuarios>iter=list.iterator();
        modeloUsuarios modeloUsuarios=null;
        
        if(accion.equalsIgnoreCase("Ingresar")){
            String Nombre=request.getParameter("txtNombre");
            String Contraseña=request.getParameter("txtContrasena");
            
            while(iter.hasNext()){
                modeloUsuarios=iter.next();
                System.out.println(modeloUsuarios);
                String nombreServidor=modeloUsuarios.getNombre();
                String contraseñaServidor=modeloUsuarios.getContraseña();
                
                if(Nombre.equalsIgnoreCase(nombreServidor)){
                    if(Contraseña.equalsIgnoreCase(contraseñaServidor)){
                        acceso=mostrarProducto;
                        System.out.println("Estoy aqui de nuevo yo");
                    }
                }else {
                    
                }
            }            
        }else if(accion.equalsIgnoreCase("agregarUsuario")){
            System.out.println("Todavia no tengo esta pagina");
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
