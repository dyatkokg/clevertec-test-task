package me.example.printer;

import lombok.experimental.UtilityClass;
import me.example.service.ReceiptService;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class ReceiptPrinter {

    public static void printReceipt(ReceiptService receipt) {
        try {
            PrintStream fileOut = new PrintStream("C:\\Users\\dyatk\\IdeaProjects\\test-task-clevertec\\src\\main\\resources\\receipt.txt");
            fileOut.println("                   CASH RECIPE                   ");

            fileOut.println("                 SUPERMARKET 123               ");
            fileOut.println();
            fileOut.println("\t \t \t \t" + LocalDate.now() + " " + LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
            fileOut.println("————————————————————————————————————————————————————");
            fileOut.println("Q \t \t Name \t\t Price \t\t Total");
            fileOut.println();
            receipt.getProductsList().forEach(products -> fileOut.printf("%s \t \t %s \t   %s  \t %s%n", products.getQuantity(),
                    products.getName(),
                    products.getPrice(),
                    products.getTotalPrice()));
            fileOut.println("————————————————————————————————————————————————————");
            fileOut.println();
            if (receipt.getCard() != null) {
                fileOut.printf("Subtotal: %s%n", receipt.getTotal());
                fileOut.printf("Discount Card: %s%n", receipt.getCard().getName());
                fileOut.printf("Discount Value: %s%n", receipt.getCard().getDiscountCount());
                fileOut.println();
                fileOut.printf("Total: %s%n", BigDecimal.valueOf(receipt.getTotalWithCard()).setScale(1,RoundingMode.CEILING));
            } else {
                fileOut.printf("Total: %s%n", BigDecimal.valueOf(receipt.getTotal()).setScale(1, RoundingMode.CEILING));
            }
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
