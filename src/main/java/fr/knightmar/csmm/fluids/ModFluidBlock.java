package fr.knightmar.csmm.fluids;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.ITag;

import java.util.function.Supplier;

public class ModFluidBlock extends FlowingFluidBlock {
    public ITag.INamedTag<Fluid> fluidTag;

    public ModFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties, ITag.INamedTag<Fluid> fluidTag) {
        super(supplier, properties);
        this.fluidTag = fluidTag;
    }
}
