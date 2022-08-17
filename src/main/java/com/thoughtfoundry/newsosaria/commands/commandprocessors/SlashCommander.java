package com.thoughtfoundry.newsosaria.commands.commandprocessors;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface SlashCommander {
    void execute(SlashCommandInteractionEvent event);
    void read();
    String getName();
}
