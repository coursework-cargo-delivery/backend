package ru.smart_transportation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smart_transportation.dto.response.map.MapResponse;
import ru.smart_transportation.dto.response.map.StationIntersectionResponse;
import ru.smart_transportation.entity.Station;
import ru.smart_transportation.entity.StationIntersection;
import ru.smart_transportation.entity.TrainLine;
import ru.smart_transportation.repo.StationIntersectionRepository;
import ru.smart_transportation.repo.StationRepository;
import ru.smart_transportation.repo.TrainLineRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    StationIntersectionRepository stationIntersectionRepository;

    @Autowired
    TrainLineRepository trainLineRepository;

    public MapResponse getMap() {
        final var response = new MapResponse();
        response.setStations(getStations());
        response.setTrainLines(getTrainLines());
        response.setIntersections(getIntersections());

        return response;
    }

    public List<Station> getStations(){
        return stationRepository.findAll();
    }

    public List<TrainLine> getTrainLines(){
        return trainLineRepository.findAll();
    }

    public List<StationIntersectionResponse> getIntersections(){
        final var dbIntersections =  stationIntersectionRepository.findAll();

        return dbIntersections.stream()
                .map(this::convertIntersectionToIntersectionResponse)
                .collect(Collectors.toList());
    }

    private StationIntersectionResponse convertIntersectionToIntersectionResponse(StationIntersection intersection){
        final var response = new StationIntersectionResponse();
        response.setId(intersection.getNodeId());
        response.setStationId(intersection.getStation().getId());

        return response;
    }
}
