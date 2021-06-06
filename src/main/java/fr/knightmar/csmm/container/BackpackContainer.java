package fr.knightmar.csmm.container;

import fr.knightmar.csmm.init.ContainerInit;
import fr.knightmar.csmm.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;

public class BackpackContainer extends Container {

    private final IInventory inputInventory = new Inventory(2);
    private final IWorldPosCallable worldPosCallable;

    public BackpackContainer(int windowIdIn, PlayerInventory playerInventoryIn) {
        this(windowIdIn, playerInventoryIn, IWorldPosCallable.DUMMY);
    }

    public BackpackContainer(int windowIdIn, PlayerInventory playerInventoryIn, final IWorldPosCallable worldPosCallableIn) {
        super(ContainerInit.TEST_CONTAINER.get(), windowIdIn);
        this.worldPosCallable = worldPosCallableIn;

        //29 29 correspond a la position de l'un des slots se trouvant sur la texture de l'interface
        this.addSlot(new Slot(this.inputInventory, 0, 29, 29) {
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem() instanceof BlockItem;
            }
        });

        //69 29 correspond a la position du deuxième slot se trouvant sur la texture de l'interface
        this.addSlot(new Slot(this.inputInventory, 1, 69, 29) {
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem() instanceof BlockItem;
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
        }

    }


    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.worldPosCallable.consume((world, pos) -> {
            this.clearContainer(playerIn, world, this.inputInventory);
        });
    }


    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.worldPosCallable, playerIn, ModBlocks.PLATINIUM_BLOCK.get());
    }

}
