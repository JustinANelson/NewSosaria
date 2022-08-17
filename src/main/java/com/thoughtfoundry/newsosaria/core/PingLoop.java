package com.thoughtfoundry.newsosaria.core;

import static com.thoughtfoundry.newsosaria.core.NewSosaria.jda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingLoop implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(PingLoop.class);
    void info(String message){ log.info(message); }
    void error(String message){ log.error(message); }
    void debug(String message){ log.debug(message); }
    void trace(String message){ log.trace(message); }
    void warn(String message){ log.warn(message); }

    @Override
    public void run() {
        String message;
        while (true) {
            message = null;
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long ping = jda.getGatewayPing();
            message = "Gateway ping is " + ping;
            trace(message);
        }
    }
}
