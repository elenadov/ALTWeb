package paramsForRequests;

import io.qameta.allure.Step;
import mainParamsForRequest.MainParamsForRequest;

import java.util.Locale;

public class ZabavaRegBet extends MainParamsForRequest {

    @Step
    public String getLZTicketForSale(int ticketCount, int parochkaCount, String bTV){
        String ticketPart1 = "{\"tickets\":[{\"t\":";
        String ticketPart2 = ",\"f\":0,\"e\":[{\"c\":1,\"n\":";
        String ticketPart3 = "},{\"c\":2,\"n\":";
        String ticketPart4 = "}]}]}";
        String richAndPopular;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = "1";
        }
        else if (isStateUncheck) {
            richAndPopular = "0";
        }
        else{
            richAndPopular = "0";
        }
        return  ticketPart1 + ticketCount + ticketPart2 + parochkaCount
                + ticketPart3 + richAndPopular + ticketPart4;
    }

    @Step
    public String calculateOneBetSumHrn(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = 2;
        }
        else if (isStateUncheck) {
            richAndPopular = 0;
        }
        else{
            richAndPopular = 0;
        }
        int mainTicketSum = 20;
        int parochkaSum = (ticketCount * parochkaCount * 5) / ticketCount;
        float sumOfOneTicket = mainTicketSum + parochkaSum + richAndPopular;
        return String.format(Locale.ROOT,"%.2f", sumOfOneTicket);
    }

    @Step
    public String calculateLZCheckSumHrn(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular = 0;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = 2;
        }
        else if (isStateUncheck) {
            richAndPopular = 0;
        }
        int mainTicketSum = ticketCount * 20;
        int parochkaSum = ticketCount * parochkaCount * 5;
        float betSum = mainTicketSum + parochkaSum + (richAndPopular * ticketCount);
        return String.format(Locale.ROOT,"%.2f", betSum);
    }

    @Step
    public String calculateLZCheckSumMonets(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular = 0;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = 2;
        }
        else if (isStateUncheck) {
            richAndPopular = 0;
        }
        int mainTicketSum = ticketCount * 20;
        int parochkaSum = ticketCount * parochkaCount * 5;
        return String.valueOf(mainTicketSum + parochkaSum + (richAndPopular * ticketCount)) + "00";
    }
}
