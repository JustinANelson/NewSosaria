package com.thoughtfoundry.newsosaria.commands.slash;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractSlashCommander;
import com.thoughtfoundry.newsosaria.commands.CommandCategory;
import com.thoughtfoundry.newsosaria.utility.Util;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashEchoProcessor extends AbstractSlashCommander {

    public SlashEchoProcessor(){
        super(CommandCategory.UTILS);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event){
        logExecution();
        if (event.getOption("msg") != null) {
            if (event.getOption("channelid") != null) {
                TextChannel channel = (TextChannel) event.getGuild().getGuildChannelById(event.getOption("channelid").getAsString());
                channel.sendMessageEmbeds(Util.basicMessageEmbed(event.getOption("msg").getAsString())).queue();
            }
            event.replyEmbeds(Util.basicMessageEmbed(event.getOption("msg").getAsString())).queue();
        }
    }
}
