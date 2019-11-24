package io.github.cottonmc.resources.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.cottonmc.resources.tag.BiomeTags;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class BiomeTagTestCommand implements Command<ServerCommandSource> {

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        context.getSource().sendFeedback(new LiteralText("Tags: "), false);
        BiomeTags.getContainer().getKeys().forEach(key -> context.getSource().sendFeedback(new LiteralText(key.toString()), false));
        return 1;
    }
}
