package com.example.Oil_Station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Oil_Station.entity.Oil;
import org.springframework.stereotype.Repository;

@Repository
public interface OilRepository extends JpaRepository<Oil, Long>{
    
}
