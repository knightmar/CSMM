//package fr.knightmar.csmm.init;
//
//import fr.knightmar.csmm.Main;
//import fr.knightmar.csmm.utils.PlatiniumFluids;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.tags.*;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import java.util.List;
//
//import static net.minecraft.tags.FluidTags.createOptional;
//
//public class ModFluids {
//    public static final DeferredRegister<Fluid> FLUID_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MODID);
//
//    public static final PlatiniumFluids PLATINIUM_WATER = null;
//    public static final PlatiniumFluids FLOWING_PLATINIUM_WATER = null;
//
//    public static class Tags{
//        protected static final TagRegistry<Fluid> REGISTRY = TagRegistryManager.create(new ResourceLocation("fluid"), ITagCollectionSupplier::getFluidTags);
//        public static final ITag.INamedTag<Fluid> PLATINUM_WATER = makeWrapperTag("platinum_water");
//
//
//        public static ITag.INamedTag<Fluid> makeWrapperTag(String id) {
//            return REGISTRY.createTag(id);
//        }
//
//        public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name) {
//            return createOptional(name, null);
//        }
//
//        public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Fluid>> defaults) {
//            return REGISTRY.createOptional(name, defaults);
//        }
//
//        public static List<? extends ITag.INamedTag<Fluid>> getAllTags() {
//            return REGISTRY.getTags();
//        }
//
//        //Forge: Readd this stripped getter like the other tag classes
//        public static ITagCollection<Fluid> getCollection() {
//            return REGISTRY.getCollection();
//        }
//    }
//}