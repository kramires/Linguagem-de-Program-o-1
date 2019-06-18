
public class  Amigo extends Pessoa{
	
	private String dataAniversario;

	public Amigo() {
		this.dataAniversario = "indefinido";
	}

	public Amigo(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
}
