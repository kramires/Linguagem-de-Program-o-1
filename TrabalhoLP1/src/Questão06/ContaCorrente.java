package Questão06;

import java.util.Scanner;

public class ContaCorrente extends ContaBancaria{

	private int qtdTransacoesRealizadas = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public int getQtdTransacoesRealizadas() {
		return qtdTransacoesRealizadas;
	}

	public void setQtdTransacoesRealizadas(int qtdTransacoesRealizadas) {
		this.qtdTransacoesRealizadas = qtdTransacoesRealizadas;
	}

	@Override
	public void saca(double valor) {
		System.out.println("Digite a senha da conta");
			int senha = sc.nextInt();
			if(senha == this.senha) {
				this.setSaldo(this.getSaldo() - valor);
				this.qtdTransacoesRealizadas++;
				System.out.println("**********************************");
				System.out.println("*  SAQUE REALIZADO COM SUCESSO  *");
				System.out.println("**********************************");
			}
	}

	@Override
	public void deposita(double valor) {
		
		this.setSaldo(this.getSaldo() + valor);
		this.qtdTransacoesRealizadas++;
		System.out.println("**********************************");
		System.out.println("* DEPÓSTIO REALIZADO COM SUCESSO *");
		System.out.println("**********************************");
	}

	@Override
	public void tiraExtrato() {
		System.out.println("Digite a senha da conta");
			int senha = sc.nextInt();
			
			if(senha == this.senha) {
				System.out.println("*******************************");
				System.out.println("O Saldo da Conta Nr" + this.getNumero() 
				+ " é de R$ " + this.getSaldo());
				System.out.println("*******************************");
				this.qtdTransacoesRealizadas++;
			}
			else {
				System.out.println("*************************************");
				System.out.println("* Senha incorreta, digite novamente *");
				System.out.println("*************************************");
				senha = sc.nextInt();
			}
		
	}
	
	@Override
	public void alterarSenha(int novaSenha) {
		
		System.out.println("Digite a senha anterior:");
		int senhaAnterior = sc.nextInt();
		
		while(senhaAnterior != this.senha) {
			System.out.println("*************************************");
			System.out.println("* Senha incorreta, digite novamente *");
			System.out.println("*************************************");
			senhaAnterior = sc.nextInt();
			
			}
		
		this.senha = novaSenha;
		System.out.println("*********************************");
		System.out.println("* Senha alterada com sucesso!!! *");
		System.out.println("*********************************");
		
	}
	
	public void imprimeQtdTransacoesRealizadas() {
		System.out.println("*******************************************");
		System.out.println("A quantidade de transações relizadas foi de: " 
	+ this.qtdTransacoesRealizadas);
		System.out.println("*******************************************");
		
		sc.close();
	}
	
}
