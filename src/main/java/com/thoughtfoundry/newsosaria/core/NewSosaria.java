package com.thoughtfoundry.newsosaria.core;

import com.thoughtfoundry.newsosaria.commands.commandprocessors.CommandProcessor;
import com.thoughtfoundry.newsosaria.commands.Commands;
import com.thoughtfoundry.newsosaria.data.AppConfig;
import com.thoughtfoundry.newsosaria.db.DB;
import com.thoughtfoundry.newsosaria.events.ModalEventProcessor;
import com.thoughtfoundry.newsosaria.utility.Util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

public class NewSosaria {
    private static final Logger log = LoggerFactory.getLogger(NewSosaria.class);
    private static void info(String message) { log.info(message); }
    public static JDA jda;
    public static DB db;
    public NewSosaria(){ super(); }
    public static CommandProcessor commandProcessor;
    public static ModalEventProcessor modalEventProcessor;

    public static void main(String[] args) throws Exception {
        jda = JDABuilder.create(AppConfig.TOKEN, EnumSet.allOf(GatewayIntent.class))
                .disableCache(CacheFlag.ACTIVITY)
                .disableIntents(GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGE_TYPING)
                .setLargeThreshold(100)
                .useSharding(0, 1)
                .addEventListeners(new Listeners()).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("Loading..."));
        jda.awaitReady();
        start();
    }
    public static void start() {
        db = new DB();
        Commands.register();
        Util.registerTestGuildParameters();
        Util.registerGlobalCommands();
        commandProcessor = new CommandProcessor();
        modalEventProcessor = new ModalEventProcessor();

        info("Ready");
        jda.getPresence().setActivity(Activity.playing("Hackin' n Slashin'"));
        PingLoop loop = new PingLoop();
        Thread thread = new Thread(loop, "Ping");
        thread.start();
    }
}
