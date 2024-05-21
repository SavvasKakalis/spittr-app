package com.spittr.repository;

import com.spittr.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Integer> {
    List<Spittle> findAll();
}