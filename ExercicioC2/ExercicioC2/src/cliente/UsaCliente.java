package cliente;

import java.util.ArrayList;

import io.InOut;

public class UsaCliente {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		int opcao;
		do {
			opcao = InOut.leInt("Escolha uma opcao\n" +
					"1 - Gerar senha\n" +
					"2 - Atendimento\n" +
					"3 - Sair da fila\n" +
					"4 - Mostrar todos os clientes nao atendidos\n" +
					"5 - Sair do programa");
			switch(opcao) {
			case 1:
				gerarSenha(clientes);
				break;
			case 2:
				atendimento(clientes);
				break;
			case 3:
				sairDaFila(clientes);
				break;
			case 4:
				mostrarNaoAtendidos(clientes);
				break;
			case 5:
				break;
			default:
				InOut.msgDeErro("Erro", "Opcao invalida! Tente novamente.");
			}
		} while(opcao !=5);
		InOut.msgDeInformacao("Saindo", "Programa encerrado!");
	}

	private static void mostrarNaoAtendidos(ArrayList<Cliente> clientes) {
	    if (clientes.isEmpty()) {
	        InOut.msgDeAviso("Clientes Nao Atendidos", "Nao existem clientes nao atendidos!");
	    } else {
	        StringBuilder mensagem = new StringBuilder("Clientes nao atendidos:\n");

	        for (Cliente cliente : clientes) {
	            mensagem.append("Senha: ").append(cliente.getSenhaDoCliente()).append("\n");
	        }

	        InOut.msgDeInformacao("Clientes Nao Atendidos", mensagem.toString());
	    }
	}

	private static void sairDaFila(ArrayList<Cliente> clientes) {
	    if (clientes.isEmpty()) {
	        InOut.msgDeAviso("Sair da Fila", "Nao existem clientes na fila!");
	    } else {
	        int senhaDigitada = InOut.leInt("Digite a sua senha: ");
	        Cliente clienteSairFila = null;

	        for (Cliente cliente : clientes) {
	            if (cliente.getSenhaDoCliente() == senhaDigitada) {
	                clienteSairFila = cliente;
	                break;
	            }
	        }

	        if (clienteSairFila != null) {
	            clientes.remove(clienteSairFila);
	            InOut.msgDeInformacao("Sair da Fila", "Cliente com senha " + senhaDigitada + " foi removido da fila com sucesso!");
	        } else {
	            InOut.msgDeAviso("Sair da Fila", "Senha " + senhaDigitada + " nao encontrada!");
	        }
	    }
	}

private static void atendimento(ArrayList<Cliente> clientes) {
	    if (clientes.isEmpty()) {
	        InOut.msgDeAviso("Atendimento", "Nao existem clientes para receber atendimento!");
	    } else {

	        while (!clientes.isEmpty()) {
	            int senhaSeguinte = Cliente.proximo();
	            Cliente clienteAtendimento = null;

	            for (Cliente cliente : clientes) {
	                if (cliente.getSenhaDoCliente() == senhaSeguinte) {
	                    clienteAtendimento = cliente;
	                    break; // Sair do for
	                }
	            }

	            if (clienteAtendimento != null) {
	                int Finalizacao = 0;
	                while( Finalizacao != 1) {
	                InOut.msgDeInformacao("Atendimento", "O próximo Cliente é: " + clienteAtendimento.getNome() + " de senha " + clienteAtendimento.getSenhaDoCliente());
	            	Finalizacao = InOut.leInt("O cliente " + clienteAtendimento.getNome() + " de senha " + clienteAtendimento.getSenhaDoCliente() + " foi atendido corretamente? \n 0. Não \n 1. Sim" );
	            	clientes.remove(clienteAtendimento);
	                }
	                break; // Sair do while final
	            } else { 
	            	InOut.msgDeAviso("Atendimento", "Não foi encontrado o Cliente de senha " + senhaSeguinte);
	            }
	        }

	        InOut.msgDeInformacao("Atendimento", " Atendimento realizado finalizado. " );
	    }
	}

	private static void gerarSenha(ArrayList<Cliente> clientes) {
		String nome = InOut.leString("Digite o seu nome");
		Cliente cliente = new Cliente(nome);
		clientes.add(cliente);
		InOut.msgDeInformacao("Senha gerada com sucesso!", "Nome do Cliente: " + nome + "\nSenha: " + cliente.getSenhaDoCliente());
	}
}
