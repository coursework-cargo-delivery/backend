package ru.smart_transportation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse implements Serializable {
    private Integer id;
    private Integer station1;
    private Integer station2;
    private Date creationDate;
    private String status;
    private String cargoType;
    private Float weight;
    private String comment;
    private Float price;
}
