package dao;

import entidade.OpcaoCafe;

public interface OpcaoCafeDAO {
	
	public boolean adicionarOpcaoCafeColaborador(OpcaoCafe opcaocafe);
	
	public OpcaoCafe pesquisarOpcaoCafe(String opcafe);
	
	public boolean removerOpcaoCafeColaborador(OpcaoCafe opcaocafe);

}
