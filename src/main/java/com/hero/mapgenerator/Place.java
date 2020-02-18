package com.hero.mapgenerator;


import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

import static com.hero.mapgenerator.PlaceExample.SHAFT;

@Slf4j

public class Place {

private byte[] uuid= new byte[16];
private Point placeCoordinate;

    public Place(byte[] uuid, Point placeCoordinate) {
        this.uuid = uuid;
        this.placeCoordinate = placeCoordinate;
    }

    private static List<Place>placeList=new LinkedList<>();



    public static byte[] uuidShaft=generateUUID();
public static byte[] uuidCastle=generateUUID();
    public static List generateUUIDForPlace()
    {

        placeList.add(new Place(uuidShaft,new Point((byte)2,(byte)3)));
       placeList.add(new Place(uuidCastle, new Point((byte)4,(byte)9)));
        log.info(placeList.toString());
        return placeList;
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



   public static Place getPlace() {

  return placeList.get(2);

   }
}


