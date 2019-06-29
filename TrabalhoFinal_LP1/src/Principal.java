import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.codec.digest.DigestUtils;

public class Principal {

	public static void main(String[] args) {
		
		List <Conta> conta = new ArrayList<Conta>();
		List<Funcionario> usuario = new ArrayList<Funcionario>();
		
		Estacionamento estacionamento = new Estacionamento();
		 
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
			
			//String senhaAtualMD5 = DigestUtils.md5Hex(senhaAtual);
			
			Funcionario f = new Funcionario();
			boolean log = false;
			
			for(int i = 0 ; i < usuario.size(); i++) {
				
				if (loginAtual.compareTo(usuario.get(i).getLogin()) == 0) {
					log = true;
					f = usuario.get(i);
					
					if (log ) {
						System.out.println("Senha: ");
						String senhaAtual = ler.next();
						boolean confirma = f.autentica(senhaAtual);
						
						System.out.println("Digite a data Atual: ");
						String dataAtual = ler.next();
						estacionamento.setDataAtual(dataAtual);
						
						if(confirma) {
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
										String senhaAtualMD5 = DigestUtils.md5Hex(novaSenha);
										System.out.println("Digite o nível no novo usuário: ");
										String novoNivel = ler.next();
										usuario.add(new Funcionario(novoLogin, novaSenha, novoNivel));
										
										try {
											FileWriter arquivo = new FileWriter("src/usuario.txt", true);
											PrintWriter gravarArquivo = new PrintWriter(arquivo);
											gravarArquivo.println();
											gravarArquivo.print(novoLogin);
											gravarArquivo.print(",");
											gravarArquivo.print(senhaAtualMD5);
											gravarArquivo.print(",");
											gravarArquivo.print(novoNivel);
											gravarArquivo.close();
											
										}catch(Exception e) {
											e.printStackTrace();
										}
									break;
								
								case 2:
									Conta c = new Conta();
									boolean voltar = true;
									do 
									{
										 System.out.println("************** Cadastrar nova Conta ***************");
										 System.out.println("Informe a opcao do menu: ");
										 System.out.println("Digite 1 - Cadastrar Conta");
										 System.out.println("Digite 2 - Alterar Conta");
										 System.out.println("Digite 3 - Excluir Conta");
										 System.out.println("Digite 4 - Consultar Conta");
										 System.out.println("Digite 5 - Fechar Conta");
										 System.out.println("Digite 6 - Relatório de veículos no Estacionamento");
										 System.out.println("Digite 7 - Total de diárias pagas");
										 System.out.println("Digite 8 - Volta ao menu principal");
										 System.out.println("****************************************************");
									   
									   int operacao = ler.nextInt();
									   
									   switch(operacao) {
									   case 1:
										    System.out.println("********* Cadastrar nova Conta ********");
										    System.out.println("Qual o tipo de Veículo:");
											System.out.println("Digite 1 para carro");
											System.out.println("Digite 2 para Moto");
											System.out.println("Digite 3 para Caminhão");
											System.out.println("Digite 4 para Ônibus");
											System.out.println("***************************************");
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
												c.setData(dataAtual);
												System.out.println("Digite a Hora de chegada: ");
												c.setHoraChegada(ler.next());
												
												if (estacionamento.getLotacao() < IEstacionamento.capacidadeVeiculos) {
													estacionamento.setLotacao(estacionamento.getLotacao() + 1);
													conta.add(c);
												}
										   break;
									   case 2: 
										   System.out.println("***** ALTERAR CONTA: *********");
										   System.out.println(" Digite a placa do veículo: ");
										   String placa = ler.next();
										   
										   for (int j = 0 ; conta.size() < j; i++) {
											   if(placa == conta.get(j).getVeiculo().getPlaca()) {
												   int tipo2 = 0;
												   if (tipo2 == 1) {
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
													}
													else if (tipo2 == 2) {
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
													}
													else if (tipo2 == 3) {
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
													}
													else if (tipo2 == 4) {
														
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
													}
													else 
														System.out.println("Tipo de veículo não existente!!");
													
														System.out.println("Digite os dados do Cliente.");
														Cliente cliente2 = new Cliente();
														System.out.println("Digite o nome: ");
														cliente2.setNome(ler.next());
														System.out.println("Digite o CPF: ");
														cliente2.setCpf(ler.next());
														System.out.println("Digite o Telefone: ");
														((Cliente)cliente2).setTelefone(ler.next());
														c.setCliente(cliente2);
														
														c.setData(dataAtual);
														System.out.println("Digite a Hora de chegada: ");
														c.setHoraChegada(ler.next());
														conta.add(c);
											   }
										   }
										   break;
										   
									   case 3: 
										   System.out.println("***** APAGAR CONTA: ********");
										   System.out.println("Digite a placa do veículo: ");
										   placa = ler.next();
										   
										   for (int j = 0 ; conta.size() < j; i++) {
											   if(placa == conta.get(j).getVeiculo().getPlaca()) {
												   conta.remove(j);
											   }
											   else {
												   System.out.println("*******************************");
												   System.out.println("**** Veículo não cadastrado ***");
												   System.out.println("********************************");
											   }
										   }
										   break;
									   case 4: 
										   System.out.println("***** IMPRIMIR CONTA: ********");
										   System.out.println(" Digite a placa do veículo da conta a ser impressa: ");
										   placa = ler.next();
										   for (int j = 0 ; conta.size() < j; i++) {
											   
											   if(placa == conta.get(j).getVeiculo().getPlaca()) {
													  System.out.println(conta.get(j));
												  }
											   else {
												   System.out.println("*******************************");
												   System.out.println("**** Veículo não cadastrado ***");
												   System.out.println("********************************");
											   }
											  }
										   break;
									   case 5: 
										   System.out.println("***** FECHAR CONTA: ********");
										   System.out.println(" Digite a placa do veículo da conta a ser fechada: ");
										   placa = ler.next();
										   for (int j = 0 ; conta.size() < j; i++) {
											   
											   if(placa == conta.get(j).getVeiculo().getPlaca()) {
												   double valor = 0;
												   if (conta.get(j).getVeiculo() instanceof Carro ) {
													   valor = IEstacionamento.valorDiariaCarro;  
												   }
												   else if (conta.get(j).getVeiculo() instanceof Moto ) {
													  valor = IEstacionamento.valorDiariaMoto;  
												   }
												   else if (conta.get(j).getVeiculo() instanceof Caminhao ) {
													   valor = IEstacionamento.valorDiariaCaminhao;  
												   }
												   else if (conta.get(j).getVeiculo() instanceof Onibus ) {
													   valor = IEstacionamento.valorDiariaOnibus;  
												   }
												   int pagamento = 0;
												   pagamento ++;
												   estacionamento.setLotacao(estacionamento.getLotacao() - 1);
												   
														   
												   String nomeArquivo = "src/" + estacionamento.getDataAtual() + "RelatorioDiario.txt";
												  try {
														FileWriter arquivo2 = new FileWriter(nomeArquivo, true);
														PrintWriter gravarArquivo = new PrintWriter(arquivo2);
														gravarArquivo.print(estacionamento.getDataAtual());
														gravarArquivo.print(" - ");
														gravarArquivo.print(conta.get(j).getHoraChegada());
														gravarArquivo.print(" - ");
														gravarArquivo.print("O CARRO Chevrolet Prisma com placa ");
														gravarArquivo.print(conta.get(j).getVeiculo().getPlaca());
														gravarArquivo.print(" entrou no estacionamento, conduzido por ");
														gravarArquivo.print(conta.get(j).getCliente().getNome());
														gravarArquivo.print(" de CPF: ");
														gravarArquivo.print(conta.get(j).getCliente().getCpf());
														gravarArquivo.print(" e pagou a quantia de R$ ");
														gravarArquivo.print(valor);
														gravarArquivo.println(" Reais.");
														
														gravarArquivo.close();
														
													}catch(Exception e) {
														e.printStackTrace();
													}
												  }
											   else {
												   System.out.println("*******************************");
												   System.out.println("**** Veículo não cadastrado ***");
												   System.out.println("********************************");
											   }
											  }
										   
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
									sair = false;
									break;
								default:
						        	System.out.println("******************");
						        	System.out.println("* OPÇÃO INVÁLIDA *");
						        	System.out.println("******************");
								
							}
							   
						}while(sair);
							System.out.println("**********************");
				        	System.out.println("* SISTEMA FINALIZADO *");
				        	System.out.println("**********************");
					}
						
				}	
					ler.close();
				
			}
			
		}
		
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
