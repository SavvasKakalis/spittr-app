package com.spittr.repository;

import com.spittr.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpittleRepository extends JpaRepository<Spittle, Integer> {
    List<Spittle> findAll();
}
