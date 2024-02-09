package io.menglibay.realestateproject.repository;

import io.menglibay.realestateproject.entity.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookHistoryRepository extends JpaRepository<BookingHistory,Integer> {
    List<BookingHistory> findByRoomId(int roomId);

    List<BookingHistory> findTopByRoomIdOrderByIdDesc(int roomId);
}
