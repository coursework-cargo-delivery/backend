package ru.smart_transportation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "card_number", nullable = false, length = Integer.MAX_VALUE)
    private String cardNumber;

    @Column(name = "exp_date", nullable = false)
    private LocalDate expDate;

    @Column(name = "cvv", nullable = false, length = 6)
    private String cvv;

}