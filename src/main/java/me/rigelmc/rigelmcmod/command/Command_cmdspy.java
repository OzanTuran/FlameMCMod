package me.rigelmc.rigelmcmod.command;

import me.rigelmc.rigelmcmod.player.FPlayer;
import me.rigelmc.rigelmcmod.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Spy on commands", usage = "/<command>", aliases = "commandspy")
public class Command_cmdspy extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        FPlayer playerdata = plugin.pl.getPlayer(playerSender);
        playerdata.setCommandSpy(!playerdata.cmdspyEnabled());
        msg("CommandSpy " + (playerdata.cmdspyEnabled() ? "enabled." : "disabled."));

        return true;
    }
}
