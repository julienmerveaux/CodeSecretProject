package IntegrationPurseCodeSecret;

import monnaie.Purse;
import monnaie.TansactionRejeteeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import verrouillage.CodeSecret;

public class PurseIntegTest {
    private CodeSecret codeSecret;
    private Purse purse;
    private double solde;
    private double montant_debit;
    private String goodCode;
    private String badCode;

    @BeforeEach
    public void setUp() {
        codeSecret = new CodeSecret();
        goodCode = codeSecret.revelerCode();
        badCode = goodCode + "3";
        purse = new Purse(codeSecret);
        purse.credite(solde);
    }
    @Test
    public void testDebitCodeValide() throws TansactionRejeteeException {
        purse.debite(montant_debit, goodCode);
        Assertions.assertEquals(solde - montant_debit, purse.getSolde());
    }
}
