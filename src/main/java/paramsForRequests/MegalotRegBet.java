package paramsForRequests;

import io.qameta.allure.Step;
import mainParamsForRequest.MainParamsForRequest;

/**
 * Created by Elena Dovhaliuk
 */

public class MegalotRegBet extends MainParamsForRequest {

    public int simpleTicketSum = 10;

    @Step
    public String getMegalotTicketForSale(int ball1, int ball2, int ball3, int ball4
            , int ball5, int ball6, int megaBall){
        //[{"balls":[17,7,41,27,4,3],"megaballs":[0],"input_mode":3}]

        String ticketPart1 = "[{\"balls\":[";
        String ticketPart2 = ",";
        String ticketPart3 = "],\"megaballs\":[";
        String ticketPart4 = "],\"input_mode\":2}]";

        return  ticketPart1 + ball1 + ticketPart2 + ball2 + ticketPart2 + ball3
                + ticketPart2 + ball4 + ticketPart2 + ball5 + ticketPart2 + ball6
                + ticketPart3 + megaBall + ticketPart4;
    }

    @Step
    public String calculateMegalotCheckSumMonets(int drawCount){
        return String.valueOf(drawCount * simpleTicketSum) + "00";
    }

    @Step
    public String calculateMegalotCheckSumHrn(int drawCount){
        return String.valueOf(drawCount * simpleTicketSum) + ".00";
    }
}
