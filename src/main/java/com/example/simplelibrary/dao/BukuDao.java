package com.example.simplelibrary.dao;

import com.example.simplelibrary.models.Buku;
import com.example.simplelibrary.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class BukuDao implements BukuService {
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Buku> listBuku() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Buku", Buku.class).getResultList();
    }

    @Override
    public Buku store(Buku buku) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Buku dataBuku = em.merge(buku);
        em.getTransaction().commit();
        return dataBuku;
    }

    @Override
    public Buku getBuku(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Buku.class,id);
    }

    @Override
    public void deleteBuku(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Buku.class,id));
        em.getTransaction().commit();
    }
}
