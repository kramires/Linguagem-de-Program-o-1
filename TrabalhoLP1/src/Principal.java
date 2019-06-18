import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe quantas pessoas deseja adicionar na agenda");
		Agenda a = new Agenda(sc.nextInt());
		
		System.out.println("A sua agenda possui Amigos: " + a.getQtdAmigos());
		System.out.println("A sua agenda possui Conhecidos: " + a.getQtdConhecidos());
		a.addInformacoes();
		a.imprimeAniversario();
		a.imprimeEmail();
	
		sc.close();	
	}
}
