package dao;

import java.util.List;

import entidade.Colaborador;

public interface ColaboradorDAO {
	
	public boolean inserirColaborador(Colaborador colaborador);
	
	public Colaborador pesquisarColaborador(String cpf);
	
	public List<Colaborador> pesquisarColaborador(Colaborador colaborador);
	
	public List<Colaborador> listarColaboradores();

}
