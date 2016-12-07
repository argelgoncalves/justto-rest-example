package br.com.justto.api.model;

import java.io.Serializable;

public class Soma implements Serializable{
	private Double A;
	private Double B;
	private Double RESULTADO;
	
	public Double getA() {
		return A;
	}
	public void setA(Double a) {
		A = a;
	}
	public Double getB() {
		return B;
	}
	public void setB(Double b) {
		B = b;
	}
	public Double getRESULTADO() {
		return RESULTADO;
	}
	public void calcular() {
		RESULTADO = A + B;
	}
	
	public boolean isValido(){
		return !(A == null || B == null);
	}
	
}
