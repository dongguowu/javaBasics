package xyz.dongguo.lesson.objectoriented;

import static xyz.dongguo.JsonHelper.generateRandomString;
import static xyz.dongguo.lesson.objectoriented.Person.LENGTH_ID;

import java.util.Random;

/**
 * @author dongguo
 */
public class Course {

  private final String id = generateRandomString(new Random(), LENGTH_ID);
  private String name;

  public Course(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

}