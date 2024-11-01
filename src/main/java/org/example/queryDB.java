package org.example;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

import static org.example.Database.db;

public class queryDB {

    public boolean cekLogin(String userCode){
        String sql = "SELECT COUNT(*) FROM user_acc WHERE userCode = :userCode";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("userCode", userCode)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer uangUser(String userCode) {
        String sql = "SELECT userSaldo FROM user_acc WHERE userCode = :userCode";
        try (Connection con = db.open()) {
            Integer uang = con.createQuery(sql)
                    .addParameter("userCode", userCode)
                    .executeScalar(Integer.class);
            return uang; // Return Integer directly if not null
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null if there's an error
        }
    }

    public Integer noRekUser (String userCode){
        String sql = "SELECT noRek FROM user_acc WHERE userCode = :userCode";
        try (Connection con = db.open()){
            Integer noRek = con.createQuery(sql)
                    .addParameter("userCode", userCode)
                    .executeScalar(Integer.class);
            return noRek;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer uangNoRekTujuan(int noRek){
        String sql = "SELECT userSaldo FROM user_acc WHERE noRek = :noRek";
        try (Connection con = db.open()){
            Integer uangrekTujuan = con.createQuery(sql)
                    .addParameter("noRek", noRek)
                    .executeScalar(Integer.class);
            return uangrekTujuan;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void updateUangUser(int userSaldo, int noRek){
        String sql = "UPDATE user_acc SET userSaldo = :userSaldo WHERE noRek = :noRek";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("userSaldo", userSaldo)
                    .addParameter("noRek", noRek)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUangNoRekTujuan(int userSaldo, int noRek){
        String sql = "UPDATE user_acc SET userSaldo = :userSaldo WHERE noRek = :noRek";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("userSaldo", userSaldo)
                    .addParameter("noRek", noRek)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cekPin(String userPin, String userCode){
        String sql = "SELECT COUNT(*) FROM user_acc WHERE userPin = :userPin AND userCode = :userCode";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("userPin", userPin)
                    .addParameter("userCode", userCode)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cekRekTujuan(int noRek){
        String sql = "SELECT COUNT(*) FROM user_acc WHERE noRek = :noRek";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("noRek", noRek)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer getSaldo (int noRek) {
        String sql = "SELECT userSaldo FROM user_acc WHERE noRek = :noRek";
        try (Connection con = db.open()){
            Integer saldoUser = con.createQuery(sql)
                    .addParameter("noRek", noRek)
                    .executeScalar(Integer.class);
            return saldoUser;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void updateMutasiUser (int idM, int noRek, int saldoMutasi) {
        String sql = "INSERT INTO mutasi_rek VALUES ( :idM ,:noRek, NOW(), 'Pengeluaran', :saldoMutasi)";
        try (Connection con = db.open()) {
            con.setRollbackOnException(false);
            con.createQuery(sql)
                    .addParameter("idM", idM)
                    .addParameter("noRek", noRek)
                    .addParameter("saldoMutasi", saldoMutasi)
                    .executeUpdate();
        }  catch (Sql2oException ex) {
            ex.printStackTrace();
            try (Connection conn = db.open()) {
                conn.rollback(); // Roll back the transaction on error
            }
        }
    }

    public void updateMutasiMasuk (int idM, int noRek, int saldoMutasi) {
        String sql = "INSERT INTO mutasi_rek VALUES (:idM, :noRek, NOW(), 'Pemasukkan', :saldoMutasi)";
        try (Connection con = db.open()) {
            con.setRollbackOnException(false);
            con.createQuery(sql)
                    .addParameter("idM", idM)
                    .addParameter("noRek", noRek)
                    .addParameter("saldoMutasi", saldoMutasi)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            ex.printStackTrace();
            try (Connection con = db.open()) {
                con.rollback(); // Roll back the transaction on error
            }
        }
    }

    public List<Mutasi> MutasiRekening(int noRek) {
        String query = "SELECT tanggal, tipeMutasi, saldoMutasi FROM mutasi_rek WHERE noRek = :noRek";

        try (Connection con = db.open()) {
            return con.createQuery(query)
                    .addParameter("noRek", noRek)
                    .executeAndFetch(Mutasi.class);
        }
    }

    public static class Mutasi {
        public String tanggal;
        public String tipeMutasi;
        public String saldoMutasi;
    }

    public int getRowCount() {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM mutasi_Rek";
        try (Connection con = Database.db.open()) {
            rowCount = con.createQuery(sql)
                    .executeScalar(Integer.class);
        }
        return rowCount;
    }
}
