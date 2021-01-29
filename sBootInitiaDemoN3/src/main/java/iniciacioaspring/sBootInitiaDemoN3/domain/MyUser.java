package iniciacioaspring.sBootInitiaDemoN3.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyUser {

  private @Id @GeneratedValue Long id;
  private String name;
  private String dateOfBirth;

  MyUser() {}

  public MyUser(String name, String dateOfBirth) {

    this.name = name;
    this.dateOfBirth = dateOfBirth;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof MyUser))
      return false;
    MyUser user = (MyUser) o;
    return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name)
        && Objects.equals(this.dateOfBirth, user.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.dateOfBirth);
  }

  @Override
  public String toString() {
    return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", date of birth='" + this.dateOfBirth + '\'' + '}';
  }
}