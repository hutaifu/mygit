package com.jxd.petstore.model;

/**
 * @ClassName Account
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class Account {
    private int id;
    private int deal_type;
    private int pet_id;
    private int selller_id;
    private int buyer_id;
    private double price;
    private String deal_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeal_type() {
        return deal_type;
    }

    public void setDeal_type(int deal_type) {
        this.deal_type = deal_type;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public int getSelller_id() {
        return selller_id;
    }

    public void setSelller_id(int selller_id) {
        this.selller_id = selller_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }

    public Account() {
    }

    public Account(int deal_type, int pet_id, int selller_id, int buyer_id, double price, String deal_time) {
        this.deal_type = deal_type;
        this.pet_id = pet_id;
        this.selller_id = selller_id;
        this.buyer_id = buyer_id;
        this.price = price;
        this.deal_time = deal_time;
    }
}
