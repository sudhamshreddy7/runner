package dev.sudhamsh.runners.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runners = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(RunRepository.class);
    private JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
   public List<Run> findAll(){
        return jdbcClient.sql("select * from run").query(Run.class).list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("select * from run where id= :id").param("id",id).query(Run.class).optional();
    }

    public void update(Run run, Integer id) {
        var update = jdbcClient.sql("update run set distance= ?, duration= ?, location= ?, data_d= ? where id= ?")
                .params(List.of(run.distance(),run.duration(),run.location().toString(),run.data_d(),id))
                .update();
        Assert.state(update==1,"Failed to update runner with id "+id);
    };

    public void delete(Integer id) {
        var update = jdbcClient.sql("delete from run where id= :id").param("id",id).update();
        Assert.state(update==1,"Failed to update runner with id "+id);
    }
    public int count(){
        return findAll().size();
    }
    public void create(Run run) {
        var update = jdbcClient.sql("Insert into run(id,distance,duration,location,data_d) values(?,?,?,?,?)")
                .params(List.of(run.id(),run.distance(),run.duration(),run.location().toString(),run.data_d()))
                .update();
        Assert.state(update==1,"Failed to update runner with id "+run.id());
    }

    public void saveAll(List<Run> allRuns) {
        for(Run r:allRuns){
            create(r);
        }
    }
}