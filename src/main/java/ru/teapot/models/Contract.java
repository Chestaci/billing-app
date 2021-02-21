package ru.teapot.models;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String number;
    @Column
    private String tariff;
}
