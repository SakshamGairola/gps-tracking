package com.microservice.gpstracker.GpsData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservice.gpstracker.Vehicle.VehicleModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name = "gpsData_info")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GpsDataModel {

    @Id
    @SequenceGenerator(name="gpsData_seq_generator", sequenceName = "gpsData_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gpsData_seq_generator")
    private Long gpsDataId;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private VehicleModel vehicleModel;

}
