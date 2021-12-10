/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.springboot.entities.pk;

import com.curso.springboot.entities.Order;
import com.curso.springboot.entities.Product;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Evandro
 */
@Embeddable // por ser uma classe auxiliar recebe esse anotation e não ( @Entity)
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = " product_id")
    private Product productItemPk;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderItemPk;

    public Product getProductItemPk() {
        return productItemPk;
    }

    public void setProductItemPk(Product productItemPk) {
        this.productItemPk = productItemPk;
    }

    public Order getOrderItemPk() {
        return orderItemPk;
    }

    public void setOrderItemPk(Order orderItemPk) {
        this.orderItemPk = orderItemPk;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.productItemPk);
        hash = 79 * hash + Objects.hashCode(this.orderItemPk);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItemPK other = (OrderItemPK) obj;
        if (!Objects.equals(this.productItemPk, other.productItemPk)) {
            return false;
        }
        if (!Objects.equals(this.orderItemPk, other.orderItemPk)) {
            return false;
        }
        return true;
    }

}
