package io.menglibay.realestateproject.controller;

import io.menglibay.realestateproject.model.BookingHistory;
import io.menglibay.realestateproject.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookHistory")
public class BookingHistoryController {

    @Autowired
    private BookingHistoryService bookHistoryService;


    @GetMapping("/all")
    public ResponseEntity<List<BookingHistory>> getAllBookHistory() {
        List<BookingHistory> allBookHistory = bookHistoryService.getAllBookHistory();
        return ResponseEntity.ok(allBookHistory);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<List<BookingHistory>> getBookHistoryByRoomId(@PathVariable int roomId){
        List<BookingHistory> bookHistoryList = bookHistoryService.getBookHistoryByRoomId(roomId);
        return ResponseEntity.ok(bookHistoryList);
    }

    @PostMapping("/book/{roomId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> bookRoom(@PathVariable int roomId,@RequestBody BookingHistory bookHistory){
        bookHistoryService.bookRoom(roomId,bookHistory);
        return ResponseEntity.ok("Room booked succesfully");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateBookHistory(@PathVariable int id,
                                                    @RequestBody BookingHistory updateBookHistory){
        bookHistoryService.updateBookHistory(id,updateBookHistory);
        return ResponseEntity.ok("Book history updated successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBookHistory(@PathVariable int id){
        bookHistoryService.deleteBookHistory(id);
        return ResponseEntity.ok("Book history deleted successfully");
    }

    @PutMapping("/rooms/{roomId}/setFree")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> setRoomFree(@PathVariable int roomId){
        bookHistoryService.setRoomFree(roomId);
        return ResponseEntity.ok("Room set free successfully");
    }
}
