package filter;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private FilterRepository filterRepository;

    @Bean
    @Transactional // Ensure transactional context
    CommandLineRunner initDatabase() {
        Criteria c1 = new Criteria("Amount", "More", "1");
        Criteria c2 = new Criteria("Title", "Contains", "The");
        Criteria c3 = new Criteria("Date", "On", "2013-08-01");

        List<Criteria> criterias1 = new ArrayList<>();
        criterias1.add(c1);
        criterias1.add(c2);

        List<Criteria> criterias2 = new ArrayList<>();
        criterias2.add(c3);

        return args -> {
            log.info("Preloading " + filterRepository.save(new Filter("first filter", criterias1)));
            log.info("Preloading " + filterRepository.save(new Filter("second filter", criterias2)));

        };
    }

}