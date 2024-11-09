package com.api.backenddevtest.repositories;

import com.api.backenddevtest.models.Polls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPolls extends JpaRepository<Polls, Long> {

}
