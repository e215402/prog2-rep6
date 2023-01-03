package jp.ac.uryukyu.ie.e215402;

import java.util.ArrayList;
import java.util.List;

public class Discs {
    private List<Disc> discs;

    public Discs() {
        discs = new ArrayList<>();
    }

    public void addDisc(Disc disc) {
        discs.add(disc);
    }

    public void removeDisc(Disc disc) {
        discs.remove(disc);
    }

    public List<Disc> getDiscs() {
        return discs;
    }
    
}
