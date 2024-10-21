package cliente;

public class Cliente {
	// Atributos de Instância
		private static int senhaDeAtendimento = 0;
		private static int geradorDeSenha = 1;
		
	// Atributos de Classe
	private int senhaDoCliente ;
	private String nome;

	// Construtor
	// Remover senhaDoCliente
	public Cliente(String nome) {
		super();
		this.senhaDoCliente = geradorDeSenha;
		this.nome = nome;
		geradorDeSenha++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenhaDoCliente() {
		return senhaDoCliente;
	}

	public static int getSenhaDeAtendimento() {
		return senhaDeAtendimento;
	}
	
	
	// Deve ser static?
	public static int proximo() {
		senhaDeAtendimento++;
		return senhaDeAtendimento;
	}

	@Override
	public String toString() {
		return "Nome do Cliente: " + nome + "\nSenha: " + senhaDoCliente;
	}
}
