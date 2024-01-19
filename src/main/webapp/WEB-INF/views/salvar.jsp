<!DOCTYPE html>
<%@page import="com.example.dto.RetornoDTO"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.example.entity.Paciente"%>
<%@page import="com.example.service.PacienteService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Poppins:wght@200;500&display=swap"
        rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Salvar</title>

    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <%
    PacienteService service = (PacienteService) request.getAttribute("serviceVar");
    
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String data = request.getParameter("data");
    
    Paciente paciente = new Paciente();
    
    paciente.setNome(nome);
    paciente.setEmail(email);
    paciente.setDataNasc(LocalDate.parse(data));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate dataRight = LocalDate.parse(data);

    RetornoDTO retorno = service.save(paciente);
    %>

    <div class="box">
        <h2><%= retorno.getMensagem() %></h2>
<%--         <c:if test="retorno.isSucesso()">Sucesso!</c:if> --%>
        <% if (retorno.isSucesso()) { %>
	        <h3>Os dados salvos foram:</h3>
	        <p><b>Nome:</b> <%= nome %></p>
	        <p><b>E-mail:</b> <%= email %></p>
	        <p><b>Data de nascimento:</b> <%= dataRight.format(formatter) %></p>
        <% } %>
        <div class="box-item">
                <a class="link voltar" href="/">Voltar</a>
        </div>
    </div>
</body>
</html>