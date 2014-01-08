package evilcraft.commands;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.common.Configuration;
import evilcraft.api.Helpers;
import evilcraft.api.config.ConfigProperty;


public class CommandConfigSet extends CommandEvilCraft {
    
    private ConfigProperty config;
    private String name;
    public static Configuration CONFIGURATION;

    public CommandConfigSet(String name, ConfigProperty config) {
        this.name = name;
        this.config = config;
    }
    
    protected List<String> getAliases() {
        List<String> list = new LinkedList<String>();
        list.add(name);
        return list;
    }
    
    protected Map<String, ICommand> getSubcommands() {
        Map<String, ICommand> map = new HashMap<String, ICommand>();
        return map;
    }
    
    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring) {
        if(astring.length == 0 || astring.length > 1) {
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Please define one new value."));
        } else {
            Object newValue = Helpers.tryParse(astring[0], config.getValue());
            if(newValue != null) {
                CONFIGURATION.load();
                config.setValue(newValue);
                config.save(CONFIGURATION, true);
                CONFIGURATION.save();
                icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Updated "+name+" to: "+newValue.toString() + " (not updated in config file)"));
                // TODO: Why not updated in config? Config not changeable at runtime?
            } else {
                icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Invalid new value."));
            }
        }
    }

}
