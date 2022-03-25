package ru.kpfu.itis.db.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.db.entities.simple.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCRepository {
    private DataSource dataSource;

    @Autowired
    public JDBCRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Book> findAll() throws DBException {
        List<Book> results = new ArrayList<>();
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement st = con.prepareStatement("SELECT * FROM books")
        ) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getLong("id"),
                        rs.getString("name")
                );
                results.add(book);
            }
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
        return results;
    }
}
