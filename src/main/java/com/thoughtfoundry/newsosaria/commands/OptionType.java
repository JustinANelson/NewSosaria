package com.thoughtfoundry.newsosaria.commands;

import com.thoughtfoundry.newsosaria.utility.Util;

public enum OptionType {
    GENERAL, SPECIFIC, COMMAND, GUILD, CHANNEL, USER, MUSIC, MODERATION;

    @Override
    public String toString() {
        return Util.capitalize(this.name().toLowerCase());
    }
}