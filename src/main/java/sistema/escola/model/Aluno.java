package sistema.escola.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	private String nome;
	private Integer total_Aulas;

	private Nota notaEFalta;

	public Aluno(Integer cod, String nome, Integer total_Aulas, Nota notaEFalta) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.total_Aulas = total_Aulas;
		this.notaEFalta = notaEFalta;
	}

	public Aluno() {

	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTotal_Aulas() {
		return total_Aulas;
	}


	public Nota getNotaEFalta() {
		return notaEFalta;
	}

	public void setNotaEFalta(Nota notaEFalta) {
		this.notaEFalta = notaEFalta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cod, other.cod);
	}

}
