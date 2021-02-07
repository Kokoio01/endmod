
package net.mcreator.endmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.endmod.procedures.EnderzSwordRightClickedInAirProcedure;
import net.mcreator.endmod.EndmodModElements;

import java.util.Map;
import java.util.HashMap;

@EndmodModElements.ModElement.Tag
public class EnderzSwordItem extends EndmodModElements.ModElement {
	@ObjectHolder("endmod:enderz_sword")
	public static final Item block = null;
	public EnderzSwordItem(EndmodModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 261;
			}

			public float getEfficiency() {
				return 49f;
			}

			public float getAttackDamage() {
				return 298f;
			}

			public int getHarvestLevel() {
				return 405;
			}

			public int getEnchantability() {
				return 4;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EnderzIngotItem.block, (int) (1)));
			}
		}, 3, -3.9999f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					EnderzSwordRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("enderz_sword"));
	}
}
