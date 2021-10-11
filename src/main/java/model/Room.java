package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Room {
    private String source;
    private Map<Character, String> directionAndDestination;
    @Setter
    private boolean isActive;

    public Room(String source) {
        this.source = source;
        this.directionAndDestination = new HashMap();
        this.isActive = false;
    }


    public void addPath(Character direction, String destination) {
        directionAndDestination.put(direction, destination);
    }


}

