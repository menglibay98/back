package io.menglibay.realestateproject.repository;

import io.menglibay.realestateproject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
