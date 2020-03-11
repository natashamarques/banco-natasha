package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

import entities.Boleto;
import entities.Conta;
import entities.Endereco;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {
	static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	static ArrayList<Boleto> boletos = new ArrayList<Boleto>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		populate();
		int opcao = 0;

		while (opcao != 4) {
			mostarMenuPrincipal();
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				registarCliente();
				break;
			case 2:
				listarClientes();
				break;
			case 3:
				logarCliente();
				break;
			case 4:
				System.out.println("Obrigado por utilizar o sistema !!!");
			default:
				System.out.println("Por favor informar uma opção valida !");

			}
		}

	}

	private static void logarCliente() {
		System.out.println();
		System.out.println("--------- CLIENTE LOGADO --------");
		System.out.println("Informe os dados abaixo: ");
		System.out.println("\nAgencia: ");
		int agencia = sc.nextInt();
		System.out.println("\nConta: ");
		int conta = sc.nextInt();
		System.out.println("\nSenha: ");
		int senha = sc.nextInt();
		for (Pessoa pessoa : pessoas) {
			if (agencia == pessoa.getConta().getAgencia() && conta == pessoa.getConta().getConta()
					&& senha == pessoa.getConta().getSenha()) {
				System.out.println("Bem-vindo =)");
				mostrarMenuLogado(pessoa);
			}
		}

	}

	private static void mostrarMenuLogado(Pessoa pessoa) {
		System.out.println();
		System.out.print("--------- MENU DO USUÁRIO ---------");
		int opcao = 0;
		while (opcao != 6) {
			System.out.println("1- Fazer transferencia" + "\n2- Fazer deposito" + "\n3- Ver saldo"
					+ "\n4- Fazer pagamento de boleto" + "\n5- Alterações Cadastrais" + "\n6- Sair");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				fazerTransferencia(pessoa);
				break;
			case 2:
				fazerDeposito(pessoa);
				break;
			case 3:
				verSaldo(pessoa);
				break;
			case 4:
				fazerPagamentoBoleto(pessoa);
				break;
			case 5:
				alteracoesCadastrais(pessoa);
				break;
			case 6:
				System.out.println("Obrigado por utilizar o caixa =)");
			}
		}

	}

	private static void alteracoesCadastrais(Pessoa pessoa) {
		System.out.println();
		System.out.print("--------- FAZER ALTERAÇÕES CADASTRAIS ---------");
		if (pessoa instanceof PessoaFisica) {
			System.out.println("Menu de alteções cadastrais PF" + "\n1- Alterar Nome" + "\n2- Telefone" + "\n3- Email"
					+ "\n4- Endereço");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Digite seu novo nome: " + ((PessoaFisica) pessoa).getNome());
				String nome = sc.next();
				((PessoaFisica) pessoa).setNome(nome);
			case 2:
				alterarTelefone(pessoa);
				break;
			case 3:
				alterarEmail(pessoa);
				break;
			case 4:
				alterarEndereco(pessoa);
				break;
			}
		}

	}

	private static void alterarEndereco(Pessoa pessoa) {
		System.out.println("Digite seu novo endereço: ");
		pessoa.setEndereco(criarNovoEndereco());
	}

	private static void alterarEmail(Pessoa pessoa) {
		System.out.println("Digite o novo email: ");
		String email = sc.next();
		pessoa.setEmail(email);
	}

	private static void alterarTelefone(Pessoa pessoa) {
		System.out.println("Digite o novo numero de telefone: ");
		String telefone = sc.next();
		pessoa.setTelefone(telefone);
	}

	private static void fazerPagamentoBoleto(Pessoa pessoa) {
		System.out.println();
		System.out.print("--------- FAZER PAGAMENTO DE BOLETO ---------");
		System.out.println("Digite o codigo do boleto");
		String codigoBarras = sc.next();
		if (codigoBarras.length() == 20) {
			for (Boleto boleto : boletos) {
				if (codigoBarras.equals(boleto.getCodigoBarras())) {
					if (boleto.isBoletoVencido()) {
						pessoa.getConta()
								.setSaldo(pessoa.getConta().getSaldo() - (boleto.getValorBoleto() + boleto.getJuros()));
					} else {
						pessoa.getConta().setSaldo(pessoa.getConta().getSaldo() - boleto.getValorBoleto());
					}
				}
			}

		} else {
			System.out.println("Boleto invalido");
		}

	}

	private static void verSaldo(Pessoa pessoa) {
		System.out.println();
		System.out.print("--------- VER SALDO ---------");
		if (pessoa instanceof PessoaFisica) {
			System.out
					.println(((PessoaFisica) pessoa).getNome() + " o seu saldo é de: " + pessoa.getConta().getSaldo());
		} else {
			System.out.println(
					((PessoaJuridica) pessoa).getRazaoSocial() + " o seu saldo é de: " + pessoa.getConta().getSaldo());
		}

	}

	private static void fazerDeposito(Pessoa pessoa) {
		System.out.println();
		System.out.print("--------- FAZER DEPOSITO ---------");
		System.out.println("Qual o valor deseja depositar na sua conta? ");
		double valor = sc.nextDouble();
		pessoa.getConta().setSaldo(pessoa.getConta().getSaldo() + valor);
		System.out.println("Deposito realizado com sucesso =)");
	}

	private static void fazerTransferencia(Pessoa pessoa) {
		System.out.println();
		System.out.print("--------- FAZER TRANSFERENCIA ---------");
		System.out.println("\nInforme o CPF/CNPJ da Pessoa que deseja transferir: ");
		String documento = sc.next();
		if (documento.length() == 11) {
			for (Pessoa pessoaDestinatario : pessoas) {
				if (pessoaDestinatario instanceof PessoaFisica) {
					if (((PessoaFisica) pessoaDestinatario).getCpf().equals(documento)) {
						System.out.println("Qual o valor que deseja transferir? ");
						double valor = sc.nextDouble();
						pessoa.getConta().setSaldo(pessoa.getConta().getSaldo() - valor);
						pessoaDestinatario.getConta().setSaldo(pessoaDestinatario.getConta().getSaldo() + valor);
					}
				}
			}
		}

		else if (documento.length() == 14) {
			for (Pessoa pessoaDestinatario : pessoas) {
				if (pessoaDestinatario instanceof PessoaJuridica) {
					if (((PessoaJuridica) pessoaDestinatario).getCnpj().equals(documento)) {
						System.out.println("Qual o valor que deseja transferir? ");
						double valor = sc.nextDouble();
						pessoa.getConta().setSaldo(pessoa.getConta().getSaldo() - valor);
						pessoaDestinatario.getConta().setSaldo(pessoaDestinatario.getConta().getSaldo() + valor);

					}
				}
			}

		} else {
			System.out.println("Invalido");
		}

	}

	private static void listarClientes() {
		System.out.println();
		System.out.println("--------- LISTAR CLIENTES -------");
		System.out.println("--------- PESSOAS FÍSICAS -------");
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof PessoaFisica) {
				System.out.println(pessoa);
			}
		}
		System.out.println("--------- PESSOAS JURIDICAS -------");
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof PessoaJuridica) {
				System.out.println(pessoa);
			}
		}
	}

	private static void populate() {
		Endereco endereco = new Endereco(03455, "Formoselha", "Arica", "SP", "sp", "161");
		Endereco endereco1 = new Endereco(23456, "São felix", "Ari", "SP", "poa", "168", "1º andar");
		Conta conta = new Conta(011, 123, 6, 123, 1000);
		Conta conta1 = new Conta(012, 321, 7, 321, 20000);
		PessoaFisica pessoa = new PessoaFisica(endereco, "thiago@.com", "119123456", conta, "Thiago", new Date(), "498",
				"1616");
		PessoaJuridica pessoa1 = new PessoaJuridica(endereco1, "nata@hot", "1198000", conta1, "nenhuma", "Mercados",
				"198034");
		pessoas.add(pessoa);
		pessoas.add(pessoa1);
		Boleto boleto1 = new Boleto("12345678912345678912", 200, false);
		Boleto boleto2 = new Boleto("12345678941345578911", 150, false);
		Boleto boleto3 = new Boleto("12345524541412312366", 400, true, 100);
		Boleto boleto4 = new Boleto("13412312366234123125", 184, true, 140);

		boletos.add(boleto1);
		boletos.add(boleto2);
		boletos.add(boleto3);
		boletos.add(boleto4);

	}

	private static void mostarMenuPrincipal() {
		System.out.println();
		System.out.print("--------- MENU PRINCIPAL ---------");
		System.out.print("\nSelecione uma das opções");
		System.out.print("\n1- Cadastrar novo cliente: ");
		System.out.print("\n2- Listar clientes: ");
		System.out.print("\n3- Login de usuário: ");
		System.out.print("\n4- Sair");
	}

	private static void registarCliente() {
		System.out.println();
		System.out.println("--------- REGISTRAR CLIENTE -------");
		System.out.println("\nInforme o CPF/CNPJ: ");
		String documento = sc.next();
		if (documento.length() == 11) {
			cadastrarPessoaFisica(documento);
		} else if (documento.length() == 14) {
			cadastrarPessoaJuridica(documento);
		} else {
			System.out.print("Numero de documento invalido");
		}

	}

	private static void cadastrarPessoaJuridica(String cnpj) {
		System.out.println();
		System.out.print("--------- CADASTRAR PESSOA JURIDICA ---------");
		System.out.print("\nInforme os dados abaixo: ");
		System.out.print("\nRazão social: ");
		String razaoSocial = sc.next();
		System.out.print("\nNome fantasia: ");
		String nomeFantasia = sc.next();
		System.out.print("Email para contato: ");
		String email = sc.next();
		System.out.print("telefone: ");
		String telefone = sc.next();
		Endereco endereco = criarNovoEndereco();
		Conta conta = criarNovaConta();
		Pessoa pessoaJuridica = new PessoaJuridica(endereco, email, telefone, conta, razaoSocial, nomeFantasia, cnpj);
		pessoas.add(pessoaJuridica);
		System.out.println(pessoas);
	}

	private static void cadastrarPessoaFisica(String cpf) {
		System.out.println();
		System.out.print("--------- CADASTRAR PESSOA FISICA ---------");
		System.out.print("\nInforme os dados abaixo: ");
		System.out.print("\nNome: ");
		String nome = sc.next();
		System.out.print("\nRG: ");
		String rg = sc.next();
		System.out.print("\nData de nascimento: exemplo 29/12/2020");
		Date dataNascimento = parseDate(sc.next());
		System.out.print("\nEmail : ");
		String email = sc.next();
		System.out.print("\nNumero de Telefone : ");
		String telefone = sc.next();
		Endereco endereco = criarNovoEndereco();
		Conta conta = criarNovaConta();
		Pessoa pessoaFisica = new PessoaFisica(endereco, email, telefone, conta, nome, dataNascimento, cpf, rg);
		pessoas.add(pessoaFisica);
		System.out.print(pessoas);
	}

	private static Endereco criarNovoEndereco() {
		System.out.print("Informe os dados abaixo: ");
		System.out.print("\nCep: ");
		int cep = sc.nextInt();
		System.out.print("\nRua: ");
		String rua = sc.next();
		System.out.print("\nBairro: ");
		String bairro = sc.next();
		System.out.print("\nCidade: ");
		String cidade = sc.next();
		System.out.print("\nEstado: ");
		String estado = sc.next();
		System.out.print("\nNumero : ");
		String numero = sc.next();
		System.out.print("\nPossui complemento? s ou n");
		String resposta = sc.next();

		if (resposta.equals("s")) {
			System.out.println("Complemento: ");
			String complemento = sc.next();
			return new Endereco(cep, rua, bairro, cidade, estado, numero, complemento);

		} else {
			return new Endereco(cep, rua, bairro, cidade, estado, numero);
		}
	}

	private static Conta criarNovaConta() {
		System.out.print("Informe os dados abaixo: ");
		System.out.print("\nAgencia: ");
		int agencia = sc.nextInt();
		System.out.print("\nConta: ");
		int conta = sc.nextInt();
		System.out.print("\nDigito: ");
		int digito = sc.nextInt();
		System.out.print("\nSenha: ");
		int senha = sc.nextInt();
		System.out.print("\nSaldo: ");
		double saldo = sc.nextDouble();
		return new Conta(agencia, conta, digito, senha, saldo);
	}

	private static Date parseDate(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formato.parse(data);
		} catch (ParseException e) {
			return new Date();
		}

	}
}
