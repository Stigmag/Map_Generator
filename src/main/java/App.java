import com.hero.mapgenerator.FileParser;

import com.hero.mapgenerator.MapCreator;
import com.hero.mapgenerator.MapGenerator;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
public class App {
    public static void main(String[] args) {
       // MapGenerator map = new MapGenerator((byte) 20, (byte) 20);
        MapCreator map= new MapCreator();
      //  map.createMapArray();
        try {
            FileParser.saveMapInFile(map);
        } catch (IOException e) {
            log.info("Fucking ERROR");
        }
        try {int i = 0;
            byte[] myMap = FileParser.readMapFromFile("Map");
            log.info(myMap.toString());

        } catch (IOException e) {
            log.info("Fucking ERROR");
        }


    }
}
