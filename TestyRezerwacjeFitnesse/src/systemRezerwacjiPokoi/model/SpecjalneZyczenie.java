package systemRezerwacjiPokoi.model;

import java.util.Arrays;

public class SpecjalneZyczenie {

	private String[] zyczenie = new String[2];

    public SpecjalneZyczenie() {
        
    }
    
    public SpecjalneZyczenie(String[] zyczenie) {
        this.zyczenie = zyczenie;
}

    public String[] getZyczenie() {
        return zyczenie;
    }

    public void setZyczenie(String[] zyczenie) {
        this.zyczenie = zyczenie;
    }

    @Override
    public String toString() {
        return "SpecjalneZyczenia{"+ Arrays.toString(zyczenie) + '}';
    }
    
    
}