package model;

import java.util.List;

public class AllergyManager {

    List<Dish> dishes;
    List<String> ingredients;

    Boolean hasNuts = false;
    Boolean hasDairy = false;
    Boolean hasFish = false;
    Boolean hasGluten = false;

    public AllergyManager(List<Dish> dishes){
        this.dishes = dishes;
        getAllIngredients();
    }

    public void setter(){
        if(ingredients.contains("nuts")){
            hasNuts = true;
        }else if(ingredients.contains("dairy")){
            hasDairy = true;
        }else if(ingredients.contains("fish")){
            hasFish = true;
        }else if(ingredients.contains("gluten")){
            hasGluten = true;
        }
    }


    public void getAllIngredients() {
        for(Dish d:dishes){
            for(String i:d.getIngredients()){
                ingredients.add(i);
            }
        }
    }
}
