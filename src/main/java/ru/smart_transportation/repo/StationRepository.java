package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smart_transportation.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
}