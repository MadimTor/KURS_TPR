package com.madim.mode;

import com.madim.mode.proxy.CommonProxy;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import com.madim.mode.proxy.CommonProxy;
import com.madim.mode.EventsHandler;

@Mod(modid = AisMode.MODID)




public class AisMode
{
    @SidedProxy(clientSide = "com.madim.mode.proxy.ClientProxy", serverSide = "com.madim.mode.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final String MODID = "ais";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
        FMLCommonHandler.instance().bus().register(new InventoryCheck());





        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        proxy.init(event);
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }


    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

        this.proxy.serverStarting(event);//Вызов из CommonProxy в главном классе
    }
}


