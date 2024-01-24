package io.menglibay.realestateproject.controller;

import io.menglibay.realestateproject.model.Room;
import io.menglibay.realestateproject.model.User;
import io.menglibay.realestateproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room getRoomById(@PathVariable int id){
        Room room = roomService.getRoomById(id);
        if(room == null){
            System.out.println("Room not found with ID: " + id);
        }

        return room;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Room> createMultipleUsers(@RequestBody List<Room> rooms) {
        List<Room> savedRooms = new ArrayList<>();

        for (Room room : rooms) {
            savedRooms.add(roomService.saveRoom(room));
        }

        return savedRooms;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room updateRoom(@PathVariable int id, @RequestBody Room updatedRoomData) {
        Optional<Room> existingRoom = Optional.ofNullable(roomService.getRoomById(id));

        return existingRoom.map(room -> {
            // Обновить данные комнаты
            room.setTitle(updatedRoomData.getTitle());
            room.setPrice(updatedRoomData.getPrice());
            room.setFloor(updatedRoomData.getFloor());
            room.setComplex(updatedRoomData.getComplex());
            room.setAmount(updatedRoomData.getAmount());
            room.setSquare(updatedRoomData.getSquare());
            room.setKitchenSquare(updatedRoomData.getKitchenSquare());
            room.setCoordinates(updatedRoomData.getCoordinates());
            room.setPeopleNum(updatedRoomData.getPeopleNum());
            room.setBedNum(updatedRoomData.getBedNum());
            room.setStatus(updatedRoomData.getStatus());
            room.setBookedDate(updatedRoomData.getBookedDate());
            room.setDescription(updatedRoomData.getDescription());
            room.setImages(updatedRoomData.getImages());
            room.setSmallImages(updatedRoomData.getSmallImages());
            // Сохранить обновленную комнату
            return roomService.saveRoom(room);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found with ID: " + id));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable int id) {
        roomService.deleteRoom(id);
    }



}
