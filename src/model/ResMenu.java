package model;

import java.util.ArrayList;
import java.util.List;

public class ResMenu{

    private List<Dish> dishes;

    public ResMenu(List<Dish> dishes){
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish d){
        if(!dishes.contains(d)){
            dishes.add(d);
        }
    }

    public void removeDish(Dish d){
        if(dishes.contains(d)){
            dishes.remove(d);
        }
    }

}