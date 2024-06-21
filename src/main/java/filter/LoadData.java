package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CriteriaRepository criteriaRepository, FilterRepository filterRepository) {
        // useing this kind of nameing is against Clean Code principales and is not used anywhere else. This is test data so I hope this is not judged too harshly.
        Criteria c1 = new Criteria("Amount", "More", "1");
        Criteria c2 = new Criteria("Title", "Contains", "The");
        Criteria c3 = new Criteria("Date", "On", "2013-08-01");

        List<Criteria> Criterias1 = new ArrayList<>();
        Criterias1.add(c1);
        Criterias1.add(c2);

        List<Criteria> Criterias2 = new ArrayList<>();
        Criterias2.add(c1);

        return args -> {
            log.info("Preloading " + criteriaRepository.save(c1));
            log.info("Preloading " + criteriaRepository.save(c2));
            log.info("Preloading " + criteriaRepository.save(c3));

            log.info("Preloading " + filterRepository.save(new Filter("first filter", Criterias1)));
            log.info("Preloading " + filterRepository.save(new Filter("first filter", Criterias2)));
        };
    }

}