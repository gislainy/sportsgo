package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.anuncio.Anuncio;
import br.com.sportsgo.model.dao.interfaces.IAnuncioDAO;

@Repository
public class AnuncioDAO implements IAnuncioDAO{

    private final GenericDAO<Anuncio,Long> dao;
    
    @Autowired
    public AnuncioDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Anuncio,Long>(factory, Anuncio.class);
    }
	
    @Transactional
	public void adiciona(Anuncio t) {
		dao.adiciona(t);
	}

    @Transactional
	public void remove(Anuncio t) {
		dao.remove(t);	
	}

    @Transactional
	public Anuncio busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<Anuncio> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(Anuncio t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}

}
