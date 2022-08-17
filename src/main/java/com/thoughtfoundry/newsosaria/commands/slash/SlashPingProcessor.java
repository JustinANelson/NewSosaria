package com.thoughtfoundry.newsosaria.commands.slash;


import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractSlashCommander;
import com.thoughtfoundry.newsosaria.commands.CommandCategory;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashPingProcessor extends AbstractSlashCommander {

    public SlashPingProcessor(){
        super(CommandCategory.UTILS);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event){
        long time = System.currentTimeMillis();
        event.reply("Pong!").setEphemeral(true) // reply or acknowledge
                .flatMap(v ->
                        event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time) // then edit original
                ).queue(); // Queue both reply and edit
    }
}
