package com.freelife.client.annotation01.domain;

import com.freelife.client.annotation01.annotation.FruitColor;
import com.freelife.client.annotation01.annotation.FruitName;
import com.freelife.client.annotation01.annotation.FruitProvider;
import lombok.Data;

@Data
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "HomePlus", address = "Seoul")
    private String appleProvider;
}
