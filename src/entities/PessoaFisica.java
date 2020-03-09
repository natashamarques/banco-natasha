package entities;

import java.util.Date;

public class PessoaFisica extends Pessoa {

	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String rg;

	public PessoaFisica(Endereco endereco, String email, String telefone, Conta conta, String nome, Date dataNascimento,
			String cpf, String rg) {
		super(endereco, email, telefone, conta);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "-----Informações cadastrais----- " + "\nNome: " + nome + "\nCPF: " + cpf + "\nRG: " + rg
				+ "\nData de nascimento: " + dataNascimento + "\nEmail: " + getEmail() + "\nTelefone: " + getTelefone()
				+ "\n----Informações da conta-----" + "\nAgencia: " + getConta().getAgencia() + "\nConta: "
				+ getConta().getConta() + "\nDigito: " + getConta().getDigito() + "\nSaldo: " + getConta().getSaldo();
	}

}
