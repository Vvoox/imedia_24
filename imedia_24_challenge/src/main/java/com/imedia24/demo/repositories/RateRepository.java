package com.imedia24.demo.repositories;

import com.imedia24.demo.models.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestController
public interface RateRepository extends JpaRepository<Rate,Long> {
}
