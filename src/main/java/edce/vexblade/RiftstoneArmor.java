package edce.vexblade;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

import static edce.vexblade.ModItems.register;


public class RiftstoneArmor {
    public static final int BASE_DURABILITY = 15;
    public static final ResourceKey<EquipmentAsset> RIFTSTONE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "riftstone"));
    public static final TagKey<Item> REPAIRS_RIFTSTONE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "repairs_riftstone_armor"));

    public static void InitalizeRiftstoneArmor(){
        //Init armor class
    }
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
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




    //ITEMS
    public static final Item RIFTSTONE_HELMET = register(
            "riftstone_helmet",
            Item::new,
            new Item.Properties().humanoidArmor(INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(BASE_DURABILITY))
    );
    public static final Item RIFTSTONE_CHESTPLATE = register(
            "riftstone_chestplate",
            Item::new,
            new Item.Properties().humanoidArmor(INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(BASE_DURABILITY))
    );

    public static final Item RIFTSTONE_LEGGINGS = register(
            "riftstone_leggings",
            Item::new,
            new Item.Properties().humanoidArmor(INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(BASE_DURABILITY))
    );

    public static final Item RIFTSTONE_BOOTS = register(
            "riftstone_boots",
            Item::new,
            new Item.Properties().humanoidArmor(INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(BASE_DURABILITY))
    );
}
