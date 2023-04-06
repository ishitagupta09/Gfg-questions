

class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        Set<Integer> prev=new HashSet<>();
        Set<Integer> next=new HashSet<>();
        Map<Integer,Integer> m=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:A){
            
                next.add(i);
            
            m.put(i,m.getOrDefault(i,0)+1);
        }
        
        for(int i:A){
           if(next.contains(i) && m.get(i)==1) next.remove(i);
           int nextDis=next.size();
           if(m.get(i)==1) m.remove(i);
           else if(m.get(i)>1){
               m.put(i,m.get(i)-1);
            //   nextDis++;
           }
           int prevDis=prev.size();
           prev.add(i);
           arr.add(prevDis-nextDis);
        }
        return arr;
    }
}
        
