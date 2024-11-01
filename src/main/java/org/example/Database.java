package org.example;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Database {
    public static Sql2o db;

    static {
        //Memanggil Database Dengan Koneksi JDBC
        db = new Sql2o("jdbc:mysql://localhost:3306/mBanking", "Li Wei", "Liwei2004");
    }
}
