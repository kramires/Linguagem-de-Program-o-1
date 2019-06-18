
public class Funcionario extends Pessoa implements Autenticavel{
	
	private String login;
	private String senha;
	private String nivel;
	
	public Funcionario() {
	}

	public Funcionario(String login, String senha, String nivel) {
		this.login = login;
		this.senha = senha;
		this.nivel = nivel;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public boolean autentica(String senha) {
		return true;
	}

}
