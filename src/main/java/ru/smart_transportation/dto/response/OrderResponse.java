package ru.smart_transportation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse implements Serializable {
    private Integer id;
    private Integer station1;
    private Integer station2;
    private String status;
    private Float weight;
    private String comment;
}
