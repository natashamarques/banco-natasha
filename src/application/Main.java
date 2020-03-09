package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

import entities.Conta;
import entities.Endereco;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {
	static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
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
			}
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
		PessoaFisica pessoa = new PessoaFisica(endereco, "thiago@.com", "119123456", conta, "Thiago", new Date(),
				"498", "1616");
		PessoaJuridica pessoa1 = new PessoaJuridica(endereco1, "nata@hot", "1198000", conta1, "nenhuma", "Mercados",
				"198034");
		pessoas.add(pessoa);
		pessoas.add(pessoa1);

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
