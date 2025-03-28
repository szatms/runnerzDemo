package Portfolio.JavaDev.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //azért kell, hogy a SPRING tudja hogy mizu
public class RunRepository {

    private List<Run> runs = new ArrayList<>(); //tároljuk a futásokat

    List<Run> findAll(){    //megtalálja az összes tárolt futást
        return runs;
    }

    Optional<Run> findById(Integer id){ //megkeres egy futást az ID alapján
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);   //megkeresi a futást amit szerkeszteni akarunk
        if (existingRun.isPresent())
            runs.set(runs.indexOf(existingRun.get()),run);  //ha megtalálja akkor átadja az új futás indexét
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id)); //eltávolítja azt a futást, amelyiknek átadtuk az ID-jét
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.OUTDOOR));

        runs.add(new Run(2,
                "Wednesday evening run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                6,
                Location.OUTDOOR));
    }
}