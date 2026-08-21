class CountSquares {
    private Map<Integer,Map<Integer,Integer>> map;
    public CountSquares() {
        map=new HashMap<>();
    }
    
    public void add(int[] point) {
        int x=point[0]; int y=point[1];
        map.putIfAbsent(x,new HashMap<>());
        map.get(x).put(y,map.get(x).getOrDefault(y,0)+1);
    }
    private int countSquares(int x1,int y1,int x3,int y3,int y2,int freq){
        if(map.containsKey(x3)){
            Map<Integer,Integer> points=map.get(x3);
            return points.getOrDefault(y1,0)*points.getOrDefault(y2,0)*freq;
        }
        return 0;
    }
    public int count(int[] point) {
        int x1=point[0]; int y1=point[1];
        int count=0;
        if(!map.containsKey(x1)){
            return 0;
        }
        for(Map.Entry<Integer,Integer> entry: map.get(x1).entrySet()){
            int y2=entry.getKey();
            int freq=entry.getValue();
            if(y1==y2){
                continue;
            }
            int sub=Math.abs(y1-y2);
            count+=countSquares(x1,y1,x1-sub,y1,y2,freq);
            count+=countSquares(x1,y1,x1+sub,y1,y2,freq);
        }
        return count;
    }
}
