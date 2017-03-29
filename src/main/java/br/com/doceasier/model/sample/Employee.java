package br.com.doceasier.model.sample;

public class Employee {
	
	private Integer codigo;
	private String nome;
	private String cpf;
	private Erro erro;
	char teste;
	int idade;
	
	
	@Override
	public String toString() {
		return "Employee [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf
				+ ", teste=" + teste + ", idade=" + idade + "]";
	}
	
	
}
