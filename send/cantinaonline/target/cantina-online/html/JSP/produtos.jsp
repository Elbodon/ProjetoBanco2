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

<%--DIV CARRINHO--%>
<div class="left col s3 green darken-4">
    <%--<a href="<c:url value=""/>">Meu carrinho:</a>--%>
    <p style="color: white"> Total de Itens: <c:out value="${toCarrinho}"/> </p>
    <p style="color: white"> Preco do Carrinho: <c:out value="${toCarrinho}"/> </p>
</div>

<div class="right col s3">
    <form action="#">
        <button class="btn waves-effect waves-light"> Finalizar </button>
    </form>
</div>

<%--<div id="carrinho">--%>
    <%--<h3>Meu carrinho:</h3>--%>
    <%--<c:if test="${empty carrinho or carrinho.totalDeItens eq 0 }">--%>
        <%--<span>Você não possui itens no seu carrinho</span>--%>
    <%--</c:if>--%>
    <%--<c:if test="${carrinho.totalDeItens > 0 }">--%>
        <%--<ul>--%>
            <%--<li>--%>
                <%--<strong>Itens:</strong> ${carrinho.totalDeItens }--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<strong>Total:</strong>--%>
                <%--<fmt:formatNumber type="currency"--%>
                                  <%--value="${carrinho.total }"/>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</c:if>--%>
<%--</div>--%>

<br/><br/><br/><br/>


<table>
    <thead>
    <h3> Produtos </h3>
    <th>ID</th>
    <th>Nome</th>
    <th>Preco</th>

    </thead>
    <form action="<c:url value="/adicionar"/>" method="POST">
        <c:forEach items="${itens}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.preco}</td>
                <td></td>
                <td> <button type="submit">Comprar</button> </td>
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
