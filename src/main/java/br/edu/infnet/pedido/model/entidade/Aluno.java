package br.edu.infnet.pedido.model.entidade;

public class Aluno {

	private Long matricula;

	private String nome;

	public Aluno() {
	}

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}

	public Aluno(String nome, Long matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public Long getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}

}
