import com.hero.mapgenerator.FileParser;
import com.hero.mapgenerator.MapGenerator;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
public class App {
    public static void main(String[] args) {
        MapGenerator map = new MapGenerator((byte) 10, (byte) 10);
        map.createMapArray();
        try {
            FileParser.saveMapInFile(map);
        } catch (IOException e) {
            log.info("Fucking ERROR");
        }
        try {int i = 0;
            byte[] myMap = FileParser.readMapFromFile("Map");
            for(int j=0; j<map.getSizeX();j++){

            byte[] currentUUID = new byte[16];
            System.arraycopy(myMap, i+2, currentUUID, 0, 16);
            i+=18;
            map.getLocation(currentUUID);
            }
        } catch (IOException e) {
            log.info("Fucking ERROR");
        }


    }
}
