class Pointe {
    int x, y;

    public Pointe(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toSring() {
        String res = "";
        res = "{" + x + "," + y + "}";
        return res;
    }

    public static void poitEquals(Pointe p1, Pointe p2, Pointe p3) {
        System.out.println(" = " + ((p1.x == p2.x && p1.y == p2.y)&&(p2.x == p3.x && p2.y == p3.y)));
    }


}

