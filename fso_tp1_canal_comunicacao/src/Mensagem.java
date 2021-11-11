
public class Mensagem implements iMensagem{
	private int id, tipo, angulo, raio, distancia = 0;
	private long idCliente = 0;
	private String texto = "";
	
	public Mensagem(int tipo) {
		this.tipo = tipo;
	}
	
	public Mensagem(int tipo, long idCliente) {
		this.tipo = tipo;
		this.idCliente = idCliente;
	}

	public Mensagem(int tipo, int raio,int angulo, long idCliente) {
		this.tipo = tipo;
		this.raio = raio;
		this.angulo = angulo;
		this.idCliente = idCliente;
	}
	
	public Mensagem(int tipo, int distancia, long idCliente) {
		this.tipo = tipo;
		this.distancia = distancia;
		this.idCliente = idCliente;
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

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
