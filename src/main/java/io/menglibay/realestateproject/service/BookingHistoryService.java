package io.menglibay.realestateproject.service;

import io.menglibay.realestateproject.model.BookingHistory;
import io.menglibay.realestateproject.model.Room;
import io.menglibay.realestateproject.repository.BookHistoryRepository;
import io.menglibay.realestateproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingHistoryService {
    private final BookHistoryRepository bookHistoryRepository;

    private final RoomRepository roomRepository;

    @Autowired
    public BookingHistoryService(BookHistoryRepository bookHistoryRepository,RoomRepository roomRepository){
        this.bookHistoryRepository = bookHistoryRepository;
        this.roomRepository = roomRepository;
    }

    public List<BookingHistory> getAllBookHistory() {
        return bookHistoryRepository.findAll();
    }

    public List<BookingHistory> getBookHistoryByRoomId(int roomId){
        return bookHistoryRepository.findByRoomId(roomId);
    }

    public void bookRoom(int roomId,BookingHistory bookingHistory){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
        bookingHistory.setRoom(room);
        bookHistoryRepository.save(bookingHistory);
    }

    public void setRoomFree(int roomId){
        List<BookingHistory> bookingHistories = bookHistoryRepository.findTopByRoomIdOrderByIdDesc(roomId);
        if(!bookingHistories.isEmpty()){
            BookingHistory latestBooking = bookingHistories.get(0);
            latestBooking.setStatus(1);
            bookHistoryRepository.save(latestBooking);
        }
    }

    public void updateBookHistory(int id,BookingHistory updatedBookHistory){
        BookingHistory existingBookHistory = bookHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking History not found"));
        existingBookHistory.setFullname(updatedBookHistory.getFullname());
        existingBookHistory.setIin(updatedBookHistory.getIin());
        existingBookHistory.setStartDate(updatedBookHistory.getStartDate());
        existingBookHistory.setEndDate(updatedBookHistory.getEndDate());
        existingBookHistory.setComments(updatedBookHistory.getComments());
        existingBookHistory.setStatus(updatedBookHistory.getStatus());
        bookHistoryRepository.save(existingBookHistory);
    }

    public void deleteBookHistory(int id){
        bookHistoryRepository.deleteById(id);
    }


}
