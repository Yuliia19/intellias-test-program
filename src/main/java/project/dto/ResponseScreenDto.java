package project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseScreenDto {

    @JsonProperty(value = "dep_sid", required = true)
    int departureStationId;

    @JsonProperty(value = "arr_sid", required = true)
    int arrivalStationId;

    @JsonProperty(value = "direct_bus_route", required = true)
    boolean directBusRoute;
}
