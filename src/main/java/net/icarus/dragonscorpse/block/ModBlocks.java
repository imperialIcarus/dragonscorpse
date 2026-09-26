package net.icarus.dragonscorpse.block;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    // Dragonite Block
    public static final Block DRAGONITE_BLOCK = registerBlock("dragonite_block", properties -> new Block(properties
            .strength(60f, 1200f)
            .mapColor(MapColor.COLOR_PURPLE)
            .sound(SoundType.NETHERITE_BLOCK)
            .requiresCorrectToolForDrops()));
    // Reinforced Endstone
    public static final Block REINFORCED_ENDSTONE = registerBlock("reinforced_end_stone", properties -> new Block(properties
            .strength(80f, 1200f)
            .pushReaction(PushReaction.IMMOVEABLE)
            .sound(SoundType.DEEPSLATE)
            .instrument(NoteBlockInstrument.DRAGON)
            .mapColor(MapColor.COLOR_YELLOW)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name), toRegister);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name),
                new BlockItem(block,
                        new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name)))));
    }
    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, Component... tooltip) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name))));
        registerBlockItem(name, toRegister, tooltip);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name), toRegister);
    }
    private static void registerBlockItem(String name, Block block, Component... tooltip) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name),
                new BlockItem(block,
                        new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name)))) {
                    @Override
                    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                        for (var component : tooltip) {
                            builder.accept(component);
                        }
                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                    }
                });
    }
    public static void registerModBlocks() {
        DragonSCorpse.LOGGER.info("Registering Mod Blocks for " + DragonSCorpse.MOD_ID);
    }
    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name), toRegister);
    }

}
