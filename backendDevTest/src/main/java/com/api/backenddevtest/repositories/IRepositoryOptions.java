package com.api.backenddevtest.repositories;

import com.api.backenddevtest.models.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryOptions extends JpaRepository<Options, Long> {
}
