package ru.courses.geometry;

public class Pointe implements Cloneable{
    public int x;
    public int y;

    public Pointe(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pointe() {

    }


    public String toSring() {
        String res = "";
        res = "{" + x + "," + y + "}";
        return res;
    }

    public static void poitEquals(Pointe p1, Pointe p2, Pointe p3) {
        System.out.println(" = " + ((p1.x == p2.x && p1.y == p2.y)&&(p2.x == p3.x && p2.y == p3.y)));
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return false;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Pointe point = (Pointe) obj;
        return this.x == point.x && this.y == point.y;
        }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result*this.x;
        result = 31*result*this.y;
        return result;
    }

    @Override
    public Pointe clone(){
        try{
            return (Pointe) super.clone();
        } catch (CloneNotSupportedException e){
            throw new AssertionError(e);
        }
    }


}

