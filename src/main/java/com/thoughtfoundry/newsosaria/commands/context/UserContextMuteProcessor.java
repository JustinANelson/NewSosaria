package com.thoughtfoundry.newsosaria.commands.context;

import com.thoughtfoundry.newsosaria.commands.CommandCategory;
import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractUserContactCommander;
import com.thoughtfoundry.newsosaria.utility.Util;

import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

/*
    Currently not operational.
    Need to send the success message to a specified channel.
 */
public class UserContextMuteProcessor extends AbstractUserContactCommander {

    public UserContextMuteProcessor() {
        super(CommandCategory.MODERATION);
    }

    @Override
    public void execute(UserContextInteractionEvent event) {
        Util.standardSuccess(event);
    }

    @Override
    public String getName() {
        return null;
    }
}
