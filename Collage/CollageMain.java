import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Runs the methods in Picture Class and saves collage
 * 
 * vishal Chitnis
 * Fianl version
 */
public class CollageMain
{
    public static void main(String[] args)
    {
        Picture temp = new Picture("images/template.jpg");
        Picture zucc1 = new Picture("images/zucc.png");
        Picture zucc2 = new Picture("images/zucc.png");
        Picture zucc3 = new Picture("images/zucc.png");
        Picture zucc4= new Picture("images/zucc.png");
        Picture zucc5= new Picture("images/zucc.png");
        Picture zucc6= new Picture("images/zucc.png");
        Picture zucc7= new Picture("images/zucc.png");
        Picture zucc8= new Picture("images/zucc.png");
        Picture zucc9= new Picture("images/zucc.png");
        Picture zucc10= new Picture("images/zucc.png");
        zucc1.lizardIFY();
        temp.copyZucc(zucc1, 0, 0);
        zucc2.mirrorVertical();
        zucc2.mirrorHorizontal();
        temp.copyZucc(zucc2, 950, 0);
        zucc3.randomPlacement();
        temp.copyZucc(zucc3, 1900, 0);
        zucc4.recursivePasteRight(2);
        temp.copyZucc(zucc4, 0, 534);
        zucc5.blend("images/lizard.png");
        temp.copyZucc(zucc5, 950, 534);
        temp.copyZucc(zucc6, 1900, 534);
        zucc7.negativeZucc();
        temp.copyZucc(zucc7, 0, 1068);
        zucc9.all(zucc9);
        temp.copyZucc(zucc9, 950, 1068);
        zucc8.mirrorVerticalFull();
        zucc8.sheparFairey();
        zucc8.recursivePasteLeft(zucc8, 2);
        temp.copyZucc(zucc8, 1900, 1068);
        temp.explore();
        temp.write("images//FinalImage.jpg");
    }
}
