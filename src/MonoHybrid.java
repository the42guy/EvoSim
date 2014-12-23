import java.util.ArrayList;

/**
 * Created by Peter and Amol on 12/7/2014.
 */
public class MonoHybrid {
    private int f = 200;
    ArrayList<MonoCreature> bufferMC = new ArrayList<MonoCreature>();                                                    //A buffer for temporarily storing monocreatures
    ArrayList<ArrayList<MonoCreature>> alOfAl= new ArrayList<ArrayList<MonoCreature>>();                                //An arraylist of an arraylist of monocs
    MonoCreature[][] mc = new MonoCreature[f][];                                                                        //Creates a 2-d array which will contain all the mono-creatures in following format: [gen][offspring#]

    public MonoHybrid(int maxGenerationsToSee) {                                                                        //Most probable constructor, will take in max gen count
        this.f = maxGenerationsToSee;
    }

    protected MonoHybrid() {                                                                                            //another possible constructor.
                                                                                                                        //initialize maxGen later, or cut it out. Use a max safe limit
    }

    protected void fuseTwo(MonoCreature parent1, MonoCreature parent2) {                                                //Generates the four DNA outcomes from two parents
        String[] gamete = new String[4];
        MonoCreature[] offSpring = new MonoCreature[4];
        for(int i = 0; i < 4; i++) {
            if((i == 0)||(i == 1)) {
                gamete[i] = parent1.getGamete(i);
            } else if((i == 2)||(i == 3)) {
                gamete[i] = parent2.getGamete(i - 2);
            }
            System.out.println("Gamete " + i + " is " + gamete[i]);
        }
        /*offSpringString[0] = this.fuse(gamete[0], gamete[2]);
        offSpringString[1] = this.fuse(gamete[0], gamete[3]);
        offSpringString[2] = this.fuse(gamete[1], gamete[2]);
        offSpringString[3] = this.fuse(gamete[1], gamete[3]);*/
        for (int z = 0; z < 4; z++) {                                                                                   //Iterates over the offSpringString count
            for (int gameteFuseBothWith0 = 2; gameteFuseBothWith0 < 4; gameteFuseBothWith0++) {                         //Iterates over both genes of p2
                //offSpringString[z] = this.fuse(gamete[0], gamete[gameteFuse0]);                                               //Fuses [0] and the above two
                offSpring[z] = new MonoCreature(gamete[0], gamete[gameteFuseBothWith0]);                                //Creates two new MonoCreatures which are a result of gene1 of parent1 and gene1,2 of parent2
                z++;
            }
            for (int gameteFuseBothWith1 = 2; gameteFuseBothWith1 < 4; gameteFuseBothWith1++) {                         //Iterates over both genes of p2
                //offSpringString[z] = this.fuse(gamete[1], gamete[gameteFuseBothWith1]);                                               //This time for [1] and the two above
                offSpring[z] = new MonoCreature(gamete[1], gamete[gameteFuseBothWith1]);                                //Creates two new MonoCreatures which are a result of gene2 of p1 and g1,2 of p2
                z++;
            }
        }
        //4 off-springs from 2 parents created. Now send them to bufferMC arrayList.
        for(int childInt = 0; childInt < 4; childInt++) {
            System.out.println("Adding " + offSpring[childInt].geneMakeup());
            bufferMC.add(offSpring[childInt]);
            System.out.println(offSpring[childInt].geneMakeup() + " added\nTotal length of the buffer array-list: " + bufferMC.size() + "\n");
        }
        /* I don't think we need this. Good to separate the different gene combinations though. Can be used to determine gene combos later */
        /*for(int i = 0; i < 4; i++) {
            if (Character.isUpperCase(offSpringString[i].charAt(0)) && Character.isUpperCase(offSpringString[i].charAt(1))) {
                System.out.println(offSpringString[i]);
            }
        }
        for(int i = 0; i < 4; i++) {
            if (Character.isUpperCase(offSpringString[i].charAt(0)) && Character.isLowerCase(offSpringString[i].charAt(1))) {
                System.out.println(offSpringString[i]);
            }
        }
        for(int i = 0; i < 4; i++) {
            if (Character.isLowerCase(offSpringString[i].charAt(0)) && Character.isLowerCase(offSpringString[i].charAt(1))) {
                System.out.println(offSpringString[i]);
            }
        }*/
        /* Optimization End */
    }



    private void generator(int maxLevels) {
        for(int i = 1; i < f; i++) {                                                                                //Iterates in the generations count
            for(int o = 1; o <= i * 2; o++) {                                                                           //Iterates in the offspring count of current gen
                //adds mono-creatures to buffer array-list
                /*
                Possible prep-code:
                take first two parents
                create their four off-springs through fuseTwo method, which also adds them to buffer
                do the same for all other parents
                now add the buffer's content to the main ArrayList, in current gen. Possibly like:
                alOfAl.add(bufferMC);
                this will add bufferMC to current alOfAl index, ie this generation
                then the for loop iterates for next gen, does the same

                * */
                //@TODO
            }
        }
    }

    protected void nextGen() {
        f++;
    }
}
