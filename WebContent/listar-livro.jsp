<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="index-head.html" />
<body>
	<c:import url="index-top.html" />

	<jsp:useBean id="dao" class="br.com.flf.jdbc.LivroDAO" />
	<div class="row">
		<div class="twelve columns">
			<div class="row">
				<div class="ten columns">
					<table width="100%">
					<thead>
							<tr>
								<th>Título</th>
								<th>Gênero</th>
								<th>Autores</th>
								<th>Ano</th>
								<th>Editora</th>
								<th>Opções</th>
							</tr>
						</thead>
						<tbody>
					<c:forEach var="filme" items="${dao.getLivros()}">
						<tr>
							<td>${filme.titulo}</td>
							<td>${filme.genero}</td>
							<td>${filme.autores}</td>
							<td>${filme.ano}</td>
							<td>${filme.editora}</td>
							<td><a href="altera-livro.jsp?id=${filme.id}" target="blank">Alterar</a> - <a href="removeLivro?id=${filme.id}" target="blank">Excluir</a></td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<!-- 
Com datas<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="filme" items="${dao.getLivros()}">

</c:forEach>
 -->
</body>
</html>