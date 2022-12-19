package me.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.example.entity.Card;
import me.example.entity.Product;
import me.example.entity.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ReceiptService {

    private final List<Products> productsList = new ArrayList<>();

    private Card card;

    public double getTotal() {
        double total = 0;
        for (Products products : productsList) {
            total += products.getTotalPrice();
        }
        return total;
    }


    public double getTotalWithCard() {
        return getTotal() - getTotal() / card.getDiscountCount();
    }

    public void saveProduct(Product product, int quantity) {
        productsList.add(new Products(product, quantity));
    }
}
