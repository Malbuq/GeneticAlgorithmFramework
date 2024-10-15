package Framework.Test;

import Framework.PopulationComponents.*;
import Framework.Strategies.*;
import Template.GeneticAlgorithm;
import Template.GeneticAlgorithmTemplate;

public class TestGeneticAlgorithm {

    public static void main(String[] args) {
        int LEFT_BOUND = -100;
        int RIGHT_BOUND = 100;
        int POPULATION_SIZE = 100;
        int CHROMOSOME_LENGTH = 30;
        float CROSSOVER_PROBABILITY = 0.8f;
        float MUTATION_PROBABILITY = 0.01f;
        int GENERATIONS = 1000;

        FitnessEvaluatorStrategy sphereEvaluator = new SphereEvaluatorStrategy();
        MatingProbabilityCalculatorStrategy complementaryMatingProbability = new ComplementaryMatingProbabilityStrategy();
        SelectorStrategy tournamentFitnessSelector = new TournamentSelectorStrategy();
        ChromosomeCrossoverStrategy onePointCrossover = new OnePointCrossoverStrategy();
        MutatePopulationStrategy simpleMutation = new SimpleMutatatePopulationStrategy();

        GeneticAlgorithmTemplate geneticAlgorithm = new GeneticAlgorithm(POPULATION_SIZE, CHROMOSOME_LENGTH, LEFT_BOUND,
                RIGHT_BOUND);

        geneticAlgorithm.run(GENERATIONS, sphereEvaluator, complementaryMatingProbability, tournamentFitnessSelector,
                onePointCrossover, CROSSOVER_PROBABILITY, simpleMutation, MUTATION_PROBABILITY);

    }
}
