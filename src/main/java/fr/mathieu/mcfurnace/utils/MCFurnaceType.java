package fr.mathieu.mcfurnace.utils;

public enum MCFurnaceType {

    // furnaces
    BASIC_FURNACE(3, 1),
    GOLD_FURNACE(4,2),
    DIAMOND_FURNACE(6,2),

    // generators
    BASIC_GENERATOR(2, 1),
    IRON_GENERATOR(3, 1),
    GOLD_GENERATOR(4, 2),
    DIAMOND_GENERATOR(6, 2);

    public int cookSpeed;
    public int output;

    MCFurnaceType(int cookSpeed, int output) {
        this.cookSpeed = cookSpeed;
        this.output = output;
    }



}
