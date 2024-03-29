package fr.knightmar.csmm.entities;


import fr.knightmar.csmm.init.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrocoEntity extends MonsterEntity {

    private static final double speed = 0.25D;
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.COOKED_MUTTON, Items.MUTTON, Items.COOKED_CHICKEN, Items.COOKED_BEEF, Items.BEEF);


    private int crocoTimer;

    public CrocoEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //func_233666_p_ ---> registerAttributes()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.ATTACK_SPEED, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0);



    }


    @Override
    protected void registerGoals() {
//        super.registerGoals();
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SheepEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, CowEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(7, new RandomWalkingGoal(this, speed));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookRandomlyGoal(this));

    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return 10 + this.level.random.nextInt(20);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CROCO_AMBIENT_SOUND.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 1.0F);
    }
}





