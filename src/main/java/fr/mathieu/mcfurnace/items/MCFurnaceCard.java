package fr.mathieu.mcfurnace.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MCFurnaceCard extends Item {

    private Block fromBlock;

    public MCFurnaceCard(Properties properties) {
        super(properties);
    }

    public void setFromBlock(Block block) {
        this.fromBlock = block;
    }

    public Block getFromBlock() {
        return fromBlock;
    }
}
