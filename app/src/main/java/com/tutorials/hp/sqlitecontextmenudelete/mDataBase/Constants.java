package com.tutorials.hp.sqlitecontextmenudelete.mDataBase;

/**
 * Created by Oclemmy on 5/1/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class Constants {
    //COLUMNS
    static final String ROW_ID="id";
    static final String NAME="name";

    //DB PROPS
    static final String DB_NAME="ff_DB";
    static final String TB_NAME="ff_TB";
    static final int DB_VERSION=1;

    //CREATE TB
    static final String CREATE_TB="CREATE TABLE ff_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL);";

    //TABLE DROP STMT
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
