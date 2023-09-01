package com.microservice.gpstracker.Owner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "owner_info")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerModel {

    //    use this for association
    @Id
    @SequenceGenerator(name="seq_generator", sequenceName = "owner_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "owner_seq_generator")
    private Long ownerId;

    @Column(name = "licence_number")
    private String licence_number;

    @Column(name = "owner_name")
    private String owner_name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

}
