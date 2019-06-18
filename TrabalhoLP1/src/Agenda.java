import java.util.Scanner;

public class Agenda {
	
	private int qtdAmigos;
	private int qtdConhecidos;
	private Pessoa[] pessoa;
	
	public Agenda() {
	}

	public Agenda(int qtdAmigos, int qtdConhecidos, Pessoa[] pessoa) {
		this.qtdAmigos = qtdAmigos;
		this.qtdConhecidos = qtdConhecidos;
		this.pessoa = pessoa;
	}

	public int getQtdAmigos() {
		return qtdAmigos;
	}

	public void setQtdAmigos(int qtdAmigos) {
		this.qtdAmigos = qtdAmigos;
	}

	public int getQtdConhecidos() {
		return qtdConhecidos;
	}

	public void setQtdConhecidos(int qtdConhecidos) {
		this.qtdConhecidos = qtdConhecidos;
	}

	public Pessoa[] getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa[] pessoa) {
		this.pessoa = pessoa;
	}
	
	public Agenda (int qtdPessoa) {
		this.pessoa = new Pessoa[qtdPessoa];
		
		for(int i = 0; i < qtdPessoa; i++) {
			int n = 1 + (int)(Math.random()*2);
			
			if (n == 1) { 
				this.pessoa[i] = new Amigo();
				this.qtdAmigos++;
			}
			else if (n == 2) {
				this.pessoa[i] = new Conhecido();
				this.qtdConhecidos++;
			}
			
		}
	}
		
		public void addInformacoes() {
			Scanner sc = new Scanner(System.in);
			
			for(int i=0; i < pessoa.length; i++ ) {
				
				if (pessoa[i] instanceof Amigo) {
					System.out.println("Digite o nome do Amigo: ");
					pessoa[i].setNome(sc.next());
					
					System.out.println("Digite a idade: ");
					pessoa[i].setIdade(sc.nextInt());
					
					System.out.println("Digite a data de Aniversário: ");
					((Amigo)pessoa[i]).setDataAniversario(sc.next());
					
				}
				else if (pessoa[i] instanceof Conhecido) {
					System.out.println("Digite o nome do Conhecido: ");
					pessoa[i].setNome(sc.next());
					
					System.out.println("Digite a idade: ");
					pessoa[i].setIdade(sc.nextInt());
					
					System.out.println("Digite o email: ");
					((Conhecido)pessoa[i]).setEmail(sc.next());
				}
			}
		
			sc.close();
		}
		
		public void imprimeAniversario() {
			for(int i=0; i < pessoa.length; i++ ) {
				if (pessoa[i] instanceof Amigo) {
					
					System.out.println(((Amigo)pessoa[i]).getNome() +": "+ ((Amigo)pessoa[i]).getDataAniversario());
					System.out.println("***************");
				}
			}
		}
		
		public void imprimeEmail() {
			for(int i=0; i < pessoa.length; i++ ) {
				if (pessoa[i] instanceof Conhecido) {
					
					System.out.println(((Conhecido)pessoa[i]).getNome()+ ": " + ((Conhecido)pessoa[i]).getEmail());
					System.out.println("***************");
				}
			}
		}
	}
