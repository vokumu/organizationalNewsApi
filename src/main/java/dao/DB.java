package dao;

import org.sql2o.Sql2o;

public class DB {
public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-236-137-173.compute-1.amazonaws.com:5432/d8ejj8qeoejrm4", "evbtpalcvjuyol", "d5e23f3bf74750895f442eea2b37d613a12cfde6f7820e29d38040042128b4a3");
//public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/organisational",  "denvar", "kenya@2020");
}
