package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.EmployeeView;
import constants.MessageConst;
import services.EmployeeService;
/**
 * 従業員インスタンスに設定されている値のバリデーションを行うクラス
 *
 */
public class EmployeeValidator {

    /**
     * 従業員インスタンスの各項目についてバリデーション
     * @param service 呼び出し元Serviceクラスのインスタンス
     * @param ev EmployeeViewのインスタンス
     * @param codeDuplicateCheckFlag 社員番号の重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @param passwordCheckFlag パスワードの入力チェックを実施するかどうか（実施:true 実施しない: false）
     * @return エラーのリスト
     */
    public static List<String> validate(
            EmployeeService service, EmployeeView ev, Boolean codeDuplicateCheckFlag, Boolean passwordCheckFlag){
        List<String>errors=new ArrayList<String>();

        //社員番号のチェック
        String codeError = validateCode(service,ev.getCode(),codeDuplicateCheckFlag);
        if(!codeError.equals("")) {
            errors.add(codeError);
        }

        //氏名のチェック
        String nameError = validateName(ev.getName());
        if(!nameError.equals("")) {
            errors.add(nameError);
        }

        //パスワードのチェック
        String passError = validatePassword(ev.getPassword(), passwordCheckFlag);
        if(!passError.equals("")) {
            errors.add(passError);
        }

        return errors;
    }

    /**
     * 社員番号の入力チェック、エラーメッセージを返却
     * @param service EmployeeServiceのインスタンス
     * @param code 社員番号
     * @param codeDuplicateCheckFlag 社員番号の重複チェックを実施するかどうか（実施 : true 実施しない : false）
     * @return エラーメッセージ
     */
    private static String validateCode(EmployeeService service, String code, Boolean codeDuplicateCheckFlag) {
        if(code == null || code.equals("")) {
            return MessageConst.E_NOEMP_CODE.getMessage();
        }

        if(codeDuplicateCheckFlag) {
            //重複チェック
            long employeesCount = isDuplicateEmployee(service, code);

            //同一社員番号がある場合はエラーメッセージを返却
            if(employeesCount>0) {
                return MessageConst.E_EMP_CODE_EXIST.getMessage();
            }
        }

        //エラーなしの場合空文字返却
        return "";
    }

    /**
     * @param service EmployeeServiceのインスタンス
     * @param code 社員番号
     * @return 従業員テーブルに登録されている同一社員番号のデータの件数
     */
    private static long isDuplicateEmployee(EmployeeService service, String code) {

        long employeesCount = service.countBycode(code);
        return employeesCount;
    }

    /**
     * 氏名に入力値があるかチェック、なければエラーメッセージを返却
     * @param name 氏名
     * @return エラーメッセージ
     */
    private static String validateName(String name) {
        if(name==null || name.equals("")) {
            return MessageConst.E_NONAME.getMessage();
        }
        //入力値がある場合
        return "";
    }

    /**
     * パスワードの入力チェック、なければエラーメッセージを返却
     * @param passwordCheckFlag パスワードの入力チェックを実施するか（実施 : true 実施しない : false）
     * @return エラーメッセージ
     */
    private static String validatePassword(String password, Boolean passwordCheckFlag) {

        //入力チェック実施、入力値がなければエラーメッセージ返却
        if(passwordCheckFlag && (password == null || password.equals(""))) {
            return MessageConst.E_NOPASSWORD.getMessage();
        }

        //エラーがない場合
        return "";
    }
}