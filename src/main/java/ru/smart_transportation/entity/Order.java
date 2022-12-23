package ru.smart_transportation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "station1", nullable = false)
    private Station station1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "station2", nullable = false)
    private Station station2;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cargo_type", nullable = false)
    private CargoType cargoType;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "comment", length = Integer.MAX_VALUE)
    private String comment;

    @OneToMany(mappedBy = "order")
    private Set<Payment> payments = new LinkedHashSet<>();

}