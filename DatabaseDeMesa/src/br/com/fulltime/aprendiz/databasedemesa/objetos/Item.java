package br.com.fulltime.aprendiz.databasedemesa.objetos;

import java.util.List;

public class Item {
	private long id;
	private String nome;
	
	public Item(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
