package Virus;
import java.lang.*;
public class ChineseVariant implements IVirus {
    public double contagionProbability(Person person){
        switch (person.getage()) {
            case person.getage()<=18:return person.cotagionProbability()*0.2;
            case 18<=person.getage()<=55:return person.cotagionProbability()*0.5;
            default:return person.cotagionProbability()*0.7;
        }
    }
    public boolean tryToKill(Person person){
        double probability;
        switch (person.getage()) {
            case person.getage()<=18:probability=0.001;
            case 18<=person.getage()<=55:probability=0.05;
            default:probability=0.10;
        }
        long contagious_time=person.contagioustime();
        double kill_formula=Math.max(0,probability-0.01*probability*(Math.pow(contagious_time-15,2)));
        System.out.println("The peron will die by the disease at the probability of"+probability);
        return kill_formula>0;
    }
    public boolean tryToContagion(Person person_a,Person person_b){
        if (person_b instanceof Sick) {
            System.out.println("This person is already sick");
            return false;
        }
        double distance=IVirus.calculate_distance(person_a,person_b);
        double result = contagionProbability(person_b) * Math.min(1, 0.14 * Math.pow(Math.E, 2 - 0.25 * distance));
        System.out.println("the person will be infected by the other person at the  probability of" + result);
        return true;
    }

    /**
     * @return info about contagoiuns and death
     */
    public String toString(){
        String s1="The contagion and death probability is:20% and 0.1% for people until the age of 18 years old ";
        String s2="50% and 5% between the ages 18 to 55 ";
        String s3="and 70%  and 10% otherwise";
        return s1+s2+s3;
    }
}
