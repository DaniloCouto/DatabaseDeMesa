package br.com.fulltime.aprendiz.databasedemesa.objetos;

public class AtributoSecundario {
	private String nome;
	private double valor;
	
	public AtributoSecundario(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	};
	
	
}
