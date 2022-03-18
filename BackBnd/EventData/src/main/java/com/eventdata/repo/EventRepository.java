package com.eventdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventdata.model.EventDTO;

@Repository
public interface EventRepository extends JpaRepository<EventDTO,Long>{

}
