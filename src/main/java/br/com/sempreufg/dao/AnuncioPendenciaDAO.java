package br.com.sempreufg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sempreufg.dao.interfaces.IAnuncioPendenciaDAO;
import br.com.sempreufg.model.anuncio.AnuncioPendencia;

@Repository
public class AnuncioPendenciaDAO implements IAnuncioPendenciaDAO{
	private final GenericDAO<AnuncioPendencia,Long> dao;
    
    @Autowired
    public AnuncioPendenciaDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioPendencia,Long>(factory, AnuncioPendencia.class);
    }
	
    @Transactional
	public Long adiciona(AnuncioPendencia t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioPendencia t) {
		dao.remove(t);	
	}

    @Transactional
	public AnuncioPendencia busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<AnuncioPendencia> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioPendencia t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}
}
