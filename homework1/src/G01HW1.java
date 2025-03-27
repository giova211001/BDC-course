import org.apache.spark.rdd.RDD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Specifically, for the homework you must do the following tasks.
 *
 * 1) Write a method/function MRComputeStandardObjective that takes in input an RDD of (point,group) pairs (representing a set 𝑈=𝐴∪𝐵
 * ), and a set 𝐶
 *  of centroids, and returns the value of the objective function Δ(𝑈,𝐶)
 *  described above, thus ignoring the demopgraphic groups.
 *
 * 2) Write a method/function MRComputeFairObjective that takes in input an RDD of (point,group) pairs (representing points of a set 𝑈=𝐴∪𝐵
 * ), and a set 𝐶
 *  of centroids, and returns the value of the objective function Φ(𝐴,𝐵,𝐶)
 *  described above.
 *
 * 3) Write a method/function MRPrintStatistics that takes in input an RDD of (point,group) pairs (representing points of a set 𝑈=𝐴∪𝐵
 * ), and a set 𝐶
 *  of centroids, and computes and prints the triplets (𝑐𝑖,𝑁𝐴𝑖,𝑁𝐵𝑖)
 * , for 1≤𝑖≤𝐾=|𝐶|
 * , where 𝑐𝑖
 *  is the 𝑖
 * -th centroid in 𝐶
 * , and 𝑁𝐴𝑖,𝑁𝐵𝑖
 *  are the numbers of points of 𝐴
 *  and 𝐵
 * , respectively, in the cluster 𝑈𝑖
 *  centered in 𝑐𝑖
 * .
 *
 * 4) Write a program GxxHW1.java (for Java users) or GxxHW1.py (for Python users), where xx is your 2-digit group number (e.g., 04 or 25), which receives in input, as command-line arguments, a path to the file storing the input points, and 3 integers 𝐿,𝐾,𝑀
 * , and does the following:
 *
 * Prints the command-line arguments and stores  𝐿,𝐾,𝑀
 *  into suitable variables.
 * Reads the input points into an RDD of (point,group) pairs -called inputPoints-, subdivided into 𝐿
 *  partitions.
 * Prints the number 𝑁
 *  of points, the number 𝑁𝐴
 *  of points of group A, and the number 𝑁𝐵
 *  of points of group B (hence, 𝑁=𝑁𝐴+𝑁𝐵
 * ).
 * Computes a set 𝐶
 *  of 𝐾
 *  centroids by using the Spark implementation of the standard Lloyd's algorithm for the input points, disregarding the points' demographic groups, and using 𝑀
 *  as number of iterations.
 * Prints the values of the two objective functions Δ(𝑈,𝐶)
 *  and Φ(𝐴,𝐵,𝐶)
 * , computed by running  MRComputeStandardObjective and MRComputeFairObjective, respectively.
 * Runs MRPrintStatistics.
 */



public class G01HW1 {

    public static void main(String[] args) throws IOException {

        /*Check the number of CMD LINE PARAMETERS in order to satisfy the following requirement of the homework
         -> Prints the command-line arguments and stores  𝐿,𝐾,𝑀 into suitable variables.
         INPUTS:
         1) path to the file storing the input points
         2) L = number of partitions
         3) K = number of desired clusters
         4) M = number of iterations

         */

        if(args.length != 4){
            throw new IllegalArgumentException("USAGE: file_path num_partitions num_cluster num_iterations");
        }

        // Store and print the COMMAND LINE ARGUMENT
        String file_path = args[0];
        int L = Integer.parseInt(args[1]);
        int K = Integer.parseInt(args[2]);
        int M = Integer.parseInt(args[3]);

        System.out.println("File path: " + file_path + "\n" +
                "L (number of partitions): " + L + "\n" +
                "K (number of clusters): " + K + "\n" +
                "M (number of iterations): " + M + "\n");



    }
}
