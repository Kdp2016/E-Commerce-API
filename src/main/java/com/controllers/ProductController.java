package com.controllers;

import com.entities.Products;
import com.entities.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    Users user = new Users(1, "Goku", "Kakarot", "goku@gmail.com", "123 main st", "password123", Users.Role.SELLER);

    @GetMapping(produces = "application/json")
    public List<Products> products() {
        List<Products> productList = new ArrayList<Products>();
        productList.addAll(Arrays.asList(
                new Products(1, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(2, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(3, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(4, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(5, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(6, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(7, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products(8, "Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS)));
        return productList;


    }
}
