package lesson3.task2;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Planet{
    private final String name;
    private final Set<IArea> list = new HashSet();
    Planet(String planetName){
        if(planetName==null){throw new IllegalArgumentException("Planet name is null");}
        this.name = planetName;
    }

    Planet(){
        this.name = "Earth";
    }

    Planet add(IArea area){
        if(area==null){return this;}
        for(IArea iA:list){
            if(iA==area){return this;}
        }
        list.add(area);
        return this;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for(IArea iA:list){
            sj.add(iA.getName() + " - " + iA.getType());
        }

        return "Planet The " + name + " contains:\n" + sj;
    }

    int getOceansCount(){
        return countAllByType(IArea.Type.Ocean);
    }
    
    int getContinentsCount(){
        return countAllByType(IArea.Type.Continent);
    }
    
    int getIslandsCount(){
        return countAllByType(IArea.Type.Island);
    }

    int countAllByType(IArea.Type type){
        return (int)list
                .stream()
                .filter(x->x.getType()==type)
                .count();
    }
}
