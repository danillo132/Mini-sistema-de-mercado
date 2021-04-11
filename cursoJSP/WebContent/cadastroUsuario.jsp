<%@page import="com.sun.xml.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="beans.BeanCursoJsp"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Usuário</title>
<link rel="stylesheet" href="resources/css/cadastro.css">


<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

</head>
<body>




	<div class="menu">
		<table class="menu2">
			<tr>
				<td><a href="acessoliberado.jsp"><img alt="home"
						src="resources/img/homie.png"></a></td>

				<td>MARKET SYSTEM</td>
				<td><a href="index.jsp"><img alt="logout"
						src="resources/img/logout.png"></a></td>
			</tr>

		</table>
	</div>

	<div class="login-page">
		<h3 style="color: white;">${msg}</h3>
		<h3>${cadastrado}</h3>
		<div class="form">

			<h2>Cadastro de usuários</h2>

			<form action="salvarUsuario" method="post" class="login-form"
				id="formUser" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Código:</td>
						<td><input type="text" readonly="readonly" id="id" name="id"
							value="${user.id}" class="field-long"
							placeholder="Gerado automaticamente"></td>

					</tr>
					<tr>
						<td>Nome:</td>
						<td><input type="text" id="nome" name="nome"
							value="${user.nome}" placeholder="Digite seu nome"
							required="required"></td>

						<td>Telefone:</td>
						<td><input type="text" id="telefone" name="telefone"
							value="${user.telefone}" placeholder="(DDD) + número"
							required="required"></td>
					</tr>

					<tr>
						<td>Login:</td>
						<td><input type="text" id="login" name="login"
							value="${user.login}" placeholder="Seu melhor email"
							required="required" maxlength="30"></td>

						<td>Senha:</td>
						<td><input type="password" id="senha" name="senha"
							value="${user.senha}" placeholder="Senha" required="required"
							maxlength="14"> <img src="resources/img/olho.png"
							id="olho" class="olho"></td>
					</tr>


					<tr>
						<td>Cep:</td>
						<td><input type="text" id="cep" name="cep" placeholder="CEP"
							required="required" onblur="ConsultaCep();" value="${user.cep}">
						<td>Rua:</td>
						<td><input type="text" id="rua" name="rua" placeholder="Rua"
							value="${user.rua}">
					</tr>



					<tr>
						<td>Bairro:</td>
						<td><input type="text" id="bairro" name="bairro"
							placeholder="Bairro" value="${user.bairro}">
						<td>Cidade:</td>
						<td><input type="text" id="cidade" name="cidade"
							placeholder="Cidade" value="${user.cidade}">
					</tr>



					<tr>
						<td>Estado:</td>
						<td><input type="text" id="estado" name="estado"
							placeholder="Estado" value="${user.estado}">
						<td>Código IBGE:</td>
						<td><input type="text" id="ibge" name="ibge"
							placeholder="Código do IBGE" value="${user.ibge}"></td>
					</tr>





					<tr>
						<td>Foto:</td>
						<td><input type="file" name="foto"></td>
						<td><label class="check">Ativo <input type="checkbox"
								id="ativo" name="ativo"
							  	<%if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.isAtivo()) {
					out.print(" ");
					out.print("checked=\'checked\'");
					out.print(" ");
				}
			}%> >
			
			
								<span class="checkmark"></span>
						</label></td>
					</tr>

					<tr>
						<td>Currículo:</td>
						<td><input type="file" name="curriculo" value="curriculo"></td>
						<td>Sexo:</td>

						<td><label class="radius"> <input type="radio"
								name="sexo"
								<%
								 	
								
								if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.getSexo().equalsIgnoreCase("masculino")) {
					out.print("");

					out.print("checked=\"checked\"");
					out.print("");
				}

			} %>
								id="sexo" value="masculino">masculino <span
								class="checkmark"></span>
						</label> <label class="radius"> <input type="radio" name="sexo"
								<%if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.getSexo().equalsIgnoreCase("feminino")) {
					out.print("");

					out.print("checked=\"checked\"");
					out.print("");
				}

			}%>
								id="sexo" value="feminino">feminino <span
								class="checkmark"></span>
						</label></td>

					</tr>

					<tr>
						<td>Perfil:</td>
						<td><select id="perfil" name="perfil">
								<option value="nao_informado" selected="selected">[--SELECIONE----]</option>



								<option value="administrador"
									<%
									
									if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("adiministrador")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}  %>
			>Administrador</option>



								<option value="secretario"
									<%if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("secretario")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Secrétario(a)</option>



								<option value="gerente"
									<%if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("gerente")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Gerente</option>



								<option value="funcionario"
									<%if (request.getAttribute("user") != null) {

				BeanCursoJsp usuario = (BeanCursoJsp) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("funcionario")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Funcionário(a)</option>
						</select></td>



					</tr>




				</table>

				<button type="submit" value="Salvar">Salvar</button>
				<br> <br>
				<button type="submit" value="Cancelar"
					onclick="document.getElementById('formUser').action = 'salvarUsuario?acao=reset'">Cancelar</button>
			</form>
		</div>
	</div>
	
	
	
	<div class="consult-page">
		<h3 style="color: white;">${pesquisa}</h3>
		
		<div class="consult">

			<h3>Pesquisar usuário</h3>

			<form action="servletPesquisa" method="post" class="consult-form"
				id="formConsult" >
				<table>
					<tr>
						<td>Descrição: </td>
						<td> <input  class="descricao" type="text" id="descricaoconsulta" name="descricaoconsulta" placeholder="Nome do usuário"></td>
						<td> <button type="submit" value="pesquisar"> Pesquisar</button> </td>
					</tr>
					


				</table>

				
			
				
			</form>
		</div>
	</div>



	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table class="tabela">
						<tr>
							<th>ID</th>
							<th>Email</th>
							<th>Nome</th>
							<th>Foto</th>
							<th>Currículo</th>

							<th>Cep</th>




							<th>Delete</th>
							<th>Editar</th>
							<th>fones</th>
						</tr>
						<c:forEach items="${usuarios}" var="user">
							<tr>

								<td style="width: 150px"><c:out value="${user.id}"></c:out></td>
								<td style="width: 150px"><c:out value="${user.login}"></c:out>
								</td>
								<td style="width: 150px"><c:out value="${user.nome}"></c:out></td>


								<c:if test="${user.fotoBase64Miniatura.isEmpty() == false}">
									<td style="width: 150px"><a
										href="salvarUsuario?acao=download&tipo=imagem&user=${user.id}"><img
											src="<c:out value="${user.fotoBase64Miniatura}"></c:out>"
											alt="ImagemUser" title="ImagemUser"></a></td>
								</c:if>
								<c:if test="${user.fotoBase64Miniatura == null}">
									<td style="width: 150px"><img
										src="resources/img/usuario.png" alt="ImagemUser"
										title="ImagemUser"></td>
								</c:if>
								<c:if test="${user.curriculoBase64.isEmpty() == false}">
									<td style="width: 150px"><a
										href="salvarUsuario?acao=download&tipo=curriculo&user=${user.id}"><img
											alt="curriculo" src="resources/img/pdf.png" title="Currículo">
									</a></td>
								</c:if>

								<c:if test="${user.curriculoBase64 == null}">
									<td style="width: 150px"><img alt="curriculo"
										src="resources/img/vazio.png" title="Currículo"></td>
								</c:if>

								<td style="width: 150px"><c:out value="${user.cep}"></c:out></td>




								<td><a href="salvarUsuario?acao=delete&user=${user.id}"
									onclick="return confirm('Confirmar a exclusão?')"> <img
										alt="" src="resources/img/favicon.ico" title="Excluir">
								</a></td>
								<td><a href="salvarUsuario?acao=editar&user=${user.id}">
										<img alt="" src="resources/img/editar.ico" title="Editar">
								</a></td>

								<td><a href="salvarTelefones?acao=addFone&user=${user.id}">
										<img alt="telefones" src="resources/img/fone.png"
										title="Telefones">
								</a></td>

							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		document.getElementById('olho').addEventListener('mousedown',
				function() {
					document.getElementById('senha').type = 'text';
				});

		document.getElementById('olho').addEventListener('mouseup', function() {
			document.getElementById('senha').type = 'password';
		});

		document.getElementById('olho').addEventListener('mousemove',
				function() {
					document.getElementById('senha').type = 'password';
				});

		function ConsultaCep() {
			var cep = $("#cep").val();

			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {

							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);

						} else {
							$("#rua").val('');
							$("#bairro").val('');
							$("#cidade").val('');
							$("#estado").val('');
							$("#ibge").val('');

							alert("CEP não encontrado.");
						}
					});

		}
	</script>

</body>
</html>