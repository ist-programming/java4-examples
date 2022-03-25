package ru.kpfu.itis.db.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.db.entities.jpa.Book;

import java.util.List;

public interface BookSpringDataJPARepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findByName(String name);
    int countByPages(int page);

    @Query("SELECT b FROM Book b WHERE b.year > :start")
    Book findFirstBookAfter(@Param("start") int year);
}
