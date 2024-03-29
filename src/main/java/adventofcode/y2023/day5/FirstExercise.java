package adventofcode.y2023.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FirstExercise {

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
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(line);

                matcher.results().forEach(m -> seeds.add(new Seed(Long.parseLong(m.group()))));
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

        //ciclo su tutti i semi
        for(Seed seed : seeds) {

            //per ogni seme prendo la lista di stages
            for(List<Step> l : stages) {

                //per ogni stage prendo la lista di step
                for(Step step : l) {
                    long location = seed.getLocation();
                    long source = step.getSource();
                    long range = step.getRange();
                    long dest = step.getDestination();

                    if(source <= location && location <= source+range-1) {
                        long diff = location - source;
                        seed.setLocation(dest+diff);
                        break;
                    }
                }

            }
        }

        long lowestLocation = seeds.stream().mapToLong(Seed::getLocation).min().getAsLong();

        System.out.println(lowestLocation);
    }

}
