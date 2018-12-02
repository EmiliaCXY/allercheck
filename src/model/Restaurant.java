package model;

import java.awt.*;

public class Restaurant {

    private String name;
    private ResMenu resMenu;
    private Image logo;

    //AllergyManager allergyManager;

    public Restaurant(String name, ResMenu resMenu, Image logo){
        this.name = name;
        this.resMenu = resMenu;
        this.logo = logo;
        //allergyManager = new AllergyManager(resMenu.getDishes());
        //System.out.println(allergyManager.hasDairy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public ResMenu getResMenu() {
        return resMenu;
    }
}