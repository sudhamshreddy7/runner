package dev.sudhamsh.runners.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class RunJsonLoader implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(RunJsonLoader.class);
    private static RunRepository repo;
    public RunJsonLoader(RunRepository repo){
        this.repo = repo;
    }
    @Override
    public void run(String... args) throws Exception {
        if(repo.count()==0){
            
        }
    }
}
