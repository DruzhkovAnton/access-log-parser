public class Fraction {
    private final int x;
    private final int y;

    public Fraction(int x, int y) {
        this.x = x;
        if(x < 0){
            this.y = -y;
        }else if (y <= 0) {
            throw new IllegalArgumentException("не корректный знаменатель");
        }else this.y = y;
    }

    public String toString() {
        return x + "/" + y;
    }

    public Fraction plus(Fraction other) {
        int newX = (this.x * other.y) + (other.x * this.y);
        int newY = this.y * other.y;
        return new Fraction(newX, newY);
    }

    public Fraction minus(Fraction other) {
        int newX = (this.x * other.y) - (other.x * this.y);
        int newY = this.y * other.y;
        return new Fraction(newX, newY);
    }

    public Fraction plus(int number) {
        int newX = this.x + (number * this.y);
        return new Fraction(newX, this.y);
    }

    public Fraction minus(int num) {
        int newX = this.x - (num * this.y);
        return new Fraction(newX, this.y);
    }

}
