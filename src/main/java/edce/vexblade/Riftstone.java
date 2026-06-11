package edce.vexblade;


import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static edce.vexblade.ModItems.register;
import static edce.vexblade.ModBlocks.register;

public class Riftstone {
    //Stuff for tab
    /*
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "vexblade")
    );
    public static final CreativeModeTab RIFTSTONE_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RiftstoneTool.RIFTSTONE_SWORD))
            .title(Component.translatable("itemGroup.vexblade"))
            .displayItems((params, output) -> {


                output.accept(RiftstoneTool.RIFTSTONE_SWORD);
                output.accept(RiftstoneTool.RIFTSTONE_PICKAXE);
                output.accept(RiftstoneTool.RIFTSTONE_AXE);
                output.accept(RiftstoneTool.RIFTSTONE_SHOVEL);
            })
            .build();
    // Register the group.
    Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, RIFTSTONE_ITEM_GROUP);





    */
    public static void InitalizeRiftstone() {
        // Get the event for modifying entries in the ingredients group.

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((itemGroup) -> itemGroup.accept(RIFTSTONE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(RIFTSTONE_ORE.asItem());
        });
    }

    public static final Item RIFTSTONE = register("riftstone", Item::new, new Item.Properties());
    public static final Block RIFTSTONE_ORE = register(
            "riftstone_ore",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(8).requiresCorrectToolForDrops(),
            true
    );
}