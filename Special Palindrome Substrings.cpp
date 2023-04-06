class Solution{
    public:
    int specialPalindrome(string s1, string s2){
        int n = s1.size(),m = s2.size(),ans = INT_MAX;
        if(m > n){
            return -1;
        }
        else{
            for(int i = 0; i < n - m + 1; i++){
                string f = s1; int op = 0;
                for(int j = 0; j < m; j++){
                    if(f[i+j] != s2[j]){
                        f[i+j] = s2[j];
                        op++;
                    }
                }
                bool c = true;
                for(int j = 0; j < n / 2; j++){
                    if(j < i || n-j-1 > i+m-1){
                        if(f[j] != f[n-j-1]){
                            op++;
                        }
                    }
                    else{
                        if(f[j] != f[n-j-1]){
                            c = false;
                            break;
                        }
                    }
                }
                if(c){
                    ans = min(ans,op);
                }
            }
            return ans == INT_MAX ? -1 : ans;
        }
    }
};
