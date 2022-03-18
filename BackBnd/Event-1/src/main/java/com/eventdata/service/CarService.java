package com.eventdata.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.eventdata.Inputs.Input1;
import com.eventdata.Inputs.Input2;
import com.eventdata.model.Car;
import com.eventdata.repo.CarRepository;
@Service
public class CarService {

	@Autowired
	CarRepository repo;
	@Async
    public CompletableFuture<Car> saveCars() throws Exception {
        
        Input1 mode1=new Input1();
    
        Car cars = mode1.saveClassModel1();
      

        //LOGGER.info("Saving a list of cars of size {} records", cars.size());

        cars = repo.save(cars);
        
   
        return CompletableFuture.completedFuture(cars);
    }
	@Async
    public CompletableFuture<Car> saveCars2() throws Exception {
      
        Input2 mode2=new Input2();
        
        Car car2=mode2.saveClassModel2();

        //LOGGER.info("Saving a list of cars of size {} records", cars.size());
        car2=repo.save(car2);
   
        return CompletableFuture.completedFuture(car2);
    }
	 @Async
	    public CompletableFuture<List<Car>> getAllCars() {

	        //LOGGER.info("Request to get a list of cars");

	        final List<Car> cars = repo.findAll();
	        return CompletableFuture.completedFuture(cars);
	    }
}
