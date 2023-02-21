package monnaie;

import org.mockito.Mockito;
import verrouillage.CodeSecret;

public class Purse {
    private double solde;
    Purse fakePurse;
    CodeSecret codeSecret;

    public Purse(CodeSecret codeSecret) {
        this.codeSecret = codeSecret;
        fakePurse = Mockito.mock(Purse.class);
        Mockito.when(fakePurse.getSolde()).thenReturn(solde);
    }

    public void credite(double solde) {
        this.solde += solde;
    }

    public void debite(double montantDebit, String goodCode) throws TansactionRejeteeException {
        if(!codeSecret.verifierCode(goodCode)) throw new TansactionRejeteeException();
        this.solde -= montantDebit;
    }

    public double getSolde() {
        return solde;
    }
}
