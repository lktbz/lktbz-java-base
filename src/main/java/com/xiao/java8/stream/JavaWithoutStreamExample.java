package com.xiao.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName JavaWithoutStreamExample
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class JavaWithoutStreamExample {
    private static List< Product > productsList = new ArrayList< Product >();

    public static void main(String[] args) {

        // Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        // Without Java 8 Stream API'S
        withoutStreamAPI();
    }
    private static void withoutStreamAPI() {
        // without Stream API's
        List < Float > productPriceList = new ArrayList < Float > ();
        // filtering data of list
        for (Product product: productsList) {
            if (product.getPrice() > 25000) {
                // adding price to a productPriceList
                productPriceList.add(product.getPrice());
            }
        }

        // displaying data
        for (Float price: productPriceList) {
            System.out.println(price);
        }


        // With Java 8 Stream API'S
        withStreamAPI();

        // This is more compact approach for filtering data
        productsList.stream().filter(product -> product.getPrice() == 30000)
                .forEach(product -> System.out.println(product.getPrice()));
    }
    private static void withStreamAPI() {
        // filtering data of list
        List < Float > productPriceList =
                productsList.stream()
                     .filter((product) -> product.getPrice() > 25000)
                     .map((product) -> product.getPrice())
                     .collect(Collectors.toList());
        // displaying data
        productPriceList.forEach((price) -> System.out.println(price));
    }
}
