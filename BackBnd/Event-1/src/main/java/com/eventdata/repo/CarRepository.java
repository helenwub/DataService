package com.eventdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventdata.model.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
