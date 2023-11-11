public class Pointe3D extends Pointe {
    int z;
    public Pointe3D(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }

    public String toString(){
        String res = "";
        res = "{" + x + "," + y + "," + z + "}";
        return res;
    }

}
