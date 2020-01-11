package io.github.cottonmc.resources.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.cottonmc.resources.tag.DimensionTypeTags;
import net.fabricmc.fabric.impl.dimension.DimensionIdsFixer;
import net.minecraft.server.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.tag.Tag;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

import java.util.Map;

public class TagTestCommand {
	public static int biomes(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

		return 1;
	}

	public static int dimensions(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		ServerCommandSource source = context.getSource();
		source.sendFeedback(new LiteralText("DimensionType tag has the following tags:"), false);

		for (Map.Entry<Identifier, Tag<DimensionType>> value : DimensionTypeTags.getContainer().getEntries().entrySet()) {
			source.sendFeedback(new LiteralText(value.getKey().toString()), false);
			source.sendFeedback(new LiteralText("Contains values:"), false);
			Tag<DimensionType> tag = DimensionTypeTags.getContainer().get(value.getKey());

			for (DimensionType dimensionType : tag.values()) {
				source.sendFeedback(new LiteralText(DimensionType.getId(dimensionType).toString()), false);
			}

		}
		return 1;
	}
}
