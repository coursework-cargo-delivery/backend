package ru.smart_transportation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String roleName;
}
