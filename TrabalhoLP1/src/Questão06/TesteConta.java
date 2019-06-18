package Questão06;

import java.util.Scanner;

public class TesteConta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ContaBancaria[] conta;
		
		System.out.println("Digite a qtd de Contas");
		int qtdConta = sc.nextInt();
		conta = new ContaBancaria[qtdConta];
		
		int i = 0;
		while (i < qtdConta) {
		
			System.out.println("Qual o tipo de Conta desejada:");
			System.out.println("Digite 1 para Conta Corrente");
			System.out.println("Digite 2 para Conta Poupança");
			System.out.println("*******************************");
			int tipo = sc.nextInt();
			
			if (tipo == 1) {
				conta[i] = new ContaCorrente();
				System.out.println("Digite o número da Conta Corrente");
				conta[i].setNumero(sc.nextInt());
				System.out.println("Digite o Depósito inicial");
				conta[i].setSaldo(sc.nextDouble());
				System.out.println("Digite a senha");
				conta[i].setSenha(sc.nextInt());
			
			}
			else if (tipo == 2) {
				conta[i]  = new ContaPoupanca();
				System.out.println("Digite o número da Conta Poupança");
				conta[i].setNumero(sc.nextInt());
				System.out.println("Digite o Depósito inicial");
				conta[i].setSaldo(sc.nextDouble());
				System.out.println("Digite a senha");
				conta[i].setSenha(sc.nextInt());
			}
			i++;
		}
		boolean sair = true;
		int nrConta = 0;
		 do
		    {
		       System.out.println("Menu Principal");
		        System.out.println("Informe a opcao do menu: ");
		        System.out.println("Digite 0 - Sair");
		        System.out.println("Digite 1 - Saque Conta");
		        System.out.println("Digite 2 - Depósito");
		        System.out.println("Digite 3 - Extrato");
		        System.out.println("Digite 4 - Alterar senha");
		        System.out.println("Digite 5 - Mostrar taxa de rendimento da Poupança");
		        System.out.println("Digite 6 - Mostrar Qtd Transações da Conta Corrrente");
		        
		        int op = sc.nextInt();

		        switch(op){
		            case 0:
		            	sair = false;
		            	break;
		            case 1:
		            	System.out.println("Digite o número da Conta para saque!!");
		            	nrConta = sc.nextInt();
		            	for(int j = 0; j < conta.length; j++ ) {
		    				if (conta[j] instanceof ContaCorrente) {
		    					if(nrConta == conta[j].getNumero()){
		    						System.out.println("Digite o valor do saque");	
		    						((ContaCorrente)conta[j]).saca(sc.nextDouble());
		    					}
		    				}
		    				else if (conta[j] instanceof ContaPoupanca) {
		    					if(nrConta == conta[j].getNumero()) {
		    						System.out.println("Digite o valor do saque");	
		    						((ContaPoupanca)conta[j]).saca(sc.nextDouble());
				    			}
		    				}	
		    			}
		    			
		                break;
		           	case 2:
		           		System.out.println("Digite o número da Conta para Depósito!!");
		            	nrConta = sc.nextInt();
		            	for(int j = 0; j < conta.length; j++ ) {
		    				
		    				if (conta[j] instanceof ContaCorrente) {
		    					if(nrConta == ((ContaCorrente)conta[j]).getNumero()){
		    						System.out.println("Digite o valor do depósito");	
		    						((ContaCorrente)conta[j]).deposita(sc.nextDouble());
		    					}
		    				}
		    				else if (conta[j] instanceof ContaPoupanca) {
		    					if(nrConta == ((ContaPoupanca)conta[j]).getNumero()) {
		    						System.out.println("Digite o valor do depósito");	
				    				((ContaPoupanca)conta[j]).deposita(sc.nextDouble());
		    					}	
		    				}
		    			}
		    			
		                break;
		                
		            case 3:
		            	System.out.println("Digite o número da Conta!!");
		            	nrConta = sc.nextInt();
		            	for(int j = 0; j < conta.length; j++ ) {
		    				
		    				if (conta[j] instanceof ContaCorrente) {
		    					if(nrConta == ((ContaCorrente)conta[j]).getNumero()){
		    				
		    						((ContaCorrente)conta[j]).tiraExtrato();
		    					}
		    				}
		    				else if (conta[j] instanceof ContaPoupanca) {
		    					if(nrConta == ((ContaPoupanca)conta[j]).getNumero()) {
		    						((ContaPoupanca)conta[j]).tiraExtrato();
		    						}
				    			}
		    				}
		               
		                break;

		            case 4:
		                System.out.println("Digite o número da Conta!!");
		            	nrConta = sc.nextInt();
		            	for(int j = 0; j < conta.length; j++ ) {
		    				
		    				if (conta[j] instanceof ContaCorrente) {
		    					if(nrConta == ((ContaCorrente)conta[j]).getNumero()){
				    				System.out.println("Digite a nova senha");
				    				((ContaCorrente)conta[j]).alterarSenha(sc.nextInt());
		    					}
		    				}
		    				else if (conta[j] instanceof ContaPoupanca) {
		    					if(nrConta == ((ContaPoupanca)conta[j]).getNumero()) {
			    					System.out.println("Digite a nova senha");
					    			((ContaPoupanca)conta[j]).alterarSenha(sc.nextInt());
		    						}
				    			}
		    				}
		                break;
		            case 5:
		            	System.out.println("Digite o número da Conta!!");
		            	nrConta = sc.nextInt();
		            	for(int j = 0; j < conta.length; j++ ) {
		    				
		    				if (conta[j] instanceof ContaCorrente) {
		    					if(nrConta == ((ContaCorrente)conta[j]).getNumero()){
		    						System.out.println("************************************************");
				    				System.out.println("* Conta Corrente não possui taxa de rendimento *");
				    				System.out.println("************************************************");
		    					}
		    				}
		    				else if (conta[j] instanceof ContaPoupanca) {
		    					if(nrConta == ((ContaPoupanca)conta[j]).getNumero())
					    			((ContaPoupanca)conta[j]).taxaRendimento();
				    				}
		    				}
		            	 break;
		            case 6:
		            	System.out.println("Digite o número da Conta!!");
		            	nrConta = sc.nextInt();
		            	
		            	for(int j = 0; j < conta.length; j++ ) {
		    				
		    				if (conta[j] instanceof ContaCorrente) {
		    					if(nrConta == ((ContaCorrente)conta[j]).getNumero()){
				    				((ContaCorrente)conta[j]).imprimeQtdTransacoesRealizadas();
		    					}
		    				}
		    				else if (conta[j] instanceof ContaPoupanca) {
		    					if(nrConta == ((ContaPoupanca)conta[j]).getNumero()) {
		    						System.out.println("********************************************");
			    					System.out.println("* Operação Inexistente para Conta Poupança *");
		    						System.out.println("********************************************");
		    						}
		    					}
		    				}
		            	 break;
		            	 
		            default:
		            	System.out.println("******************");
		            	System.out.println("* OPÇÃO INVÁLIDA *");
		            	System.out.println("******************");
		        }
		 
		 	
		    }while(sair);
		 System.out.println("*****************");
		 System.out.println("*  FINALIZADO!  *");
		 System.out.println("*****************");
	}
}
