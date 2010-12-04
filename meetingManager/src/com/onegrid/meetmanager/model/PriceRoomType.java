package com.onegrid.meetmanager.model;

/**
 * Role entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PriceRoomType implements java.io.Serializable {
    private Integer id;

    private Price price;

    private RoomType roomType;

    private Integer minRoomNumber;

    private Integer maxRoomNumber;

    // Constructors

    public PriceRoomType(Integer id, Price price, RoomType roomType) {
        super();
        this.id = id;
        this.price = price;
        this.roomType = roomType;
    }

    /** default constructor */
    public PriceRoomType() {
    }

    /** full constructor */

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getMinRoomNumber() {
        return minRoomNumber;
    }

    public void setMinRoomNumber(Integer minRoomNumber) {
        this.minRoomNumber = minRoomNumber;
    }

    public Integer getMaxRoomNumber() {
        return maxRoomNumber;
    }

    public void setMaxRoomNumber(Integer maxRoomNumber) {
        this.maxRoomNumber = maxRoomNumber;
    }

}