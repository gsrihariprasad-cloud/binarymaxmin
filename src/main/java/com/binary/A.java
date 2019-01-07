package com.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class A {
 
	public static BinaryOperator<Item> get(){
		return (Item newI, Item oldI) -> {
		    
		    
		    Item i=(newI == null) ? oldI : newI;
		    
		    i.setCharges(oldI.getCharges());
		    
		    //return x;
		    return i;
		};
		}

public static void main(String[] args) {
 
List<Item> newEvent = Arrays.asList(new Item("a", 11, new PickupVariant(2)), new Item("b", 2,new PickupVariant(4)), new Item("f", 3,new PickupVariant(5)));
List<Item> oldEvent = Arrays.asList(new Item("b", 4,new PickupVariant(12)), new Item("a", 5,new PickupVariant(22)), new Item("e", 6,new PickupVariant(21)));
//List<Item> olololdogList3 = Arrays.asList(new Item("a", 7,new PickupVariant(25)), new Item("z", 8,new PickupVariant(23)), new Item("e", 9,new PickupVariant(22)));
      
//BinaryOperator<Charges> bch=(Charges x, Charges y) -> x == null ? y : x;       


      Collection<Item> dw= Stream.of(newEvent, oldEvent)
       .flatMap(List::stream)
       .collect(Collectors.toMap(Item::getName,
               d->d,
               get()))
       .values();
       
      
      
      
      List<Item> dogs = new ArrayList<>(dw);
       // dogs.forEach(System.out::println);
        
        dogs.forEach(d->{
            
            System.out.println("Nameid: "+d.getName() +" id:"+d.getId()+" pickup:"+d.getCharges().getPrice());
        });
        
        
        
       // new ArrayList<>( Stream.of(newdogList1, olddogList2,olololdogList3))
    }
 
}
 

class Item {
    String name;
    int id;
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    PickupVariant charges;
    public Item(String name, int id,PickupVariant charges) {
        this.name = name;
        this.id = id;
        this.charges=charges;
    }
 
    public PickupVariant getCharges() {
        return charges;
    }
 
    public void setCharges(PickupVariant charges) {
        this.charges = charges;
    }
 
    public String getName() {
        return name;
    }
 
    @Override
    public String toString() {
        return "Item [name=" + name + ", id=" + id + ", charges=" + charges + "]";
    }
 
//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                '}';
//    }
}
 
class PickupVariant{
    int price;
 
    public PickupVariant(int price) {
        super();
        this.price = price;
    }
 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }
}