package fr.mathieu.mcfurnace.furnace.simplefurnace.diamondfurnace;

import fr.mathieu.mcfurnace.furnace.simplefurnace.model.AbstractSimpleFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class DiamondFurnaceBlock extends AbstractSimpleFurnace {

    public DiamondFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new DiamondFurnaceTileEntity();
    }

}

