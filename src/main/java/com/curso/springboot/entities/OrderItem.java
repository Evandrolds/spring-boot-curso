package com.curso.springboot.entities;

import com.curso.springboot.entities.pk.OrderItemPK;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Evandro
 */
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @EmbeddedId
    private OrderItemPK id;
    private Integer quantity;
    private Double price;

    public OrderItem(Product product, Order order,Integer quantity, Double price) {

        this.quantity = quantity;
        this.price = price;
        id.setOrderItemPk(order);
        id.setProductItemPk(product);
    }
    public Order getOrder(){
        return id.getOrderItemPk();
    }
    public void setOrder(Order order){
        id.setOrderItemPk(order);
    }
    public Product getProduct(){
        return id.getProductItemPk();
    }
    public void setProduct(Product product){
        id.setProductItemPk(product);
    }
    public OrderItem() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final OrderItem other = (OrderItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

}
