package model;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ResManager implements Iterable<Restaurant>{

    public List<Restaurant> restaurants;
    private List<String> lines;

    public ResManager(){
        restaurants = new ArrayList<>();
    }

    public void load() throws Exception{
        File directory = new File("SavedRestaurants");
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(files!=null){
                for(File file:files){
                    lines = Files.readAllLines(file.toPath());
                    if(!lines.isEmpty()){
                        String resName = file.getName().replace(".txt", "");
                        Image logo = new ImageIcon(lines.get(0)).getImage();
                        List<Dish> dishes = new ArrayList<>();
                        for(int i=1; i<lines.size(); i++){
                            String name = lines.get(1);
                            List<String> ingredients = separateLine(lines.get(2));
                            Dish d = new Dish(name, ingredients);
                            dishes.add(d);
                            lines.remove(1);
                            lines.remove(1);
                        }
                        ResMenu menu = new ResMenu(dishes);
                        Restaurant r = new Restaurant(resName, menu, logo);
                        restaurants.add(r);
                    }
                }
            }
        }
    }

    private List<String> separateLine(String ingredientsLine) {
        String LINE_SEPARATOR = ",";
        String[] splits = ingredientsLine.split(LINE_SEPARATOR);
        return new ArrayList<>(Arrays.asList(splits));
    }

    public int indexOf(Restaurant r){
        return restaurants.indexOf(r);
    }

    public Restaurant get(int index){
        return restaurants.get(index);
    }

    @Override
    public Iterator<Restaurant> iterator() {
        return restaurants.iterator();
    }
}
