package ru.kpfu.itis.db;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.db.repositories.BookEMRepository;
import ru.kpfu.itis.db.repositories.BookSpringDataJPARepository;
import ru.kpfu.itis.db.repositories.JDBCTemplateRepository;

public class App{
    private static final String SEPARATOR = "--------------";
    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            context.getEnvironment().addActiveProfile("jdbc");
            JDBCTemplateRepository jdbcRepository = context.getBean(JDBCTemplateRepository.class);

            //JDBC Template
            System.out.println(SEPARATOR);
            System.out.println("JDBC");
            System.out.println(SEPARATOR);
            jdbcRepository.findAll().stream().forEach(System.out::println);
            System.out.println(SEPARATOR);
            jdbcRepository.findAllSimpleRowMapper().stream().forEach(System.out::println);
            System.out.println(SEPARATOR);
            jdbcRepository.findAllAdvanced().stream().forEach(System.out::println);
            System.out.println(SEPARATOR);

            // Entity Manager
            System.out.println(SEPARATOR);
            System.out.println("Entity Manager");
            BookEMRepository bookEMRepository = context.getBean(BookEMRepository.class);
            bookEMRepository.findAll().forEach(System.out::println);
            System.out.println(SEPARATOR);
            bookEMRepository.findAllFilled().forEach(System.out::println);
            System.out.println(SEPARATOR);

            // Spring Data JPA
            System.out.println(SEPARATOR);
            System.out.println("Spring Data JPA");
            BookSpringDataJPARepository bookSpringDataJPARepository = context.getBean(BookSpringDataJPARepository.class);
            bookSpringDataJPARepository.findAll().forEach(System.out::println);
            System.out.println(SEPARATOR);
            bookSpringDataJPARepository.findByName("Some book name").forEach(System.out::println);
            System.out.println(SEPARATOR);
            System.out.println(bookSpringDataJPARepository.countByPages(3421));
            System.out.println(SEPARATOR);
            System.out.println(bookSpringDataJPARepository.findFirstBookAfter(2004));
            System.out.println(SEPARATOR);

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
