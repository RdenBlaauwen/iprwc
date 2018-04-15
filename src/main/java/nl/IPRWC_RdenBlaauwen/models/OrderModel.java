/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.models;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author RdenBlaauwen
 */
public class OrderModel {
    private int id;
    private int accountId;
    private Date orderDateTime;
    private Date deliveryDateTime;
    private OrderStatus status;
    private boolean isDeleted;
    private ArrayList<OrderProductModel> products = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Date getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(Date deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ArrayList<OrderProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<OrderProductModel> products) {
        this.products = products;
    }
}
