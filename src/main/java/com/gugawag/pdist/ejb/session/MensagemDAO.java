package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName="default")
    private EntityManager manager;

    public void inserir(Mensagem mensagem) {
        manager.persist(mensagem);
    }

    public List<Mensagem> listar() {
        return manager.createQuery("FROM Mensagem").getResultList();
    }

    public Mensagem pesquisarPorId(long id) {
        return manager.find(Mensagem.class, id);
    }
}
