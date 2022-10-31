package services;

import javax.persistence.EntityManager;

import utils.DBUtil;
/**
 *DB接続関連の共通処理を行うクラス
 *
 */
public class ServiceBase {
    /**
     * EntityManagerインスタンス
     */
    protected EntityManager em=DBUtil.createEntityManager();

    /**
     * EntityManagerのclose
     */
    public void close() {
        if(em.isOpen()) {
            em.close();
        }
    }
}
