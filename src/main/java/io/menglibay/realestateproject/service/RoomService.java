package io.menglibay.realestateproject.service;

import io.menglibay.realestateproject.model.Room;
import io.menglibay.realestateproject.model.User;
import io.menglibay.realestateproject.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(int id){
        return roomRepository.findById(id).orElse(null);
    }

    @Transactional
    public Room saveRoom(Room room){
        try{
            Room savedRoom = roomRepository.save(room);
            return savedRoom;
        } catch (Exception e){
            System.out.println("Success!!!");
            throw e;
        }
    }

    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }
}
