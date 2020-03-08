package entities;

public class Pessoa {
	int agencia;
	int conta;
	int digito;
	int senha;
	double saldo;
	
	public Pessoa(int agencia, int conta, int digito, int senha, double saldo) {
		super();
		this.agencia = agencia;
		this.conta = conta;
		this.digito = digito;
		this.senha = senha;
		this.saldo = saldo;
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
	
}
