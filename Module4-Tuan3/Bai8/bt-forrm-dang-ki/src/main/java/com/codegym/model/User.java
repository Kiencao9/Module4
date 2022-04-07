package com.codegym.model;

import javax.validation.constraints.*;

public class User {
    @NotEmpty
    @Size(min = 5, max = 45, message = "tối thiểu 5 kí tự tối đa 45 kí tự")
    private String firstname;

    @NotEmpty
    @Size(min = 5, max = 45, message = "tối thiểu 5 kí tự tối đa 45 kí tự")
    private String lastname;

    @Pattern(regexp = "0[0-9]{9,10}", message = "số điện thoại phải từ 10 đến 11 số")
    private String phoneNumber;

    @Min(value = 18, message = "tối thiểu 18 tuổi")
    private int age;

    @Email(message = "email sai định dạng")
    private String email;


    public User() {
    }

    public User(String firstname, String lastname, String phoneNumber, int age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
