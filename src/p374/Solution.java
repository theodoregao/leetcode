package p374;
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

class GuessGame {
    public int guess(int num) {
        return 0;
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long lo = 1, hi = n;
        long mid;
        int thisGuess = 0;
        while (true) {
            mid = (lo + hi) >> 1;
            thisGuess = guess((int) mid);
            if (thisGuess == 0) break;
            else if (thisGuess > 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int) mid;
    }
}