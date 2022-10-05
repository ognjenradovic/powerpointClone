package Controller;

import javax.swing.JOptionPane;

public class Error {
	ENumError type;
    String poruka;

    public Error(ENumError type, String poruka) {
        this.type = type;
        this.poruka = poruka;
        JOptionPane.showMessageDialog(null,poruka);
    }

    public ENumError getType() {
        return type;
    }

    public void setType(ENumError type) {
        this.type = type;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    @Override
    public String toString() {
        return poruka;
    }
}
