<%@page import="Modelo.modeloInventario"%>
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
            <div class="col-lg-6">
              <%
              inventarioDAO inventarioDAO=new inventarioDAO();
              //int id=request.getAttribute("IdInventario");
              int id=Integer.parseInt((String)request.getAttribute("IdInventario"));
              //System.out.println("variable" +id);
              modeloInventario modeloInventario=(modeloInventario)inventarioDAO.mostrarProducto(id);
          %>    
            <h1>Modificar Producto</h1>
            <form action="Controlador1">
                Clave:<br>
                <input class="form-control" type="text" name="txtClave" value="<%= modeloInventario.getClave()%>"><br>
                Descripcion: <br>
                <input class="form-control" type="text" name="txtDescripcion" value="<%= modeloInventario.getDescripcion()%>"><br>
                Lote: <br>
                <input class="form-control" type="text" name="txtLote" value="<%= modeloInventario.getLote()%>"><br>
                Caducidad: <br>
                <input class="form-control" type="text" name="txtCaducidad" value="<%= modeloInventario.getCaducidad()%>"><br>
                Cantidad: <br>
                <input class="form-control" type="text" name="txtCantidad" value="<%= modeloInventario.getCantidad()%>"><br>
                
                <input type="hidden" name="txtid" value="<%=modeloInventario.getIdInventario()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador?accion=mostrarProducto">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
