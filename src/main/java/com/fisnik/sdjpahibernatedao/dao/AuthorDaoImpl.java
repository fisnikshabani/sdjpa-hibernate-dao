package com.fisnik.sdjpahibernatedao.dao;

import com.fisnik.sdjpahibernatedao.domain.Author;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Component
public class AuthorDaoImpl implements AuthorDao{

    private final EntityManagerFactory emf;

    public AuthorDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Author getById(Long id) {
        return getEntityManager().find(Author.class, id);
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {

        TypedQuery<Author> query = getEntityManager().createQuery("SELECT a FROM Author a " +
                "WHERE a.firstName = :first_name and a.lastName = :last_name", Author.class);
        query.setParameter("first_name", firstName);
        query.setParameter("last_name", lastName);

        return query.getSingleResult();
    }

    @Override
    public Author saveNewAuthor(Author author) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.flush();
        em.getTransaction().commit();

        return author;
    }

    @Override
    public Author updateAuthor(Author author) {

        EntityManager em = getEntityManager();
        em.joinTransaction();
        em.merge(author); //take existing entity and update it
        em.flush(); // execute sql transaction against DB
        em.clear();
        return em.find(Author.class, author.getId());
    }

    @Override
    public void deleteAuthorById(Long id) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class, id);
        em.remove(author);
        em.flush();
        em.getTransaction().commit();
    }

    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}