package com.thoughtfoundry.newsosaria.commands;

import com.thoughtfoundry.newsosaria.data.BotCollections;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class CommandGenerators {
    public static void create() {
        createSlashCommands();
        createUserContextCommands();
        createMessageContextCommands();
        combineCommandLists();
    }
    public static void createSlashCommands() {
        BotCollections.slashCommands.add(Commands.slash("echo", "Replies with the message you send.")
                .addOption(OptionType.STRING, "msg", "msg to echo", true)
                .addOption(OptionType.CHANNEL, "channelid", "channel to send message to", false));
        BotCollections.slashCommands.add(Commands.slash("feedback", "Shows help modal."));
        BotCollections.slashCommands.add(Commands.slash("mod", "Brings up Mod Control Panel")
                .addOption(OptionType.MENTIONABLE, "mentionable", "User, Role, or Member.", false));
        BotCollections.slashCommands.add(Commands.slash("ping", "Calculate the ping of the bot."));
        BotCollections.slashCommands.add(Commands.slash("prefix", "returns the bot prefix"));
        BotCollections.slashCommands.add(Commands.slash("purge", "Replies with the message you send.")
                .addOption(OptionType.INTEGER, "amount", "Number of messages to purge", true));
        BotCollections.slashCommands.add(Commands.slash("rolebutton", "Adds a button that gives a role")
                .addOption(OptionType.ROLE, "rolebuttonrole", "Role to add", true)
                .addOption(OptionType.STRING, "rolebuttondescription", "description", false)
                .addOption(OptionType.BOOLEAN, "rolebuttontoggle", "is toggleable?", false));
        BotCollections.slashCommands.add(Commands.slash("time", "Displays a time conversion table.")
                .addOption(OptionType.BOOLEAN, "ephemeral", "Set false to make visible to everyone."));
        BotCollections.slashCommands.add(Commands.slash("test", "test generic event processor"));
    }
    public static void createUserContextCommands() {
        BotCollections.userContextCommands.add(Commands.user("mute"));
    }
    public static void createMessageContextCommands(){

    }
    public static void combineCommandLists(){
        BotCollections.guildCommands.addAll(BotCollections.slashCommands);
        BotCollections.guildCommands.addAll(BotCollections.userContextCommands);
        BotCollections.guildCommands.addAll(BotCollections.messageContextCommands);
    }
}
