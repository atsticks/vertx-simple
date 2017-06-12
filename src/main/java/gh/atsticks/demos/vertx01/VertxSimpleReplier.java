package gh.atsticks.demos.vertx01;/*
 * (C) Copyright 2015-2017 Trivadis AG. All rights reserved.
 */

import io.vertx.core.AbstractVerticle;

/**
 * Created by atsticks on 12.06.17.
 */
public class VertxSimpleReplier extends AbstractVerticle{

    @Override
    public void start() throws Exception {
        super.start();
        vertx.createHttpServer().requestHandler(req -> {
            req.response().setChunked(true);
            req.response().write("Thread: " + Thread.currentThread().getName())
            .write("\nVerticle: " + super.hashCode())
            .write("\nInstance: " + System.getenv("HOSTNAME")).end();})
                .listen(8088);
    }
}
