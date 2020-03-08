package entities;

public class Pessoa {
	private int agencia;
	private int conta;
	private int digito;
	private int senha;
	private double saldo;
	private Endereco endereco;
	private String email;
	private String telefone;
	
	public Pessoa(int agencia, int conta, int digito, int senha, double saldo, Endereco endereco, String email,
			String telefone) {
		super();
		this.agencia = agencia;
		this.conta = conta;
		this.digito = digito;
		this.senha = senha;
		this.saldo = saldo;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
	
	
	
}
