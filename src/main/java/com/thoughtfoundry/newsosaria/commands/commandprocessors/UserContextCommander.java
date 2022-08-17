package com.thoughtfoundry.newsosaria.commands.commandprocessors;

import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

public interface UserContextCommander {
    void execute(UserContextInteractionEvent event);
    void read();
    String getName();
}
