package Framework;

public interface SelectorStrategy<T extends Number> {
    public PopulationInterface<T> selectNextGeneration();
}
