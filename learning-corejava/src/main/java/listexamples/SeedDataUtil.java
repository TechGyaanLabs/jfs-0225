package listexamples;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

public class SeedDataUtil {


    public static List<Player> loadPlayers(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(SeedDataUtil.class.getResourceAsStream("/players.json"), new TypeReference<List<Player>>() {});
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return Collections.emptyList();
    }
}
