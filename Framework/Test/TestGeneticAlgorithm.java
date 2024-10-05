package Framework.Test;

import Framework.PopulationComponents.*;

public class TestGeneticAlgorithm {

    public static void main(String[] args) {
        int LEFT_BOUND = -2;
        int RIGHT_BOUND = 2;
        int POPULATION_SIZE = 3;
        int CHROMOSOME_LENGTH = 3;

        Population population = new Population(POPULATION_SIZE, LEFT_BOUND, RIGHT_BOUND);

        population.generateInitialPopulation(CHROMOSOME_LENGTH);

        SphereEvaluatorStrategy sphereEvaluator = new SphereEvaluatorStrategy();

        for (int i = 0; i < population.getSize(); i++) {
            ChromosomeInterface chromosome = population.getChromosomeAt(i);
            chromosome.setFitness(sphereEvaluator.calculateChromosomeFitness(chromosome));
        }
        
        population.setFitness(sphereEvaluator.calculatePopulationFitness(population));
        
        System.out.println(population.toString());
        System.out.println(population.getFitness());
    }
}
