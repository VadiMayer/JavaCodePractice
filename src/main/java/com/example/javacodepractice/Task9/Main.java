package com.example.javacodepractice.Task9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        Map<String, Double> groupByTotalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(
                Order::getProduct, Collectors.summingDouble(Order::getCost)));

        List<Map.Entry<String, Double>> sortedProducts = groupByTotalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();

        List<Map.Entry<String, Double>> top3Products = sortedProducts.stream()
                .limit(3)
                .toList();

        top3Products.forEach(e -> System.out.println("Product: " + e.getKey() + ", Total Cost: " + e.getValue()));

    }
}
