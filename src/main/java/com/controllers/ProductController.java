package com.controllers;

import com.models.Product;
import com.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping(produces = "application/json")
    public List<Product> products() {
        List<Product> productList = new ArrayList<Product>();
        productList.addAll(Arrays.asList(
                new Product(1, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(2, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(3, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(4, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(5, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(6, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(7, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2),
                new Product(8, "Airpods Wireless Bluetooth Headphones", "null", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple", 89.99, 1, 2)));
        return productList;


    }
}
