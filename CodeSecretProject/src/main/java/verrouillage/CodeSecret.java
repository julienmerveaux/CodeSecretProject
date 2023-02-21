package verrouillage;

import org.mockito.Mockito;

public class CodeSecret {
    private CodeSecret fakeCode;

    public CodeSecret() {
        fakeCode = Mockito.mock(CodeSecret.class);
        Mockito.when(fakeCode.revelerCode()).thenReturn("good");
        Mockito.when(fakeCode.verifierCode("good")).thenReturn(true);
    }
    public String revelerCode() {
        return fakeCode.revelerCode();
    }

    public boolean verifierCode(String code) {
        return fakeCode.verifierCode(code);
    }
}
