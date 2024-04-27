package com.example.gardening;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepo extends JpaRepository<Garden, Integer> {
}
