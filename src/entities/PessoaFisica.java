package entities;

import java.util.Date;

public class PessoaFisica extends Pessoa {
	
	private String nome;
	private Date dataNascimento;
	private int cpf;
	private String rg;
	
	public PessoaFisica(int agencia, int conta, int digito, int senha, double saldo, Endereco endereco, String email,
			String telefone, String nome, Date dataNascimento, int cpf, String rg) {
		super(agencia, conta, digito, senha, saldo, endereco, email, telefone);
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
}
