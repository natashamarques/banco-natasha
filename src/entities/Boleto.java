package entities;

public class Boleto {
	private String codigoBarras;
	private double valorBoleto;
	private boolean boletoVencido;
	private double juros;

	public Boleto(String codigoBarras, double valorBoleto, boolean boletoVencido, double juros) {
		super();
		this.codigoBarras = codigoBarras;
		this.valorBoleto = valorBoleto;
		this.boletoVencido = boletoVencido;
		this.juros = juros;
	}

	public Boleto(String codigoBarras, double valorBoleto, boolean boletoVencido) {
		super();
		this.codigoBarras = codigoBarras;
		this.valorBoleto = valorBoleto;
		this.boletoVencido = boletoVencido;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public double getValorBoleto() {
		return valorBoleto;
	}

	public void setValorBoleto(double valorBoleto) {
		this.valorBoleto = valorBoleto;
	}

	public boolean isBoletoVencido() {
		return boletoVencido;
	}

	public void setBoletoVencido(boolean boletoVencido) {
		this.boletoVencido = boletoVencido;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	

}
