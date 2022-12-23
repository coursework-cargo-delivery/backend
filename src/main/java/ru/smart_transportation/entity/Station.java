package ru.smart_transportation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "station")
public class Station {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "x", nullable = false)
    private Float x;

    @Column(name = "y", nullable = false)
    private Float y;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "\"order\"", nullable = false)
    private Integer order;

}