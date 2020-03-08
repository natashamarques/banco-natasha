package entities;

public class PessoaJuridica extends Pessoa {
	private String razaoSocial;
	private String nomeFantasia;
	private int cnpj;

	public PessoaJuridica(Endereco endereco, String email, String telefone, Conta conta, String razaoSocial,
			String nomeFantasia, int cnpj) {
		super(endereco, email, telefone, conta);
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
