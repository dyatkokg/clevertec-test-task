package me.example.parser;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


public class ArgsParser {

    public static Map<Integer, Integer> productParse(String[] args) {
        Map<Integer, Integer> products = new LinkedHashMap<>();
        for (String arg : args) {
            if (!arg.contains("card")) {
                String[] split = arg.split("-");
                products.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
        }
        return products;
    }

    public static Optional<Integer> cardParse(String[] args) {
        return Arrays.stream(args).filter(s -> s.contains("card")).findFirst()
                .map(s -> s.split("-")[1])
                .map(Integer::parseInt);
    }
}
