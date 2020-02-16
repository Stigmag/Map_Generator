package com.hero.mapgenerator;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
public class App {
    public static void main(String[] args) {
        MapGenerator map = new MapGenerator((byte) 5, (byte) 5);
        map.createMapArray();
        try {
            FileParser.saveMapInFile(map);
        } catch (IOException e) {
            log.info("Fucking ERROR");
        }
        try {
            byte[] myMap = FileParser.readMapFromFile("Map");
        } catch (IOException e) {
            log.info("Fucking ERROR");
        }


    }
}
