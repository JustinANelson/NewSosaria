package com.thoughtfoundry.newsosaria.data;

import com.thoughtfoundry.newsosaria.events.Moderation;
import com.thoughtfoundry.newsosaria.events.RoleButton;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.ArrayList;

public class BotCollections {

    public static ArrayList<Moderation> moderations = new ArrayList<>();
    public static ArrayList<RoleButton> roleButtons = new ArrayList<>();

    public static ArrayList<SlashCommandData> slashCommands = new ArrayList<>();
    public static ArrayList<CommandData> userContextCommands = new ArrayList<>();
    public static ArrayList<CommandData> messageContextCommands = new ArrayList<>();
    public static ArrayList<CommandData> guildCommands = new ArrayList<>();
}
