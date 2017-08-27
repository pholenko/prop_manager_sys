package com.example.configuration;

import com.example.demo.ReservationGenerator;
import com.example.domain.Reservation;
import com.example.reposotory.ReservationCrudRepository;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * Created by admin on 26.08.17.
 */
@Component
public class AppConfig {

    public static final DateTimeFormatter FORMATTER = ofPattern("yyyy-MM-dd HH:mm:ss");

    @Component
    public static class DataGenerator {

        private static final int COUNT = 10;

        private final ReservationCrudRepository reservationRepository;

        private final ReservationGenerator reservationGenerator = new ReservationGenerator();

        @Autowired
        public DataGenerator(ReservationCrudRepository reservationRepository) {
            this.reservationRepository = reservationRepository;
        }

        @Bean
        CommandLineRunner commandLineRunner(DataGenerator dataGenerator) {
            return (o) -> dataGenerator.generate();
        }

        private void generate() {
            IntStream.range(0, COUNT - 1).forEach(x -> {
                final LocalDateTime currentTime = LocalDateTime.now().minusMinutes(COUNT - x);
                reservationRepository.save(reservationGenerator.nextReservation(currentTime));
            });
        }
    }

    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new DateSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new DateDeserializer());
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

    @Bean
    public Module newJavaTimeModule() {
        return new JavaTimeModule();
    }

    @Configuration
    public static class CustomRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.exposeIdsFor(Reservation.class);
        }

    }



}


