# 피보나치수(Level2)

(A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C라는 성질을 이용

반복문 사용

```java
class Solution {
    static int[] fiboArr;
    public int solution(int n) {
        fiboArr = new int[n+1];
        fiboArr[0] = 0; fiboArr[1] = 1;
        for(int i = 2; i <= n; i++){
            fiboArr[i] = (fiboArr[(i-2)%1234567]+ fiboArr[(i-1)%1234567])%1234567;
        }
        return fiboArr[n];
    }
}
```

재귀로 풀기

```java
class Solution {
    static int[] fiboArr;
    public int solution(int n) {
        fiboArr = new int[n+1];
        fiboArr[1] = 1;
        fibo(n);
        return fiboArr[n];
    }
    
    private static int fibo(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else{
            if(fiboArr[n] == 0)
                fiboArr[n] = (fibo((n-2)%1234567) + fibo((n-1)%1234567))%1234567;
            
            return fiboArr[n];
        }
    }
}
```