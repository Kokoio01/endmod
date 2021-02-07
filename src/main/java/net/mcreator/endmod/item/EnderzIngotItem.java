
package net.mcreator.endmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.endmod.itemgroup.EndermodItemGroup;
import net.mcreator.endmod.EndmodModElements;

@EndmodModElements.ModElement.Tag
public class EnderzIngotItem extends EndmodModElements.ModElement {
	@ObjectHolder("endmod:enderz_ingot")
	public static final Item block = null;
	public EnderzIngotItem(EndmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(EndermodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("enderz_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
