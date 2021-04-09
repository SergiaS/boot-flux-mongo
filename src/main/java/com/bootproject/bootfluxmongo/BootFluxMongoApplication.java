package com.bootproject.bootfluxmongo;

import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.model.NodeRoot;
import com.bootproject.bootfluxmongo.repository.NodeDescRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class BootFluxMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootFluxMongoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initConfig(NodeDescRepository repo) {
        return (p) -> {
            repo.deleteAll().block();
            repo.save(new NodeDesc("Bob", "IT")).block();
            repo.save(new NodeRoot("IT")).block();
            repo.save(new NodeDesc("Matt", "Sales")).block();
            repo.save(new NodeDesc("Elis", "HR")).block();
            repo.save(new NodeDesc("Ted", "Security")).block();
            repo.save(new NodeRoot("Sales")).block();
            repo.save(new NodeDesc("Jenny", "Admin")).block();
            repo.save(new NodeDesc("Nora", "IT")).block();
        };
    }
}
