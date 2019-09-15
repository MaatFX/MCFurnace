package fr.mathieu.mcfurnace.furnace.simplefurnace.goldfurnace;

import fr.mathieu.mcfurnace.furnace.simplefurnace.model.AbstractSimpleFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class GoldFurnaceBlock extends AbstractSimpleFurnace {

    public GoldFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new GoldFurnaceTileEntity();
    }

}
