package io.github.cottonmc.resources.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.cottonmc.resources.tag.BiomeTags;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class BiomeTagTestCommand implements Command<ServerCommandSource> {

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();
        System.out.println(BiomeTags.CONTAINER.getEntries().size());
        BiomeTags.CONTAINER.getEntries().forEach((a,b)->System.err.println(a + ":" + b));
        return 1;
    }
}
