package Framework.Test;

import javax.swing.WindowConstants;

import Framework.Strategies.*;
import Observer.Graphic;
import Template.GeneticAlgorithm;
import Template.GeneticAlgorithmTemplate;

public class TestGeneticAlgorithm {

    public static void main(String[] args) throws InterruptedException {
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
        Graphic graphic = new Graphic();
        graphic.setSize(800, 600);
        graphic.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        graphic.setVisible(true);


        geneticAlgorithm.registrarObserver(graphic);

        geneticAlgorithm.run(GENERATIONS, sphereEvaluator, complementaryMatingProbability, tournamentFitnessSelector,
                onePointCrossover, CROSSOVER_PROBABILITY, simpleMutation, MUTATION_PROBABILITY);

    }
}
