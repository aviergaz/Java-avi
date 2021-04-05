package Virus;

public interface IVirus {
    /**
     * @param person person_a
     * @param Person person_b
     * Calculates the distance between two people
     */
    static double calculate_distance(Person person_a, Person person_b){
        return Math.sqrt(Math.pow(person_a.getx()-person_b.getx()))+Math.pow(person_a.gety()-person_b.gety());

    }

    /**
     * @param Person person
     *calculates the probability that the person Will be infected with the disease.
     *
     *
     */
    public double contagionProbability(Person person);
    /**
     *
     * @param person person_a,person_b
     * If person_b is sick,so it means that person_a Infected him with the disease.
     */
    public boolean tryToContagion(Person person_a, Person person_b);

    /**
     *
     * @param person person
     * @return true if the person will be killed by the disease.
     */
    public boolean tryToKill(Person person);


    /**
     * @return info about contagions and death
     */
    public String toString();





}
