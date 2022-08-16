package com.contactbook.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContact;

    @Column(nullable = false, length = 300)
    private String nameContact;

    @Column(nullable = false, length = 300)
    private String emailContact;

    @Column(nullable = false, length = 300)
    private Boolean favoriteContact;



}
