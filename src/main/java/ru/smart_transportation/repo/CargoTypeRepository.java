package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smart_transportation.entity.CargoType;

@Repository
public interface CargoTypeRepository extends JpaRepository<CargoType, Integer> {
}