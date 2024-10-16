package com.rafaelnarnajo.msone.infrastructure.out.db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMPANY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String location;
}
