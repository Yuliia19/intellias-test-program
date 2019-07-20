package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.dto.ResponseScreenDto;
import project.service.BusDirectionService;

@RestController
@RequestMapping("api/direct")
public class BusDirectionController {
    @Autowired
    private BusDirectionService busDirectionService;

    @GetMapping()
    public ResponseScreenDto checkDirection(@RequestParam("dep_sid") int departureStationId,
                                            @RequestParam("arr_sid") int arrivalStationId) {
        boolean result = busDirectionService.checkBusDirection(departureStationId, arrivalStationId);
        return ResponseScreenDto.builder().departureStationId(departureStationId).arrivalStationId(arrivalStationId)
        .directBusRoute(result).build();
    }
}
