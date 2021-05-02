package dao;

import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.OpcaoCafe;
import util.JpaUtil;

public class OpcaoCafeDAOImplementacao implements OpcaoCafeDAO{

	@Override
	public boolean adicionarOpcaoCafeColaborador(OpcaoCafe opcaocafe) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(opcaocafe);

		tx.commit();
		ent.close();

		return true;
	}

	@Override
	public OpcaoCafe pesquisarOpcaoCafe(String opcafe) {
		
		String sql = "from OpcaoCafe o where o.opcafe = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, opcafe);

		List<OpcaoCafe> lista = query.getResultList();

		ent.close();
		
		if(lista != null && lista.size() > 0) {
			return lista.get(0);
		}else {
			return null;
		}
	}

	@Override
	public boolean removerOpcaoCafeColaborador(OpcaoCafe opcaocafe) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		OpcaoCafe existe = ent.find(OpcaoCafe.class, opcaocafe.getOpcafe());

		tx.begin();

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