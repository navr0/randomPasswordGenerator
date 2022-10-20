package passwordGenerator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class GeneratePassword {
    public String GeneratePassword(JCheckBox[] userSettings, int passLength) {

        //checking settings (checkBoxes)
        boolean[] ifDetected = new boolean[5];
        for (int i = 0; i < userSettings.length; i++) {
            ifDetected[i] = userSettings[i].isSelected();
        }
        String toreturn = "", tempToReturn, finalPass="";
        int emptyPass = 0;
        GenerateSymbols genSymbols = new GenerateSymbols();

        for (int j = 0; j < ifDetected.length; j++) {
            if (ifDetected[j] == true) {
                toreturn = toreturn + genSymbols.symbols(ifDetected[j], j);
            }
            else
            {
                emptyPass++;
            }

            if(emptyPass == 5){
                return null;
            }
        }
        tempToReturn = toreturn;
        for(int i=0;i<passLength; i++){
            toreturn = toreturn + tempToReturn;
        }
        ArrayList<Character> passList = new ArrayList<Character>();
        for(Character c:toreturn.toCharArray()){
            passList.add(c);
        }
        //shuffling the password
        Collections.shuffle(passList);

        //generating password with right size (from JSpinner)
        for(int i=0;i<passLength;i++){
            finalPass = finalPass + passList.get(i);
        }

        if (emptyPass == 5) {
            return "Your password is empty!";
        } else {
            return finalPass;
        }
    }
}
