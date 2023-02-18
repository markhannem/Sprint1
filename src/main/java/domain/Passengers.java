package domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Passengers{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String passportNumber;
    private String email;
    private String phoneNumber;

    public Passengers(long id, String name, String surname, String passportNumber, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Passengers() {
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
