
public class Mensagem implements iMensagem{
	private int id;
	private int tipo;
	private String texto;
	
	public Mensagem(int tipo, String texto) {
		this.setTipo(tipo);
		this.setTexto(texto);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
