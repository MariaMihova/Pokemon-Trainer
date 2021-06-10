import java.util.ArrayList;
import java.util.List;

public class Trainer {
//name, number of badges and a collection of pokemon
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void add(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setBadges(int badges) {
        this.badges += badges;
    }
    //"<TrainerName> <Badges> <NumberOfPokemon
    @Override
    public String toString(){
        return String.format("%s %d %d", getName(), getBadges(), this.pokemons.size());
    }
}
