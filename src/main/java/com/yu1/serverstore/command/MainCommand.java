package com.yu1.serverstore.command;


import com.yu1.serverstore.Main;
import com.yu1.serverstore.command.commands.Open;
import com.yu1.serverstore.command.commands.Reload;
import com.yu1.serverstore.util.SendMsgUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {
    Main INSTANCE = Main.getInstance();
    public void helpMessage(CommandSender sender)
    {
        for(String msg : INSTANCE.getConfig().getConfigurationSection("Commands").getKeys(false))
        {
            sender.sendMessage(SendMsgUtil.getConfig("Commands." + msg));
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (args.length == 0) {
            helpMessage(sender);
        }else{
            switch (args[0]) {
                case "reload":
                    new Reload(sender);
                    break;
                case "open":
                    new Open(sender,args);
                    break;
                default:
                    helpMessage(sender);
                    break;
            }
        }
        return false;
    }
}
