package io.menglibay.realestateproject.controller;

import io.menglibay.realestateproject.entity.BookingHistory;
import io.menglibay.realestateproject.entity.Room;
import io.menglibay.realestateproject.service.BookingHistoryService;
import io.menglibay.realestateproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-history")
public class BookingHistoryController {

    private final BookingHistoryService bookingHistoryService;

    private final RoomService roomService;

    @Autowired
    public BookingHistoryController(BookingHistoryService bookingHistoryService,RoomService roomService) {
        this.bookingHistoryService = bookingHistoryService;
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<BookingHistory>> getAllBookingHistory() {
        List<BookingHistory> bookingHistories = bookingHistoryService.getAllBookHistory();
        return ResponseEntity.ok(bookingHistories);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookingHistory> getBookingHistoryById(@PathVariable int id) {
        BookingHistory bookingHistory = bookingHistoryService.getBookingHistoryById(id);
        if (bookingHistory != null) {
            return ResponseEntity.ok(bookingHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<BookingHistory>> getBookingHistoryByRoomId(@PathVariable int roomId) {
        List<BookingHistory> bookingHistories = bookingHistoryService.getBookHistoryByRoomId(roomId);
        if (!bookingHistories.isEmpty()) {
            return ResponseEntity.ok(bookingHistories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/book/{roomId}")
    public BookingHistory bookRoom(@PathVariable int roomId, @RequestBody BookingHistory bookingHistory) {
        return bookingHistoryService.create(roomId,bookingHistory);
    }


    @PutMapping("/{id}")
    public void updateBookingHistory(@PathVariable int id, @RequestBody BookingHistory updatedBookingHistory) {
        bookingHistoryService.updateBookHistory(id, updatedBookingHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteBookingHistory(@PathVariable int id) {
        bookingHistoryService.deleteBookHistory(id);
    }
}
