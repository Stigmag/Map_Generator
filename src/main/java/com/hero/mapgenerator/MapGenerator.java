package com.hero.mapgenerator;


import com.sun.deploy.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static com.oracle.jrockit.jfr.ContentType.Bytes;

@Slf4j

public class MapGenerator {
    private byte sizeX;
    private byte sizeY;

    private byte[] mapArray= new byte[200];

    public MapGenerator(byte sizeX, byte sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public static UUID getUUIDFromBytes(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Long high = byteBuffer.getLong();
        Long low = byteBuffer.getLong();

        return new UUID(high, low);
    }
    public byte[] fillMap() {

        UUID uuid = UUID.randomUUID();
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        log.debug(bb.toString());
        return bb.array();
    }

    public byte[] getMapArray() {
        return mapArray;
    }

    public byte[] createMapArray() {
        int i=0;
        int j=0;
while(i<=sizeY) {

        mapArray[j] = (byte) 3;

        mapArray[j + 1] = (byte) 5;

        System.arraycopy(fillMap(), 0, mapArray, j + 2, fillMap().length);
        i++;
        j+=17;

}

        return mapArray;
        }


    @Override
    public String toString() {
        return Arrays.toString(mapArray) ;

    }
}


