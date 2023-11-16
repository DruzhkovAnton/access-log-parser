package ru.courses.geometry;

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
        res = "\nЛиния от " + p1.toSring() + " до " + p2.toSring();
        return res;
    }

    public String toString() {
        String res = "";
        res = "\nЛиния от " + p1.toSring() + " до " + p2.toSring();
        return res;
    }



    public double lengthLine(){
        double res =  Math.sqrt(Math.pow(p2.x - p1.x,2) + Math.pow(p2.y - p1.y,2 )); //(x2 - x1)^2 + (y2 - y1)^2)
        return res;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return false;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Line line = (Line) obj;
        return this.p1.x == line.p1.x && this.p2.x == line.p2.x && this.p1.y == line.p1.y && this.p2.y == line.p2.y;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result*(this.p1.x+this.p2.x);
        result = 31*result*(this.p1.y+this.p2.y);
        return result;
    }

    @Override
    public Line clone(){
        try{
            return (Line) super.clone();
        } catch (CloneNotSupportedException e){
            throw new AssertionError(e);
        }
    }


}
