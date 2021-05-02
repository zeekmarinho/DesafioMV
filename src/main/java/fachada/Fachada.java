package fachada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.ColaboradorDAO;
import dao.ColaboradorDAOImplementacao;
import dao.OpcaoCafeDAO;
import dao.OpcaoCafeDAOImplementacao;
import entidade.Colaborador;
import entidade.OpcaoCafe;
import util.JpaUtil;

public class Fachada {
	
	private ColaboradorDAO colaboradorDAO;
	private OpcaoCafeDAO opcaocafeDAO;
	
	public Fachada() {
		
		this.colaboradorDAO = new ColaboradorDAOImplementacao();
		this.opcaocafeDAO = new OpcaoCafeDAOImplementacao();
		
	}
	
	//Inserir Colaborador	
	public boolean inserirColaborador(Colaborador colaborador) {

		Colaborador colaboradorExiste = this.colaboradorDAO.pesquisarColaborador(colaborador.getCpf());
			
		if(colaboradorExiste != null) {
			return false;
		}else {
			return this.colaboradorDAO.inserirColaborador(colaborador);
		}
	}
	
	//Pesquisar Colaborador
	public List<Colaborador> pesquisarColaborador(Colaborador colaborador) {
		String sql = "from Colaborador c where 1=1" + montarWhere(colaborador);
		return null;
	}
	
	//String montarWhere
	private String montarWhere(Colaborador colaborador) {
		String where = "1";

		if (colaborador.getCpf() != null && !colaborador.getNome().isEmpty()) {
			where += "and c.cpf = " + colaborador.getCpf() + "'";
		} else {
			if (colaborador.getNome() != null && !colaborador.getNome().isEmpty()) {
				where += "and c.nome like '%" + colaborador.getNome() + "%'";
			}			
		}
		return null;
	}
	
	//Adicionar Opcão de Café	
	public boolean adicionarOpcaoCafeColaborador(OpcaoCafe opcaocafe) {

		OpcaoCafe opcaocafeExiste = this.opcaocafeDAO.pesquisarOpcaoCafe(opcaocafe.getOpcafe());
				
		if(opcaocafeExiste != null) {
			return false;
		}else {
			return this.opcaocafeDAO.adicionarOpcaoCafeColaborador(opcaocafe);
		}
	}
	
	//Remover Opcão de Café
	public boolean removerContatoCliente(OpcaoCafe opcaocafe) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		OpcaoCafe existe = ent.find(OpcaoCafe.class, opcaocafe.getOpcafe());

		if (existe != null) {

			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}

}
