package com.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewOrderProductRequest {

    private int productId;
    private int quantity;

}



