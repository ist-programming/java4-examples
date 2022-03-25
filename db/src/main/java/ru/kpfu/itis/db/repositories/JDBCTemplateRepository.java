package ru.kpfu.itis.db.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.db.entities.simple.Book;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JDBCTemplateRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCTemplateRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //The Simplest
    public List<Book> findAll() throws DBException {
        return jdbcTemplate.query("SELECT * FROM books", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getLong("id"),
                        rs.getString("name")
                );
            }
        });
    }

    public List<Book> findAllSimpleRowMapper() throws DBException {
        return jdbcTemplate.query("SELECT * from books", new SimpleRowMapper<Book>(Book.class));
    }

    public List<Long> findAllAdvanced() throws DBException {
        return jdbcTemplate.queryForList("SELECT id from books", Long.class);
    }

    //Simple universal RowMapper
    private static class SimpleRowMapper<T> implements RowMapper<T> {
        private final Class<? extends T> clazz;

        public SimpleRowMapper(Class<? extends T> clazz) {
            this.clazz = clazz;
        }

        @Override
        public T mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Field[] fields = clazz.getDeclaredFields();
                T instance = clazz.getConstructor().newInstance();
                for (Field field : fields) {
                    if (field.getGenericType().equals(String.class)) {
                        Method setter = clazz.getMethod("set" + capitalize(field.getName()), String.class);
                        setter.invoke(instance, rs.getString(field.getName()));
                    } else if (field.getGenericType().equals(Long.class)) {
                        Method setter = clazz.getMethod("set" + capitalize(field.getName()), Long.class);
                        setter.invoke(instance, rs.getLong(field.getName()));
                    } else {
                        throw new SQLException("Unknown field type: " + field.getGenericType().getTypeName());
                    }
                }
                return instance;
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                throw new SQLException(ex);
            }
        }

        private String capitalize(String str) {
            String newStr = str.substring(0, 1).toUpperCase();
            if (str.length() > 1) {
                newStr += str.substring(1);
            }
            return newStr;
        }
    }
}
