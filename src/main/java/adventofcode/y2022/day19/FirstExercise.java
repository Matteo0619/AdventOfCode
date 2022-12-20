package adventofcode.y2022.day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("res/2022/day19/test.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<Blueprint> blueprints = new ArrayList<>();

        String line = null;
        while ((line = buffer.readLine()) != null) { //Blueprint 1: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 9 clay. Each geode robot costs 3 ore and 9 obsidian.

            String[] arr = line.split(" ");
            Robot ore = new Robot("Ore", Integer.parseInt(arr[6]), 0, 0);
            Robot clay = new Robot("Clay", Integer.parseInt(arr[12]), 0, 0);
            Robot obsidian = new Robot("Obsidian", Integer.parseInt(arr[18]), Integer.parseInt(arr[21]), 0);
            Robot geode = new Robot("Geode", Integer.parseInt(arr[27]), 0, Integer.parseInt(arr[30]));

            Blueprint blueprint = new Blueprint(ore, clay, obsidian, geode);
            blueprints.add(blueprint);
        }

        int max = 0;
        int c = 1;

        for(Blueprint bp : blueprints) {
            int ore = 0;
            int clay = 0;
            int obs = 0;
            int geode = 0;
            int oreR = 1;
            int clayR = 0;
            int obsR = 0;
            int geodeR = 0;
            int maxOre = findMaxUse("Ore", bp);
            int maxClay = findMaxUse("Clay", bp);
            int maxObs = findMaxUse("Obsidian", bp);

            for(int i=1; i<=24; i++) {
                if(canBuy(bp, "Geode", ore, clay, obs, oreR, clayR, obsR, 24-i, maxOre, maxClay, maxObs)) {
                    ore += oreR - bp.getGeode().getOre();
                    clay += clayR- bp.getGeode().getClay();
                    obs += obsR - bp.getGeode().getObsidian();
                    geode += geodeR;
                    geodeR++;
                } else if (canBuy(bp, "Obsidian", ore, clay, obs, oreR, clayR, obsR, 24-i, maxOre, maxClay, maxObs)) {
                    ore += oreR - bp.getObsidian().getOre();
                    clay += clayR- bp.getObsidian().getClay();
                    obs += obsR - bp.getObsidian().getObsidian();
                    geode += geodeR;
                    obsR++;
                } else if(canBuy(bp, "Clay", ore, clay, obs, oreR, clayR, obsR, 24-i, maxOre, maxClay, maxObs)) {
                    ore += oreR - bp.getClay().getOre();
                    clay += clayR- bp.getClay().getClay();
                    obs += obsR - bp.getClay().getObsidian();
                    geode += geodeR;
                    clayR++;
                } else if(canBuy(bp, "Ore", ore, clay, obs, oreR, clayR, obsR, 24-i, maxOre, maxClay, maxObs)) {
                    ore += oreR - bp.getOre().getOre();
                    clay += clayR- bp.getOre().getClay();
                    obs += obsR - bp.getOre().getObsidian();
                    geode += geodeR;
                    oreR++;
                } else {
                    ore += oreR;
                    clay += clayR;
                    obs += obsR;
                    geode += geodeR;
                }
            }

            max += geode * c;
            c++;
        }

        System.out.println(max);
    }

    public static int findMaxUse(String res, Blueprint bp) {
        switch (res) {
            case "Ore": {
                return Math.max(bp.getOre().getOre(), Math.max(bp.getClay().getOre(), Math.max(bp.getObsidian().getOre(), bp.getGeode().getOre())));
            }
            case "Clay": {
                return Math.max(bp.getOre().getClay(), Math.max(bp.getClay().getClay(), Math.max(bp.getObsidian().getClay(), bp.getGeode().getClay())));
            }
            case "Obsidian": {
                return Math.max(bp.getOre().getObsidian(), Math.max(bp.getClay().getObsidian(), Math.max(bp.getObsidian().getObsidian(), bp.getGeode().getObsidian())));
            }
        }
        return 0;
    }

    public static boolean canBuy(Blueprint bp, String name, int ore, int clay, int obs, int oreR, int clayR, int obsR, int time, int maxOre, int maxClay, int maxObs) {
        switch(name) {
            case "Geode" : {
                Robot robot = bp.getGeode();
                return ore >= robot.getOre() && clay >= robot.getClay() && obs >= robot.getObsidian();
            }
            case "Obsidian" : {
                Robot robot = bp.getObsidian();
                boolean buyObs =  ore >= robot.getOre() && clay >= robot.getClay();
                //boolean buyGeo = canBuy(bp, "Geode", ore+oreR, clay+clayR, obs+obsR, oreR, clayR, obsR);

                return buyObs;
            }
            case "Clay" : {
                Robot robot = bp.getClay();
                boolean buyClay = ore >= robot.getOre() && maxClay*time > clay;
                //boolean buyObs = canBuy(bp, "Obsidian", ore+oreR, clay+clayR, obs+obsR, oreR, clayR, obsR);
                //boolean buyGeo = canBuy(bp, "Geode", ore+oreR, clay+clayR, obs+obsR, oreR, clayR, obsR);

                return buyClay;
            }
            case "Ore" : {
                Robot robot = bp.getOre();
                boolean buyOre = ore >= robot.getOre() && maxOre*time > ore;
                //boolean buyClay = canBuy(bp, "Obsidian", ore+oreR, clay+clayR, obs+obsR, oreR, clayR, obsR);
                //boolean buyObs = canBuy(bp, "Obsidian", ore+oreR, clay+clayR, obs+obsR, oreR, clayR, obsR);
                //boolean buyGeo = canBuy(bp, "Geode", ore+oreR, clay+clayR, obs+obsR, oreR, clayR, obsR);

                return buyOre;
            }
        }
        return false;
    }

    public static void calculateNewResources(int ore, int clay, int obs, int geode) {

    }
}
