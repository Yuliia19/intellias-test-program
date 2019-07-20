package project.service;

import com.google.common.collect.ImmutableSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class BusDirectionService {

    private final FileReaderService fileReaderService;

    public boolean checkBusDirection(int departureStationId, int arrivalStationId) {
        if (departureStationId == arrivalStationId) {
            return false;
        }

        ImmutableSet<Integer> stations = ImmutableSet.of(departureStationId, arrivalStationId);
        return fileReaderService.getBusRouts().values().stream().anyMatch(e -> e.containsAll(stations));
    }
}
