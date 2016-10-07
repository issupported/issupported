package model;

public class Attribute {
    private String name;
    private boolean chromeSupport;
    private boolean ieSupport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getChromeSupport() {
        return chromeSupport;
    }

    public void setChromeSupport(boolean chromeSupport) {
        this.chromeSupport = chromeSupport;
    }

    public boolean getIeSupport() {
        return ieSupport;
    }

    public void setIeSupport(boolean ieSupport) {
        this.ieSupport = ieSupport;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", chromeSupport=" + chromeSupport +
                ", ieSupport=" + ieSupport +
                '}';
    }
}
