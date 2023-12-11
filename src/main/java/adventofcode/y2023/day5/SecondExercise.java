package adventofcode.y2023.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SecondExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2023/day5/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;
        long total = 0;

        List<Seed> seeds = new ArrayList<>();
        List<List<Step>> stages = new ArrayList<>();
        List<Step> steps = new ArrayList<>();

        List<Long> locations = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {
            if(line.equals("")) {
                continue;
            }

            if(line.contains("seeds")) {
                String[] arr = line.split(": ");
                String[] s = arr[1].split(" ");

                for(int i=0; i<s.length; i+=2) {
                    seeds.add(new Seed(Long.parseLong(s[i]), Long.parseLong(s[i+1])));
                }
                continue;
            }

            if(line.contains("map")) {
                if(!steps.isEmpty()) {
                    stages.add(steps);
                }
                steps = new ArrayList<>();
                continue;
            }

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(line);

            List<MatchResult>  matchers = matcher.results().collect(Collectors.toList());

            steps.add(new Step(Long.parseLong(matchers.get(1).group()), Long.parseLong(matchers.get(0).group()), Long.parseLong(matchers.get(2).group())));

        }
        stages.add(steps);

        //scorro la lista dei semi
        for(Seed seed : seeds) {

            //prendo il range del seme
            long range = seed.getRange();

            //scorro tutti i valori del seme
            for(int i=0; i<range; i++) {

                seed.setNewLocation(seed.getLocation());

                for(List<Step> l : stages) {

                    //per ogni stage prendo la lista di step
                    for(Step step : l) {
                        long location = seed.getNewLocation()+i;
                        long source = step.getSource();
                        long srange = step.getRange();
                        long dest = step.getDestination();

                        if(source <= location && location <= source+srange-1) {
                            long diff = location - source;
                            seed.setNewLocation(dest+diff);
                            break;
                        }
                    }

                }

                if(seed.getNewLocation() < seed.getLowestLocation() ) {
                    seed.setLowestLocation(seed.getNewLocation());
                    seed.setLowRange(i);
                }
            }

        }

        Long lowest = seeds.stream().mapToLong(Seed::getLowestLocation).min().getAsLong();

        Seed lowSeed = seeds.stream().filter(s -> s.getLowestLocation() == lowest).findFirst().get();

        System.out.println(lowSeed.getLocation() +  " " + (lowSeed.getLocation() + lowSeed.getLowRange()));
    }

}
