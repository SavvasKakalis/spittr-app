import java.util.ArrayList;
import java.util.List;

public class SpittrService {

    private List<Spitter> spitters = new ArrayList<>();
    private static Long spitterId = 0L;
    private List<Spittle> spittles = new ArrayList<>();
    private static Long spittleId = 0L;

    public void createSpitter(Spitter spitter) {
        spitters.add(spitter);
        spitter.setId(++spitterId);
    }

    public Spitter findSpitterById(Long spitterId) {
        for (Spitter spitter : spitters) {
            if (spitter.getId() == spitterId) {
                return spitter;
            }
        }
        return null;
    }

    public List<Spitter> findAllSpitters() {
        return spitters;
    }

    public void updateSpitter(Spitter spitter) {
        int index = spitters.indexOf(findSpitterById(spitter.getId()));
        spitters.set(index, spitter);
    }

    public void deleteSpitter(Spitter spitter) {
        spitters.removeIf(s -> s.getId().equals(spitter.getId()));
    }

    public void createSpittle(Spittle spittle) {
        spittles.add(spittle);
        spittle.setId(++spittleId);
    }

    public Spittle findSpittleById(Long spittleId) {
        for (Spittle spittle : spittles) {
            if (spittle.getId() == spittleId) {
                return spittle;
            }
        }
        return null;
    }

    public List<Spittle> findSpittlesBySpitter(Spitter searchedSpitter) {
        List<Spittle> spittlesBySpitter = new ArrayList<>();
        for (Spittle spittle : spittles) {
            if (spittle.getSpitter().getId() == searchedSpitter.getId()) {
                spittlesBySpitter.add(spittle);
            }
        }
        return spittlesBySpitter;
    }

    public void updateSpittle(Spittle spittle) {
        int index = spittles.indexOf(findSpittleById(spittle.getId()));
        spittles.set(index, spittle);
    }

    public void deleteSpittle(Spittle spittle) {
        spittles.removeIf(s -> s.getId().equals(spittle.getId()));
    }

    public List<Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(List<Spitter> spitters) {
        this.spitters = spitters;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }
}
