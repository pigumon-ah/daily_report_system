package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

public class ReportValidator {


/**
 *日報インスタンスに各項目についてバリデーション
 *@param rv 日報のインスタンス
 *@return エラーのリスト
 */
 public static List<String> validate(ReportView rv){
    List<String> errors = new ArrayList<String>();

    //タイトルチェック
    String titleError = validateTitle(rv.getTitle());
    if(!titleError.equals("")){
        errors.add(titleError);
    }
    //内容のチェック
    String contentError = validateContent(rv.getContent());
    if(!contentError.equals("")){
        errors.add(contentError);
    }
    return errors;
 }
 /**
 *タイトルに入力値があるかチェックし、入力値がなければエラーを返却
  *@param title タイトル
  *@return エラーメッセージ
  */
 public static String validateTitle(String title){
    if(title == null || title.equals("")){
        return MessageConst.E_NOTITLE.getMessage();
    }
    //入力値あり
    return "";
 }
 /**
  *内容に入力値があるかチェックし、入力値がなければエラーを返却
  *@param content タイトル
  *@return エラーメッセージ
  */
 public static String validateContent(String content){
    if(content == null || content.equals("")){
        return MessageConst.E_NOCONTENT.getMessage();
    }
    //入力値あり
    return "";
 }


}
