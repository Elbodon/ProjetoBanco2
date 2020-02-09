<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../../materialize/css/materialize.min.css">
    <link rel="stylesheet" href="../../css/estilos.css">
</head>
<body>

<div class="row">
    <div class="col s12 green darken-5">
        <img width="40px" src="../../imagens/logo.png"/>
        <p class="right">
            <a href="#modal2" class="modal-trigger"><button class="btn waves-effect waves-light">Entrar</button></a>
            | <a href="#modal1" class="modal-trigger"><button class="btn waves-effect waves-light" id="Cadastrar">Cadastrar</button></a>
        </p>



    </div>
</div>

<div>
    <center>
        <img width="600px" src="../../imagens/logo.png">
    </center>
    <form action="../mostrarCli" method="post" class="col s6">
    <div class="carousel" >
        <a class="carousel-item" href="produtos.jsp"><img src="../../imagens/coca.jpg"></a>
        <a class="carousel-item" href="produtos.jsp"><img src="../../imagens/pizza.png"></a>
        <a class="carousel-item" href="produtos.jsp"><img src="../../imagens/cachorro-quente.jpg"></a>
        <a class="carousel-item" href="produtos.jsp"><img src="../../imagens/hamburguer.jpg"></a>
        <a class="carousel-item" href="produtos.jsp"><img src="../../imagens/suco.jpg"></a>
    </div>

    </form>

</div>

<%-- CADASTRO DE USUARIOS --%>
<div id="modal1" class="modal">
     c <!-- Div dos Dados -->
        <div  id="divTelaCadastro">
            <center><label class="center"><img src="../../imagens/logo.png" with="320" height="205" ></label></center>
        </div>
        <center> <h5> Informe seus Dados </h5></center>
        <div class="row">
            <%-- ENVIANDO OS DADOS PARA CADASTRO --%>
            <form action="../cadastroservlet" method="post" class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">account_circle</i>
                        <input id="nomeCompleto" type="text" name="nomeC" class="validate" required>
                        <label for="nomeCompleto">Nome Completo</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">person</i>
                        <input id="nomeUsuario" type="text" name="nomeU" class="validate" required>
                        <label for="nomeUsuario">Nome de Usuario</label>
                    </div>


                    <div class="input-field col s6">
                        <i class="material-icons prefix">textsms</i>
                        <input id="email" type="email" name="email" required>
                        <label for="email">Email</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">today</i>
                        <input id="nascimento" type="date" name="data">
                        <label for="nascimento">Data de Nascimento</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">location_city</i>
                        <input id="endereco" type="text" name="cidade" class="validate" required>
                        <label for="endereco">Cidade</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">location_on</i>
                        <input id="rua" type="text" name="rua" class="validate" required>
                        <label for="rua">Rua</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">location_on</i>
                        <input id="bairro" type="text" name="bairro" class="validate" required>
                        <label for="bairro">Bairro</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">phone</i>
                        <input id="icon_telephone" type="tel" name="telefone" class="validate" required>
                        <label for="icon_telephone">Telefone</label>
                    </div>



                    <div class="input-field col s6">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="senha" type="password" name="senha" class="validate" required>
                        <label for="senha">Senha</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="Csenha" type="password" class="validate" required>
                        <label for="Csenha">Confirmar Senha</label>
                    </div>

                    <%-- VERIFICANDO O TIPO DE USUÁRIO--%>
                    <div class="input-field col s6">
                        <select name="funcao">
                            <%--<option value="" disabled selected>Função</option>--%>
                            <option id="optUsu "name="cliente">Cliente</option>
                            <option id="optFunc" name="funcionario">Funcionário</option>
                        </select>
                        <label> Tipo de Usuário </label>
                    </div>

                    <center>
                        <div class="input-field col s12" required>
                            <button class="btn right">Enviar</button>
                        </div>
                    </center>
                </div>

            </form>

        </div>
    </div>
</div>

<%-- FAZENDO O LOGIN --%>
<div id="modal2" class="modal">
    <div class="modal-content">
        <center>
            <div id="divFormularioLogin" class="row container"> <!-- Div dos Dados -->


                    <label class="center"><img id="labelImg" width="500px" src="../../imagens/logo.png"> </label>


                <center><h5> Faça seu Login </h5></center>

                <%-- LOGIN --%>
                <div class="row" id="divDadosLogin">
                    <center>
                        <form class="col s12" action="../acessopagina" method="post" class="col s12">
                            <div class="row">
                                <div class="input-field col s12" id="divEmail">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="emailLog" name="usuario"type="text" class="validate" required>
                                    <label for="emailLog">Nome de Usuario </label>
                                </div>
                            </div>
                            <div class="row container">
                                <div class="input-field col s12 center" id="divSenha">
                                    <i class="material-icons prefix">vpn_key</i>
                                    <input id="senhaLog" name="senha" type="password" class="validate" required>
                                    <label for="senhaLog">Senha</label>
                                </div>
                            </div>

                            <center>
                            <div class="row">
                            <div id="divSelect" class="input-field col s6">
                                <select name="funcao">
                                    <%--<option value="" disabled selected>Função</option>--%>
                                    <option id="optUsu "name="cliente">Cliente</option>
                                    <option id="optFunc" name="funcionario">Funcionario</option>
                                </select>
                                <label> Tipo de Usuário </label>
                            </div>
                            </div>
                            </center>

                            <div class="row container">
                                <div class="col s12 right">
                                    <button class="btn" id="btEnviar">Login</button>
                                </div>
                            </div>

                        </form>
                    </center>
                </div>
            </div>
        </center>
    </div>
</div>

<%--<div class="row">--%>
    <%--<form action="../carrinho" method="post" class="col s6">--%>
        <%--<p> <h6> Listar </h6> </p>--%>
        <%--<button class="btn" id="btMostrar"> Mostrar </button>--%>
    <%--</form>--%>
<%--</div>--%>


<script src="../../js/jquery-3.4.1.min.js"></script>
<script src="../../materialize/js/materialize.min.js"></script>
<script src="../../js/configuracoes.js"></script>
<script>

    $(document).ready(function(){
        $('select').formSelect();
    });
    $(document).ready(function(){
        $('.carousel').carousel();
    });

</script>
</body>
</html>