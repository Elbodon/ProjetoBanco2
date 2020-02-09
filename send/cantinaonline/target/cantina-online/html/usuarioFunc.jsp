<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../materialize/css/materialize.min.css">
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
<div class="row">
    <div class="col s12 green darken-5">
        <img width="109px" src="../imagens/logo.png"/>
        <p class="right">
            <a href="../invalidando"><button class="btn center-align">Logout</button></a>
            | <a href="#modal3" class="modal-trigger"><button class="btn waves-effect waves-light">Cadastrar Produto</button></a>
        </p>

        <form action="../mostrarFunc" method="post" class="col s6">
            <p class="right-aligned">
            <button class="btn" id="btMostrar"> Mostrar </button>
            </p>
        </form>

    </div>
</div>

<center>
    <p><h5> Olá, <c:out value="${usuarioLogado.nome}"/> </h5> </p>
    <br/>
</center>

<%-- CADASTRO DOS PRODUTOS AQUI --%>
<div id="modal3" class="modal">
    <div id="divFormulario2" class="row container"> <!-- Div dos Dados -->
        <div  id="divTelaCadastro2">
            <center><label class="center"><img src="../imagens/logo.png" with="320" height="205"></label></center>
        </div>
        <center> <h5> Informe seus Dados </h5></center>
        <div class="row">
            <form action="../cadastroProduto" method="post" class="col s12">
                <div class="row">


                    <div class="input-field col s6" id="idProduto">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="id" type="text" name="id" class="validate" required>
                        <label for="id"> ID </label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">room_service</i>
                        <input id="nomeProduto" type="text" name="nome" class="validate" required>
                        <label for="nomeProduto"> Nome </label>
                    </div>


                    <div class="input-field col s6">
                        <i class="material-icons prefix">attach_money</i>
                        <input id="preco" type="text" name="preco" class="validate" required>
                        <label for="preco"> Preço </label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">add_circle</i>
                        <input id="quantidade" type="number" name="quantidade" class="validate" required>
                        <label for="quantidade"> Quantidade </label>
                    </div>


                    <center>
                        <div class="input-field col s12">
                            <button class="btn right" type="submit" name="action">Enviar</button>
                        </div>
                    </center>
                </div>

            </form>

        </div>
    </div>
</div>

<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../materialize/js/materialize.min.js"></script>
<script src="../js/configuracoes.js"></script>

</body>
</html>