package ru.teapot.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @Column
    @NotEmpty(message = "Surname should not be empty")
    private String surname;
    @Column
    @NotEmpty(message = "Date should not be empty")
    private String dateOfBirth;
    @Column
    @NotEmpty(message = "Passport should not be empty")
    private String passportData;
    @Column
    @NotEmpty(message = "Address should not be empty")
    private String address;
    @Column
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @Column
    @NotEmpty(message = "Password should not be empty")
    //@Email(message = "Email should be valid")
    private String password;

  //  private Set <Contract> contracts;
}
