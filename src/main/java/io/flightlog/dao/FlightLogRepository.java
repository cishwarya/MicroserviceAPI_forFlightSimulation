package io.flightlog.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.flightlog.dto.FlightLog;

public interface FlightLogRepository extends MongoRepository<FlightLog, String>{

}
