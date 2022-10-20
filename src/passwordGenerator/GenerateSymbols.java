package passwordGenerator;

public class GenerateSymbols {
    public String symbols(boolean userSet, int userType) {
        //returning values for each checkbox
        if (userSet == true) {
            switch (userType) {
                case (0):
                    return "ABCDEFGHIJKLMNOPRSTUVWXYZ";
                case (1):
                    return "abcdefghijklmnoprstuvwxyz";
                case (2):
                    return "0123456789";
                case (3):
                    return "!@#$%^&*(),.;:";
                case (4):
                    GetTodayDate g = new GetTodayDate();
                    return g.getTodayDate();
                default:
                    return null;
            }
        }

        else
            return null;
    }
}
