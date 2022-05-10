package com.madim.mode;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.swing.plaf.basic.BasicComboBoxUI;

public class InventoryCheck {

    @SubscribeEvent
    public void onTickPlayerEvent(TickEvent.PlayerTickEvent e) {
        //EntityPlayer player = (EntityPlayer) e.player;

        //player.sendMessage(new TextComponentString("Hello"));
        //ItemStack stakk = new ItemStack(Block.getBlockById(4));
        //if (player.inventory.hasItemStack(stakk))
        //{
            //int msg = player.inventory.storeItemStack(stakk);
            //System.out.println(msg);
            //player.sendMessage(new TextComponentString(""));
            //player.inventory.storeItemStack();
        //};

    }

}



