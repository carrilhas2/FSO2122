
public class Mensagem {
	private int id;
	private int tipo;
	private String texto;
	
	public Mensagem(int id, int tipo, String texto) {
		this.id = id;
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
}
