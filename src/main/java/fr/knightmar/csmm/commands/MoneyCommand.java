package fr.knightmar.csmm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.data.capability.CoinStorage;
import fr.knightmar.csmm.data.capability.ICoinCapability;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.LazyOptional;

public class MoneyCommand {
    public MoneyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money").requires((perm) -> {
                    return perm.hasPermission(2);
                }).then(Commands.literal("set")
                        .then(Commands.argument("target", EntityArgument.players())
                                .then(Commands.argument("count", IntegerArgumentType.integer(1)).executes((command) -> {
                                    return setMoney(command.getSource(), EntityArgument.getPlayer(command, "target"), IntegerArgumentType.getInteger(command, "count"));
                                }))))


                .then(Commands.literal("get")
                        .then(Commands.argument("target", EntityArgument.players()).executes((command) -> {
                            return getMoney(command.getSource(), EntityArgument.getPlayer(command, "target"));
                        })))
                .then(Commands.literal("add")
                        .then(Commands.argument("target", EntityArgument.players())
                                .then(Commands.argument("count", IntegerArgumentType.integer(1)).executes((command) -> {
                                    return addMoney(command.getSource(), EntityArgument.getPlayer(command, "target"), IntegerArgumentType.getInteger(command, "count"));
                                })))));


    }

    private static int setMoney(CommandSourceStack source, ServerPlayer target, int count) throws CommandSyntaxException {
        LazyOptional<ICoinCapability> coin_capability = target.getCapability(CoinCapability.COIN_CAPABILITY);
        coin_capability.ifPresent(cap -> cap.setCoin(count));

        int coin = coin_capability.orElse(new CoinStorage()).getCoin();

        source.getPlayerOrException().sendMessage(new TextComponent(target.getName().getString() + " est maintenant a " + coin + " coins."), source.getPlayerOrException().getUUID());
        return 1;
    }


    private static int addMoney(CommandSourceStack source, ServerPlayer target, int count) throws CommandSyntaxException {
        LazyOptional<ICoinCapability> coin_capability = target.getCapability(CoinCapability.COIN_CAPABILITY);
        coin_capability.ifPresent(cap -> cap.addCoin(count));

        int coin = coin_capability.orElse(new CoinStorage()).getCoin();

        source.getPlayerOrException().sendMessage(new TextComponent(target.getName().getString() + " est maintenant a " + coin + " coins."), source.getPlayerOrException().getUUID());
        return 1;
    }


    public static int getMoney(CommandSourceStack source, ServerPlayer target) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();

        LazyOptional<ICoinCapability> capa = target.getCapability(CoinCapability.COIN_CAPABILITY);
        int coin = capa.orElse(new CoinStorage()).getCoin();

        player.sendMessage(new TextComponent(target.getName().getString() + " a actuellement " + coin + " coins."), source.getPlayerOrException().getUUID());
        return 1;
    }
}
