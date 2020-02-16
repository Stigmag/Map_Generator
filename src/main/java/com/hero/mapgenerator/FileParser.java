package com.hero.mapgenerator;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.omg.IOP.Encoding;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileParser {
    public static void saveMapInFile(MapGenerator map) throws IOException {


        BufferedOutputStream bos = null;

        try {
            FileOutputStream fos = new FileOutputStream("Map");
            bos = new BufferedOutputStream(fos);
            bos.write(map.getMapArray());
        }finally {
            if(bos != null) {
                try  {
                    //flush and close the BufferedOutputStream
                    bos.flush();
                    bos.close();
                } catch(Exception e){}
            }
        }

    }



    public static byte[] readMapFromFile(String fileName) throws IOException {
        File file= new File(fileName);
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            throw new IOException("Could not completely read file " + file.getName() + " as it is too long (" + length + " bytes, max supported " + Integer.MAX_VALUE + ")");
        }

        // Create the byte array to hold the data
        byte[] map = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < map.length && (numRead=is.read(map, offset, map.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < map.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return map;
    }
}
