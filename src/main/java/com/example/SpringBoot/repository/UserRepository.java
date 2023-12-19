package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {

    @PersistenceContext
    private final EntityManager em;


    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public List<User> list() {
        return em.createQuery("from User", User.class).getResultList();
    }

    public User find(int id) {
        return em.find(User.class,id);
    }

    public void save(User user) {
        em.persist(user);
        em.flush();
    }

    public void update(User user) {
        em.merge(user);
        em.flush();
    }

    public void delete(int id) {
        User user = find(id);
        em.remove(user);
        em.flush();
    }
}
