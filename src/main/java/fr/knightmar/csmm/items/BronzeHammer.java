package fr.knightmar.csmm.items;


import com.google.common.collect.ImmutableSet;
import fr.knightmar.csmm.init.ModBlocks;
import fr.knightmar.csmm.utils.CustomItemTiers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public class BronzeHammer extends PickaxeItem {
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.PISTON_HEAD, ModBlocks.BRONZE_ORE.get());
    private static final CustomItemTiers tier = CustomItemTiers.BRONZE;

    public BronzeHammer(Properties properties,float speed) {
        super(CustomItemTiers.BRONZE, 1, 0.1f, properties);

    }


    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return this.speed - 2;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        int rotH = (int) entityLiving.xRot/2;
        System.out.println("Yaw 2 : "+ entityLiving.yRot);
        System.out.println("Pitch : " + entityLiving.xRot);

        if (entityLiving.xRot >= 32 || entityLiving.xRot <=-32) {
            System.out.println("bas ok");
            BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1);
            BlockPos pos2 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1);
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
            BlockPos pos5 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1);
            BlockPos pos6 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            BlockPos pos7 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1);
            BlockPos pos8 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);

            for (Object block : EFFECTIVE_ON.toArray()) {
                if (worldIn.getBlockState(pos1).getBlock() == block) {
                    worldIn.destroyBlock(pos1, true);
                }
                if (worldIn.getBlockState(pos2).getBlock() == block) {
                    worldIn.destroyBlock(pos2, true);
                }
                if (worldIn.getBlockState(pos3).getBlock() == block) {
                    worldIn.destroyBlock(pos3, true);
                }
                if (worldIn.getBlockState(pos4).getBlock() == block) {
                    worldIn.destroyBlock(pos4, true);
                }
                if (worldIn.getBlockState(pos5).getBlock() == block) {
                    worldIn.destroyBlock(pos5, true);
                }
                if (worldIn.getBlockState(pos6).getBlock() == block) {
                    worldIn.destroyBlock(pos6, true);
                }
                if (worldIn.getBlockState(pos7).getBlock() == block) {
                    worldIn.destroyBlock(pos7, true);
                }
                if (worldIn.getBlockState(pos8).getBlock() == block) {
                    worldIn.destroyBlock(pos8, true);
                }

            }
        } else if (entityLiving.getDirection() == Direction.SOUTH){ //(entityLiving.yRot > -45 && entityLiving.yRot < 45) || (entityLiving.yRot > 315 && entityLiving.yRot < 360) && entityLiving.xRot < 30 && entityLiving.xRot > -30) {
            //(entityLiving.rotationYaw > -40 && entityLiving.rotationYaw < 40 && entityLiving.rotationPitch < 32 && entityLiving.rotationPitch > -32) {
            System.out.println("sud ok");
            BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            BlockPos pos5 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());
            BlockPos pos6 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
            BlockPos pos7 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ());
            BlockPos pos8 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ());

            for (Object block : EFFECTIVE_ON.toArray()) {
                if (worldIn.getBlockState(pos1).getBlock() == block) {
                    worldIn.destroyBlock(pos1, true);
                }
                if (worldIn.getBlockState(pos2).getBlock() == block) {
                    worldIn.destroyBlock(pos2, true);
                }
                if (worldIn.getBlockState(pos3).getBlock() == block) {
                    worldIn.destroyBlock(pos3, true);
                }
                if (worldIn.getBlockState(pos4).getBlock() == block) {
                    worldIn.destroyBlock(pos4, true);
                }
                if (worldIn.getBlockState(pos5).getBlock() == block) {
                    worldIn.destroyBlock(pos5, true);
                }
                if (worldIn.getBlockState(pos6).getBlock() == block) {
                    worldIn.destroyBlock(pos6, true);
                }
                if (worldIn.getBlockState(pos7).getBlock() == block) {
                    worldIn.destroyBlock(pos7, true);
                }
                if (worldIn.getBlockState(pos8).getBlock() == block) {
                    worldIn.destroyBlock(pos8, true);
                }
            }
        } else if (entityLiving.getDirection() == Direction.NORTH){ //(entityLiving.yRot > 135 && entityLiving.yRot < 225) && (entityLiving.xRot < 32 && entityLiving.xRot > -32)) {
            System.out.println("nord ok");
            BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            BlockPos pos5 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());
            BlockPos pos6 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
            BlockPos pos7 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ());
            BlockPos pos8 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ());

            for (Object block : EFFECTIVE_ON.toArray()) {
                if (worldIn.getBlockState(pos1).getBlock() == block) {
                    worldIn.destroyBlock(pos1, true);
                }
                if (worldIn.getBlockState(pos2).getBlock() == block) {
                    worldIn.destroyBlock(pos2, true);
                }
                if (worldIn.getBlockState(pos3).getBlock() == block) {
                    worldIn.destroyBlock(pos3, true);
                }
                if (worldIn.getBlockState(pos4).getBlock() == block) {
                    worldIn.destroyBlock(pos4, true);
                }
                if (worldIn.getBlockState(pos5).getBlock() == block) {
                    worldIn.destroyBlock(pos5, true);
                }
                if (worldIn.getBlockState(pos6).getBlock() == block) {
                    worldIn.destroyBlock(pos6, true);
                }
                if (worldIn.getBlockState(pos7).getBlock() == block) {
                    worldIn.destroyBlock(pos7, true);
                }
                if (worldIn.getBlockState(pos8).getBlock() == block) {
                    worldIn.destroyBlock(pos8, true);
                }
            }
        }else if (entityLiving.getDirection() == Direction.WEST){ //(entityLiving.yRot > 45 && entityLiving.yRot < 135) && (entityLiving.xRot < 32 && entityLiving.xRot > -32)) {
            System.out.println("west ok");
            BlockPos pos1 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
            BlockPos pos2 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1);
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1);
            BlockPos pos5 = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ());
            BlockPos pos6 = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1);
            BlockPos pos7 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
            BlockPos pos8 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1);

            for (Object block : EFFECTIVE_ON.toArray()) {
                if (worldIn.getBlockState(pos1).getBlock() == block) {
                    worldIn.destroyBlock(pos1, true);
                }
                if (worldIn.getBlockState(pos2).getBlock() == block) {
                    worldIn.destroyBlock(pos2, true);
                }
                if (worldIn.getBlockState(pos3).getBlock() == block) {
                    worldIn.destroyBlock(pos3, true);
                }
                if (worldIn.getBlockState(pos4).getBlock() == block) {
                    worldIn.destroyBlock(pos4, true);
                }
                if (worldIn.getBlockState(pos5).getBlock() == block) {
                    worldIn.destroyBlock(pos5, true);
                }
                if (worldIn.getBlockState(pos6).getBlock() == block) {
                    worldIn.destroyBlock(pos6, true);
                }
                if (worldIn.getBlockState(pos7).getBlock() == block) {
                    worldIn.destroyBlock(pos7, true);
                }
                if (worldIn.getBlockState(pos8).getBlock() == block) {
                    worldIn.destroyBlock(pos8, true);
                }
            }
        }else if (entityLiving.getDirection() == Direction.EAST){ //(entityLiving.yRot > 225 && entityLiving.yRot < 315) && (entityLiving.xRot < 32 && entityLiving.xRot > -32)) {
            System.out.println("est ok");
            BlockPos pos1 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
            BlockPos pos2 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1);
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
            BlockPos pos4 = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1);
            BlockPos pos5 = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ());
            BlockPos pos6 = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1);
            BlockPos pos7 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
            BlockPos pos8 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1);

            for (Object block : EFFECTIVE_ON.toArray()) {
                if (worldIn.getBlockState(pos1).getBlock() == block) {
                    worldIn.destroyBlock(pos1, true);
                }
                if (worldIn.getBlockState(pos2).getBlock() == block) {
                    worldIn.destroyBlock(pos2, true);
                }
                if (worldIn.getBlockState(pos3).getBlock() == block) {
                    worldIn.destroyBlock(pos3, true);
                }
                if (worldIn.getBlockState(pos4).getBlock() == block) {
                    worldIn.destroyBlock(pos4, true);
                }
                if (worldIn.getBlockState(pos5).getBlock() == block) {
                    worldIn.destroyBlock(pos5, true);
                }
                if (worldIn.getBlockState(pos6).getBlock() == block) {
                    worldIn.destroyBlock(pos6, true);
                }
                if (worldIn.getBlockState(pos7).getBlock() == block) {
                    worldIn.destroyBlock(pos7, true);
                }
                if (worldIn.getBlockState(pos8).getBlock() == block) {
                    worldIn.destroyBlock(pos8, true);
                }
            }
        }
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);

    }


}



