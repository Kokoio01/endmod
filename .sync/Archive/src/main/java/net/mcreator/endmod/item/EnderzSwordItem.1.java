
package net.mcreator.endmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.endmod.EndmodModElements;

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
				return 250;
			}

			public float getEfficiency() {
				return 16.5f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 34;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EnderzIngotItem.block, (int) (1)));
			}
		}, 3, -4f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("enderz_sword"));
	}
}
