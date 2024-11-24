package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model;

import java.util.Random;

public class Identifier {
    private final String CHARACTERS ="abcdefghijklmnopqrstuvwxyz";
    private final int LENGTH = 6;

    public Identifier(){

    }

    public String generateIdentifier(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder(LENGTH);
        for(int i = 0; i < LENGTH; i++){
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();

    }
}
