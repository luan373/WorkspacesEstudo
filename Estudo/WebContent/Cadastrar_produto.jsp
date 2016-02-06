<%@include file="Topo.html"%>
<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Cadastrar Produto</h1>
		<h1 class="page-subhead-line">Tela para realizar cadastro de um
			produto</h1>
	</div>
</div>
<!-- /. ROW  -->
<div class="row">
	<div class="col-md-6 col-sm-6 col-xs-12">
		<div class="panel panel-info">
			<div class="panel-heading">Preencha os campos</div>
			<div class="panel-body">
				<form role="form" action="ResultadoProduto.jsp?">
					<div class="form-group">
						<label>Nome do Produto </label> <input class="form-control"
							type="text" name="nomeProduto">
					</div>
					<div class="form-group">
						<label>Descrição</label> <input class="form-control" type="text"
							name="descricao">
					</div>
					<div class="form-group">
						<label>Valor</label> <input class="form-control" type="text"
							maxlength="11" name="valor">
					</div>
					<div class="form-group">
						<label>Quantidade de Estoque</label> <input class="form-control"
							type="number" name="qntEstoque">
					</div>
					<button type="submit" class="btn btn-info">Salvar</button>

				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="Fundo.html"%>