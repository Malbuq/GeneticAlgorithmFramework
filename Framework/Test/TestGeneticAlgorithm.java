package Framework.Test;

import Framework.PopulationComponents.*;
import Framework.Strategies.*;

public class TestGeneticAlgorithm {

    public static void main(String[] args) {
        int LEFT_BOUND = -100;
        int RIGHT_BOUND = 100;
        int POPULATION_SIZE = 1000;
        int CHROMOSOME_LENGTH = 30;
        float CROSSOVER_PROBABILITY = 0.8f;
        float MUTATION_PROBABILITY = 0.01f;
        int GENERATIONS = 1000;

        FitnessEvaluatorStrategy sphereEvaluator = new SphereEvaluatorStrategy();
        MatingProbabilityCalculatorStrategy complementaryMatingProbability = new ComplementaryMatingProbabilityStrategy();
        SelectorStrategy fitnessProportionalSelector = new ProbabilityProportionalSelectorStrategy();
        ChromosomeCrossoverStrategy onePointCrossover = new OnePointCrossoverStrategy();
        MutatePopulationStrategy simpleMutation = new SimpleMutatatePopulationStrategy();

        Population population = new Population(POPULATION_SIZE, LEFT_BOUND, RIGHT_BOUND);

        for (int i = 0; i < POPULATION_SIZE; i++) {
            Chromosome chromosome = new Chromosome(CHROMOSOME_LENGTH);
            chromosome.populateChromosome(LEFT_BOUND, RIGHT_BOUND);
            population.setChromosomeAt(i, chromosome);
        }

        for (int i = 0; i < GENERATIONS; i++) {
            for (int j = 0; j < population.getSize(); j++) {
                ChromosomeInterface chromosome = population.getChromosomeAt(j);
                chromosome.setFitness(sphereEvaluator.calculateChromosomeFitness(chromosome));
            }
            population.setFitness(sphereEvaluator.calculatePopulationFitness(population));

            complementaryMatingProbability.calculatePopulationMatingProbability(population);

            population = (Population) fitnessProportionalSelector.selectNextGeneration(population);

            population = (Population) onePointCrossover.crossoverPopulation(population, CROSSOVER_PROBABILITY);

            simpleMutation.mutate(population, MUTATION_PROBABILITY);
        }
        System.out.println(population.getFitness());
    }
}
