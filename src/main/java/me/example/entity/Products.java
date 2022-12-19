package me.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Products extends Product {

    private double totalPrice;

    private int quantity;

    public Products(Product product, int quantity) {
        super(product.getId(), product.getName(), product.getPrice(), product.isOnSale());
        double price = product.getPrice() * quantity;
        if (product.isOnSale() && quantity > 5) {
            price = price - (price / 10);
        }
        this.totalPrice = price;
        this.quantity = quantity;
    }


}
