package fr.mathieu.mcfurnace.furnace.simplegenerator.goldgenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.AbstractSimpleGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class GoldGenerator extends AbstractSimpleGenerator {

    public GoldGenerator(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader world) {
        return new GoldGeneratorTileEntity();
    }
}
