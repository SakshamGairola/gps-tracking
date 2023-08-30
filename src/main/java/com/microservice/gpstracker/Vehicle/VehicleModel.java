package com.microservice.gpstracker.Vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservice.gpstracker.Owner.OwnerModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Table(name = "vehicle_info")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModel {

    @Id
    @SequenceGenerator(name="vehicle_seq_generator", sequenceName = "vehicle_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "vehicle_seq_generator")
    private Long vehicleId;

    @Column(name = "registration_number")
    private String registration_number;

    @Column(name = "bike_model")
    private String bike_model;

    @Column(name = "ins_exp_date")
    private String ins_exp_date;

    @Column(name = "purchase_date")
    private String purchase_date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OwnerModel ownerModel;

}
