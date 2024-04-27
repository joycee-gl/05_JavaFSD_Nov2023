package com.greatlearning.slma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "AUTHOR")
  private String author;

  @Column(name = "CATEGORY")
  private String category;

  public Book() {
  }

  public Book(String name, String category, String author) {
    this.name = name;
    this.category = category;
    this.author = author;
  }
}          