package entities;

public class Pessoa {

	private Endereco endereco;
	private String email;
	private String telefone;
	private Conta conta;
	
	public Pessoa(Endereco endereco, String email, String telefone, Conta conta) {
		super();
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.conta = conta;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
