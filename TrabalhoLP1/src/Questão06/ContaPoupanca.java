package Questão06;

import java.util.Scanner;

public class ContaPoupanca extends ContaBancaria{

	private double taxaRendimento;

	Scanner sc = new Scanner(System.in);
	
	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	@Override
	public void saca(double valor) {
		int senha = sc.nextInt();
		if(senha == this.senha) {
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("**********************************");
			System.out.println("*  SAQUE REALIZADO COM SUCESSO  *");
			System.out.println("**********************************");
		}
	}

	@Override
	public void deposita(double valor) {
		
		this.setSaldo(this.getSaldo() + valor);
		System.out.println("**********************************");
		System.out.println("* DEPÓSTIO REALIZADO COM SUCESSO *");
		System.out.println("**********************************");
	}

	@Override
	public void tiraExtrato() {
		int senha = sc.nextInt();
		if(senha == this.senha) {
			System.out.println("O Saldo da Conta Nr" + this.getNumero() 
			+ " é de R$ " + this.getSaldo());
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
	
	public void taxaRendimento() {
		double rendimento = this.getSaldo() * 0.01;
		this.setSaldo(this.getSaldo() + rendimento);
		
		System.out.println("**************************************************");
		System.out.println("* O rendimento da Poupança é de R$ " + rendimento);
		System.out.println("O novo Saldo é R$ " + this.getSaldo());
		System.out.println("**************************************************");
		
		sc.close();
	}
	
}
