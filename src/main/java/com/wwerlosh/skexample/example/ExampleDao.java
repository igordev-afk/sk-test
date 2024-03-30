package com.wwerlosh.skexample.example;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleDao extends JpaRepository<ExampleEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @NonNull
    Optional<ExampleEntity> findById(@NonNull Long id);
}
