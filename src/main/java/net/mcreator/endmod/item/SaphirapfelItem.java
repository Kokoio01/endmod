
package net.mcreator.endmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.endmod.procedures.SaphirapfelFoodEatenProcedure;
import net.mcreator.endmod.EndmodModElements;

import java.util.Map;
import java.util.HashMap;

@EndmodModElements.ModElement.Tag
public class SaphirapfelItem extends EndmodModElements.ModElement {
	@ObjectHolder("endmod:saphirapfel")
	public static final Item block = null;
	public SaphirapfelItem(EndmodModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(29).saturation(1.8f).build()));
			setRegistryName("saphirapfel");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SaphirapfelFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
