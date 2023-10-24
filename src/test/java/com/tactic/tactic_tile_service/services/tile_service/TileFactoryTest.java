package com.tactic.tactic_tile_service.services.tile_service;

import org.junit.jupiter.api.Test;

class TileFactoryTest {
    @Test
    public void test1() {
        TileFactory tileFactory = new TileFactory();
        String[] leftUp = {"33.436","57.759"};
        String[] rightDown = {"33.456","57.789"};
        int zoom = 5;
        tileFactory.saveTiles(zoom, leftUp, rightDown);
    }
}