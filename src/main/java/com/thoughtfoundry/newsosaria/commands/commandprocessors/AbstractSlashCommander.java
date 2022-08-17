package com.thoughtfoundry.newsosaria.commands.commandprocessors;

import com.thoughtfoundry.newsosaria.commands.CommandCategory;
import com.thoughtfoundry.newsosaria.commands.Commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public abstract class AbstractSlashCommander implements SlashCommander {
    public final Logger log = LoggerFactory.getLogger(this.getClass());
    public String name = this.getClass().getSimpleName().toLowerCase(Locale.ROOT);
    public final CommandCategory thisCategory;

    public AbstractSlashCommander(CommandCategory category) {
        thisCategory = category;
        Commands.registerSlashCommand(this);
    }

    protected void info(String message){ log.info(message); }
    protected void error(String message){ log.error(message); }
    protected void debug(String message){ log.debug(message); }
    protected void trace(String message){ log.trace(message); }
    protected void warn(String message){ log.warn(message); }

    public void read(){
        System.out.println(this.getName());
    }
    public String getName(){ return this.name; }

    public void logExecution() {
        trace(this.getClass().getSimpleName() + " executed.");
    }

}


