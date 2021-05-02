package dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Colaborador;
import util.JpaUtil;

public class ColaboradorDAOImplementacao implements ColaboradorDAO {

	//INSERIR COLABORADOR
	public boolean inserirColaborador(Colaborador colaborador) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(colaborador);

		tx.commit();
		ent.close();

		return true;
	}

	//PESQUISAR COLABORADOR
	public Colaborador pesquisarColaborador(String cpf) {
		
		String sql = "from Colaborador c where c.cpf = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, cpf);

		List<Colaborador> lista = query.getResultList();

		ent.close();
		
		if(lista != null && lista.size() > 0) {
			return lista.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<Colaborador> pesquisarColaborador(Colaborador colaborador) {
		// TODO Auto-generated method stub
		return null;
	}

	//LISTAR COLABORADORES
	public List<Colaborador> listarColaboradores() {
		
		String sql = "from Colaborador c";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Colaborador> listacolaborador = query.getResultList();

		ent.close();

		return listacolaborador;
	}
	
	

}
