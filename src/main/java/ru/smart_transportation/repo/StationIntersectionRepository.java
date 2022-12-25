package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smart_transportation.entity.StationIntersection;

@Repository
public interface StationIntersectionRepository extends JpaRepository<StationIntersection, Integer> {
}