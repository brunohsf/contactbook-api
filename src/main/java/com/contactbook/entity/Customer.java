package com.contactbook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;

    @Column(name = "name_customer", nullable = false, length = 300)
    private String nameCustomer;

    @Column(name = "cpf_customer", nullable = false, length = 300, unique = true)
    private String cpfCustomer;

    @Column(name = "date_created_customer", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreatedCustomer;

    @PrePersist
    public void prePersist() {
        setDateCreatedCustomer(LocalDate.now());
    }
}