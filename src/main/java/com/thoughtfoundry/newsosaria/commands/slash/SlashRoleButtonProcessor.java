package com.thoughtfoundry.newsosaria.commands.slash;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.AbstractSlashCommander;
import com.thoughtfoundry.newsosaria.commands.CommandCategory;
import com.thoughtfoundry.newsosaria.events.RoleButton;
import com.thoughtfoundry.newsosaria.utility.Util;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Random;

public class SlashRoleButtonProcessor extends AbstractSlashCommander {

    public SlashRoleButtonProcessor() {
        super(CommandCategory.MODERATION);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        trace(this.getClass().getSimpleName() + " executed");

        long eventID = new Random().nextLong();

        //Here we are generating a new long to use as the eventID
        //If the button is toggleable we are going to preface the ID with a 1
        //If the button is not toggleable we will preface with a 0.
        String eventIDString = null;

        OptionMapping option = event.getOptions().stream().filter(e -> e.getName().equals("rolebuttontoggle")).findAny().orElse(null);
        if (option != null) {
            if (option.getAsBoolean()) {
                eventIDString = "1" + eventID;
            } else {
                eventIDString = "0" + eventID;
            }
        }

        MessageEmbed msgEmbed;
        OptionMapping option2 = event.getOptions().stream().filter(e -> e.getName().equals("rolebuttondescription")).findAny().orElse(null);
        if (option2 != null){
            msgEmbed = Util.basicMessageEmbed(event.getOption("rolebuttondescription").getAsString());
        } else {
            msgEmbed = Util.basicMessageEmbed("Click button for role.");
        }
        
        Role role = event.getOption("rolebuttonrole").getAsRole();
        eventIDString = eventIDString + role.getId();
        String label = role.getName();
        event.replyEmbeds(msgEmbed)
                .addActionRow(
                        Button.primary(eventIDString, label) // Button with only a label
                ).queue();

        //Creates new roleButton which adds itself to the roleButtons Collection
        new RoleButton(eventIDString, label);
    }
}
