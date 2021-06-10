
import java.util.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!command.equals("Tournament")){

            String[] data = command.split("\\s+");
            //"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>"
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if(!trainers.containsKey(trainerName)){
                Trainer trainer = new Trainer(trainerName);
                trainers.put(trainerName, trainer);
            }
                trainers.get(trainerName).add(pokemon);

            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("End")){
            String toMach = command;
            long count = 0;
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
              count =  entry.getValue()
                     .getPokemons().stream()
                     .filter(pokemon -> pokemon.getElement().equals(toMach)).count();
                  if(count > 0){
                      entry.getValue().setBadges(1);
                  }else{
                      entry.getValue().getPokemons().forEach(pokemon -> pokemon.setHealth());
                      entry.getValue().setPokemons(entry.getValue().getPokemons().stream()
                              .filter(pokemon -> pokemon.getHealth() > 0)
                              .collect(Collectors.toList()));

                  }
            }
            command = scanner.nextLine();
        }
         trainers.values().stream()
                .sorted((a, b) -> Integer.compare(b.getBadges(), a.getBadges()))
                .forEach(trainer -> System.out.println(trainer.toString()));
    }
}