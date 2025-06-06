package net.bcutty.tutorialmod.item.custom;

import net.bcutty.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class OreVacuumItem extends Item {
    private static final Map<Block, Block> VacuumMap =
            Map.of(
                    Blocks.COAL_ORE, Blocks.STONE
            );
    public OreVacuumItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context, Entity entity) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(VacuumMap.containsKey(clickedBlock)) {
            if(!world.isClient) {
                world.setBlockState(context.getBlockPos(), VacuumMap.get(clickedBlock).getDefaultState());
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
                if (entity instanceof ItemEntity itemEntity) {
                    if(clickedBlock == Blocks.COAL_ORE) {
                        itemEntity.setStack(new ItemStack(Items.COAL, itemEntity.getStack().getCount()));
                    }
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
