package com.hotel.reservas.repository;

import com.hotel.reservas.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuespedRepository extends JpaRepository<Huesped, Long> {
}