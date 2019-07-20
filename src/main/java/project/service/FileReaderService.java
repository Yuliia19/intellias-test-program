package project.service;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.io.Files.readLines;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;
import static org.apache.commons.io.Charsets.toCharset;

@Slf4j
public class FileReaderService {
    private static final String SPACE = " ";
    private static final int BUS_ROUT_ID = 0;

    private final String fileLocation;

    public FileReaderService(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    Map<Integer, List<Integer>> getBusRouts() {
        List<String> fileContent = readFileContent();

        if (fileContent.isEmpty()) {
            log.info("File is empty");
            return emptyMap();
        }

        fileContent.remove(0);

        return collectBusRouts(fileContent);
    }

    private List<String> readFileContent() {
        try {
            File file = new File(fileLocation);
            return readLines(file, toCharset("UTF-8"));
        } catch (IOException exception) {
            log.error("Cannot read file {}", exception.getMessage());
            return emptyList();
        }
    }

    private Map<Integer, List<Integer>> collectBusRouts(List<String> fileContent) {
        Map<Integer, List<Integer>> busRouts = new HashMap<>();

        fileContent.forEach(row -> {
            String[] stations = row.split(SPACE);
            List<Integer> stationList = of(stations).mapToInt(Integer::valueOf).boxed().collect(toList());
            Integer busRoutId = stationList.get(BUS_ROUT_ID);
            stationList.remove(BUS_ROUT_ID);
            busRouts.put(busRoutId, stationList);
        });
        return busRouts;
    }
}
