
public class Conta {
	
	private Veiculo veiculo;
	private Cliente cliente;
	private String data;
	private String horaChegada;
	private String horaSaida;
	private double valor;
	private boolean paga;
	
	
	public Conta() {
	}

	public Conta(Veiculo veiculo, Cliente cliente, String data, String horaChegada, String horaSaida, double valor,
			boolean paga) {
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.data = data;
		this.horaChegada = horaChegada;
		this.horaSaida = horaSaida;
		this.valor = valor;
		this.paga = paga;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}	
	
}
