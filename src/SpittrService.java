import java.util.HashMap;
import java.util.Map;

public class SpittrService {

    private Map<Integer, Spitter> spitters = new HashMap<>();
    private Map<Integer, Spittle> spittles = new HashMap<>();
    private Integer spitterId = 1;
    private Integer spittleId = 1;


    public void createSpitter(Spitter spitter) {
        spitters.put(spitterId++, spitter);
    }

    public Spitter findSpitterById(Long spitterId) {
        return spitters.get(spitterId);
    }

    public Map<Integer, Spitter> findAllSpitters() {
        return spitters;
    }

    public void updateSpitter(Integer spitterId, Spitter spitter) {
        spitters.put(spitterId, spitter);
    }

    public void deleteSpitter(Integer spitterId) {
        spitters.remove(spitterId);
    }

    public void createSpittle(Spittle spittle) {
        spittles.put(spittleId++, spittle);
    }

    public Spittle findSpittleById(Long spittleId) {
        return spittles.get(spittleId);
    }

    public Map<Integer, Spittle> findSpittlesBySpitter(String searchedUsername) {
        Map<Integer, Spittle> spittlesBySpitter = new HashMap<>();
        for (Map.Entry<Integer, Spittle> entry : spittles.entrySet()) {
            if (entry.getValue().getSpitter().getUsername().equals(searchedUsername)) {
                spittlesBySpitter.put(entry.getKey(), entry.getValue());
            }
        }
        return spittlesBySpitter;
    }

    public void updateSpittle(Integer spittleId, Spittle spittle) {
        spittles.put(spittleId, spittle);
    }

    public void deleteSpittle(Integer spittleId) {
        spittles.remove(spittleId);
    }

    public Map<Integer, Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(Map<Integer, Spitter> spitters) {
        this.spitters = spitters;
    }

    public Map<Integer, Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(Map<Integer, Spittle> spittles) {
        this.spittles = spittles;
    }
}
