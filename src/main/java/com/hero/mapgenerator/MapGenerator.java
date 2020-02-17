package com.hero.mapgenerator;


import com.sun.deploy.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

import static com.oracle.jrockit.jfr.ContentType.Bytes;

@Slf4j

public class MapGenerator {
    private byte sizeX;
    private byte sizeY;

    private byte[] mapArray= new byte[200];
   private static Map<Byte,byte[]> locationList= new HashMap<>();
    public MapGenerator(byte sizeX, byte sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }



    public static Map generateUUIDForLocation()
    {

        locationList.put((byte)10,generateUUID());// water
        locationList.put((byte)0,generateUUID());//forest
        locationList.put((byte)1,generateUUID());//mountains
        locationList.put((byte)11,generateUUID());//road
        locationList.put((byte)100,generateUUID());//river
        locationList.put((byte)101,generateUUID());//sand
        locationList.put((byte)110,generateUUID());//meadow
        locationList.put((byte)111,generateUUID());//swamp
        locationList.put((byte)1111,generateUUID());//place where we can come in
        log.info(locationList.toString());
        return locationList;
    }



    public static byte[] generateUUID() {

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

    public void getLocation(byte[] currentUUID)
    {

        for (Map.Entry<Byte, byte[]> entry : locationList.entrySet()) {
        byte[] UUID=entry.getValue();

        if (Arrays.equals(UUID,currentUUID)) {
           log.info(entry.getKey().toString());
        }

    }


    }

    public byte getSizeX() {
        return sizeX;
    }

    public byte[] createMapArray() {
        List<byte[]> valuesListOfLocation = new ArrayList<byte[]>(generateUUIDForLocation().values());

        int i=0;
        int j=0;
while(i<=sizeY) {

        mapArray[j] = (byte) 3;

        mapArray[j + 1] = (byte) 5;
    int randomIndex = new Random().nextInt(valuesListOfLocation.size());
    byte[] randomUUIDLocationFromList = valuesListOfLocation.get(randomIndex);
        System.arraycopy(randomUUIDLocationFromList, 0, mapArray, j + 2,randomUUIDLocationFromList.length );
        i++;
        j+=18;

}

        return mapArray;
        }


    @Override
    public String toString() {
        return Arrays.toString(mapArray) ;

    }
}


