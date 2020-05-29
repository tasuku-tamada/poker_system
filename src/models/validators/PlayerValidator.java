package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Player;
import utils.DBUtil;

public class PlayerValidator {
    public static List<String> validate(Player p) {
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(p.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(p.getPassword());
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors;
    }
    // 名前の必須入力チェック
    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "氏名を入力してください。";
        }
        //重複チェック
        EntityManager em = DBUtil.createEntityManager();
        Long count = em.createNamedQuery("nameDuplicateCheck",Long.class)
                .setParameter("name",name)
                .getSingleResult();
        em.close();
        if(0 < count){
            return "そのユーザ名は既に存在しています。";
        }
        //文字数チェック
        if(10 < name.length()){
            return "入力できるユーザ名は10文字までです。";
        }
        return "";
    }

    // パスワードの必須入力チェック
    private static String _validatePassword(String password) {
        // パスワードを変更する場合のみ実行
        if(password == null || password.equals("")) {
            return "パスワードを入力してください。";
        }
        return "";
    }
}
