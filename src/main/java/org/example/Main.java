package org.example;

import java.util.Comparator;
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
                new Order("Smartphone", 900.0));

        //Общая стоимость заказов по каждому продукту
        Map<String, Double> totalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,
                        Collectors.summingDouble(Order::getCost)));

        //Сортировка продуктов по убыванию общей стоимости
        List<Map.Entry<String, Double>> topThreeProducts = totalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .toList();

        //Вывод результатов: список трех самых дорогих продуктов и их общая стоимость.
        topThreeProducts.forEach(entry ->
                System.out.println("Продукт: " + entry.getKey() + ", Общая стоимость: " + entry.getValue()));

    }
}