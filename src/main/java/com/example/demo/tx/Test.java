package com.example.demo.tx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String [] args) {

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        System.out.println("///////////////////////////////");


        List<Grouped> gList = new ArrayList<>();

        for (Map.Entry<BigDecimal, List<Item>> entry : groupByPriceMap.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());

            Grouped gtmp = new Grouped();


            for(Item e : entry.getValue()){
                Goods product = new Goods();

                gtmp.setPrice(e.getPrice());
                product.setName(e.getName());
                product.setQty(e.getQty());
                gtmp.getGoodsList().add(product);
                gList.add(gtmp);
            }

        }

        System.out.println("////////////// 1 /////////////////");

        for(Grouped el:gList){
            System.out.println(el);
        }

        System.out.println("////////////// 2 /////////////////");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = ow.writeValueAsString(gList);

            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

class Grouped {
    private BigDecimal price;
    private List<Goods> goodsList;

    public Grouped() {
        goodsList = new ArrayList<>();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Grouped{" +
                "price=" + price +
                ", goodsList=" + goodsList +
                '}';
    }
}

class Goods {
    private String name;
    private int qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}

class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    //constructors, getter/setters

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}

