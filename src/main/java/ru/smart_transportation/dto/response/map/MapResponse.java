package ru.smart_transportation.dto.response.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.smart_transportation.entity.Station;
import ru.smart_transportation.entity.TrainLine;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapResponse {
    private List<Station> stations;
    private List<TrainLine> trainLines;
    private List<StationIntersectionResponse> intersections;
}
