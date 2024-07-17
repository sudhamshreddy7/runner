
package dev.sudhamsh.runners.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class RunJsonLoader implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(RunJsonLoader.class);
    private static RunRepository repo ;
    private static ObjectMapper objectMapper;
    public RunJsonLoader(RunRepository repo,ObjectMapper objectMapper){
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            try (InputStream input = TypeReference.class.getResourceAsStream("/data/data.json")) {
                Runs allRuns = objectMapper.readValue(input, Runs.class);
                log.info("Loading data info DB number of Records : " + allRuns.runs().size());
                repo.saveAll(allRuns.runs());
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        } else {
            log.info("Not loading any data");
        }
    }
}
