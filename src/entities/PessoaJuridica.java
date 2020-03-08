package entities;

public class PessoaJuridica extends Pessoa {
	private String razaoSocial;
	private String nomeFantasia;
	private int cnpj;

	public PessoaJuridica(int agencia, int conta, int digito, int senha, double saldo, Endereco endereco, String email,
			String telefone, String razaoSocial, String nomeFantasia, int cnpj) {
		super(agencia, conta, digito, senha, saldo, endereco, email, telefone);
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

}
