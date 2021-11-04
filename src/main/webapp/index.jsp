
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <!--JQUERY-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
        <!-- FRAMEWORK BOOTSTRAP-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
        <!--iconos-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

        <!-- css-->
        <link rel="stylesheet" type="text/css" href="css/index.css" th:href="@{/css/index.css}">
        
    </head>
    <body>
            <div class="modal-dialog text-center">
                <div class="col-sm-8 main-section">
                    <div class="modal-content">
                        <div class="col-12 user-img">
                            <img src="img/user.png" th:src="@{/img/user.png}"/>
                        </div>
                        <form class="col-12" action="Controlador" method="post">
                            <div class="form-group" id="user-group">
                                <input type="text" class="form-control" placeholder="Nombre de usuario" name="txtNombre"/>
                            </div>
                            <div class="form-group" id="contrasena-group">
                                <input type="password" class="form-control" placeholder="Contraseña" name="txtContrasena"/>
                            </div>
                            <!--<button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>-->
                            <input class="btn btn-primary" type="submit" name="accion" value="Ingresar"><i class="fas fa-sign-in-alt"></i>
                        </form>
                        <div class="col-12 forgot">
                            <a href="Controlador?accion=gregarUsuario">Recordar contrasena?</a>                           
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
