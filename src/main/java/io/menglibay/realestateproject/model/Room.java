package io.menglibay.realestateproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "floor",length = 45)
    private String floor;

    @Column(name = "complex",length = 100)
    private String complex;

    @Column(name = "amount")
    private int amount;

    @Column(name = "square")
    private double square;

    @Column(name = "kitchen_square")
    private double kitchenSquare;

    @Column(name = "conditions",length = 45)
    private String conditions;

    @Column(name = "coordinates",length = 45)
    private String coordinates;

    @Column(name = "people_num",length = 45)
    private String peopleNum;

    @Column(name = "bed_num",length = 45)
    private String bedNum;

    @Column(name = "status",length = 45)
    private String status;

    @Column(name = "booked_date",length = 45)
    private String bookedDate;

    @Column(name = "description",columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "images")
    private String images;

    @Column(name = "small_images")
    private String smallImages;


    public Room(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getComplex() {
        return complex;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getKitchenSquare() {
        return kitchenSquare;
    }

    public void setKitchenSquare(double kitchenSquare) {
        this.kitchenSquare = kitchenSquare;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", floor='" + floor + '\'' +
                ", complex='" + complex + '\'' +
                ", amount=" + amount +
                ", square=" + square +
                ", kitchenSquare=" + kitchenSquare +
                ", conditions='" + conditions + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", peopleNum='" + peopleNum + '\'' +
                ", bedNum='" + bedNum + '\'' +
                ", status='" + status + '\'' +
                ", bookedDate='" + bookedDate + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", smallImages='" + smallImages + '\'' +
                '}';
    }
}
