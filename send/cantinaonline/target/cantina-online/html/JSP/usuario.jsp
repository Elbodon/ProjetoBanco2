<%@ page import="br.com.ifpb.cantinaonline.model.Usuario" %>
<%@ page import="br.com.ifpb.cantinaonline.model.Acesso" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="br.com.ifpb.cantinaonline.model.AcessoProduto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
<head>
    <title>Usuário</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../../materialize/css/materialize.min.css">
    <link rel="stylesheet" href="../../css/estilos.css">
</head>
<body>

<div class="row">
    <div class="col s12 green darken-5">
        <img width="109px" src="../../imagens/logo.png"/>
        <p class="right">
            <a href="../invalidando"><button class="btn center-align">Logout</button></a> |
            <form action="../mostrarFunc" method="post" class="col s6">
                <p class="right-aligned">
                    <button class="btn" id="btMostrar"> Mostrar </button>
                </p>
            </form>

        </p>
    </div>
</div>

    <center>
        <p><h5> Olá, <c:out value="${usuarioLogado.nome}"/> </h5> </p>
        <br/>
    </center>

</body>
</html>
