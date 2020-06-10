//Inicializa objetos
$(document).ready(function(){
	carregaEstadosAjax();
	cadastrar();
});

// [ PUBLIC FUNCTIONS ]

function carregaEstadosAjax(){
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/contatos/estados',
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(estados){
				console.log(estados);
				buildSelect(estados);
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro ao carregar os estados. Tente mais tarde.');
				console.error('Ocorreu um erro.' + ex);
			}
		}
	});
}

function cadastrarContatoAjax(contato){
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/contatos/criar',
		data: contato,
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(contato){
//				buildTable(contatos); essa função tem que estar dentro de contato.js
//				Aqui, só fazemos o post
				messagePanelSuccess('Usuário cadastrado com sucesso.');
				window.location = 'http://localhost:8080/contatos/cadastros';
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex);
			}
		}
	});
}

function cadastrar(){
	$('#cadastraContatoID').click(function(){
		if(validarCadastro()){
			var nome     = $('#nomeCadID').val();
			var telefone = $('#telCadID').val();
			var email    = $('#emailCadID').val();
			var cidade   = $('#cidadeCadID').val();
			var estado   = $('#inputState option:selected').text();
			var contato  = '{"nome":"'+nome+'","telefone":"'+telefone+'","email":"'+email+'","cidade":"'+cidade+'","estado":"'+estado+'"}';
			cadastrarContatoAjax(contato);
			//limpar os campos
		}
	});
}

function validarCadastro(id){
	var nome     = $('#nomeCadID').val();
	var telefone = $('#telCadID').val();
	var email    = $('#emailCadID').val();
	var cidade   = $('#cidadeCadID').val();
	
	if(nome == '' | telefone == '' | email == '' | cidade == ''){
		showMessageWarning('#msgCadContato', 'Informe todos os campos.');
		return false;
	} else {
		return true;
	}
}

// [ PRIVATE FUNCTIONS ]

function buildSelect(estados){
	estados.forEach(function(es){
		var opt = $('<option>');
		opt.val(es.ordinal);
		opt.text(es.sigla);
		$('#inputState').append(opt);
	});
}

