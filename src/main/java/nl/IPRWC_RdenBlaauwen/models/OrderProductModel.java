/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPRWC_RdenBlaauwen.models;

/**
 *
 * @author RdenBlaauwen
 */
public class OrderProductModel {
    private int orderedAmount;
    private int productId;

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
