package ru.kpfu.itis.models;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import ru.kpfu.itis.validation.isbn.ISBN;

public class Book{

  private Integer id;

  @NotNull
  @ISBN
  private String isbn;

  @NotNull
  @Size(min = 1, max = 255)
  private String name;

  @NotNull
  @Range(min = 0L, max = 9999L)
  private Integer pages;

  public Book(){}
  public Book(String isbn, String name, int pages) {
    this.isbn = isbn;
    this.name = name;
    this.pages = pages;
  }

  public Book(Integer id, String isbn, String name, int pages) {
    this.id = id;
    this.isbn = isbn;
    this.name = name;
    this.pages = pages;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (id != null ? !id.equals(book.id) : book.id != null) return false;
    if (!isbn.equals(book.isbn)) return false;
    if (!name.equals(book.name)) return false;
    return pages.equals(book.pages);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + isbn.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + pages.hashCode();
    return result;
  }
}
