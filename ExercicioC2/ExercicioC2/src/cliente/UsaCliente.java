package cliente;

import java.util.ArrayList;

import io.InOut;

public class UsaCliente {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Integer> senhasRemovidas = new ArrayList<>();
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
                atendimento(clientes, senhasRemovidas);
                break;
            case 3:
                sairDaFila(clientes, senhasRemovidas);
                break;
            case 4:
                mostrarNaoAtendidos(clientes);
                break;
            case 5:
                break;
            default:
                InOut.msgDeErro("Erro", "Opcao invalida! Tente novamente.");
            }
        } while(opcao != 5);
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

    private static void sairDaFila(ArrayList<Cliente> clientes, ArrayList<Integer> senhasRemovidas) {
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
                senhasRemovidas.add(senhaDigitada);
                InOut.msgDeInformacao("Sair da Fila", "Cliente com senha " + senhaDigitada + " foi removido da fila com sucesso!");
            } else {
                InOut.msgDeAviso("Sair da Fila", "Senha " + senhaDigitada + " nao encontrada!");
            }
        }
    }

    private static void atendimento(ArrayList<Cliente> clientes, ArrayList<Integer> senhasRemovidas) {
        if (clientes.isEmpty() && senhasRemovidas.isEmpty()) {
            InOut.msgDeAviso("Atendimento", "Nao existem clientes para receber atendimento!");
        } else {
            int indice = 0;

            while (indice < clientes.size()) {
                Cliente clienteAtendimento = clientes.get(indice);

                int statusAtendimento = InOut.leInt("O cliente " + clienteAtendimento.getNome() +
                        " de senha " + clienteAtendimento.getSenhaDoCliente() +
                        " foi atendido? \n 0. Não \n 1. Sim");

                if (statusAtendimento == 1) {
                    clientes.remove(indice);
                    InOut.msgDeInformacao("Atendimento", "Cliente " + clienteAtendimento.getNome() +
                            " foi atendido e removido da fila!");
                } else {
                    InOut.msgDeAviso("Atendimento", "O cliente " + clienteAtendimento.getNome() +
                            " ainda não foi atendido! Passando para o próximo cliente.");
                    indice++;
                }
            }

            for (Integer senhaRemovida : senhasRemovidas) {
                InOut.msgDeAviso("Atendimento", "Senha " + senhaRemovida + " não encontrada.");
            }

            InOut.msgDeInformacao("Atendimento", "Todos os clientes foram exibidos. Registro(s) finalizado(s)! ");
        }
    }

    private static void gerarSenha(ArrayList<Cliente> clientes) {
        String nome = InOut.leString("Digite o seu nome");
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        InOut.msgDeInformacao("Senha gerada com sucesso!", "Nome do Cliente: " + nome + "\nSenha: " + cliente.getSenhaDoCliente());
    }
}
