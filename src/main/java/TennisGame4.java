import java.util.ArrayList;

public class TennisGame4 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String namesScore[] = new String[]{  "Love" ,"Fifteen", "Thirty","Forty"};


    public TennisGame4(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    @Override
    public String getScore() {
        String score="";
        switch (getDiferencia()){
            case 0:
                score =getTitleScoreEquals(m_score1,m_score2);
                break;
            case 1:
                if(Math.max(m_score1,m_score2)>3){
                    score = getTitleAdvantagePlayer(m_score1,m_score2);
                }else{
                    score = getTitleByScore(m_score1,m_score2);
                }
                break;
            case 2:
                if(Math.max(m_score1,m_score2)>3){
                    score = getTitleWinPlayer(m_score1,m_score2);
                }else{
                    score = getTitleByScore(m_score1,m_score2);
                }
                break;
            default:
                if(Math.max(m_score1,m_score2)<4){
                    score = getTitleByScore(m_score1,m_score2);
                }else{
                    score = getTitleWinPlayer(m_score1,m_score2);
                }
                break;
        }
        return score;
    }

    private String getTitleAdvantagePlayer(int m_score1, int m_score2) {
        String result ="Advantage ";
        if(m_score1>m_score2){
            result +="player1";

        }else{
            result +="player2";
        }

        return result;
    }

    public int getDiferencia(){
        int diferencia = m_score1 - m_score2;
        if(diferencia < 0){
            return (diferencia * - 1);
        }
        return diferencia;
    }


    public String getTitleScoreEquals(int pnt1,int pnt2){
        String titleEquals = "";
            switch (pnt1){
                case 0:
                    titleEquals+="Love-All";
                    break;
                case 1:
                    titleEquals+="Fifteen-All";
                    break;
                case 2:
                    titleEquals+="Thirty-All";
                    break;
                default:
                    titleEquals+="Deuce";
                    break;
            }

        return titleEquals;
    }


    public String getTitleWinPlayer (int pnt1,int pnt2){
        String result ="";
        if(pnt1>pnt2){
          result +="Win for player1";
          return result;
        }
        result +="Win for player2";
        return result;
    }


    public String getTitleByScore(int num,int num2){
        return namesScore[num] +"-" +namesScore[num2];
    }
}
