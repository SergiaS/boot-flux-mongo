package com.bootproject.bootfluxmongo;

import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.model.NodeRoot;
import com.bootproject.bootfluxmongo.repository.NodeDescRepositoryImpl;
import com.bootproject.bootfluxmongo.repository.NodeRootRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BootFluxMongoApplication implements CommandLineRunner {

    @Autowired
    private NodeRootRepositoryImpl nodeRootRepository;

    @Autowired
    private NodeDescRepositoryImpl nodeDescRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootFluxMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<NodeRoot> nodeRootList = List.of(
//                new NodeRoot("Zoy"),
                new NodeRoot("Bob"),
                new NodeRoot("Matt"),
                new NodeRoot("Elis"),
                new NodeRoot("Ted"),
                new NodeRoot("Jenny"),
                new NodeRoot("Nora")
        );
        List<NodeDesc> nodeDescList = List.of(
//                new NodeDesc("Zoy", "28, Female, HR"),
                new NodeDesc("Bob", "34, Male, IT"),
                new NodeDesc("Matt","27, Male, Sales"),
                new NodeDesc("Elis", "25, Female, IT"),
                new NodeDesc("Ted", "38, Male, Admin"),
                new NodeDesc("Jenny", "23, Female, IT"),
                new NodeDesc("Nora", "30, Female, Sales")
        );

        for (int i = 0; i < nodeDescList.size(); i++) {
            nodeDescRepository.add(nodeDescList.get(i));
            nodeRootRepository.add(nodeRootList.get(i));
        }
    }
}
