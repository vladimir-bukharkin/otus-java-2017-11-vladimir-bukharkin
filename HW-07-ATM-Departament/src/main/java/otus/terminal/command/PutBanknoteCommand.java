package otus.terminal.command;

import otus.atm.ATMType1;
import otus.atm.BanknoteDenomination;
import otus.terminal.ATMTerminal;

import java.io.IOException;
import java.util.Arrays;

public class PutBanknoteCommand implements ATMCommand {

    @Override
    public void execute(ATMTerminal terminal, ATMType1 atm) throws IOException {
        terminal.printlnToTerminal("Введите один из доступных номиналов банкнот: " +
                Arrays.toString(BanknoteDenomination.values()));

        String inDenomination = terminal.readLineFromTerminal();
        BanknoteDenomination banknoteDenomination = BanknoteDenomination.getBanknoteDenomination(inDenomination);
        if (banknoteDenomination == null) {
            terminal.printlnToTerminal("Error: incorrect banknote denomination");
        } else {
            atm.putBanknote(banknoteDenomination);
            terminal.printlnToTerminal("Ок... банконта была добавлена\n" +
                    "Total balance: " + atm.getTotalBalance() +
                    "\nTotal banknote Balance: " + atm.toString());
        }
    }
}
