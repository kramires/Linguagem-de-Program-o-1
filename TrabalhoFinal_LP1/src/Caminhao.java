
public class Caminhao extends Veiculo {
	
	private double capacidadeCarga;
	
	
	public Caminhao() {
	}

	public Caminhao(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}
	
}
