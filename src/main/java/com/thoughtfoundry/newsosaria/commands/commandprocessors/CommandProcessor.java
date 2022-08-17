package com.thoughtfoundry.newsosaria.commands.commandprocessors;

import com.thoughtfoundry.newsosaria.commands.Commands;
import com.thoughtfoundry.newsosaria.data.Metrics;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

public class CommandProcessor {

    // This entire package could benefit from being generified but I don't know how yet.

    public void process(SlashCommandInteractionEvent event){
        if (event.getGuild() == null) {
            event.deferReply(true)
                    .setContent("This bot does not accept commands in Private Messages. Please add it to your guild.")
                    .queue();
            return;
        }

        final var start = System.nanoTime();
        var eventName = "slash" + event.getName() + "processor";
        Commands.slashCommands.stream()
                .filter(s -> eventName.equals(s.getName()))
                .findAny().ifPresent(e -> e.execute(event));

        final var end = System.nanoTime();
        Metrics.latency(start, end, event.getName());
        Metrics.commandCounter();
    }

    public void process(UserContextInteractionEvent event) {
        if (event.getGuild() == null) {
            event.deferReply(true)
                    .setContent("This bot does not accept commands in Private Messages. Please add it to your guild.")
                    .queue();
            return;
        }

        final var start = System.nanoTime();
        var eventName = event.getName() + "processor";
        Commands.userContextCommands.stream()
                .filter(s -> eventName.equals(s.getName()))
                .findAny().ifPresent(e -> e.execute(event));

        final var end = System.nanoTime();
        Metrics.latency(start, end, event.getName());
        Metrics.commandCounter();
    }

    public void process(MessageContextInteractionEvent event) {
        if (event.getGuild() == null) {
            event.deferReply(true)
                    .setContent("This bot does not accept commands in Private Messages. Please add it to your guild.")
                    .queue();
            return;
        }

        final var start = System.nanoTime();
        var eventName = event.getName() + "processor";
        Commands.messageCommands.stream()
                .filter(s -> eventName.equals(s.getName()))
                .findAny().ifPresent(e -> e.execute(event));

        final var end = System.nanoTime();
        Metrics.latency(start, end, event.getName());
        Metrics.commandCounter();
    }
}
