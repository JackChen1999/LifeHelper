package com.qz.lifehelper.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table POI.
 */
public class POIDao extends AbstractDao<POI, Long> {

    public static final String TABLENAME = "POI";

    /**
     * Properties of entity POI.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CreatedAt = new Property(1, java.util.Date.class, "createdAt", false, "CREATED_AT");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Detail = new Property(3, String.class, "detail", false, "DETAIL");
        public final static Property Tel = new Property(4, String.class, "tel", false, "TEL");
        public final static Property Add = new Property(5, String.class, "add", false, "ADD");
        public final static Property Category = new Property(6, String.class, "category", false, "CATEGORY");
        public final static Property City = new Property(7, String.class, "city", false, "CITY");
        public final static Property UserId = new Property(8, Long.class, "userId", false, "USER_ID");
        public final static Property ImageId = new Property(9, Long.class, "imageId", false, "IMAGE_ID");
    }

    ;

    private DaoSession daoSession;


    public POIDao(DaoConfig config) {
        super(config);
    }

    public POIDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'POI' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'CREATED_AT' INTEGER," + // 1: createdAt
                "'TITLE' TEXT," + // 2: title
                "'DETAIL' TEXT," + // 3: detail
                "'TEL' TEXT," + // 4: tel
                "'ADD' TEXT," + // 5: add
                "'CATEGORY' TEXT," + // 6: category
                "'CITY' TEXT," + // 7: city
                "'USER_ID' INTEGER," + // 8: userId
                "'IMAGE_ID' INTEGER);"); // 9: imageId
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'POI'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, POI entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        java.util.Date createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindLong(2, createdAt.getTime());
        }

        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }

        String detail = entity.getDetail();
        if (detail != null) {
            stmt.bindString(4, detail);
        }

        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(5, tel);
        }

        String add = entity.getAdd();
        if (add != null) {
            stmt.bindString(6, add);
        }

        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(7, category);
        }

        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(8, city);
        }

        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(9, userId);
        }

        Long imageId = entity.getImageId();
        if (imageId != null) {
            stmt.bindLong(10, imageId);
        }
    }

    @Override
    protected void attachEntity(POI entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public POI readEntity(Cursor cursor, int offset) {
        POI entity = new POI( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // createdAt
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // detail
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // tel
                cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // add
                cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // category
                cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // city
                cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8), // userId
                cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9) // imageId
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, POI entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCreatedAt(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDetail(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTel(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAdd(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCategory(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCity(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUserId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
        entity.setImageId(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(POI entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(POI entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getImageDao().getAllColumns());
            builder.append(" FROM POI T");
            builder.append(" LEFT JOIN USER T0 ON T.'USER_ID'=T0.'_id'");
            builder.append(" LEFT JOIN IMAGE T1 ON T.'IMAGE_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected POI loadCurrentDeep(Cursor cursor, boolean lock) {
        POI entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);
        offset += daoSession.getUserDao().getAllColumns().length;

        Image image = loadCurrentOther(daoSession.getImageDao(), cursor, offset);
        entity.setImage(image);

        return entity;
    }

    public POI loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();

        String[] keyArray = new String[]{key.toString()};
        Cursor cursor = db.rawQuery(sql, keyArray);

        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }

    /**
     * Reads all available rows from the given cursor and returns a list of new ImageTO objects.
     */
    public List<POI> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<POI> list = new ArrayList<POI>(count);

        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }

    protected List<POI> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }


    /**
     * A raw-style query where you can pass any WHERE clause and arguments.
     */
    public List<POI> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }

}