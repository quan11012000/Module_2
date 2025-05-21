package ss9_TDD.bai_tap.triangle_classifier;

public class TriangleClassifier {
    public static String resultTraingle(int edgeA,int edgeB, int edgeC){
        if(edgeA+edgeB>edgeC && edgeA+edgeC>edgeB && edgeC+edgeB>edgeA){
            if(edgeA==edgeB && edgeA==edgeC){
                return "tam giác đều";
            }else if(edgeA==edgeB || edgeA==edgeC || edgeB==edgeC){
                return "tam giác cân";
            }else return "tam giác thường";
        }else return "không phải là tam giác";
    }
}
