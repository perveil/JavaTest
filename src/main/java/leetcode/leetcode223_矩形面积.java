package leetcode;

public class leetcode223_矩形面积 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=Math.abs(C-A)*Math.abs(D-B);
        int area2=Math.abs(G-E)*Math.abs(H-F);
        /*
         (A)-(C)
         (E)-(G)
        */
        int intera_width=0;
        if(Math.min(C,G)>Math.max(A,E)){ //判断有交集
            intera_width=A>E? (C<G?C-A:G-A ):(C>G?G-E:C-E);
        }
        int intera_height=0;
        /*
           B-D
           F-H
        */
        if(Math.min(D,H)>Math.max(B,F)){ //判断有交集
            intera_height=B>F?(D<H?D-B:H-B):(D>H?H-F:D-F);
        }
        return area1+area2-intera_height*intera_width;
    }

    public static void main(String[] args) {
        new leetcode223_矩形面积().computeArea(
                -2,-2,2,2,
                -1,-1,1,1

        );
    }
}
