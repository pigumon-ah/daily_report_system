package constants;
//各出力メッセージを定義
public enum MessageConst {

    //認証
    I_LOGINED("ログインしました"),
    E_LOGINED("ログインに失敗しました"),
    I_LOGOUT("ログアウトしました"),
    //ＤＢ更新
    I_REGISTERED("登録完了"),
    I_UPDATED("更新完了"),
    I_DELETED("削除完了"),
    //バリデーション
    E_NONAME("氏名が入力されていません"),
    E_NOPASSWORD("パスワードが入力されていません"),
    E_NOEMP_CODE("社員番号が入力されていません"),
    E_EMP_CODE_EXIST("入力された社員番号の情報はすでに存在しています"),
    E_NOTITLE("タイトルが入力されていません"),
    E_NOCONTENT("内容が入力されていません");


    private final String text;

    private MessageConst(final String text) {
        this.text=text;
    }
    public String getMessage() {
        return this.text;
    }
}
