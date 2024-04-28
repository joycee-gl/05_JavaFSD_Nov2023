package com.greatlearning.ssrs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "course")
  private String course;

  @Column(name = "country")
  private String country;

  public Student() {

  }

  public Student(String firstName, String lastName, String course, String country) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.course = course;
    this.country = country;
  }
}  