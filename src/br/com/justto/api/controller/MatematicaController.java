package br.com.justto.api.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.justto.api.model.Soma;

import static br.com.caelum.vraptor.view.Results.*;

import javax.servlet.http.HttpServletResponse;

@Resource
public class MatematicaController {

	private Result result;
	
	public MatematicaController(Result result) {
		this.result = result;
	}
	
	
	@Consumes("application/json")
	@Post @Path("/soma")
	public void soma(Soma soma){
		if(soma.isValido()){
			soma.calcular();
			result.use(http()).setStatusCode(HttpServletResponse.SC_OK);
			result.use(json()).withoutRoot().from(soma).exclude("A").exclude("B").serialize();
		}else
			result.use(http()).setStatusCode(HttpServletResponse.SC_EXPECTATION_FAILED);
	}
}
