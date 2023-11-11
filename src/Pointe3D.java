public class Pointe3D extends Pointe {
    int x,y,z;
    public Pointe3D() {
        super();
    }

    public Pointe3D( int z){
        this.x = super.x;
        this.y = super.y;
        this.z = z;
    }

    public String toString(){
        String res = "";
        res = "{" + x + "," + y + "," + z + "}";
        return res;
    }

}
