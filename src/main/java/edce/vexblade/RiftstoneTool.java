package edce.vexblade;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class RiftstoneTool {

    public static final int BASE_DURABILITY = 15;
    public static final ResourceKey<EquipmentAsset> RIFTSTONE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "riftstone"));
    public static final TagKey<Item> REPAIRS_RIFTSTONE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "repairs_riftstone_armor"));

    public static void InitalizeTools(){
        //Initalizes tools.
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(RIFTSTONE_SWORD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(RIFTSTONE_PICKAXE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(RIFTSTONE_AXE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(RIFTSTONE_SHOVEL));
    }
    public static final ArmorMaterial RiftstoneArmorMaterial = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 9,
                    ArmorType.LEGGINGS, 7,
                    ArmorType.BOOTS, 3
            ),
            5,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            REPAIRS_RIFTSTONE_ARMOR,
            RIFTSTONE_ARMOR_MATERIAL_KEY
    );


    public static final ToolMaterial RIFTSTONE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            2300,
            9.5F,
            4.5F,
            18,
            REPAIRS_RIFTSTONE_ARMOR
    );




    //ITEM TIMEEEE
    public static final Item RIFTSTONE_SWORD = ModItems.register(
            "riftstone_sword",
            Item::new,
            new Item.Properties().sword(RIFTSTONE_TOOL_MATERIAL, 3f, -2.4f)
    );
    public static final Item RIFTSTONE_PICKAXE = ModItems.register(
            "riftstone_pickaxe",
            Item::new,
            new Item.Properties().pickaxe(RIFTSTONE_TOOL_MATERIAL, 1f, -2.8f)
    );
    public static final Item RIFTSTONE_AXE = ModItems.register(
            "riftstone_axe",
            Item::new,
            new Item.Properties().axe(RIFTSTONE_TOOL_MATERIAL, 5f, -3f)
    );
    public static final Item RIFTSTONE_SHOVEL = ModItems.register(
            "riftstone_shovel",
            Item::new,
            new Item.Properties().shovel(RIFTSTONE_TOOL_MATERIAL, 1.5f, -3f)
    );

}
