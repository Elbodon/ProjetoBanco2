<%@ page import="br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.ifpb.cantinaonline.model.Produto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Familia Nogueira
  Date: 02/07/2019
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produtos</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../../materialize/css/materialize.min.css">
    <link rel="stylesheet" href="../../css/estilos.css">
</head>
<body id="bodyProdutos">

<div class="row">
    <div class="col s12 green darken-5">
        <img width="109px" src="../../imagens/logo.png"/>
        <p class="right">
            <a href="home.jsp"><button class="btn waves-effect waves-light">Voltar</button></a>
        </p>
    </div>
</div>

<br/><br/><br/><br/>


<table>
    <thead>
    <h3> Produtos </h3>
    <th>ID</th>
    <th>Nome</th>
    <th>Preco</th>
    <th>Quantidade</th>
    <th>

    </th>

    </thead>
    <form action="#" method="POST">
        <c:forEach items="${itens}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.preco}</td>
                <td>${item.quantidade}</td>
                    <%--<td> <input type="hidden" name="add" value="adiciona"/> </td>--%>
            </tr>
        </c:forEach>
    </form>
    <tbody>
    </tbody>
</table>




<script>

    function redireciona(param){
        location.href=param;
    }


</script>
</body>
</html>
