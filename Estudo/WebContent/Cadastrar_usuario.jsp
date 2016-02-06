
<%@include file="Topo.html"%>
<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Cadastrar Usuário</h1>
		<h1 class="page-subhead-line">Tela para realizar cadastro de um
			usuário</h1>
	</div>
</div>
<!-- /. ROW  -->
<div class="row">
	<div class="col-md-6 col-sm-6 col-xs-12">
		<div class="panel panel-info">
			<div class="panel-heading">Preencha os campos</div>
			<div class="panel-body">
				<form role="form" action="Resultado.jsp?">
					<div class="form-group">
						<label>Nome Completo</label> <input class="form-control"
							type="text" name="nomeCompleto">
					</div>
					<div class="form-group">
						<label>Data de Nascimento</label> <input class="form-control"
							type="date" name="dataNascimento">
					</div>
					<div class="form-group">
						<label>E-mail</label> <input class="form-control" type="text"
							name="email">
					</div>
					<label>Sexo</label>
					<div class="radio">
						<label> <input type="radio" name="sexo" value="Homem"
							checked>Masculino
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="sexo" value="Mulher">Femino
						</label>
					</div>
					<div class="form-group">
						<label>CPF</label> <input class="form-control" type="text"
							maxlength="11" name="cpf">
					</div>
					<div class="form-group">
						<label>Usuário</label> <input class="form-control" type="text"
							name="usuario">
					</div>
					<div class="form-group">
						<label>Senha</label> <input class="form-control" type="password"
							name="senha">
					</div>

					<button type="submit" class="btn btn-info">Salvar</button>

				</form>
			</div>
		</div>
	</div>
</div>

<!--/.ROW-->

<%@include file="Fundo.html"%>

