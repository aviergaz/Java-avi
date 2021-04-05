package Virus;

import Virus.IVirus;

public class SouthAfricanVariant implements IVirus {
    public double contagionProbability(Person person){
        double probability;
        if(person.getage()<=18)
            {
                probability=0.6;
            }
        else{probability=0.5;}
        return person.cotagionProbability()*probability;
        }
    public boolean tryToKill(Person person){
       double probability;
       if(person.getage()<=18){probability=0.05;}
       else{probability=0.08;}
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
        double result=contagionProbability(person_b)*Math.min(1,0.14*Math.pow(Math.E,2-0.25*distance));
        System.out.println("the person will be infected at the probability of"+result);
        return true;
    }
    public String toString(){
        String s1="The contagion and death probability is:60% and 5% for people until the age of 18 years old ";
        String s2="and 50% and 8% otherwise";
        return s1+s2;
    }




}


