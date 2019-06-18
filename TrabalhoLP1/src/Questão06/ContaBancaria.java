package Questão06;

import java.util.Scanner;

public abstract class ContaBancaria {
	
	protected int senha;
	private int numero;
	private double saldo;
	
	public ContaBancaria() {
	}

	public ContaBancaria(int senha, int numero, double saldo) {
		this.senha = senha;
		this.numero = numero;
		this.saldo = saldo;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	Scanner sc = new Scanner(System.in);
	
	public abstract void saca(double valor);
	
	public abstract void deposita(double valor);
	
	public abstract void tiraExtrato();
	
	
	
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
		
		System.out.println("**********************************");
		System.out.println("* Senha alterada com sucesso!!!  *");
		System.out.println("**********************************");
		
		sc.close();
	}
	
}
