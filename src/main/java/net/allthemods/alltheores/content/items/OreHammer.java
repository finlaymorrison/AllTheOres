package net.allthemods.alltheores.content.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class OreHammer extends Item {

    public OreHammer(Item.Properties properties, int durability) {

        super(properties.durability(durability));

    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return (stack.getItem() instanceof OreHammer);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        // If the item is not damageable (has Unbreakable tag, max durability is 0, or item type doesn't support damage), return it unchanged
        // This allows items modified by mods like Eternal Stella to work correctly
        if (!itemStack.isDamageableItem()) {
            return itemStack.copy();
        }
        
        int durability = itemStack.getDamageValue();
        itemStack.setDamageValue(durability + 1);
        if (itemStack.getDamageValue() == itemStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return itemStack.copy();
    }

}
