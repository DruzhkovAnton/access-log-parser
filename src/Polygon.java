import java.awt.*;
import java.util.List;

public class Polygon extends BrokenLine {
    public Polygon(){
        super();
    }
    @Override
    public List<Line> getLineLst() {
        super.getLineLst();
        Pointe p1 = pLst.get(0);
        Pointe p2 = pLst.get(pLst.size() - 1);
        lLst.add(new Line(p2, p1));
        return lLst;
    }


}
