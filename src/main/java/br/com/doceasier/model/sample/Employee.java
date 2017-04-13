package br.com.doceasier.model.sample;

@SuppressWarnings("unused")
public class Employee {
	
	private Integer codigo;
	private String nome;
	private String cpf;
	private Erro erro = new Erro();
	char teste;
	int idade;
	
	
	@Override
	public String toString() {
		return "Employee [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf
				+ ", teste=" + teste + ", idade=" + idade + "]";
	}
	
	
}
