package fedosov.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Graph graph;

    public static void main(String[] args) {
        graph = new Graph();
        PathFinder pf = new PathFinder();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String pathToFile=sc1.nextLine();
        File file = new File(pathToFile);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                int id = sc.nextInt();
                int ids = sc.nextInt();
                graph.addRelation(id, ids);
            }
            sc.close();
            List<List<GraphNode>> result = new ArrayList<>();
            result=pf.find(graph);
            for (List<GraphNode> path:result){
                for(GraphNode node:path){
                    System.out.print(node.getId() + " ");
                }
                System.out.print(path.get(0).getId()+" ");
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл");
        }

    }
}


