package entidade;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COLABORADOR")
public class Colaborador {
	
	@Id
	@Column(name="CPF", nullable=false)
	private String cpf;	
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	private ArrayList<OpcaoCafe> opcaos;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<OpcaoCafe> getOpcaos() {
		return opcaos;
	}

	public void setOpcaos(ArrayList<OpcaoCafe> opcaos) {
		this.opcaos = opcaos;
	}	

}
