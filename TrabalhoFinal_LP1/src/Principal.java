import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.codec.digest.DigestUtils;

public class Principal {

	public static void main(String[] args) {
		
		List <Conta> conta = new ArrayList<Conta>();
		List<Funcionario> usuario = new ArrayList<Funcionario>();
		 
			String login = null;
			String senha = null;
			
			try {
				
				BufferedReader br = new BufferedReader(new FileReader("src/usuario.txt"));
				
				String linha = br.readLine();
				
				while(linha != null) {
					
					StringTokenizer st = new StringTokenizer(linha,",");
					
					Funcionario f = new Funcionario();
					f.setLogin(st.nextToken());
					f.setSenha(st.nextToken());
					f.setNivel(st.nextToken());
					usuario.add(f);
					//System.out.println(f.getLogin() +" " +  " " + f.getSenha() + " " + f.getNivel());
					
					linha = br.readLine();
					
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Scanner ler = new Scanner(System.in);
			System.out.println("Para acessar o sistema digite Login e senha do usuário: ");
			System.out.println("Login: ");
			String loginAtual = ler.next();
			
			System.out.println("Senha: ");
			String senhaAtual = ler.next();
			String senhaAtualMD5 = DigestUtils.md5Hex(senhaAtual);
			
			for(int i = 0 ; i < usuario.size(); i++) {
				
				if(usuario.get(i).getLogin().equals(loginAtual)) {
					login = usuario.get(i).getLogin();
				}
				else 
					System.out.println("Login Incorreto");
			}
			
			if (login == loginAtual ) {
				
				if(senhaAtualMD5.equals(senha)) {
					System.out.println("Senha correta.");
					boolean sair = true;
					do 
					{
						 System.out.println("Menu Principal");
						 System.out.println("Informe a opcao do menu: ");
						 System.out.println("Digite 1 - Cadastrar novo usuário");
						 System.out.println("Digite 2 - Contas");
						 System.out.println("Digite 3 - Relatório final");
						 System.out.println("Digite 4 - Sair");
					   
					   int op = ler.nextInt();
					   
					   switch(op){
						
						
						case 1:
								System.out.println("Cadastre Novo usuário!");
								System.out.println("Digite o login no novo usuário: ");
								String novoLogin = ler.next();
								System.out.println("Digite a senha no novo usuário: ");
								String novaSenha = ler.next();
								System.out.println("Digite o nível no novo usuário: ");
								String novoNivel = ler.next();
								usuario.add(new Funcionario(novoLogin, novaSenha, novoNivel));
							break;
						
						case 2:
							Conta c = new Conta();
							boolean voltar = true;
							do 
							{
								 System.out.println("Cadastrar nova Conta");
								 System.out.println("Informe a opcao do menu: ");
								 System.out.println("Digite 1 - Cadastrar Conta");
								 System.out.println("Digite 2 - Alterar Conta");
								 System.out.println("Digite 3 - Alterar Conta");
								 System.out.println("Digite 4 - Consultar Conta");
								 System.out.println("Digite 5 - Fechar Conta");
								 System.out.println("Digite 6 - Relatório de veículos no Estacionamento");
								 System.out.println("Digite 7 - Total de diárias pagas");
								 System.out.println("Digite 8 - Volta ao menu principal");
							   
							   
							   int operacao = ler.nextInt();
							   
							   switch(operacao) {
							   case 1:
								   
								   while (usuario.size() < 30) {
								   System.out.println("Cadastrar nova Conta");
								   System.out.println("Qual o tipo de Veículo:");
									System.out.println("Digite 1 para carro");
									System.out.println("Digite 2 para Moto");
									System.out.println("Digite 3 para Caminhão");
									System.out.println("Digite 4 para Ônibus");
									System.out.println("*******************************");
									int tipo = ler.nextInt();
									
									if (tipo == 1) {
										
										Veiculo carro = new Carro();
										System.out.println("Digite os dados do Veículo.");
										System.out.println("Digite a marca: ");
										carro.setMarca(ler.next());
										System.out.println("Digite o modelo: ");
										carro.setModelo(ler.next());
										System.out.println("Digite a Placa: ");
										carro.setPlaca(ler.next());
										System.out.println("Digite a cor: ");
										carro.setCor(ler.next());
										System.out.println("Digite a quantidade de portas: ");
										((Carro) carro).setQuantidadePortas(ler.nextInt());
										c.setVeiculo(carro);
										//conta.add(c);
										
									}
									else if (tipo == 2) {
										Moto moto = new Moto();
										System.out.println("Digite os dados do Veículo.");
										System.out.println("Digite a marca: ");
										moto.setMarca(ler.next());
										System.out.println("Digite o modelo: ");
										moto.setModelo(ler.next());
										System.out.println("Digite a Placa: ");
										moto.setPlaca(ler.next());
										System.out.println("Digite a cor: ");
										moto.setCor(ler.next());
										System.out.println("Digite a quantidade de cilindradas: ");
										((Moto) moto).setClilindradas(ler.nextDouble());
										c.setVeiculo(moto);
										//conta.add(c);
										
									}
									else if (tipo == 3) {
										Veiculo caminhao = new Caminhao();
										System.out.println("Digite os dados do Veículo.");
										System.out.println("Digite a marca: ");
										caminhao.setMarca(ler.next());
										System.out.println("Digite o modelo: ");
										caminhao.setModelo(ler.next());
										System.out.println("Digite a Placa: ");
										caminhao.setPlaca(ler.next());
										System.out.println("Digite a cor: ");
										caminhao.setCor(ler.next());
										System.out.println("Digite a capacidade de carga: ");
										((Caminhao) caminhao).setCapacidadeCarga(ler.nextDouble());
										c.setVeiculo(caminhao);
										//conta.add(c);
									}
									else if (tipo == 4) {
										
										Veiculo onibus = new Onibus();
										
										System.out.println("Digite os dados do Veículo.");
										System.out.println("Digite a marca: ");
										onibus.setMarca(ler.next());
										System.out.println("Digite o modelo: ");
										onibus.setModelo(ler.next());
										System.out.println("Digite a Placa: ");
										onibus.setPlaca(ler.next());
										System.out.println("Digite a cor: ");
										onibus.setCor(ler.next());
										System.out.println("Digite a capacidade de passageiros: ");
										((Onibus) onibus).setCapacidadePassageiros(ler.nextInt());
										c.setVeiculo(onibus);
										//conta.add(c);
									}
									else 
										System.out.println("Tipo de veículo não existente!!");
									
										System.out.println("Digite os dados do Cliente.");
										Cliente cliente = new Cliente();
										System.out.println("Digite o nome: ");
										cliente.setNome(ler.next());
										System.out.println("Digite o CPF: ");
										cliente.setCpf(ler.next());
										System.out.println("Digite o Telefone: ");
										((Cliente)cliente).setTelefone(ler.next());
										c.setCliente(cliente);
										//conta.add(c);
										
										System.out.println("Digite a Data: ");
										c.setData(ler.next());
										System.out.println("Digite a Hora de chegada: ");
										c.setHoraChegada(ler.next());
										
										conta.add(c);
								   }
								
								   break;
							   case 2: 
								   
								   break;
							   case 3: 
								   
								   break;
							   case 4: 
								   
								   break;
							   case 5: 
						   
								   break;
							   case 6: 
								   
								   break;
							   case 7: 
						   
								   break;
							   case 8: 
								   voltar = false;
								   break;
							   default:
					           	System.out.println("******************");
					           	System.out.println("* OPÇÃO INVÁLIDA *");
					           	System.out.println("******************"); 
							  
							   }
							   
						  }while(voltar);
							break;
							
						case 3:
							
							break;
						
						case 4:
							
							break;
						default:
				        	System.out.println("******************");
				        	System.out.println("* OPÇÃO INVÁLIDA *");
				        	System.out.println("******************");
						
					}
					   
					   }while(sair);
				}
				else {
					System.out.println("Senha incorreta.");
				}
			}
			else 
				System.out.println("Login incorreto");
			
			ler.close();
			
			System.out.println();
			try {
				FileWriter arquivo = new FileWriter("log.txt", true);
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				if(senhaAtualMD5.equals(senha)) {
					gravarArquivo.print(horaAtual());
					gravarArquivo.print(" - ");
					gravarArquivo.println("Usuário com senha correta acessou o sistema.");
				}
				else {
					gravarArquivo.print(horaAtual());
					gravarArquivo.print(" - ");
					gravarArquivo.println("Usuário com senha incorreta acessou o sistema.");
				}
				
			    arquivo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		
			ler.close();
		
	}
	public static String horaAtual () {
		
		Calendar data = Calendar.getInstance();
		int hora = data.get(Calendar.HOUR_OF_DAY); 
		int min = data.get(Calendar.MINUTE);
		int seg = data.get(Calendar.SECOND);
		String horaAtual = hora + ":" + min + ":" + seg;
		return horaAtual;
	}	
	
	public static void menuPrincipal(int op) {
		
		
	}
	
	public static void menuCadastrarConta() {
		Scanner ler = new Scanner(System.in);
		
		
			
		ler.close();
		
	}
}



