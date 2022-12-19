package me.example;

import lombok.RequiredArgsConstructor;
import me.example.parser.ArgsParser;
import me.example.printer.ReceiptPrinter;
import me.example.service.CardService;
import me.example.service.ProductService;
import me.example.service.ReceiptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    private static final ReceiptService receiptService = new ReceiptService();

    private final CardService cardService;

    private final ProductService productService;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        ArgsParser.productParse(args).forEach((k, v) -> receiptService.saveProduct(productService.getProduct(k), v));
        ArgsParser.cardParse(args).ifPresent(card -> receiptService.setCard(cardService.getCard(card)));
        ReceiptPrinter.printReceipt(receiptService);
    }

}