package ss8_cleancode.bai_tap.refactoring;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return getEqualScore(player1Score);
        }
        if (player1Score >= 4 || player2Score >= 4) {
            return getAdvantageOrWinScore(player1Name, player2Name, player1Score, player2Score);
        }
        return getNormalScore(player1Score, player2Score);
    }
    private static String getEqualScore(int score) {
        switch (score) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            case 3: return "Forty-All";
            default: return "Deuce";
        }
    }
    private static String getAdvantageOrWinScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) return "Advantage " + player1Name;
        if (scoreDifference == -1) return "Advantage " + player2Name;
        if (scoreDifference >= 2) return "Win for " + player1Name;
        return "Win for " + player2Name;
    }
    private static String getScoreDescription(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }
    private static String getNormalScore(int player1Score, int player2Score) {
        return getScoreDescription(player1Score) + "-" + getScoreDescription(player2Score);
    }
}
