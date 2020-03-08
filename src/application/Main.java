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
		int opcao = 0;
		mostarMenuPrincipal();
		opcao = sc.nextInt();

		while (opcao != 2) {
			switch (opcao) {
			case 1:
				registarCliente();
			case 2:
				System.out.println("Obrigado por utilizar o sistema !!!");
			default:
				System.out.println("Por favor informar uma opção valida !");
			}
		}

	}

	private static void mostarMenuPrincipal() {
		System.out.println();
		System.out.println("--------- MENU PRINCIPAL ---------");
		System.out.println("\nSelecione uma das opções");
		System.out.println("\n1- Cadastrar novo cliente:");
	}

	private static void registarCliente() {
		System.out.println();
		System.out.println("--------- REGISTRAR CLIENTE -------");
		System.out.println("\nInforme o CPF/CNPJ: ");
		String documento = sc.next();
		if (documento.length() == 11) {
			cadastrarPessoaFisica(documento);
		} 
		else if(documento.length() == 14) { 
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
