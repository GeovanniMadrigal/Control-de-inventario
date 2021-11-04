
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.modeloInventario"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.inventarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Inventario</h1>
            <a class="btn btn-success" href="Controlador?accion=agregarProducto">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Clave</th>
                        <th class="text-center">Descripcion</th> 
                        <th class="text-center">Lote</th>
                        <th class="text-center">Caducidad</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    inventarioDAO inventarioDAO=new inventarioDAO();
                    List<modeloInventario>list=inventarioDAO.mostrarInventario();
                    Iterator<modeloInventario>iter=list.iterator();
                    modeloInventario modeloInventario=null;
                    while(iter.hasNext()){
                        modeloInventario=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= modeloInventario.getClave()%></td>
                        <td class="text-center"><%= modeloInventario.getDescripcion()%></td>
                        <td class="text-center"><%= modeloInventario.getLote()%></td>
                        <td class="text-center"><%= modeloInventario.getCaducidad()%></td>
                        <td class="text-center"><%= modeloInventario.getCantidad()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editarProducto&id=<%= modeloInventario.getIdInventario()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminarProducto&id=<%= modeloInventario.getIdInventario()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
