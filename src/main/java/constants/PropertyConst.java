package constants;
//アプリケーションスコープのパラメータの定義
public enum PropertyConst {
    PEPPER("pepper");

    private final String text;
    private PropertyConst(final String text) {
        this.text=text;
    }
    public String getValue() {
        return this.text;
    }
}
