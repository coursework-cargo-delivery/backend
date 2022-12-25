package ru.smart_transportation.dto.response.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationIntersectionResponse implements Serializable {
    private Integer id;
    private Integer stationId;
}
