package day_03;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 15/12/2015
 */
class House {
    
    private final Position pos;
    private int visits;

    House(Position pos) {
        this.pos = pos;
        this.visits = 1;
    }

    void visit(){
        visits++;
    }

    int getVisits() {
        return visits;
    }

    Position getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return "House{" + "pos=" + pos.toString() + ", visits=" + visits + '}';
    }
    
}
