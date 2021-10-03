
public class _5_prefix_Hashing {
	private long P = 31;
	private long M = (long)1e9+9;
	final private int N = (int)1e6;
	
	long[] fxp;
	long[] prefixHash;
	int []modInv;
	
    long fastExponentiation(long a, long b){
        long res = 1;
        while(b>0){
            if((b&1)==1){                     // comparing last bit of the no
                res = (res * a)%M;
            }
            b>>=1;
            a = (a*a)%M;
        }

        return res;
    }
	
	_5_prefix_Hashing(){
		fxp = new long[N];
		fxp[0]=1;
		for(int i=1;i<N;i++) {
			/*
				fxp[i] = P^i % M
                fxp[i-1] = P^(i-1) % M;
                fxp[i] = (P^(i-1) * P)%M = (P^(i-1) % M * P%M) % M (Using (a*b)%m)
                fxp[i] = (fxp[i-1] * P) % M; 
			*/
			fxp[i]=(fxp[i-1]*P)%M;
		}
		
        modInv = new int[N];
        
        /*
            modInv(a) modulo M,  a^(M-2)%M 
        */
        for(int i=0; i<N; i++){
            modInv[i] = (int)fastExponentiation(fxp[i], M-2);
        }
	}
	
    public void precompute(String s){
        prefixHash =  new long[s.length()];

        long hashval = 0;
        for(int i=0;i<s.length();i++){
            long ascii = (s.charAt(i) - 'a') + 1L;
            hashval = (hashval + (ascii * fxp[i])%M) % M;
            prefixHash[i] = hashval;
            
        }
    }
    
    public long getSubstringHash(int l, int r){
        //(a-b)%m = (a%m - b%m + m)%m
        long val = (prefixHash[r] - (l > 0 ? prefixHash[l-1] : 0) + M)%M;
        val = (val * modInv[l])%M;

        return val;
    }
}
