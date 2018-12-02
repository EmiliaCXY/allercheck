package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    String name;
    List<String> ingredients;

    Boolean vegan;
    Boolean vegetarian;
    Boolean halal;
    Boolean kosher;
    Boolean oceanWise;

    public String getIdentifier;

    public Dish(String name, List<String> ingredients){
        this.name = name;
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIngredient(String i){
        if(!ingredients.contains(i)){
            ingredients.add(i);
        }
    }

    public void removeIngredient(String i){
        if(ingredients.contains(i)){
            ingredients.remove(i);
        }
    }
}
