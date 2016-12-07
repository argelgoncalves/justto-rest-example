<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Docs < Matematica < Soma</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
fieldset {
	width:20%;
	float: left;
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<h2>Matematica: Soma</h2>
	<h4>Descricao</h4>
	<p>Envia via application/json os elementos A e B, realiza a soma e  retorna RESULTADO<p>
	<h4>Dados da requisicao: </h4>
	<p>
		<b>URL:</b> http://54.244.59.246:8080/justto/soma<br />
		<b>Metod:</b> Post<br />
		<b>Envio:</b> <span id="input">{A: 30.50, B: 5.12}</span><br />
		<b>Retorno:</b> <span id="output">{RESULTADO: 35.62}</span><br />
	</p>
	
	<h4>Exemplo</h4>
	
	<form>
		<fieldset>
			<label for="A">A: </label>
			<input type = "text" id = "A" value = "30.50"/>
			<br />
			
			<label for="B">B: </label>
			<input type = "text" id = "B" value = "5.12"/>
			
			<label for="RESULTADO">RESULTADO: </label>
			<input type = "text" id = "RESULTADO" value = "" readonly="true"/>
			
			<br />
			<button id = "executar">Executar</button>
			<br />
		</fieldset>
		
	</form>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#executar').click(function(event){
			event.preventDefault();
			
			var inputData = '{A: ' +$("#A").val()+ ', B: ' +$("#B").val()+'}';
			$("#input").text(inputData);
			
			$.ajax({
	              type: 'Post',
	              contentType: "application/json; charset=utf-8",
	              url: 'http://54.244.59.246:8080/justto/soma',
	              data: inputData,
	              dataType: 'json',
	              success: function(json) {
	            	$("#RESULTADO").val(json.RESULTADO);
	            	$("#output").text("{RESULTADO:"+json.RESULTADO+"}");
	              }
	            });
		});
	});
	</script>
</body>
</html>