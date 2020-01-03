package algorithm;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;
import java.util.Comparator;

class ScoreLabelPoint  {
    double score;
    int label;

    public ScoreLabelPoint(int label, double score){
        this.label = label;
        this.score = score;
    }

}

public class AUCCalculator {

    public static void main(String [] args){

        int [] labels = new int[]{0,0,1,1};
        double [] scores = new double[]{0.1,0.4,0.35,0.8};
        System.out.println(calculateAUC(labels,scores));
    }

    public static double calculateAUC(int [] labels, double [] scores){
        if(labels == null || scores == null || labels.length != scores.length )
            return -1;

        int res  = 0;
        if(labels.length == 0)
            return res;

        ScoreLabelPoint [] tuples = new ScoreLabelPoint[labels.length];
        for (int i = 0; i < labels.length; i++){
            tuples[i] = new ScoreLabelPoint(labels[i], scores[i]);
        }
        Arrays.sort(tuples, new Comparator<ScoreLabelPoint>() {
            @Override
            public int compare(ScoreLabelPoint o1, ScoreLabelPoint o2) {
                return Double.compare(o1.score, o2.score);
            }
        });

        int posCnt = 0;
        for(int i = 0; i < tuples.length; i++) {
            //找到正样本
            if(tuples[i].label == 0) continue;
            res += i ;
            posCnt += 1;
        }

        double minusPart = posCnt > 0 ? posCnt*(posCnt-1)/2: 0;
        return (res - minusPart) / (posCnt * (labels.length - posCnt));
    }

}
