<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">

<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Poppins:wght@200;500&display=swap"
	rel="stylesheet">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Relatório</title>

<link rel="stylesheet" href="../css/styles_relatorio.css">
</head>

<body>
	<table border="1">
		<caption>Relatório de pacientes</caption>
		<thead>
			<th>Nome do paciente</th>
			<th>Idade</th>
			<th>E-mail</th>
			<th>Data de cadastro</th>
			<th>Última atualização</th>
			<th>Editar</th>
		</thead>
		<tbody>
			<c:forEach var="paciente" items="${pacientes}">
				<tr>
					<td>${paciente.nome}</td>
					<td>${paciente.idade}</td>
					<td>${paciente.email}</td>
					<td>${paciente.dataCadastro}</td>
					<td>${paciente.ultimaAtt}</td>
					<td><a href = "/editar/${paciente.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="box-item">
                <a class="link" href="/">Voltar</a>
    </div>
</body>

</html>