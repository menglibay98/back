package io.menglibay.realestateproject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "bookHistory")
public class BookingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "iin")
    private String iin;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Lob
    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @Column(name = "status",nullable = false,columnDefinition = "int default 0")
    private int status;

    public BookingHistory(){

    }

    public BookingHistory(String fullname, String iin, String startDate, String endDate, String comments, Room room, int status) {
        this.fullname = fullname;
        this.iin = iin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comments = comments;
        this.room = room;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
