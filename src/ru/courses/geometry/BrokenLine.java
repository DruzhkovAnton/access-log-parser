package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;

public class BrokenLine implements Lineble{
    public List<Pointe> pLst = new ArrayList<>();
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

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return false;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        BrokenLine brokenLine = (BrokenLine) obj;
        if(this.pLst.size()!=brokenLine.pLst.size()){
            return false;
        }
        boolean res = false;
        for(int i=0; i<this.pLst.size(); i++) {
            res = this.pLst.get(i).x==brokenLine.pLst.get(i).x && this.pLst.get(i).y==brokenLine.pLst.get(i).y;
        }
        return res;

    }

    @Override
    public int hashCode(){
        int result = 17;
        int sump1 = 17;
        int sump2 = 17;
        for(int i=0; i<this.pLst.size(); i++) {
            sump1 = sump1 + pLst.get(i).x;
            sump2 = sump2 + pLst.get(i).y;
        }
        return result;
    }
}
