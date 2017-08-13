package me.rigelmc.rigelmcmod.command;

import me.rigelmc.rigelmcmod.rank.Rank;
import me.rigelmc.rigelmcmod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Clear the chat", usage = "/<command>", aliases = "cc")
public class Command_clearchat extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        for (Player p : server.getOnlinePlayers())
        {
            for (int i = 0; i < 100; i++)
            {
                p.sendMessage("");
            }
        }
        FUtil.adminAction(sender.getName(), "Cleared the chat", true);
        return true;
    }
}
