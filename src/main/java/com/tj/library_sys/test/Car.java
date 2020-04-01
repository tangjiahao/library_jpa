package com.tj.library_sys.test;

public class Car {
  int id;
  String name;
  int score;
  String color;


  public Car(int id, String name, int score, String color) {
    this.id = id;
    this.name = name;
    this.score = score;
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Car{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", score=" + score +
            ", color='" + color + '\'' +
            '}';
  }
}
