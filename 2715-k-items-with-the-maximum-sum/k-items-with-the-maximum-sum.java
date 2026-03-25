class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum=0;
        if(k<=numOnes) return k;
        if(k>numOnes && k<numOnes+numZeros){
            return numOnes;
        } 
        else return numOnes-(k-numOnes -numZeros);
    }
}