import java.util.ArrayList;
import java.util.List;

public class BrokenLine implements Lineble{
    List<Pointe> pLst = new ArrayList<>();
    List<Line> lLst = new ArrayList<>();

    public BrokenLine(Pointe p){
        this.pLst.add(p);
    }

    public BrokenLine(List<Pointe> p) {
        this.pLst = p;
    }

    public BrokenLine() {
    }

    public String pointListToString(){
        String res = "";
        for(int i = 0; i<pLst.size(); i++)
        res = res + pLst.get(i).toSring();
        return res;
    }

    public List<Pointe> getPointLst() {
        return pLst;
    }

    public List<Line> getLineLst(){
        for(int i=0;i<pLst.size()-1;i++){
            lLst.add(new Line(pLst.get(i),pLst.get(i+1)));
        }
        return lLst;
    }

    public double length(){
        double res = 0;
        for(int i=0; i< lLst.size();i++){
            int x1 = lLst.get(i).p1.x;
            int x2 = lLst.get(i).p2.x;
            int y1 = lLst.get(i).p1.y;
            int y2 = lLst.get(i).p2.y;
            res = res+(Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2 )));
        }
        return res;
    }

    public String lineListToString(){
        String res = "";
        for(int i = 0; i<lLst.size(); i++){
            res = res + lLst.get(i).fromPointToPoint();
        }
        return res;
    }
}
