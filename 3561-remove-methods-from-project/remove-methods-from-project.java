class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocation) {
        List<Integer>[] edges=new ArrayList[n];
        for(int i=0;i<n;i++) edges[i]=new ArrayList<>();

        int[] indgry = new int[n];
        for(int[] inv:invocation){
            edges[inv[0]].add(inv[1]);
            indgry[inv[1]]++;
        }

        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(k);
        boolean suspicious[] = new boolean[n];
        suspicious[k]=true;

        while(!queue.isEmpty()){
            int u=queue.poll();
            for(int v:edges[u]){
                indgry[v]--;
                if(!suspicious[v]){
                    suspicious[v]=true;
                   queue.offer(v);
                }
            }
        }

        List<Integer> remaining=new ArrayList<>();
        boolean removeall=true;
        for(int i=0;i<n;i++){
            if(suspicious[i] && indgry[i]>0){
                removeall=false;
                break;
            }else if(!suspicious[i]) remaining.add(i);
        }
        if(!removeall){
            remaining.clear();
            for(int i=0;i<n;i++) remaining.add(i);
        }
        return remaining;
    }
}