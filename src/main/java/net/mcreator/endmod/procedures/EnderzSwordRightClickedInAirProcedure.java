package net.mcreator.endmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.endmod.EndmodModElements;

import java.util.Map;

@EndmodModElements.ModElement.Tag
public class EnderzSwordRightClickedInAirProcedure extends EndmodModElements.ModElement {
	public EnderzSwordRightClickedInAirProcedure(EndmodModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EnderzSwordRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 100, (int) 100, (true), (true)));
	}
}
