package br.com.fulltime.aprendiz.databasedemesa.adaptador;

public class ItemMenuLateral {
	private int ico;
	private String texto;
	private String descricao;
	
	public ItemMenuLateral(int ico, String texto, String descricao) {
		super();
		this.ico = ico;
		this.texto = texto;
		this.descricao = descricao;
	}

	public int getIco() {
		return ico;
	}

	public void setIco(int ico) {
		this.ico = ico;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
