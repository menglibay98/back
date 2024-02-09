package io.menglibay.realestateproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookhistory")
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


    @Column(name = "status",nullable = false,columnDefinition = "int default 0")
    private int status;

    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "id")
    private Room room;


    public BookingHistory(){

    }

    public BookingHistory(String fullname, String iin, String startDate, String endDate, String comments, int status,Room room) {
        this.fullname = fullname;
        this.iin = iin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comments = comments;
        this.status = status;
        this.room = new Room();
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
