package com.mediaserver.entity;


//@Entity
//@Table(name = "platforms")
public class Platform {

    public Platform() {
    }

    public Platform(Integer id, String name, String multicastAddress, String comment) {
        this.id = id;
        this.name = name;
        this.multicastAddress = multicastAddress;
        this.comment = comment;
    }

    //@Id
    //@GeneratedValue
    private Integer id;
    private String name;
    private String multicastAddress;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMulticastAddress() {
        return multicastAddress;
    }

    public void setMulticastAddress(String multicastAddress) {
        this.multicastAddress = multicastAddress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
