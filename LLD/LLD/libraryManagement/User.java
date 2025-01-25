package LLD.librarymanagement;

public class User {
  private String name;
  private String email;
  private String phone;
  private String address;

  public User(String name, String email, String phone, String address) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String  getAddress() {
    return address;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}