package com.thoughtfoundry.newsosaria.commands;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.MessageCommander;
import com.thoughtfoundry.newsosaria.commands.commandprocessors.UserContextCommander;
import com.thoughtfoundry.newsosaria.commands.commandprocessors.SlashCommander;
import com.thoughtfoundry.newsosaria.commands.context.UserContextMuteProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashEchoProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashFeedbackProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashMenuProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashModProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashPingProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashPrefixProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashPurgeProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashRoleButtonProcessor;
import com.thoughtfoundry.newsosaria.commands.slash.SlashTimeProcessor;

import java.util.ArrayList;

public class Commands {
    public static ArrayList<SlashCommander> slashCommands = new ArrayList<>();
    public static ArrayList<UserContextCommander> userContextCommands = new ArrayList<>();
    public static ArrayList<MessageCommander> messageCommands = new ArrayList<>();

    public static void register(){
        CommandGenerators.create();
        new SlashEchoProcessor();
        new SlashFeedbackProcessor();
        new SlashMenuProcessor();
        new SlashModProcessor();
        new SlashPingProcessor();
        new SlashPrefixProcessor();
        new SlashPurgeProcessor();
        new SlashRoleButtonProcessor();
        new SlashTimeProcessor();

        new UserContextMuteProcessor();
    }

    public static void registerSlashCommand(SlashCommander slashCommander){
        slashCommands.add(slashCommander);
    }

    public static void registerUserContextCommand(UserContextCommander userContextCommander) {
        userContextCommands.add(userContextCommander);
    }

    public static void registerMessageCommand(MessageCommander messageCommander){
        messageCommands.add(messageCommander);
    }
}
