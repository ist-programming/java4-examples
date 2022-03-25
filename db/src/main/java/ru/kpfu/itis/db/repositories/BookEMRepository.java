package ru.kpfu.itis.db.repositories;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.db.entities.jpa.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
@Component
public class BookEMRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Book> findAll(){
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public List<Book> findAllFilled(){
        return em.createQuery("SELECT b FROM Book b LEFT JOIN FETCH b.publishingHouse p", Book.class).getResultList();
    }
}
