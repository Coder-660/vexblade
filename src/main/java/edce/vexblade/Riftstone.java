package edce.vexblade;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static edce.vexblade.ModItems.register;

public class Riftstone {
    //Stuff for tab
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "vexblade")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RiftstoneTool.RIFTSTONE_SWORD))
            .title(Component.translatable("itemGroup.vexblade"))
            .displayItems((params, output) -> {


                output.accept(RiftstoneTool.RIFTSTONE_SWORD);
                output.accept(RiftstoneTool.RIFTSTONE_PICKAXE);
                output.accept(RiftstoneTool.RIFTSTONE_AXE);
                output.accept(RiftstoneTool.RIFTSTONE_SHOVEL);
            })
            .build();





    public static void InitalizeRIftstone(){
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register((itemGroup) -> itemGroup.accept(RIFTSTONE));
    }
    public static final Item RIFTSTONE = register("riftstone", Item::new, new Item.Properties());
}
