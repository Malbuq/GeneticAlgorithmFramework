public interface FitnessEvaluatorStrategy {
    public float calculatePopulationFitness();
    public float calculateChromosomeFitness();
    public float calculateGeneFitness();
}
