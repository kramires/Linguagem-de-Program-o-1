import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa{
	
	private String telefone;
	

	public Cliente() {
	}

	public Cliente(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
