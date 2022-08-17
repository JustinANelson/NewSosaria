package com.thoughtfoundry.newsosaria.commands.slash;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractSlashCommander;
import com.thoughtfoundry.newsosaria.commands.CommandCategory;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashMenuProcessor extends AbstractSlashCommander {

    public SlashMenuProcessor() {
        super(CommandCategory.MODERATION);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        trace(this.getClass().getSimpleName() + " executed.");

    }
}
