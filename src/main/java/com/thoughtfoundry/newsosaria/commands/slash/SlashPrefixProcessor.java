package com.thoughtfoundry.newsosaria.commands.slash;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractSlashCommander;
import com.thoughtfoundry.newsosaria.commands.CommandCategory;
import com.thoughtfoundry.newsosaria.data.AppConfig;
import com.thoughtfoundry.newsosaria.utility.Util;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashPrefixProcessor extends AbstractSlashCommander {

    public SlashPrefixProcessor(){
        super(CommandCategory.MODERATION);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event){
        trace(this.getClass().getSimpleName() + " executed");
        event.replyEmbeds(Util.basicMessageEmbed(AppConfig.prefix)).queue();
    }
}
