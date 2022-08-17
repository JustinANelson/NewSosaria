package com.thoughtfoundry.newsosaria.commands.slash;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractSlashCommander;
import com.thoughtfoundry.newsosaria.commands.CommandCategory;
import com.thoughtfoundry.newsosaria.utility.Util;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.List;

public class SlashPurgeProcessor extends AbstractSlashCommander {
    public SlashPurgeProcessor() {
        super(CommandCategory.MODERATION);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        trace(this.getClass().getSimpleName() + " executed");
        if(event.getMember().hasPermission(Permission.MANAGE_CHANNEL)){
            List<Message> messages = event.getChannel().getHistory().retrievePast(event.getOption("amount").getAsInt()).complete();
            event.getChannel().asTextChannel().deleteMessages(messages).queue();

        }
        Util.standardSuccess(event);
    }
}
