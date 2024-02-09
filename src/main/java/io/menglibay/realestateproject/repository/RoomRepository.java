package io.menglibay.realestateproject.repository;

import io.menglibay.realestateproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
