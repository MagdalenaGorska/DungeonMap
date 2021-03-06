package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Room {
    private String source;
    private Map<Character, String> directionAndDestination;

    public Room(String source){
        this.source=source;
        this.directionAndDestination = new HashMap();
    }

    public void addPath(Character direction, String destination){
        directionAndDestination.put(direction, destination);
    }
}
