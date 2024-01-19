<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html lang="pt-BR">

	<head>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link
			href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Poppins:wght@200;500&display=swap"
			rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
			integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
			crossorigin="anonymous" referrerpolicy="no-referrer" />

		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Relatório</title>

		<link rel="stylesheet" href="../css/styles.css">
	</head>

	<body>
		<div class="box-table">
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
							<td class="edit"><a href="/editar/${paciente.id}"><i
										class="fa-solid fa-pen-to-square"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="box-item rel">
				<a class="link voltar" href="/">Voltar</a>
			</div>
		</div>
	</body>

	</html>