package dev.sudhamsh.runners.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/run")
public class RunController {
    private RunRepository repo;
    RunController(RunRepository repo){
        this.repo = repo;
    }
    @RequestMapping("")
    List<Run> getRunner(){
        return repo.findAll();
    }
    @RequestMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = repo.findById(id);

        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }
   //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run,@PathVariable Integer id){
        repo.update(run,id);
    }
    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        repo.delete(id);
    }
//
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/create")
    void create(@RequestBody Run run){
        repo.create(run);
    }
    @RequestMapping("/hello")
    String home(){
        return "Hello Runner";
    }
}
