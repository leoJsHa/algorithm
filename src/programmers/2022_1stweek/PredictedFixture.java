package programmers;

//N명 참가
//1~N 순으로 배정
//1<->2 3<->4 5<->6 ..
//3번이 승리시, 다음판 2번 배정 <-- a / 2 의 반올림
//n : 참가자 수 , a : 참가자 번호 , b : 경쟁자 번호
//a와 b가 언제 만나는지?
//붙기 전 각자 전승
//n : 2^n (부전승 발생 X) => 결승 / 4강 / 8강 / 16강 / 32강 ... 양 사이드의 팀들은 무조건 2^n - 1
//a와 b가 각각 1과 2가 될 때 <-- 합이 3.
//목표 : 둘이 몇번째 라운드에 만나는가

public class PredictedFixture {
    public static void main(String[] args){
        System.out.println("solution1 : " + solution(64,9,13));
        System.out.println("solution2 : " + solution2(64,9,13));
    }
    public static int solution(int n, int a, int b){
        int answer = 0;
        while(true){

            a = a/2 + a%2;
            b = b/2 + b%2;
            answer ++;
            if(a==b)
                break;
        }
        return answer;
    }
    //올림을 쓴 이유 : 다음 라운드에서의 순번을 위해
    public static int solution2(int n, int a, int b){
        int answer = 0;
        int temp;
        if(a>b){
            temp = a;
            a = b;
            b = temp;
        }
        while (a != b){
            if(a<= n/2 && n/2 < b){
                a = (int)Math.ceil((a/2.0)*1);
                b = (int)Math.ceil((b/2.0)*1);
                answer++;
                n = n/2;
            }else {
                if((int)Math.ceil((a/2.0)*1) == (int)Math.ceil((b/2.0)*1)){
                    if(a==b)
                        break;
                    else{
                        answer++;
                        break;
                    }
                }
                else{
                    a = (int)Math.round((a/2.0)*1);
                    b = (int)Math.round((b/2.0)*1);
                    answer++;
                    n = n/2;
                }
            }
        }
        return answer;
    }
    public static double log(double x, double base){
        return Math.log(x) / Math.log(base);
    }

}
