package mazeDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JunctionFactory {

    Maze maze;

    public JunctionFactory() {


        Junction n1 = new Junction("n1", 10, 10, null, null, null, null);
        Junction n2 = new Junction("n2", 40, 10, null, null, n1, null);
        Junction n3 = new Junction("n3", 40, 30, n2, null, null, null);
        Junction n4 = new Junction("n4", 25, 30, null, n3, null, null);
        Junction n5 = new Junction("n5", 25, 40, n4, null, null, null);
        Junction n6 = new Junction("n6", 10, 40, n1, n5, null, null);
        Junction n7 = new Junction("n7", 10, 70, n6, null, null, null);
        Junction n8 = new Junction("n8", 40, 70, null, null, n7, null);
        Junction n9 = new Junction("n9", 40, 55, null, null, null, n8);
        Junction n10 = new Junction("n10", 25, 55, n5, n9, null, null);
        Junction n11 = new Junction("n11", 50, 55, null, null, n9, null);
        Junction n12 = new Junction("n12", 50, 70, n11, null, null, null);
        Junction n13 = new Junction("n13", 50, 40, null, null, n5, n11);
        Junction n14 = new Junction("n14", 50, 30, null, null, n3, n13);
        Junction n15 = new Junction("n15", 50, 10, null, null, null, n14);
        Junction n16 = new Junction("n16", 90, 10, null, null, n15, null);
        Junction n17 = new Junction("n17", 90, 30, n16, null, null, null);
        Junction n18 = new Junction("n18", 70, 30, null, n17, n14, null);
        Junction n19 = new Junction("n19", 70, 40, n18, null, null, null);
        Junction n20 = new Junction("n20", 80, 40, null, null, n19, null);
        Junction n21 = new Junction("n21", 60, 40, null, n19, null, null);
        Junction n22 = new Junction("n22", 90, 40, n17, null, null, null);
        Junction n23 = new Junction("n23", 90, 55, n22, null, n11, null);
        Junction n24 = new Junction("n24", 90, 70, n23, null, n12, null);
        Junction n25 = new Junction("n25", 100, 55, null, null, n23, null);
        Junction n26 = new Junction("n26", 115, 55, null, null, n25, null);
        Junction n27 = new Junction("n27", 100, 70, n25, null, null, null);
        Junction n28 = new Junction("n28", 130, 70, null, null, n27, null);
        Junction n29 = new Junction("n29", 130, 40, null, null, null, n28);
        Junction n30 = new Junction("n30", 115, 40, null, n29, n22, n26);
        Junction n31 = new Junction("n31", 115, 30, null, null, null, n30);
        Junction n32 = new Junction("n32", 100, 30, null, n31, n17, null);
        Junction n33 = new Junction("n33", 100, 10, null, null, null, n32);
        Junction n34 = new Junction("n34", 130, 10, null, null, n33, n29);
//        Junction n35 = new Junction("n35", 70, 70, null, n24, n12, null);
//        Junction n36 = new Junction("n36", 70, 55, null, n23, n11, null);
//        Junction n37 = new Junction("n37", 70, 10, null, n16, n15, null);


        HashMap<String, Junction> junctions = new HashMap<>();

        junctions.put(n1.getName(), n1);
        junctions.put(n2.getName(), n2);
        junctions.put(n3.getName(), n3);
        junctions.put(n4.getName(), n4);
        junctions.put(n5.getName(), n5);
        junctions.put(n6.getName(), n6);
        junctions.put(n7.getName(), n7);
        junctions.put(n8.getName(), n8);
        junctions.put(n9.getName(), n9);
        junctions.put(n10.getName(), n10);
        junctions.put(n11.getName(), n11);
        junctions.put(n12.getName(), n12);
        junctions.put(n13.getName(), n13);
        junctions.put(n14.getName(), n14);
        junctions.put(n15.getName(), n15);
        junctions.put(n16.getName(), n16);
        junctions.put(n17.getName(), n17);
        junctions.put(n18.getName(), n18);
        junctions.put(n19.getName(), n19);
        junctions.put(n20.getName(), n20);
        junctions.put(n21.getName(), n21);
        junctions.put(n22.getName(), n22);
        junctions.put(n23.getName(), n23);
        junctions.put(n24.getName(), n24);
        junctions.put(n25.getName(), n25);
        junctions.put(n26.getName(), n26);
        junctions.put(n27.getName(), n27);
        junctions.put(n28.getName(), n28);
        junctions.put(n29.getName(), n29);
        junctions.put(n30.getName(), n30);
        junctions.put(n31.getName(), n31);
        junctions.put(n32.getName(), n32);
        junctions.put(n33.getName(), n33);
        junctions.put(n34.getName(), n34);
//        junctions.put(n35.getName(), n35);
//        junctions.put(n36.getName(), n36);
//        junctions.put(n37.getName(), n37);

        maze = new Maze(junctions);
    }


    public Maze getMaze() {
        return maze;
    }
}
