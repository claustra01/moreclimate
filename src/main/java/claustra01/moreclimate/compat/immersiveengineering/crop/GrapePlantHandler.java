package claustra01.moreclimate.compat.immersiveengineering.crop;

import blusunrize.immersiveengineering.api.ComparableItemStack;
import claustra01.moreclimate.compat.immersiveengineering.WeightedItemStack;
import claustra01.moreclimate.compat.immersiveengineering.WeightedVinePlantHandler;
import defeatedcrow.hac.food.FoodInit;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class GrapePlantHandler extends WeightedVinePlantHandler {

    public static float seedWeight = 0.25f;
    public static float cropWeight = 1f;
    public static int minDrops = 1;
    public static int maxDrops = 2;
    public static int numDrops = new Random().nextInt(maxDrops - minDrops) + minDrops;
    public static ItemStack itemSeeds = new ItemStack(FoodInit.seeds, 1, 16);
    public static ItemStack itemDrops = new ItemStack(FoodInit.crops, numDrops, 20);
    public static ItemStack blockDirt = new ItemStack(Blocks.DIRT);

    public GrapePlantHandler() {
        this.seed = new ComparableItemStack(itemSeeds, false, false);
        this.soil = new ComparableItemStack(blockDirt, false, false);
        this.crop = FoodInit.cropGrape;
    }

    @Override
    public ItemStack[] getOutput(ItemStack seed, ItemStack soil, TileEntity tile) {
        WeightedItemStack[] stacks = new WeightedItemStack[] {
                new WeightedItemStack(itemSeeds, seedWeight),
                new WeightedItemStack(itemDrops, cropWeight)
        };
        return WeightedItemStack.getRandomDrops(rand, stacks);
    }

}
