package fr.mathieu.mcfurnace.furnace.simplefurnace.basicfurnace;

import fr.mathieu.mcfurnace.furnace.simplefurnace.model.AbstractSimpleFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;


public class BasicFurnaceBlock extends AbstractSimpleFurnace {

    public BasicFurnaceBlock(Properties builder) {
        super(builder);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new BasicFurnaceTileEntity();
    }
}

