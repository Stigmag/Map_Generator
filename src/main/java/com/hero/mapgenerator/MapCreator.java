package com.hero.mapgenerator;

import lombok.AllArgsConstructor;


public class MapCreator {
     byte[] mapArray= {4,4,11,10,(byte)1111,1,0,1,110,101,100,100,(byte)1111,10,0,11,10,110};
    byte water=10;
    byte forest=0;
    byte mountains=1;
    byte road=11;
    byte river=100;
    byte sand=101;
    byte meadow=110;
    byte swamp=111;
    byte place=(byte)1111;

    public MapCreator() {
    }
}
