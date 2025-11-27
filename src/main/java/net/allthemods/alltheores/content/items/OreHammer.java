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
        // If the item is not damageable (e.g., has Eternal Stella applied or Unbreakable tag), return it unchanged
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
