package com.madim.mode;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import scala.Int;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandCallhelp extends CommandBase {

    public static final String
            NAME = "callhelp",
            USAGE = "/callhelp"; //Шаблон вызова, выводится при выбрасывании WrongUsageException

    @Override
    public String getName() {

        return this.NAME;
    }

    @Override
    public String getUsage(ICommandSender sender) {

        return this.USAGE;
    }

    //Выполнение команды происходит здесь, этот метод вызывается только на сервере (физическом или логическом)
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (sender instanceof EntityPlayer) {

            if (args.length > 0) {

                throw new WrongUsageException(this.getUsage(sender));//Выбросить исключение если вместе с командой переданы какие либо аргументы.
            }




            EntityPlayer player = this.getCommandSenderAsPlayer(sender);//Получение экземрляра игрока, вызвавшего команду
            //ItemStack stakk = new ItemStack(Block.getBlockById(4));


            HashMap<String, Integer> inventoryMap = new HashMap<>(); // создаём словарь для хранения информации об инвентаре игрока




            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) //цикл по инвентарю
            {
                if (!((ItemStack)player.inventory.getStackInSlot(i)).isEmpty()) // проверка слота на пустоту
                {
                    //System.out.println("//");
                    //System.out.println(player.inventory.getStackInSlot(i));
                    //System.out.println(player.inventory.getStackInSlot(i).getUnlocalizedName());
                    if (!inventoryMap.containsKey(player.inventory.getStackInSlot(i).getUnlocalizedName())) //если в словаре инвентаря нет такого предмета
                        inventoryMap.put(player.inventory.getStackInSlot(i).getUnlocalizedName(),
                                player.inventory.getStackInSlot(i).getCount()); // добавляем предмет
                    else
                    {
                        Integer tempstr = inventoryMap.get(player.inventory.getStackInSlot(i).getUnlocalizedName());
                        Integer oldcount = tempstr;
                        oldcount += player.inventory.getStackInSlot(i).getCount();
                        inventoryMap.put(player.inventory.getStackInSlot(i).getUnlocalizedName(), oldcount);//считаем кол-во предметов в инвентаре
                    }

                }
            }
            System.out.println(inventoryMap);

            /////////////////////////

            TakeAdvise advise = new TakeAdvise();
            ArrayList<String> adviseForPlayer = advise.getAdvise(inventoryMap);

            for (String str : adviseForPlayer){
                player.sendMessage(new TextComponentString(str));
            }


            /////////////////////////







            //if (player.inventory.hasItemStack(stakk))
            //{
                //int temp = player.inventory.getSlotFor(stakk);
                //int temp2 = player.inventory.getStackInSlot(temp).getCount();

                //System.out.println("yes ");
                //System.out.println(temp);
                //System.out.println(temp2);

            //}






        }
    }
}