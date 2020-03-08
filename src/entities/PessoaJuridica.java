package entities;

public class PessoaJuridica extends Pessoa {
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;

	public PessoaJuridica(Endereco endereco, String email, String telefone, Conta conta, String razaoSocial,
			String nomeFantasia, String cnpj) {
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
