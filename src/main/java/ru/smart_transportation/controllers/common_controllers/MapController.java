package ru.smart_transportation.controllers.common_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smart_transportation.dto.response.map.MapResponse;
import ru.smart_transportation.service.MapService;

@RestController
@CrossOrigin("*")
@RequestMapping("common/map")
public class MapController {

    @Autowired
    MapService mapService;

    @GetMapping
    ResponseEntity<MapResponse> getMap(){
        return ResponseEntity.ok(mapService.getMap());
    }
}
