package algorithm;

import java.util.*;

public class Leet210 {
    public static void main(String[] args){
        int num = 2;
        int [][] pres = {{1,0},{0,1}};
        System.out.println(Arrays.toString(new Leet210().findOrder(2, pres)));
    }

    /**这个是我想的办法，但是没法解决的。注释掉。
     * **/
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        HashMap<Integer,Integer> index = new HashMap<>(numCourses);
//        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
//        int [] res = new int[numCourses];
//        int [][] valid =  new int[numCourses][numCourses];
//        for (int[] pres: prerequisites){
//            int course = pres[0];
//            int pre = pres[1];
//            valid[course][pre] = 1;
//            Set<Integer> set = map.getOrDefault(course,new HashSet<>());
//            set.add(pre);
//            map.put(course,set);
//        }
//        for(int i = 0; i <numCourses; i++){
//            for(int j =0; j<numCourses; j++){
//                if(valid[i][j] == 1 && valid[j][i] == 1){
//                    return new int[0];
//                }
//            }
//        }
//        for(int i = 0; i < numCourses; i++){
//            index.put(i,i);
//        }
//        for(int course: map.keySet()){
//            int courseIndex = index.get(course);
//            int preItem = -1, preIndex = -1;
//            int tempIndex;
//            for(int pre: map.get(course)){
//                if((tempIndex = index.get(pre)) > preIndex){
//                    preIndex = tempIndex;
//                    preItem  = pre;
//                }
//            }
//            if(courseIndex < preIndex){
//                index.put(course, preIndex);
//                index.put(preItem,courseIndex);
//            }
//        }
//        for(int course: index.keySet()){
//            res[index.get(course)] = course;
//        }
//        return res;
//    }

    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses){
        this.isPossible = true;
        color = new HashMap<>(numCourses);
        adjList = new HashMap<>(numCourses);
        topologicalOrder = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            color.put(i, WHITE);
        }
    }

    private void dfs(int node){
        if(!isPossible){
            return;
        }
        color.put(node, GRAY);
        for(int neighbour: adjList.getOrDefault(node,new ArrayList<>())){
            if(color.get(neighbour) == WHITE){
                dfs(neighbour);
            }
            else if(color.get(neighbour) == GRAY){
                this.isPossible = false;
            }
        }
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);

        /*
        * create adj list
        * */
        for(int i =0; i <prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src,lst);
        }

        for(int i= 0; i< numCourses; i++){
            if(color.get(i) == WHITE){
                dfs(i);
            }
        }

        int [] order;
        if(isPossible){
            order = new int[numCourses];
            for(int i =0 ;i< numCourses; i++){
                order[i] = topologicalOrder.get(numCourses-1 -i);
            }
        }
        else {
            order = new int[0];
        }
        return  order;
    }

    }
