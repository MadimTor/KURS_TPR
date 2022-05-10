package com.madim.mode;

import gnu.trove.map.hash.THashMap;
import org.lwjgl.Sys;
import scala.Int;

import java.sql.Struct;
import java.util.*;


public class TakeAdvise {

   Advise[] advises = new Advise[17];
    {
        advises[0] = new Advise(
                "Need some blocks",
                0,
                0,
                0,
                0,
                0
        );

        advises[1] = new Advise(
                "Need wood tools",
                32,
                0,
                0,
                0,
                0
        );

        advises[2] = new Advise(
                "Need wood weapons",
                32,
                0,
                0,
                0,
                3
        );

        advises[3] = new Advise(
                "Need some armor",
                32,
                16,
                0,
                3,
                3
        );

        advises[4] = new Advise(
                "Need more blocks",
                32,
                16,
                6,
                3,
                3
        );

        advises[5] = new Advise(
                "Need stone tools",
                64,
                16,
                6,
                3,
                3
        );

        advises[6] = new Advise(
                "Need stone sword",
                64,
                16,
                6,
                3,
                9
        );

        advises[7] = new Advise(
                "Need more blocks",
                64,
                16,
                6,
                6,
                9
        );

        advises[8] = new Advise(
                "Need iron armor",
                86,
                16,
                6,
                6,
                9
        );

        advises[9] = new Advise(
                "Need iron tools",
                86,
                16,
                24,
                6,
                9
        );

        advises[10] = new Advise(
                "Need iron sword",
                86,
                16,
                24,
                6,
                18
        );

        advises[11] = new Advise(
                "Need more blocks",
                86,
                16,
                24,
                9,
                18
        );

        advises[12] = new Advise(
                "Need diamond tools",
                128,
                16,
                24,
                9,
                18
        );

        advises[13] = new Advise(
                "Need diamond sword",
                128,
                16,
                24,
                9,
                48
        );

        advises[14] = new Advise(
                "Need diamond armor",
                128,
                16,
                24,
                12,
                48
        );

        advises[15] = new Advise(
                "You can beat the dragon!",
                128,
                16,
                36,
                12,
                48
        );

        advises[16] = new Advise(
                "Need some food",
                64,
                0,
                6,
                6,
                9
        );

    }



    HashMap<String, Integer> blocksWeight = new HashMap()
    {{
        put("tile.stonebrick", 3);
        put("tile.dirt.default", 1);
        put("tile.cloth.white=1", 1);
        put("tile.log.oak=1", 2);
        put("tile.sand.default=1", 1);
        put("tile.gravel=1", 1);
        put("tile.wood.oak=1", 2);


    }};

    HashMap<String, Integer> foodWeight = new HashMap()
    {{
        put("item.porkchopCooked", 4);
        put("item.beefRaw", 1);
        put("item.chickenRaw", 1);
        put("item.apple", 2);
        put("item.beefCooked", 4);
        put("item.porkchopRaw", 1);
        put("item.chickenCooked", 3);
        put("item.carrots", 2);

    }};

    HashMap<String, Integer> armorWeight = new HashMap()
    {{
        put("item.helmetCloth", 3);
        put("item.chestplateCloth", 3);
        put("item.leggingsCloth", 3);
        put("item.bootsCloth", 3);

        put("item.helmetIron", 6);
        put("item.chestplateIron", 6);
        put("leggingsIron", 6);
        put("item.bootsIron", 6);

        put("item.helmetDiamond", 9);
        put("item.chestplateDiamond", 9);
        put("item.leggingsDiamond", 9);
        put("item.bootsDiamond", 9);

        put("item.helmetGold", 4);
        put("item.chestplateGold", 4);
        put("item.leggingsGold", 4);
        put("item.bootsGold", 4);

    }};

    HashMap<String, Integer> weaponWeight = new HashMap()
    {{
        put("item.swordWood", 3);
        put("item.swordIron", 9);
        put("item.swordDiamond", 12);
        put("item.swordStone", 6);

    }};


    HashMap<String, Integer> toolsWeight = new HashMap()
    {{
        put("item.hatchetWood", 1);
        put("item.shovelWood", 1);
        put("item.pickaxeWood", 1);
        put("item.pickaxeStone", 3);
        put("item.hatchetStone", 3);
        put("item.shovelStone", 3);
        put("item.shovelIron", 6);
        put("item.pickaxeIron", 6);
        put("item.hatchetIron", 6);
        put("item.pickaxeDiamond", 12);
        put("item.hatchetDiamond", 12);
        put("item.shovelDiamond", 12);


    }};






    public ArrayList<String> getAdvise(HashMap<String, Integer> inventoryMap)
    {
        ArrayList<String> a = new ArrayList<String>();



        Integer playerBlocks = 0;
        Integer playerFood = 0;
        Integer playerArmor = 0;
        Integer playerWeapon = 0;
        Integer playerTools = 0;

        ArrayList<HashMap.Entry> inventory_entries = new ArrayList<>(inventoryMap.entrySet());

        for (HashMap.Entry entry : inventory_entries)
        {
            if (blocksWeight.containsKey(entry.getKey()))
                playerBlocks += Integer.parseInt(entry.getValue().toString()) * blocksWeight.get(entry.getKey());

            if (foodWeight.containsKey(entry.getKey()))
                playerFood += Integer.parseInt(entry.getValue().toString()) * foodWeight.get(entry.getKey());

            if (armorWeight.containsKey(entry.getKey()))
                playerArmor += Integer.parseInt(entry.getValue().toString()) * armorWeight.get(entry.getKey());

            if (weaponWeight.containsKey(entry.getKey()))
                playerWeapon += Integer.parseInt(entry.getValue().toString()) * weaponWeight.get(entry.getKey());

            if (toolsWeight.containsKey(entry.getKey()))
                playerTools += Integer.parseInt(entry.getValue().toString()) * toolsWeight.get(entry.getKey());


        }

        System.out.println("//");
        System.out.println("Blocks " + playerBlocks);
        System.out.println("Food " + playerFood);
        System.out.println("Armor " + playerArmor);
        System.out.println("Weapons " + playerWeapon);
        System.out.println("Tools " + playerTools);
        System.out.println("//");


        for (Advise advise : advises) {
            advise.distanceToBlocks = Math.pow(Math.pow(advise.blockWeight - (double) playerBlocks, 2), (double)1/2);
            advise.distanceToFoods = Math.pow(Math.pow(advise.foodWeight - (double) playerFood, 2), (double)1/2);
            advise.distanceToArmors = Math.pow(Math.pow(advise.armorWeight - (double) playerArmor, 2), (double)1/2);
            advise.distanceToWeapon = Math.pow(Math.pow(advise.weaponWeight - (double) playerWeapon, 2), (double)1/2);
            advise.distanceToTool = Math.pow(Math.pow(advise.toolWeight - (double) playerTools, 2), (double)1/2);

        }

        Arrays.sort(advises, Comparator.comparingDouble(Advise -> Advise.distanceToBlocks));
        for (int i = 0; i <= 4; i++)
        {
            advises[i].Weight += 1;
        }

        Arrays.sort(advises, Comparator.comparingDouble(Advise -> Advise.distanceToFoods));
        for (int i = 0; i <= 4; i++)
        {
            advises[i].Weight += 1;
        }

        Arrays.sort(advises, Comparator.comparingDouble(Advise -> Advise.distanceToArmors));
        for (int i = 0; i <= 4; i++)
        {
            advises[i].Weight += 1;
        }

        Arrays.sort(advises, Comparator.comparingDouble(Advise -> Advise.distanceToWeapon));
        for (int i = 0; i <= 4; i++)
        {
            advises[i].Weight += 1;
        }

        Arrays.sort(advises, Comparator.comparingDouble(Advise -> Advise.distanceToTool));
        for (int i = 0; i <= 4; i++)
        {
            advises[i].Weight += 1;
        }




        Arrays.sort(advises, Collections.reverseOrder(Comparator.comparingInt(Advise -> Advise.Weight)));
        for (int i = 0; i <= 0; i++)
        {
            a.add(advises[i].adviseItself);
        }

        return a;

    }


}
