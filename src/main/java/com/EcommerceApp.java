package com;

import com.order.OrderRepository;
import com.order.Orders;
import com.product.Products;
import com.user.Users;
import com.product.ProductRepository;
import com.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EcommerceApp{

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApp.class, args);
    }

}
