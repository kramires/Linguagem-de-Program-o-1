
public class Estacionamento implements IEstacionamento {
	private int lotacao;
	private String dataAtual;
	
	public Estacionamento() {
	}

	public Estacionamento(int lotacao, String dataAtual) {
		this.lotacao = lotacao;
		this.dataAtual = dataAtual;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public String getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}
	
}
