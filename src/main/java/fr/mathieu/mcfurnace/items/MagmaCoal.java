package fr.mathieu.mcfurnace.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagmaCoal extends Item {

    public MagmaCoal(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2500;
    }
}
