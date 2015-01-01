package com.example;

import org.apache.log4j.Logger;
import java.io.InputStream;


public class App {
    private static final Logger log = Logger.getLogger(App.class);
    private InputStream is = null;

    public static void main(String[] args) throws Exception {

        log.debug("Starting ...");

        String[] nothing = {""};

        ForkBlur.main(nothing);
    }

    public App() {
        is = getClass().getResourceAsStream("/test.properties");
    }
}
