package com.thoughtfoundry.newsosaria.commands.commandprocessors;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;

public interface MessageCommander {
    void execute(MessageContextInteractionEvent event);
    void read();
    String getName();
}
