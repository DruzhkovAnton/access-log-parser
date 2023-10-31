

public class Line {
    Pointe p1,p2;

    public Line(Pointe p1, Pointe p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(int x, int y, int x1, int y1) {
        this.p1 = new Pointe(x, y);
        this.p2 = new Pointe(x1, y1);
    }

    public String fromPointToPoint() {
        String res = "";
        res = "Линия от " + p1.toSring() + " до " + p2.toSring();
        return res;
    }

    public double lengthLine(){
        double res =  Math.sqrt(Math.pow(p2.x - p1.x,2) + Math.pow(p2.y - p1.y,2 )); //(x2 - x1)^2 + (y2 - y1)^2)
        return res;
    }

}
