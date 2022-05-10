package com.madim.mode;

public class Advise {
    public String adviseItself;
    public Integer blockWeight;
    public Integer foodWeight;
    public Integer armorWeight;
    public Integer weaponWeight;
    public Integer toolWeight;




    public Double distanceToBlocks;
    public Double distanceToFoods;
    public Double distanceToArmors;
    public Double distanceToWeapon;

    public Double distanceToTool;


    public Integer Weight;

    public Advise(String adviseItself, Integer blockWeight, Integer foodWeight, Integer armorWeight, Integer weaponWeight, Integer toolWeight)
    {
        this.adviseItself = adviseItself;
        this.blockWeight = blockWeight;
        this.foodWeight = foodWeight;
        this.armorWeight = armorWeight;
        this.weaponWeight = weaponWeight;

        this.toolWeight = toolWeight;




        this.distanceToBlocks = 0.0;
        this.distanceToArmors = 0.0;
        this.distanceToFoods = 0.0;
        this.distanceToWeapon = 0.0;
        this.distanceToTool = 0.0;


        this.Weight = 0;


    }



}
